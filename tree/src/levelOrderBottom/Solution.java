package levelOrderBottom;

import common.TreeNode;

import java.util.*;

/**
 * 解题思路: 层次遍历 + 逆序数组
 *
 * @author: itsuki
 * @create: 2021-04-24 09:12
 **/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ret;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        Collections.reverse(ret);
        return ret;
    }
}
