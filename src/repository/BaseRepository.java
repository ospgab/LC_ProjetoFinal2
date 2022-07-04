package org.example.repository;

import java.util.List;

public interface BaseRepository<T extends BaseModel<ID>, ID> {
    void add(T entity);
    void remove(T entity);
    void update(T entity);
    List<T> getAll();
    T findById(ID id);
}