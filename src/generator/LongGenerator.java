package generator;

public class LongGenerator implements Generator<Long> {
    private static Long value = 0L;

    public Long next(){
        return value++;
    }
}
