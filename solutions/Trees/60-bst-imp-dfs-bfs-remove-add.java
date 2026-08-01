package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeImplementation {
    private Node root;

    public BinarySearchTreeImplementation() {
    }

    public void add(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (current != null) {
            if (val >= current.val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = node;
                    return;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = node;
                    return;
                }
            }
        }
    }

    public boolean search(int val) {
        Node current = root;

        while (current != null) {
            if (current.val == val) {
                return true;
            }
            if (val > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
    }

    public List<List<Integer>> bfs(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            while (levelSize > 0) {
                Node levelNode = queue.poll();
                levelResult.add(levelNode.val);
                levelSize--;
                if (levelNode.left != null) {
                    queue.add(levelNode.left);
                }
                if (levelNode.right != null) {
                    queue.add(levelNode.right);
                }
            }
            result.add(levelResult);
        }
        return result;

    }



    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeImplementation bstImpl = new BinarySearchTreeImplementation();
        bstImpl.add(10);
        bstImpl.add(11);
        bstImpl.add(8);
        bstImpl.add(9);
        bstImpl.add(7);
        bstImpl.add(6);
        Node root = bstImpl.root;
        System.out.println(root);
        System.out.println(bstImpl.search(9));
        System.out.println(bstImpl.search(12));
        List<List<Integer>> lists = bstImpl.levelOrder(bstImpl.root);
    }
}
