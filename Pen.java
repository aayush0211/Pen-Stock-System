package core;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.Objects;

public class Pen implements Comparable<Pen>,Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int cnt=0;
     private Integer uniqueId;
     private Company company;
     private String color;
     private String material;
     private int stock;
     private LocalDate updateDate;
     private LocalDate listingDate;
     private Double price;
	public Pen(Company company, String color, String material, int stock, LocalDate updateDate) {
		super();
		this.uniqueId =++cnt;
		this.company = company;
		this.color = color;
		this.material = material;
		this.stock = stock;
		this.updateDate = updateDate;
		this.listingDate = updateDate;
		price=this.company.getCost();
	}
	public Pen(int id) {
		this.uniqueId=id;
	}
	
	@Override
	public String toString() {
		return "Pen [uniqueId=" + uniqueId + ", company=" + company + ", color=" + color + ", material=" + material
				+ ", stock=" + stock + ", updateDate=" + updateDate + ", listingDate=" + listingDate + ", price="
				+ price + "]";
	}
	@Override
	public int hashCode() {
		return this.company.name().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
	   
	    	Pen p = (Pen)obj;
	    	return this.uniqueId.equals(p.uniqueId);
	}
	@Override
	public int compareTo(Pen p) {
		return this.uniqueId.compareTo(p.uniqueId);
	}
	public Integer getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.setUpdateDate(LocalDate.now());
		this.stock = stock;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public LocalDate getListingDate() {
		return listingDate;
	}
	public void setListingDate(LocalDate listingDate) {
		this.listingDate = listingDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
     
     
     
}
