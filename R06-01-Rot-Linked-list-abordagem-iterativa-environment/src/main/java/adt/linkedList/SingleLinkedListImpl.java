package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

   protected SingleLinkedListNode<T> head;

   public SingleLinkedListImpl() {
      this.head = new SingleLinkedListNode<T>();
   }

   @Override
   public boolean isEmpty() {
      return this.size() == 0;
   }

   @Override
   public int size() {
      int size = 0;
      SingleLinkedListNode<T> auxHead = getHead();

      while (!auxHead.isNIL()) {
         size++;
         auxHead = auxHead.getNext();
      }

      return size;
   }

   @Override
   public T search(T element) {
      T result = null;

      if (!isEmpty() && element != null) {

         if (getHead().getData().equals(element)) {
            result = getHead().getData();
         }

         else {
            SingleLinkedListNode<T> auxHead = getHead();

            while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
               auxHead = auxHead.getNext();
            }

            result = auxHead.getData();
         }
      }
      return result;
   }

   @Override
   public void insert(T element) {
	   if (element != null) {

		   SingleLinkedListNode<T> newHead;
		   SingleLinkedListNode<T> auxHead = getHead();

		   if (auxHead.isNIL()) {
			   newHead = new SingleLinkedListNode<T>(element, auxHead);
			   setHead(newHead);
		   } else {
			   while (!auxHead.getNext().isNIL()) {
				   auxHead = auxHead.getNext();
			   }

			   newHead = new SingleLinkedListNode<T>(element, auxHead.getNext());
			   auxHead.setNext(newHead);
		   }
	   }
   }

   @Override
   public void remove(T element) {

      if (isEmpty() || element == null) {
         return;
      }

      else if (getHead().getData().equals(element)) {
         setHead(getHead().getNext());
      }

      else {

         SingleLinkedListNode<T> auxHead = getHead();
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
      SingleLinkedListNode<T> auxHead = getHead();
      T[] array = (T[]) new Object[size()];
      int index = 0;

      while (index != size()) {
         array[index] = auxHead.getData();
         auxHead = auxHead.getNext();
         index++;
      }

      return array;
   }

   public SingleLinkedListNode<T> getHead() {
      return head;
   }

   public void setHead(SingleLinkedListNode<T> head) {
      this.head = head;
   }

}
