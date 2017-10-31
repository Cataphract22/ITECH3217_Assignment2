package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByCommentid", query = "SELECT c FROM Comment c WHERE c.commentid = :commentid")
    , @NamedQuery(name = "Comment.findByItemid", query = "SELECT c FROM Comment c WHERE c.itemid = :itemid")
    , @NamedQuery(name = "Comment.findByUserid", query = "SELECT c FROM Comment c WHERE c.userid = :userid")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentid")
    private Integer commentid;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "commenttext")
    private String commenttext;
    
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User user;
    
    @JoinColumn(name = "itemid", referencedColumnName = "itemid")
    @ManyToOne
    private Item item;

    public Comment() {
    }

    public Comment(Integer _commentID) {
        this.commentid = _commentID;
    }

    public Integer getCommentID() {
        return this.commentid;
    }

    public void setCommentID(Integer _commentID) {
        this.commentid = _commentID;
    }

    public String getCommentText() {
        return this.commenttext;
    }

    public void setCommentText(String _commentText) {
        this.commenttext = _commentText;
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
        hash += (commentid != null ? commentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object _object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(_object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) _object;
        if ((this.commentid == null && other.commentid != null) || (this.commentid != null && !this.commentid.equals(other.commentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Comment[ commentid=" + this.commentid + " ]";
    }
    
}
