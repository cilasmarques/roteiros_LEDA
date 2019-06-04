package adt.avltree;

import adt.bst.BSTNode;

import java.util.ArrayList;
import java.util.Arrays;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

   private int LLcounter;
   private int LRcounter;
   private int RRcounter;
   private int RLcounter;

   public AVLCountAndFillImpl() {
   }

   @Override
   public int LLcount() {
      return LLcounter;
   }

   @Override
   public int LRcount() {
      return LRcounter;
   }

   @Override
   public int RRcount() {
      return RRcounter;
   }

   @Override
   public int RLcount() {
      return RLcounter;
   }

   @Override
   protected void rebalance(BSTNode<T> node) {
      if (!node.isEmpty()) {
         if (calculateBalance(node) > 1) {
            if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
               rightRotation(node);
               LLcounter++;
            } else {
               leftRotation((BSTNode<T>) node.getLeft());
               rightRotation(node);
               LRcounter++;
            }
         } else if (calculateBalance(node) < -1) {
            if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
               leftRotation(node);
               RRcounter++;
            } else {
               rightRotation((BSTNode<T>) node.getRight());
               leftRotation(node);
               RLcounter++;
            }
         }
      }
   }

   @Override
   public void fillWithoutRebalance(T[] array) {
      if (array != null && array.length != 0) {
         T[] aux = concatenate(array, order());
         Arrays.sort(aux);

         ArrayList<T> fullArray = new ArrayList<T>(Arrays.asList(aux));

         while (!fullArray.isEmpty()) {
            int middle = fullArray.size() / 2;
            insert(fullArray.get(middle));
            fullArray.remove(middle);
            clean();
         }
      }
   }

   private void clean() {
      this.root = new BSTNode<T>();
      this.LLcounter = 0;
      this.RRcounter = 0;
      this.LRcounter = 0;
      this.RLcounter = 0;
   }

   @SuppressWarnings("unchecked")
   private T[] concatenate(T[] array, T[] order) {
      T[] newArray = (T[]) new Comparable[array.length + order().length];

      int i = 0;

      for (T element : array) {
         newArray[i] = element;
         i++;
      }

      for (T element : order()) {
         newArray[i] = element;
         i++;
      }
      return newArray;
   }

}
