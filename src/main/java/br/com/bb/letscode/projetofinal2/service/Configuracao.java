package br.com.bb.letscode.projetofinal2.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracao {

    private String origemDosDados;

    public enum OrigemDados {
        BANCO_DE_DADOS,
        ARQUIVO,
        MEMORIA
    }

    public Configuracao() {
        String origem;

        final Properties configuracoes = new Properties();
        final String filePath = getClass().getClassLoader().getResource("configuracoes.properties").getPath();

        try (InputStream stream = new FileInputStream(filePath)) {
            configuracoes.load(stream);
        } catch (IOException e) {
            throw new RuntimeException("Arquivo de configuração ausente");
        }

        origem = configuracoes.getProperty("dados.origem");

        if (origem.isBlank()) {
            throw new RuntimeException("A configuração está inválida!");
        }

        setOrigemDosDados(origem);
    }

    public String getOrigemDosDados() {
        return origemDosDados;
    }

    public void setOrigemDosDados(String origemDosDados) {
        this.origemDosDados = origemDosDados;
    }
}
