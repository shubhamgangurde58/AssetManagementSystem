package com.shubham.AssetManagementSystem;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
/**
 * Hello world!
 */
public class App {
	
	  AssetManagementInfo assetManagementInfo = new AssetManagementInfo();
	  static Scanner scanner = new Scanner(System.in);
	  
	 public Session sessionObject() {
		 
		 	Configuration configuration = new Configuration();
	        configuration.configure();
	        configuration.addAnnotatedClass(AssetManagementInfo.class);
	        
	        SessionFactory sessionFactory = configuration.buildSessionFactory();
	        
	        Session session = sessionFactory.openSession();
	        
	        return session;	 
	 }
     
      
	public void addAsset() {
		
        System.out.println("Enter the Asset Name :=");
        assetManagementInfo.setAssetName(scanner.next());
        System.out.println("Enter the Asset Type :=");
        assetManagementInfo.setAssetType(scanner.next());
        System.out.println("Enter the Serial Number:=");
        assetManagementInfo.setSerialNumber(scanner.next());
        System.out.println("Enter the Purchase Date :=");
        assetManagementInfo.setPurchaseDate(scanner.next());
        
        Session session =  sessionObject();
        
        session.getTransaction();
        session.save(assetManagementInfo);
        session.beginTransaction().commit();
        
        session.close();
        System.out.println("Asset info insert Successfully !!!");      
		
	}
	
	public void deleteAsset(Integer id) {
		
	     
	}
	
	public void updateAsset(int id) {
		
		
	}
	
	public void viewAsset( ) {
		
			
	}
	
    public static void main(String[] args) {
       
      
        System.out.println("***** Welcome to Asset Management System ***** ");
        App app = new App();
        int a;
   
      do {
    	  
	    	 System.out.println("\n1. addAsset \n2. deleteAsset \n3. updateAsset \n4. viewAsset \n5. Exit \nEnter your Choice :=");
	         int key = scanner.nextInt();
	          
	        switch (key) {
	  		case 1: 
	  			app.addAsset();
	  			break;
	  		case 2:
	  			System.out.println("Delete Asset to Enter the Asset id := ");
	  			app.deleteAsset(scanner.nextInt());
	  			break;
	  		case 3: 
	  			System.out.println("Update Asset to Enter the Asset id := ");
	  			app.updateAsset(scanner.nextInt());
	  			break;
	  		case 4:
	  			app.viewAsset();
	  			break;
	  		case 5:
	  			System.exit(0);
	  			break;
	  			
	  		default:
	  			throw new IllegalArgumentException("Unexpected value: " + key);
	  		}     
	    	  
	        System.out.println("\nContinue to enter  1/yes and 0/no :=");
	        a = scanner.nextInt();
			
	} while (a==1);
           
    }
}
