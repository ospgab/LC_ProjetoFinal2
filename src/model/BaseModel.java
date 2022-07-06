package model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseModel<ID> {
    public ID getId() {
        List<Field> classFields = this.getAllClassFields();
        try {
            for (Field field :
                    classFields) {
                if (field.isAnnotationPresent(PrimaryKey.class)){
                    field.setAccessible(true);
                    return (ID) field.get(this);
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void setId(ID id) {

        try {
            Class clazz = this.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(PrimaryKey.class)) {
                    String fieldName = field.getName();
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1);
                    Method method = clazz.getDeclaredMethod(methodName, id.getClass());
                    //method.setAccessible(true);
                    method.invoke(this, id);
                    break;
                }
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private List<Field> getAllClassFields(){
        Class clazz = this.getClass();
        List<Field> fields = new ArrayList<>();

        while(clazz.getSuperclass() != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        return fields;
    }
}