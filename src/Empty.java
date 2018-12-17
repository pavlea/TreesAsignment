import java.util.Optional;

public final class Empty<T> implements Tree<T> {
    Empty() {
    }

    @Override
    public Optional<Tree<T>> left() {
        return Optional.empty();
    }

    @Override
    public Optional<Tree<T>> right() {
        return Optional.empty();
    }

    @Override
    public T value() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}