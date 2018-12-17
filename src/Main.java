public class Main {

    public static void main(String[] args) {
        Tree<Integer> defaultTree = TreeFactory.INSTANCE.createDefaultBinaryTree(false);
        Tree<Integer> reversedDefaultTree = TreeFactory.INSTANCE.createDefaultBinaryTree(true);

        Tree<Integer> binaryTree = TreeFactory.INSTANCE.createRandomBinaryTree(2);
        Tree<Integer> binaryTree2 = TreeFactory.INSTANCE.createRandomBinaryTree(3);

        areSame(binaryTree, binaryTree2);
        areSame(defaultTree, defaultTree);

        areIsomorphic(binaryTree, reversedDefaultTree);
        areIsomorphic(defaultTree, reversedDefaultTree);
    }

    private static void areSame(Tree<Integer> t1, Tree<Integer> t2) {
        TreePrinter.printNode(t1);
        TreePrinter.printNode(t2);
        System.out.println("TREES SAME:");
        System.out.println(TreeOperations.INSTANCE.areSame(t1, t2));
        System.out.println("\n--------------------------");
    }

    private static void areIsomorphic(Tree<Integer> t1, Tree<Integer> t2) {
        TreePrinter.printNode(t1);
        TreePrinter.printNode(t2);
        System.out.println("TREES ISOMORPHIC:");
        System.out.println(TreeOperations.INSTANCE.areIsomorphic(t1, t2));
        System.out.println("\n--------------------------");
    }
}
