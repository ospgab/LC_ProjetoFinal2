package br.com.bb.letscode.projetofinal2.repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import br.com.bb.letscode.projetofinal2.generator.GeneratedValue;
import br.com.bb.letscode.projetofinal2.generator.GenerationType;
import br.com.bb.letscode.projetofinal2.generator.Generator;
import br.com.bb.letscode.projetofinal2.generator.LongGenerator;
import br.com.bb.letscode.projetofinal2.model.BaseModel;
import br.com.bb.letscode.projetofinal2.utils.ReflectionUtils;

public interface BaseRepository<T extends BaseModel<ID>, ID> {

    default void updateId(T entity) {
        GeneratedValue field = ReflectionUtils.getFieldWithAnnotation(GeneratedValue.class, entity.getClass());
        GenerationType g = field.strategy();
        Generator<ID> generator = getGenerator(LongGenerator.class);

        switch (g) {
            case SEQUENCE:
                entity.setId(generator.next());
        }

    };

    void persist(T entity);

    void update(T entity);

    T getById(ID id);

    List<T> getAll();

    void delete(T entity);

    default Generator<ID> getGenerator(Class<? extends Generator<?>> generatorClass) {
        try {
            Method getInstance = generatorClass.getDeclaredMethod("getInstance");
            System.out.println(getInstance);
            return (Generator<ID>) getInstance.invoke(null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
        }

        return null;
    }
}