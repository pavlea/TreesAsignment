public interface Contract {

    interface TreeOperations<T> {

        boolean areSame(Tree<T> t1, Tree<T> t2);

        boolean areIsomorphic(Tree<T> t1, Tree<T> t2);
    }

    interface TreeFactory<T> {

        Tree<T> createRandomBinaryTree(int height);

        Tree<T> createDefaultBinaryTree(boolean reverse);
    }
}
