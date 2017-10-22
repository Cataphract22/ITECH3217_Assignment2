/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Ebook;
import entities.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drewm
 */
@Local
public interface EbookFacadeLocal {

    void create(Ebook ebook);

    void edit(Ebook ebook);

    void remove(Ebook ebook);

    Ebook find(Object id);

    List<Ebook> findAll();

    List<Ebook> findRange(int[] range);

    int count();

    public Ebook findByItemid(Item item);
    
}
