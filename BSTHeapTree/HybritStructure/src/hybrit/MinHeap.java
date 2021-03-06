package hybrit;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Iterator;
public class MinHeap<T> implements Iterator {
    private int[] Heap;
    private int size;
    private int maxsize;
    int index=0;
    private static final int FRONT = 1;
  
    public MinHeap(int maxsize)
    {
        this.maxsize = 100;
        this.size = 0;
        Heap = new int[1000+ 1];
        Heap[0] = Integer.MIN_VALUE;
    }
  
    // Function to return the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos)
    {
        return pos / 2;
    }
  
    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
  
    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
  
    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
  
    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
  
    // Function to heapify the node at pos
    private void minHeapify(int pos)
    {
  
        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                || Heap[pos] > Heap[rightChild(pos)]) {
  
                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
  
                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
  
    // Function to insert a node into the heap
    public void insert(int element)
    {
        if (size >= maxsize) {
            return;
        }
        Heap[size] = element;
        int current = size;
        size++;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
  
    // Function to print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                             + " LEFT CHILD : " + Heap[2 * i]
                             + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
  
    // Function to build the min heap using
    // the minHeapify
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }
  public void printAll() {
	  for(int i=0;i< size;i++) {
		  System.out.println(Heap[i]);
	  }
  }
    // Function to remove and return the minimum
    // element from the heap
    public int removet()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
    public void heapMerge(MinHeap minHeap1,MinHeap minHeap2) {
    	for(int i=0;i<minHeap2.size;i++) {
    		minHeap1.insert(minHeap2.Heap[i]);
    	}
    	minHeap1.minHeap();
    }
    public boolean search(int value) {
    	for(int i=0;i<this.size;i++) {
    		if(this.Heap[i]==value) {
    			return true;
    		}
    	}
		return false;
    }
    
   

	@Override
	public boolean hasNext() {
		if(size >= index) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		int tmp=index;
		index++;
		return Heap[tmp];
	}

	
    
}   
