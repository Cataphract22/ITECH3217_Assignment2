/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Loan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drewm
 */
@Local
public interface LoanFacadeLocal {

    void create(Loan loan);

    void edit(Loan loan);

    void remove(Loan loan);

    Loan find(Object id);

    List<Loan> findAll();

    List<Loan> findRange(int[] range);

    int count();
    
}
