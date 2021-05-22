package com.example.c196projectdanadams.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.c196projectdanadams.data.entity.TermEntity;

import java.util.List;

@Dao
public interface TermDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TermEntity term);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TermEntity> term);

    @Delete
    void delete(TermEntity term);

    @Query("DELETE FROM term_table")
    void deleteAllTerms();

    @Query("SELECT * FROM term_table ORDER BY termID ASC")
    List<TermEntity> getAllTerms();

}
