/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 *
 * @author bradl
 */
public class QuickSortWithThreads {

    private static int threadspossible = Runtime.getRuntime().availableProcessors();
    private static int maxThreadLessDepth = (int) (Math.log(threadspossible) / Math.log(2));
    private static int numThreads = 0;
    private static int[] mData;

    private class sortSection implements Runnable {

        int mFirst = 0;
        int mLast = 0;

        public void sortSection(int pFirst, int pLast) {
            mFirst = pFirst;
            mLast = pLast;
        }

        @Override
        public void run() {
            quickSort(mFirst, mLast, 0);
        }

    }

    public static int[] sort(int[] data) {
        mData = data;
        quickSort(0, data.length - 1, 0);
        
        return mData;
    }

    private static void quickSort(int first, int last, int depth) {
        if (first < last) {
            int pivotPosition = pivotPosition(first, last);

            quickSort(first, pivotPosition - 1, ++depth);
            quickSort(pivotPosition + 1, last, ++depth);
        }
        return ;
    }

    private static int pivotPosition(int first, int last) {
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
        return pivot;
    }

    private static void swap(int one, int two) {
        int t = mData[one];
        mData[one] = mData[two];
        mData[two] = t;
    }
}
