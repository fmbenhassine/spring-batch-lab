/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.springframework.batch.performance.benchmarks;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
public class BeanWrapperFieldSetMapperBenchmark {

	private static final String LINE = "nameNumber1, nameNumber2, nameNumber3, nameNumber4, nameNumber5, nameNumber6, nameNumber7, nameNumber8, nameNumber9, nameNumber10, nameNumber11, nameNumber12, nameNumber13, nameNumber14, nameNumber15, nameNumber16, nameNumber17, nameNumber18, nameNumber19, nameNumber20, nameNumber21, nameNumber22, nameNumber23, nameNumber24, nameNumber25, nameNumber26, nameNumber27, nameNumber28, nameNumber29, nameNumber30, nameNumber31, nameNumber32, nameNumber33, nameNumber34, nameNumber35, nameNumber36, nameNumber37, nameNumber38, nameNumber39, nameNumber40";

	@State(Scope.Thread)
	public static class ThreadState {
		volatile BeanWrapperFieldSetMapper<Person> beanWrapperFieldSetMapper;
		volatile FieldSet fieldSet;

		@Setup(Level.Trial)
		public void doSetup() {
			beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
			beanWrapperFieldSetMapper.setTargetType(Person.class);
			beanWrapperFieldSetMapper.setDistanceLimit(0);

			DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
			lineTokenizer.setNames("nameNumber1", "nameNumber2", "nameNumber3", "nameNumber4", "nameNumber5", "nameNumber6", "nameNumber7", "nameNumber8", "nameNumber9", "nameNumber10", "nameNumber11", "nameNumber12", "nameNumber13", "nameNumber14", "nameNumber15", "nameNumber16", "nameNumber17", "nameNumber18", "nameNumber19", "nameNumber20", "nameNumber21", "nameNumber22", "nameNumber23", "nameNumber24", "nameNumber25", "nameNumber26", "nameNumber27", "nameNumber28", "nameNumber29", "nameNumber30", "nameNumber31", "nameNumber32", "nameNumber33", "nameNumber34", "nameNumber35", "nameNumber36", "nameNumber37", "nameNumber38", "nameNumber39", "nameNumber40");
			fieldSet = lineTokenizer.tokenize(LINE);
		}
	}

	@Benchmark
	public void performanceTestOfBeanWrapperFieldSetMapperWithoutFuzzyMatching(final ThreadState threadState, final Blackhole blackhole) throws BindException {
		blackhole.consume(threadState.beanWrapperFieldSetMapper.mapFieldSet(threadState.fieldSet));
	}


}
