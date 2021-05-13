package com.example.c196projectdanadams.ui.terms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.ui.courses.CourseEditAssessmentListActivity;
import com.example.c196projectdanadams.util.DatePickerFragment;

public class TermEditCourseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_edit_course_list);
    }

    public void goToCourseEditAssessmentList(View view) {
        Intent intent = new Intent(TermEditCourseListActivity.this, CourseEditAssessmentListActivity.class);
        startActivity(intent);
    }

    public void showDateClickerDialog(View view) {
        int viewID = view.getId();
        TextView datePickerView = findViewById(viewID);
        DialogFragment newFragment = new DatePickerFragment(datePickerView);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}