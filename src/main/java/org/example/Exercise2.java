package org.example;

import jdk.jshell.SourceCodeAnalysis;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercise2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> printHello = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello...");
        });

        CompletableFuture<Void> printWorld = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" ... World!");
        });

        printHello.get();
        printWorld.get();

    }
}
