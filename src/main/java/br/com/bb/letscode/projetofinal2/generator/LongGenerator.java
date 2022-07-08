package br.com.bb.letscode.projetofinal2.generator;

public class LongGenerator extends Generator<Long> {
    private static Generator<Long> instance;
    private static Long value = 0L;

    private LongGenerator() {
    }

    public static Generator<Long> getInstance() {
        if (instance == null)
            instance = new LongGenerator();
        return instance;
    }

    @Override
    public Long next() {
        return value++;
    }
}
