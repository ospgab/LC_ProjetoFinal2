package repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import generator.GeneratedValue;
import generator.GenerationType;
import generator.Generator;
import generator.LongGenerator;
import model.BaseModel;
import utils.ReflectionUtils;

public interface BaseRepository<T extends BaseModel<ID>, ID> {

    

    void persist(T entity);
    // default void persist(T entity) {
    //     // GeneratedValue field = ReflectionUtils.getAnnotation(GeneratedValue.class);
    //     // GenerationType g = field.strategy();
    //     // Generator<ID> generator = getGenerator(LongGenerator.class);
    //     // switch (g) {
    //     //     case SEQUENCE:
    //     //         entity.setId(generator.getInstance().next());
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