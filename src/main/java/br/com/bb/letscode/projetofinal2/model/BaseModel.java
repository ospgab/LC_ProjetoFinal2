package br.com.bb.letscode.projetofinal2.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.bb.letscode.projetofinal2.utils.ReflectionUtils;

public abstract class BaseModel<ID> {
    public ID getId() {
        Field field = ReflectionUtils.getAnnotatedField(PrimaryKey.class, getClass());

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
        Class<?> clazz = this.getClass();
        Field field = ReflectionUtils.getAnnotatedField(
                PrimaryKey.class, getClass());

        if (field == null)
            return;

        try {
            field.setAccessible(true);
            field.set(this, id);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atribuir o ID do Model");
        }

    }
}