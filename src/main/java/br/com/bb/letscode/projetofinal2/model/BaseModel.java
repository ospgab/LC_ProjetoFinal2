package br.com.bb.letscode.projetofinal2.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.bb.letscode.projetofinal2.utils.ReflectionUtils;

public abstract class BaseModel<ID> {
    public ID getId() {
        Field field = ReflectionUtils.getAnnotatedField(PrimaryKey.class);

        if (field == null)
            return null;

        field.setAccessible(true);
        try {
            @SuppressWarnings({ "unchecked" })
            ID id = (ID) field.get(this);
            return id;
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setId(ID id) {
        Field field = ReflectionUtils.getAnnotatedField(PrimaryKey.class);

        if (field == null)
            return;

        try {
            Class<?> clazz = this.getClass();
            String fieldName = field.getName();
            String methodName = "set" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            Method method = clazz.getDeclaredMethod(methodName, id.getClass());
            // method.setAccessible(true);
            method.invoke(this, id);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}