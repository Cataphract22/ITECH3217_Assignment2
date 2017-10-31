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
    private String itemtype;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usertype")
    private String usertype;

    public LoanRulePK() {
    }

    public LoanRulePK(String itemtype, String usertype) {
        this.itemtype = itemtype;
        this.usertype = usertype;
    }

    public String getItemTypeString() {
        return itemtype;
    }

    public void setItemTypeString(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getUserType() {
        return usertype;
    }

    public void setUserType(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemtype != null ? itemtype.hashCode() : 0);
        hash += (usertype != null ? usertype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanRulePK)) {
            return false;
        }
        LoanRulePK other = (LoanRulePK) object;
        if ((this.itemtype == null && other.itemtype != null) || (this.itemtype != null && !this.itemtype.equals(other.itemtype))) {
            return false;
        }
        if ((this.usertype == null && other.usertype != null) || (this.usertype != null && !this.usertype.equals(other.usertype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoanRulePK[ itemtype=" + itemtype + ", usertype=" + usertype + " ]";
    }
    
}
