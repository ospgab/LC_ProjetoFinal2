package br.com.bb.letscode.projetofinal2.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.bb.letscode.projetofinal2.model.Compra;

public class CompraInMemoryRepository implements BaseRepository<Compra, Long> {

    private static CompraInMemoryRepository instance;
    private final List<Compra> listaCompra = new ArrayList<>();

    private CompraInMemoryRepository() {
    }

    public static CompraInMemoryRepository getInstance() {
        if (instance == null)
            instance = new CompraInMemoryRepository();
        return instance;
    }

    @Override
    public void update(Compra entity) {
        this.delete(entity);
        this.persist(entity);
    }

    @Override
    public Compra getById(Long id) {
        return this.listaCompra.stream()
                .filter(compra -> compra.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Compra> getAll() {
        return List.copyOf(this.listaCompra);
    }

    @Override
    public void delete(Compra entity) {
        this.listaCompra.remove(entity);
    }

    @Override
    public void persist(Compra entity) {
        this.listaCompra.add(entity);
    }

    
}
