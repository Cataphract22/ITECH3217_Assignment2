package model;

import entities.Ebook;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EbookFacadeLocal {

    void create(Ebook ebook);

    void edit(Ebook ebook);

    void remove(Ebook ebook);

    Ebook find(Object id);

    List<Ebook> findAll();

    List<Ebook> findRange(int[] range);

    int count();

    public Ebook findByItem(Item item);
    
}
