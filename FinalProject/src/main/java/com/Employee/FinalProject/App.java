package com.Employee.FinalProject;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner in = new Scanner(System.in);
    	char ch;
        do {
        	System.out.println("Please select the operation to perform: ");
        	System.out.println("1. Insert the record: " );
        	System.out.println("2. View the record: " );
        	int choice=in.nextInt();
        	App app=new App();
        	switch(choice) {
			case 1:
				try {
					System.out.println("Enter the name: ");
					String name=in.next();
					System.out.println("Enter the designation: ");
					String designation=in.next();
					app.createEmployee(name,designation);
					
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					System.out.println("Enter the employee id: ");
					int empid=in.nextInt();
					app.fetchEmployee(empid);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
        		System.out.println("Do u want to continue");
        		ch=in.next().charAt(0);
			}
		
				while(ch=='y'||ch=='Y');
        	
        	}
    
    public void createEmployee(String name,String designation) {
    	Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
    	 Employee emp1=new Employee();
         
         emp1.setName(name);
         emp1.setDesignation(designation);
         emp1.setCreationDate(new Date());
         Session session=factory.openSession();
         Transaction tx=session.beginTransaction();
         
         session.save(emp1);
         tx.commit();
         System.out.println("Record Inserted");
         session.close();
    } 
    
    public void fetchEmployee(int empid) {
    	Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        
        Session session=factory.openSession();
        Employee employee = (Employee)session.get(Employee.class, empid);
        System.out.println(employee);
        session.close();
    }
}
