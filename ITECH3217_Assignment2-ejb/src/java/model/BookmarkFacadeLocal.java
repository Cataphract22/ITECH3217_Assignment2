/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Bookmark;
import entities.Item;
import entities.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drewm
 */
@Local
public interface BookmarkFacadeLocal {

    void create(Bookmark bookmark);

    void edit(Bookmark bookmark);

    void remove(Bookmark bookmark);

    Bookmark find(Object id);

    List<Bookmark> findAll();

    List<Bookmark> findRange(int[] range);

    int count();

    public List findAllByUserid(User userid);

    public void delete(Bookmark bookmark);

    public Bookmark findById(User user, Item item);
    
}
