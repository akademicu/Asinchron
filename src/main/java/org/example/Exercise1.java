package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercise1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> delayHello = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello there");
        });

        delayHello.get();

    }

}
