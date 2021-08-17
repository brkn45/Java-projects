package hybrit;

import hybrit.BSTHeapTree.Node;
import java.util.Random;
public class BSTHeapTree {
	Node root;
	class Node {
	    bstHeap heap =new bstHeap(7);
	    Node left;
	    Node right;
	    int count;
	    Node(int value) {
	        //this.heap.insert(value); 
	        right = null;
	        left = null;
	    }
	}
	
	private Node addRecursive(Node current, int value) {
		
		if (current == null) {
			Node tmp= new Node(value);
			//System.out.println("Burada1");
			tmp=addRecursive(tmp, value);
	        return tmp;
	        
	    }
		else if(current.heap.getSize()>=7) {
			
			if (value < current.heap.getValue(0)) {
		        current.left = addRecursive(current.left, value);
		    } else if (value > current.heap.getValue(0)) {
		        current.right = addRecursive(current.right, value);
		    } else {
		        // value already exists
		    	if(containsNode( value)) {
		    		setCount(value,+1,root);
		    		return current;
		    	}
		        return current;
		    }
	    	return current;
		    
	    }
	    else {
	    	//System.out.println("Burada3");
	    	if(containsNode( value)) {
	    		setCount(value,+1,root);
	    		return current;
	    	}
	    	else {
	    		current.heap.insert(value);
		    	return current;
	    	}
	    }
	}
	public boolean setCount(int value,int num,Node current) {
		 
	    if ( current.heap.search(value)) {
	       current.heap.setCount(value,num);
	    } 
	    return value < current.heap.getValue(0)
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if ( current.heap.search(value)) {
	    	tmpNode=current;
	        return true;
	    } 
	    return value < current.heap.getValue(0)
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	public int find(int value,Node current) {
		int tmpIndex;
		if(containsNode(value)) {
			return tmpNode.heap.getCount(tmpNode.heap.getIndex(value));
		}
		else {
			return -1;
		}
		
	    
	      
	       
	}
	public int find(int value) {
		return find(value,root);
	}
	private int [] saveNumber = new int[100];
	public int getSaveNumber(int pindex) {
		if(pindex<100) {
			return saveNumber[pindex];
		}
		else {
			return -1;
		}
		
	}
	
	/*
	 * @return BST instance 
	 * add value in BSTTrreHeap
	 */
	
	public BSTHeapTree createBinaryTree() {
		BSTHeapTree bt = new BSTHeapTree();
		
	    bt.add(5);
	    bt.add(3);
	    bt.add(17);
	    bt.add(10);
	    bt.add(84);
	    bt.add(19);
	    bt.add(6);
	    bt.add(6);  // most value
	    bt.add(6);
	    bt.add(6);
	    bt.add(22);
	    bt.add(9);
	    int tmpNum=0;
	    for(int i=0;i< 3000 ;i++) {
	    	Random rand  = new Random();
	    	tmpNum=rand.nextInt(5000);
	    	bt.add(tmpNum);
			if(i<100) {
				
				bt.saveNumber[i]=tmpNum;
			}
			System.out.println("onuncu"+saveNumber[10]);
	    }
	    return bt;
	}
	
	
	
	
	private int deleteRecursive(Node current, int value) {
	    int num;
		if (current == null) {
	        return 0;
	    }

	    if (current.heap.search(value)) {
	        return current.heap.remove(value);
	    } 
	    if (value < current.heap.getValue(0)) {
	        num = deleteRecursive(current.left, value);
	        return num;
	    }
	    num = deleteRecursive(current.right, value);
	    return num;
	}
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.println("heap");
	        node.heap.printAll();
	        traverseInOrder(node.right);
	    }
	}
	public int remove(int item) {
		return deleteRecursive(root, item);
	}
	Node tmpNode;
	int CountIndex;
	int tmpCount=0;
	public int find_mode () {
		frequency(root);
		return tmpNode.heap.getValue(CountIndex);
	}
				
	private void frequency(Node current) {
		
		
		if(current !=null) {
			frequency(current.left);
			for(int i=0;i< current.heap.getSize();i++) {
				if(tmpCount < current.heap.getCount(i)) {
					tmpNode=current;
					CountIndex=i;
					tmpCount =current.heap.getCount(i);
				}
			}
			frequency(current.right);
		}
		
	}
	
	
	
	public static void main(String[] arg)
    {
        
        
    }
    
	
	
}
