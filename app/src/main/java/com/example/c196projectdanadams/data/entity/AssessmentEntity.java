package com.example.c196projectdanadams.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.time.LocalDate;

@Entity(tableName = "assessment_table")
public class AssessmentEntity {

    @PrimaryKey
    private int assessmentID;

    private String assessmentTitle;
    private AssessmentType assessmentType;
    private LocalDate endDate;

    private int courseID;

    public AssessmentEntity(int assessmentID, String assessmentTitle, AssessmentType assessmentType, LocalDate endDate, int courseID) {
        this.assessmentID = assessmentID;
        this.assessmentTitle = assessmentTitle;
        this.assessmentType = assessmentType;
        this.endDate = endDate;
        this.courseID = courseID;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(AssessmentType assessmentType) {
        this.assessmentType = assessmentType;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
