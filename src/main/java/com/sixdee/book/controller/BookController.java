package com.sixdee.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixdee.book.model.Book;
import com.sixdee.book.repository.BookRepo;
import com.sixdee.book.specificationimpl.BookSpecificationImpl;

@RestController
public class BookController 
{
	@Autowired
	BookRepo repo;
	
	@PostMapping("/addBooks")
	public Book addBook(@RequestBody Book b)
	{
		return repo.save(b); 	
				
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks()
	{
		return (List<Book>) repo.findAll();
	}
	
	@GetMapping("/getBooksById/{bookId}")
	public Book getBooksById(@PathVariable("bookId") int bookId)
	{
		Optional<Book> b = repo.findById(bookId);
		
		return b.get();
	}
	
	@GetMapping("/getBooksByAuthor/{authorName}")
	public List<Book> getBooksByAuthor(@PathVariable("authorName") String authorName)
	{
		List<Book> b = repo.findByAuthorName(authorName);
		return b;
	}
	
	@GetMapping("/getBooksByGenre/{bookGenre}")
	public List<Book> getBooksByGenre(@PathVariable("bookGenre") String bookGenre)
	{
		List<Book> b = repo.findByBookGenre(bookGenre);
		return b;
	}
	
	@DeleteMapping("/deleteBooks/{bookId}")
	public int deleteBooks(@PathVariable("bookId") int bookId)
	{
		repo.deleteById(bookId);
		return 0;
	}
	
	@GetMapping(value = "/bookPageable")
	Page bookPageable(Pageable pageable)
	{
		return repo.findAll(pageable);
	}
	
	@GetMapping(value = "/findByAuthor/{authorName}")
	List findByAuthorName(@PathVariable("authorName") String authorName,Pageable pageable)
	{

		return repo.findAll(BookSpecificationImpl.findByAuthorName(authorName));
		
	}
}
