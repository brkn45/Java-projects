package Store;

import java.util.Scanner;

public class AdminManage {
	private Data data;
	private int number,branchId;
	boolean exit;
	String firstName,lastName,password;
	Scanner input = new Scanner(System.in);
	AdminManage(){}
	AdminManage(Data data){
		this.data =data;
		this.number=0;
		this.exit=true;
	}
	public void startAdminPanel(Data data) {
		this.data =data;
		getMenu();
	}
	private void getMenu() {
		int modelNumber, branchNumber,productId;
	  	String color,name;
		while(exit) {
			System.out.println("              -----------------------------------------");
			System.out.println("              |         Admin Manage Panel            |");
			System.out.println("              -----------------------------------------");
		
			System.out.println("         Menu");
			System.out.println("-------------------");
			System.out.println("1-)Add Employee");
			System.out.println("2-)Remove Employee");
			System.out.println("3-)List Employee");
			System.out.println("4-)Add Branch");
			System.out.println("5-)Remove Branch");
			System.out.println("6-)List Branch");
			System.out.println("7-)Add Product");
			System.out.println("8-)Remove Product");
			System.out.println("9-)List Product");
			System.out.println("10-)Search Product");
			System.out.println("11-)EXIT");
			number=input.nextInt();
			input.nextLine();
			switch (number) {
			  case 1:
				  	System.out.println("              -----------------------------------------");
					System.out.println("              |             Add Employee               |");
					System.out.println("              -----------------------------------------");
					System.out.println("First Name:");
					firstName=input.nextLine();
					System.out.println("Last Name:");
					lastName=input.nextLine();
					System.out.println("Password:");
					password=input.nextLine();
					System.out.println("Barnch ID:");
					
					branchId=input.nextInt();
					Employee newEmployee =new Employee(branchId,data.getEmployeeNumber(),firstName,lastName,password);
					data.getAdmin(0).addBranchEmployee(newEmployee);
			    break;
			  case 2:
				    System.out.println("              -----------------------------------------");
					System.out.println("              |             Remove Employee           |");
					System.out.println("              -----------------------------------------");
					System.out.println("First Name:");
					firstName=input.nextLine();
					System.out.println("Last Name:");
					lastName=input.nextLine();
					data.getAdmin(0).removeEmployee(firstName, lastName);
			    break;
			  case 3:
			    data.printEmployee();
			    break;
			  case 4:
				    System.out.println("              -----------------------------------------");
				  	System.out.println("              |               Add Branch              |");
					System.out.println("              -----------------------------------------");
					Branch newBranch = new Branch(data.getBranchNumber());
					System.out.println("   !!!Open the New Branch!!! ");
					System.out.println("Branch ID:"+data.getBranchNumber());
					data.getAdmin(0).addBranch(newBranch);
					
			    break;
			  case 5:
				    System.out.println("              -----------------------------------------");
				  	System.out.println("              |            Remove Branch              |");
					System.out.println("              -----------------------------------------");
					data.printBranch();
					System.out.println("Please enter Branch ID");
					
					branchId=input.nextInt();
					data.getAdmin(0).removeBranch(branchId);
			    break;
			  case 6:
				  data.printBranch();
			    break;
			  case 7:
				  	
				    System.out.println("              -----------------------------------------");
				  	System.out.println("              |            Add Product                |");
					System.out.println("              -----------------------------------------");
					
					System.out.println("Model Number  :");
					modelNumber   =  input.nextInt();
					System.out.println("Branch Number :");
					branchNumber  =  input.nextInt();
					color         =  input.nextLine();
					System.out.println("Color         :");
					color         =  input.nextLine();
					System.out.println("Name          :");
					name          =  input.nextLine();
					Furniture newFurniture = new Furniture(name,branchNumber,data.getFurnitureNumber(),modelNumber,color);
					data.getAdmin(0).addFurniture(newFurniture);
			    break;
			  case 8:
				    System.out.println("              -----------------------------------------");
				  	System.out.println("              |            Remove Product             |");
					System.out.println("              -----------------------------------------");
					data.printFurniture();
					System.out.println("Select Product ID  :");
					productId=input.nextInt();
					data.getAdmin(0).removeFurniture(productId);
				break;
			  case 9:
				data.printFurniture();
				break;
			  case 10:
				  name = input.nextLine();
				  data.searchProduct(name);
				  break;
			  case 11:
				  exit=false;
				  break;
			  default :
				  System.out.println("Wrong Input");
			
			}
			
		}
		
	}
	
	
	
	
}
