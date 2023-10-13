

### Add Hibernate AOT hints

Trying to add Hibernate hints:

```java

@SpringBootApplication
@ImportRuntimeHints(DemoApplication.HibernateRegistrar.class)
public class DemoApplication {
    
    // ...

    static class HibernateRegistrar implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(final RuntimeHints hints, final ClassLoader classLoader) {
            hints.proxies().registerJdkProxy(org.hibernate.query.hql.spi.SqmQueryImplementor.class,
                    org.hibernate.query.sqm.internal.SqmInterpretationsKey.class,
                    org.hibernate.query.spi.DomainQueryExecutionContext.class,
                    org.hibernate.query.SelectionQuery.class,
                    org.hibernate.query.CommonQueryContract.class);
        }
    }

}
```

Fails with:

```
$>mvn clean -Pnative native:compile
...
[INFO] --- spring-boot-maven-plugin:3.1.3:process-aot (process-aot) @ gh4447 ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.3)

2023-10-13T10:17:09.044+02:00  INFO 32394 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 17.0.5 with PID 32394 (/Users/mbenhassine/Downloads/gh4447/target/classes started by mbenhassine in /Users/mbenhassine/Downloads/gh4447)
2023-10-13T10:17:09.047+02:00  INFO 32394 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
2023-10-13T10:17:09.408+02:00  INFO 32394 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2023-10-13T10:17:09.447+02:00  INFO 32394 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 33 ms. Found 2 JPA repository interfaces.
Exception in thread "main" java.lang.IllegalArgumentException: The following must be non-sealed interfaces: [org.hibernate.query.sqm.internal.SqmInterpretationsKey]
	at org.springframework.aot.hint.JdkProxyHint$Builder.toTypeReferences(JdkProxyHint.java:159)
	at org.springframework.aot.hint.JdkProxyHint$Builder.proxiedInterfaces(JdkProxyHint.java:129)
	at org.springframework.aot.hint.ProxyHints.lambda$registerJdkProxy$1(ProxyHints.java:78)
	at org.springframework.aot.hint.ProxyHints.registerJdkProxy(ProxyHints.java:50)
	at org.springframework.aot.hint.ProxyHints.registerJdkProxy(ProxyHints.java:77)
	at com.example.demo.DemoApplication$HibernateRegistrar.registerHints(DemoApplication.java:23)
	at org.springframework.context.aot.RuntimeHintsBeanFactoryInitializationAotProcessor$RuntimeHintsRegistrarContribution.lambda$applyTo$0(RuntimeHintsBeanFactoryInitializationAotProcessor.java:116)
	at java.base/java.util.LinkedHashMap$LinkedValues.forEach(LinkedHashMap.java:647)
	at org.springframework.context.aot.RuntimeHintsBeanFactoryInitializationAotProcessor$RuntimeHintsRegistrarContribution.applyTo(RuntimeHintsBeanFactoryInitializationAotProcessor.java:110)
	at org.springframework.context.aot.BeanFactoryInitializationAotContributions.applyTo(BeanFactoryInitializationAotContributions.java:78)
	at org.springframework.context.aot.ApplicationContextAotGenerator.lambda$processAheadOfTime$0(ApplicationContextAotGenerator.java:58)
	at org.springframework.context.aot.ApplicationContextAotGenerator.withCglibClassHandler(ApplicationContextAotGenerator.java:67)
	at org.springframework.context.aot.ApplicationContextAotGenerator.processAheadOfTime(ApplicationContextAotGenerator.java:53)
	at org.springframework.context.aot.ContextAotProcessor.performAotProcessing(ContextAotProcessor.java:106)
	at org.springframework.context.aot.ContextAotProcessor.doProcess(ContextAotProcessor.java:84)
	at org.springframework.context.aot.ContextAotProcessor.doProcess(ContextAotProcessor.java:49)
	at org.springframework.context.aot.AbstractAotProcessor.process(AbstractAotProcessor.java:82)
	at org.springframework.boot.SpringApplicationAotProcessor.main(SpringApplicationAotProcessor.java:80)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.530 s
[INFO] Finished at: 2023-10-13T10:17:10+02:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:3.1.3:process-aot (process-aot) on project gh4447: Process terminated with exit code: 1 -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```