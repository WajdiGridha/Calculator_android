package com.example.calculator_android;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //déclaration des buttons
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bplus,bmoins,betoile,bdiv,bc,begal,bpoint;
    EditText res;
    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b0 = (Button) findViewById(R.id.button0);
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);

        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);

        Button b6 = (Button) findViewById(R.id.button6);
        Button b7 = (Button) findViewById(R.id.button7);
        Button b8 = (Button) findViewById(R.id.button8);
        Button b9 = (Button) findViewById(R.id.button9);
        Button bplus = (Button) findViewById(R.id.buttonPlus);
        Button bmoins = (Button) findViewById(R.id.buttonMoins);
        Button betoile = (Button) findViewById(R.id.buttonMultiplier);
        Button bdiv = (Button) findViewById(R.id.buttonDivision);
        Button bc = (Button) findViewById(R.id.buttonC);
        Button begal = (Button) findViewById(R.id.buttonEgal);
        Button bpoint = (Button) findViewById(R.id.buttonPoint);

        res = (EditText) findViewById(R.id.EditText01);

        // opération d'addition
        bplus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        //opération Mopins
        bmoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });


        //opération multiplication
        betoile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etoileClick();
            }
        });

        // opération de division
        bdiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });


        bc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        begal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        bpoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });


        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

    }
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!res.getText().equals("0"))
                str = res.getText() + str;
        }
        res.setText(str);



    }


    public void plusClick(){

        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }




    public void moinsClick(){
        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }

    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton *
    public void etoileClick(){
        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }


    public void divClick(){
        if(clicOperateur){
            calcul();
            res.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }


    //voici la méthode qui est  exécutée lorsqu'on clique sur le bouton =
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }

    //voici la méthode qui est  exécutée lorsque l'on clique sur le bouton C
    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        res.setText("");
    }

    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("/")){
            try{
                if(Double.valueOf(res.getText().toString()).doubleValue() != 0){
                    chiffre1 = chiffre1 / Double.valueOf(res.getText().toString()).doubleValue();
                    res.setText(String.valueOf(chiffre1));
                }else {
                    chiffre1 = 0 ;
                    res.setText("Error impossible div sur 0");
                }
            }catch(ArithmeticException e){
                res.setText("0");
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("result", res.getText().toString());
        myEdit.apply();
        Toast.makeText(MainActivity.this, "Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String ch = sh.getString("result", "");
        res.setText(ch);
        Toast.makeText(MainActivity.this, "Resume", Toast.LENGTH_SHORT).show();
    }
}


