/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgos;

import GenerateData.DataGenerator;
import algorithms.*;
import java.io.IOException;

/**
 *
 * @author bradl
 */
public class SortingAlgos {

    private static int[] dataToSort = {8,5,8,4};
    private static String[] namesOfSorts = {"BubbleSort", "MergeSort", "QuickSort", "QuickThread", "Insertion"};

    private static int[] sortsToPrint = {1};
    private static long[] timings = new long[10];

    private static int[] quicksortedData;
    private static int[] mergesortedData;
    private static int[] bubblesortedData;
    private static int[] insertsortedData;

    private static int[] quickthreadsortedData;
    private static boolean compareCorrectness = false;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        DataGenerator.generateData();
        DataGenerator.writeDataToFile();

        testAlgorithms();

        compareCorrectness();

    }

    public static void testAlgorithms() throws IOException {
        long timingStart;
        for (int i : sortsToPrint) {
            switch (i) {
                case 0:
                    dataToSort = DataGenerator.readDataFromFile();
                    timingStart = System.currentTimeMillis();
                    bubblesortedData = Bubblesort.sort(dataToSort);
                    printIntArray(bubblesortedData);
                    timings[0] = System.currentTimeMillis() - timingStart;
                    break;
                case 1:
                    dataToSort = DataGenerator.readDataFromFile();
                    timingStart = System.currentTimeMillis();
                    mergesortedData = Mergesort.sort(dataToSort);
                    printIntArray(mergesortedData);
                    timings[1] = System.currentTimeMillis() - timingStart;
                    break;
                case 2:
                    dataToSort = DataGenerator.readDataFromFile();
                    timingStart = System.currentTimeMillis();
                    quicksortedData = Quicksort.sort(dataToSort);
                    printIntArray(quicksortedData);
                    timings[2] = System.currentTimeMillis() - timingStart;
                    break;
                case 3:
                    dataToSort = DataGenerator.readDataFromFile();
                    timingStart = System.currentTimeMillis();
                    quickthreadsortedData = QuickSortWithThreads.sort(dataToSort);
                    printIntArray(quickthreadsortedData);
                    timings[3] = System.currentTimeMillis() - timingStart;
                    break;
                case 4:
                    dataToSort = DataGenerator.readDataFromFile();
                    timingStart = System.currentTimeMillis();
                    insertsortedData = Insertionsort.sort(dataToSort);
                    printIntArray(insertsortedData);
                    timings[4] = System.currentTimeMillis() - timingStart;
                    break;
            }

        }
        printArraysSideBySide();
    }

    public static void printArraysSideBySide() {
        String namesOfSortsLine = "";
        String millisecondsLine = "";
        for (int i : sortsToPrint) {
            namesOfSortsLine += String.format("%-12s", namesOfSorts[i]);
            millisecondsLine += String.format("%-12s", timings[i] + "ms");
        }
        System.out.println(namesOfSortsLine);
        System.out.println(millisecondsLine);
        /*
        for (int i = 0; i < dataToSort.length; i++) {
            System.out.println(includeSorts(sortsToPrint, i));
        }
        //*/
    }

    private static String includeSorts(int[] whichSorts, int index) {
        String sortStrings = "";
        for (int i : whichSorts) {
            switch (i) {
                case 0:
                    sortStrings += String.format("%-12s", String.valueOf(bubblesortedData[index]));
                    break;
                case 1:
                    sortStrings += String.format("%-12s", String.valueOf(mergesortedData[index]));
                    break;
                case 2:
                    sortStrings += String.format("%-12s", String.valueOf(quicksortedData[index]));
                    break;
                case 3:
                    sortStrings += String.format("%-12s", String.valueOf(quickthreadsortedData[index]));
                    break;
                case 4:
                    sortStrings += String.format("%-12s", String.valueOf(insertsortedData[index]));
                    break;
            }
        }
        return sortStrings;
    }

    public static void printIntArray(int[] data) {
        System.out.println("The integer array contains:");
        for (int i : data) {
            System.out.println(i);
        }
    }

    private static void compareCorrectness() {
        for (int i : sortsToPrint) {
            switch (i) {
                case 0:
                    if (!isInOrder(bubblesortedData)) {
                        System.out.println("BUBBLE is wrong");
                    }
                    break;
                case 1:
                    if (!isInOrder(mergesortedData)) {
                        System.out.println("MERGE is wrong");
                    }
                    break;
                case 2:
                    if (!isInOrder(quicksortedData)) {
                        System.out.println("QUICK is wrong");
                    }
                    break;
                case 3:
                    if (!isInOrder(quickthreadsortedData)) {
                        System.out.println("QUICKTHREAD is wrong");
                    }
                    break;
                case 4:
                    if (!isInOrder(insertsortedData)) {
                        System.out.println("INSERT is wrong");
                    }
                    break;
            }
        }
    }

    private static boolean isInOrder(int[] data) {
        for (int i = 0, j = 1; j < data.length; i++, j++) {
            if (data[i] > data[j]) {
                return false;
            }
        }
        return true;
    }
}
