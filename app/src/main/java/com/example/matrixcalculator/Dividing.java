package com.example.matrixcalculator;

public class Dividing {
    public float[][] Dividing_Calculate (float[][] Matrix_A , float[][] Matrix_B){

        Invers Invers = new Invers();
        float[][] Invers_B = Invers.Invers_Calculate(Matrix_B);

        Multiply Multiply = new Multiply();
        return Multiply.Multiply_Calculate(Matrix_A , Invers_B);

    }
}
