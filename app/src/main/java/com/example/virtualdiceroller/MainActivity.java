package com.example.virtualdiceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private MediaPlayer mediaPlayer;
    private TextView textView2;
    private final static int max = 6;
    private final static int min = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        mediaPlayer = MediaPlayer.create(this,R.raw.diceroller);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                imageView.startAnimation(anim);
                mediaPlayer.start();
                int x = (int) Math.floor(Math.random()*(max-min+1)+min);
                if(x == 1){
                    imageView.setImageResource(R.drawable.dice1);
                }
                else if(x == 2){
                    imageView.setImageResource(R.drawable.dice2);
                }
                else if(x == 3){
                    imageView.setImageResource(R.drawable.dice3);
                }
                else if(x == 4){
                    imageView.setImageResource(R.drawable.dice4);
                }
                else if(x == 5){
                    imageView.setImageResource(R.drawable.dice5);
                }
                else if(x == 6){
                    imageView.setImageResource(R.drawable.dice6);
                }
                textView2.setText(String.valueOf(x));
            }
        });
    }
}