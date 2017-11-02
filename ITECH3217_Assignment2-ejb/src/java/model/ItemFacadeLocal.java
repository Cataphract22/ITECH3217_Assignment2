package model;

import entities.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drewm
 */
@Local
public interface ItemFacadeLocal {

    void create(Item item);

    void edit(Item item);

    void remove(Item item);

    Item find(Object id);
    
    Item findByItemID(Integer id);

    List<Item> findAllUsers();

    List<Item> findUsersInRange(int[] range);

    int count();

    public boolean update(Item item);
    
}
