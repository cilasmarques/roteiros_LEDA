package adt.linkedList.batch;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * ATENÇÃO: NAO MODIFIQUE NENHUMA OUTRA CLASSE ALEM DESTA !!!!! 
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/* 
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>)head;
	}

	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {
		SingleLinkedListNode iNode = this.getHead();

		for (int i = 0; i < posicao; i++) {iNode = iNode.getNext();}

		for (int j = 0; j < elementos.length; j++){
			if(isEmpty()){
				iNode.setData(elementos[j]);
				setHead(iNode);
			} else {
				SingleLinkedListNode tempNext = iNode.getNext();
				iNode.setNext(new SingleLinkedListNode(elementos[j], tempNext));
				iNode = iNode.getNext();
			}
		}
	}

	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {
		SingleLinkedListNode iNode = this.getHead();

		for (int i = 0; i < posicao-1; i++) {iNode = iNode.getNext();}

		for (int j = 0; j < quantidade; j++) {
			SingleLinkedListNode iNextNode = iNode.getNext();
			iNode.setNext(iNextNode.getNext());
		}
	}

	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>)getHead();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result += " ";
			}
				
			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();
			
		}
		
		return result;
	}
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead() 
	 * 
	 */
	public String toStringFromLast() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result = " " + result;
			}
				
			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();
			
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return toStringFromHead();
	}


}
