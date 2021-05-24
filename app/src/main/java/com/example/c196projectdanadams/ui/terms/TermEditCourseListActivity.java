package com.example.c196projectdanadams.ui.terms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.data.database.ScheduleRepository;
import com.example.c196projectdanadams.data.entity.CourseEntity;
import com.example.c196projectdanadams.data.entity.TermEntity;
import com.example.c196projectdanadams.ui.courses.CourseEditAssessmentListActivity;
import com.example.c196projectdanadams.util.DatePickerFragment;
import com.example.c196projectdanadams.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TermEditCourseListActivity extends AppCompatActivity {
    private ScheduleRepository scheduleRepository;

    int id;
    String title;
    LocalDate startDate;
    LocalDate endDate;
    EditText editTitle;
    EditText editStartDate;
    EditText editEndDate;

    TermEntity currentTerm;

    public static int numCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_edit_course_list);

        Button addCourseBtn = (Button) findViewById(R.id.addCourse);


//------Fill Term Edit Fields if editing a Term-----------------//
        id=getIntent().getIntExtra("termID", -1);
        if(id == -1)
            id = CourseEditAssessmentListActivity.termID;
        scheduleRepository = new ScheduleRepository(getApplication());
        List<TermEntity> allTerms = scheduleRepository.getAllTerms();

        for(TermEntity term:allTerms){
            if(term.getTermID() == id)
                currentTerm = term;
        }

        editTitle = findViewById(R.id.term_name_edit);
        editStartDate = findViewById(R.id.term_start_date_edit);
        editEndDate = findViewById(R.id.term_end_date_edit);

        if(currentTerm != null){
            title = currentTerm.getTermTitle();
            startDate = currentTerm.getStartDate();
            endDate = currentTerm.getEndDate();
        }
        else
            addCourseBtn.setVisibility(View.GONE);
        if(id != -1){
            editTitle.setText(title);
            editStartDate.setText(startDate.format(DateUtils.dtf));
            editEndDate.setText(endDate.format(DateUtils.dtf));
        }

//------Set and show associated Courses-----------------//
        scheduleRepository = new ScheduleRepository(getApplication());
        RecyclerView recyclerView = findViewById(R.id.course_recyclerview);
        final TermEditCourseListAdapter adapter = new TermEditCourseListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CourseEntity> filteredCourseEntityList = new ArrayList<>();
        for(CourseEntity course: scheduleRepository.getAllCourses()){
            if (course.getTermID() == id)
                filteredCourseEntityList.add(course);
        }
        numCourses = filteredCourseEntityList.size();
        adapter.setCourses(filteredCourseEntityList);
    }

    public void goToCourseEditAssessmentList(View view) {
        Intent intent = new Intent(TermEditCourseListActivity.this, CourseEditAssessmentListActivity.class);
        intent.putExtra("termID", id);
        startActivity(intent);
    }

    public void addTermFromScreen(View view) {
        TermEntity term;

        if (id != -1)
            term = new TermEntity(id, editTitle.getText().toString(), DateUtils.parseDate(editStartDate.getText().toString()), DateUtils.parseDate(editEndDate.getText().toString()));
        else {
            List<TermEntity> allTerms = scheduleRepository.getAllTerms();
            id = allTerms.get(allTerms.size() - 1).getTermID();
            term = new TermEntity(++id, editTitle.getText().toString(), DateUtils.parseDate(editStartDate.getText().toString()), DateUtils.parseDate(editEndDate.getText().toString()));
        }
        scheduleRepository.insert(term);

        Intent intent = new Intent(TermEditCourseListActivity.this, TermListActivity.class);
        startActivity(intent);
    }

    public void showDateClickerDialog(View view) {
        int viewID = view.getId();
        TextView datePickerView = findViewById(viewID);
        DialogFragment newFragment = new DatePickerFragment(datePickerView);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}