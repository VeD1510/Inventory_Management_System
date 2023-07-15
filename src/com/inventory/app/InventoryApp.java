package com.inventory.app;

import java.util.Scanner;

import com.inventory.dao.InventoryImplimentation;

public class InventoryApp {
	
	public static void main(String[] args) {
		
		InventoryImplimentation il = new InventoryImplimentation();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============Welcome to Inventory Management System App=============");
		char ch;
		do {
			System.out.println("enter the choice");
			System.out.println("1.Add product\n2.Remove Product By ID\n"
					+ "3.Search Product By Name\n4.Display All Products\n5.Delete Product By name\n6.Display Total Price");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:il.addProduct();
			break;
			case 2:il.removeProduct();
			break;
			case 3:il.displayProductByName();
			break;
			case 4:il.displayAllProduct();
			break;
			case 5:il.deleteByname();
			break;
			case 6:il.displayTotal();
			break;
			

			default:System.out.println("Invalid choice");
			}
			System.out.println("Do you want to continue");
			ch=sc.next().charAt(0);
		}while(ch=='y'||ch=='Y');
	}

}
