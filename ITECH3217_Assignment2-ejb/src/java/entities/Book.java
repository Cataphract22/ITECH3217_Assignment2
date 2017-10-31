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
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findByItemid", query = "SELECT b FROM Book b WHERE b.itemid = :itemid")
    , @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")
    , @NamedQuery(name = "Book.findByPublisher", query = "SELECT b FROM Book b WHERE b.publisher = :publisher")
    , @NamedQuery(name = "Book.findByPublishYear", query = "SELECT b FROM Book b WHERE b.publishYear = :publishYear")
    , @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "Book.findByFormat", query = "SELECT b FROM Book b WHERE b.format = :format")})
public class Book implements Serializable {

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
    
    @Size(max = 8)
    @Column(name = "format")
    private String format;
    
    @JoinColumn(name = "itemid", referencedColumnName = "itemid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Book() {
    }

    public Book(Integer _itemID) {
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

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String _format) {
        this.format = _format;
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
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof Book)) {
            return false;
        }
        Book other = (Book) _object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Book[ itemid=" + this.itemID + " ]";
    }
    
}
