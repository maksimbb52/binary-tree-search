package org.example.binary.tree.search.util;

import org.example.binary.tree.search.model.Node;

public class BinarySearchUtil {

    public static Node findOne(Node root, int searching) throws IllegalArgumentException {
        if (root == null) {
            throw new IllegalArgumentException("Root is null");
        }
        if (root.getValue() < searching) {
            return findOne(root.getRight(), searching);
        } else if (root.getValue() > searching) {
            return findOne(root.getLeft(), searching);
        } else {
            return root;
        }
    }
}
