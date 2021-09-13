
package com.controller;

import java.util.List;
import java.util.Scanner;
import com.dao.RestaurantDaoImplements;
import com.dao.Restaurantdao;
import com.model.Restaurant;

public class Rsystem {
	
	public static void main(String[] args) {
		int input = 0;
			Scanner sc=new Scanner(System.in);
			Restaurantdao restdao=RestaurantDaoImplements.getInstance();
			  
			
			do {
				System.out.println("Enter Your Choice");
				System.out.println("Enter 1 add Restaurant");
				System.out.println("Enter 2 update Restaurant");
				System.out.println("Enter 3 Delete Restaurant");
				System.out.println("Enter 4 View all Restaurant");
				
				
				System.out.println("Enter 0 for Exit");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					
					restdao.addRestaurant();
					break;
				case 2:
					System.out.println("Enter Restaurant  id to update ");
					int Rid=sc.nextInt();
					System.out.println("Enter new name for restaurant");
					String Rname=sc.next();
					restdao.updateRestaurant(Rid,Rname);
				break;
				case 3:
					System.out.println("Delete Restaurant ");
					System.out.println("enter restaurant name to delete");
					 Rname=sc.next();
							
					restdao.deleteRestaurant(Rname);
					break;
				case 4:System.out.println("View All Restaurant");
						List<Restaurant> al=restdao.getAllRestaurant();
						for(Restaurant ob:al)
							System.out.println(ob);
						break;
				
				case 0:
					System.exit(0);
				}
				
			}while(true);

		}

	

}
