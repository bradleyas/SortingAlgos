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

    private static int[] dataToSort = {5, 8, 7, 4, 2, 3, 9};

    private static int[] quicksortedData;
    private static int[] mergesortedData;
    private static int[] bubblesortedData;
    private static int[] insertsortedData;

    private static int[] quickthreadsortedData;

    private static long bubbletime;
    private static long mergetime;
    private static long quicktime;
    private static long inserttime;
    private static long quickthreadtime;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        DataGenerator.generateData();
        DataGenerator.writeDataToFile();

        testAlgorithms();
    }

    public static void testAlgorithms() throws IOException {
//        dataToSort = DataGenerator.readDataFromFile();
//        bubbletime = System.currentTimeMillis();
//        bubblesortedData = Bubblesort.sort(dataToSort);
//        //printIntArray(bubblesortedData);
//        bubbletime = System.currentTimeMillis() - bubbletime;

//        dataToSort = DataGenerator.readDataFromFile();
//        mergetime = System.currentTimeMillis();
//        mergesortedData = Mergesort.sort(dataToSort);
//        printIntArray(mergesortedData);
//        mergetime = System.currentTimeMillis() - mergetime;
//
//        dataToSort = DataGenerator.readDataFromFile();
//        quicktime = System.currentTimeMillis();
//        quicksortedData = Quicksort.sort(dataToSort);
//        printIntArray(quicksortedData);
//        quicktime = System.currentTimeMillis() - quicktime;

        dataToSort = DataGenerator.readDataFromFile();
        quickthreadtime = System.currentTimeMillis();
        quickthreadsortedData = QuickSortWithThreads.sort(dataToSort);
        printIntArray(quickthreadsortedData);
        quickthreadtime = System.currentTimeMillis() - quickthreadtime;

//        dataToSort = DataGenerator.readDataFromFile();
//        inserttime = System.currentTimeMillis();
//        insertsortedData = Insertionsort.sort(dataToSort);
//        //printIntArray(insertsortedData);
//        inserttime = System.currentTimeMillis() - inserttime;
        printArraysSideBySide();
    }
    public static void addToSortedListPrintout(String sortname, int[] data){
        
    }
    
    
    public static void printArraysSideBySide() {
        System.out.println("BubbleSort  MergeSort   QuickSort   InsertionSort");

        System.out.println(String.format("%-12s", String.valueOf(bubbletime) + "ms")
                + String.format("%-12s", String.valueOf(mergetime) + "ms")
                + String.format("%-12s", String.valueOf(quicktime) + "ms")
                + String.format("%-12s", String.valueOf(inserttime) + "ms"));

        System.out.println();
//        String line;
//        for (int i = 0; i < dataToSort.length; i++) {
//            line = String.format("%-12s", String.valueOf(bubblesortedData[i]))
//                    + String.format("%-12s", String.valueOf(mergesortedData[i]))
//                    + String.format("%-12s", String.valueOf(quicksortedData[i]))
//                    + String.format("%-12s", String.valueOf(insertsortedData[i]));
//            System.out.println(line);
//        }
    }

    public static void printIntArray(int[] data) {
        System.out.println("The integer array contains:");
        for (int i : data) {
            System.out.println(i);
        }
    }
}
