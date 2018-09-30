package com.golovenkov.autoboxing;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.function.LongSupplier;

public class TestAutoboxingSpeedApplication {

    public static void main(String[] args) {
        System.out.println("This is an application for testing Effective Java examples");
        sumOfAllIntegersWithPrimitiveOnly();
        sumOfAllIntegersWithAutoboxing();
    }

    private static void sumOfAllIntegersWithPrimitiveOnly() {
        testSpeed(() -> {
            System.out.println("Sum of all integers with primitive only");

            long sum = 0L;
            for (long i = 0; i <= Integer.MAX_VALUE; i++) {
                sum = sum + i;
            }

            return sum;
        });
    }

    private static void sumOfAllIntegersWithAutoboxing() {
        testSpeed(() -> {
            System.out.println("Sum of all integers with autoboxing");

            Long sum = 0L;
            for (long i = 0; i <= Integer.MAX_VALUE; i++) {
                sum = sum + i;
            }

            return sum;
        });
    }

    private static void testSpeed(LongSupplier sumSupplier) {
        long start = System.nanoTime();
        long sum = sumSupplier.getAsLong();
        long elapsed = System.nanoTime() - start;

        printResult(sum, elapsed);
    }

    private static void printResult(long sum, long elapsed) {
        System.out.println("Sum is " + sum);
        System.out.println("Elapsed time is " + LocalTime.ofNanoOfDay(elapsed).get(ChronoField.MILLI_OF_DAY) + " ms");
    }
}
