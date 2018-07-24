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
public class Mergesort {
    
    private static int[] mData;  
    public static int[] sort(int[] data) {
        mData = data;
        sort(0, data.length);
        return mData;
    }

    public static void sort(int first, int last) {
        if (last - first > 1) {
            int middle = (last + first) / 2;
            sort(first, middle);
            sort(middle, last);
            merge(first, middle, last);
        }
    }

    private static void merge(int first, int middle, int last) {
        int[] sorted = new int[last - first];
        int leftpos = first;
        int rightpos = middle;
        int newpos = 0;
        for (; leftpos < middle && rightpos < last; newpos++) {
            if (mData[leftpos] < mData[rightpos]) {
                sorted[newpos] = mData[leftpos];
                leftpos++;
            } else {
                sorted[newpos] = mData[rightpos];
                rightpos++;
            }
        }
        for (; leftpos < middle; leftpos++, newpos++) {
            sorted[newpos] = mData[leftpos];
        }

        for (; rightpos < last; rightpos++, newpos++) {
            sorted[newpos] = mData[rightpos];
        }
        newpos = first;
        for (int i : sorted) {
            mData[newpos] = i;
            newpos++;
        }

    }

}
