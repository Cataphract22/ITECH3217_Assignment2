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

    List<Bookmark> findInRange(int[] range);

    int count();

    public List findAllByUser(User userid);

    public void delete(Bookmark bookmark);

    public Bookmark findByUser(User user, Item item);
    
}
