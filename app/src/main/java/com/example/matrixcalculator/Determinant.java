package com.example.matrixcalculator;

import android.widget.EditText;

public class Determinant {
    public float Determinant_Calculate(float[][] Matrix){

        int c = Matrix.length;

        float det = 0;

        if(c == 1){
            return Matrix[0][0];
        }
        else if(c == 2 ){

            float r1 = Matrix[0][0] * Matrix[1][1];
            float r2 = Matrix[0][1] * Matrix[1][0];

            det = r1 - r2;

            return det;
        }
        else if(c == 3 ){

            float r1 =  Matrix[0][0] * ((Matrix[1][1] * Matrix[2][2]) - (Matrix[2][1] * Matrix[1][2]));
            float r2 =  Matrix[0][1] * ((Matrix[1][0] * Matrix[2][2]) - (Matrix[1][2] * Matrix[2][0]));
            float r3 =  Matrix[0][2] * ((Matrix[1][0] * Matrix[2][1]) - (Matrix[1][1] * Matrix[2][0]));

            det = (r1 - r2 ) + r3;
            return det;
        }

        else if(c == 4 ){

            float r1 = Matrix[0][0]*(Determinant_Mat_3x3(Matrix[1][1] , Matrix[1][2] , Matrix[1][3] ,
                    Matrix[2][1] , Matrix[2][2] , Matrix[2][3] ,
                    Matrix[3][1] , Matrix[3][2] , Matrix[3][3] ));

            float r2 = Matrix[0][1]*(Determinant_Mat_3x3(Matrix[1][0] , Matrix[1][2] , Matrix[1][3] ,
                    Matrix[2][0] , Matrix[2][2] , Matrix[2][3] ,
                    Matrix[3][0] , Matrix[3][2] , Matrix[3][3] ));

            float r3 = Matrix[0][2]*(Determinant_Mat_3x3(Matrix[1][0] , Matrix[1][1] , Matrix[1][3] ,
                    Matrix[2][0] , Matrix[2][1] , Matrix[2][3] ,
                    Matrix[3][0] , Matrix[3][1] , Matrix[3][3] ));

            float r4 = Matrix[0][3]*(Determinant_Mat_3x3(Matrix[1][0] , Matrix[1][1] , Matrix[1][2] ,
                    Matrix[2][0] , Matrix[2][1] , Matrix[2][2] ,
                    Matrix[3][0] , Matrix[3][1] , Matrix[3][2] ));

            det = r1-r2+r3-r4;

            return det;
        }

        else if(c == 5 ){

            float r1 = Matrix[0][0]*(Determinant_Mat_4x4
                    (Matrix[1][1] , Matrix[1][2] , Matrix[1][3] , Matrix[1][4] ,
                    Matrix[2][1] , Matrix[2][2] , Matrix[2][3] , Matrix[2][4] ,
                    Matrix[3][1] , Matrix[3][2] , Matrix[3][3] , Matrix[3][4] ,
                    Matrix[4][1] , Matrix[4][2] , Matrix[4][3] , Matrix[4][4]));

            float r2 = Matrix[0][1]*(Determinant_Mat_4x4
                            (Matrix[1][0] , Matrix[1][2] , Matrix[1][3] , Matrix[1][4] ,
                            Matrix[2][0] , Matrix[2][2] , Matrix[2][3] , Matrix[2][4] ,
                            Matrix[3][0] , Matrix[3][2] , Matrix[3][3] ,Matrix[3][4] ,
                            Matrix[4][0] , Matrix[4][2] , Matrix[4][3] ,Matrix[4][4]));

            float r3 = Matrix[0][2]*(Determinant_Mat_4x4
                            (Matrix[1][0] , Matrix[1][1] , Matrix[1][3] , Matrix[1][4] ,
                            Matrix[2][0] , Matrix[2][1] , Matrix[2][3] , Matrix[2][4] ,
                            Matrix[3][0] , Matrix[3][1] , Matrix[3][3] ,Matrix[3][4] ,
                            Matrix[4][0] , Matrix[4][1] , Matrix[4][3] ,Matrix[4][4]));

            float r4 = Matrix[0][3]*(Determinant_Mat_4x4
                            (Matrix[1][0] , Matrix[1][1] , Matrix[1][2] , Matrix[1][4] ,
                            Matrix[2][0] , Matrix[2][1] , Matrix[2][2] , Matrix[2][4] ,
                            Matrix[3][0] , Matrix[3][1] , Matrix[3][2] ,Matrix[3][4] ,
                            Matrix[4][0] , Matrix[4][1] , Matrix[4][2] ,Matrix[4][4]));

            float r5 = Matrix[0][4]*(Determinant_Mat_4x4
                            (Matrix[1][0] , Matrix[1][1] , Matrix[1][2] , Matrix[1][3] ,
                            Matrix[2][0] , Matrix[2][1] , Matrix[2][2] , Matrix[2][3] ,
                            Matrix[3][0] , Matrix[3][1] , Matrix[3][2] ,Matrix[3][3] ,
                            Matrix[4][0] , Matrix[4][1] , Matrix[4][2] ,Matrix[4][3]));

            det = r1-r2+r3-r4+r5;

            return det;
        }

        return 0;
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
}
