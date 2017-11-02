package model;

import entities.Equipment;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EquipmentFacadeLocal {

    void create(Equipment equipment);

    void edit(Equipment equipment);

    void remove(Equipment equipment);

    Equipment find(Object id);

    List<Equipment> findAllUsers();

    List<Equipment> findUsersInRange(int[] range);

    int count();

    public Equipment findByItem(Item item);
    
}
