package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "user_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u")
    , @NamedQuery(name = "UserType.findByUsertype", query = "SELECT u FROM UserType u WHERE u.usertype = :usertype")
    , @NamedQuery(name = "UserType.findByMaxloans", query = "SELECT u FROM UserType u WHERE u.maxloans = :maxloans")})
public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usertype")
    private String userTypeString;
    
    @Column(name = "maxloans")
    private Short maxLoans;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userType")
    private Collection<LoanRule> loanRuleCollection;
    
    @OneToMany(mappedBy = "type")
    private Collection<User> userCollection;

    public UserType() {
    }

    public UserType(String _userTypeString) {
        this.userTypeString = _userTypeString;
    }

    public String getUserTypeString() {
        return this.userTypeString;
    }

    public void setUserTypeString(String _userType) {
        this.userTypeString = _userType;
    }

    public Short getMaxLoans() {
        return this.maxLoans;
    }

    public void setMaxLoans(Short _maxLoans) {
        this.maxLoans = _maxLoans;
    }

    @XmlTransient
    public Collection<LoanRule> getLoanRuleCollection() {
        return this.loanRuleCollection;
    }

    public void setLoanRuleCollection(Collection<LoanRule> _loanRuleCollection) {
        this.loanRuleCollection = _loanRuleCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return this.userCollection;
    }

    public void setUserCollection(Collection<User> _userCollection) {
        this.userCollection = _userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.userTypeString != null ? userTypeString.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) _object;
        if ((this.userTypeString == null && other.userTypeString != null) || (this.userTypeString != null && !this.userTypeString.equals(other.userTypeString))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserType[ usertype=" + this.userTypeString + " ]";
    }
    
}
