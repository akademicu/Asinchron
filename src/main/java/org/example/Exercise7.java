package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise7 {

    public static void main(String[] args) {

        try(ExecutorService executor = Executors.newSingleThreadExecutor()) {

            for (int i = 0; i < 3; i++) {
                executor.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException ignore) {}
                    System.out.println("well hello everybody");
                });
            }
        }

    }
}
