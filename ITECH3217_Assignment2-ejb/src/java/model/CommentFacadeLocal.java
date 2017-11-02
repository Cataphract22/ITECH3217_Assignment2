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

    List<Comment> findAllUsers();

    List<Comment> findUsersInRange(int[] range);

    int count();

    public List findAllByItem(Item itemId);

    public List findAllByUser(User userId);
    
}
