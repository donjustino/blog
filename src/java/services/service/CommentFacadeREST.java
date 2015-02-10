/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import article.entities.Article;
import article.entities.GestionnairesArticle;
import commentaire.Comment;
import commentaire.GestionnaireCommentaire;
import commentaire.service.AbstractFacade;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import utilisateur.entities.GestionnairesUtilisateur;
import utilisateur.entities.Users;

/**
 *
 * @author Justin
 */
@Stateless
@Path("commentaire.comment")
public class CommentFacadeREST extends AbstractFacade<Comment> {

    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;
    @EJB
    GestionnairesUtilisateur gu;
    @EJB
    GestionnairesArticle art;
    @EJB
    GestionnaireCommentaire cmt;

    public CommentFacadeREST() {
        super(Comment.class);
    }

    @POST
    @Path("/{id}")
    @Consumes({"application/xml", "application/json"})
    public void create(Comment entity, @PathParam("id") long id) {
        Collection<Article> temp = art.checkArticle(id);
        Collection<Users> tempuse = gu.checkUser(entity.getCommentepar().getUsername());
        System.out.println(entity.getComment());
        System.out.println(entity.getCommentepar().getUsername());
        System.out.println(temp);

        Article arttmp;
        Users usetmp;
        Iterator i = temp.iterator();

        Iterator j = tempuse.iterator();

        while (j.hasNext()) {
            usetmp = (Users) j.next();
            while (i.hasNext()) {
                arttmp = (Article) i.next();
                Comment c1 = cmt.creerCommentaire(entity.getComment(), usetmp);
                c1.setA_article(arttmp);
            }

        }

        //super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Comment entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Comment find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("/admin")
    @Produces({"application/xml", "application/json"})
    public List<Comment> findCommentaire() {
        System.out.println("listage 2");
        return (List<Comment>) cmt.getAllCommentaireValid();
        //return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Comment> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("search/{id}")
    @Produces({"application/json"})
    public List<Comment> findCommentByArticle(@PathParam("id") long id) {
        System.out.println("fonction ok");
        Query q = em.createNamedQuery("findCommentByArticle");
        q.setParameter("article", id);
        return q.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("/valid/{id}")
    @Produces({"application/xml", "application/json"})
    public Boolean validArticle(@PathParam("id") Integer id) {
        System.out.println("fonction ok");
        cmt.validerCommentaire(id);
        return true;
    }

    @GET
    @Path("/disabled/{id}")
    @Produces({"application/xml", "application/json"})
    public Boolean disabledArticle(@PathParam("id") Integer id) {
        System.out.println("fonction ok");
        cmt.DesactiverCommentaire(id);
        return true;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Comment> findAll() {
        System.out.println("listage");
        return super.findAll();
        //System.out.println("listage");
        //return (List<Comment>) cmt.getAllCommentaireValid();
    }

    @GET
    @Path("/stat")
    @Produces({"application/xml", "application/json"})
    public List<Article> findMostArticle() {
        Query q = em.createQuery("select COUNT(u) from Comment u where u.status = true ");
        System.out.println("Requete :" + q.getResultList().toString());

        return q.getResultList();
    }

}
