package com.example.tsa_softdev_24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewChatsActivity extends AppCompatActivity {
    public CardView answer;
    public String url = "http:/10.0.2.2:1800/";

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


                Runnable runnable = new Runnable() {
                    public void run() {
                        OkHttpClient client = new OkHttpClient();

                        FormBody formBody = new FormBody.Builder()
                                .add("tone", current_tone)
                                .add("recipent", current_recipient)
                                .add("message", current_question)
                                .add("setting", current_setting)
                                .build();



                        Request builder = new Request.Builder()
                                .header("Content-Type", "application/json")
                                .header("User-Agent", "Mozilla/5.0")
                                .url(url)
                                .post(formBody)
                                .build();

                        try {
                            Response response = client.newCall(builder).execute();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                Intent intent = new Intent(NewChatsActivity.this, Old1.class);
                startActivity(intent);



                };
            });
        }
    }
















