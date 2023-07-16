package com.inventory.dao;
import com.inventory.bean.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class InventoryImplimentation implements InventoryManagement {
	
	
	ArrayList<InventoryItem> iAl = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);

	@Override
	public void addProduct() {
		System.out.println("Enter No. Of Inventory Items To Register: ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			System.out.println("enter the product id");
			int prodId=sc.nextInt();
			System.out.println("enter the product name");
			String prodName=sc.next();
			System.out.println("enter the product price");
			double prodPrice=sc.nextDouble();
			System.out.println("enter the product category details");
			System.out.println("enter the product category id");
			int prodCategoryId=sc.nextInt();
			System.out.println("enter the product category name");
			String prodCategoryName=sc.next();
			System.out.println("enter the total quntity");
			int prodQuntity=sc.nextInt();
			
			iAl.add(new InventoryItem(new Product(prodId, prodCategoryName, new Category(prodCategoryId, prodCategoryName), prodPrice), prodQuntity));
			

		}
		
	}

	@Override
	public void removeProduct() {
		
		
		System.out.println("Enter Product ID To Be Removed: ");
		int id=sc.nextInt();
		//Iterator<InventoryItem>itr=iAl.iterator();
		if(iAl.isEmpty())
			System.err.println("Product Not Found: ");
		else
		{
			for(InventoryItem i: iAl)
			{
				if(id==i.getProduct().getProductId())
				{
					iAl.remove(i);
					System.out.println("Item Deleted Sucessfully...");
				}
			}
		}
		
	}

	@Override
	public void displayProductByName() {
		System.out.println("Enter Name Of The Product To Display: ");
		String s=sc.next();
		
		for(InventoryItem ii : iAl)
		{
			if(s.equalsIgnoreCase(ii.getProduct().getProductName()))
			{
				System.out.println("Product ID        Product Name        Category ID        Price        QTY");
				System.out.println(ii);
			}
			
		}
		
		
	}

	@Override
	public void displayAllProduct() 
	{
		int count=1;
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("   Product ID  Product Name  Category ID  Price  QTY");
		for(InventoryItem ii : iAl)
		{
			
			
			System.out.println(count+".  "+ii);
			
			count++;
		}
		System.out.println("--------------------------------------------------------------------------------");
		
	}

	@Override
	public void deleteByname() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTotal() {
		
		for(InventoryItem i : iAl)
		{
			System.out.println(i+"       "+(i.getQuantity()*i.getProduct().getProductPrice()));
		}
		
	}

	@Override
	public void updateInventory() {
		
		System.out.print("Enter Product ID To Update: ");
		int id=sc.nextInt();
		
		ListIterator<InventoryItem> itr = iAl.listIterator();
		while(itr.hasNext())
		{
			InventoryItem i = itr.next();
			if(id==i.getProduct().getProductId())
			{
				System.out.print("Enter New Product Name: ");
				String name=sc1.nextLine();
				System.out.print("Enter New Product Price: ");
				int price=sc.nextInt();
				System.out.print("Enter New Product Category ID: ");
				int cid=sc.nextInt();
				System.out.print("Enter New Product Category Name: ");
				String cName=sc1.nextLine();
				System.out.print("Enter New QTY");
				int qty= sc.nextInt();
				
				itr.set(new InventoryItem(new Product(id, name, new Category(cid, cName), price), qty));
				System.out.println("Product Updated Sucessfully...");
			}
			else
			{
				System.out.println("Product Not Found...");
			}
		}
		
	}

}
