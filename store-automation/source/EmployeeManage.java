package Store;

import java.util.Scanner;

public class EmployeeManage {
	private Data data;
	EmployeeManage(Data data){
		this.data = data;
	}
	public void startMenu(Employee employee) {
		int number,modelNumber, branchNumber,productId;
		Boolean exit=true;
		employee.setData(data);
	  	String color,name;
		Scanner input = new Scanner(System.in);
		while(exit) {
			
			System.out.println("              -----------------------------------------");
			System.out.println("              |        Employee Login Panel            |");
			System.out.println("              -----------------------------------------");
			
			System.out.println("        Menu");
			System.out.println("--------------------");
			System.out.println("1-)Employee List");
			System.out.println("2-)Add Product");
			System.out.println("3-)Remove Product");
			System.out.println("4-)Product List");
			System.out.println("5-)Order List");
			System.out.println("6-)Search Product");
			System.out.println("7-)Exit");
			
			
			
			number = input.nextInt();
			switch (number) {
			  case 1:
			    data.printEmployee();
			    break;
			  case 2:
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
					employee.addFurniture(newFurniture);
			    break;
			  case 3:
				    System.out.println("              -----------------------------------------");
				  	System.out.println("              |            Remove Product             |");
					System.out.println("              -----------------------------------------");
					data.printFurniture();
					System.out.println("Select Product ID  :");
					productId=input.nextInt();
					employee.removeFurniture(productId);
			    break;
			  case 4:
				    System.out.println("              -----------------------------------------");
				  	System.out.println("              |             List Product              |");
					System.out.println("              -----------------------------------------");
					data.printFurniture();
			    break;
			  case 5:
			    employee.printOrder();
			    break;
			  case 6:
				  System.out.println("Enter Product Name");
				  name =input.nextLine();
				  name =input.nextLine();
				  data.searchProduct(name);
				  break;
			  case 7:
				  exit = false;
				  break;
			  default:
			    System.out.println("Wrong Input");
			    break;
			}
		}
		
		
		
		
	}
}
