package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByItemid", query = "SELECT i FROM Item i WHERE i.itemid = :itemid")
    , @NamedQuery(name = "Item.findByTitle", query = "SELECT i FROM Item i WHERE i.title = :title")
    , @NamedQuery(name = "Item.findByImage", query = "SELECT i FROM Item i WHERE i.image = :image")
    , @NamedQuery(name = "Item.findByIsavailable", query = "SELECT i FROM Item i WHERE i.isavailable = :isavailable")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemid")
    private Integer itemID;
    
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    
    @Column(name = "isavailable")
    private boolean isAvailable;
    
    @OneToMany(mappedBy = "itemid")
    private Collection<Bookmark> bookmarkCollection;
    
    @JoinColumn(name = "itemtype", referencedColumnName = "itemtype")
    @ManyToOne
    private ItemType itemType;
    
    @OneToMany(mappedBy = "itemid")
    private Collection<Loan> loanCollection;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Book book;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Equipment equipment;
    
    @OneToMany(mappedBy = "itemid")
    private Collection<Comment> commentCollection;

    public Item() {
    }

    public Item(Integer _itemID) {
        this.itemID = _itemID;
    }

    public Integer getItemID() {
        return this.itemID;
    }

    public void setItemID(Integer _itemID) {
        this.itemID = _itemID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String _image) {
        this.image = _image;
    }

    public boolean Available() {
        return this.isAvailable;
    }

    public void setAvailable(boolean _available) {
        this.isAvailable = _available;
    }

    @XmlTransient
    public Collection<Bookmark> getBookmarkCollection() {
        return this.bookmarkCollection;
    }

    public void setBookmarkCollection(Collection<Bookmark> _bookmarkCollection) {
        this.bookmarkCollection = _bookmarkCollection;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public void setItemType(ItemType _itemtype) {
        this.itemType = _itemtype;
    }

    @XmlTransient
    public Collection<Loan> getLoanCollection() {
        return this.loanCollection;
    }

    public void setLoanCollection(Collection<Loan> _loanCollection) {
        this.loanCollection = _loanCollection;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book _book) {
        this.book = _book;
    }

    public Equipment getEquipment() {
        return this.equipment;
    }

    public void setEquipment(Equipment _equipment) {
        this.equipment = _equipment;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return this.commentCollection;
    }

    public void setCommentCollection(Collection<Comment> _commentCollection) {
        this.commentCollection = _commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.itemID != null ? this.itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof Item)) {
            return false;
        }
        Item other = (Item) _object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Item[ itemid=" + this.itemID + " ]";
    }
    
}
