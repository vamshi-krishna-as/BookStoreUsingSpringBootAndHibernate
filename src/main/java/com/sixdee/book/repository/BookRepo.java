package com.sixdee.book.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sixdee.book.model.Book;

@Repository
public interface BookRepo extends PagingAndSortingRepository<Book, Integer>,JpaSpecificationExecutor
{

	List<Book> findByAuthorName(String authorName);

	List<Book> findByBookGenre(String bookGenre);

	Page<Book> findByAuthorName(String authorName, Pageable pageable);

}
