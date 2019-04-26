package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

   protected T data;
   protected RecursiveSingleLinkedListImpl<T> next;

   public RecursiveSingleLinkedListImpl() {
   }

   @Override
   public boolean isEmpty() {
      return getData() == null;
   }

   @Override
   public int size() {
      if (isEmpty())
         return 0;

      return 1 + getNext().size();
   }

   @Override
   public T search(T element) {
      if (element != null && !isEmpty()) {
         if (getData().equals(element))
            return getData();
         else
            return getNext().search(element);
      }
      return null;
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         if (isEmpty()) {
            setData(element);
            setNext(new RecursiveSingleLinkedListImpl<>());
         } else {
            getNext().insert(element);
         }
      }
   }

   @Override
   public void remove(T element) {
      if (element != null && !isEmpty() && getData() != null) {
         if (getData().equals(element)) {
            setData(getNext().getData());
            setNext(getNext().getNext());
         } else {
            getNext().remove(element);
         }
      }
   }

   @Override
   public T[] toArray() {
      T[] array = (T[]) new Comparable[size()];
      if (size() > 0) {
         array[0] = getData();
         listToArray(array, getNext(), 1);
      }
      return array;
   }

   public void listToArray(T[] array, RecursiveSingleLinkedListImpl node, int i) {
      if (node.getData() != null && i < size()) {
         array[i] = (T) node.getData();
         listToArray(array, node.getNext(), i + 1);
      }
   }

   public T getData() {
      return data;
   }

   public void setData(T data) {
      this.data = data;
   }

   public RecursiveSingleLinkedListImpl<T> getNext() {
      return next;
   }

   public void setNext(RecursiveSingleLinkedListImpl<T> next) {
      this.next = next;
   }

}
