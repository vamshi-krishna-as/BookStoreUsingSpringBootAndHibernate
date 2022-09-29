package com.sixdee.book.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface BookSpecification<Book>
{
	Predicate toPredicate(Root<Book> root,CriteriaQuery<Book> querey,CriteriaBuilder builder);
}
