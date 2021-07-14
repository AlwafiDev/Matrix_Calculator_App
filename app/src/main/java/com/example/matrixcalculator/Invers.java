package com.example.matrixcalculator;

import android.util.Log;

public class Invers {
    public float[][] Invers_Calculate(float[][] Matrix){

        int Matrix_Size = Matrix.length;

        Adjoint Adjoint = new Adjoint();
        Determinant Determinant = new Determinant();

        if(Matrix_Size == 2){
            Matrix = Adjoint.Adjoint_Matrix_2x2(Matrix);
            float Det = Determinant.Determinant_Calculate(Matrix) ;

            for(int r = 0 ; r < Matrix.length ; r++){
                for(int c = 0 ; c < Matrix[0].length ; c++){
                    Matrix[r][c] = Matrix[r][c] / Det;
                }
            }

            return Matrix;

        }

        else if(Matrix_Size == 3){

            float Det = Determinant.Determinant_Calculate(Matrix) ;
            Matrix = Adjoint.Adjoint_Matrix_3x3(Matrix);

            for(int r = 0 ; r < Matrix.length ; r++){
                for(int c = 0 ; c < Matrix[0].length ; c++){
                    Matrix[r][c] = Matrix[r][c] / Det;
                }
            }

            return Matrix;

        }
        else if(Matrix_Size == 4){

            float Det = Determinant.Determinant_Calculate(Matrix) ;
            Matrix = Adjoint.Adjoint_Matrix_4x4(Matrix);


            for(int r = 0 ; r < Matrix.length ; r++){
                for(int c = 0 ; c < Matrix[0].length ; c++){
                    Matrix[r][c] = Matrix[r][c] / Det;
                }
            }

            return Matrix;

        }
        else if(Matrix_Size == 5){

            float Det = Determinant.Determinant_Calculate(Matrix) ;
            Matrix = Adjoint.Adjoint_Matrix_5x5(Matrix);

            for(int r = 0 ; r < Matrix.length ; r++){
                for(int c = 0 ; c < Matrix[0].length ; c++){
                    Matrix[r][c] = Matrix[r][c] / Det;
                }
            }

            return Matrix;

        }

        return null;
    }
}
