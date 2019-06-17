package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

   protected BSTNode<T> root;

   public BSTImpl() {
      root = new BSTNode<T>();
   }

   public BSTNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return root.isEmpty();
   }

   @Override
   public int height() {return height(getRoot());}

   private int height(BSTNode<T> node) {
      if(node.isEmpty())
         return -1;
      return 1 + Math.max(height((BSTNode<T>) node.getRight()), height((BSTNode<T>) node.getLeft()));
   }

   @Override
   public BSTNode<T> search(T element) {
      if(element != null)
         return search(element, getRoot());
      return null;
   }

   private BSTNode<T> search(T element, BSTNode<T> node) {
      if(node.isEmpty() || node.getData().equals(element))
         return node;
      else if(node.getData().compareTo(element) > 0)
         return search(element, (BSTNode<T>) node.getLeft());
      else
         return search(element, (BSTNode<T>) node.getRight());
   }

   @Override
   public void insert(T element) {
      if (element != null){
         insert(null, element, getRoot());
      }
   }

   private void insert(BTNode parent, T element, BSTNode<T> node) {
      if (node.isEmpty()){
         node.setData(element);
         node.setParent(parent);
         node.setLeft(new BSTNode<T>());
         node.setRight(new BSTNode<T>());
      } else if (node.getData().compareTo(element) > 0){
         insert(node, element, (BSTNode<T>) node.getLeft());
      } else if (node.getData().compareTo(element) < 0){
         insert(node, element, (BSTNode<T>) node.getRight());
      }
   }

   @Override
   public BSTNode<T> maximum() {return maximum(getRoot());}

   private BSTNode<T> maximum(BSTNode<T> node) {
      if (node.isEmpty() || node == null)
         return null;
      else if (node.getRight().isEmpty())
         return node;
      return maximum((BSTNode<T>) node.getRight());
   }

   @Override
   public BSTNode<T> minimum() {return minimum(getRoot());}

   private BSTNode<T> minimum(BSTNode<T> node) {
      if (node.isEmpty() || node == null)
         return null;
      else if (node.getLeft().isEmpty())
         return node;
      return minimum((BSTNode<T>) node.getLeft());
   }

   @Override
   public BSTNode<T> sucessor(T element) {
      BSTNode<T> node = search(element);
      if (node == null || node.isEmpty()) {
         return null;
      } else {
         return sucessor(node);
      }
   }

   private BSTNode<T> sucessor(BSTNode<T> node) {
      BSTNode<T> sucessor = minimum((BSTNode<T>) node.getRight());
      if (sucessor != null && !sucessor.isEmpty()) {
         return sucessor;
      } else {
         sucessor = (BSTNode<T>) node.getParent();
         while (sucessor != null && !sucessor.isEmpty() && (sucessor.getData().compareTo(node.getData()) < 0)) {
            sucessor = (BSTNode<T>) sucessor.getParent();
         }
         if (sucessor != null && sucessor.isEmpty()) {
            return null;
         } else {
            return sucessor;
         }
      }
   }

   @Override
   public BSTNode<T> predecessor(T element) {
      BSTNode<T> node = search(element);
      if (node == null || node.isEmpty()) {
         return null;
      } else {
         return predecessor(node);
      }
   }

   private BSTNode<T> predecessor(BSTNode<T> node) {
      BSTNode<T> predecessor = maximum((BSTNode<T>) node.getLeft());
      if (predecessor != null && !predecessor.isEmpty()) {
         return predecessor;
      } else {
         predecessor = (BSTNode<T>) node.getParent();
         while (predecessor != null && !predecessor.isEmpty()
                 && (predecessor.getData().compareTo(node.getData()) > 0)) {
            predecessor = (BSTNode<T>) predecessor.getParent();
         }
         if (predecessor != null && predecessor.isEmpty()) {
            return null;
         } else {
            return predecessor;
         }
      }
   }

   @Override
   public void remove(T element) {
      BSTNode<T> node = search(element);
      if (node != null && !node.isEmpty()) {
         remove(node);
      }
   }

   private void remove(BSTNode<T> node) {
      if(node.isLeaf())
         node.setData(null);
      else if ((node.getLeft().isEmpty() && !node.getRight().isEmpty())
              || (!node.getLeft().isEmpty() && node.getRight().isEmpty()))
         removeNode1(node);
      else
         removeNode2(node);
   }

   private boolean isLeftChild(BSTNode<T> node) {
      return node.getParent().getLeft().equals(node);
   }

   private void removeNode1(BSTNode<T> node) {
      if(node.getParent() != null){
         if(isLeftChild(node)) {
             if (!node.getLeft().isEmpty() && node.getLeft() != null){
                 node.getParent().setLeft(node.getLeft());
                 node.getLeft().setParent(node.getParent());
             } else {
                 node.getParent().setLeft(node.getRight());
                 node.getRight().setParent(node.getParent());
             }
         } else {
               if(!node.getRight().isEmpty() && node.getRight() != null){
                  node.getParent().setRight(node.getRight());
                  node.getRight().setParent(node.getParent());
               } else {
                  node.getParent().setRight(node.getLeft());
                  node.getLeft().setParent(node.getParent());
               }
         }
      } else {
          if (node.getLeft().isEmpty())
              root = (BSTNode<T>) node.getRight();
          else
              root = (BSTNode<T>) node.getLeft();
          root.setParent(null);
      }
   }

   private void removeNode2(BSTNode<T> node) {
       BSTNode tempNode = sucessor(node);
       node.setData((T) tempNode.getData());
       remove(tempNode);
   }

   @Override
   public T[] preOrder() {
      T[] array = (T[]) new Comparable[this.size()];
      preOrder(array, this.root, 0);
      return array;
   }

   private int preOrder(T[] array, BSTNode<T> node, int index) {
      if (!node.isEmpty()) {
         array[index] = node.getData();
         index++;
         index = preOrder(array, (BSTNode<T>) node.getLeft(), index);
         index = preOrder(array, (BSTNode<T>) node.getRight(), index);
      }
      return index;

   }

   @Override
   public T[] order() {
      T[] array = (T[]) new Comparable[this.size()];
      order(array, this.root, 0);
      return array;
   }

   private int order(T[] array, BSTNode<T> node, int index) {
      if (!node.isEmpty()) {
         index = order(array, (BSTNode<T>) node.getLeft(), index);
         array[index] = node.getData();
         index++;
         index = order(array, (BSTNode<T>) node.getRight(), index);
      }
      return index;
   }

   @Override
   public T[] postOrder() {
      T[] array = (T[]) new Comparable[this.size()];
      postOrder(array, this.root, 0);
      return array;
   }

   private int postOrder(T[] array, BSTNode<T> node, int index) {
      if (!node.isEmpty()) {
         index = postOrder(array, (BSTNode<T>) node.getLeft(), index);
         index = postOrder(array, (BSTNode<T>) node.getRight(), index);
         array[index] = node.getData();
         index++;
      }
      return index;
   }

   /**
    * This method is already implemented using recursion. You must understand
    * how it work and use similar idea with the other methods.
    */
   @Override
   public int size() {
      return size(root);
   }

   private int size(BSTNode<T> node) {
      int result = 0;
      // base case means doing nothing (return 0)
      if (!node.isEmpty()) { // indusctive case
         result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
      }
      return result;
   }
}
