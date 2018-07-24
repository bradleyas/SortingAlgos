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
public class Bubblesort {

    public static int[] sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int t = data[i];
                    data[i] = data[j];
                    data[j] = t;
                }
            }
        }
        return data;
    }

}
