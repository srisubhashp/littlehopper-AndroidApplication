package com.srisubhashp.teachingtodlersapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.res.ColorStateList.*;

public class LevelTwo extends AppCompatActivity implements View.OnClickListener
{
    private TextView question, qCount;
    private Button option1, option2, option3, option4;
    private List<QuestionL2> questionL2List;
    int questionNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);

        question = findViewById(R.id.question);
        qCount = findViewById(R.id.quest_num);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        getQuestionsList();

    }

    private void getQuestionsList()
    {

        int x, y;

        // creating an array list that will hold the questions, answers, and correct answer
        questionL2List = new ArrayList<>();

        // assigning values through constructor
        questionL2List.add(new QuestionL2("What is 2 + 2?", "4", "3", "1", "2", 1));
        questionL2List.add(new QuestionL2("What is 2 x 3?", "7", "8", "6", "5", 3));
        questionL2List.add(new QuestionL2("What is 25 / 5?", "20", "30", "125", "5", 4));
        questionL2List.add(new QuestionL2("What is 8 - 6?", "2", "1", "14", "3", 1));
        questionL2List.add(new QuestionL2("What is 2 + 7?", "5", "9", "10", "4", 2));
        questionL2List.add(new QuestionL2("What is 2 + 2?", "4", "3", "1", "2", 1));
        questionL2List.add(new QuestionL2("What is 2 x 3?", "7", "8", "6", "5", 3));
        questionL2List.add(new QuestionL2("What is 25 / 5?", "20", "30", "125", "5", 4));
        questionL2List.add(new QuestionL2("What is 8 - 6?", "2", "1", "14", "3", 1));
        questionL2List.add(new QuestionL2("What is 2 + 7?", "5", "9", "10", "4", 2));
        questionL2List.add(new QuestionL2("What is 2 + 2?", "4", "3", "1", "2", 1));
        questionL2List.add(new QuestionL2("What is 2 x 3?", "7", "8", "6", "5", 3));
        questionL2List.add(new QuestionL2("What is 25 / 5?", "20", "30", "125", "5", 4));
        questionL2List.add(new QuestionL2("What is 8 - 6?", "2", "1", "14", "3", 1));
        questionL2List.add(new QuestionL2("What is 2 + 7?", "5", "9", "10", "4", 2));

        // setting the questions
        setQuestion();

    }

    private void setQuestion()
    {
        // transferring question elements ot display
        question.setText(questionL2List.get(0).getQuestion());
        option1.setText(questionL2List.get(0).getOptionA());
        option2.setText(questionL2List.get(0).getOptionB());
        option3.setText(questionL2List.get(0).getOptionC());
        option4.setText(questionL2List.get(0).getOptionD());

        // displays what question we are on
        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionL2List.size()));

        // initializing the number of questions we have done
        questionNum = 0;
    }

    // once you click on an option, this is where we store which option we chose
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v)
    {
        int selectedOption = 0;

        switch(v.getId())
        {
            case R.id.option1 :
                selectedOption = 1;
                break;

            case R.id.option2 :
                selectedOption = 2;
                break;

            case R.id.option3 :
                selectedOption = 3;
                break;

            case R.id.option4 :
                selectedOption = 4;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

        // check answer that we chose
        checkAnswer(selectedOption, v);

    }

    // checks the user's answer
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkAnswer(int selectedOption, View view)
    {
        if(selectedOption == questionL2List.get(questionNum).getCorrectAnswer())
        {
            // user clicked the correct question

            // set button color to green
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        }
        else
        {
            // the user clicked the wrong answer

            // set incorrect button color to red
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));


            // set correct button color to green
            switch (questionL2List.get(questionNum).getCorrectAnswer())
            {
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;

            }

        }

        // move onto next question
        changeQuestion();
    }

    // function changes the question
    private void changeQuestion()
    {
        // if we have questions remaining, then we will go to the next question
        if (questionNum < questionL2List.size()-1)
        {
            // update question
            questionNum++;

            // animation that will change the question
            tranAnim(question, 0, 0);
            tranAnim(option1, 0, 1);
            tranAnim(option2, 0, 2);
            tranAnim(option3, 0, 3);
            tranAnim(option4, 0, 4);

            qCount.setText(String.valueOf(questionNum+1) + "/" + String.valueOf(questionL2List.size()));

        }
        else // we are done with the questions
        {
            // we will display the score activity
            Intent intent = new Intent(LevelTwo.this,LevelTwoScoreActivity.class);
            startActivity(intent);
            LevelTwo.this.finish();
        }
    }

    // animation for program
    private void tranAnim(View view, final int value, int viewNum)
    {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(600)
                .setStartDelay(600).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(value == 0)
                        {
                            switch (viewNum)
                            {
                                // if view number is 0 then it is a question
                                case 0:
                                    ((TextView)view).setText(questionL2List.get(questionNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button)view).setText(questionL2List.get(questionNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button)view).setText(questionL2List.get(questionNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button)view).setText(questionL2List.get(questionNum).getOptionC());
                                    break;
                                case 4:
                                    ((Button)view).setText(questionL2List.get(questionNum).getOptionD());
                                    break;
                            }


                            if(viewNum != 0)
                                ((Button)view).setBackgroundTintList(valueOf(Color.parseColor("#E99C03")));


                            tranAnim(view,1,viewNum);

                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

    }
}