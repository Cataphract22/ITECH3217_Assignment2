package model;

import entities.Bookmark;
import entities.Item;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BookmarkFacadeLocal {

    void create(Bookmark _bookmark);

    void edit(Bookmark _bookmark);

    void remove(Bookmark _bookmark);

    Bookmark find(Object _object);

    List<Bookmark> findAll();

    List<Bookmark> findRange(int[] _range);

    int count();

    public List findAllByUserID(User _user);

    public void delete(Bookmark _bookmark);

    public Bookmark findByID(User _user, Item _item);
    
}
