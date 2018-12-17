public enum TreeOperations implements Contract.TreeOperations<Integer> {
    INSTANCE;

    @Override
    public boolean areSame(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null) {
            return (t1.value().equals(t2.value())
                    && areSame(t1.left().orElse(null), t2.left().orElse(null))
                    && areSame(t1.right().orElse(null), t2.right().orElse(null))
            );
        }
        return false;
    }

    @Override
    public boolean areIsomorphic(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (!t1.value().equals(t2.value())) {
            return false;
        }
        return (areIsomorphic(t1.left().orElse(null), t2.left().orElse(null))
                && areIsomorphic(t1.right().orElse(null), t2.right().orElse(null))
                || areIsomorphic(t1.left().orElse(null), t2.right().orElse(null))
                && areIsomorphic(t1.right().orElse(null), t2.left().orElse(null)));
    }
}
