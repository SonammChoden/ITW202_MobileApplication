package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;
    private TextView mResultTextView;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();
        mOperandOneEditText=findViewById(R.id.editText1);
        mOperandTwoEditText =findViewById(R.id.editText2);
        mResultTextView=findViewById(R.id.textView1);
    }
    public void add(View view){
        String operandOne = mOperandOneEditText.getText().toString();
        String operandTwo = mOperandTwoEditText.getText().toString();


        double value =mCalculator.add(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }
    public void sub(View view){
        String operandOne =  mOperandOneEditText.getText().toString();
        String operandTwo = mOperandTwoEditText.getText().toString();

        double value =mCalculator.sub(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }
    public void mul(View view){
        String operandOne =  mOperandOneEditText.getText().toString();
        String operandTwo = mOperandTwoEditText.getText().toString();

        double value =mCalculator.mul(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }
    public void div(View view){
        String operandOne =  mOperandOneEditText.getText().toString();
        String operandTwo = mOperandTwoEditText.getText().toString();

        double value =mCalculator.div(Double.valueOf(operandOne), Double.valueOf(operandTwo));
        mResultTextView.setText(String.valueOf(value));
    }

}