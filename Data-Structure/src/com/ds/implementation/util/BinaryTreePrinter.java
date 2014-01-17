package com.ds.implementation.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ds.implementation.Node;

public class BinaryTreePrinter{

    /**
     * Prints the node.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param root the root
     */
    public static <T extends Comparable<T>, E> void printNode(Node<T,E> root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    /**
     * Prints the node internal.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param nodes the nodes
     * @param level the level
     * @param maxLevel the max level
     */
    private static <T extends Comparable<T>, E> void printNodeInternal(List<Node<T,E>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

       printWhitespaces(firstSpaces);

        List<Node<T,E>> newNodes = new ArrayList<Node<T,E>>();
        for (Node<T,E> node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeftNode());
                newNodes.add(node.getRightNode());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeftNode() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRightNode() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    /**
     * Prints the whitespaces.
     *
     * @param count the count
     */
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    /**
     * Max level.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param node the node
     * @return the int
     */
    private static <T extends Comparable<T>, E> int maxLevel(Node<T,E> node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.getLeftNode()), maxLevel(node.getRightNode())) + 1;
    }

    /**
     * Checks if is all elements null.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param list the list
     * @return true, if is all elements null
     */
    private static <T extends Comparable<T>, E> boolean isAllElementsNull(List<Node<T,E>> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}