package org.example.lesson27.hw;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CourseTester {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Course.class;
        Constructor<Course> courseConstructor = clazz.getConstructor(String.class, int.class, double.class);
        Course course = courseConstructor.newInstance("math", 112, 5432.1);
        Method toString = clazz.getMethod("toString");
        System.out.println("" +toString.invoke(course));
    }
}
