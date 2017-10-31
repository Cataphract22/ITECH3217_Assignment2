package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "equipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e")
    , @NamedQuery(name = "Equipment.findByItemid", query = "SELECT e FROM Equipment e WHERE e.itemid = :itemid")
    , @NamedQuery(name = "Equipment.findByModel", query = "SELECT e FROM Equipment e WHERE e.model = :model")
    , @NamedQuery(name = "Equipment.findBySerialno", query = "SELECT e FROM Equipment e WHERE e.serialno = :serialno")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemid")
    private Integer itemid;
    
    @Size(max = 40)
    @Column(name = "model")
    private String model;
    
    @Size(max = 80)
    @Column(name = "serialno")
    private String serialno;
    
    @JoinColumn(name = "itemid", referencedColumnName = "itemid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Equipment() {
    }

    public Equipment(Integer _itemID) {
        this.itemid = _itemID;
    }

    public Integer getItemID() {
        return this.itemid;
    }

    public void setItemID(Integer _itemID) {
        this.itemid = _itemID;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String _model) {
        this.model = _model;
    }

    public String getSerialNo() {
        return this.serialno;
    }

    public void setSerialNo(String _serialno) {
        this.serialno = _serialno;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item _item) {
        this.item = _item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.itemid != null ? this.itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) _object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Equipment[ itemid=" + this.itemid + " ]";
    }
    
}
