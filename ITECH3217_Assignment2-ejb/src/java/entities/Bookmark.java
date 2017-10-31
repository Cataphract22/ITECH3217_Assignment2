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
    private Integer bookmarkid;
    
    @Column(name = "bookmarkdate")
    @Temporal(TemporalType.DATE)
    private Date bookmarkdate;
    
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User userid;
    
    @JoinColumn(name = "itemid", referencedColumnName = "itemid")
    @ManyToOne
    private Item itemid;

    public Bookmark() {
    }

    public Bookmark(Integer bookmarkid) {
        this.bookmarkid = bookmarkid;
    }

    public Integer getBookmarkID() {
        return bookmarkid;
    }

    public void setBookmarkID(Integer bookmarkid) {
        this.bookmarkid = bookmarkid;
    }

    public Date getBookmarkDate() {
        return bookmarkdate;
    }

    public void setBookmarkDate(Date bookmarkdate) {
        this.bookmarkdate = bookmarkdate;
    }

    public User getUser() {
        return userid;
    }

    public void setUser(User userid) {
        this.userid = userid;
    }

    public Item getItem() {
        return itemid;
    }

    public void setItem(Item itemid) {
        this.itemid = itemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookmarkid != null ? bookmarkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookmark)) {
            return false;
        }
        Bookmark other = (Bookmark) object;
        if ((this.bookmarkid == null && other.bookmarkid != null) || (this.bookmarkid != null && !this.bookmarkid.equals(other.bookmarkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bookmark[ bookmarkid=" + bookmarkid + " ]";
    }
    
}
