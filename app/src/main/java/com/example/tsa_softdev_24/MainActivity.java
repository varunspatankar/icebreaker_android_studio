package com.example.tsa_softdev_24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }
}
 */

public class MainActivity extends AppCompatActivity {
    public CardView card1, card2, card3, card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the CardView by its ID
        card1 = (CardView) findViewById(R.id.h1);
        card2 = (CardView) findViewById(R.id.h2);
        card3 = (CardView) findViewById(R.id.h3);
        card4 = (CardView) findViewById(R.id.h4);
        card5 = (CardView) findViewById(R.id.h5);
        card6 = (CardView) findViewById(R.id.h6);

        // Set an OnClickListener for NewChats
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, NewChatsActivity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for OldChats
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, OldChatsActivity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for Lessons
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, LessonsActivity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for Reset
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, ResetActivity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for HowToUse
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, HowToUseActivity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for AboutUs
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }

     /*
        card1.setOnClickListener(this);
        card1.setOnClickListener(this);
        card1.setOnClickListener(this);
        card1.setOnClickListener(this);
        card1.setOnClickListener(this);
        card1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.h1 :
                i = new Intent(this, NewChatsActivity.class);
                startActivity(i);
                break;

            case R.id.h2 :
                i = new Intent(this, OldChatsActivity.class);
                startActivity(i);
                break;

            case R.id.h3 :
                i = new Intent(this, LessonsActivity.class);
                startActivity(i);
                break;

            case R.id.h4 :
                i = new Intent(this, ResetActivity.class);
                startActivity(i);
                break;

            case R.id.h5 :
                i = new Intent(this, HowToUseActivity.class);
                startActivity(i);
                break;

            case R.id.h6 :
                i = new Intent(this, AboutUsActivity.class);
                startActivity(i);
                break;
        }
    }

    */
}