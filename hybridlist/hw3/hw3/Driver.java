package hw3;

public class Driver {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		HybridList hybridlist = new HybridList();
		MyLinkList linklist = new MyLinkList();
		
		hybridlist.add(10);
		hybridlist.add(20);
		hybridlist.add(30);
		hybridlist.add(40);
		hybridlist.add(50);
		hybridlist.add(60);
		hybridlist.add(70);
		hybridlist.add(80);
		hybridlist.add(90);
		System.out.println("hybrid List Testing");
		hybridlist.pirntS();
		System.out.println("Hybrid Functions Testing");
		System.out.println("num: " + hybridlist.get(8));
		System.out.println("before" +hybridlist.set(8,44));
		System.out.println("num: " + hybridlist.get(8));
		
		hybridlist.remove(5);
		hybridlist.pirntS();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(1,25);
		list.remove(2);
		list.set(0, 1);
		for(int i=0;i< list.getSize();i++) {
			System.out.println(list.get(i));
		}
		linklist.add(10);
		linklist.add(20);
		linklist.add(30);
		linklist.add(40);
		linklist.add(50);
		linklist.add(60);
		for(int i=0;i <linklist.getSize();i++) {
			System.out.println(linklist.get(i));
		}
		linklist.add(2,25);
		linklist.add(5,45);
		for(int i=0;i <linklist.getSize();i++) {
			System.out.println(linklist.get(i));
		}
		System.out.println("Set Testing");
		linklist.set(1, 15);
		for(int i=0;i <linklist.getSize();i++) {
			System.out.println(linklist.get(i));
		}
		System.out.println("Remove Testing");
		linklist.remove(2);
		linklist.remove(0);
		for(int i=0;i <linklist.getSize();i++) {
			System.out.println(linklist.get(i));
		}
	}

}
