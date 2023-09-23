package model;
 class AVLNode<T> {
        T data;
        int height;
        AVLNode<T> left, right;

        AVLNode(T data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }
