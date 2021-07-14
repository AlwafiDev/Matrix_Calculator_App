package com.example.matrixcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class Display_Result extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        TextView textView = findViewById(R.id.Result_TextView);

        Bundle Get_Bundel = getIntent().getExtras();

        if(Get_Bundel.getInt("Mat_Size_Error") == 1 && Get_Bundel.getInt("Sum|Subtract_Error") == 1){
            textView.setText(" The tow matrices Must have same Column and Row size ");
        }
        else if(Get_Bundel.getInt("Mat_Size_Error") == 1 && Get_Bundel.getInt("Multiply_Error") == 1){
            textView.setText("Column Size of first Matrix must equal row size of second matrix");
        }
        else if(Get_Bundel.getInt("Mat_Size_Error") == 1 && Get_Bundel.getInt("Dividing_Error") == 1){
            textView.setText("Column Size of first Matrix must equal row and column size of second matrix");
        }
        else if(Get_Bundel.getInt("Mat_Size_Error") == 1 && Get_Bundel.getInt("Invers|Adjoint|Determinant") == 1){
            textView.setText("Column And Row must have same size");
        }
        else if(Get_Bundel.getInt("Null_Value_Error") == 1){
            textView.setText(" You have null value ");
        }
        else if(Get_Bundel.getInt("Determinant") == 1){
            textView.setText("Det = " + Get_Bundel.getSerializable("Det_Result"));
        }
        else {

            float[][] arr = (float[][]) Get_Bundel.getSerializable("2_D_Array");
            for (int r = 0; r < arr.length; r++) {
                for (int c = 0; c < arr[0].length; c++) {
                  //  NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
                    //arr[r][c] = Float.parseFloat(nf.format(arr[r][c]));
                   // String h = nf.format(arr[r][c]);

                    //textView.append(arr[r][c]+"   ");
                 //   textView.append(h + "   ");
                    textView.append(arr[r][c] + "   ");
                }
                textView.append("\n");
            }
        }
    }

}