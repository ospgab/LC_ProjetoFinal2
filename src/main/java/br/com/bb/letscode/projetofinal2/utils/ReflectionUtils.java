package br.com.bb.letscode.projetofinal2.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtils {
    public static List<Field> getAllClassFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();

        while (clazz.getSuperclass() != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        return fields;
    }

    public static <T extends Annotation> Field getAnnotatedField(Class<T> annotationClass) {
        List<Field> classFields = getAllClassFields(annotationClass);
        try {
            for (Field field : classFields) {
                if (field.isAnnotationPresent(annotationClass)) {
                    return field;
                }
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        Field annotatedField = getAnnotatedField(annotationClass);
        return (annotatedField == null) ? null : annotatedField.getAnnotation(annotationClass);
    }
}
