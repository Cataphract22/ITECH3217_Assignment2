package model;

import entities.Book;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BookFacadeLocal {

    void create(Book book);

    void edit(Book book);

    void remove(Book book);

    Book find(Object id);

    List<Book> findAll();

    List<Book> findRange(int[] range);

    int count();

    public Book findByItem(Item item);
    
}
