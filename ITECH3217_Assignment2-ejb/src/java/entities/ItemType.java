package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "item_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemType.findAll", query = "SELECT i FROM ItemType i")
    , @NamedQuery(name = "ItemType.findByItemtype", query = "SELECT i FROM ItemType i WHERE i.itemtype = :itemtype")})
public class ItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "itemtype")
    private String itemtype;
    
    @OneToMany(mappedBy = "itemtype")
    private Collection<Item> itemCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemType")
    private Collection<LoanRule> loanRuleCollection;

    public ItemType() {
    }

    public ItemType(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getItemtypeString() {
        return itemtype;
    }

    public void setItemTypeString(String itemtype) {
        this.itemtype = itemtype;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<LoanRule> getLoanRuleCollection() {
        return loanRuleCollection;
    }

    public void setLoanRuleCollection(Collection<LoanRule> loanRuleCollection) {
        this.loanRuleCollection = loanRuleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemtype != null ? itemtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemType)) {
            return false;
        }
        ItemType other = (ItemType) object;
        if ((this.itemtype == null && other.itemtype != null) || (this.itemtype != null && !this.itemtype.equals(other.itemtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ItemType[ itemtype=" + itemtype + " ]";
    }
    
}
