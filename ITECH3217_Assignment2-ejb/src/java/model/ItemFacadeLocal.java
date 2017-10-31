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

    void create(Item _item);

    void edit(Item _item);

    void remove(Item _item);

    Item find(Object _object);
    
    Item findByItemID(Integer _itemID);

    List<Item> findAll();

    List<Item> findRange(int[] _range);

    int count();

    public boolean update(Item _item);
    
}
