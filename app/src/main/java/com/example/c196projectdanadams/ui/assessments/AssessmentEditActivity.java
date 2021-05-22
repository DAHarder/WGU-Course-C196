package com.example.c196projectdanadams.ui.assessments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.data.database.ScheduleRepository;
import com.example.c196projectdanadams.data.entity.AssessmentEntity;
import com.example.c196projectdanadams.data.entity.AssessmentType;
import com.example.c196projectdanadams.data.entity.CourseEntity;
import com.example.c196projectdanadams.ui.courses.CourseEditAssessmentListActivity;
import com.example.c196projectdanadams.util.DatePickerFragment;
import com.example.c196projectdanadams.util.DateUtils;

import java.util.List;

public class AssessmentEditActivity extends AppCompatActivity {
    private ScheduleRepository scheduleRepository;

    public static int courseIdAssEditPage = -1;
    public static int termIdAssEditPage = -1;

    int assessmentID;
    EditText assessmentTitle;
    RadioButton OARadio;
    RadioButton PARadio;
    EditText endDate;
    int courseID;

    AssessmentEntity currentAssessment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_edit);
        //Set Variables
        System.out.println(courseIdAssEditPage);
        courseIdAssEditPage = getIntent().getIntExtra("courseID", -1);
        assessmentID = getIntent().getIntExtra("assessmentID", -1);
        termIdAssEditPage = getIntent().getIntExtra("termID", -1);

        System.out.println(courseIdAssEditPage);

        //If not creating a new Entity, fills out current fields
        scheduleRepository = new ScheduleRepository((getApplication()));
        List<AssessmentEntity> allAssessments = scheduleRepository.getAllAssessments();

        for(AssessmentEntity assessment:allAssessments){
            if (assessment.getAssessmentID() == assessmentID)
                currentAssessment = assessment;
        }

        assessmentTitle = findViewById(R.id.assessment_title_edit);
        OARadio = findViewById(R.id.assessment_OA);
        PARadio = findViewById(R.id.assessment_PA);
        endDate = findViewById(R.id.assessment_end_date_edit);

        if (currentAssessment != null){
            assessmentTitle.setText(currentAssessment.getAssessmentTitle());
            switch (currentAssessment.getAssessmentType()){
                case OA:
                    OARadio.setChecked(true);
                    break;
                case PA:
                    PARadio.setChecked(true);
                    break;
            }
            endDate.setText(currentAssessment.getEndDate().format(DateUtils.dtf));
        }
    }

    public void showDateClickerDialog(View view) {
        int viewID = view.getId();
        TextView datePickerView = findViewById(viewID);
        DialogFragment newFragment = new DatePickerFragment(datePickerView);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void addAssessmentFromScreen(View view) {
        AssessmentEntity assessment = null;

        if (assessmentID == -1) {
            List<AssessmentEntity> allAssessments = scheduleRepository.getAllAssessments();
            assessmentID = allAssessments.get(allAssessments.size() - 1).getAssessmentID();
            ++assessmentID;
        }
        if (OARadio.isChecked()) {
            assessment = new AssessmentEntity(assessmentID, assessmentTitle.getText().toString(), AssessmentType.OA, DateUtils.parseDate(endDate.getText().toString()),courseID);
        }
        else if (PARadio.isChecked()){
            assessment = new AssessmentEntity(assessmentID, assessmentTitle.getText().toString(), AssessmentType.PA, DateUtils.parseDate(endDate.getText().toString()),courseID);
        }
        scheduleRepository.insert(assessment);

        Intent intent = new Intent(AssessmentEditActivity.this, CourseEditAssessmentListActivity.class);
        startActivity(intent);
    }
}