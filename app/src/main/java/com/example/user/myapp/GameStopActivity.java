package com.example.user.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameStopActivity extends AppCompatActivity {

    private String score = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        score = extras.getString("Score");

        setContentView(R.layout.gamestop);
        initStopButton();
        initreturnButton();
        initText();
    }
    private void initStopButton() {
        Button button = (Button)findViewById(R.id.button_stop);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                System.exit(0);
            }
        });
    }
    private void initreturnButton() {
        Button button = (Button)findViewById(R.id.button_return);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                jump();
            }
        });
    }

    private void jump(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void initText(){
        TextView text = (TextView)findViewById(R.id.textView_score);
        text.setText(score);
    }
}
