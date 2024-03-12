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

public class OldChatsActivity extends AppCompatActivity {
    public CardView oldchat1, oldchat2, oldchat3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_old_chats);

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */

        // Find the CardView by its ID
        oldchat1 = (CardView) findViewById(R.id.old1);
        oldchat2 = (CardView) findViewById(R.id.old2);
        oldchat3 = (CardView) findViewById(R.id.old3);

        // Set an OnClickListener for Lesson1
        oldchat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(OldChatsActivity.this, Old1.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for Lesson1
        oldchat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(OldChatsActivity.this, Old2.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for Lesson1
        oldchat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(OldChatsActivity.this, Old3.class);
                startActivity(intent);
            }
        });
    }
}