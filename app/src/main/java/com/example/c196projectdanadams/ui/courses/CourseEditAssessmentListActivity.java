package com.example.c196projectdanadams.ui.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.ui.assessments.AssessmentEditActivity;
import com.example.c196projectdanadams.ui.terms.TermEditCourseListActivity;

public class CourseEditAssessmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_edit_assessment_list);
    }

    public void goToAssessmentEdit(View view) {
        Intent intent = new Intent(CourseEditAssessmentListActivity.this, AssessmentEditActivity.class);
        startActivity(intent);
    }
}