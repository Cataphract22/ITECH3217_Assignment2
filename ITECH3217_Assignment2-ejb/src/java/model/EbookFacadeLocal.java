package model;

import entities.Ebook;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EbookFacadeLocal {

    void create(Ebook _ebook);

    void edit(Ebook _ebook);

    void remove(Ebook _ebook);

    Ebook find(Object _object);

    List<Ebook> findAll();

    List<Ebook> findRange(int[] _range);

    int count();

    public Ebook findByItemID(Item _item);
    
}
