package com.srisubhashp.teachingtodlersapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.res.ColorStateList.*;

public class LevelThree extends AppCompatActivity implements View.OnClickListener
{
    private TextView question, qCount;
    private ImageView imageVar;
    private Button option1, option2, option3, option4;
    private List<QuestionL3> question3List;
    int questionNum;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_level_one);
        super.onCreate(savedInstanceState);

        question = findViewById(R.id.textView2);
        qCount = findViewById(R.id.quest_num);
        imageVar=findViewById(R.id.imageView4);
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

        int x, y, i;

        // creating an array list that will hold the questions, answers, and correct answer
        question3List = new ArrayList<>();

        // assigning values through constructor

        //Question 1
        question3List.add(new QuestionL3("What is this?",R.drawable.apple,"Apple", "Orange", "Cherry", "Kiwi", 1));

        //Question 2
        question3List.add(new QuestionL3("What is this?",R.drawable.chicken, "Cat", "Dog", "Chicken", "Egg",3));

        //Question 3
        question3List.add(new QuestionL3("What is this?",R.drawable.dog, "Fox", "Dog", "Cat", "Raccoon",2));

        //Question 4
        question3List.add(new QuestionL3("What is this?",R.drawable.horse, "Cow", "Horse", "Wheat", "Donkey",2));

        //Question 5
        question3List.add(new QuestionL3("What is this?",R.drawable.cow, "Milk", "Farm", "Cow", "Bucket",3));

        //Question 6
        question3List.add(new QuestionL3("What is this?",R.drawable.key, "Key", "Door", "Lock", "House",1));

        //Question 7
        question3List.add(new QuestionL3("What is this?",R.drawable.bread, "Bread", "Sandwich", "Knife", "Butter",1));

        //Question 8
        question3List.add(new QuestionL3("What is this?",R.drawable.pen, "Pen", "Pencil", "Eraser", "Stick",1));

        //Question 9
        question3List.add(new QuestionL3("What is this?",R.drawable.door, "Door", "Room", "House", "Window",1));

        //Question 10
        question3List.add(new QuestionL3("What is this?",R.drawable.cup, "Fork", "Plate", "Bowl", "Cup",4));

        //Question 11
        question3List.add(new QuestionL3("What is this?",R.drawable.tree, "Sky", "Grass", "Bush", "Tree",4));

        //Question 12
        question3List.add(new QuestionL3("What is this?",R.drawable.lamp, "Table", "Room", "House", "Lamp",4));

        //Question 13
        question3List.add(new QuestionL3("What is this?",R.drawable.bed, "Bed", "Tent", "T-Shirt", "Pants", 1));

        //Question 14
        question3List.add(new QuestionL3("What is this?",R.drawable.bike, "Motorcycle", "Bicycle", "Scooter", "Skateboard",2));

        //Question 15
        question3List.add(new QuestionL3("What is this?",R.drawable.banana, "Orange", "Apple", "Banana", "Watermelon", 3));

        // setting the questions
        setQuestion();
    }

    private void setQuestion()
    {
        // transferring question elements ot display
        question.setText(question3List.get(0).getQuestion());

        Drawable drawable=getResources().getDrawable(question3List.get(0).getImageId());
        imageVar.setImageDrawable(drawable);
        //imageVar.setImageResource(R.drawable.color_1);
        option1.setText(question3List.get(0).getOptionA());
        option2.setText(question3List.get(0).getOptionB());
        option3.setText(question3List.get(0).getOptionC());
        option4.setText(question3List.get(0).getOptionD());

        // displays what question we are on
        qCount.setText(String.valueOf(1) + "/" + String.valueOf(question3List.size()));

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
        if(selectedOption == question3List.get(questionNum).getCorrectAnswer())
        {
            // user clicked the correct question

            // increment correct number of answers
            correctAnswers++;

            // set button color to green
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        }
        else
        {
            // the user clicked the wrong answer

            // set incorrect button color to red
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));


            // set correct button color to green
            switch (question3List.get(questionNum).getCorrectAnswer())
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
        if (questionNum < question3List.size()-1)
        {
            // update question
            questionNum++;

            // animation that will change the question
            tranAnim(question, 0, 0, 1);
            tranAnim(imageVar,0,1,1);
            tranAnim(option1, 0, 2, 2);
            tranAnim(option2, 0, 3, 2);
            tranAnim(option3, 0, 4, 2);
            tranAnim(option4, 0, 5,2);


            qCount.setText(String.valueOf(questionNum+1) + "/" + String.valueOf(question3List.size()));

        }
        else // we are done with the questions
        {
            // we will display the score activity
            Intent intent = new Intent(LevelThree.this,ScoreActivity.class);
            intent.putExtra("SCORE", String.valueOf(correctAnswers) + "/" + String.valueOf(question3List.size()));
            startActivity(intent);
            LevelThree.this.finish();
        }
    }

    // animation for program
    private void tranAnim(View view, final int value, int viewNum, int category)
    {
        if(category == 2)
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
                            if (value == 0) {
                                switch (viewNum) {
                                    // if view number is 0 then it is a question
                                    case 0:
                                        ((TextView) view).setText(question3List.get(questionNum).getQuestion());
                                        break;
                                    case 1:
                                        ((ImageView) view).setImageResource(question3List.get(questionNum).getImageId());
                                        break;
                                    case 2:
                                        ((Button) view).setText(question3List.get(questionNum).getOptionA());
                                        break;
                                    case 3:
                                        ((Button) view).setText(question3List.get(questionNum).getOptionB());
                                        break;
                                    case 4:
                                        ((Button) view).setText(question3List.get(questionNum).getOptionC());
                                        break;
                                    case 5:
                                        ((Button) view).setText(question3List.get(questionNum).getOptionD());
                                        break;
                                }


                                if (viewNum != 0)
                                    ((Button) view).setBackgroundTintList(valueOf(Color.parseColor("#FFFFFF")));


                                tranAnim(view, 1, viewNum, category);
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
        else
        {
            {
                view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                        .setStartDelay(500).setInterpolator(new DecelerateInterpolator())
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                if (value == 0) {
                                    switch (viewNum) {
                                        // if view number is 0 then it is a question
                                        case 0:
                                            ((TextView) view).setText(question3List.get(questionNum).getQuestion());
                                            break;
                                        case 1:
                                            ((ImageView) view).setImageResource(question3List.get(questionNum).getImageId());
                                            break;
                                        case 2:
                                            ((Button) view).setText(question3List.get(questionNum).getOptionA());
                                            break;
                                        case 3:
                                            ((Button) view).setText(question3List.get(questionNum).getOptionB());
                                            break;
                                        case 4:
                                            ((Button) view).setText(question3List.get(questionNum).getOptionC());
                                            break;
                                        case 5:
                                            ((Button) view).setText(question3List.get(questionNum).getOptionD());
                                            break;
                                    }

                                    if (viewNum != 0 && viewNum!=1)
                                        ((Button) view).setBackgroundTintList(valueOf(Color.parseColor("#FFFFFF")));


                                    tranAnim(view, 1, viewNum, category);
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

    }
}