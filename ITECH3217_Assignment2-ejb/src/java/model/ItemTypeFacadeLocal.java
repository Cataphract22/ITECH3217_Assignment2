package model;

import entities.ItemType;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ItemTypeFacadeLocal {

    void create(ItemType itemType);

    void edit(ItemType itemType);

    void remove(ItemType itemType);

    ItemType find(Object id);

    List<ItemType> findAll();

    List<ItemType> findInRange(int[] range);

    int count();
    
}
