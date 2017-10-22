/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.LoanRule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drewm
 */
@Local
public interface LoanRuleFacadeLocal {

    void create(LoanRule loanRule);

    void edit(LoanRule loanRule);

    void remove(LoanRule loanRule);

    LoanRule find(Object id);

    List<LoanRule> findAll();

    List<LoanRule> findRange(int[] range);

    int count();
    
}
