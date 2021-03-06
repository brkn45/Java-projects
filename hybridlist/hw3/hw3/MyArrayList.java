package hw3;

import java.util.Arrays;

public class MyArrayList <E> {
	
	private static final int INITIAL_CAPACITY =10;
	private E[] theData;
	private int size=0;
	private int capacity=0;
	
	public MyArrayList() {
		capacity=INITIAL_CAPACITY;
		theData =(E[]) new Object[capacity];
	}
	
	public boolean add(E anEntry) {
		if(size==capacity) {
			//reallocate();
		}
		theData[size]= anEntry;
		size++;
		return true;
	}
	
	public void add(int index,E anEntry) {
		if(index < 0  || index > size) {
			//throw new ArrayIndexOutBoundsExeception(index);
		}
		if(size==capacity) {
			//reallocate();
		}
		for(int i=size;i > index ;i--) {
			theData[i] = theData[i-1];
		}
		
		theData[index] =anEntry;
		size++;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			//throw
		}
		
		return theData[index];
	}
	
	public E set(int index, E newValue) {
		if(index < 0 || index >= size) {
			//throw
		}
		E oldValue =theData[index];
		theData[index] = newValue;
		return oldValue;
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size) {
			//throw
		}
		E returnValue =theData[index];
		for(int i=index +1; i < size ; i++) {
			theData[i-1] = theData[i];
		}
		size--;
		return returnValue;
	}
	
	private void reallocate() {
		capacity=2*capacity;
		theData = Arrays.copyOf(theData, capacity);
	}
	public int getSize() {
		return size;
	}
	
	
	
	
	
	
}
