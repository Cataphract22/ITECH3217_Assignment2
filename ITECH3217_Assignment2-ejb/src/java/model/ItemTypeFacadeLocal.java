package model;

import entities.ItemType;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ItemTypeFacadeLocal {

    void create(ItemType _itemType);

    void edit(ItemType _itemType);

    void remove(ItemType _itemType);

    ItemType find(Object _object);

    List<ItemType> findAll();

    List<ItemType> findRange(int[] _range);

    int count();
    
}
