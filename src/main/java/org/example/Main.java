package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*CompletableFuture<Void> delay = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> greet = CompletableFuture.supplyAsync(() -> "Hello there");
        delay.thenCompose(v -> greet).thenAccept(System.out::println);
        for (int i = 0; i < 200; i++) {
             System.out.println(i);
        }*/
        System.out.println("hi");
        hell3SecWorld5Sec();
       // Thread.sleep(501);
    }

    static void hell3SecWorld5Sec() throws ExecutionException, InterruptedException {
        CompletableFuture<String> helloFun = CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });

        CompletableFuture<String> worldFun = CompletableFuture.supplyAsync(()->{try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
            return "World";
        });

        System.out.println(helloFun.thenCombine(worldFun,(m,w)->m+w).get());
    }
}