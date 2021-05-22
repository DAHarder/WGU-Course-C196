package com.example.c196projectdanadams.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.c196projectdanadams.data.entity.AssessmentEntity;
import com.example.c196projectdanadams.data.entity.CourseEntity;

import java.util.List;

@Dao
public interface AssessmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AssessmentEntity assessment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<AssessmentEntity> assessment);

    @Delete
    void delete(AssessmentEntity assessment);

    @Query("DELETE FROM assessment_table")
    void deleteAllAssessments();

    @Query("SELECT * FROM assessment_table ORDER BY assessmentID ASC")
    List<AssessmentEntity> getAllAssessments();
}
