package org.example;

import java.util.Random;

public class MultiDimensionalArrayTest {

    public static void main(String[] args) {
        int[][][] array = createRandomArray(10, 10, 10);

        MultiDimensionalArray mda = new MultiDimensionalArray(array);

        long startTime = System.nanoTime();
        int element = mda.getElement(5, 5, 5);
        long endTime = System.nanoTime();
        System.out.println("getElement time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        element = mda.getElementUsingIliffeVector(500050);
        endTime = System.nanoTime();
        System.out.println("getElementUsingIliffeVector time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int[] iliffeVector = mda.calculateIliffeVector(array);
        endTime = System.nanoTime();
        System.out.println("calculateIliffeVector time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        int[] indices = mda.calculateIndicesUsingIliffeVector(5, iliffeVector);
        endTime = System.nanoTime();
        System.out.println("calculateIndicesUsingIliffeVector time: " + (endTime - startTime) + " ns");
    }

    private static int[][][] createRandomArray(int x, int y, int z) {
        int[][][] array = new int[x][y][z];
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    array[i][j][k] = rand.nextInt();
                }
            }
        }
        return array;
    }
}
