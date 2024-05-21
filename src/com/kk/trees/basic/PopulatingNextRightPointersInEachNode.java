package com.kk.trees;

public class PopulatingNextRightPointersInEachNode {


    public static void main(String[] args) {


        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);

        Node answer = root;

    }

    public static Node connect(Node root) {

        if(root == null){
            return null;
        }

        Node leftMost = root;

        while(leftMost.left != null){
            Node current = leftMost;

            while(current != null){

                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;



    }



    private static class Node{

        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }


}
