package Store;
/**
*Administrator class for funiture company. Implement CompanyAdministrator.
*@author Berkan_akin_171044073
*/
public class Furniture implements Product {
	private String productName;
	private int branchNumber;
	private int productNumber;
	private int modelNumber;
	private String color;
	private int productCount;
	/**
     * Default Value.
     
     */
	Furniture(){
		this.productName="None";
		this.branchNumber=999;
		this.productNumber=999;
		this.modelNumber=999;
		this.productCount=999;
		
	}
	Furniture(String productName,int branchNumber,int productNumber,int modelNumber,String color){
		this.productName=productName;
		this.branchNumber=branchNumber;
		this.productNumber=productNumber;
		this.modelNumber=modelNumber;
		this.color=color;
	}
	@Override
	public String getProductName() {
		
		return productName;
	}

	@Override
	public void setProductName(String name) {
		this.productName=name;
		
	}

	@Override
	public int getBranchNumber() {
		
		return branchNumber;
	}

	@Override
	public void setBrachNumber(int branchNumber) {
		this.branchNumber=branchNumber;
	}

	@Override
	public int getProductNumber() {
		// TODO Auto-generated method stub
		return productNumber;
	}

	@Override
	public void setProductNumber(int productNumber) {
		this.productNumber=productNumber;
		
	}

	@Override
	public int getModelNumber() {
		
		return modelNumber;
	}

	@Override
	public void setModelNumber(int modelNumber) {
		this.modelNumber=modelNumber;
		
	}
	@Override
	public void setProductCount(int count) {
		this.productCount=count;
		
	}
	@Override
	public int getProductCount() {
		
		return productCount;
	}
	public String getColor() {
		return color;
	}
	

}
