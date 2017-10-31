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
    private Integer loanid;
    
    @Column(name = "loandate")
    @Temporal(TemporalType.DATE)
    private Date loandate;
    
    @Column(name = "duedate")
    @Temporal(TemporalType.DATE)
    private Date duedate;
    
    @Column(name = "history")
    private Boolean history;
    
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User userid;
    
    @JoinColumn(name = "itemid", referencedColumnName = "itemid")
    @ManyToOne
    private Item itemid;

    public Loan() {
    }

    public Loan(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getLoanID() {
        return loanid;
    }

    public void setLoanID(Integer loanid) {
        this.loanid = loanid;
    }

    public Date getLoanDate() {
        return loandate;
    }

    public void setLoanDate(Date loandate) {
        this.loandate = loandate;
    }

    public Date getDueDate() {
        return duedate;
    }

    public void setDueDate(Date duedate) {
        this.duedate = duedate;
    }

    public Boolean getHistory() {
        return history;
    }

    public void setHistory(Boolean history) {
        this.history = history;
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
        hash += (loanid != null ? loanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.loanid == null && other.loanid != null) || (this.loanid != null && !this.loanid.equals(other.loanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Loan[ loanid=" + loanid + " ]";
    }
    
}
