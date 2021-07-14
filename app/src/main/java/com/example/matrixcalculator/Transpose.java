package com.example.matrixcalculator;

public class Transpose {
    public float[][] Transpose_Calculate(float[][] Matrix){
        float[][] Result = new float[Matrix[0].length][Matrix.length];

        for(int r = 0 ; r < Result.length ; r++){
            for(int c = 0 ; c < Result[0].length ; c++){
                Result[r][c] = Matrix[c][r];
            }
        }
        return Result;
    }
}
