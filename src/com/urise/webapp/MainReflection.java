package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume resume = new Resume();
        Field declaredField = resume.getClass().getDeclaredFields()[0];
        declaredField.setAccessible(true);
        System.out.println(declaredField.getName());
        System.out.println(declaredField.get(resume));
        declaredField.set(resume, "new_uuid");
        System.out.println(resume);

        Method method = resume.getClass().getDeclaredMethod("toString");
        method.setAccessible(true);
        System.out.println(method.invoke(resume));

    }
}
