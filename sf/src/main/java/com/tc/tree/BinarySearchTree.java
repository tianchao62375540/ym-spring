package com.tc.tree;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 11:06
 * @Description:
 */
public class BinarySearchTree {
    int data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insert(BinarySearchTree root,int data){
        if (root.data <= data){
            if (root.right == null){
                root.right = new BinarySearchTree(data);
            }else {
                insert(root.right,data);
            }
        }else {
            if (root.left == null){
                root.left = new BinarySearchTree(data);
            }else {
                insert(root.left,data);
            }
        }
    }

    public void in(BinarySearchTree root){
        if (root != null){
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,9,0,1,2,3,10,10,15,9};
        BinarySearchTree root = new BinarySearchTree(array[0]);
        for (int i = 1;i<array.length;i++){
            root.insert(root, array[i]);
        }
        root.in(root);
    }
}
