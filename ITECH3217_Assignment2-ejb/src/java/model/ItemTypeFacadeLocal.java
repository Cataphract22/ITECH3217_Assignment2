/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.ItemType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drewm
 */
@Local
public interface ItemTypeFacadeLocal {

    void create(ItemType itemType);

    void edit(ItemType itemType);

    void remove(ItemType itemType);

    ItemType find(Object id);

    List<ItemType> findAll();

    List<ItemType> findRange(int[] range);

    int count();
    
}
