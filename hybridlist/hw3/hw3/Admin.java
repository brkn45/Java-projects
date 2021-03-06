package hw3;
/**
*Administrator class for funiture company. Implement CompanyAdministrator.
*@author Berkan_akin_171044073
*/

public class Admin extends User{
	
	private final String AdminFirstName ="berkan";
	private final String AdminLastName ="akin";
	private final String AdminPassword  ="123";
	/**
     * Constructor for the administrator with name,surname,id and its company.
     * @param Data Class.
     * 
     */
	private Data data;
	Admin(Data data){
		this.data =data;
	}
	
	public void setData(Data data) {
		this.data =data;
		
	}
	public Boolean addBranchEmployee(Employee newEmployee) {
		int i=0;
		data.employee.add(newEmployee);

		
		data.addEmployeeNumber(+1);
		return true;
	}
	
	
	
	public Boolean removeEmployee(String firstName,String lastName) {
		int i=0,index=0 ,flag=0;
		if(null==findEmployeeObject(firstName,lastName)) {
			return false;
		}
		Employee removeEmployee=findEmployeeObject(firstName,lastName);
		
		for(i=0;i<data.getEmployeeNumber();i++) {
			if(removeEmployee.equals(data.getEmployee(i))) {
				index=i;
				
			}
		}
		data.employee.remove(index);
		return true;
	
	}

	public Boolean addFurniture(Furniture newFurniture) {
		int i=0;
		
		data.addFurnitureNumber(1);
		data.furniture.add(newFurniture);
		//data.FurnitureSwap(tmp);
		return true;
	}
	public Furniture findFurniture(int productId) {
		if(productId >= data.furniture.getSize() || productId < 0){
			//throww
		}
			
		return data.furniture.get(productId);
			
	}
	public Boolean removeFurniture(int productId) {
		int i=0,index=0 ,flag=0;
		if(productId >= data.furniture.getSize() || productId < 0){
			//throww
		}
		data.furniture.remove(productId);
		
		return true;
		
	
	}
	
	
	public Boolean addBranch(Branch newBranch) {
		int i=0;
		data.addBranchNumber(+1);
		data.branch.add(newBranch);
		return true;
	}
	
	public Boolean removeBranch(int branchId) {
		int i=0,index=0 ,flag=0;
		//Branch removeBranch = findBranch(branchId);
		if(branchId<0 || branchId >= data.branch.getSize()) {
			//throw
		}
		data.branch.remove(branchId);
		
		
		
		return true;
	
	}
	public Branch findBranch(int branchId) {
		if(branchId<0 || branchId >= data.branch.getSize()) {
			//throw
		}
		return data.branch.get(branchId);
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
		for(int i=0;i<data.employee.getSize();i++) {
			if(data.employee.get(i).getFirstName().equals(firstName) && data.employee.get(i).getLastName().equals(lastName)) {
				return data.employee.get(i);
			}
			else {
				System.out.println("Wrong Name");
				return null;
			}
		}
		return null;
	}
}	

