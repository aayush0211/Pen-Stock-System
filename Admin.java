package tester;
//import core.Company;
import core.Pen;
import utility.*;
import utility.ValidationRule;

import java.util.*;

public class Admin implements ValidationRule {
    public static void main(String...args) {
		try(Scanner sc = new Scanner(System.in)){
			 List<Pen>penList = new ArrayList<>();
			// penList= PopulatedPenList.populatedList(penList); take sample data from PopulatedPenList class static method
			penList= PopulatedPenList.readDataFromBinaryFile(penList);
			 boolean exit=false;
			while(!exit) {
				System.out.println("choose any option :\n"
						+ "1)Add new Pen\n2)Update Stock of a Pen\n"
						+ "3)Set discount of 20% of all pen which are not sold in last 3 months\n"
						+ "4)remove pen which are not sold once listed in 9 months\n"
						+ "5)Display all pen\n"
						+ "0)Exit");
				try {
				switch(sc.nextInt()){
				
				case 1: penList.add(ValidationRule.addPen(sc));
					break;
					
				case 2:System.out.println("enter unique id of stock");
				       int id = sc.nextInt();
				       ValidationRule.addStock(penList, id, sc);
				       System.out.println("successfully updated Stock");
					break;
				case 3:
			           ValidationRule.setDiscunt(penList);
					break;
				case 4: ValidationRule.removePen(penList);
				       break;
				case 5:ValidationRule.displayAllPen(penList);
					break;
				
				case 0:System.out.println("Thank you!!!");
				exit = true;
				break;
				}
				
			}
			
			catch(Exception e) {
				e.printStackTrace();
				sc.nextLine();
				}
		}

			PopulatedPenList.writeDataInBinaryFIle(penList);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    
    }
}
