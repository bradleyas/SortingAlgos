/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author bradl
 */
public class QuickSortWithThreads {

    private static int threadspossible = Runtime.getRuntime().availableProcessors();
    private static int maxDepth = (int) (Math.log(threadspossible) / Math.log(2));
    private static int numThreads = 0;
    private static int[] mData;
    private static sortSection[] sortingThreads = new sortSection[threadspossible];

    private static class sortSection implements Runnable {

        int mFirst = 0;
        int mLast = 0;

        sortSection(int pFirst, int pLast) {
            mFirst = pFirst;
            mLast = pLast;
        }

        @Override
        public void run() {
            quickSort(mFirst, mLast);
        }

        private static void quickSort(int first, int last) {
            if (first < last) {
                int pivotPosition = Partition(first, last);
                quickSort(first, pivotPosition);
                quickSort(pivotPosition + 1, last);
            }

        }
    }

    public static int[] sort(int[] data) {
        mData = data;
        quickSort(0, data.length - 1, 0);
        ExecutorService executor = Executors.newFixedThreadPool(threadspossible);
        for (sortSection i : sortingThreads) {
            if (i != null) {
                executor.execute(i);
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        return mData;
    }

    private static void quickSort(int first, int last, int depth) {
        if (first < last) {
            if (depth < maxDepth) {
                depth++;
                int pivotPosition = Partition(first, last);

                quickSort(first, pivotPosition, depth);
                quickSort(pivotPosition + 1, last, depth);
            } else if (numThreads < threadspossible) {
                sortingThreads[numThreads] = new sortSection(first, last);
                numThreads++;
            }
        }
    }

    private static int Partition(int left, int right) {
        int pivot = medianOfThree(left, right);
        int pivotValue = mData[pivot];
//        System.out.println(pivotValue);

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

    private static void smallBubbleSort(int left, int right) {
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j < right; j++) {
                if (mData[i] > mData[j]) {
                    int t = mData[i];
                    mData[i] = mData[j];
                    mData[j] = t;
                }
            }
        }
    }

    private static int medianOfThree(int left, int right) {
        int middleIndex = (left + right) / 2;
        int rightData = mData[right];
        int leftData = mData[left];

        int middleData = mData[middleIndex];

        return ((leftData - middleData) * (middleData - rightData) > - 1 ? middleIndex : ((leftData - middleData) * (leftData - rightData) < 1 ? left : right));
    }

    private QuickSortWithThreads() {
    }
}
