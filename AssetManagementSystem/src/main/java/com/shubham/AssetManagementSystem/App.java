package com.shubham.AssetManagementSystem;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class App {
	
	  AssetManagementInfo assetManagementInfo = new AssetManagementInfo();
	  static Scanner scanner = new Scanner(System.in);
	  
	 public Session getConnection() {
		 
		 	Configuration configuration = new Configuration();
	        configuration.configure();
	        configuration.addAnnotatedClass(AssetManagementInfo.class);
	        
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	        
	        Session session = sessionFactory.openSession();
	        
	        return session;	 
	 }
     
	 public void closeConnection(Session session) {
		 
		 	session.getTransaction().commit();
			session.close();
	 }
      
	public void addAsset() {
		
		try {
			
			System.out.println("Enter the Asset Name :=");
	        assetManagementInfo.setAssetName(scanner.next());
	        System.out.println("Enter the Asset Type :=");
	        assetManagementInfo.setAssetType(scanner.next());
	        System.out.println("Enter the Serial Number:=");
	        assetManagementInfo.setSerialNumber(scanner.next());
	        System.out.println("Enter the Purchase Date :=");
	        assetManagementInfo.setPurchaseDate(scanner.next());
	        
	        Session session =  getConnection();
	 
	        session.beginTransaction();
	        session.save(assetManagementInfo);
	        closeConnection(session);
	        
	        System.out.println("Asset info insert Successfully !!!");   
			
		}catch (Exception e) {
				System.out.println(e.getMessage());
		}	
	}
	
	public void deleteAsset()  {
		
		try {
			
			AssetManagementInfo  assetManagementInfo  = null;
			
  			System.out.println("Delete Asset to Enter the Asset id := ");
  			int id = scanner.nextInt();
			
			Session session = getConnection();
			
			assetManagementInfo = session.get(AssetManagementInfo.class,id);
				
			session.beginTransaction();
			session.delete(assetManagementInfo);
			closeConnection(session);
			
			System.out.println("Asset Record Deleted Successfully !!!");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	
		
	     
	}
	
	public void updateAsset() {
		
	  try {
			
			AssetManagementInfo  assetManagementInfo  = null;
			
  			System.out.println("Update Asset to Enter the Asset id := ");
  			int id = scanner.nextInt();

			Session session = getConnection();
			
			assetManagementInfo = session.get(AssetManagementInfo.class,id);
			
			
				System.out.println("Enter the Asset Name :=");
		        assetManagementInfo.setAssetName(scanner.next());
		        System.out.println("Enter the Asset Type :=");
		        assetManagementInfo.setAssetType(scanner.next());
		        System.out.println("Enter the Serial Number:=");
		        assetManagementInfo.setSerialNumber(scanner.next());
		        System.out.println("Enter the Purchase Date :=");
		        assetManagementInfo.setPurchaseDate(scanner.next());
				
			session.beginTransaction();
			session.update(assetManagementInfo);
			closeConnection(session);
			
			System.out.println("Asset Record Updated Successfully !!!");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	
	public void viewAsset( ) {
		
	  try {
		  
		  
		  	Session session = getConnection();
			session.beginTransaction();
			
	        List<AssetManagementInfo> assetRecord = session.createQuery("from AssetManagementInfo", AssetManagementInfo.class).getResultList();
	        
	        for (int i = 0; i < assetRecord.size(); i++) {
	        	
	            AssetManagementInfo assetManagementInfo = assetRecord.get(i); 
	            System.out.println("Asset ID: " + assetManagementInfo.getAssetId() + " , Asset Name: " + assetManagementInfo.getAssetName() + " , Asset Type: " + assetManagementInfo.getAssetType() + " , Serial Number: " + assetManagementInfo.getSerialNumber() + " , Purchase Date: " + assetManagementInfo.getPurchaseDate());
	        }
	        
	       closeConnection(session);
			
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		
		
	}
	
    public static void main(String[] args) {
       
      
        System.out.println("***** Welcome to Asset Management System ***** ");
        App app = new App();
        int a;
   
      do {
    	  
	    	 System.out.println("\n1. addAsset \n2. deleteAsset \n3. updateAsset \n4. viewAsset \n5. Exit \nEnter your Choice :=");
	         int choice = scanner.nextInt();
	          
	        switch (choice) {
	  		case 1: 
	  			app.addAsset();
	  			break;
	  		case 2:
	  			app.deleteAsset();
	  			break;
	  		case 3: 
	  			app.updateAsset();
	  			break;
	  		case 4:
	  			app.viewAsset();
	  			break;
	  		case 5:
	  			System.exit(0);
	  			break;
	  			
	  		default:
	  			throw new IllegalArgumentException("Unexpected value: " + choice);
	  		}     
	    	  
	        System.out.println("\nContinue to enter  1/yes and 0/no :=");
	        a = scanner.nextInt();
			
	} while (a!=0);
           
    }
}
