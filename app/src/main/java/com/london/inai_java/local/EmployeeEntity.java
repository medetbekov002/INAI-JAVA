package com.london.inai_java.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employees")
public class EmployeeEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int image; // Измените тип данных, если необходимо

    // Создайте конструктор и методы доступа к полям (getters и setters)
    // ...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
