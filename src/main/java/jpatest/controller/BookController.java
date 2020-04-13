package jpatest.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jpatest.entity.Book;
import jpatest.repository.BookRepository;
import jpatest.service.BookService;
import jpatest.specification.BookSpecifications;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;


@Controller("/book")
public class BookController {
    @Inject
    BookService bookService;
    @Transactional
    @Get()
    HttpResponse book() {
        return bookService.findAll();
    }
}
