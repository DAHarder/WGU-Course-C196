package com.example.c196projectdanadams.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.ui.terms.TermListActivity;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTermList(View view) {
        Intent intent = new Intent(HomePageActivity.this, TermListActivity.class);
        startActivity(intent);
    }
}