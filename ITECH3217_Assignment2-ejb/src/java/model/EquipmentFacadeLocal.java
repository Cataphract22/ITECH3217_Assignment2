package model;

import entities.Equipment;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EquipmentFacadeLocal {

    void create(Equipment _equipment);

    void edit(Equipment _equipment);

    void remove(Equipment _equipment);

    Equipment find(Object _object);

    List<Equipment> findAll();

    List<Equipment> findRange(int[] _range);

    int count();

    public Equipment findByItemID(Item _item);
    
}
