package com.example.tsa_softdev_24;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Old3 extends AppCompatActivity {
    public TextView box1_3, box2_3, box3_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_old3);


        box1_3 = findViewById(R.id.old3_prompt1);
        box2_3 = findViewById(R.id.old3_prompt2);
        box3_3 = findViewById(R.id.old3_prompt3);
        OldChatsTemplateActivity.updateData(OldChatsTemplateActivity.Chat2, box1_3, box2_3, box3_3);
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         */
    }
}