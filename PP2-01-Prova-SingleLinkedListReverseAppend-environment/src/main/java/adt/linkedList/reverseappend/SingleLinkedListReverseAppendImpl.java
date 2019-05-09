package adt.linkedList.reverseappend;

import adt.linkedList.SingleLinkedListNode;

/**
 * 
 * @see SingleLinkedListReverseAppend
 * 
 * @author campelo
 *
 * @param <T>
 */
public class SingleLinkedListReverseAppendImpl<T> implements SingleLinkedListReverseAppend<T> {
	
	/*
	 * Nao remover esse atributo nem criar outros
	 */
	protected SingleLinkedListNode<T> head;
	
	/*
	 * Nao modifique o construtor
	 * @param head
	 */
	public SingleLinkedListReverseAppendImpl() {
		head = new SingleLinkedListNode<T>();
	}

	/* (non-Javadoc)
	 * @see adt.linkedList.reverseappend.SingleLinkedListReverseAppend#doIt(java.lang.Object)
	 * 
	 * Implemente apenas este metodo de acordo com os comentários da interface.
	 * 
	 */
	@Override
    public void doIt(T elem) {
		if (elem != null) {

			SingleLinkedListNode nodeCount = this.head;
			int listSize = 0;
			while (!nodeCount.isNIL()) {
				nodeCount = nodeCount.getNext();
				listSize++;
			}

			if (listSize > 1) {
				int indexRightNode = 0;
				int indexLeftNode = listSize - 2;

				while (indexRightNode < indexLeftNode) {
					SingleLinkedListNode rightNode = this.head;
					SingleLinkedListNode leftNode = rightNode.getNext();
					T rightValue = (T) rightNode.getData();
					T leftValue = (T) leftNode.getData();

					for (int i = 0; i < indexRightNode; i++) {
						rightNode = rightNode.getNext();
						rightValue = (T) rightNode.getData();
					}

					for (int j = indexRightNode; j < indexLeftNode; j++) {
						leftNode = leftNode.getNext();
						leftValue = (T) leftNode.getData();
					}

					rightNode.setData(leftValue);
					leftNode.setData(rightValue);
					indexRightNode++;
					indexLeftNode--;
				}
			}



				SingleLinkedListNode newNode = new SingleLinkedListNode();
				newNode.setNext(head.getNext());
				newNode.setData(head.getData());
				head.setData(elem);
				head.setNext(newNode);

		}
    }
    
	
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     */
	@Override
    public String toString() {
    	String retorno = "";
    	SingleLinkedListNode<T> currentNode = this.head;
    	while (currentNode!=null) {
    		if (!retorno.equals("")) {
    			retorno += " ";
    		}
    		retorno += currentNode;
    		currentNode = currentNode.getNext();
    	}
		return retorno;
    }
    
}
