package Store;
/**
*Administrator class for funiture company. Implement CompanyAdministrator.
*@author Berkan_akin_171044073
*/

public class Admin extends User{
	/**
     * Constructor for the administrator with name,surname,id and its company.
     * @param Data Class.
     * 
     */
	private final String AdminFirstName ="berkan";
	private final String AdminLastName ="akin";
	private final String AdminPassword  ="123";
	
	private Data data;
	Admin(Data data){
		this.data =data;
	}
	
	public void setData(Data data) {
		this.data =data;
		
	}
	public Boolean addBranchEmployee(Employee newEmployee) {
		int i=0;
		
		data.addEmployeeNumber(+1);
		Employee tmp[]= new Employee[data.getEmployeeNumber()];
		
		for(i=0;i<data.getEmployeeNumber()-1;i++) {
			tmp[i]= data.getEmployee(i);
		}
		tmp[i]=newEmployee;
		data.EmployeeSwap(tmp);
		return true;
	}
	
	/*public Boolean addBranchEmployee(String firstName,String lastName) {
		int i=0;
		Employee newEmployee=findEmployeeObject(firstName,lastName);
		data.addEmployeeNumber(+1);
		Employee tmp[]= new Employee[data.getEmployeeNumber()];
		
		for(i=0;i<data.getEmployeeNumber()-1;i++) {
			tmp[i]= data.getEmployee(i);
		}
		tmp[i]=newEmployee;
		data.EmployeeSwap(tmp);
		return true;
	}*/
	
	public Boolean removeEmployee(String firstName,String lastName) {
		int i=0,index=0 ,flag=0;
		if(null==findEmployeeObject(firstName,lastName)) {
			return false;
		}
		Employee removeEmployee=findEmployeeObject(firstName,lastName);
		Employee tmp[]= new Employee[data.getEmployeeNumber()-1];
		for(i=0;i<data.getEmployeeNumber();i++) {
			if(removeEmployee.equals(data.getEmployee(i))) {
				index=i;
				flag=1;
			}
		}
		if(flag==1) {
			for(i=0;i<index;i++) {
				tmp[i]=data.getEmployee(i);
			}
			for(i=index+1;i<data.getEmployeeNumber();i++) {
				tmp[i-1]=data.getEmployee(i);
			}
			data.addEmployeeNumber(-1);
			data.EmployeeSwap(tmp);
			return true;
			}
		else {
			return false;
		}
		
	
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
		Product removeFurniture = findFurniture(productId);
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
	
	
	public Boolean addBranch(Branch newBranch) {
		int i=0;
		data.addBranchNumber(+1);
		Branch tmp[]= new Branch[data.getBranchNumber()];
		
		for(i=0;i<data.getBranchNumber()-1;i++) {
			tmp[i]= data.getBranch(i);
		}
		tmp[i]=newBranch;
		data.branchSwap(tmp);
		return true;
	}
	
	public Boolean removeBranch(int branchId) {
		int i=0,index=0 ,flag=0;
		Branch removeBranch = findBranch(branchId);
		
		
		Branch tmp[]= new Branch[data.getBranchNumber()-1];
		for(i=0;i<data.getBranchNumber();i++) {
			if(removeBranch.equals(data.getBranch(i))) {
				index=i;
				flag=1;
			}
		}
		if(flag==1) {
			for(i=0;i<index;i++) {
				tmp[i]=data.getBranch(i);
			}
			for(i=index+1;i<data.getBranchNumber();i++) {
				tmp[i-1]=data.getBranch(i);
			}
			data.addBranchNumber(-1);
			data.branchSwap(tmp);
			return true;
			}
		else {
			return false;
		}
		
	
	}
	public Branch findBranch(int branchId) {
		for(int i=0;i<data.getBranchNumber();i++) {
			if(data.getBranch(i).getBranchId()==branchId) {
				return data.getBranch(i);
				
			}
		}
		return null;
	}
	@Override
    public String getFirstName() {
        return AdminFirstName;
    }
	@Override
    public String getLastName() {
        return AdminLastName;
    }
	@Override
    public String getPassword() {
        return AdminPassword;
    }
	public Employee findEmployeeObject(String firstName,String lastName) {
		for(int i=0;i<data.getEmployeeNumber();i++) {
			if(data.getEmployee(i).getFirstName().equals(firstName) && data.getEmployee(i).getLastName().equals(lastName)) {
				return data.getEmployee(i);
			}
			else {
				System.out.println("Wrong Name");
				return null;
			}
		}
		return null;
	}
}	

