import java.util.ArrayList;

public class _530_GetMinimumDifference {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        transeTree(root);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int temp = Math.abs(arrayList.get(i) - arrayList.get(i + 1));
            if (temp < result) {
                result = temp;
            }
        }
        return result;
    }

    public void transeTree(TreeNode root) {
        if (root.left != null) {
            transeTree(root.left);
        }
        arrayList.add(root.val);
        if (root.right != null) {
            transeTree(root.right);
        }
    }
}
