package generator;

public abstract class Generator<T> {
    public abstract Generator<T> getInstance();

    public abstract T next();
}
