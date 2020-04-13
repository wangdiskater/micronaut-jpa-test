package jpatest.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Book.class)
public class Book_ {
    public static volatile SingularAttribute<Book, Long> id;
}
