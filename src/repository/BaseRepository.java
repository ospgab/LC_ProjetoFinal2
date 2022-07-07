package repository;

import java.util.List;
import java.util.Map;

import model.BaseModel;

public interface BaseRepository<T extends BaseModel<ID>, ID> {

    default void salvar(T entity) {
        entity.setId(criarId());
        //getDados().put(entity.getId(), entity);
        persistir(entity);
    }

    void persistir(T entity);

    ID criarId();

    void atualizar(T entity);

    T getById(ID id);

    List<T> listarTodos();

    // default List<T> listarTodos() {
    // final List<T> lista = new ArrayList<>(getDados().values());
    // Collections.sort(lista);
    // return lista;
    // }

    void excluir(T entity);

    /*default T buscarPorId(ID id) {
        return getDados().get(id);
    }

     */

}