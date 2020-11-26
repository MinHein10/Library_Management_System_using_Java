package LBMS;

import java.util.Date;

public class BookBorrowAndReturn {
	Bookcopyitem bookID;
	Students studentID;
	Date dueDate;
	Date borrowDate;
	Date returnDate;
	public Bookcopyitem getBookID() {
		return bookID;
	}
	public void setBookID(Bookcopyitem bookID) {
		this.bookID = bookID;
	}
	public Students getStudentID() {
		return studentID;
	}
	public void setStudentID(Students studentID) {
		this.studentID = studentID;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
}
