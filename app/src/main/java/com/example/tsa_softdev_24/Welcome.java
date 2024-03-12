package com.example.tsa_softdev_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Welcome extends AppCompatActivity implements View.OnClickListener{


    public Button continue_to_TT, continue_to_Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

       continue_to_TT = findViewById(R.id.cont);
       continue_to_Home = findViewById(R.id.cont2);

       continue_to_TT.setOnClickListener(this);
       continue_to_Home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.cont){
            Intent intent = new Intent(Welcome.this, ToneTest.class);
            startActivity(intent);
    }else{
            Intent intent = new Intent(Welcome.this, MainActivity.class);
            startActivity(intent);
        }

}}
