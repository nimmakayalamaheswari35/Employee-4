import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

abstract class Employee {
	String name, desig;
	int age, sal;

	public Employee() {
		Scanner t = new Scanner(System.in);
		System.out.print("\n Enter Name ");
		name = t.next();
		System.out.print("\nEnter Age : ");
		age = scanner.nextInt();
		//t.close();
	}

	public void display() {
		System.out.println("Name is :" + name);
		System.out.println("Age is :" + age);
		System.out.println("Salary is :" + sal);
		System.out.println("Designation is :" + desig);
	}

	public abstract void raiseSalary();
}

final class Clerk extends Employee {
	public Clerk() {
		desig = "Clerk";
		sal = 3000;
	}

	public void raiseSalary() {
		sal += 10000;
	}

}

final class Manager extends Employee {
	public Manager() {
		desig = "Manager";
		sal = 4000;
	}

	public void raiseSalary() {
		sal += 20000;
	}
}

final class Programmer extends Employee {
	public Programmer() {
		desig = "Programmer";
		sal = 9000;
	}

	public void raiseSalary() {
		sal += 50000;
	}
}

public class EMPLOYEE3 {
	public static void main(String[] args) 
 {
		System.out.println("Enter option");
		 Scanner t = new Scanner(System.in);
  try 
  {
     

   int outerChoice = 0, innerChoice = 0;
 
   FileWriter writer = new FileWriter(new File("D:\\JAVA1\\employee.txt"));
   ArrayList<Employee>  employee = new ArrayList();	
  do {
    System.out.print("\n\n1.CREATE\n2.DISPLAY\n3.RAISESALARY\n4.EXIT\nENTER YOUR CHOICE: ");
    
    outerChoice = t.nextInt();
    switch(outerChoice) 
    {
    case 1: 
     {
     do 
     {
       System.out.print("\n\n1.CLERK\n2.MANAGER\n3.PROGRAMMER\n4.EXIT\nENTER YOUR CHOICE: ");
       innerChoice = t.nextInt();
       Employee emp = null;
       switch(innerMenuChoice) 
       {
        case 1: emp = new Clerk();
        break;
        case 2: emp = new Manager();
              break;
        case 3: emp = new Programmer();
        break;
        case 4: break;
        default: System.out.print("\n\ninvalid entry...!");
              break;
       }
       if(innerChoice == 1 || innerChoice == 2 || innerChoice == 3) 
       {
        boolean existing = false;
         for( Employee k : employee) 
        {
         if(k != null && emp != null && k.name.equals(emp.name) && k.age == emp.age) 
         {
          System.out.print("\nRecord already exists...");
          existing = true;
          break;
         }
        }
        if(!existing) 
        {
         employee.add(emp);
         StringBuilder sb = new StringBuilder();
         sb.append("__________\n");
         sb.append("Name is :"+emp.name);
         sb.append("\n");
         sb.append("Age is :"+emp.age);
         sb.append("\n");
         sb.append("Sal is :"+emp.sal);
         sb.append("\n");
         sb.append("Desig is :"+emp.desig);
         sb.append("\n");
         sb.append("__________\n");
         writer.write(sb.toString());
         writer.flush();

        }
        }
     } while(innerChoice != 4);
      break;
     }
    case 2: 
     {
     if(employee.size() == 0) 
      {
       System.out.print("\n\nNorecords found.....?");
       break;
      }
     for(Employee e:employee)e.display();
     break;
     }
    case 3: 
     {
     if(employee.size() == 0) 
      {
       System.out.print("\n\nNorecords found.....?");
       break;
      }
     for(Employee e:employee) e.raiseSalary();
       System.out.print("\n\nSalary raised...");
       break;
     }
    case 4: System.out.print("\nExiting....!");
      break;
    default: System.out.print("\nInvalid choice....$");
    
    }
  } while(outerChoice != 4);
   scanner.close();
   
  }catch(Exception e) {
     e.printStackTrace();
  }
 }
}