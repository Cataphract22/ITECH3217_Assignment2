package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "loan_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanRule.findAll", query = "SELECT l FROM LoanRule l")
    , @NamedQuery(name = "LoanRule.findByItemtype", query = "SELECT l FROM LoanRule l WHERE l.loanRulePK.itemtype = :itemtype")
    , @NamedQuery(name = "LoanRule.findByUsertype", query = "SELECT l FROM LoanRule l WHERE l.loanRulePK.usertype = :usertype")
    , @NamedQuery(name = "LoanRule.findByLoantime", query = "SELECT l FROM LoanRule l WHERE l.loantime = :loantime")
    , @NamedQuery(name = "LoanRule.findByRenewals", query = "SELECT l FROM LoanRule l WHERE l.renewals = :renewals")
    , @NamedQuery(name = "LoanRule.findByRule", query = "SELECT l FROM LoanRule l WHERE l.loanRulePK.itemtype = :itemtype AND l.loanRulePK.usertype = :usertype")})
public class LoanRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LoanRulePK loanRulePK;
    
    @Column(name = "loantime")
    private Short loantime;
    
    @Column(name = "renewals")
    private Short renewals;
    
    @JoinColumn(name = "itemtype", referencedColumnName = "itemtype", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ItemType itemType;
    
    @JoinColumn(name = "usertype", referencedColumnName = "usertype", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserType userType;

    public LoanRule() {
    }

    public LoanRule(LoanRulePK loanRulePK) {
        this.loanRulePK = loanRulePK;
    }

    public LoanRule(String itemtype, String usertype) {
        this.loanRulePK = new LoanRulePK(itemtype, usertype);
    }

    public LoanRulePK getLoanRulePK() {
        return loanRulePK;
    }

    public void setLoanRulePK(LoanRulePK loanRulePK) {
        this.loanRulePK = loanRulePK;
    }

    public Short getLoanTime() {
        return loantime;
    }

    public void setLoanTime(Short loantime) {
        this.loantime = loantime;
    }

    public Short getRenewals() {
        return renewals;
    }

    public void setRenewals(Short renewals) {
        this.renewals = renewals;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanRulePK != null ? loanRulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanRule)) {
            return false;
        }
        LoanRule other = (LoanRule) object;
        if ((this.loanRulePK == null && other.loanRulePK != null) || (this.loanRulePK != null && !this.loanRulePK.equals(other.loanRulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoanRule[ loanRulePK=" + loanRulePK + " ]";
    }
    
}
