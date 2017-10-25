package model;

import entities.Comment;
import entities.Item;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CommentFacadeLocal {

    void create(Comment comment);

    void edit(Comment comment);

    void remove(Comment comment);

    Comment find(Object id);

    List<Comment> findAll();

    List<Comment> findRange(int[] range);

    int count();

    public List findAllByItemid(Item itemId);

    public List findAllByUserid(User userId);
    
}
