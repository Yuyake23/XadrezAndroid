package com.example.xadrez;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Animation lado = AnimationUtils.loadAnimation(this, R.anim.subir);
        ImageView xadrez = findViewById(R.id.xadrez);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        xadrez.startAnimation(lado);

        new Handler().postDelayed(() -> {
            Class<?> otherClass = auth.getCurrentUser() == null ? LoginActivity.class : HomeActivity.class;
            Intent intent = new Intent(MainActivity.this, otherClass);
            startActivity(intent);
            finish();
        }, 500);
    }
}