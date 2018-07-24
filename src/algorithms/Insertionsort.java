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
public class Insertionsort {

    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j > 0 && data[j - 1] > data[j]; j--) {
                int t = data[j];
                data[j] = data[j - 1];
                data[j - 1] = t;
            }
        }
        return data;
    }
}
