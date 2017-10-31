package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByGivenname", query = "SELECT u FROM User u WHERE u.givenname = :givenname")
    , @NamedQuery(name = "User.findByFamilyname", query = "SELECT u FROM User u WHERE u.familyname = :familyname")
    , @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByIsadmin", query = "SELECT u FROM User u WHERE u.isadmin = :isadmin")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userID;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    
    @Size(max = 30)
    @Column(name = "givenname")
    private String givenName;
    
    @Size(max = 30)
    @Column(name = "familyname")
    private String familyName;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "phone")
    private String phone;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    
    @Column(name = "isadmin")
    private Short isAdmin;
    
    @OneToMany(mappedBy = "userid")
    private Collection<Bookmark> bookmarkCollection;
    
    @OneToMany(mappedBy = "userid")
    private Collection<Loan> loanCollection;
    
    @OneToMany(mappedBy = "userid")
    private Collection<Comment> commentCollection;
    
    @JoinColumn(name = "type", referencedColumnName = "usertype")
    @ManyToOne
    private UserType userType;

    public User() {
    }

    public User(Integer _userID) {
        this.userID = _userID;
    }

    public User(Integer _userID, String _password) {
        this.userID = _userID;
        this.password = _password;
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer _userID) {
        this.userID = _userID;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenName(String _givenName) {
        this.givenName = _givenName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String _familyName) {
        this.familyName = _familyName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String _phone) {
        this.phone = _phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public Short isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(Short _isAdmin) {
        this.isAdmin = _isAdmin;
    }

    @XmlTransient
    public Collection<Bookmark> getBookmarkCollection() {
        return this.bookmarkCollection;
    }

    public void setBookmarkCollection(Collection<Bookmark> _bookmarkCollection) {
        this.bookmarkCollection = _bookmarkCollection;
    }

    @XmlTransient
    public Collection<Loan> getLoanCollection() {
        return this.loanCollection;
    }

    public void setLoanCollection(Collection<Loan> _loanCollection) {
        this.loanCollection = _loanCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return this.commentCollection;
    }

    public void setCommentCollection(Collection<Comment> _commentCollection) {
        this.commentCollection = _commentCollection;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public void setUserType(UserType _userType) {
        this.userType = _userType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.userID != null ? this.userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof User)) {
            return false;
        }
        User other = (User) _object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ userid=" + this.userID + " ]";
    }
    
}
