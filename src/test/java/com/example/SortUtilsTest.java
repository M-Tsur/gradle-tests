package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortUtilsTest {

    private SortUtils sortUtils;

    @BeforeEach
    void setUp() {
        sortUtils = new SortUtils();
    }

    @Test
    void bubbleSortNormal() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortUtils.bubbleSort(new int[]{5, 3, 1, 4, 2}));
    }

    @Test
    void bubbleSortAlreadySorted() {
        assertArrayEquals(new int[]{1, 2, 3}, sortUtils.bubbleSort(new int[]{1, 2, 3}));
    }

    @Test
    void bubbleSortNull() {
        assertNull(sortUtils.bubbleSort(null));
    }

    @Test
    void bubbleSortSingleElement() {
        assertArrayEquals(new int[]{42}, sortUtils.bubbleSort(new int[]{42}));
    }

    @Test
    void insertionSortNormal() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortUtils.insertionSort(new int[]{5, 3, 1, 4, 2}));
    }

    @Test
    void insertionSortReversed() {
        assertArrayEquals(new int[]{1, 2, 3}, sortUtils.insertionSort(new int[]{3, 2, 1}));
    }

    @Test
    void insertionSortNull() {
        assertNull(sortUtils.insertionSort(null));
    }

    @Test
    void selectionSortNormal() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortUtils.selectionSort(new int[]{5, 3, 1, 4, 2}));
    }

    @Test
    void selectionSortWithDuplicates() {
        assertArrayEquals(new int[]{1, 2, 2, 3}, sortUtils.selectionSort(new int[]{3, 2, 1, 2}));
    }

    @Test
    void selectionSortNull() {
        assertNull(sortUtils.selectionSort(null));
    }

    @Test
    void mergeSortNormal() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortUtils.mergeSort(new int[]{5, 3, 1, 4, 2}));
    }

    @Test
    void mergeSortSingleElement() {
        assertArrayEquals(new int[]{1}, sortUtils.mergeSort(new int[]{1}));
    }

    @Test
    void mergeSortNull() {
        assertNull(sortUtils.mergeSort(null));
    }

    @Test
    void mergeSortEmpty() {
        assertArrayEquals(new int[]{}, sortUtils.mergeSort(new int[]{}));
    }

    @Test
    void binarySearchFound() {
        assertEquals(2, sortUtils.binarySearch(new int[]{1, 3, 5, 7, 9}, 5));
    }

    @Test
    void binarySearchNotFound() {
        assertEquals(-1, sortUtils.binarySearch(new int[]{1, 3, 5, 7, 9}, 4));
    }

    @Test
    void binarySearchNull() {
        assertEquals(-1, sortUtils.binarySearch(null, 5));
    }

    @Test
    void binarySearchFirstElement() {
        assertEquals(0, sortUtils.binarySearch(new int[]{1, 3, 5, 7, 9}, 1));
    }

    @Test
    void binarySearchLastElement() {
        assertEquals(4, sortUtils.binarySearch(new int[]{1, 3, 5, 7, 9}, 9));
    }

    @Test
    void isSortedTrue() {
        assertTrue(sortUtils.isSorted(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void isSortedFalse() {
        assertFalse(sortUtils.isSorted(new int[]{1, 3, 2}));
    }

    @Test
    void isSortedNull() {
        assertTrue(sortUtils.isSorted(null));
    }

    @Test
    void isSortedSingleElement() {
        assertTrue(sortUtils.isSorted(new int[]{42}));
    }
}
