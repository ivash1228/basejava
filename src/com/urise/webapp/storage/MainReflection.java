package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    //MainReflection вызовите у Resume, через отражение, метод toString. Выведите результат на консоль
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume r = new Resume();
        r.setUuid("1111");
        Method method = r.getClass().getDeclaredMethod("toString");
        System.out.println(method.invoke(r));
    }

}
