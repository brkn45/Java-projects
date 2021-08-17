package hw3;

import java.util.Scanner;

public class CustumerManage {
	private Data data;
	Scanner input = new Scanner(System.in);
	
	CustumerManage(Data data){
		this.data =data;
	}
	
	
	
	public void  StartSubscribe() {
		String firstName,lastName,password,email;
		Boolean exit = true;
		int number;
		System.out.println("Yalan oldu");
		while(exit) {
			
			System.out.println("First Name :");
			firstName=input.nextLine();
			System.out.println("Last Name  :");
			lastName=input.nextLine();
			System.out.println("Password   :");
			password=input.nextLine();
			System.out.println("Email      :");
			email=input.nextLine();
			 Custumer custumer = new Custumer(firstName,lastName,password,email,data.getCustumerNumber());
			 data.addCustumer(custumer);
			 exit=false;
			
		}
	}
	
	public void startShop(Custumer custumer) {
		int number;
		Boolean exit=true;
		String name;
		custumer.setData(data);
		while(exit) {
			System.out.println("              -----------------------------------------");
			System.out.println("              |           Shop Subscribe              |");
			System.out.println("              -----------------------------------------");
			System.out.println("    Menu  ");
			System.out.println("--------------");
			System.out.println("1-)Product List");
			System.out.println("2-)Search Product");
			System.out.println("3-)Basket List");
			System.out.println("4-)Buy Product");
			System.out.println("5-)Order Status");
			System.out.println("6-)Exit");
			
			
			number = input.nextInt();
			
			switch (number) {
			  case 1:
				    System.out.println("              -----------------------------------------");
					System.out.println("              |              Product List             |");
					System.out.println("              -----------------------------------------");  
			        data.printFurniture();
			        this.addBasket(custumer);
			        break;
			  case 2:
				    System.out.println("              -----------------------------------------");
					System.out.println("              |             Search Product            |");
					System.out.println("              -----------------------------------------");
					System.out.println("Enter Product Name:");
					name=input.nextLine();
					name=input.nextLine();
					
					data.searchProduct(name);
					this.addBasket(custumer);
			    break;
			  case 3:
				    System.out.println("              -----------------------------------------");
					System.out.println("              |             Basket List               |");
					System.out.println("              -----------------------------------------");
					custumer.printBasket();
					this.addBasket(custumer);
					
			    break;
		     case 4:
			    System.out.println("              -----------------------------------------");
				System.out.println("              |               Buy Product             |");
				System.out.println("              -----------------------------------------"); 
				System.out.println("1-)Buy Prodcuts");
				System.out.println("2-)Exit");
				number = input.nextInt();
				switch (number) {
				  case 1:
					  custumer.printBasket();
					  this.buyProduct(custumer);
					  custumer.setStatus(1);
				  break;
				}
			    break;
			  case 5:
				  if(custumer.getOrderStatus()==0) {
					  	System.out.println("-----------------------------------------");
						System.out.println("|               Product in Basket        |");
						System.out.println("-----------------------------------------");
						
				  }
				  else if(custumer.getOrderStatus()==1) {
					   System.out.println("-----------------------------------------");
						System.out.println("|               Order Preparing         |");
						System.out.println("-----------------------------------------"); 
				  }
				  custumer.printBasket();
				break;
			  case 6:
				  exit=false;
				  break;
			  default:
				  System.out.println("Wrong Input!!!");
			}
		}
	}
	private void addBasket(Custumer custumer) {
		int number;
		Boolean exit = true;
		while(exit) {
			System.out.println("1-)Add Basket");
			System.out.println("2-)Remove Basket");
			System.out.println("3-)Exit");
			
			number = input.nextInt();
			switch (number) {
			  case 1:
			    System.out.println("Please enter ID Number  :");
			    number = input.nextInt();
			    custumer.addBasket(number);
			    break;
			  case 2:
				  System.out.println("Please enter ID Number:");
				  number = input.nextInt();
				  custumer.removeBasket(number);
			  case 3:
			    exit=false;
			    break;
			}    
		}
		
	}
	public void buyProduct(Custumer custumer) {
		for(int i=0;i<custumer.getBasketNumber();i++) {
			for(int k=0;k<data.getEmployeeNumber();k++) {
				if(custumer.getBasket(i).getBranchNumber()==data.getEmployee(k).getBranchId()) {
					data.getEmployee(k).addOrder(custumer.getBasket(i));
				}
			}
		}
		
	}
	
}
