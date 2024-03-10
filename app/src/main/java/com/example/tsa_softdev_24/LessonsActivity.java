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

public class LessonsActivity extends AppCompatActivity {
    public CardView lesson1, lesson2, lesson3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lessons);

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */




        // Find the CardView by its ID
        lesson1 = (CardView) findViewById(R.id.l1);
        lesson2 = (CardView) findViewById(R.id.l2);
        lesson3 = (CardView) findViewById(R.id.l3);

        // Set an OnClickListener for Lesson1
        lesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(LessonsActivity.this, Lesson1Activity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for Lesson2
        lesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(LessonsActivity.this, Lesson2Activity.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for Lesson3
        lesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(LessonsActivity.this, Lesson3Activity.class);
                startActivity(intent);
            }
        });

    }
}