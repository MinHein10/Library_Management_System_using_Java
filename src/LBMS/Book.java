package LBMS;

import java.util.Date;

public class Book {
	
	String title;
	String author;
	Category category;
	CurrentLocation bookracknum;
	String publisher;
	Date yearofpublication;
	String ISBN;
	int numberofpages;
	Date dateofPurchase;
	double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CurrentLocation getBookracknum() {
		return bookracknum;
	}
	public void setBookracknum(CurrentLocation bookracknum) {
		this.bookracknum = bookracknum;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getYearofpublication() {
		return yearofpublication;
	}
	public void setYearofpublication(Date yearofpublication) {
		this.yearofpublication = yearofpublication;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getNumberofpages() {
		return numberofpages;
	}
	public void setNumberofpages(int numberofpages) {
		this.numberofpages = numberofpages;
	}
	public Date getDateofPurchase() {
		return dateofPurchase;
	}
	public void setDateofPurchase(Date dateofPurchase) {
		this.dateofPurchase = dateofPurchase;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
