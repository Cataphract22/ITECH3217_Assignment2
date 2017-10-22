/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Equipment;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drewm
 */
@Local
public interface EquipmentFacadeLocal {

    void create(Equipment equipment);

    void edit(Equipment equipment);

    void remove(Equipment equipment);

    Equipment find(Object id);

    List<Equipment> findAll();

    List<Equipment> findRange(int[] range);

    int count();

    public Equipment findByItemid(Item item);
    
}
