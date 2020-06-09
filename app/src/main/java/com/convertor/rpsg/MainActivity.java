package com.convertor.rpsg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String Tag = "MainActivity";
    TextView userSelectionTextView, compSelectionTextView, wonlostTieTextView,userscoreTextView,compscoreTextView;
    int userScore = 0, compScore = 0;
    Random random;
private TextView ys,cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userSelectionTextView = findViewById(R.id.userSelectionTextView);
        compSelectionTextView = findViewById((R.id.compSelectionTextView));
        wonlostTieTextView = findViewById(R.id.wonlostTieTextView);
        userSelectionTextView.setText(" ");
        compSelectionTextView.setText((" "));
        wonlostTieTextView.setText((" "));
        random = new Random();
        ys=findViewById(R.id.userscoreTextView);
        cs=findViewById(R.id.compscoreTextView);
    }

    public void resetButton(View view) {
wonlostTieTextView.setText((" "));
userSelectionTextView.setText(" ");
compSelectionTextView.setText(" ");
userScore=0;
compScore=0;

    }

    public void rpsButtonSelected(View view) {
        int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(Tag, "rpsButtonSelected:" + userSelection);
        matchGame(userSelection);
    }

    private void matchGame(int userSelection) {
        int low = 1;
        int high = 3;
        int compSelection = random.nextInt(high) + low;
        if (userSelection == compSelection) {
            //TIE
            wonlostTieTextView.setText("TIE");
        } else if ((userSelection == 1 && compSelection == 3)) {
            //User win
            userScore = userScore + 1;
            wonlostTieTextView.setText(("YOU WON"));
        } else if ((userSelection == 1 && compSelection == 2)) {
            //Comp win
            compScore = compScore + 1;
            wonlostTieTextView.setText(("COMP WON"));

        } else if (userSelection == 2 && compSelection == 1) {

            //User win
            userScore = userScore + 1;
            wonlostTieTextView.setText(("YOU WON"));
        } else if (userSelection == 2 && compSelection == 3) {
            //Comp win
            compScore = compScore + 1;
            wonlostTieTextView.setText(("COMP WON"));
        } else if (userSelection == 3 && compSelection == 1) {

            compScore = compScore + 1;
            wonlostTieTextView.setText(("COMP WON"));
        } else {


            userScore = userScore + 1;
            wonlostTieTextView.setText(("YOU WON"));
        }

        switch (userSelection) {
            case 1:
                userSelectionTextView.setText("ROCK");
                break;
            case 2:
                userSelectionTextView.setText("PAPER");
                break;
            case 3:
                userSelectionTextView.setText("Scissors");
                break;
        }
        switch (compSelection) {
            case 1:
                compSelectionTextView.setText("ROCK");
                break;
            case 2:
                compSelectionTextView.setText("PAPER");
                break;
            case 3:
                compSelectionTextView.setText("Scissors");
                break;
        }
            ys.setText(String.valueOf(userScore));
            cs.setText(String.valueOf(compScore));
    }

    }

