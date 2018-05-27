package com.benjamin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.LongStream;

/**
 * Multiples of 3 and 5
 * <p>
 * https://projecteuler.net/problem=1
 */
public class Problem1 {

    private static final Logger logger = LoggerFactory.getLogger(Problem1.class);

    private Problem1 problem1;

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();

        problem1.outputResult(problem1.compute1());
        problem1.outputResult(problem1.compute2());
    }

    private void outputResult(long computationAnswer) {
        final long startTime = System.currentTimeMillis();
        logger.info("The answer is {}.", computationAnswer);
        final long endTime = System.currentTimeMillis();
        logger.info("Total time of computation: {} ms.", endTime - startTime);
    }

    /**
     * Typical imperative style.
     */
    private long compute1() {
        long solution = 0;

        for (long i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                solution += i;
            }
        }

        return solution;
    }

    /**
     * Functional style.
     */
    private long compute2() {
        return LongStream.range(0, 1000)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum();
    }
}
