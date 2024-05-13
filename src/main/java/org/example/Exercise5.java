package org.example;

import jdk.jshell.SourceCodeAnalysis;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class Exercise5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String data = "85671 34262 92143 50984 24515 68356 77247 12348 56789 98760";
//        String data = "85671 34262";
        String[] individualNumbers = data.split(" ");
        List<BigInteger> bigIntList = new ArrayList<>();

        for (int i = 0; i < individualNumbers.length; i++) {
            bigIntList.add( new BigInteger(individualNumbers[i]));
        }

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
