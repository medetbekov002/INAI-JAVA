package com.london.inai_java.ui.onboarding.model;

import java.util.Objects;
import java.util.Optional;

public class OnBoarding {
    private final Integer image;
    private final String title;

    public OnBoarding(Integer image, String title) {
        this.image = image;
        this.title = title;
    }

    public Optional<Integer> getImage() {
        return Optional.ofNullable(image);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnBoarding that = (OnBoarding) o;
        return Objects.equals(image, that.image) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, title);
    }

    @Override
    public String toString() {
        return "OnBoarding{" +
                "image=" + image +
                ", title='" + title + '\'' +
                '}';
    }
}
