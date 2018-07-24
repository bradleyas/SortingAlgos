/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author bradl
 */
public class Quicksort {
    
    private static int[] mData;    
    public static int[] sort(int[] data) {
        mData = data;
        quickSort(0, data.length - 1);
        return mData;
    }

    private static void quickSort(int first, int last) {
        if (first < last) {
            int pivot = (last - first) / 2 + first;
            int pivotValue = mData[pivot];
            //swap first element and pivot
            swap(first, pivot);
            pivot = first;
            int i = first + 1;
            for (; i <= last; i++) {
                if (mData[i] < pivotValue) {
                    swap(i, pivot);
                    swap(i, pivot + 1);
                    pivot++;
                }
            }
            quickSort(first, pivot - 1);
            quickSort(pivot + 1, last);
        }
    }

    private static void swap(int one, int two) {
        int t = mData[one];
        mData[one] = mData[two];
        mData[two] = t;
    }
}
