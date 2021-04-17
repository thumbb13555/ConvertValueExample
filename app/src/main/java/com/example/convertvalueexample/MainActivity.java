package com.example.convertvalueexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName()+"m";
    Button btConvert;
    EditText edInput,edBinary,edOctal,edDecimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btConvert   = findViewById(R.id.button);
        edInput     = findViewById(R.id.input);
        edBinary    = findViewById(R.id.binary);
        edOctal     = findViewById(R.id.octal);
        edDecimal   = findViewById(R.id.decimal);
        btConvert.setOnClickListener((v)->{convert();});

    }

    private void convert(){
            if (edInput.getText().toString().length()>0){
                int input = (short)Integer.parseInt(edInput.getText().toString(),16);
                edDecimal.setText(String.valueOf(input));
                if(input<0){
                    edBinary.setText("-"+(Long.toBinaryString(~input+1)));
                    edOctal.setText("-"+Long.toOctalString(~input+1));
                }else{
                    edBinary.setText(Long.toBinaryString(input));
                    edOctal.setText(Long.toOctalString(input));
                }

                if (Long.toBinaryString(input).length()<8){
                    edBinary.setText(String.format("%08d",Integer.parseInt(Long.toBinaryString(input))));
                }

            }

        



    }
}
