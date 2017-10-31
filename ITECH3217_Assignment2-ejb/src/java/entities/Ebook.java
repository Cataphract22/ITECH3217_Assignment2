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
    private Integer itemid;
    
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

    public Ebook(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemID() {
        return itemid;
    }

    public void setItemID(Integer itemid) {
        this.itemid = itemid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
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
        if (!(object instanceof Ebook)) {
            return false;
        }
        Ebook other = (Ebook) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ebook[ itemid=" + itemid + " ]";
    }
    
}
