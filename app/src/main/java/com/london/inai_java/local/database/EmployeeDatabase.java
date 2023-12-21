package com.london.inai_java.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.london.inai_java.local.EmployeeEntity;
import com.london.inai_java.local.dao.EmployeeDao;

@Database(entities = {EmployeeEntity.class}, version = 1, exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
