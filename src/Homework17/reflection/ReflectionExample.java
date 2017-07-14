package Homework17.reflection;

import Homework17.inheritance.MyAnnotation;
import Homework17.inheritance.SuperEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        SuperEntity se = new SuperEntity();
        Class clazz = se.getClass();
        String h = clazz.getName();
        System.out.println(h);
        Class sE = SuperEntity.class;
        Class c = Class.forName("com.mysql.jdbc.Driver");
        Field f = clazz.getField("a");
        System.out.println(f.get(clazz).toString());

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if ("a".equals(field.getName())) {
                field.setInt(se, 1);
            }

            if ("b".equals(field.getName())) {
                field.setInt(se, 5);
            }

            if ("c".equals(field.getName())) {
                field.setInt(se, 10);
            }

            if (field.isAnnotationPresent(MyAnnotation.class)) {
                int anInt = field.getInt(se);
                field.setInt(se, anInt * 2);
            }
        }

        Class parent = clazz.getSuperclass();
        System.out.println(parent.getName());
        Field[] fields = parent.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
            if ("f".equals(declaredMethod.getName())) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(se);
            }
        }


    }
}
