package com.srisubhashp.teachingtodlersapp;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.content.res.ColorStateList.*;

public class LevelOne extends AppCompatActivity implements View.OnClickListener
{
    private TextView question, qCount;
    private ImageView imageVar;
    private Button option1, option2, option3, option4;
    private List<QuestionL1> questionL1List;
    private FirebaseFirestore firestore;

    int questionNum;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_level_one);
        super.onCreate(savedInstanceState);

        firestore=FirebaseFirestore.getInstance();

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

        firestore= FirebaseFirestore.getInstance();

        getQuestionsList();

    }

    private void getQuestionsList()
    {

        int x, y, i;
        int k;

        // creating an array list that will hold the questions, answers, and correct answer
        questionL1List = new ArrayList<>();

        firestore.collection("Todlers-Quiz").document("QuizQuestions").collection("Level1").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful())
                {
                    QuerySnapshot questionListfb =task.getResult();

                    for(QueryDocumentSnapshot doc: questionListfb)
                    {
                        questionL1List.add(new QuestionL1(doc.getString("question"),
                                R.drawable.pink,
                                doc.getString("optionA"),
                                doc.getString("optionB"),
                                doc.getString("optionC"),
                                doc.getString("optionD"),
                                Integer.valueOf(doc.getString("correctAnswer"))
                        ));
                    }
                    setQuestion();
                }
                else
                {
                    Toast.makeText(LevelOne.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });

        // assigning values through constructor
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.pink,"Pink", "Blue", "Red", "Orange", 1));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.red, "Blue", "Pink", "Orange", "Red", 4));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.blue, "Green", "Yellow", "Blue", "Orange", 3));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.brown, "Black", "Brown", "Orange", "Red",2));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.purple, "Pink", "Blue", "Green", "Purple",4));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.green, "Green", "Orange", "Blue", "Purple",1));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.black, "Brown", "Black", "Gray", "Blue",2));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.gray, "Black", "Brown", "Gray", "Pink",3));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.maroon, "Red", "Purple", "Maroon", "Magenta",3));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.yellow, "Yellow", "Orange", "Red", "Purple",1));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.turquoise, "Blue", "Turquoise", "Green", "Sea Green",2));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.magenta, "Red", "Purple", "Magenta", "Maroon",3));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.peach, "Orange", "Pink", "Red", "Peach",4));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.tan, "Tan", "Yellow", "Brown", "Orange",1));
//        questionL1List.add(new QuestionL1("What color is this?",R.drawable.orange, "Brown", "Tan", "Orange", "Beige",3));

        // setting the questions

    }

    private void setQuestion()
    {
        // transferring question elements ot display
        question.setText(questionL1List.get(0).getQuestion());

        Drawable drawable=getResources().getDrawable(questionL1List.get(0).getImageId());
        imageVar.setImageDrawable(drawable);
        option1.setText(questionL1List.get(0).getOptionA());
        option2.setText(questionL1List.get(0).getOptionB());
        option3.setText(questionL1List.get(0).getOptionC());
        option4.setText(questionL1List.get(0).getOptionD());

        // displays what question we are on
        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionL1List.size()));

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
        if(selectedOption == questionL1List.get(questionNum).getCorrectAnswer())
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
            switch (questionL1List.get(questionNum).getCorrectAnswer())
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
        if (questionNum < questionL1List.size()-1)
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


            qCount.setText(String.valueOf(questionNum+1) + "/" + String.valueOf(questionL1List.size()));

        }
        else // we are done with the questions
        {
            // we will display the score activity
            Intent intent = new Intent(LevelOne.this,ScoreActivity.class);
            intent.putExtra("SCORE", String.valueOf(correctAnswers) + "/" + String.valueOf(questionL1List.size()));
            startActivity(intent);
            LevelOne.this.finish();
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
                                        ((TextView) view).setText(questionL1List.get(questionNum).getQuestion());
                                        break;
                                    case 1:
                                        ((ImageView) view).setImageResource(questionL1List.get(questionNum).getImageId());
                                        break;
                                    case 2:
                                        ((Button) view).setText(questionL1List.get(questionNum).getOptionA());
                                        break;
                                    case 3:
                                        ((Button) view).setText(questionL1List.get(questionNum).getOptionB());
                                        break;
                                    case 4:
                                        ((Button) view).setText(questionL1List.get(questionNum).getOptionC());
                                        break;
                                    case 5:
                                        ((Button) view).setText(questionL1List.get(questionNum).getOptionD());
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
                                            ((TextView) view).setText(questionL1List.get(questionNum).getQuestion());
                                            break;
                                        case 1:
                                            ((ImageView) view).setImageResource(questionL1List.get(questionNum).getImageId());
                                            break;
                                        case 2:
                                            ((Button) view).setText(questionL1List.get(questionNum).getOptionA());
                                            break;
                                        case 3:
                                            ((Button) view).setText(questionL1List.get(questionNum).getOptionB());
                                            break;
                                        case 4:
                                            ((Button) view).setText(questionL1List.get(questionNum).getOptionC());
                                            break;
                                        case 5:
                                            ((Button) view).setText(questionL1List.get(questionNum).getOptionD());
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