import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BSTHeightHistogram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a positive integer n: ");
            int n = scanner.nextInt();

            List<Integer> values = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                values.add(i);
            }

            List<Integer> heights = new ArrayList<>();
            long totalHeight = 0;

            int factorial = factorial(n);
            for (int i = 0; i < factorial; i++) {
                Collections.shuffle(values);
                BinarySearchTree bst = new BinarySearchTree();
                for (int value : values) {
                    bst.insert(value);
                }
                int height = bst.height();
                heights.add(height);
                totalHeight += height;
            }

            System.out.println("Height Frequency");
            System.out.println("----------------");
            int[] frequency = new int[n + 1];
            for (int height : heights) {
                frequency[height]++;
            }
            for (int h = 1; h <= n; h++) {
                System.out.println(h + " " + frequency[h]);
            }

            double averageHeight = (double) totalHeight / factorial;
            System.out.println("Average height of BSTs: ");
            System.out.println(averageHeight);
        }
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = heightRec(root.left);
            int rightHeight = heightRec(root.right);

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }
}
