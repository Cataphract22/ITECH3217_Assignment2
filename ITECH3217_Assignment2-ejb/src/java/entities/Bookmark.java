package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "bookmark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookmark.findAll", query = "SELECT b FROM Bookmark b")
    , @NamedQuery(name = "Bookmark.findByBookmarkid", query = "SELECT b FROM Bookmark b WHERE b.bookmarkid = :bookmarkid")
    , @NamedQuery(name = "Bookmark.findByBookmarkdate", query = "SELECT b FROM Bookmark b WHERE b.bookmarkdate = :bookmarkdate")})
public class Bookmark implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookmarkid")
    private Integer bookmarkID;
    
    @Column(name = "bookmarkdate")
    @Temporal(TemporalType.DATE)
    private Date bookmarkDate;
    
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User user;
    
    @JoinColumn(name = "itemid", referencedColumnName = "itemid")
    @ManyToOne
    private Item item;

    public Bookmark() {
    }

    public Bookmark(Integer _bookmarkID) {
        this.bookmarkID = _bookmarkID;
    }

    public Integer getBookmarkID() {
        return this.bookmarkID;
    }

    public void setBookmarkID(Integer _bookmarkID) {
        this.bookmarkID = _bookmarkID;
    }

    public Date getBookmarkDate() {
        return this.bookmarkDate;
    }

    public void setBookmarkDate(Date _bookmarkDate) {
        this.bookmarkDate = _bookmarkDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User _user) {
        this.user = _user;
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
        hash += (this.bookmarkID != null ? this.bookmarkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof Bookmark)) {
            return false;
        }
        Bookmark other = (Bookmark) _object;
        if ((this.bookmarkID == null && other.bookmarkID != null) || (this.bookmarkID != null && !this.bookmarkID.equals(other.bookmarkID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bookmark[ bookmarkid=" + this.bookmarkID + " ]";
    }
    
}
