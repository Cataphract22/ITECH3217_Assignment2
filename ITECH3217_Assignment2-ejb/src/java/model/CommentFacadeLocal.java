package model;

import entities.Comment;
import entities.Item;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CommentFacadeLocal {

    void create(Comment _comment);

    void edit(Comment _comment);

    void remove(Comment _comment);

    Comment find(Object _object);

    List<Comment> findAll();

    List<Comment> findRange(int[] _range);

    int count();

    public List findAllByItemID(Item _item);

    public List findAllByUserID(User _user);
    
}
