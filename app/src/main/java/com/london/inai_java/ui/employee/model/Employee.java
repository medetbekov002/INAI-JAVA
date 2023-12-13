package com.london.inai_java.ui.employee.model;

import java.util.Objects;
import java.util.Optional;

public class Employee {
    private final String name;
    private final Integer image;

    public Employee(String name, Integer image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Optional<Integer> getImage() {
        return Optional.ofNullable(image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(image, employee.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
