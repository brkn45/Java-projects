package Store;

import java.util.Scanner;

/**
*Administrator class for funiture company. Implement CompanyAdministrator.
*@author Berkan_akin_171044073
*/

public class Driver {
	
	public static void main(String[] args) {
		int number=0,flag=0;
		String firstName,lastName,password;
		Scanner input = new Scanner(System.in);
		Boolean exit=true;
		Data data =new Data();
		
		try{  
		      //code that may raise exception  
			while(exit) {
				System.out.println("              -----------------------------------------");
				System.out.println("              |    Welcome to Berkan Furniture Shop   |");
				System.out.println("              -----------------------------------------");
			
				System.out.println("         Menu");
				System.out.println("-------------------");
				System.out.println("1-)Administrator Login");
				System.out.println("2-)Employee Login");
				System.out.println("3-)Custumer Login");
				System.out.println("4-)Custumer Subscribe");
				System.out.println("5-)EXIT");
				number=input.nextInt();
				input.nextLine();
				switch (number) {
				  case 1:
					    System.out.println("              -----------------------------------------");
						System.out.println("              |      Administrator Login Panel        |");
						System.out.println("              -----------------------------------------");
						System.out.println("First Name:");
						firstName=input.nextLine();
						System.out.println("Last Name:");
						lastName=input.nextLine();
						System.out.println("Password:");
						password=input.nextLine();
						System.out.println("Name:"+data.getAdmin(0).getFirstName());
						if(data.getAdmin(0).getFirstName().equals(firstName)&& data.getAdmin(0).getLastName().equals(lastName) && data.getAdmin(0).getPassword().equals(password)) {
							System.out.println("True");
							AdminManage panel=new AdminManage();
							panel.startAdminPanel(data);
						}
						else {
							System.out.println("Name or Password Wrong");
						}
				    break;
				  case 2:
					    System.out.println("              -----------------------------------------");
						System.out.println("              |        Employee Login Panel           |");
						System.out.println("              -----------------------------------------");
						System.out.println("First Name:");
						firstName= input.next();
						System.out.println("Last Name:");
						lastName= input.next();
						System.out.println("Password:");
						password= input.next();
						for(int i=0;i<data.getEmployeeNumber();i++) {
							if(data.getEmployee(i).getFirstName().equals(firstName) && data.getEmployee(i).getLastName().equals(lastName) && data.getEmployee(i).getPassword().equals(password)) {
								EmployeeManage panelEmployee = new EmployeeManage(data);
								panelEmployee.startMenu(data.getEmployee(i));
								flag=1;
							}
							
						}
						if(flag==0){
							System.out.println("Name or Password Wrong");
						}
						else {
							flag=1;
						}
				    break;
				  case 3:
					    System.out.println("              -----------------------------------------");
						System.out.println("              |        Custumer Login Panel           |");
						System.out.println("              -----------------------------------------");
						System.out.println("First Name:");
						firstName= input.next();
						System.out.println("Last Name:");
						lastName= input.next();
						System.out.println("Password:");
						password= input.next();
						
						for(int i=0;i<data.getCustumerNumber();i++) {
							if(data.getCustumer(i).getFirstName().equals(firstName) && data.getCustumer(i).getLastName().equals(lastName) && data.getCustumer(i).getPassword().equals(password)) {
								CustumerManage panelCustumer =new CustumerManage(data);
								panelCustumer.startShop(data.getCustumer(i));
							}
							else {
								System.out.println("Name or Password Wrong");
							}
						}
				    break;
				  case 4:
					    System.out.println("              -----------------------------------------");
						System.out.println("              |        Custumer   Subscribe           |");
						System.out.println("              -----------------------------------------");
						CustumerManage panelCustumer =new CustumerManage(data);
						panelCustumer.StartSubscribe();
				    break;
				  case 5:
				    exit=false;
				    break;
				  default:
					System.out.println("Wrong Select");
					break; 
				}
			}
		 }catch(Exception e){  
		    
		   System.out.println("Exeception handling!!!!");  
		  }
		
		
	}	


}
