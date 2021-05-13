package com.example.c196projectdanadams.ui.terms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.ui.HomePageActivity;

public class TermListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
    }

    public void goToTermEditCourseList(View view) {
        Intent intent = new Intent(TermListActivity.this, TermEditCourseListActivity.class);
        startActivity(intent);
    }
}