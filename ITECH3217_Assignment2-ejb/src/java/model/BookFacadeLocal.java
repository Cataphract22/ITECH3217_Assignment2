package model;

import entities.Book;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BookFacadeLocal {

    void create(Book _book);

    void edit(Book _book);

    void remove(Book _book);

    Book find(Object _object);

    List<Book> findAll();

    List<Book> findRange(int[] _range);

    int count();

    public Book findByItemID(Item _item);
    
}
