package com.example.spiderhackathonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button drive,reset;
    View carView,gameView;
    Boolean draw = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drive = findViewById(R.id.drive);
        reset = findViewById(R.id.reset);
        carView = findViewById(R.id.carView);
        gameView = findViewById(R.id.gameView);

        gameView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (draw){
                    gameView.invalidate();
                }
                return false;
            }
        });

        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carView.setVisibility(View.VISIBLE);
                draw = false;
                carView.invalidate();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw = true;
                GameView.path = new Path();
                gameView.invalidate();
                carView.setVisibility(View.INVISIBLE);
            }
        });
    }
}