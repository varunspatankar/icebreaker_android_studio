package com.example.tsa_softdev_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HowToUseActivity extends AppCompatActivity {
    public CardView about1, about2, about3, about4, about5, about6, about7, about8, about9;

  //  about1 = (CardView) findViewById(R.id.abouttab1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_how_to_use);

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */

        about1 = (CardView) findViewById(R.id.abouttab1);
        about2 = (CardView) findViewById(R.id.abouttab2);
        about3 = (CardView) findViewById(R.id.abouttab3);
        about4 = (CardView) findViewById(R.id.abouttab4);
        about5 = (CardView) findViewById(R.id.abouttab5);
        about6 = (CardView) findViewById(R.id.abouttab6);
        about7 = (CardView) findViewById(R.id.abouttab7);

        about1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(HowToUseActivity.this, HomePageAbout.class);
                startActivity(intent);
            }
        });

        about2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(HowToUseActivity.this, ToneTestAbout.class);
                startActivity(intent);
            }
        });

        about3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(HowToUseActivity.this, NewChatsAbout.class);
                startActivity(intent);
            }
        });

        about4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(HowToUseActivity.this, PastChatsAbout.class);
                startActivity(intent);
            }
        });

        about5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(HowToUseActivity.this, LessonsAbout.class);
                startActivity(intent);
            }
        });

        about6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(HowToUseActivity.this, HowToUseAbout.class);
                startActivity(intent);
            }
        });

        about7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(HowToUseActivity.this, AboutUsAbout.class);
                startActivity(intent);
            }
        });
    }
}