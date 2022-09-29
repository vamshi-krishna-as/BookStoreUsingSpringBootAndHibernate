package com.sixdee.book.specificationimpl;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.sixdee.book.model.Book;
import com.sixdee.book.repository.BookRepo;

public class BookSpecificationImpl {
	
	public static Specification<Book> findByAuthorName(String authorName) {
		return new Specification<Book>() {
			

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				return criteriaBuilder.equal(root.get(authorName), "%"+ authorName);
					}
		};
	}
}
