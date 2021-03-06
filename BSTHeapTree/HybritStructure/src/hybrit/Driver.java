package hybrit;

public class Driver {

	public static void main(String[] args) {
		System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        MinHeap minHeap2 = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
        
      minHeap2.insert(15);
        minHeap2.insert(25);
        minHeap2.insert(35);
        minHeap2.insert(2);
        minHeap2.insert(55);
        minHeap2.insert(7);
        minHeap.minHeap();
        minHeap.printAll();
        minHeap.heapMerge(minHeap, minHeap2);
        System.out.println(minHeap.search(36));
       minHeap.print();
       System.out.println("The Min val is " + minHeap.removet());
        System.out.println("sonra ");
        minHeap.printAll();
        System.out.println("iter ");

        while(minHeap.hasNext()) {
        	System.out.println(minHeap.next());
        }
        
        
        System.out.println("The Min Heap is ");
        BSTHeapTree tree =new BSTHeapTree();  // build BST Heap tree
        tree=tree.createBinaryTree(); // add value function
        tree.traverseInOrder(tree.root);
        tree.remove(5);
        System.out.println("remove ");
        tree.traverseInOrder(tree.root);
        System.out.println("find: " +tree.find(6));
        
        System.out.println("There are 10 number in heap");
        for(int i=0;i<100;i++) {
        	System.out.println("find: " +tree.find(tree.getSaveNumber(i)));
        }
        System.out.println("There arent 10 number in heap");
        System.out.println("find: " +tree.find(6000));
        System.out.println("find: " +tree.find(6055));
        System.out.println("find: " +tree.find(-26));
        System.out.println("find: " +tree.find(5156));
        System.out.println("find: " +tree.find(5556));
        System.out.println("find: " +tree.find(7000));
        System.out.println("find: " +tree.find(-6));
        System.out.println("find: " +tree.find(-46));
        
        System.out.println("find mode: " +tree.find_mode());
        
        for(int i=0;i<100;i++) {
        	System.out.println("Remove Number: " + tree.getSaveNumber(i) + "  remove : " +tree.remove(tree.getSaveNumber(i)));
        }
        System.out.println("After Remove (-1 is none number)");
        for(int i=0;i<100;i++) {
        	System.out.println("save Number: " + tree.getSaveNumber(i) + "  Number of occurrences: " +tree.find(tree.getSaveNumber(i)));
        }
        
	}

}
