package jpatest.service;

import io.micronaut.http.HttpResponse;
import jpatest.entity.Book;
import jpatest.entity.Book_;

import jpatest.repository.BookRepository;
import jpatest.specification.BookSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class BookService {
    @Inject
    BookRepository bookRepository;

    @PersistenceContext(name = "book")
    EntityManager entityManager;


    @Transactional
    public HttpResponse findAll() {
        // error
        Specification<Book> bookSpecification = (Specification<Book>) (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"),2);
        List booksByJpaSpecification = bookRepository.findAll(bookSpecification);

        // ok
        Iterable<Book> books = bookRepository.findAll();

        // error in
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        criteriaBuilder.equal(root.get("id"),2);


        List<Book> customSpecificaiton = entityManager.createQuery(query).getResultList();
//        Iterable<Book> all = bookRepository.findAll();
        return HttpResponse.ok(booksByJpaSpecification);
    }
}
