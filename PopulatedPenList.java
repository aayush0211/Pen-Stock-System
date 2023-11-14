package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;

import core.Company;
import core.Pen;

public class PopulatedPenList {
	public static List<Pen> populatedList(List<Pen> lists) {
		lists.add(new Pen(Company.CELLO, "black", "steel", 20, LocalDate.parse("2023-07-12")));
		lists.add(new Pen(Company.INKPEN, "blue", "Alloy", 10, LocalDate.parse("2023-03-22")));
		lists.add(new Pen(Company.PARKER, "blue", "wooden", 20, LocalDate.parse("2022-12-10")));
		lists.add(new Pen(Company.CELLO, "Red", "steel", 8, LocalDate.parse("2023-10-12")));
		return lists;
	}

	public static void writeDataInBinaryFIle(List<Pen> lists) throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UpdatedStockData.ser"))) {
			out.writeObject(lists);
			System.out.println("successfully write data in binary file");
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Pen> readDataFromBinaryFile(List<Pen> lists)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("StockData.ser"))) {
          
			lists = (List<Pen>) in.readObject();
			System.out.println("successfully read data from StockData.ser");
			return lists;
		}
	}
}
