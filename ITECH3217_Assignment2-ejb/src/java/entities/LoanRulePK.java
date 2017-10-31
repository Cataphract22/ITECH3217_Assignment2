package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class LoanRulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "itemtype")
    private String itemType;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usertype")
    private String userType;

    public LoanRulePK() {
    }

    public LoanRulePK(String _itemType, String _userType) {
        this.itemType = _itemType;
        this.userType = _userType;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String _itemType) {
        this.itemType = _itemType;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String _userType) {
        this.userType = _userType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.itemType != null ? this.itemType.hashCode() : 0);
        hash += (this.userType != null ? this.userType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof LoanRulePK)) {
            return false;
        }
        LoanRulePK other = (LoanRulePK) _object;
        if ((this.itemType == null && other.itemType != null) || (this.itemType != null && !this.itemType.equals(other.itemType))) {
            return false;
        }
        if ((this.userType == null && other.userType != null) || (this.userType != null && !this.userType.equals(other.userType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoanRulePK[ itemtype=" + this.itemType + ", usertype=" + this.userType + " ]";
    }
    
}
