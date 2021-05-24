package com.example.c196projectdanadams.data.database;

import android.content.Context;
import android.os.strictmode.InstanceCountViolation;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.c196projectdanadams.data.dao.AssessmentDao;
import com.example.c196projectdanadams.data.dao.CourseDao;
import com.example.c196projectdanadams.data.dao.TermDao;
import com.example.c196projectdanadams.data.entity.AssessmentEntity;
import com.example.c196projectdanadams.data.entity.AssessmentType;
import com.example.c196projectdanadams.data.entity.CourseEntity;
import com.example.c196projectdanadams.data.entity.TermEntity;
import com.example.c196projectdanadams.util.SampleData;

import java.sql.Date;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TermEntity.class, CourseEntity.class, AssessmentEntity.class}, version = 2)
@TypeConverters({DateConverter.class, CourseStatusConverter.class, AssessmentTypeConverter.class})
public abstract class ScheduleDatabase extends RoomDatabase {
    public abstract AssessmentDao assessmentDao();
    public abstract CourseDao courseDao();
    public abstract TermDao termDao();

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile ScheduleDatabase INSTANCE;

    static ScheduleDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (ScheduleDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ScheduleDatabase.class, "schedule_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            TermDao mTermDao = INSTANCE.termDao();
            CourseDao mCourseDao = INSTANCE.courseDao();
            AssessmentDao mAssessmentDao = INSTANCE.assessmentDao();

            databaseWriteExecutor.execute(() -> {

                mTermDao.deleteAllTerms();
                mCourseDao.deleteAllCourses();
                mAssessmentDao.deleteAllAssessments();

                mTermDao.insertAll(SampleData.getSampleTerms());
                mCourseDao.insertAll(SampleData.getSampleCourses());
                mAssessmentDao.insertAll(SampleData.getSampleAssessments());

            });
        }
    };
}

