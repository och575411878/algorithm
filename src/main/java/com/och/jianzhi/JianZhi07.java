package com.och.jianzhi;

import java.util.HashMap;

/**
 * 二叉树的重现方法
 * 没有子树的情况。i+1>right,i-1<left
 */
public class JianZhi07 {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder||preorder.length == 0){
            return null;
        }
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left>right)return null;// 没有子树的情况。i+1>right,i-1<left
        TreeNode node = new TreeNode(preorder[root]);
        // 递归终止          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }
}
