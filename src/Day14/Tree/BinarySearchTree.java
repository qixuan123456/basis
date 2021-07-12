package Day14.Tree;

public class BinarySearchTree {


    private Node root; // 树根节点

    //插入节点
    public void insert(int key) {
        Node p = new Node(); //待插入的节点
        p.data = key;

        if (root == null) {
            root = p;
        } else {
            Node parent = new Node();
            Node current = root;
            while (true) {
                parent = current;
                if (key > current.data) {
                    current = current.right; // 右子树
                    if (current == null) {
                        parent.right = p;
                        return;
                    }
                } else //本程序没有做key出现相等情况的处理，暂且假设用户插入的节点值都不同
                {
                    current = current.left; // 左子树
                    if (current == null) {
                        parent.left = p;
                        return;
                    }
                }
            }
        }
    }

    //遍历节点
    public void travel(Node root) {
        if (root != null) {
            travel(root.left);
            System.out.print(root.data + "\t");
            travel(root.right);
        }
    }

    //查找节点
    public Node find(int key) {
        Node current = root;
        while (key != current.data) {
            if (key > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
            if (current == null)
                return null;
        }
        return current;
    }

    public void show(Node node) {
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("null");
        }
    }

    //寻找要删除节点的中序后继结点
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;

        //用来寻找后继结点
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        //如果后继结点为要删除结点的右子树的左子，需要预先调整一下要删除结点的右子树
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    // 删除结点
    public boolean delete(int key) {
        Node current = root;
        Node parent = new Node();
        boolean isRightChild = true;
        while (current.data != key) {
            parent = current;
            if (key > current.data) {
                current = current.right;
                isRightChild = true;
            } else {
                current = current.left;
                isRightChild = false;
            }
            if (current == null) return false; // 没有找到要删除的结点
        }
        // 此时current就是要删除的结点,parent为其父结点
        // 要删除结点为叶子结点
        if (current.right == null && current.left == null) {
            if (current == root) {
                root = null; // 整棵树清空
            } else {
                if (isRightChild)
                    parent.right = null;
                else
                    parent.left = null;
            }
            return true;
        }
        //要删除结点有一个子结点
        else if (current.left == null) {
            if (current == root)
                root = current.right;
            else if (isRightChild)
                parent.right = current.right;
            else
                parent.left = current.right;
            return true;
        } else if (current.right == null) {
            if (current == root)
                root = current.left;
            else if (isRightChild)
                parent.right = current.left;
            else
                parent.left = current.left;
            return true;
        }
        //要删除结点有两个子结点
        else {
            Node successor = getSuccessor(current);    //找到要删除结点的后继结点

            if (current == root)
                root = successor;
            else if (isRightChild)
                parent.right = successor;
            else
                parent.left = successor;

            successor.left = current.left;
            return true;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 6, 8, 2, 9, 1, 0, 3, 7};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < a.length; i++) {
            binarySearchTree.insert(a[i]);
        }
        binarySearchTree.travel(binarySearchTree.root);

        Node node = binarySearchTree.find(3);
        binarySearchTree.show(node);
    }

}

class Node { // 节点类
    int data; // 数据域
    Node right; // 右子树
    Node left; // 左子树
}