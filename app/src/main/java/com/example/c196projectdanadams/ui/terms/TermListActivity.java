package com.example.c196projectdanadams.ui.terms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.data.database.ScheduleRepository;
import com.example.c196projectdanadams.ui.courses.CourseEditAssessmentListActivity;

public class TermListActivity extends AppCompatActivity {

    private ScheduleRepository scheduleRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CourseEditAssessmentListActivity.termID = -1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        scheduleRepository = new ScheduleRepository(getApplication());
        scheduleRepository.getAllTerms();

        RecyclerView recyclerView = findViewById(R.id.term_recyclerview);

        final TermAdapter adapter = new TermAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setTerms(scheduleRepository.getAllTerms());

    }

    public void goToTermEditCourseList(View view) {
        Intent intent = new Intent(TermListActivity.this, TermEditCourseListActivity.class);
        startActivity(intent);
    }
}