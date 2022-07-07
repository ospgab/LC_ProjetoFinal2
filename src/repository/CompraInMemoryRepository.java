package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.Compra;

public class CompraInMemoryRepository implements BaseRepository<Compra, Long> {

    private final List<Compra> listaCompra = new ArrayList<>();

    @Override
    public void salvar(Compra entity) {
        BaseRepository.super.salvar(entity);
        System.out.println();
    }

    @Override
    public void persistir(Compra entity) {
        // Salvar Compra

    }

    @Override
    public Long criarId() {
        return new Random().nextLong();
    }

    @Override
    public void atualizar(Compra Compra) {

    }

    @Override
    public Compra getById(Long id) {
        return null;
    }

    @Override
    public List<Compra> listarTodos() {
        return null;
    }

    @Override
    public void excluir(Compra entity) {

    }

    @Override
    public Compra buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
