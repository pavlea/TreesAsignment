import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreePrinter {

    public static <T> void printNode(Tree<T> root) {
        int maxLevel = TreePrinter.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T> void printNodeInternal(List<Tree<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        TreePrinter.printWhitespaces(firstSpaces);

        List<Tree<T>> newNodes = new ArrayList<>();
        for (Tree<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value());
                newNodes.add(node.left().orElse(null));
                newNodes.add(node.right().orElse(null));
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            TreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (Tree<T> node : nodes) {
                TreePrinter.printWhitespaces(firstSpaces - i);
                if (node == null) {
                    TreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (node.left().orElse(null) != null)
                    System.out.print("/");
                else
                    TreePrinter.printWhitespaces(1);

                TreePrinter.printWhitespaces(i + i - 1);

                if (node.right().orElse(null) != null)
                    System.out.print("\\");
                else
                    TreePrinter.printWhitespaces(1);

                TreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T> int maxLevel(Tree<T> node) {
        if (node == null)
            return 0;

        return Math.max(
                TreePrinter.maxLevel(node.left().orElse(null)),
                TreePrinter.maxLevel(node.right().orElse(null))) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}