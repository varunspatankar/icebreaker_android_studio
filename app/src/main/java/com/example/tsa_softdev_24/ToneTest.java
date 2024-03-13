package com.example.tsa_softdev_24;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ToneTest extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;

    int toneScore;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    String toneLabel;
    int score = 0;
    int totalQuestion = 5;
    public int currentQuestionIndex = 0;
    String selectedAnswer = "";


    String selectedanswers = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tone_test);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : " + totalQuestion);

        loadNewQuestion();

        ansA.setBackgroundColor(Color.LTGRAY);
        ansB.setBackgroundColor(Color.LTGRAY);
        ansC.setBackgroundColor(Color.LTGRAY);
        ansD.setBackgroundColor(Color.LTGRAY);


    }


    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.submit_btn) {
            currentQuestionIndex++;
            loadNewQuestion();

            if (!selectedAnswer.isEmpty()) {
                ansA.setBackgroundColor(Color.LTGRAY);
                ansB.setBackgroundColor(Color.LTGRAY);
                ansC.setBackgroundColor(Color.LTGRAY);
                ansD.setBackgroundColor(Color.LTGRAY);
            } else {
                // Show an alert indicating that the user needs to select an option
                new AlertDialog.Builder(this)
                        .setTitle("Please Select an Option")
                        .setMessage("You must select an option before proceeding to the next question.")
                        .setPositiveButton(android.R.string.ok, null)
                        .show();

                // Evaluate tone after the user selects an option
                score += evaluateTone(selectedAnswer);
            }
        } else {
            // Choices button clicked
            ansA.setBackgroundColor(Color.LTGRAY);
            ansB.setBackgroundColor(Color.LTGRAY);
            ansC.setBackgroundColor(Color.LTGRAY);
            ansD.setBackgroundColor(Color.LTGRAY);
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.DKGRAY);
        }
    }


    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
        } else {
            questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
            ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
            ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
            ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
            ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

        }
    }


    String displayTone(int score) {
        // Evaluate the tone based on the selected answers
        // Determine the tone label based on the tone score
        String tonelabel = "";
        if (score >= 16) {
            tonelabel = "Positive Tone";
        } else if (score >= 13) {
            tonelabel = "Optimistic Tone";
        } else if (score >= 12) {
            tonelabel = "Frustrated Tone";
        } else if (score >= 11) {
            tonelabel = "Active Tone";
        } else if (score >= 10) {
            tonelabel = "Ambivalent Tone";
        } else if (score >= 9) {
            tonelabel = "Neutral Tone";
        } else if (score >= 8) {
            tonelabel = "Indifferent Tone";
        } else if (score >= 7) {
            tonelabel = "Calm Tone";
        } else if (score >= 6) {
            tonelabel = "Reserved Tone";
        } else if (score >= 5) {
            tonelabel = "Reflective Tone";
        } else if (score >= 4) {
            tonelabel = "Negative Tone";
        } else if (score >= 3) {
            tonelabel = "Shy Tone";
        } else if (score >= 2) {
            tonelabel = "Anxious Tone";
        } else if (score >= 1) {
            tonelabel = "Introverted Tone";
        }
        return toneLabel;
    }

    void finishQuiz() {
        displayTone(evaluateTone(selectedanswers));
        float avg_score = score/5;
        displayTone(Math.round(avg_score));
        // Show the tone score and label in the completion dialog
        String passStatus = "COMPLETED! Your tone: " + toneLabel;

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setPositiveButton("Start Breaking Ice!", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }


    int evaluateTone(String selectedAnswer) {
        int questionScore = 0;
        switch (currentQuestionIndex) {
            case 0: // How was your day?
                switch (selectedAnswer) {
                    case "My day was great! I accomplished a lot of tasks and enjoyed some downtime as well.":
                        questionScore = 32;
                        break;
                    case "It was a tough day. Nothing seemed to go right.":
                        questionScore = 8;
                        break;
                    case "It was just another day, nothing special.":
                        questionScore = 18;
                        break;
                    case "I’d rather not talk about it.":
                        questionScore = 12;
                        break;
                    default:
                        break;
                }
                break;

            case 1: // What’s your favorite way to spend a weekend?
                switch (selectedAnswer) {
                    case "I love exploring the outdoors! Hiking, biking, you name it!":
                        questionScore = 36;
                        break;
                    case "Doesn’t really matter to me. Weekends are just like any other day.":
                        questionScore = 16;
                        break;
                    case "I enjoy spending time with my friends and family.":
                        questionScore = 2;
                        break;
                    case "I prefer to have some quiet time alone.":
                        questionScore = 26;
                        break;
                    default:
                        break;
                }
                break;

            case 2: // How do you handle stress?
                switch (selectedAnswer) {
                    case "I try to stay positive and look at the bright side of things.":
                        questionScore = 32;
                        break;
                    case "I tend to get overwhelmed and anxious.":
                        questionScore = 8;
                        break;
                    case "I usually go for a run or do some physical activity.":
                        questionScore = 18;
                        break;
                    case "I don’t usually get stressed.":
                        questionScore = 12;
                        break;
                    default:
                        break;
                }
                break;

            case 3: // What’s your approach to problem-solving?
                switch (selectedAnswer) {
                    case "I tackle it head-on and try to find a solution as quickly as possible.":
                        questionScore = 36;
                        break;
                    case "I take a step back and try to look at the bigger picture.":
                        questionScore = 16;
                        break;
                    case "I get frustrated and sometimes avoid dealing with it.":
                        questionScore = 2;
                        break;
                    case "I ask others for help or advice.":
                        questionScore = 26;
                        break;
                    default:
                        break;
                }
                break;

            case 4: // How do you feel about meeting new people?
                switch (selectedAnswer) {
                    case "I love it! It’s always exciting to meet new people.":
                        questionScore = 32;
                        break;
                    case "I’m a bit shy and reserved, so it can be challenging.":
                        questionScore = 8;
                        break;
                    case "It depends on the situation and the people.":
                        questionScore = 18;
                        break;
                    case "I prefer to stick with my close circle of friends.":
                        questionScore = 12;
                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }

        score += questionScore; // Update the overall score
        return questionScore;
    }




    public void restartQuiz() {
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
        Intent intent = new Intent(ToneTest.this, MainActivity.class);
        startActivity(intent);
    }



}