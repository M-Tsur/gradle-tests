package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {

    private CollectionUtils collectionUtils;

    @BeforeEach
    void setUp() {
        collectionUtils = new CollectionUtils();
    }

    @Test
    void removeDuplicatesNormal() {
        assertEquals(List.of(1, 2, 3), collectionUtils.removeDuplicates(Arrays.asList(1, 2, 2, 3, 3)));
    }

    @Test
    void removeDuplicatesNull() {
        assertTrue(collectionUtils.removeDuplicates(null).isEmpty());
    }

    @Test
    void removeDuplicatesNoDuplicates() {
        assertEquals(List.of(1, 2, 3), collectionUtils.removeDuplicates(List.of(1, 2, 3)));
    }

    @Test
    void filterEvenNormal() {
        assertEquals(List.of(2, 4), collectionUtils.filterEven(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void filterEvenNull() {
        assertTrue(collectionUtils.filterEven(null).isEmpty());
    }

    @Test
    void filterOddNormal() {
        assertEquals(List.of(1, 3, 5), collectionUtils.filterOdd(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void flattenNormal() {
        List<List<Integer>> input = List.of(List.of(1, 2), List.of(3, 4));
        assertEquals(List.of(1, 2, 3, 4), collectionUtils.flatten(input));
    }

    @Test
    void flattenNull() {
        assertTrue(collectionUtils.flatten(null).isEmpty());
    }

    @Test
    void frequencyNormal() {
        Map<String, Long> freq = collectionUtils.frequency(Arrays.asList("a", "b", "a", "c", "a"));
        assertEquals(3L, freq.get("a"));
        assertEquals(1L, freq.get("b"));
    }

    @Test
    void frequencyNull() {
        assertTrue(collectionUtils.frequency(null).isEmpty());
    }

    @Test
    void partitionNormal() {
        List<List<Integer>> result = collectionUtils.partition(List.of(1, 2, 3, 4, 5), 2);
        assertEquals(3, result.size());
        assertEquals(List.of(1, 2), result.get(0));
        assertEquals(List.of(5), result.get(2));
    }

    @Test
    void partitionInvalidSize() {
        assertTrue(collectionUtils.partition(List.of(1, 2), 0).isEmpty());
    }

    @Test
    void intersectionNormal() {
        assertEquals(List.of(2, 3), collectionUtils.intersection(List.of(1, 2, 3), List.of(2, 3, 4)));
    }

    @Test
    void intersectionNull() {
        assertTrue(collectionUtils.intersection(null, List.of(1)).isEmpty());
    }

    @Test
    void differenceNormal() {
        assertEquals(List.of(1), collectionUtils.difference(List.of(1, 2, 3), List.of(2, 3, 4)));
    }

    @Test
    void differenceNullSecond() {
        assertEquals(List.of(1, 2), collectionUtils.difference(List.of(1, 2), null));
    }
}
