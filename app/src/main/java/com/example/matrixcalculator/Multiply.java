package com.example.matrixcalculator;

public class Multiply {
    public float[][] Multiply_Calculate(float[][] Matrix_A , float[][] Matrix_B){

        float Result[][] = new float[Matrix_A.length][Matrix_B[0].length];

        float seeR = 0 , seeR1 = 0 ;
        for (int rm1 = 0; rm1 < Matrix_A.length; rm1++)
        {
            for (int cm2 = 0; cm2 < Matrix_B[0].length; cm2++)
            {
                for (int rcm1m2 = 0; rcm1m2 < Matrix_B.length; rcm1m2++)
                {

                    Result[rm1][cm2] += Matrix_A[rm1][rcm1m2] * Matrix_B[rcm1m2][cm2];

                    seeR = Matrix_A[rm1][rcm1m2] * Matrix_B[rcm1m2][cm2] ;

                    seeR1 += seeR ;

                }
                seeR1 = 0 ;
            }
        }

        return Result;
    }
}
