package com.sixdee.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_DETAILS")
public class Book 
{
	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "AUTHOR_NAME")
	private String authorName;
	
	@Column(name = "BOOK_GENRE")
	private String bookGenre;
	
	@Column(name = "BOOK_PRICE")
	private double bookPrice;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Book(int bookId, String bookName, String authorName, String bookGenre, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookGenre = bookGenre;
		this.bookPrice = bookPrice;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", bookGenre="
				+ bookGenre + ", bookPrice=" + bookPrice + "]";
	}
	
	
	
}
