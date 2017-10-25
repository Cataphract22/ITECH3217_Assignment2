package model;

import entities.Bookmark;
import entities.Item;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BookmarkFacadeLocal {

    void create(Bookmark bookmark);

    void edit(Bookmark bookmark);

    void remove(Bookmark bookmark);

    Bookmark find(Object id);

    List<Bookmark> findAll();

    List<Bookmark> findRange(int[] range);

    int count();

    public List findAllByUserid(User userid);

    public void delete(Bookmark bookmark);

    public Bookmark findById(User user, Item item);
    
}
