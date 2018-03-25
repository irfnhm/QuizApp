package com.example.irfan.quizapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int finalScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Clears answers for all the questions.
    * This function can be called anywhere, it's needed.*/
    private void reset(){

        //Clear answer values for question one
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.questionOneRadioGroup);
        rg1.clearCheck();

        //Clear answer value for question two
        EditText et = (EditText) findViewById(R.id.image_answer);
        et.setText("");

        //Clear answer values for question three
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.questionThreeRadioGroup);
        rg3.clearCheck();

        //Clear answer values for question four
        RadioGroup rg4 = (RadioGroup) findViewById(R.id.questionFourRadioGroup);
        rg4.clearCheck();

        //Clear answer values for question five
        RadioGroup rg5 = (RadioGroup) findViewById(R.id.questionFiveRadioGroup);
        rg5.clearCheck();

        //Clear answer values for question six
        RadioGroup rg6 = (RadioGroup) findViewById(R.id.questionSixRadioGroup);
        rg6.clearCheck();

        //Clear answer values for question seven
        RadioGroup rg7 = (RadioGroup) findViewById(R.id.questionSevenRadioGroup);
        rg7.clearCheck();

        //Clear answer values for question eight
        RadioGroup rg8 = (RadioGroup) findViewById(R.id.questionEightRadioGroup);
        rg8.clearCheck();

        //Clear answer values for question nine
        RadioGroup rg9 = (RadioGroup) findViewById(R.id.questionNineRadioGroup);
        rg9.clearCheck();

        //Clear answer values for question ten
        CheckBox cb1 =  (CheckBox) findViewById(R.id.q_ten_a);
        cb1.setChecked(false);

        CheckBox cb2 =  (CheckBox) findViewById(R.id.q_ten_b);
        cb2.setChecked(false);

        CheckBox cb3 =  (CheckBox) findViewById(R.id.q_ten_c);
        cb3.setChecked(false);

        CheckBox cb4 =  (CheckBox) findViewById(R.id.q_ten_d);
        cb4.setChecked(false);

        CheckBox cb5 =  (CheckBox) findViewById(R.id.q_ten_e);
        cb5.setChecked(false);
    }

    /* Submits the answers
    evaluates the questions
    displays final score
    resets the answers
     */
    public void submitGame(View view){
        //Evaluate question one
        RadioButton rb1 = (RadioButton) findViewById(R.id.q_one_b);
        if(rb1.isChecked()) finalScore += 1;

        EditText et = (EditText) findViewById(R.id.image_answer);
        String answer = et.getText().toString();
        if (answer.equals("sophia") || answer.equals("Sophia") || answer.equals("SOPHIA")) finalScore += 1;

        RadioButton rb3 = (RadioButton) findViewById(R.id.q_three_b);
        if(rb3.isChecked()) finalScore += 1;

        RadioButton rb4 = (RadioButton) findViewById(R.id.q_four_a);
        if(rb4.isChecked()) finalScore += 1;

        RadioButton rb5 = (RadioButton) findViewById(R.id.q_five_b);
        if(rb5.isChecked()) finalScore += 1;

        RadioButton rb6 = (RadioButton) findViewById(R.id.q_six_c);
        if(rb6.isChecked()) finalScore += 1;

        RadioButton rb7 = (RadioButton) findViewById(R.id.q_seven_c);
        if(rb7.isChecked()) finalScore += 1;

        RadioButton rb8 = (RadioButton) findViewById(R.id.q_eight_b);
        if (rb8.isChecked()) finalScore += 1;

        RadioButton rb9 = (RadioButton) findViewById(R.id.q_nine_a);
        if(rb9.isChecked()) finalScore += 1;

        CheckBox cb1 = (CheckBox) findViewById(R.id.q_ten_a);
        CheckBox cb2 = (CheckBox) findViewById(R.id.q_ten_b);
        CheckBox cb3 = (CheckBox) findViewById(R.id.q_ten_e);
        if (cb1.isChecked() && cb2.isChecked() && cb3.isChecked()) finalScore += 1;

        //Toast.makeText(MainActivity.this, "Your Score is:" + finalScore, Toast.LENGTH_LONG).show();
        final Toast myToast = Toast.makeText(MainActivity.this, "Your score is: " + finalScore, Toast.LENGTH_SHORT);
        myToast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myToast.cancel();
            }
        }, 7000);
    }

    //Reset Button
    public void resetGame(View view){
        //Reset score
        finalScore = 0;

        //Clear answers
        reset();
    }
}
