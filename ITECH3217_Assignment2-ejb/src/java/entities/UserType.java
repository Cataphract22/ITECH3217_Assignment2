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
    private String usertype;
    
    @Column(name = "maxloans")
    private Short maxloans;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userType")
    private Collection<LoanRule> loanRuleCollection;
    
    @OneToMany(mappedBy = "type")
    private Collection<User> userCollection;

    public UserType() {
    }

    public UserType(String usertype) {
        this.usertype = usertype;
    }

    public String getUserTypeString() {
        return usertype;
    }

    public void setUserTypeString(String usertype) {
        this.usertype = usertype;
    }

    public Short getMaxLoans() {
        return maxloans;
    }

    public void setMaxLoans(Short maxloans) {
        this.maxloans = maxloans;
    }

    @XmlTransient
    public Collection<LoanRule> getLoanRuleCollection() {
        return loanRuleCollection;
    }

    public void setLoanRuleCollection(Collection<LoanRule> loanRuleCollection) {
        this.loanRuleCollection = loanRuleCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usertype != null ? usertype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) object;
        if ((this.usertype == null && other.usertype != null) || (this.usertype != null && !this.usertype.equals(other.usertype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserType[ usertype=" + usertype + " ]";
    }
    
}
