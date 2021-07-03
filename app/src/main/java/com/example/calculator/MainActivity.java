package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    ImageView btnac,btnmod,btnextra,btnplus,btnmulty,btnminus,btnequal,btndot;
    TextView inputText,outputText;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btndot = findViewById(R.id.btndot);
        btnminus = findViewById(R.id.btnminus);
        btnmod = findViewById(R.id.btnmod);
        btnmulty = findViewById(R.id.btnmulty);
        btnplus = findViewById(R.id.btnplus);
        btnextra = findViewById(R.id.btnextra);
        btnequal = findViewById(R.id.btnequal);
        btnac = findViewById(R.id.btnac);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"0");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"6");
            }

        });btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"9");
            }
        });

        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               inputText.setText("");
               outputText.setText("0");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+".");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"+");
            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"-");
            }
        });

        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"%");
            }
        });

        btnmulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+"✕");
            }
        });

        btnequal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();

                data = data.replaceAll("✕","*");
                data = data.replaceAll("%","/100");
                data = data.replaceAll("÷","/");


                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                Scriptable scriptable = rhino.initSafeStandardObjects();
                finalResult = rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();

                outputText.setText(finalResult);
            }
        }));



    }
}