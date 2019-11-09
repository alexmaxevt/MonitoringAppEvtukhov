package ru.evtukhov.android.monitoringapp;

import java.util.Objects;

public class Profile {
    private String name;
    private int age;

    public Profile (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return name.equals(profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
