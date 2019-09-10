package com.e.hex_o_dec;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.security.PublicKey;

import static com.e.hex_o_dec.R.id.bdec;
import static com.e.hex_o_dec.R.id.bhex;
import static com.e.hex_o_dec.R.id.editHex;

public class MainActivity extends AppCompatActivity {
    Button tmpButton;
    EditText currentState;
    int op1=-1,op2;
    String operation;
    EditText ebin,edec,eoct,ehex;
    Button b1,b0,b2,b3,b4,b5,b6,b7,b8,b9,bdel,bce,bnor,bxor,band,bor,bhelp,bequal,badd,bmul,bdiv,bsub,ba,bb,bc,bd,be,bf;
    @SuppressLint("ResourceAsColor")
    public void changeEditText(){
        EditText e1 = findViewById(R.id.editHex);
        EditText e2 = findViewById(R.id.editOct);
        EditText e3 = findViewById(R.id.editBin);
        EditText e4 = findViewById(R.id.editDec);
        e1.setEnabled(false);
        e2.setEnabled(false);
        e3.setEnabled(false);
        e4.setEnabled(false);
    }
    public static void disableSoftInputFromAppearing(EditText editText) {
        if (Build.VERSION.SDK_INT >= 11) {
            editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
            editText.setTextIsSelectable(true);
        } else {
            editText.setRawInputType(InputType.TYPE_NULL);
            editText.setFocusable(true);
        }
    }
    public static int octToDec(int octal){
        //Declaring variable to store decimal number
        int decimal = 0;
        //Declaring variable to use in power
        int n = 0;
        //writing logic
        while(true){
            if(octal == 0){
                break;
            } else {
                int temp = octal%10;
                decimal += temp*Math.pow(8, n);
                octal = octal/10;
                n++;
            }
        }
        return decimal;
    }
    @SuppressLint("SetTextI18n")
    public void onClickDigits(View view){
        if(currentState==ehex){
            Log.i("yeessssssssssss","as");
        }
        if(edec.getText().toString().length()<9 && currentState==edec) {
            Log.i("Insideeeee",""+edec.getText().toString().length());
            switch (view.getId()) {
                case R.id.bzero:
                    edec.append("0");
                    break;
                case R.id.bone:
                    edec.append("1");
                    break;
                case R.id.btwo:
                    edec.append("2");
                    break;
                case R.id.bthree:
                    edec.append("3");
                    break;
                case R.id.bfour:
                    edec.append("4");
                    break;
                case R.id.bfive:
                    edec.append("5");
                    break;
                case R.id.bsix:
                    edec.append("6");
                    break;
                case R.id.bseven:
                    edec.append("7");
                    break;
                case R.id.beight:
                    edec.append("8");
                    break;
                case R.id.bnine:
                    edec.append("9");
                    break;
            }
            eoct.setText(Integer.toOctalString(Integer.parseInt(edec.getText().toString())));
            ehex.setText(Integer.toHexString(Integer.parseInt(edec.getText().toString())).toUpperCase());
            ebin.setText(Integer.toBinaryString(Integer.parseInt(edec.getText().toString())));
        }
        else if(currentState==ehex && edec.getText().toString().length()<9) {
            Log.i("Lennngthhh",""+edec.getText().toString().length());
            switch (view.getId()) {
                case R.id.bzero:
                    ehex.append("0");
                    break;
                case R.id.bone:
                    ehex.append("1");
                    break;
                case R.id.btwo:
                    ehex.append("2");
                    break;
                case R.id.bthree:
                    ehex.append("3");
                    break;
                case R.id.bfour:
                    ehex.append("4");
                    break;
                case R.id.bfive:
                    ehex.append("5");
                    break;
                case R.id.bsix:
                    ehex.append("6");
                    break;
                case R.id.bseven:
                    ehex.append("7");
                    break;
                case R.id.beight:
                    ehex.append("8");
                    break;
                case R.id.bnine:
                    ehex.append("9");
                    break;
                case R.id.ba:
                    ehex.append("A");
                    break;
                case R.id.bb:
                    ehex.append("B");
                    break;
                case R.id.bc:
                    ehex.append("C");
                    break;
                case R.id.bd:
                    ehex.append("D");
                    break;
                case R.id.be:
                    ehex.append("E");
                    break;
                case R.id.bf:
                    ehex.append("F");
                    break;
            }
            Log.i("Texttttttttttt",""+ehex.getText().toString());
            edec.setText(Integer.toString(Integer.parseInt(ehex.getText().toString(),16)));
            eoct.setText(Integer.toOctalString(Integer.parseInt(edec.getText().toString())));
            ebin.setText(Integer.toBinaryString(Integer.parseInt(edec.getText().toString())));
        }
        else if(currentState==eoct && edec.getText().toString().length()<9) {
            Log.i("Lennngthhh",""+edec.getText().toString().length());
            switch (view.getId()) {
                case R.id.bzero:
                    eoct.append("0");
                    break;
                case R.id.bone:
                    eoct.append("1");
                    break;
                case R.id.btwo:
                    eoct.append("2");
                    break;
                case R.id.bthree:
                    eoct.append("3");
                    break;
                case R.id.bfour:
                    eoct.append("4");
                    break;
                case R.id.bfive:
                    eoct.append("5");
                    break;
                case R.id.bsix:
                    eoct.append("6");
                    break;
                case R.id.bseven:
                    eoct.append("7");
                    break;
            }
            edec.setText(Integer.toString(octToDec(Integer.parseInt(eoct.getText().toString()))));
            ehex.setText(Integer.toHexString(Integer.parseInt(edec.getText().toString())).toUpperCase());
            ebin.setText(Integer.toBinaryString(Integer.parseInt(edec.getText().toString())));
        }
        else if(currentState==ebin && edec.getText().toString().length()<9) {
            Log.i("Lennngthhh",""+edec.getText().toString().length());
            switch (view.getId()) {
                case R.id.bzero:
                    ebin.append("0");
                    break;
                case R.id.bone:
                    ebin.append("1");
                    break;
            }
            edec.setText(Integer.toString(Integer.parseInt(ebin.getText().toString(),2)));
            ehex.setText(Integer.toHexString(Integer.parseInt(edec.getText().toString())).toUpperCase());
            eoct.setText(Integer.toOctalString(Integer.parseInt(edec.getText().toString())));
        }
        else{
            Toast.makeText(this,"OUT OF RANGE",Toast.LENGTH_LONG).show();
        }

    }
    public void disableEditText(){
        eoct.setPressed(false);
        edec.setPressed(false);
        ehex.setPressed(false);
        ebin.setPressed(false);
    }
    public void decEnable(){
        enableAll();
        ba.setEnabled(false);
        bb.setEnabled(false);
        bc.setEnabled(false);
        bd.setEnabled(false);
        be.setEnabled(false);
        bf.setEnabled(false);
    }
    public void binEnable(){
        enableAll();
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        ba.setEnabled(false);
        bb.setEnabled(false);
        bc.setEnabled(false);
        bd.setEnabled(false);
        be.setEnabled(false);
        bf.setEnabled(false);
    }
    public void enableAll(){
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        ba.setEnabled(true);
        bb.setEnabled(true);
        bc.setEnabled(true);
        bd.setEnabled(true);
        be.setEnabled(true);
        bf.setEnabled(true);
    }
    public void octEnabled(){
        enableAll();
        ba.setEnabled(false);
        bb.setEnabled(false);
        bc.setEnabled(false);
        bd.setEnabled(false);
        be.setEnabled(false);
        bf.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }
    public void changeAllColors(){
        Button b1=(Button) findViewById(R.id.bdec);
        Button b2=(Button) findViewById(R.id.bhex);
        Button b3=(Button) findViewById(R.id.boct);
        Button b4=(Button) findViewById(R.id.bbin);
        b1.setBackgroundColor(Color.parseColor("#FF008577"));
        b2.setBackgroundColor(Color.parseColor("#FF008577"));
        b3.setBackgroundColor(Color.parseColor("#FF008577"));
        b4.setBackgroundColor(Color.parseColor("#FF008577"));
    }
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }
    public void onClickDel(View view){
        String tmp=edec.getText().toString();
        if(tmp.length()<=1){
            clearAll();
        }
        else {
            String s=removeLastChar(tmp);
            edec.setText(s);
            eoct.setText(Integer.toOctalString(Integer.parseInt(edec.getText().toString())));
            ehex.setText(Integer.toHexString(Integer.parseInt(edec.getText().toString())).toUpperCase());
            ebin.setText(Integer.toBinaryString(Integer.parseInt(edec.getText().toString())));
        }

    }
    public void clearAll(){
        edec.setText("");
        eoct.setText("");
        ehex.setText("");
        ebin.setText("");
    }
    public void onClickCE(View view){
        clearAll();
    }
    public void onClickEqual(View view){
        int ans = 0;
        if(edec.getText().toString().length()!=0 && op1!=-1) {
            op2 = Integer.parseInt(edec.getText().toString());
            switch (operation) {
                case "add":
                    ans = op1 + op2;
                    break;
                case "sub":
                    ans = op1 - op2;
                    break;
                case "mul":
                    ans = op1 * op2;
                    break;
                case "div":
                    if (op2 != 0) {
                        ans = op1 / op2;
                    } else {
                        Toast.makeText(this, "Cannot divide by 0. Try Again!", Toast.LENGTH_LONG).show();
                        clearAll();
                    }
                    break;
                case "and":
                    ans = op1 & op2;
                    break;
                case "xor":
                    ans = op1 ^ op2;
                    break;
                case "nor":
                    ans = ~ (op1 | op2);
                    break;
                case "or":
                    ans=op1 | op2;
                    break;
            }
            if (ans != 0) {
                edec.setText(Integer.toString(ans));
                eoct.setText(Integer.toOctalString(Integer.parseInt(edec.getText().toString())));
                ehex.setText(Integer.toHexString(Integer.parseInt(edec.getText().toString())).toUpperCase());
                ebin.setText(Integer.toBinaryString(Integer.parseInt(edec.getText().toString())));
            }
        }
    }
    public void onClickOperation(View view){

        if(edec.getText().toString().length()!=0) {
            op1 = Integer.parseInt(edec.getText().toString());
            clearAll();
            switch (view.getId()) {
                case R.id.badd:
                    operation = "add";
                    break;
                case R.id.bsub:
                    operation = "sub";
                    break;
                case R.id.bmul:
                    operation = "mul";
                    break;
                case R.id.bdiv:
                    operation = "div";
                    break;
                case R.id.bnor:
                    operation = "nor";
                    break;
                case R.id.bxor:
                    operation = "xor";
                    break;
                case R.id.band:
                    operation = "and";
                    break;
                case R.id.bor:
                    operation = "or";
                    break;
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    public void formatColor(View view){
        changeAllColors();
        findViewById(view.getId()).setBackgroundColor(Color.parseColor("#FFD81B60"));
        switch(view.getId()) {
            case R.id.bhex:
                currentState=ehex;
                disableEditText();
                EditText text=findViewById(editHex);
                text.setTextIsSelectable(false);
                text.requestFocus();
                text.setSelection(text.getText().length());
                tmpButton=findViewById(R.id.bhex);
                enableAll();
                changeEditText();
                findViewById(R.id.editHex).setEnabled(true);
                break;
            case R.id.boct:
                currentState=eoct;
                disableEditText();
                EditText text2=findViewById(R.id.editOct);
                text2.setTextIsSelectable(false);
                text2.requestFocus();
                text2.setSelection(text2.getText().length());
                tmpButton=findViewById(R.id.boct);
                changeEditText();
                octEnabled();
                findViewById(R.id.editOct).setEnabled(true);
                break;
            case R.id.bbin:
                currentState=ebin;
                disableEditText();
                EditText text3=findViewById(R.id.editBin);
                text3.setTextIsSelectable(false);
                text3.setSelection(text3.getText().length());
                tmpButton=findViewById(R.id.bbin);
                changeEditText();
                binEnable();
                findViewById(R.id.editBin).setEnabled(true);
                break;
            case R.id.bdec:
                currentState=edec;
                disableEditText();
                EditText text4=findViewById(R.id.editDec);
                text4.setTextIsSelectable(false);
                text4.requestFocus();
                text4.setSelection(text4.getText().length());
                decEnable();
                tmpButton=findViewById(R.id.bdec);
                changeEditText();
                findViewById(R.id.editDec).setEnabled(true);
                EditText editText = findViewById(R.id.editDec);
                break;
        }
    }
    @SuppressLint("ResourceAsColor")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bdec).setBackgroundColor(Color.parseColor("#FFD81B60"));
        changeEditText();
        //Assigning all buttons
        b1=findViewById(R.id.bone);
        b2=findViewById(R.id.btwo);
        b3=findViewById(R.id.bthree);
        b4=findViewById(R.id.bfour);
        b5=findViewById(R.id.bfive);
        b6=findViewById(R.id.bsix);
        b7=findViewById(R.id.bseven);
        b8=findViewById(R.id.beight);
        b9=findViewById(R.id.bnine);
        b0=findViewById(R.id.bzero);
        ba=findViewById(R.id.ba);
        bb=findViewById(R.id.bb);
        bc=findViewById(R.id.bc);
        bd=findViewById(R.id.bd);
        be=findViewById(R.id.be);
        bf=findViewById(R.id.bf);
        bxor=findViewById(R.id.bxor);
        bnor=findViewById(R.id.bnor);
        bor=findViewById(R.id.bor);
        band=findViewById(R.id.band);
        badd=findViewById(R.id.badd);
        bsub=findViewById(R.id.bsub);
        bmul=findViewById(R.id.bmul);
        bdiv=findViewById(R.id.bdiv);
        bequal=findViewById(R.id.bequal);
        bhelp=findViewById(R.id.bhelp);

        //asE
        edec = findViewById(R.id.editDec);
        ehex = findViewById(R.id.editHex);
        ebin = findViewById(R.id.editBin);
        eoct = findViewById(R.id.editOct);
        disableEditText();
        disableSoftInputFromAppearing(edec);
        disableSoftInputFromAppearing(eoct);
        disableSoftInputFromAppearing(ehex);
        disableSoftInputFromAppearing(ebin);
        formatColor(findViewById(R.id.bdec));

    }

}
