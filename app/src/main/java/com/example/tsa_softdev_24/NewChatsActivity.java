package com.example.tsa_softdev_24;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



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

                HashMap<String, String> request = new HashMap<>();
                request.put("tone", current_tone);
                request.put("recipient", current_recipient);
                request.put("message", current_question);
                request.put("setting", current_setting);

                String tosend;
                ObjectMapper request2 = new ObjectMapper();
                try {
                    tosend = request2.writeValueAsString(request);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

                ChatData current = new ChatData(current_tone, current_recipient, current_setting, current_question);
                URL url = null;
                try {
                    url = new URL("127.0.0.1:1800");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }




                HttpURLConnection conn = null;
                try {
                    conn = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    conn.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    throw new RuntimeException(e);
                }
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("User-Agent", "Mozilla/5.0");

                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(tosend);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                //out.writeBytes(tosend);

                /*
                try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
                    out.writeBytes(tosend);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                 */

                try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = bf.readLine()) != null) {
                        Log.i("debug: ", line);
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