package com.example.rapidmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timerText,question,score,remark;
    Button btn0,btn1,btn2,btn3,btn4,btn5;
    int correctTag;
    int i,j=0;
    ArrayList<Integer> answers = new ArrayList<>();
    public void onClick(View view){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setVisibility(View.INVISIBLE);
        btn0.setVisibility(View.INVISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        timerText.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        score.setText("0/0");
        new CountDownTimer(30000 + 100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText(Long.toString(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                btn5.setVisibility(View.VISIBLE);
                i=0;
                j=0;
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                remark.setText("Game Over");
            }
        }.start();
        setRand();
    }
    public void setRand(){
        Random rand = new Random();
        int num1 = rand.nextInt(20)+1;
        int num2 = rand.nextInt(20)+1;
        int sum = num1+num2;
        question.setText(Integer.toString(num1) + "+" + Integer.toString(num2));
        correctTag = rand.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==correctTag){
                answers.add(sum);
            }
            else{
                int wrongAnswer = rand.nextInt(39)+2;
                if(wrongAnswer == sum){
                    wrongAnswer = rand.nextInt(39)+2;
                }
                answers.add(wrongAnswer);
            }
        }
        btn1.setText(Integer.toString(answers.get(0)));
        btn2.setText(Integer.toString(answers.get(1)));
        btn3.setText(Integer.toString(answers.get(2)));
        btn4.setText(Integer.toString(answers.get(3)));
        answers.clear();
    }
    public void Game(View view){
        remark.setVisibility(View.VISIBLE);
        Log.i("Clicked Tag", view.getTag().toString());
        Log.i("Correct Tag", Integer.toString(correctTag));
        if(Integer.parseInt(view.getTag().toString())==correctTag) {
            remark.setText("Correct :)");
            i++;
        }
        else{
            remark.setText("Wrong :(");
            }
        j++;
        score.setText(Integer.toString(i) + "/" + Integer.toString(j));
        setRand();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerText =findViewById(R.id.timerText);
        question =findViewById(R.id.question);
        score =findViewById(R.id.score);
        remark =findViewById(R.id.remark);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
    }
}
