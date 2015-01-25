/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commentaire;

import article.entities.Article;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import utilisateur.entities.Utilisateur;

/**
 *
 * @author Justin
 */
@Entity
@XmlRootElement
public class Commentaire  implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    
    private int idarticle;
    
    private String commentaire;
    
    private int idauteur; 
    
    public Commentaire(){
        
    }

    public Commentaire(int idart, int idaut, String commentaire) {
           this.idarticle = idart;
           this.idauteur = idaut;
           this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdauteur() {
        return idauteur;
    }

    public void setIdauteur(int idauteur) {
        this.idauteur = idauteur;
    }
    
}
