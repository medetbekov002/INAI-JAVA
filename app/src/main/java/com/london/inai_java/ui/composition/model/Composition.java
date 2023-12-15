package com.london.inai_java.ui.composition.model;

import java.util.Objects;
import java.util.Optional;

public class Composition {
    private final String name;
    private final Integer image;

    public Composition(String name, Integer image) {
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
        Composition composition = (Composition) o;
        return Objects.equals(name, composition.name) &&
                Objects.equals(image, composition.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image);
    }

    @Override
    public String toString() {
        return "Composition{" +
                "name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}

