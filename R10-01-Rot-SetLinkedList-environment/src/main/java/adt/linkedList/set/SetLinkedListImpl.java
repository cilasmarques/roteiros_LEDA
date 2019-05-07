package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

   @Override
   public void removeDuplicates() {
      SingleLinkedListNode<T> tempHead = this.getHead();

      if (isEmpty()){return;}

      while (!tempHead.isNIL()) {
         SingleLinkedListNode<T> iNode = tempHead.getNext();

         while (!iNode.isNIL()) {
            if (tempHead.getData().equals(iNode.getData()))
               iNode.setData(null);
            iNode = iNode.getNext();
         }
         tempHead = tempHead.getNext();
      }
   }

   @Override
   public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
   		if (this.isEmpty()) return otherSet;
 	  	else if (otherSet.isEmpty()) return this;

 	  	SingleLinkedListNode auxHead = this.getHead();
 	  	while (!auxHead.isNIL()) {
 	  		otherSet.insert((T) auxHead.getData());
 	  		auxHead = auxHead.getNext();
 	  	}

      	return otherSet;
   }

   @Override
   public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
	   if (this.isEmpty()) return otherSet;
	   else if (otherSet.isEmpty()) return this;

	   SingleLinkedListNode auxHead = this.getHead();
	   SetLinkedList<T> intersecSet = new SetLinkedListImpl<>();

       while (!auxHead.isNIL()) {
          if (otherSet.search((T) auxHead.getData()) != null)
          	intersecSet.insert((T) auxHead.getData());
          auxHead = auxHead.getNext();
       }

       return intersecSet;
   }

   @Override
   public void concatenate(SetLinkedList<T> otherSet) {
	   if (this.isEmpty() || otherSet.isEmpty()) return ;

	   SingleLinkedListNode<T> auxHead = this.getHead();

	   while (!auxHead.getNext().isNIL()) { auxHead = auxHead.getNext(); }

	   SingleLinkedListNode<T> auxHead2 = ((SingleLinkedListImpl<T>) otherSet).getHead();

	   auxHead.setNext(auxHead2);
   }

}
