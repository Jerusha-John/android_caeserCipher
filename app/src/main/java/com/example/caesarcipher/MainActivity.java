package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView tOut;
    Button btn;
    String inputString,newString;
    int key;
    Switch sw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        tOut = findViewById(R.id.t2);
        btn = findViewById(R.id.button);
        sw1 = findViewById(R.id.switch1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                key = Integer.parseInt(e2.getText().toString());
                inputString = e1.getText().toString();

                if(sw1.isChecked()){
                    newString = encrypter(inputString,key);
                }
                else{
                    newString = decrypter(inputString,key);
                }
                tOut.setText(newString);
            }
        });
    }

    protected String encrypter(String inputString,int key){

        Character charac;
        int prevAscii,newAscii;
        StringBuffer output = new StringBuffer();

        for(int i=0;i<inputString.length();i++){
            charac = inputString.charAt(i);
            if(charac.equals(' ')){
                output.append(Character.toString(charac));
                continue;
            }
            prevAscii = (int)charac;
            newAscii = prevAscii + key;
            if(newAscii > 90 && Character.isUpperCase(charac) || newAscii > 122){
                newAscii -= 26;
            }
            output.append(Character.toString((char)newAscii));
        }
        return String.valueOf(output);
    }

    protected String decrypter(String inputString,int key){

        Character charac;
        int prevAscii,newAscii;
        StringBuffer output = new StringBuffer();

        for(int i=0;i<inputString.length();i++){
            charac = inputString.charAt(i);
            if(charac.equals(' ')){
                output.append(Character.toString(charac));
                continue;
            }
            prevAscii = (int)charac;
            newAscii = prevAscii - key;
            if(newAscii < 65 && Character.isUpperCase(charac) || newAscii < 97){
                newAscii += 26;
            }
            output.append(Character.toString((char)newAscii));
        }
        return String.valueOf(output);
    }
}