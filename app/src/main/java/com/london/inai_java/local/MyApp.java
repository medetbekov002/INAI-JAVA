package com.london.inai_java.local;

import android.app.Application;
import androidx.room.Room;

import com.london.inai_java.local.database.EmployeeDatabase;

public class MyApp extends Application {
    private EmployeeDatabase employeeDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        employeeDatabase = Room.databaseBuilder(getApplicationContext(),
                EmployeeDatabase.class, "employee_db")
                .allowMainThreadQueries() // Не рекомендуется для продакшена, это позволяет выполнять запросы из главного потока
                .build();
    }

    public EmployeeDatabase getEmployeeDatabase() {
        return employeeDatabase;
    }
}
