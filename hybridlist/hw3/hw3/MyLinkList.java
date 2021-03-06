package hw3;

public class MyLinkList <E> {
	private static class Node<E>{
		private E data;
		private Node <E> next;
		
		private Node(E dataItem) {
			data =dataItem;
			next=null;
		}
		private Node(E dataItem,Node<E> nodeRef) {
			data =dataItem;
			next=nodeRef;
		}
	}
	private Node<E> head =null;
	private int size=0;
	public int getSize() {
		return size;
	}
	private void addFirst(E item) {
		head = new Node<> (item,head);
		size++;
	}
	
	private void addAfter(Node<E> node,E item) {
		node.next = new Node<> (item,node.next);
		size++;
	}
	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;
		if(temp !=null) {
			node.next=temp.next;
			size--;
			return temp.data;
		}
		else {
			return null;
		}
	}
	
	private E removeFirst() {
		Node<E> temp =head;
		if(head != null) {
			head = head.next;
		}
		if(temp != null) {
			size--;
			return temp.data;
		}
		else {
			return null;
		}
	}	
		private Node<E> getNode(int index){
			Node<E> node = head;
			for(int i=0; i <index && node !=null;i++) {
				node=node.next;
			}
			return node;
		}
		
		public E get(int index) {
			if(index < 0 || index >= size) {
				//throw
			}
			Node <E> node =getNode(index);
			return node.data;
		}
		public E set(int index,E newValue) {
			if(index < 0 || index >=size) {
				//throw
			}
			Node<E> node = getNode(index);
			E result =node.data;
			node.data=newValue;
			return result;
		}
		
		public void add(int index,E item) {
			if(index <0 || index > size) {
				//throw
			}
			if(index==0) {
				addFirst(item);
			}
			else {
				Node<E> node =getNode(index-1);
				addAfter(node,item);
			}
			
		}
		public boolean add(E item) {
			add(size,item);
			return true;
		}
		
		public boolean remove(int index) {
			 
			// if the index is out of range, exit
			if (index < 1 || index > size)
				return false;
	 
			Node temp = head;
			if (head != null) {
				for (int i = 0; i < index; i++) {
					temp=temp.next;
	 
					
				}
				temp=temp.next.next;
	 
				// decrement the number of elements variable
				size--;
				return true;
	 
			}
			return false;
		}
	
	
	
	
	
	
	
	
	
	
	
}
