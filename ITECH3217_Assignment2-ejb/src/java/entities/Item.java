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
    private Integer itemid;
    
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
    private boolean isavailable;
    
    @OneToMany(mappedBy = "itemid")
    private Collection<Bookmark> bookmarkCollection;
    
    @JoinColumn(name = "itemtype", referencedColumnName = "itemtype")
    @ManyToOne
    private ItemType itemtype;
    
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

    public Item(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemID() {
        return itemid;
    }

    public void setItemID(Integer itemid) {
        this.itemid = itemid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean Available() {
        return isavailable;
    }

    public void setAvailable(boolean isavailable) {
        this.isavailable = isavailable;
    }

    @XmlTransient
    public Collection<Bookmark> getBookmarkCollection() {
        return bookmarkCollection;
    }

    public void setBookmarkCollection(Collection<Bookmark> bookmarkCollection) {
        this.bookmarkCollection = bookmarkCollection;
    }

    public ItemType getItemType() {
        return itemtype;
    }

    public void setItemType(ItemType itemtype) {
        this.itemtype = itemtype;
    }

    @XmlTransient
    public Collection<Loan> getLoanCollection() {
        return loanCollection;
    }

    public void setLoanCollection(Collection<Loan> loanCollection) {
        this.loanCollection = loanCollection;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Item[ itemid=" + itemid + " ]";
    }
    
}
