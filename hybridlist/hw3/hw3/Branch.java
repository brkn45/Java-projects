package hw3;

public class Branch implements Shop {
	private int branchId;
	private Data data;
	Branch(int branchId){
		this.branchId =branchId;
	}
	@Override
	public int getBranchId() {
		
		return branchId;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public int getProductCount() {
		int count=0;
		for(int i=0;i<data.getFurnitureNumber();i++) {
			if(data.furniture.get(i).getBranchNumber() ==branchId) {
				count++;
			}
		}
		return count;
	}

	@Override
	public void getShopEmployeeList() {
		if(data.getEmployeeNumber()==0) {
			System.out.println("Shop Has not Employee");
			return;
		}
		for(int i=0;i<data.getEmployeeNumber();i++) {
			if(data.getEmployee(i).getBranchId() ==branchId) {
				System.out.println("-----------------------------------------------------------------------------------------------------");
				System.out.println("First Name : " + data.getEmployee(i).getFirstName() + " |Last Name : " + data.getEmployee(i).getLastName()+ " |Branch Number :" + data.getEmployee(i).getBranchId() + "|ID Number :" + data.getEmployee(i).getId());
				System.out.println("-----------------------------------------------------------------------------------------------------");

			}
		}
	}

	@Override
	public void getProductList() {
		int count=0;
		
		for(int i=0;i<data.furniture.getSize();i++) {
			if(data.furniture.get(i).getBranchNumber() ==branchId) {
				System.out.println("----------------------");
				System.out.println("|Product Name    :"   + data.furniture.get(i).getProductName());
				System.out.println("|Product Number  :"   + data.furniture.get(i).getProductNumber());
				System.out.println("|Model   Number  :"   + data.furniture.get(i).getModelNumber());
				System.out.println("|Color           :"   + data.furniture.get(i).getColor());
			}
		}
		
		
	}

}
