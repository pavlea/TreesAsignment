import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum TreeFactory implements Contract.TreeFactory<Integer> {
    INSTANCE;

    @Override
    public Tree<Integer> createRandomBinaryTree(int height) {

        List<Tree<Integer>> nodes = new ArrayList<>((int) Math.pow(2, height));

        for (int i = height; i >= 0; i--) {
            if (i == 0) { // create root
                return Tree.of(nodes.get(i), getValue(), nodes.get(i + 1));
            }
            List<Tree<Integer>> tempNodes = new ArrayList<>((int) Math.pow(2, i));
            for (int j = 0; j < Math.pow(2, i); j++) {
                if (i == height) {
                    tempNodes.add(Tree.leaf(getValue()));
                    continue;
                }
                tempNodes.add(Tree.of(nodes.get(j), getValue(), nodes.get(j + 1)));
            }
            nodes = tempNodes;
        }
        return null;
    }

    private int getValue() {
        return new Random().nextInt(10);
    }


    @Override
    public Tree<Integer> createDefaultBinaryTree(boolean reverse) {
        // childs of level1Right
        Tree<Integer> level2Node4 = new Node<>(null, 15, null);
        Tree<Integer> level2Node3 = new Node<>(null, 12, null);

        // childs of level1Left
        Tree<Integer> level2Node2 = new Node<>(null, 4, null);
        Tree<Integer> level2Node1 = new Node<>(null, 5, null);

        Tree<Integer> level1Left = new Node<>(level2Node1, 7, level2Node2);
        Tree<Integer> level1Right = new Node<>(level2Node3, 10, level2Node4);

        if (reverse) {
            level1Left = new Node<>(level2Node2, 7, level2Node1);
            level1Right = new Node<>(level2Node4, 10, level2Node3);
        }

        Tree<Integer> root = new Node<>(level1Left, 8, level1Right);

        return root;
    }
}
