package org.example.lesson27.hw;

import java.lang.reflect.Field;

public class Course {
    @Fake(value = "hello 123")
    private String specialization;
    private int duration;
    private double price;

    public Course(String specialization, int duration, double price) {
        this.specialization = specialization;
        this.duration = duration;
        this.price = price;
    }

    @Override
    public String toString() {
        Class clazz = this.getClass();
        String alternativeSpecialization = "";
        try {
            Field specializationField = clazz.getDeclaredField("specialization");
            Fake fake = specializationField.getAnnotation(Fake.class);
            alternativeSpecialization = fake.value();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return "Course{" +
                "specialization='" + (!alternativeSpecialization.equals("") ? alternativeSpecialization : specialization) + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}
