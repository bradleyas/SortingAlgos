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
            int pivotPosition = Partition(first, last);
            quickSort(first, pivotPosition);
            quickSort(pivotPosition + 1, last);
        }
    }

    private static int Partition(int left, int right) {
        int pivot = medianOfThree(left, right);
        int pivotValue = mData[pivot];

        int i = left - 1;
        int j = right + 1;

        while (true) {
            do {
                i++;
            } while (mData[i] < pivotValue);

            do {
                j--;
            } while (mData[j] > pivotValue);

            if (i >= j) {
                return j;
            }
            swap(i, j);
        }
    }

    private static void swap(int one, int two) {
        int t = mData[one];
        mData[one] = mData[two];
        mData[two] = t;
    }

    private static int medianOfThree(int left, int right) {
        int middleIndex = (left + right) / 2;
        int rightData = mData[right];
        int leftData = mData[left];

        int middleData = mData[middleIndex];

        return ((leftData - middleData) * (middleData - rightData) > - 1 ? middleIndex : ((leftData - middleData) * (leftData - rightData) < 1 ? left : right));
    }

    private Quicksort() {
    }
}
