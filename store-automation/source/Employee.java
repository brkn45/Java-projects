package Store;
/**
*Administrator class for funiture company. Implement CompanyAdministrator.
*@author Berkan_akin_171044073
*/
public class Employee extends User {
	private int branchId;
	private Data data;
	private Furniture [] order;
	private int orderNumber;
	Employee(int branchId,int id,String firstName,String lastName, String password){
		
		super(id,firstName,lastName,password);
		this.branchId=branchId;
		this.orderNumber=0;
	}
	
	public void setData(Data data) {
		this.data=data;
	}
	
	public void setBranchId(int branchId) {
		this.branchId=branchId;
	}
	public int getBranchId() {
		return branchId;
	}
	
	public void search() {
		
	}
	public  Boolean orderControl() {
		
		return true;
	}
	public Boolean addProduct() {
		return true;
	}
	public Boolean addFurniture(Furniture newFurniture) {
		int i=0;
		
		data.addFurnitureNumber(1);
		Furniture tmp[]= new Furniture[data.getFurnitureNumber()];
		
		for(i=0;i<data.getFurnitureNumber()-1;i++) {
			tmp[i]= data.getFurniture(i);
		}
		tmp[i]=newFurniture;
		data.FurnitureSwap(tmp);
		return true;
	}
	public Furniture findFurniture(int productId) {
		for(int i=0;i<data.getFurnitureNumber();i++) {
			if(data.getFurniture(i).getProductNumber()== productId) {
				return data.getFurniture(i);
			}
		}
		return null;
	}
	public Boolean removeFurniture(int productId) {
		int i=0,index=0 ,flag=0;
		Furniture removeFurniture = findFurniture(productId);
		Furniture tmp[]= new Furniture[data.getFurnitureNumber()-1];
		for(i=0;i<data.getFurnitureNumber();i++) {
			if(removeFurniture.equals(data.getFurniture(i))) {
				index=i;
				flag=1;
			}
		}
		if(flag==1) {
			for(i=0;i<index;i++) {
				tmp[i]=data.getFurniture(i);
			}
			for(i=index+1;i<data.getFurnitureNumber();i++) {
				tmp[i-1]=data.getFurniture(i);
			}
			data.addFurnitureNumber(-1);
			data.FurnitureSwap(tmp);
			return true;
			}
		else {
			return false;
		}
		
	
	}
	
	public Boolean addOrder(Furniture order) {
		int i=0;
		
		
		this.addOrderNumber(1);
		Furniture tmp[]= new Furniture[this.getOrderNumber()];
		
		for(i=0;i<this.getOrderNumber()-1;i++) {
			tmp[i]= this.getOrder(i);
		}
		tmp[i]=order;
		this.orderSwap(tmp);
		return true;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void addOrderNumber(int number) {
		orderNumber = orderNumber +number;
	}
	public void orderSwap(Furniture [] tmp) {
		this.order=tmp;
	}
	public Furniture getOrder(int index) {
		return order[index];
	}
	public void  printOrder() {
		System.out.println("              -----------------------------------------");
	  	System.out.println("              |              Order List               |");
		System.out.println("              -----------------------------------------");
		for(int i=0;i<this.getOrderNumber();i++) {
			
		  	System.out.println("Furniture Name  :   "+ this.getOrder(i).getProductName());
			System.out.println("-----------------------------------------");
			System.out.println("ID Number       :   "+ this.getOrder(i).getProductNumber());
		  	System.out.println("Model           :   "+ this.getOrder(i).getModelNumber());
			System.out.println("Color           :   "+ this.getOrder(i).getColor());
			System.out.println("-----------------------------------------");
		}
	}
}
