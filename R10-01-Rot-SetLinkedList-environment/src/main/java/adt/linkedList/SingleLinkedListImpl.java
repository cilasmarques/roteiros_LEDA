package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

   protected SingleLinkedListNode<T> head;

   public SingleLinkedListImpl() {
      this.head = new SingleLinkedListNode<T>();
   }

   @Override
   public boolean isEmpty() {
      return size() == 0;
   }

   @Override
   public int size() {
      SingleLinkedListNode<T> auxHead = this.getHead();
      int size = 0;

      while (!auxHead.isNIL()) {
         size++;
         auxHead = auxHead.getNext();
      }

      return size;
   }

   @Override
   public T search(T element) {
      if (element != null && !isEmpty()) {
         SingleLinkedListNode<T> auxHead = this.getHead();

         while (!auxHead.getNext().isNIL()) {
            if (auxHead.getData().equals(element))
               return element;
            auxHead = auxHead.getNext();
         }
      }

      return null;
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         SingleLinkedListNode<T> auxHead = this.getHead();

         if (this.getHead().isNIL()) {
            this.head.setData(element);
            this.head.setNext(new SingleLinkedListNode<>());
         } else {
            while (!auxHead.isNIL()) {
               auxHead = auxHead.getNext();
            }
            auxHead.setData(element);
            auxHead.setNext(new SingleLinkedListNode<>());
         }
      }
   }

   @Override
   public void remove(T element) {
      if (element != null && !isEmpty()) {
         SingleLinkedListNode<T> auxHead = this.getHead();
         SingleLinkedListNode<T> previousAuxHead = auxHead;

         while (!auxHead.getData().equals(element) && !auxHead.getNext().isNIL()) {
            previousAuxHead = auxHead;
            auxHead = auxHead.getNext();
         }

         previousAuxHead.setNext(auxHead.getNext());
      }
   }

   @Override
   public T[] toArray() {
      SingleLinkedListNode<T> auxHead = this.getHead();
      T[] a = (T[]) new Comparable[size()];

      for (int i = 0; i < size(); i++) {
         a[i] = auxHead.getData();
         auxHead = auxHead.getNext();
      }

      return a;
   }

   public SingleLinkedListNode<T> getHead() {
      return head;
   }

   public void setHead(SingleLinkedListNode<T> head) {
      this.head = head;
   }

}
