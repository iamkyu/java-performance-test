package com.test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Created by kjnam on 2016. 7. 15..
 */
@State(Scope.Benchmark)
public class SplitBenchmark {

    public static void main(String[] args) throws Exception {

//        Basic Settings
//
//        # VM options: <none>
//        # Warmup: 5 iterations, 1 s each
//        # Measurement: 5 iterations, 1 s each
//        # Timeout: 10 min per iteration
//        # Threads: 1 thread, will synchronize iterations
//        # Benchmark mode: Throughput, ops/time
//        # Benchmark: org.sample.MyBenchmark.testMethod
//        ...
//        # Fork: 1 of 1

        Options opt = new OptionsBuilder()
                // Specify which benchmarks to run.
                // You can be more specific if you'd like to run only one benchmark per test.
                .include(StringBenchmark.class.getSimpleName())
                // Set the following options as needed
                .mode (Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(5)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(5)
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                //.jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintInlining")
                //.addProfiler(WinPerfAsmProfiler.class)
                .build();

        new Runner(opt).run();
    }


    @Benchmark
    public void splitTest() {
        String text = "APPLE|CARROT|PIZZA";
        String [] array = text.split("|");
    }

    @Benchmark
    public void toknizerTest() {
        String text = "APPLE|CARROT|PIZZA";
        StringTokenizer st = new StringTokenizer(text, "|");
        String [] array = new String[3];
        int i = 0;

        while (st.hasMoreTokens()) {
            array[i] = st.nextToken();
            i++;
        }
    }
}

