import java.util.Optional;

public final class Node<T> implements Tree<T> {
    private final Tree<T> left;
    private final T value;
    private final Tree<T> right;

    Node(Tree<T> left, T value, Tree<T> right) {
        if (value == null) {
            throw new NullPointerException();
        }

        this.left = left;
        this.value = value;
        this.right = right;
    }

    @Override
    public Optional<Tree<T>> left() {
        return Optional.ofNullable(left);
    }

    @Override
    public Optional<Tree<T>> right() {
        return Optional.ofNullable(right);
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public boolean isEmpty() {
        return value != null;
    }
}