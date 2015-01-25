/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commentaire;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import utilisateur.entities.Users;

/**
 *
 * @author Justin
 */
@Entity
@XmlRootElement
public class Comment  implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String comment;
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date commented_date;
    @ManyToOne
    private Users commentepar;
    
    
    public Comment(){
        
    }

    public Comment(String commentaire) {
           this.comment= commentaire;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommented_date() {
        return commented_date;
    }

    public void setCommented_date(Date commented_date) {
        this.commented_date = commented_date;
    }

    public Users getCommentepar() {
        return commentepar;
    }

    public void setCommentepar(Users commentepar) {
        this.commentepar = commentepar;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCommentaire() {
        return comment;
    }

    public void setCommentaire(String commentaire) {
        this.comment = commentaire;
    }
 }
