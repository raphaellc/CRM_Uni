package util.interfaces;

public interface ThrowingFunction<T, R> {

    R apply(T t) throws Exception;
}
