package jpatest.specification;

import jpatest.entity.Book;
import jpatest.entity.Book_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Transactional
public class BookSpecifications {
    public static Specification<Book> findGreaterThan() {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get(Book_.id), (long) 1);
            }
        };
    }
}
