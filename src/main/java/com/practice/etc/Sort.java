package com.practice.etc;

public class Sort {
    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }

    public int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            int j = i - 1;

            while (j >= 0 && now < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = now;
        }

        return arr;
    }

    public int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }

        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;

        while(i < j) {
            while(pivot < arr[j]) {
                j--;
            }

            while(i < j && pivot >= arr[i]){
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 3, 2};
        Sort sort = new Sort();
//        int[] sortedArr = sort.selectionSort(arr);
//        int[] sortedArr = sort.insertionSort(arr);
//        int[] sortedArr = sort.bubbleSort(arr);

        int[] sortedArr = sort.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
    }
}
