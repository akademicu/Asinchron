package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exercise6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String story = "Mary had a little lamb, its fleece was white as snow.";
        String[] storyParts = story.split(" ");
        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";

        String[] individualNumbers = data.split(" ");
        List<BigInteger> bigIntList = new ArrayList<>();

        for (int i = 0; i < individualNumbers.length; i++) {
            bigIntList.add( new BigInteger(individualNumbers[i]));
        }

        CompletableFuture<Void> storyPrinter = CompletableFuture.runAsync(() -> {
            int counter = 0;
            while (counter < 1000000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(storyParts[counter % storyParts.length]);
                counter++;
            }
        });

        for (BigInteger bi : bigIntList) {
            CompletableFuture.supplyAsync(() -> {
                return calculateFactorial(bi);
            }).thenAccept(System.out::println).get();
        }

    }

    private static BigInteger calculateFactorial(BigInteger num) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
}
