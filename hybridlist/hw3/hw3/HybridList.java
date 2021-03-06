package hw3;



public class HybridList <E>{
	private  int size=0;
	private final int CAPACITY =5;
	private static class Node<E>{
		private MyArrayList<E> data =new MyArrayList();
		private Node <E> next;
		
		private Node(E dataItem) {
			data.add(dataItem);
			next=null;
			
		}
		private Node(E dataItem,Node<E> nodeRef) {
			data.add(dataItem);
			next=nodeRef;
			
		}
		
	}
	private Node<E> head =null;
	private Node<E> iter=null;
	
	
	public void add(E item) {
		if(size==0) {
			Node firstNode = new Node(item);
			head = firstNode;
			iter = firstNode;
			size++;
		}
		else if(size>=5 && size%CAPACITY ==0) {
			Node newNode = new Node(item);
			iter.next = newNode;
			iter =iter.next;
			size++;
			
		}
		else {
			iter.data.add(item);
			size++;
		}
		
	}
	
	public E get(int index) {
		Node temp =head;
		int nodeNum=index/CAPACITY;
		int i=0;
		while(i<nodeNum) {
			temp=temp.next;
			i++;
		}
		return (E) temp.data.get(index%CAPACITY);
	}
	public E set(int index,E item) {
		Node temp =head;
		int nodeNum=index/CAPACITY;
		int i=0;
		if(index<0 || index>=size) {
			//throw
		}
		while(i<nodeNum) {
			temp=temp.next;
			i++;
		}
		return (E) temp.data.set(index%CAPACITY,item);
	}
	public void add(int index, E item) {
		int i=0,nodeNum=index /CAPACITY;
		int arrIndex=index%CAPACITY;
		E tmpValue;
		Node temp =head;
		if(index==size) {
			this.add(item);
			return;
		}
		while(i<nodeNum) {
			temp=temp.next;
			i++;
			
		}
		i=0;
		tmpValue = (E) this.set(index, item);
		index++;
		while(index<size) {
			if(index>=CAPACITY && index%CAPACITY==0) {
				temp=temp.next;
			}
			tmpValue =(E) this.set(index, tmpValue);
			index++;
		}
		this.add(tmpValue);
		
	}
	public E remove(int index) {
		E tmpValue=this.set(index, this.get(index+1));
		index++;
		while(index <size) {
			this.set(index, this.get(index+1));
			index++;
		}
		size--;
		return tmpValue;
	}
	public void pirntS() {
		Node <E> temp=head;
		int i=0;
		for(i=0;i<size;i++) {
			
			if(i>=CAPACITY && i%CAPACITY==0) {
				temp=temp.next;
			}
			System.out.println(temp.data.get(i%5));
		}
		
	}
	public int getSize() {
		return size;
	}
	
}
