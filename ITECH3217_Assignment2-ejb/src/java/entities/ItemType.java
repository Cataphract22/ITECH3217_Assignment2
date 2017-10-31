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
    private String itemTypeString;
    
    @OneToMany(mappedBy = "itemType")
    private Collection<Item> itemCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemType")
    private Collection<LoanRule> loanRuleCollection;

    public ItemType() {
    }

    public ItemType(String _itemTypeString) {
        this.itemTypeString = _itemTypeString;
    }

    public String getItemTypeString() {
        return this.itemTypeString;
    }

    public void setItemTypeString(String _itemType) {
        this.itemTypeString = _itemType;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return this.itemCollection;
    }

    public void setItemCollection(Collection<Item> _itemCollection) {
        this.itemCollection = _itemCollection;
    }

    @XmlTransient
    public Collection<LoanRule> getLoanRuleCollection() {
        return this.loanRuleCollection;
    }

    public void setLoanRuleCollection(Collection<LoanRule> _loanRuleCollection) {
        this.loanRuleCollection = _loanRuleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.itemTypeString != null ? this.itemTypeString.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof ItemType)) {
            return false;
        }
        ItemType other = (ItemType) _object;
        if ((this.itemTypeString == null && other.itemTypeString != null) || (this.itemTypeString != null && !this.itemTypeString.equals(other.itemTypeString))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ItemType[ itemtype=" + this.itemTypeString + " ]";
    }
    
}
