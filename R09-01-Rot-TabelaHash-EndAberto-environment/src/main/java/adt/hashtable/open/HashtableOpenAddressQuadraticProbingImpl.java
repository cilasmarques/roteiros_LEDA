package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}


	@Override
	public void insert(T element) {
		if (element == null)
			return;

		if (isFull())
			throw  new HashtableOverflowException();

		for (int probe = 0; probe < this.table.length; probe++) {
			int hash = getHash(element, probe);
			if (this.table[hash] == null || this.table[hash].equals(deletedElement)){
				this.table[hash] = element;
				break;
			}
			COLLISIONS ++;
		}
		elements++;
	}

	@Override
	public void remove(T element) {
		int index = indexOf(element);

		if (index >= 0 && this.table[index] != null && !(this.table[index].equals(deletedElement))) {
			this.table[index] = deletedElement;
			elements--;
		}
	}

	@Override
	public T search(T element) {
		if (indexOf(element) >= 0 && element != null)
			return element;

		return null;
	}

	@Override
	public int indexOf(T element) {
		if (!isEmpty() && element != null){
			for (int probe = 0; probe < this.table.length; probe++) {
				int hash = getHash(element, probe);
				if (this.table[hash] == null)
					return -1;
				if (this.table[hash].equals(element))
					return hash;
			}
		}
		return -1;
	}

	private int getHash(T element, int probe) {
		return ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
	}
}
