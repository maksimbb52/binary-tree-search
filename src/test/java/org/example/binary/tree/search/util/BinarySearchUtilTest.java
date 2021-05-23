package org.example.binary.tree.search.util;

import org.example.binary.tree.search.model.Node;
import org.junit.Test;

import static org.example.binary.tree.search.util.BinarySearchUtil.findOne;
import static org.junit.Assert.assertEquals;

public class BinarySearchUtilTest {

    @Test
    public void findOneSuccess() {
        //GIVEN
        final Node root = initTree();
        final Node node13 = root.getRight().getRight().getRight().getRight().getRight().getLeft();

        //WHEN
        final Node actualResult = findOne(root, 13);

        //THEN
        assertEquals(node13, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findOneFailRootIsNull() {
        //GIVEN
        final Node root = initTree();

        //WHEN
        findOne(null, 0);
    }

    private Node initTree() {
        final Node node1 = new Node(1, null, null);//            4
        final Node node3 = new Node(3, null, null);//     2            7
        final Node node2 = new Node(2, node1, node3);//    1  3       5        10
        final Node node6 = new Node(6, null, null);//                 6     9  11
        final Node node5 = new Node(5, null, node6);//                      8     12
        final Node node8 = new Node(8, null, null);//                                 14
        final Node node9 = new Node(9, node8, null);//                               13  15
        final Node node13 = new Node(13, null, null);// Result: sorted array 1..15
        final Node node15 = new Node(15, null, null);
        final Node node14 = new Node(14, node13, node15);
        final Node node12 = new Node(12, null, node14);
        final Node node11 = new Node(11, null, node12);
        final Node node10 = new Node(10, node9, node11);
        final Node node7 = new Node(7, node5, node10);
        return new Node(4, node2, node7);
    }
}