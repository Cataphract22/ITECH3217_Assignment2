package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ebook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ebook.findAll", query = "SELECT e FROM Ebook e")
    , @NamedQuery(name = "Ebook.findByItemid", query = "SELECT e FROM Ebook e WHERE e.itemid = :itemid")
    , @NamedQuery(name = "Ebook.findByAuthor", query = "SELECT e FROM Ebook e WHERE e.author = :author")
    , @NamedQuery(name = "Ebook.findByPublisher", query = "SELECT e FROM Ebook e WHERE e.publisher = :publisher")
    , @NamedQuery(name = "Ebook.findByPublishYear", query = "SELECT e FROM Ebook e WHERE e.publishYear = :publishYear")
    , @NamedQuery(name = "Ebook.findByIsbn", query = "SELECT e FROM Ebook e WHERE e.isbn = :isbn")})
public class Ebook implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemid")
    private Integer itemID;
    
    @Size(max = 60)
    @Column(name = "author")
    private String author;
    
    @Size(max = 40)
    @Column(name = "publisher")
    private String publisher;
    
    @Column(name = "publishYear")
    private Integer publishYear;
    
    @Size(max = 13)
    @Column(name = "isbn")
    private String isbn;

    public Ebook() {
    }

    public Ebook(Integer _itemID) {
        this.itemID = _itemID;
    }

    public Integer getItemID() {
        return this.itemID;
    }

    public void setItemID(Integer _itemID) {
        this.itemID = _itemID;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String _author) {
        this.author = _author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String _publisher) {
        this.publisher = _publisher;
    }

    public Integer getPublishYear() {
        return this.publishYear;
    }

    public void setPublishYear(Integer _publishYear) {
        this.publishYear = _publishYear;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String _isbn) {
        this.isbn = _isbn;
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
        if (!(_object instanceof Ebook)) {
            return false;
        }
        Ebook other = (Ebook) _object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ebook[ itemid=" + this.itemID + " ]";
    }
    
}
