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
@Table(name = "loan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l")
    , @NamedQuery(name = "Loan.findByLoanid", query = "SELECT l FROM Loan l WHERE l.loanid = :loanid")
    , @NamedQuery(name = "Loan.findByLoandate", query = "SELECT l FROM Loan l WHERE l.loandate = :loandate")
    , @NamedQuery(name = "Loan.findByDuedate", query = "SELECT l FROM Loan l WHERE l.duedate = :duedate")
    , @NamedQuery(name = "Loan.findByHistory", query = "SELECT l FROM Loan l WHERE l.history = :history")})
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loanid")
    private Integer loanID;
    
    @Column(name = "loandate")
    @Temporal(TemporalType.DATE)
    private Date loanDate;
    
    @Column(name = "duedate")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    
    @Column(name = "history")
    private Boolean history;
    
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User user;
    
    @JoinColumn(name = "itemid", referencedColumnName = "itemid")
    @ManyToOne
    private Item item;

    public Loan() {
    }

    public Loan(Integer _loanID) {
        this.loanID = _loanID;
    }

    public Integer getLoanID() {
        return this.loanID;
    }

    public void setLoanID(Integer _loanID) {
        this.loanID = _loanID;
    }

    public Date getLoanDate() {
        return this.loanDate;
    }

    public void setLoanDate(Date _loanDate) {
        this.loanDate = _loanDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date _dueDate) {
        this.dueDate = _dueDate;
    }

    public Boolean getHistory() {
        return this.history;
    }

    public void setHistory(Boolean _history) {
        this.history = _history;
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
        hash += (this.loanID != null ? this.loanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) _object;
        if ((this.loanID == null && other.loanID != null) || (this.loanID != null && !this.loanID.equals(other.loanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Loan[ loanid=" + this.loanID + " ]";
    }
    
}
