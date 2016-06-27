package com.test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

/**
 * Created by kjnam on 2016. 6. 27..
 */
public class StringBenchmark {

    @Benchmark @BenchmarkMode(Mode.Throughput)
    public String testEmptyBuffer() {
        StringBuffer buffer = new StringBuffer();
        return buffer.toString();
    }

    @Benchmark @BenchmarkMode(Mode.Throughput)
    public String testEmptyBuilder() {
        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }

    @Benchmark @BenchmarkMode(Mode.Throughput)
    public String testEmptyLiteral() {
        return "";
    }
}
