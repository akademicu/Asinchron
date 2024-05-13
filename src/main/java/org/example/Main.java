package org.example;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        CompletableFuture<Void> delay = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    CompletableFuture<String> greet = CompletableFuture.supplyAsync(() -> "Hello there");

        delay.thenCompose(v -> greet).thenAccept(System.out::println);

        for (int i = 0; i < 200; i++) {
//            if (i % 2 == 0) {
                System.out.println(i);

        }

    }
}