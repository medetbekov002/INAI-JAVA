package com.london.inai_java.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.london.inai_java.local.EmployeeEntity;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employees")
    List<EmployeeEntity> getAllEmployees();

    @Query("SELECT * FROM employees WHERE id = :employeeId")
    EmployeeEntity getEmployeeById(int employeeId);

    @Insert
    void insertEmployee(EmployeeEntity employee);

    @Update
    void updateEmployee(EmployeeEntity employee);

    @Delete
    void deleteEmployee(EmployeeEntity employee);
}
