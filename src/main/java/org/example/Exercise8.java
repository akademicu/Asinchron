package org.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise8 {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 6, 7, 8, 9);

        try(ExecutorService executors = Executors.newFixedThreadPool(5)) {

            for (int i = 0; i < numbers.size(); i++) {
                int finalI = i;
                System.out.println("Started: " + finalI);
                executors.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException ignore) {}
                    System.out.println(calculateFactorial(numbers.get(finalI)));
                });
            }
            System.out.println("Looped them all");

        } catch (Exception ignore){}

    }

    private static int calculateFactorial(int n) {
        if ( n < 2) return 1;
        return n * calculateFactorial(n - 1);
    }
}
