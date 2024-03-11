package com.example.tsa_softdev_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class NewChatsActivity extends AppCompatActivity {
    public CardView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_chats);

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         */

        // Find the CardView by its ID
        answer = (CardView) findViewById(R.id.ans);

        // Set an OnClickListener for Lesson1
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String body = "{\"name\": \"Apple iPad Air\", \"data\": { \"Generation\": \"4th\", \"Price\": \"519.99\", \"Capacity\": \"256 GB\" }}";
                EditText t1, t2, t3, t4;

                t1 = findViewById(R.id.answer1);
                t2 = findViewById(R.id.answer2);
                t3 = findViewById(R.id.answer3);
                t4 = findViewById(R.id.answer4);

                String current_tone = t1.getText().toString();
                String current_recipient = t2.getText().toString();
                String current_setting = t3.getText().toString();
                String current_question = t4.getText().toString();

                ChatData current = new ChatData(current_tone, current_recipient, current_setting, current_question);
                URL url = null;
                try {
                    url = new URL("127.0.0.1:1800");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                HttpsURLConnection conn = null;
                try {
                    conn = (HttpsURLConnection) url.openConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    conn.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    throw new RuntimeException(e);
                }
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("User-Agent", "Mozilla/5.0");

                try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                    dos.writeBytes(current.toJSON());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = bf.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                // Start the new activity
                //Intent intent = new Intent(NewChatsActivity.this, OldChats2Activity.class);
                //startActivity(intent);
            }
        });


    }
}