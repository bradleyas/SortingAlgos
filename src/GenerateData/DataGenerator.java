/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerateData;

import java.io.IOException;
import static java.lang.Math.random;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author bradl
 */
public class DataGenerator {

    private static String file = "Numbers.bin";
    private static Path path = Paths.get(file);
    private static int numValues = 5;//Integer.MAX_VALUE / 19;
    private static int maxValue = Integer.MAX_VALUE;
    private static int bytesPerInt = Integer.SIZE / Byte.SIZE;
    private static int[] randomValues = new int[numValues];

    public static int[] getRandomValues() {
        return randomValues;
    }

    public static void generateData() {
        for (int i = 0; i < numValues; i++) {
            randomValues[i] = (int) (random() * maxValue);
        }
    }

    public static void writeDataToFile() throws IOException {
        Files.write(path, convertIntegersToBytes(randomValues));
    }

    public static int[] readDataFromFile() throws IOException {
        byte[] byteNumbers = Files.readAllBytes(path);
        int[] intNumbers = new int[byteNumbers.length / 4];
        for (int i = 0; i < intNumbers.length; i++) {
            intNumbers[i] = toInt(byteNumbers, i);
        }

        return intNumbers;
    }

    private static int toInt(byte[] b, int poffset) {
        int ret = 0;
        int moffset = poffset * bytesPerInt;
        for (int i = moffset + bytesPerInt - 1; i >= moffset; i--) {
            ret <<= 8;
            ret |= (int) b[i] & 0xFF;
        }
        return ret;
    }

    public static byte[] convertIntegersToBytes(int[] integers) {
        if (integers != null) {
            byte[] outputBytes = new byte[integers.length * 4];

            for (int i = 0, k = 0; i < integers.length; i++) {
                int integerTemp = integers[i];
                for (int j = 0; j < 4; j++, k++) {
                    outputBytes[k] = (byte) ((integerTemp >> (8 * j)) & 0xFF);
                }
            }
            return outputBytes;
        } else {
            return null;
        }
    }

    private DataGenerator() {

    }
}
