package com.example.matrixcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int[][] Mat_A ={ {R.id.Mat_A_i00 , R.id.Mat_A_i01 , R.id.Mat_A_i02 , R.id.Mat_A_i03 , R.id.Mat_A_i04 },
            {R.id.Mat_A_i10 , R.id.Mat_A_i11 , R.id.Mat_A_i12 , R.id.Mat_A_i13 , R.id.Mat_A_i14 },
            {R.id.Mat_A_i20 , R.id.Mat_A_i21 , R.id.Mat_A_i22 , R.id.Mat_A_i23 , R.id.Mat_A_i24 },
            {R.id.Mat_A_i30 , R.id.Mat_A_i31 , R.id.Mat_A_i32 , R.id.Mat_A_i33 , R.id.Mat_A_i34 },
            {R.id.Mat_A_i40 , R.id.Mat_A_i41 , R.id.Mat_A_i42 , R.id.Mat_A_i43 , R.id.Mat_A_i44 } };

    int[][] Mat_B ={ {R.id.Mat_B_i00 , R.id.Mat_B_i01 , R.id.Mat_B_i02 , R.id.Mat_B_i03 , R.id.Mat_B_i04 },
            {R.id.Mat_B_i10 , R.id.Mat_B_i11 , R.id.Mat_B_i12 , R.id.Mat_B_i13 , R.id.Mat_B_i14 },
            {R.id.Mat_B_i20 , R.id.Mat_B_i21 , R.id.Mat_B_i22 , R.id.Mat_B_i23 , R.id.Mat_B_i24 },
            {R.id.Mat_B_i30 , R.id.Mat_B_i31 , R.id.Mat_B_i32 , R.id.Mat_B_i33 , R.id.Mat_B_i34 },
            {R.id.Mat_B_i40 , R.id.Mat_B_i41 , R.id.Mat_B_i42 , R.id.Mat_B_i43 , R.id.Mat_B_i44 } };

    int[] Keyboard_Array = { R.id.KeyBoard_Key_1 , R.id.KeyBoard_Key_2 , R.id.KeyBoard_Key_3 , R.id.KeyBoard_Key_4 , R.id.KeyBoard_Key_5 ,
            R.id.KeyBoard_Key_6 , R.id.KeyBoard_Key_7 , R.id.KeyBoard_Key_8 , R.id.KeyBoard_Key_9 , R.id.KeyBoard_Key_0 , R.id.KeyBoard_Key_Minus ,
            R.id.KeyBoard_Key_Dot  };

    int[] Keyboard_Array_ImageButton = { R.id.KeyBoard_Move_Left , R.id.KeyBoard_Move_Right , R.id.KeyBoard_Move_Down , R.id.KeyBoard_Move_Up , R.id.KeyBoard_Cursor_Right ,
            R.id.KeyBoard_Cursor_Laft , R.id.KeyBoard_backspace , R.id.KeyBoard_Clear_A , R.id.KeyBoard_Clear_B };

    ImageButton Mat_1_Column_sum , Mat_1_Column_minus , Mat_1_Row_minus , Mat_1_Row_sum , Mat_2_Column_sum , Mat_2_Column_minus , Mat_2_Row_minus , Mat_2_Row_sum;

    TextView Mat_1_Column_TextView , Mat_1_Row_TextView , Mat_2_Column_TextView , Mat_2_Row_TextView;

    Button Button_Sum , Button_Subtract , Button_Multiply  , Button_Dividing , Button_Invers_A , Button_Invers_B ,
            Button_Transpose_A , Button_Transpose_B , Button_Adjoint_A , Button_Adjoint_B , Button_Determinant_A , Button_Determinant_B;

    int Mat_A_num_column = 2 , Mat_A_num_row = 2 , Mat_B_num_column = 2 , Mat_B_num_row = 2 ;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Mat_1_Column_TextView = findViewById(R.id.Mat_1_Column_TextView);
        Mat_1_Row_TextView = findViewById(R.id.Mat_1_Row_TextView);
        Mat_2_Column_TextView = findViewById(R.id.Mat_2_Column_TextView);
        Mat_2_Row_TextView = findViewById(R.id.Mat_2_Row_TextView);

        for(int i = 0 ; i < Keyboard_Array.length ; i++){
            Button b = findViewById(Keyboard_Array[i]);
            b.setOnClickListener(setOnClickListener_Keyboard);
        }

        for(int i = 0 ; i < Keyboard_Array_ImageButton.length ; i++){
            ImageButton bb = findViewById(Keyboard_Array_ImageButton[i]);
            bb.setOnClickListener(setOnClickListener_Keyboard);
        }

        for(int r = 0 ; r < Mat_A.length ; r++){
            for(int c = 0 ; c < Mat_A[0].length ; c++){
                EditText editText = findViewById(Mat_A[r][c]);
                    editText.setShowSoftInputOnFocus(false);

            }
        }

        for(int r = 0 ; r < Mat_B.length ; r++){
            for(int c = 0 ; c < Mat_B[0].length ; c++){
                EditText editTextd = findViewById(Mat_B[r][c]);
                    editTextd.setShowSoftInputOnFocus(false);

            }
        }

        EditText E = (EditText) findViewById(R.id.Mat_A_i00);
        E.requestFocus();

        findViewById(R.id.Mat_1_Column_sum).setOnClickListener(setOnClickListener);
        findViewById(R.id.Mat_1_Column_minus).setOnClickListener(setOnClickListener);

        findViewById(R.id.Mat_1_Row_minus).setOnClickListener(setOnClickListener);
        findViewById(R.id.Mat_1_Row_sum).setOnClickListener(setOnClickListener);


        findViewById(R.id.Mat_2_Column_sum).setOnClickListener(setOnClickListener);
        findViewById(R.id.Mat_2_Column_minus).setOnClickListener(setOnClickListener);

        findViewById(R.id.Mat_2_Row_minus).setOnClickListener(setOnClickListener);
        findViewById(R.id.Mat_2_Row_sum).setOnClickListener(setOnClickListener);

        Button_Sum = findViewById(R.id.Button_Sum);
        Button_Sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];
                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];

                if(Mat_A_num_column != Mat_B_num_column || Mat_A_num_row != Mat_B_num_row){
                    Send_to_Display_Activity_Error("Sum|Subtract");
                    return;
                }

                if(CheakNull(Mat_A_num_row , Mat_A_num_column) != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                            EditText bb = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(bb.getText()));
                        }
                    }
                    Sum Sum = new Sum();
                    float[][] Result = Sum.Sum_Calculate(Array_Mat_A , Array_Mat_B);
                    Send_to_Display_Activity_Result(Result);
                }

//                Toast.makeText(getApplicationContext(), "" ,Toast.LENGTH_SHORT).show();
            }
        });

        Button_Subtract = findViewById(R.id.Button_Subtract);
        Button_Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];
                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];

                if(Mat_A_num_column != Mat_B_num_column || Mat_A_num_row != Mat_B_num_row){
                    Send_to_Display_Activity_Error("Sum|Subtract");
                    return;
                }

                if(CheakNull(Mat_A_num_row , Mat_A_num_column) != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                            EditText bb = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(bb.getText()));
                        }
                    }
                    Subtract Subtract = new Subtract();
                    float[][] Result = Subtract.Subtract_Calculate(Array_Mat_A , Array_Mat_B);

                    Send_to_Display_Activity_Result(Result);
                }
            }
        });

        Button_Multiply = findViewById(R.id.Button_Multiply);
        Button_Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];
                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];

                if(Mat_A_num_column != Mat_B_num_row){
                    Send_to_Display_Activity_Error("Multiply");
                    return;
                }

                if(CheakNull(Mat_A_num_row , Mat_A_num_column , Mat_B_num_row , Mat_B_num_column) != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }
                    for (int r = 0; r < Array_Mat_B.length; r++) {
                        for (int c = 0; c < Array_Mat_B[0].length; c++) {

                            EditText bb = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(bb.getText()));
                        }
                    }

                    Multiply Multiply = new Multiply();
                    float[][] Result = Multiply.Multiply_Calculate(Array_Mat_A, Array_Mat_B);

                    Send_to_Display_Activity_Result(Result);
                }
            }
        });

        Button_Determinant_A = findViewById(R.id.Button_Determinant_A);
        Button_Determinant_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];

                if(Mat_A_num_column != Mat_A_num_row){
                    Send_to_Display_Activity_Error("Invers|Adjoint|Determinant");
                    return;
                }

                if(CheakNull(Mat_A_num_row , Mat_A_num_column , "A") != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }
                    Determinant Determinant = new Determinant();
                    float Result = Determinant.Determinant_Calculate(Array_Mat_A);

                    Send_to_Display_Activity_Result(Result);
                }

            }
        });

        Button_Determinant_B = findViewById(R.id.Button_Determinant_B);
        Button_Determinant_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];

                if(Mat_B_num_column != Mat_B_num_row){
                    Send_to_Display_Activity_Error("Invers|Adjoint|Determinant");
                    return;
                }

                if(CheakNull(Mat_B_num_row , Mat_B_num_column , "B") != -1 ) {
                    for (int r = 0; r < Array_Mat_B.length; r++) {
                        for (int c = 0; c < Array_Mat_B[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }
                    Determinant Determinant = new Determinant();
                    float Result = Determinant.Determinant_Calculate(Array_Mat_B);

                    Send_to_Display_Activity_Result(Result);
                }

            }
        });

        Button_Adjoint_A = findViewById(R.id.Button_Adjoint_A);
        Button_Adjoint_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];

                if(Mat_A_num_column != Mat_A_num_row){
                    Send_to_Display_Activity_Error("Invers|Adjoint|Determinant");
                    return;
                }

                if(CheakNull(Mat_A_num_row , Mat_A_num_column , "A") != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }

                    Adjoint Adjoint = new Adjoint();
                    float[][] Result = Adjoint.Adjoint_Calculate(Array_Mat_A);

                    Send_to_Display_Activity_Result(Result);
                }

            }
        });

        Button_Adjoint_B = findViewById(R.id.Button_Adjoint_B);
        Button_Adjoint_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];

                if(Mat_B_num_column != Mat_B_num_row){
                    Send_to_Display_Activity_Error("Invers|Adjoint|Determinant");
                    return;
                }

                if(CheakNull(Mat_B_num_row , Mat_B_num_column , "B") != -1 ) {
                    for (int r = 0; r < Array_Mat_B.length; r++) {
                        for (int c = 0; c < Array_Mat_B[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }

                    Adjoint Adjoint = new Adjoint();
                    float[][] Result = Adjoint.Adjoint_Calculate(Array_Mat_B);

                    Send_to_Display_Activity_Result(Result);
                }

            }
        });

        Button_Invers_A = findViewById(R.id.Button_Invers_A);
        Button_Invers_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];

                if(Mat_A_num_column != Mat_A_num_row){
                    Send_to_Display_Activity_Error("Invers|Adjoint|Determinant");
                    return;
                }

                if(CheakNull(Mat_A_num_row , Mat_A_num_column , "A") != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }

                    Invers Invers = new Invers();
                    float[][] Result = Invers.Invers_Calculate(Array_Mat_A);

                    Send_to_Display_Activity_Result(Result);
                }
            }
        });

        Button_Invers_B = findViewById(R.id.Button_Invers_B);
        Button_Invers_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];

                if(Mat_B_num_column != Mat_B_num_row){
                    Send_to_Display_Activity_Error("Invers|Adjoint|Determinant");
                    return;
                }

                if(CheakNull(Mat_B_num_row , Mat_B_num_column , "B") != -1 ) {
                    for (int r = 0; r < Array_Mat_B.length; r++) {
                        for (int c = 0; c < Array_Mat_B[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }

                    Invers Invers = new Invers();
                    float[][] Result = Invers.Invers_Calculate(Array_Mat_B);

                    Send_to_Display_Activity_Result(Result);
                }
            }
        });


        Button_Dividing = findViewById(R.id.Button_Dividing);
        Button_Dividing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];
                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];

                if(Mat_A_num_column != Mat_B_num_row || Mat_B_num_column != Mat_B_num_row){
                    Send_to_Display_Activity_Error("Dividing");
                    return;
                }

                if(Mat_A_num_column == 0 && Mat_A_num_row == 0 && Mat_B_num_column == 0 && Mat_B_num_row == 0){
                    EditText aa = findViewById(R.id.Mat_A_i00);
                    float ra = Float.parseFloat(String.valueOf(aa.getText()));

                    EditText bb = findViewById(R.id.Mat_B_i00);
                    float rb = Float.parseFloat(String.valueOf(bb.getText()));

                    float r = ra/rb ;

                    Send_to_Display_Activity_Result(r);
                    return;
                }

                if(CheakNull(Mat_A_num_row , Mat_A_num_column , Mat_B_num_row , Mat_B_num_column) != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }
                    for (int r = 0; r < Array_Mat_B.length; r++) {
                        for (int c = 0; c < Array_Mat_B[0].length; c++) {

                            EditText bb = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(bb.getText()));
                        }
                    }

                    Dividing Dividing = new Dividing();
                    float[][] Result = Dividing.Dividing_Calculate(Array_Mat_A, Array_Mat_B);

                    Send_to_Display_Activity_Result(Result);
                }
            }
        });

        Button_Transpose_A = findViewById(R.id.Button_Transpose_A);
        Button_Transpose_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float[][] Array_Mat_A = new float[Mat_A_num_row+1][Mat_A_num_column+1];


                if(CheakNull(Mat_A_num_row , Mat_A_num_column , "A") != -1 ) {
                    for (int r = 0; r < Array_Mat_A.length; r++) {
                        for (int c = 0; c < Array_Mat_A[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                            Array_Mat_A[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }

                    Transpose Transpose = new Transpose();
                    float[][] Result = Transpose.Transpose_Calculate(Array_Mat_A);

                    Send_to_Display_Activity_Result(Result);
                }
            }
        });

        Button_Transpose_B = findViewById(R.id.Button_Transpose_B);
        Button_Transpose_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float[][] Array_Mat_B = new float[Mat_B_num_row+1][Mat_B_num_column+1];


                if(CheakNull(Mat_B_num_row , Mat_B_num_column , "B") != -1 ) {
                    for (int r = 0; r < Array_Mat_B.length; r++) {
                        for (int c = 0; c < Array_Mat_B[0].length; c++) {
                            EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                            Array_Mat_B[r][c] = Float.parseFloat(String.valueOf(aa.getText()));

                        }
                    }

                    Transpose Transpose = new Transpose();
                    float[][] Result = Transpose.Transpose_Calculate(Array_Mat_B);

                    Send_to_Display_Activity_Result(Result);
                }

            }
        });

    }

    public int CheakNull (int Row_NumA ,int Column_NumA){
        for(int r = 0 ; r <= Row_NumA ; r++) {
            for (int c = 0; c <= Column_NumA; c++) {
                String CheakNull;

                EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                CheakNull = aa.getText().toString();
                if(CheakNull.matches("")){

                    Send_to_Display_Activity_Error("Null_Error");

                    return -1;
                }

                EditText bb = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                CheakNull = bb.getText().toString();
                if(CheakNull.matches("")){

                    Send_to_Display_Activity_Error("Null_Error");

                    return -1;
                }
            }
        }
        return 0;
    }

    public int CheakNull (int Row_NumA ,int Column_NumA , String A_or_B){
        for(int r = 0 ; r <= Row_NumA ; r++) {
            for (int c = 0; c <= Column_NumA; c++) {

                String CheakNull;

                if(A_or_B == "A"){
                    EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                    CheakNull = aa.getText().toString();
                    if(CheakNull.matches("")){

                        Send_to_Display_Activity_Error("Null_Error");

                        return -1;
                    }
                }
                else if (A_or_B == "B") {

                    EditText bb = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                    CheakNull = bb.getText().toString();
                    if (CheakNull.matches("")) {

                        Send_to_Display_Activity_Error("Null_Error");

                        return -1;
                    }
                }
            }
        }
        return 0;
    }

    public int CheakNull (int Row_NumA ,int Column_NumA , int Row_NumB, int Column_NumB){
        String CheakNull;
        for(int r = 0 ; r <= Row_NumA ; r++) {
            for (int c = 0; c <= Column_NumA; c++) {

                EditText aa = findViewById(getResources().getIdentifier(String.valueOf(Mat_A[r][c]), "id", getPackageName()));
                CheakNull = aa.getText().toString();
                if(CheakNull.matches("")){

                    Intent Intent = new Intent(getApplicationContext() , Display_Result.class);
                    Bundle B = new Bundle();

                    B.putInt("Null_Value_Error" , 1);

                    Intent.putExtras(B);
                    startActivity(Intent);


                    return -1;
                }


            }
        }

        for(int r = 0 ; r <= Row_NumB ; r++) {
            for (int c = 0; c <= Column_NumB; c++) {

                EditText bb = findViewById(getResources().getIdentifier(String.valueOf(Mat_B[r][c]), "id", getPackageName()));
                CheakNull = bb.getText().toString();
                if(CheakNull.matches("")){

                    Intent Intent = new Intent(getApplicationContext() , Display_Result.class);
                    Bundle B = new Bundle();

                    B.putInt("Null_Value_Error" , 1);

                    Intent.putExtras(B);
                    startActivity(Intent);

                    return -1;
                }

            }
        }
        return 0;
    }

    public void Send_to_Display_Activity_Result(float[][] Result){
        Intent Intent = new Intent(this , Display_Result.class);
        Bundle B = new Bundle();

        B.putSerializable("2_D_Array" , Result);

        Intent.putExtras(B);
        startActivity(Intent);
    }

    public void Send_to_Display_Activity_Result(float Result){
        Intent Intent = new Intent(this , Display_Result.class);
        Bundle B = new Bundle();

        B.putSerializable("Det_Result" , Result);
        B.putSerializable("Determinant" , 1);

        Intent.putExtras(B);
        startActivity(Intent);
    }

    public void Send_to_Display_Activity_Error(String Error_Type){
        Intent Intent = new Intent(this , Display_Result.class);
        Bundle B = new Bundle();

        if(Error_Type == "Sum|Subtract"){
            B.putInt("Mat_Size_Error" , 1);
            B.putInt("Sum|Subtract_Error" , 1);
        }
        else if(Error_Type == "Multiply"){
            B.putInt("Mat_Size_Error" , 1);
            B.putInt("Multiply_Error" , 1);
        }
        else if(Error_Type == "Dividing"){
            B.putInt("Mat_Size_Error" , 1);
            B.putInt("Dividing_Error" , 1);
        }
        else if(Error_Type == "Invers|Adjoint|Determinant"){
            B.putInt("Mat_Size_Error" , 1);
            B.putInt("Invers|Adjoint|Determinant" , 1);
        }
        else if(Error_Type == "Null_Error"){
            B.putInt("Null_Value_Error" , 1);
        }

        Intent.putExtras(B);
        startActivity(Intent);
    }


    final View.OnClickListener setOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Mat_1_Column_sum:
                    if(Mat_A_num_column == 4){break;}
                    Mat_A_num_column++;
                    Mat_1_Column_TextView = findViewById(R.id.Mat_1_Column_TextView);
                    Mat_1_Column_TextView.setText(String.valueOf(Mat_A_num_column));
                    for(int r = 0 ; r <= Mat_A_num_row ; r++){
                        for(int c = 0 ; c <= Mat_A_num_column ; c++){
                            findViewById(Mat_A[r][c]).setVisibility(View.VISIBLE);
                        }
                    }
                    break;

                case R.id.Mat_1_Row_sum:
                    if(Mat_A_num_row == 4){break;}
                    Mat_A_num_row++;
                    Mat_1_Row_TextView = findViewById(R.id.Mat_1_Row_TextView);
                    Mat_1_Row_TextView.setText(String.valueOf(Mat_A_num_row));
                    for(int r = 0 ; r <= Mat_A_num_row ; r++){
                        for(int c = 0 ; c <= Mat_A_num_column ; c++){
                            findViewById(Mat_A[r][c]).setVisibility(View.VISIBLE);
                        }
                    }
                    break;
                case R.id.Mat_1_Column_minus:
                    if(Mat_A_num_column == 0 ){break;}
                    for(int r = 0 ; r <= Mat_A_num_row ; r++){
                        for(int c =  Mat_A_num_column; c == Mat_A_num_column ; c++){
                            findViewById(Mat_A[r][c]).setVisibility(View.INVISIBLE);
                        }
                    }
                    Mat_A_num_column--;
                    Mat_1_Column_TextView = findViewById(R.id.Mat_1_Column_TextView);
                    Mat_1_Column_TextView.setText(String.valueOf(Mat_A_num_column));
                    break;

                case R.id.Mat_1_Row_minus:
                    if(Mat_A_num_row == 0 ){break;}
                    for(int rr = Mat_A_num_row ; rr == Mat_A_num_row ; rr++){
                        for(int cc = 0 ; cc <= Mat_A_num_column ; cc++){
                            findViewById(Mat_A[rr][cc]).setVisibility(View.INVISIBLE);
                        }
                    }
                    Mat_A_num_row--;
                    Mat_1_Row_TextView = findViewById(R.id.Mat_1_Row_TextView);
                    Mat_1_Row_TextView.setText(String.valueOf(Mat_A_num_row));
                    break;

                case R.id.Mat_2_Column_sum:
                    if(Mat_B_num_column == 4){break;}
                    Mat_B_num_column++;
                    Mat_2_Column_TextView = findViewById(R.id.Mat_2_Column_TextView);
                    Mat_2_Column_TextView.setText(String.valueOf(Mat_B_num_column));
                    for(int r = 0 ; r <= Mat_B_num_row ; r++){
                        for(int c = 0 ; c <= Mat_B_num_column ; c++){
                            findViewById(Mat_B[r][c]).setVisibility(View.VISIBLE);
                        }
                    }
                    break;

                case R.id.Mat_2_Row_sum:
                    if(Mat_B_num_row == 4){break;}
                    Mat_B_num_row++;
                    Mat_2_Row_TextView = findViewById(R.id.Mat_2_Row_TextView);
                    Mat_2_Row_TextView.setText(String.valueOf(Mat_B_num_row));
                    for(int r = 0 ; r <= Mat_B_num_row ; r++){
                        for(int c = 0 ; c <= Mat_B_num_column ; c++){
                            findViewById(Mat_B[r][c]).setVisibility(View.VISIBLE);
                        }
                    }
                    break;
                case R.id.Mat_2_Column_minus:
                    if(Mat_B_num_column == 0 ){break;}
                    for(int r = 0 ; r <= Mat_B_num_row ; r++){
                        for(int c =  Mat_B_num_column; c == Mat_B_num_column ; c++){
                            findViewById(Mat_B[r][c]).setVisibility(View.INVISIBLE);
                        }
                    }
                    Mat_B_num_column--;
                    Mat_2_Column_TextView = findViewById(R.id.Mat_2_Column_TextView);
                    Mat_2_Column_TextView.setText(String.valueOf(Mat_B_num_column));
                    break;

                case R.id.Mat_2_Row_minus:
                    if(Mat_B_num_row == 0 ){break;}
                    for(int rr = Mat_B_num_row ; rr == Mat_B_num_row ; rr++){
                        for(int cc = 0 ; cc <= Mat_B_num_column ; cc++){
                            findViewById(Mat_B[rr][cc]).setVisibility(View.INVISIBLE);
                        }
                    }
                    Mat_B_num_row--;
                    Mat_2_Row_TextView = findViewById(R.id.Mat_2_Row_TextView);
                    Mat_2_Row_TextView.setText(String.valueOf(Mat_B_num_row));
                    break;
            }

        }
    };



    //Keyboard
    final View.OnClickListener setOnClickListener_Keyboard = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.KeyBoard_Key_1:
                    SetText("1");
                    break;
                case R.id.KeyBoard_Key_2:
                    SetText("2");
                    break;
                case R.id.KeyBoard_Key_3:
                    SetText("3");
                    break;
                case R.id.KeyBoard_Key_4:
                    SetText("4");
                    break;
                case R.id.KeyBoard_Key_5:
                    SetText("5");
                    break;
                case R.id.KeyBoard_Key_6:
                    SetText("6");
                    break;
                case R.id.KeyBoard_Key_7:
                    SetText("7");
                    break;
                case R.id.KeyBoard_Key_8:
                    SetText("8");
                    break;
                case R.id.KeyBoard_Key_9:
                    SetText("9");
                    break;
                case R.id.KeyBoard_Key_0:
                    SetText("0");
                    break;
                case R.id.KeyBoard_Key_Minus:
                    Set_Text_Minus();
                    break;
                case R.id.KeyBoard_Key_Dot:
                    Set_Text_Dot();
                    break;
                case R.id.KeyBoard_Cursor_Laft:
                    SetCursPositon("Left");
                    break;
                case R.id.KeyBoard_Cursor_Right:
                    SetCursPositon("Right");
                    break;
                case R.id.KeyBoard_Move_Right:
                    Move_To_Another_EditText("Right");
                    break;
                case R.id.KeyBoard_Move_Up:
                    Move_To_Another_EditText("Up");
                    break;
                case R.id.KeyBoard_Move_Left:
                    Move_To_Another_EditText("Left");
                    break;
                case R.id.KeyBoard_Move_Down:
                    Move_To_Another_EditText("Down");
                    break;
                case R.id.KeyBoard_backspace:
                    Delet_character();
                    break;
                case R.id.KeyBoard_Clear_A:
                    Clear_Matrices("A");
                    break;
                case R.id.KeyBoard_Clear_B:
                    Clear_Matrices("B");
                    break;
            }
        }
    };

    public void SetText(String Text){
        for(int r=0; r<Mat_A.length; r++) {
            for(int c = 0 ; c < Mat_A[0].length ; c++){
                EditText e = (EditText) findViewById(Mat_A[r][c]);
                EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                if(e.isFocused()) {

                    String oldStr = e.getText().toString();
                    int cursorPos = e.getSelectionStart();
                    String leftStr = oldStr.substring(0, cursorPos);
                    String rightStr = oldStr.substring(cursorPos);
                    //e.setText(Text);  clear
                    e.setText(String.format("%s%s%s", leftStr, Text, rightStr));
                    e.setSelection(cursorPos + 1);
                }
                else if(e2.isFocused()) {

                    String oldStr = e2.getText().toString();
                    int cursorPos = e2.getSelectionStart();
                    String leftStr = oldStr.substring(0, cursorPos);
                    String rightStr = oldStr.substring(cursorPos);
                    //e.setText(Text);  clear
                    e2.setText(String.format("%s%s%s", leftStr, Text, rightStr));
                    e2.setSelection(cursorPos + 1);
                }
            }
        }
    }

    public void Set_Text_Minus(){
        for(int r=0; r<Mat_A.length; r++) {
            for(int c = 0 ; c < Mat_A[0].length ; c++){
                EditText e = (EditText) findViewById(Mat_A[r][c]);
                EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                if(e.isFocused()) {

                    String oldStr = e.getText().toString();
                    int cursorPos = e.getSelectionStart();

                    String s = e.getText().toString();
                    if(cursorPos == 0 && !s.contains("-")){
                        e.setText(String.format("%s%s", "-" , oldStr));
                        e.setSelection(cursorPos + 1);
                    }

                } else if(e2.isFocused()) {

                    String oldStr = e2.getText().toString();
                    int cursorPos = e2.getSelectionStart();

                    String s = e2.getText().toString();
                    if(cursorPos == 0 && !s.contains("-")){
                        e2.setText(String.format("%s%s", "-" , oldStr));
                        e2.setSelection(cursorPos + 1);
                    }

                }
            }
        }
    }

    public void Set_Text_Dot(){
        for(int r=0; r<Mat_A.length; r++) {
            for(int c = 0 ; c < Mat_A[0].length ; c++){
                EditText e = (EditText) findViewById(Mat_A[r][c]);
                EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                if(e.isFocused()) {

                    String oldStr = e.getText().toString();
                    int cursorPos = e.getSelectionStart();
                    String leftStr = oldStr.substring(0, cursorPos);
                    String rightStr = oldStr.substring(cursorPos);

                    String s = e.getText().toString();
                    if(!s.contains(".")){
                        e.setText(String.format("%s%s%s", leftStr, "." , rightStr));
                        e.setSelection(cursorPos + 1);
                    }
                }else if(e2.isFocused()) {

                    String oldStr = e2.getText().toString();
                    int cursorPos = e2.getSelectionStart();
                    String leftStr = oldStr.substring(0, cursorPos);
                    String rightStr = oldStr.substring(cursorPos);

                    String s = e2.getText().toString();
                    if(!s.contains(".")){
                        e2.setText(String.format("%s%s%s", leftStr, "." , rightStr));
                        e2.setSelection(cursorPos + 1);
                    }
                }
            }
        }
    }

    public void Delet_character(){
        for(int r=0; r<Mat_A.length; r++) {
            for(int c = 0 ; c < Mat_A[0].length ; c++){
                EditText e = (EditText) findViewById(Mat_A[r][c]);
                EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                if(e.isFocused()) {
                    int cursorPos = e.getSelectionStart();
                    int textLength = e.getText().length();

                    if(cursorPos != 0 && textLength != 0){
                        SpannableStringBuilder selection = (SpannableStringBuilder) e.getText();
                        selection.replace(cursorPos - 1 , cursorPos , "");
                        e.setText(selection);
                        e.setSelection(cursorPos - 1);
                    }
                }
                else if(e2.isFocused()) {
                    int cursorPos = e2.getSelectionStart();
                    int textLength = e2.getText().length();

                    if(cursorPos != 0 && textLength != 0){
                        SpannableStringBuilder selection = (SpannableStringBuilder) e2.getText();
                        selection.replace(cursorPos - 1 , cursorPos , "");
                        e2.setText(selection);
                        e2.setSelection(cursorPos - 1);
                    }
                }
            }
        }
    }

    public void SetCursPositon(String Direction){
        if(Direction == "Left"){
            for(int r=0; r<Mat_A.length; r++) {
                for(int c = 0 ; c < Mat_A[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_A[r][c]);
                    EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                    if(e.isFocused()) {
                        int cursorPos = e.getSelectionStart();
                        if(cursorPos != 0) {
                            e.setSelection(cursorPos - 1);
                        }
                    }
                    else if(e2.isFocused()) {
                        int cursorPos = e2.getSelectionStart();
                        if(cursorPos != 0) {
                            e2.setSelection(cursorPos - 1);
                        }
                    }
                }
            }
        }else if (Direction == "Right"){
            for(int r=0; r<Mat_A.length; r++) {
                for(int c = 0 ; c < Mat_A[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_A[r][c]);
                    EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                    if(e.isFocused()) {
                        int cursorPos = e.getSelectionStart();
                        if(!e.getText().toString().equals("") && e.getText().length() != cursorPos) {
                            e.setSelection(cursorPos + 1);
                        }
                    }
                    else if(e2.isFocused()) {
                        int cursorPos = e2.getSelectionStart();
                        if(!e2.getText().toString().equals("") && e2.getText().length() != cursorPos) {
                            e2.setSelection(cursorPos + 1);
                        }
                    }
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Move_To_Another_EditText(String Direction){

        if(Direction == "Right"){
            for(int r=0; r<Mat_A.length; r++) {
                for(int c = 0 ; c < Mat_A[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_A[r][c]);
                    EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                    if(e.isFocused() && c != Integer.parseInt(Mat_1_Column_TextView.getText().toString())) {
                        EditText h = (EditText) findViewById(Mat_A[r][c+1]);
                        h.requestFocus();
                        return;
                    }
                    else if (e.isFocused() && c == Integer.parseInt(Mat_1_Column_TextView.getText().toString())){
                        EditText h = (EditText) findViewById(Mat_A[r][0]);
                        h.requestFocus();
                    }
                    else if(e2.isFocused() && c != Integer.parseInt(Mat_2_Column_TextView.getText().toString())) {
                        EditText h = (EditText) findViewById(Mat_B[r][c+1]);
                        h.requestFocus();
                        return;
                    }
                    else if(e2.isFocused() && c == Integer.parseInt(Mat_2_Column_TextView.getText().toString())){
                        EditText h = (EditText) findViewById(Mat_B[r][0]);
                        h.requestFocus();
                    }
                }
            }
        }else if (Direction == "Left"){
            for(int r=0; r<Mat_A.length; r++) {
                for(int c = 0 ; c < Mat_A[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_A[r][c]);
                    EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                    if(e.isFocused() && c != 0) {
                        EditText h = (EditText) findViewById(Mat_A[r][c-1]);
                        h.requestFocus();
                        return;
                    }
                    else if(e.isFocused() && c == 0) {
                        EditText h = (EditText) findViewById(Mat_A[r][check_Visable_A()]);
                        h.requestFocus();
                        return;
                    }
                    else if(e2.isFocused() && c != 0) {
                        EditText h = (EditText) findViewById(Mat_B[r][c-1]);
                        h.requestFocus();
                        return;
                    }
                    else if(e2.isFocused() && c == 0) {
                        EditText h = (EditText) findViewById(Mat_B[r][check_Visable_B()]);
                        h.requestFocus();
                        return;
                    }
                }
            }
        }else if (Direction == "Up"){
            for(int r=0; r<Mat_A.length; r++) {
                for(int c = 0 ; c < Mat_A[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_A[r][c]);
                    EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                    if(e.isFocused() && r != 0) {
                        EditText h = (EditText) findViewById(Mat_A[r-1][c]);
                        h.requestFocus();
                        return;
                    }
                    else if(e.isFocused() && r == 0) {
                        EditText h = (EditText) findViewById(Mat_B[check_Visable_B_Raw()][c]);
                        h.requestFocus();
                        return;
                    }
                    else if(e2.isFocused() && r != 0) {
                        EditText h = (EditText) findViewById(Mat_B[r-1][c]);
                        h.requestFocus();
                        return;
                    }
                    else if(e2.isFocused() && r == 0){
                        EditText h = (EditText) findViewById(Mat_A[check_Visable_A_Raw()][c]);
                        h.requestFocus();
                        return;
                    }
                }
            }
        }else if (Direction == "Down"){
            for(int r=0; r<Mat_A.length; r++) {
                for(int c = 0 ; c < Mat_A[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_A[r][c]);
                    EditText e2 = (EditText) findViewById(Mat_B[r][c]);
                    if(e.isFocused() && r != Integer.parseInt(Mat_1_Row_TextView.getText().toString())) {
                        EditText h = (EditText) findViewById(Mat_A[r+1][c]);
                        h.requestFocus();
                        return;
                    }
                    else if(e.isFocused() && r == Integer.parseInt(Mat_1_Row_TextView.getText().toString())) {
                        EditText h = (EditText) findViewById(Mat_B[0][c]);
                        h.requestFocus();
                    }
                    else if(e2.isFocused() && r != Integer.parseInt(Mat_2_Row_TextView.getText().toString())) {
                        EditText h = (EditText) findViewById(Mat_B[r+1][c]);
                        h.requestFocus();
                        return;
                    }
                    else if(e2.isFocused() && r == Integer.parseInt(Mat_2_Row_TextView.getText().toString())) {
                        EditText h = (EditText) findViewById(Mat_A[0][c]);
                        h.requestFocus();
                    }
                }
            }
        }
    }

    public void Clear_Matrices (String A_or_B){
        if (A_or_B == "A"){
            for(int r = 0 ; r < Mat_A.length ; r++){
                for(int c = 0 ; c < Mat_A[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_A[r][c]);
                    e.setText("");
                }
            }
            EditText EditText = (EditText) findViewById(Mat_A[0][0]);
            EditText.requestFocus();
        } else if (A_or_B == "B"){
            for(int r = 0 ; r < Mat_B.length ; r++){
                for(int c = 0 ; c < Mat_B[0].length ; c++){
                    EditText e = (EditText) findViewById(Mat_B[r][c]);
                    e.setText("");
                }
            }
            EditText EditText = (EditText) findViewById(Mat_B[0][0]);
            EditText.requestFocus();
        }
    }

    public int check_Visable_A(){
        int gg = -1 ;
        for(int r = 0 ;  r < 1 ; r++){
            for (int c =  0 ;  c < Mat_A[0].length ; c++){
                EditText e = (EditText) findViewById(Mat_A[r][c]);
                if(e.isShown()){
                    gg++;
                }
            }
        }
        return gg;
    }

    public int check_Visable_B(){
        int gg = -1 ;
        for(int r = 0 ;  r < 1 ; r++){
            for (int c =  0 ;  c < Mat_B[0].length ; c++){
                EditText e = (EditText) findViewById(Mat_B[r][c]);
                if(e.isShown()){
                    gg++;
                }
            }
        }
        return gg;
    }

    public int check_Visable_B_Raw(){
        int gg = -1 ;
        for(int r = 0 ;  r < Mat_B.length ; r++){
            for (int c =  0 ;  c < 1 ; c++){
                EditText e = (EditText) findViewById(Mat_B[r][c]);
                if(e.isShown()){
                    gg++;
                }
            }
        }
        return gg;
    }

    public int check_Visable_A_Raw(){
        int gg = -1 ;
        for(int r = 0 ;  r < Mat_A.length ; r++){
            for (int c =  0 ;  c < 1 ; c++){
                EditText e = (EditText) findViewById(Mat_A[r][c]);
                if(e.isShown()){
                    gg++;
                }
            }
        }
        return gg;
    }
}
