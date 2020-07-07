package com.alice.d2_Strategy;

public class Sorter {

    public void stor(ComparableExt[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    private void swap(ComparableExt[] arr, int i, int j) {
        ComparableExt temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
