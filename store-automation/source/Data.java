package Store;

public class Data  {
	private Admin [] admin; 
	private Furniture [] furniture;
	private Employee [] employee;
	private Branch [] branch;
	private Custumer[] custumer;
	/**
     * Constructor for the administrator with name,surname,id and its company.
     * @param No Parameter.
     * 
     */
	private int employeeNumber;
	private int furnitureNumber;
	private int branchNumber;
	private int custumerNumber;
	Data(){
		admin= new Admin[1];
		admin[0] = new Admin(this);
		this.autoFurniture();
		this.autoEmployee();
		this.autoCustumer();
		this.employeeNumber=0;
		this.furnitureNumber=0;
		this.branchNumber=0;
		this.custumerNumber=0;
		
	}
	
		   
	
	public void setAdmin(Admin [] admin) {
		this.admin = admin;
	}
	public Admin getAdmin(int index) {
		return admin[index];
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void addEmployeeNumber(int number) {
		employeeNumber=employeeNumber +number;
	}
	public Employee getEmployee(int index) {
		if(index<employeeNumber) {
			return employee[index];
		}
		else {
			System.out.println("Wrong I2ndex");
			return null;
		}	
	
	}
	public void  EmployeeSwap(Employee [] tmp) {
		this.employee =tmp;
	}
	
	public int getFurnitureNumber() {
		return furnitureNumber;
	}
	public void addFurnitureNumber(int number) {
		furnitureNumber=furnitureNumber +number;
	}
	public void FurnitureSwap(Furniture [] tmp) {
		furniture=tmp;
	}
	public Furniture getFurniture(int index) {
		return furniture[index];
	}
	public int getBranchNumber() {
		return branchNumber;
	}
	public void addBranchNumber(int number) {
		branchNumber=branchNumber + number;
	}
	public Branch getBranch(int index) {
		return branch[index];
	}
	public void branchSwap(Branch [] tmp) {
		branch=tmp;
	}
	
	/**
	 * Function default outo value
	 */
	private void autoFurniture() {
		final int officeChairModel   = 7;      final int officeChairColor   = 5;   final String chair    = "Office Chair";
		final int officeDeskModel    = 5;      final int officeDeskColor    = 4;   final String desk     = "Office Desk";
		final int meetingTableModel  = 10;     final int meetingTableColor  = 4;   final String table    = "Meting Table";
		final int bookcaseModel      = 12;     final int bookcaseColor      = 1;   final String bookcase = "Bookcase";	
		final int officeCabinetModel = 12;     final int officeCabinetColor = 1;   final String cabinet  = "Office Bookcase";
		
		this.makeFurniture(officeChairModel, officeChairColor, chair);
		this.makeFurniture(officeDeskModel, officeDeskColor, desk);
		this.makeFurniture(meetingTableModel, meetingTableColor, table);
		this.makeFurniture(bookcaseModel, bookcaseColor, bookcase);
		this.makeFurniture(officeCabinetModel, officeCabinetColor, cabinet);
	}
	private void makeFurniture(int model,int color,String name ) {
		Furniture newFurniture;
		for(int i=0;i<model;i++) {
			for(int k=0;k<color;k++) {
				if(k==0) {
					 newFurniture = new Furniture(name,(i*k)/5,getFurnitureNumber(),i,"Red");
				}
				else if(k==1){
					 newFurniture = new Furniture(name,(i*k)/5,getFurnitureNumber(),i,"Yellow");
				}
				else if(k==2) {
					 newFurniture = new Furniture(name,(i*k)/5,getFurnitureNumber(),i,"Black");
				}
				else if(k==3) {
					 newFurniture = new Furniture(name,(i*k)/5,getFurnitureNumber(),i,"White");
				}
				else if(k==4) {
					 newFurniture = new Furniture(name,(i*k)/5,getFurnitureNumber(),i,"Green");
				}
				else {
					newFurniture = new Furniture(name,(i*k)/5,getFurnitureNumber(),i,"Blue");
				}
				
				admin[0].addFurniture(newFurniture);
				
			}
		}
	}
	/**
	 * Function default outo value
	 */
	private void autoEmployee() {
		Employee mahmut = new Employee(0,this.getEmployeeNumber(),"mahmut","mentes","123");
		this.getAdmin(0).addBranchEmployee(mahmut);
		Employee bilal = new Employee(1,this.getEmployeeNumber(),"bilal","gok","123");
		this.getAdmin(0).addBranchEmployee(bilal);
		Employee arif = new Employee(2,this.getEmployeeNumber(),"arif","korkmaz","123");
		this.getAdmin(0).addBranchEmployee(arif);
		Employee talha = new Employee(3,this.getEmployeeNumber(),"talha","aydin","123");
		this.getAdmin(0).addBranchEmployee(talha);
		Employee ferhat = new Employee(4,this.getEmployeeNumber(),"ahmet","akin","123");
		this.getAdmin(0).addBranchEmployee(ferhat);
		
		
	}
	
	public void printEmployee() {
		for(int i=0;i<this.getEmployeeNumber();i++) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("First Name : " + this.getEmployee(i).getFirstName() + " |Last Name : " + this.getEmployee(i).getLastName()+ " |Branch Number :" + this.getEmployee(i).getBranchId() + "|ID Number :" + this.getEmployee(i).getId());
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		}
	}
	public void printBranch() {
		int flag=0;
		for(int i=0;i<this.getBranchNumber();i++) {
			
			for(int k=0;k<this.getEmployeeNumber();k++) {
				if(this.getBranch(i).getBranchId()==this.getEmployee(k).getBranchId()) {
					System.out.println("BranchId :" + this.getBranch(0).getBranchId() );
					System.out.println("-------------------------");
					System.out.println("Employee First Name: " + this.getEmployee(k).getFirstName());
					System.out.println("Employee Last  Name: " + this.getEmployee(k).getLastName());
					System.out.println("Employee ID        : " + this.getEmployee(k).getId());
					System.out.println("-------------------------%n");
					flag=1;
				}
			}
			if(flag==0) {
				System.out.println("BranchId :" + this.getBranch(0).getBranchId() );
				System.out.println("-------------------------");
				System.out.println("Branch Has Not Employee");
			}
			else {
				flag=0;
			}
		}
	}
	public void printFurniture() {
		System.out.println("              -----------------------------------------");
	  	System.out.println("              |            Furniture List             |");
		System.out.println("              -----------------------------------------");
		for(int i=0;i<this.getFurnitureNumber();i++) {
			
		  	System.out.println("Furniture Name  :   "+this.getFurniture(i).getProductName());
			System.out.println("-----------------------------------------");
			System.out.println("ID Number       :   "+ this.getFurniture(i).getProductNumber());
		  	System.out.println("Model           :   "+ this.getFurniture(i).getModelNumber());
			System.out.println("Color           :   "+ this.getFurniture(i).getColor());
			System.out.println("-----------------------------------------");
		}
	}
	
	public int getCustumerNumber() {
		return custumerNumber;
	}
	public void addCustumerNumber(int number) {
		custumerNumber=custumerNumber +1;
	}
	public Custumer getCustumer(int index) {
		return custumer[index];
	}
	public void custumerSwap(Custumer [] custumer) {
		this.custumer=custumer;
	}
	public Boolean addCustumer(Custumer newCustumer) {
		int i=0;
		
		this.addCustumerNumber(+1);
		Custumer tmp[]= new Custumer[this.getCustumerNumber()];
		
		for(i=0;i<this.getCustumerNumber()-1;i++) {
			tmp[i]= this.getCustumer(i);
		}
		tmp[i]=newCustumer;
		this.custumerSwap(tmp);
		return true;
	}
	
	public void printCustumer() {
		for(int i=0;i<this.getCustumerNumber();i++) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("First Name : " + this.getCustumer(i).getFirstName() + " |Last Name : " + this.getCustumer(i).getLastName() + "|Email :" + this.getCustumer(i).getEmail()+ " |Custumer Number :" + this.getCustumer(i).getcustumerID());
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

		}
	}
	
	private void autoCustumer() {
		Custumer ayse = new Custumer("ayse","ay","123","@",this.getCustumerNumber());
		this.addCustumer(ayse);
		Custumer aylin = new Custumer("aylin","al","123","@",this.getCustumerNumber());
		this.addCustumer(aylin);
		Custumer berkan = new Custumer("berkan","akin","123","@",this.getCustumerNumber());
		this.addCustumer(berkan);
	}
	
	public void searchProduct(String name) {
		
		for(int i=0;i<this.getFurnitureNumber();i++) {
			if(this.getFurniture(i).getProductName().equals(name)) {
				System.out.println("Furniture Name  :   "+this.getFurniture(i).getProductName());
				System.out.println("-----------------------------------------");
				System.out.println("ID Number       :   "+ this.getFurniture(i).getProductNumber());
			  	System.out.println("Model           :   "+ this.getFurniture(i).getModelNumber());
				System.out.println("Color           :   "+ this.getFurniture(i).getColor());
				System.out.println("-----------------------------------------");
			}
		}
	}

}
	
