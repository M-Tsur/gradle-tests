package com.example;

import java.util.Arrays;

public class SortUtils {

    public int[] bubbleSort(int[] arr) {
        if (arr == null) return null;
        int[] result = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    int tmp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = tmp;
                }
            }
        }
        return result;
    }

    public int[] insertionSort(int[] arr) {
        if (arr == null) return null;
        int[] result = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < result.length; i++) {
            int key = result[i];
            int j = i - 1;
            while (j >= 0 && result[j] > key) {
                result[j + 1] = result[j];
                j--;
            }
            result[j + 1] = key;
        }
        return result;
    }

    public int[] selectionSort(int[] arr) {
        if (arr == null) return null;
        int[] result = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < result.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = result[minIdx];
            result[minIdx] = result[i];
            result[i] = tmp;
        }
        return result;
    }

    public int binarySearch(int[] sortedArr, int target) {
        if (sortedArr == null) return -1;
        int lo = 0, hi = sortedArr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sortedArr[mid] == target) return mid;
            else if (sortedArr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr == null ? null : Arrays.copyOf(arr, arr.length);
        int[] result = Arrays.copyOf(arr, arr.length);
        mergeSortHelper(result, 0, result.length - 1);
        return result;
    }

    private void mergeSortHelper(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSortHelper(arr, lo, mid);
            mergeSortHelper(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int[] left = Arrays.copyOfRange(arr, lo, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, hi + 1);
        int i = 0, j = 0, k = lo;
        while (i < left.length && j < right.length) {
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) return true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}
