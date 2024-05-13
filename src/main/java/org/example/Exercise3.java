package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercise3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> provideHello = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello...";
        });

        CompletableFuture<String> provideWorld = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "...World!";
        });

        System.out.println(provideHello.thenCombine(provideWorld, (s1, s2) -> s1 + s2).get());

    }
}
