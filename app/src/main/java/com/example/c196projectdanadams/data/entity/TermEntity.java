package com.example.c196projectdanadams.data.entity;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.sql.Date;

@Entity(tableName = "term_table")
public class TermEntity {

    @PrimaryKey
    private int termID;

    private String termTitle;
    private Date startDate;
    private Date endDate;

    public TermEntity(int termID, String termTitle, Date startDate, Date endDate) {
        this.termID = termID;
        this.termTitle = termTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public String getTermTitle() {
        return termTitle;
    }

    public void setTermTitle(String termTitle) {
        this.termTitle = termTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
