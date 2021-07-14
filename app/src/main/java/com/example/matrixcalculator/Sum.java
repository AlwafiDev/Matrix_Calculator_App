package com.example.matrixcalculator;

public class Sum {
    public float[][] Sum_Calculate (float[][] Matrix_A , float[][] Matrix_B){
        float[][] Result = new float[Matrix_A.length][Matrix_A[0].length];

        for(int r = 0 ; r < Matrix_A.length ; r++){
            for(int c = 0 ; c < Matrix_A[0].length ; c++){
                Result[r][c] = Matrix_A[r][c] + Matrix_B[r][c];
            }
        }
        return Result;
    }
}
