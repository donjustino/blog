/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import article.entities.Article;
import article.entities.GestionnairesArticle;
import commentaire.Comment;
import commentaire.GestionnaireCommentaire;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import utilisateur.entities.GestionnairesUtilisateur;
import utilisateur.entities.Users;

/**
 *
 * @author MoMo
 */
@Singleton
@LocalBean
@Startup // Creation au déploiement
public class Initialisation {
    @EJB
    GestionnairesUtilisateur gu;

    @EJB
    GestionnairesArticle art;

    @EJB
    GestionnaireCommentaire com;

    @PostConstruct // Appel après constructeur
    public void initialize() {
        System.out.println("BD initialisee");
        Users justin = gu.creeUtilisateur("Mulenet", "Justin", "justinm", "mgs123");
        Article art1 = art.creerArticle("Premier titre", "Tag1", "Ceci est le contenu",justin);
        Comment c1 = com.creerCommentaire("Coucou", justin);
        List<Comment> comments;
        comments = new ArrayList<>();
        comments.add(c1);
        

        art1.setComments(comments);
    }
}
