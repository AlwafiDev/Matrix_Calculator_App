package com.example.matrixcalculator;

import android.widget.EditText;

public class Adjoint {
    public float[][] Adjoint_Calculate(float[][] Matrix){

        int Matrix_Size = Matrix.length;

        if(Matrix_Size == 2){
            return Adjoint_Matrix_2x2(Matrix);
        }
        else if(Matrix_Size == 3){
            Matrix = Adjoint_Matrix_3x3(Matrix);
            //Matrix = Transpose(Matrix);

            return Matrix;
        }
        else if(Matrix_Size == 4){
            Matrix = Adjoint_Matrix_4x4(Matrix);
            //Matrix = Transpose(Matrix);

            return Matrix;
        }
        else if(Matrix_Size == 5){
            Matrix = Adjoint_Matrix_5x5(Matrix);
            //Matrix = Transpose(Matrix);

            return Matrix;
        }

        return null;
    }

    public float[][] Transpose (float[][] Result){
        float[][] NewMat = new float[Result.length][Result.length];
        for(int r = 0 ; r < Result.length; r++){
            for(int c = 0 ; c < Result.length ; c++){
                NewMat[r][c] = Result[c][r];
            }
        }
        return NewMat;
    }

    public float[][] Adjoint_Matrix_2x2(float[][] a){
        float[][] NewMat = new float[2][2];
        float swap = a[0][0];
        a[0][0] = a[1][1];
        a[1][1] = swap;

        a[0][1] *= -1;
        a[1][0] *= -1;

        return a;
    }

    public float[][] Adjoint_Matrix_3x3(float[][] a){
        float[][] NewMat = new float[3][3];

        NewMat[0][0] = (a[1][1] * a[2][2]) - (a[1][2] * a[2][1]);
        NewMat[0][1] = (a[1][0] * a[2][2]) - (a[1][2] * a[2][0]);
        NewMat[0][2] = (a[1][0] * a[2][1]) - (a[2][0] * a[1][1]);


        NewMat[1][0] = (a[0][1] * a[2][2]) - (a[0][2] * a[2][1]);
        NewMat[1][1] = (a[0][0] * a[2][2]) - (a[0][2] * a[2][0]);
        NewMat[1][2] = (a[0][0] * a[2][1]) - (a[2][0] * a[0][1]);

        NewMat[2][0] = (a[0][1] * a[1][2]) - (a[0][2] * a[1][1]);
        NewMat[2][1] = (a[0][0] * a[1][2]) - (a[1][0] * a[0][2]);
        NewMat[2][2] = (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);


        NewMat[0][1] = NewMat[0][1] * -1;
        NewMat[1][0] = NewMat[1][0] * -1;
        NewMat[1][2] = NewMat[1][2] * -1;
        NewMat[2][1] = NewMat[2][1] * -1;

        NewMat = Transpose(NewMat);

        return NewMat;
    }

    public float[][] Adjoint_Matrix_4x4(float a[][]){
        float[][] NewMat = new float[4][4];

        NewMat[0][0] = Determinant_Mat_3x3(a[1][1] , a[1][2] , a[1][3] , a[2][1] , a[2][2] , a[2][3] , a[3][1] , a[3][2] , a[3][3]);
        NewMat[0][1] = Determinant_Mat_3x3(a[1][0] , a[1][2] , a[1][3] , a[2][0] , a[2][2] , a[2][3] , a[3][0] , a[3][2] , a[3][3]);
        NewMat[0][2] = Determinant_Mat_3x3(a[1][0] , a[1][1] , a[1][3] , a[2][0] , a[2][1] , a[2][3] , a[3][0] , a[3][1] , a[3][3]);
        NewMat[0][3] = Determinant_Mat_3x3(a[1][0] , a[1][1] , a[1][2] , a[2][0] , a[2][1] , a[2][2] , a[3][0] , a[3][1] , a[3][2]);

        NewMat[1][0] = Determinant_Mat_3x3(a[0][1] , a[0][2] , a[0][3] , a[2][1] , a[2][2] , a[2][3] , a[3][1] , a[3][2] , a[3][3]);
        NewMat[1][1] = Determinant_Mat_3x3(a[0][0] , a[0][2] , a[0][3] , a[2][0] , a[2][2] , a[2][3] , a[3][0] , a[3][2] , a[3][3]);
        NewMat[1][2] = Determinant_Mat_3x3(a[0][0] , a[0][1] , a[0][3] , a[2][0] , a[2][1] , a[2][3] , a[3][0] , a[3][1] , a[3][3]);
        NewMat[1][3] = Determinant_Mat_3x3(a[0][0] , a[0][1] , a[0][2] , a[2][0] , a[2][1] , a[2][2] , a[3][0] , a[3][1] , a[3][2]);

        NewMat[2][0] = Determinant_Mat_3x3(a[0][1] , a[0][2] , a[0][3] , a[1][1] , a[1][2] , a[1][3] , a[3][1] , a[3][2] , a[3][3]);
        NewMat[2][1] = Determinant_Mat_3x3(a[0][0] , a[0][2] , a[0][3] , a[1][0] , a[1][2] , a[1][3] , a[3][0] , a[3][2] , a[3][3]);
        NewMat[2][2] = Determinant_Mat_3x3(a[0][0] , a[0][1] , a[0][3] , a[1][0] , a[1][1] , a[1][3] , a[3][0] , a[3][1] , a[3][3]);
        NewMat[2][3] = Determinant_Mat_3x3(a[0][0] , a[0][1] , a[0][2] , a[1][0] , a[1][1] , a[1][2] , a[3][0] , a[3][1] , a[3][2]);

        NewMat[3][0] = Determinant_Mat_3x3(a[0][1] , a[0][2] , a[0][3] , a[1][1] , a[1][2] , a[1][3] , a[2][1] , a[2][2] , a[2][3]);
        NewMat[3][1] = Determinant_Mat_3x3(a[0][0] , a[0][2] , a[0][3] , a[1][0] , a[1][2] , a[1][3] , a[2][0] , a[2][2] , a[2][3]);
        NewMat[3][2] = Determinant_Mat_3x3(a[0][0] , a[0][1] , a[0][3] , a[1][0] , a[1][1] , a[1][3] , a[2][0] , a[2][1] , a[2][3]);
        NewMat[3][3] = Determinant_Mat_3x3(a[0][0] , a[0][1] , a[0][2] , a[1][0] , a[1][1] , a[1][2] , a[2][0] , a[2][1] , a[2][2]);


        NewMat[0][1] *= -1;
        NewMat[0][3] *= -1;

        NewMat[1][0] *= -1;
        NewMat[1][2] *= -1;

        NewMat[2][1] *= -1;
        NewMat[2][3] *= -1;

        NewMat[3][0] *= -1;
        NewMat[3][2] *= -1;

        NewMat = Transpose(NewMat);

        return NewMat;
    }

    public float[][] Adjoint_Matrix_5x5(float a[][]){
        float[][] NewMat = new float[5][5];

        NewMat[0][0] = Determinant_Mat_4x4(a[1][1] , a[1][2] , a[1][3] , a[1][4] , a[2][1] , a[2][2] , a[2][3] , a[2][4] , a[3][1] , a[3][2] , a[3][3] , a[3][4] , a[4][1] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[0][1] = Determinant_Mat_4x4(a[1][0] , a[1][2] , a[1][3] , a[1][4] , a[2][0] , a[2][2] , a[2][3] , a[2][4] , a[3][0] , a[3][2] , a[3][3] , a[3][4] , a[4][0] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[0][2] = Determinant_Mat_4x4(a[1][0] , a[1][1] , a[1][3] , a[1][4] , a[2][0] , a[2][1] , a[2][3] , a[2][4] , a[3][0] , a[3][1] , a[3][3] , a[3][4] , a[4][0] , a[4][1] , a[4][3] , a[4][4] );
        NewMat[0][3] = Determinant_Mat_4x4(a[1][0] , a[1][1] , a[1][2] , a[1][4] , a[2][0] , a[2][1] , a[2][2] , a[2][4] , a[3][0] , a[3][1] , a[3][2] , a[3][4] , a[4][0] , a[4][1] , a[4][2] , a[4][4] );
        NewMat[0][4] = Determinant_Mat_4x4(a[1][0] , a[1][1] , a[1][2] , a[1][3] , a[2][0] , a[2][1] , a[2][2] , a[2][3] , a[3][0] , a[3][1] , a[3][2] , a[3][3] , a[4][0] , a[4][1] , a[4][2] , a[4][3] );

        NewMat[1][0] = Determinant_Mat_4x4(a[0][1] , a[0][2] , a[0][3] , a[0][4] , a[2][1] , a[2][2] , a[2][3] , a[2][4] , a[3][1] , a[3][2] , a[3][3] , a[3][4] , a[4][1] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[1][1] = Determinant_Mat_4x4(a[0][0] , a[0][2] , a[0][3] , a[0][4] , a[2][0] , a[2][2] , a[2][3] , a[2][4] , a[3][0] , a[3][2] , a[3][3] , a[3][4] , a[4][0] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[1][2] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][3] , a[0][4] , a[2][0] , a[2][1] , a[2][3] , a[2][4] , a[3][0] , a[3][1] , a[3][3] , a[3][4] , a[4][0] , a[4][1] , a[4][3] , a[4][4] );
        NewMat[1][3] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][4] , a[2][0] , a[2][1] , a[2][2] , a[2][4] , a[3][0] , a[3][1] , a[3][2] , a[3][4] , a[4][0] , a[4][1] , a[4][2] , a[4][4] );
        NewMat[1][4] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][3] , a[2][0] , a[2][1] , a[2][2] , a[2][3] , a[3][0] , a[3][1] , a[3][2] , a[3][3] , a[4][0] , a[4][1] , a[4][2] , a[4][3] );

        NewMat[2][0] = Determinant_Mat_4x4(a[0][1] , a[0][2] , a[0][3] , a[0][4] , a[1][1] , a[1][2] , a[1][3] , a[1][4] , a[3][1] , a[3][2] , a[3][3] , a[3][4] , a[4][1] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[2][1] = Determinant_Mat_4x4(a[0][0] , a[0][2] , a[0][3] , a[0][4] , a[1][0] , a[1][2] , a[1][3] , a[1][4] , a[3][0] , a[3][2] , a[3][3] , a[3][4] , a[4][0] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[2][2] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][3] , a[0][4] , a[1][0] , a[1][1] , a[1][3] , a[1][4] , a[3][0] , a[3][1] , a[3][3] , a[3][4] , a[4][0] , a[4][1] , a[4][3] , a[4][4] );
        NewMat[2][3] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][4] , a[1][0] , a[1][1] , a[1][2] , a[1][4] , a[3][0] , a[3][1] , a[3][2] , a[3][4] , a[4][0] , a[4][1] , a[4][2] , a[4][4] );
        NewMat[2][4] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][3] , a[1][0] , a[1][1] , a[1][2] , a[1][3] , a[3][0] , a[3][1] , a[3][2] , a[3][3] , a[4][0] , a[4][1] , a[4][2] , a[4][3] );

        NewMat[3][0] = Determinant_Mat_4x4(a[0][1] , a[0][2] , a[0][3] , a[0][4] , a[1][1] , a[1][2] , a[1][3] , a[1][4] , a[2][1] , a[2][2] , a[2][3] , a[2][4] , a[4][1] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[3][1] = Determinant_Mat_4x4(a[0][0] , a[0][2] , a[0][3] , a[0][4] , a[1][0] , a[1][2] , a[1][3] , a[1][4] , a[2][0] , a[2][2] , a[2][3] , a[2][4] , a[4][0] , a[4][2] , a[4][3] , a[4][4] );
        NewMat[3][2] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][3] , a[0][4] , a[1][0] , a[1][1] , a[1][3] , a[1][4] , a[2][0] , a[2][1] , a[2][3] , a[2][4] , a[4][0] , a[4][1] , a[4][3] , a[4][4] );
        NewMat[3][3] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][4] , a[1][0] , a[1][1] , a[1][2] , a[1][4] , a[2][0] , a[2][1] , a[2][2] , a[2][4] , a[4][0] , a[4][1] , a[4][2] , a[4][4] );
        NewMat[3][4] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][3] , a[1][0] , a[1][1] , a[1][2] , a[1][3] , a[2][0] , a[2][1] , a[2][2] , a[2][3] , a[4][0] , a[4][1] , a[4][2] , a[4][3] );

        NewMat[4][0] = Determinant_Mat_4x4(a[0][1] , a[0][2] , a[0][3] , a[0][4] , a[1][1] , a[1][2] , a[1][3] , a[1][4] , a[2][1] , a[2][2] , a[2][3] , a[2][4] , a[3][1] , a[3][2] , a[3][3] , a[3][4] );
        NewMat[4][1] = Determinant_Mat_4x4(a[0][0] , a[0][2] , a[0][3] , a[0][4] , a[1][0] , a[1][2] , a[1][3] , a[1][4] , a[2][0] , a[2][2] , a[2][3] , a[2][4] , a[3][0] , a[3][2] , a[3][3] , a[3][4] );
        NewMat[4][2] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][3] , a[0][4] , a[1][0] , a[1][1] , a[1][3] , a[1][4] , a[2][0] , a[2][1] , a[2][3] , a[2][4] , a[3][0] , a[3][1] , a[3][3] , a[3][4] );
        NewMat[4][3] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][4] , a[1][0] , a[1][1] , a[1][2] , a[1][4] , a[2][0] , a[2][1] , a[2][2] , a[2][4] , a[3][0] , a[3][1] , a[3][2] , a[3][4] );
        NewMat[4][4] = Determinant_Mat_4x4(a[0][0] , a[0][1] , a[0][2] , a[0][3] , a[1][0] , a[1][1] , a[1][2] , a[1][3] , a[2][0] , a[2][1] , a[2][2] , a[2][3] , a[3][0] , a[3][1] , a[3][2] , a[3][3] );

        NewMat[0][1] *= -1;
        NewMat[0][3] *= -1;

        NewMat[1][0] *= -1;
        NewMat[1][2] *= -1;
        NewMat[1][4] *= -1;

        NewMat[2][1] *= -1;
        NewMat[2][3] *= -1;

        NewMat[3][0] *= -1;
        NewMat[3][2] *= -1;
        NewMat[3][4] *= -1;

        NewMat[4][1] *= -1;
        NewMat[4][3] *= -1;

        NewMat = Transpose(NewMat);

        return NewMat;
    }

    public static float Determinant_Mat_3x3(float n1 , float n2 , float n3 , float n4 , float n5 , float n6 , float n7 , float n8 ,float n9){
        float[][] NewMat = new float[3][3];

        NewMat[0][0] = n1; NewMat[0][1] = n2; NewMat[0][2] = n3;
        NewMat[1][0] = n4; NewMat[1][1] = n5; NewMat[1][2] = n6;
        NewMat[2][0] = n7; NewMat[2][1] = n8; NewMat[2][2] = n9;

        float det = 0;

        float r1 =  NewMat[0][0] * ((NewMat[1][1] * NewMat[2][2]) - (NewMat[2][1] * NewMat[1][2]));
        float r2 =  NewMat[0][1] * ((NewMat[1][0] * NewMat[2][2]) - (NewMat[1][2] * NewMat[2][0]));
        float r3 =  NewMat[0][2] * ((NewMat[1][0] * NewMat[2][1]) - (NewMat[1][1] * NewMat[2][0]));

        det = (r1 - r2 ) + r3;

        return det;
    }

    public static float Determinant_Mat_4x4(float n1 , float n2 , float n3 , float n4 , float n5 , float n6 , float n7 , float n8 ,float n9 , float n10 ,
                                            float n11 , float n12 , float n13 , float n14 , float n15 , float n16 ){
        float[][] NewMat = new float[4][4];

        NewMat[0][0] = n1;  NewMat[0][1] = n2;  NewMat[0][2] = n3; NewMat[0][3] = n4;
        NewMat[1][0] = n5;  NewMat[1][1] = n6;  NewMat[1][2] = n7; NewMat[1][3] = n8;
        NewMat[2][0] = n9;  NewMat[2][1] = n10; NewMat[2][2] = n11; NewMat[2][3] = n12;
        NewMat[3][0] = n13; NewMat[3][1] = n14; NewMat[3][2] = n15; NewMat[3][3] = n16;

        float det = 0;

        float r1 = NewMat[0][0]*(Determinant_Mat_3x3(NewMat[1][1] , NewMat[1][2] , NewMat[1][3] ,
                NewMat[2][1] , NewMat[2][2] , NewMat[2][3] ,
                NewMat[3][1] , NewMat[3][2] , NewMat[3][3] ));

        float r2 = NewMat[0][1]*(Determinant_Mat_3x3(NewMat[1][0] , NewMat[1][2] , NewMat[1][3] ,
                NewMat[2][0] , NewMat[2][2] , NewMat[2][3] ,
                NewMat[3][0] , NewMat[3][2] , NewMat[3][3] ));

        float r3 = NewMat[0][2]*(Determinant_Mat_3x3(NewMat[1][0] , NewMat[1][1] , NewMat[1][3] ,
                NewMat[2][0] , NewMat[2][1] , NewMat[2][3] ,
                NewMat[3][0] , NewMat[3][1] , NewMat[3][3] ));

        float r4 = NewMat[0][3]*(Determinant_Mat_3x3(NewMat[1][0] , NewMat[1][1] , NewMat[1][2] ,
                NewMat[2][0] , NewMat[2][1] , NewMat[2][2] ,
                NewMat[3][0] , NewMat[3][1] , NewMat[3][2] ));

        det = r1-r2+r3-r4;

        return det;
    }
}
