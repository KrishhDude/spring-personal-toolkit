package com.personal.toolkit.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dummy {

    public static void main(String[] args) {

        String s = "hello";
        String string = s.chars().mapToObj(c -> (char) c)
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .reverse().toString();
        System.out.printf(string);


        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if(entry.getValue() == 1) {
                System.out.printf(entry.getKey().toString());
            }
        }

        Map.Entry<Character, Long> characterLongEntry = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c, LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst().orElse(null);
        System.out.println(characterLongEntry);

        int[] arr = {1,2,3,4,5};
        int sum = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println("Sum using lambda: " + sum);


        ArrayList<Integer> x = new ArrayList<>(List.of(1, 2, 3));

        System.out.printf("\n\n");
        IntStream.of(1,1,3,3,7,6,7)
                .distinct()
                .parallel()
                .map(i-> i*2)
                .sequential()
                .forEach(System.out::println);

        try {
            Optional.of(24)
                    .filter(v -> v % 4 == 0)
                    .map(v -> {
                        System.out.println(v);
                        return v / 2;
                    })
                    .filter(t -> t != 0)
                    .map(t -> {
                        System.out.println(t);
                        return t;
                    })
                    .orElseThrow(() -> new Exception("data error"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
