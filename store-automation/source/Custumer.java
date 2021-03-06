package Store;



public class Custumer extends User {
	
	
	private String email;
	private Furniture [] basket;
	private int basketNumber=0;
	private int custumerId;
	private Data data;
	private int orderStatus=0;
	Custumer(String firstName,String lastName,String password,String email,int custumerId){
		super(custumerId,firstName,lastName,password);
		this.custumerId=custumerId;
		this.email=email;
		
		
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setStatus(int newStatus){
		this.orderStatus=newStatus;
	}
	public void setData(Data data) {
		this.data=data;
	}
	public int getBasketNumber() {
		return basketNumber;
	}
	public void addBasketNumber(int number) {
		this.basketNumber= this.basketNumber + number;
	}
	public Furniture getBasket(int index) {
		return basket[index];
	}
	public void basketSwap(Furniture [] tmp ) {
		this.basket = tmp;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public void setCustomerId(int custumerId) {
		this.custumerId= custumerId;	
	}
	
	
	public int getcustumerID() {
		return custumerId;
	}
	public String get() {
		
		return "none";
	}
	public Boolean buy() {
	
		return true;
	}
	public Boolean subscribe() {
		
		return false;
	}
	
	
	public String getBasket() {
		
		return "basket";
	}
	public void search() {
		
	}
	public  Boolean order() {
	
		return true;
	}
	
	public Boolean addBasket(int productId) {
		int i=0;
		if(this.findFurniture(productId)==null) {
			System.out.print("Product didnt add");
			return false;
		}
		Furniture newBasketProduct = this.findFurniture(productId);
		this.addBasketNumber(1);
		Furniture tmp[]= new Furniture[this.getBasketNumber()];
		
		for(i=0;i<this.getBasketNumber()-1;i++) {
			tmp[i]= this.getBasket(i);
		}
		tmp[i]=newBasketProduct;
		this.basketSwap(tmp);
		return true;
	}
	public Boolean removeBasket(int productId) {
		int i=0,index=0 ,flag=0;
		if( null== findFurniture(productId)) {
			System.out.println("did n^t find product");
			return false;
		}
		Product removeFurniture = findFurniture(productId);
		Furniture tmp[]= new Furniture[data.getFurnitureNumber()-1];
		for(i=0;i<this.getBasketNumber();i++) {
			if(removeFurniture.equals(this.getBasket(i))) {
				index=i;
				flag=1;
			}
		}
		if(flag==1) {
			for(i=0;i<index;i++) {
				tmp[i]=this.getBasket(i);
			}
			for(i=index+1;i<this.getBasketNumber();i++) {
				tmp[i-1]=this.getBasket(i);
			}
			this.addBasketNumber(-1);;
			this.basketSwap(tmp);
			return true;
			}
		else {
			return false;
		}
		
	
	}
	public Furniture findFurniture(int productId) {
		for(int i=0;i<data.getFurnitureNumber();i++) {
			if(data.getFurniture(i).getProductNumber()== productId) {
				return data.getFurniture(i);
			}
		}
		return null;
	}
	
	public void printBasket() {
		System.out.println("              -----------------------------------------");
	  	System.out.println("              |            Furniture List             |");
		System.out.println("              -----------------------------------------");
		System.out.println("Number:" + this.getBasketNumber());
		for(int i=0;i<this.getBasketNumber();i++) {
			
		  	System.out.println("Furniture Name  :   "+ this.getBasket(i).getProductName());
			System.out.println("-----------------------------------------");
			System.out.println("ID Number       :   "+ this.getBasket(i).getProductNumber());
		  	System.out.println("Model           :   "+ this.getBasket(i).getModelNumber());
			System.out.println("Color           :   "+ this.getBasket(i).getColor());
			System.out.println("-----------------------------------------");
		}
	}
	

}
