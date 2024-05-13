package org.example;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class Exercise4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Random r = new Random();
        int firstAmountOfSeconds = r.nextInt(10);
        int secondAmountOfSeconds = r.nextInt(10);

        CompletableFuture<String> provideHello = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(firstAmountOfSeconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello...";
        });

        CompletableFuture<String> provideWorld = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(secondAmountOfSeconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "...World!";
        });

        System.out.println(provideHello
                .thenCombine(provideWorld, (s1, s2) -> s1+s2)
                .orTimeout(5000, TimeUnit.MILLISECONDS)
                .exceptionally(e -> "exception occurred")
                .get());

    }
}
