package jpatest.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import jpatest.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//@Repository
//public interface BookRepository extends CrudRepository<Book, Long> {
//    Book find(String title);
//}


// specifications
@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Book find(String title);
}
