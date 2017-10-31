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
    private Short loanTime;
    
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

    public LoanRule(LoanRulePK _loanRulePK) {
        this.loanRulePK = _loanRulePK;
    }

    public LoanRule(String _itemType, String _userType) {
        this.loanRulePK = new LoanRulePK(_itemType, _userType);
    }

    public LoanRulePK getLoanRulePK() {
        return this.loanRulePK;
    }

    public void setLoanRulePK(LoanRulePK _loanRulePK) {
        this.loanRulePK = _loanRulePK;
    }

    public Short getLoanTime() {
        return this.loanTime;
    }

    public void setLoanTime(Short _loanTime) {
        this.loanTime = _loanTime;
    }

    public Short getRenewals() {
        return this.renewals;
    }

    public void setRenewals(Short _renewals) {
        this.renewals = _renewals;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public void setItemType(ItemType _itemType) {
        this.itemType = _itemType;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public void setUserType(UserType _userType) {
        this.userType = _userType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.loanRulePK != null ? this.loanRulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof LoanRule)) {
            return false;
        }
        LoanRule other = (LoanRule) _object;
        if ((this.loanRulePK == null && other.loanRulePK != null) || (this.loanRulePK != null && !this.loanRulePK.equals(other.loanRulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoanRule[ loanRulePK=" + this.loanRulePK + " ]";
    }
    
}
