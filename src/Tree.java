import java.util.Optional;

public interface Tree<T> {

    static <T> Tree<T> empty() {
        return new Empty<>();
    }

    static <T> Tree<T> leaf(T value) {
        return of(null, value, null);
    }

    static <T> Tree<T> of(Tree<T> left, T value, Tree<T> right) {
        return new Node<>(left, value, right);
    }

    Optional<Tree<T>> left();

    Optional<Tree<T>> right();

    T value();

    boolean isEmpty();

    default boolean notEmpty() {
        return !isEmpty();
    }
}