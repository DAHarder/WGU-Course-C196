package com.example.c196projectdanadams.data.database;

import android.app.Application;

import com.example.c196projectdanadams.data.dao.AssessmentDao;
import com.example.c196projectdanadams.data.dao.CourseDao;
import com.example.c196projectdanadams.data.dao.TermDao;
import com.example.c196projectdanadams.data.entity.AssessmentEntity;
import com.example.c196projectdanadams.data.entity.CourseEntity;
import com.example.c196projectdanadams.data.entity.TermEntity;

import java.text.DateFormat;
import java.util.List;

public class ScheduleRepository {
    private TermDao mTermDao;
    private CourseDao mCourseDao;
    private AssessmentDao mAssessmentDao;

    private List<TermEntity> mAllTerms;
    private List<CourseEntity> mAllCourses;
    private List<AssessmentEntity> mAllAssessments;

    private int termID;
    private int courseID;
    private int assessmentID;

    public ScheduleRepository(Application application) {
        ScheduleDatabase db = ScheduleDatabase.getDatabase(application);
        mTermDao = db.termDao();
        mCourseDao = db.courseDao();
        mAssessmentDao = db.assessmentDao();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public List<TermEntity> getAllTerms() {
        ScheduleDatabase.databaseWriteExecutor.execute(() -> {
            mAllTerms = mTermDao.getAllTerms();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllTerms;
    }

        public List<CourseEntity> getAllCourses() {
            ScheduleDatabase.databaseWriteExecutor.execute(() -> {
                mAllCourses = mCourseDao.getAllCourses();
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return mAllCourses;
        }

    public List<AssessmentEntity> getAllAssessments() {
        ScheduleDatabase.databaseWriteExecutor.execute(() -> {
            mAllAssessments = mAssessmentDao.getAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    public void insert (TermEntity termEntity) {
        ScheduleDatabase.databaseWriteExecutor.execute(()->{
            mTermDao.insert(termEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void insert (CourseEntity courseEntity) {
        ScheduleDatabase.databaseWriteExecutor.execute(()->{
            mCourseDao.insert(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void insert (AssessmentEntity assessmentEntity) {
        ScheduleDatabase.databaseWriteExecutor.execute(()->{
            mAssessmentDao.insert(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete (TermEntity termEntity) {
        ScheduleDatabase.databaseWriteExecutor.execute(()->{
            mTermDao.delete(termEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete (CourseEntity courseEntity) {
        ScheduleDatabase.databaseWriteExecutor.execute(()->{
            mCourseDao.delete(courseEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete (AssessmentEntity assessmentEntity) {
        ScheduleDatabase.databaseWriteExecutor.execute(()->{
            mAssessmentDao.delete(assessmentEntity);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
