package com.mtc.baseballquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;
    Button calculate;
    RadioButton rbPlayers;
    RadioButton rbFoulBall;
    RadioButton rbStrikes;
    RadioButton rbGreatBambino;
    CheckBox cbGrandSlam;
    CheckBox cbDoublePlay;
    CheckBox cbTouchdown;
    CheckBox cbEndZone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = (Button) findViewById(R.id.scoreButton);

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                baseballPlayers();
                foulBall();
                numberStrikes();
                greatBambino();
                homeRun();

                Context context = getApplicationContext();
                CharSequence text = "Your score is: " + score + "/7";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                testClear();

                //Question 1-4 Reset

                ((RadioGroup) findViewById(R.id.radioGroup1)).clearCheck();
                ((RadioGroup) findViewById(R.id.radioGroup2)).clearCheck();
                ((RadioGroup) findViewById(R.id.radioGroup3)).clearCheck();
                ((RadioGroup) findViewById(R.id.radioGroup4)).clearCheck();

                //Question 5 Reset

                cbGrandSlam = (CheckBox) findViewById(R.id.grandSlam);
                cbDoublePlay = (CheckBox) findViewById(R.id.doublePlay);
                cbTouchdown = (CheckBox) findViewById(R.id.touchdown);
                cbEndZone = (CheckBox) findViewById(R.id.endZone);

                if (cbGrandSlam.isChecked()) {
                    cbGrandSlam.toggle();
                }

                if (cbDoublePlay.isChecked()) {
                    cbDoublePlay.toggle();
                }
                if (cbTouchdown.isChecked()) {
                    cbTouchdown.toggle();
                }

                if (cbEndZone.isChecked()) {
                    cbEndZone.toggle();

                }

                //Question 6 reset
                ((EditText) findViewById(R.id.homeRun)).setText("");
            }

        });
    }


    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        if(cbGrandSlam.isChecked() && cbDoublePlay.isChecked() && !cbEndZone.isChecked() && !cbTouchdown.isChecked()){

                score ++;

        }
    }


    public void baseballPlayers() {
        rbPlayers = (RadioButton) findViewById(R.id.nine);

        if (rbPlayers.isChecked()) {
            score ++;
        }
    }

    public void foulBall() {
        rbFoulBall = (RadioButton) findViewById(R.id.foul);

        if (rbFoulBall.isChecked()) {
            score ++;
        }
    }

    public void numberStrikes() {
        rbStrikes = (RadioButton) findViewById(R.id.threeStrikes);

        if (rbStrikes.isChecked()) {
            score ++;
        }
    }

    public void greatBambino() {
        rbGreatBambino = (RadioButton) findViewById(R.id.bambino);

        if (rbGreatBambino.isChecked()) {
            score ++;
        }
    }

    public void homeRun(){
        String answer;
        EditText etHomeRun = ((EditText) findViewById(R.id.homeRun));
        answer = etHomeRun.getText().toString().trim();

        if (answer.equalsIgnoreCase("homerun")){
            score++;
        }
    }

    public void testClear() {

        score = 0;
    }


}