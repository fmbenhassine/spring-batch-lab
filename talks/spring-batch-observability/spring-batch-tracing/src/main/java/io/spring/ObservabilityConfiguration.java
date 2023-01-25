package io.spring;

import brave.Tracing;
import brave.baggage.BaggageField;
import brave.baggage.BaggagePropagation;
import brave.baggage.BaggagePropagationConfig;
import brave.handler.SpanHandler;
import brave.propagation.B3Propagation;
import brave.propagation.StrictCurrentTraceContext;
import brave.sampler.Sampler;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.CurrentTraceContext;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.brave.bridge.BraveBaggageManager;
import io.micrometer.tracing.brave.bridge.BraveCurrentTraceContext;
import io.micrometer.tracing.brave.bridge.BraveTracer;
import io.micrometer.tracing.handler.DefaultTracingObservationHandler;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.brave.ZipkinSpanHandler;
import zipkin2.reporter.urlconnection.URLConnectionSender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class ObservabilityConfiguration {

    @Value("${zipkin.url}")
    private String zipkinUrl;

    @Bean
    public ObservationRegistry observationRegistry() {
        // From https://micrometer.io/docs/tracing#_micrometer_tracing_brave_setup
        SpanHandler spanHandler = ZipkinSpanHandler
                .create(AsyncReporter.create(URLConnectionSender.create(this.zipkinUrl)));
        StrictCurrentTraceContext braveCurrentTraceContext = StrictCurrentTraceContext.create();
        CurrentTraceContext bridgeContext = new BraveCurrentTraceContext(braveCurrentTraceContext);
        brave.Tracer braveTracer;
        try (Tracing tracing = Tracing.newBuilder().currentTraceContext(braveCurrentTraceContext)
                .supportsJoin(false)
                .traceId128Bit(true)
                .propagationFactory(BaggagePropagation.newFactoryBuilder(B3Propagation.FACTORY)
                        .add(BaggagePropagationConfig.SingleBaggageField
                                .remote(BaggageField.create("from_span_in_scope 1")))
                        .add(BaggagePropagationConfig.SingleBaggageField
                                .remote(BaggageField.create("from_span_in_scope 2")))
                        .add(BaggagePropagationConfig.SingleBaggageField.remote(BaggageField.create("from_span")))
                        .build())
                .sampler(Sampler.ALWAYS_SAMPLE)
                .addSpanHandler(spanHandler).build()) {
            braveTracer = tracing.tracer();
        }
        Tracer tracer = new BraveTracer(braveTracer, bridgeContext, new BraveBaggageManager());
        ObservationRegistry registry = ObservationRegistry.create();
        registry.observationConfig()
                .observationHandler(new DefaultTracingObservationHandler(tracer));

        return registry;
    }
}
