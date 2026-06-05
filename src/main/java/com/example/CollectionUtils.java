package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {

    public <T> List<T> removeDuplicates(List<T> input) {
        if (input == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(new LinkedHashSet<>(input));
    }

    public List<Integer> filterEven(List<Integer> input) {
        if (input == null) {
            return Collections.emptyList();
        }
        return input.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> filterOdd(List<Integer> input) {
        if (input == null) {
            return Collections.emptyList();
        }
        return input.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }

    public <T> List<T> flatten(List<List<T>> input) {
        if (input == null) {
            return Collections.emptyList();
        }
        return input.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public <T> Map<T, Long> frequency(List<T> input) {
        if (input == null) {
            return Collections.emptyMap();
        }
        return input.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    public <T> List<List<T>> partition(List<T> input, int size) {
        if (input == null || size <= 0) {
            return Collections.emptyList();
        }
        List<List<T>> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i += size) {
            result.add(input.subList(i, Math.min(i + size, input.size())));
        }
        return result;
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        if (list1 == null || list2 == null) {
            return Collections.emptyList();
        }
        Set<T> set = new HashSet<>(list2);
        return list1.stream().filter(set::contains).collect(Collectors.toList());
    }

    public <T> List<T> difference(List<T> list1, List<T> list2) {
        if (list1 == null) {
            return Collections.emptyList();
        }
        if (list2 == null) {
            return new ArrayList<>(list1);
        }
        Set<T> set = new HashSet<>(list2);
        return list1.stream().filter(e -> !set.contains(e)).collect(Collectors.toList());
    }
}
