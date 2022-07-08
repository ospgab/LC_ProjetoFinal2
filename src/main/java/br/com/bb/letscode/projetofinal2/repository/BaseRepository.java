package br.com.bb.letscode.projetofinal2.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import br.com.bb.letscode.projetofinal2.generator.Generator;
import br.com.bb.letscode.projetofinal2.model.BaseModel;

public interface BaseRepository<T extends BaseModel<ID>, ID> {

    

    void persist(T entity);
    // default void persist(T entity) {
    //     // GeneratedValue field = ReflectionUtils.getAnnotation(GeneratedValue.class);
    //     // GenerationType g = field.strategy();
    //     // Generator<ID> br.com.bb.letscode.projetofinal2.generator = getGenerator(LongGenerator.class);
    //     // switch (g) {
    //     //     case SEQUENCE:
    //     //         entity.setId(br.com.bb.letscode.projetofinal2.generator.getInstance().next());
    //     // }

    //     //entity.setId(null); // TODO autogenerate ID
        

    // };

    void update(T entity);

    T getById(ID id);

    List<T> getAll();

    void delete(T entity);

    default Generator<ID> getGenerator(Class<? extends Generator<?>> generatorClass) {
        try {
            return (Generator<ID>) generatorClass.getDeclaredMethod("getInstance").invoke(null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
        }

        return null;
    }
}