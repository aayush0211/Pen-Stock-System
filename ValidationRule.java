package utility;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
//import java.util.Map;
import java.util.Scanner;

import core.Company;
import core.Pen;
import penStockEception.PenStockException;

public interface ValidationRule {
	public static Pen addPen(Scanner sc) throws PenStockException, IllegalArgumentException {

		Pen newPen = new Pen(Company.valueOf(sc.next().toUpperCase()), sc.next(), sc.next(), sc.nextInt(),
				LocalDate.parse(sc.next()));

		System.out.println("successfully register new pen your pen unique id is : ");
		System.out.println("unique Id = " + newPen.getUniqueId());
		return newPen;
	}

	public static void addStock(List<Pen> lists, int uniqueId, Scanner sc) throws PenStockException {
          int i= validStock(uniqueId, lists);
          System.out.println("enter updated value");
         lists.get(i).setStock(sc.nextInt());		
	}
	static int validStock(int id,List<Pen>lists) throws PenStockException {
		Pen p = new Pen(id);
		if(lists.contains(p)) {
			System.out.println("valid Stock id");
			return lists.indexOf(p);
		}
		else
			throw new PenStockException("Invalid uniqueId of Stock!!!");
	}

	static void setDiscunt(List<Pen>lists)throws PenStockException {
           
            	   lists.stream().filter(i->Period.between(i.getListingDate(),LocalDate.now()).toTotalMonths()>=(long)3).forEach(i->i.setPrice(i.getPrice()-i.getPrice()*(.20)));
            	   System.out.println("successfully set discount!!!");
               }
            	   
   static void removePen(List<Pen>lists) {
	   lists.removeIf(p->Period.between(p.getUpdateDate(),LocalDate.now()).toTotalMonths()>=(long)9);
   }
   static void displayAllPen(List<Pen>lists) {
	   lists.stream().sorted((p1,p2)->p1.getListingDate().compareTo(p2.getListingDate())).forEach(System.out::println);
   }
}
