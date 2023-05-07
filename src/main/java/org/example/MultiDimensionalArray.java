package org.example;

public class MultiDimensionalArray {
        private int[][][] array;
        private int[] iliffeVector;

        public MultiDimensionalArray(int[][][] array) {
            this.array = array;
            this.iliffeVector = calculateIliffeVector(array);
        }

        public int getElement(int i, int j, int k) {
            return array[i][j][k];
        }

        public int getElementUsingIliffeVector(int index) {
            int[] indices = calculateIndicesUsingIliffeVector(index, iliffeVector);
            return array[indices[0]][indices[1]][indices[2]];
        }

        public int[] calculateIliffeVector(int[][][] array) {
            int[] vector = new int[3];
            vector[0] = array.length;
            vector[1] = array[0].length;
            vector[2] = array[0][0].length;
            return vector;
        }

        public int[] calculateIndicesUsingIliffeVector(int index, int[] iliffeVector) {
            int[] indices = new int[3];
            int quotient = index;
            for (int i = 0; i < 3; i++) {
                indices[i] = quotient % iliffeVector[i];
                quotient = quotient / iliffeVector[i];
            }
            return indices;
        }
    }

