/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilisateur.entities.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.glassfish.enterprise.concurrent.internal.Util;
import utilisateur.entities.GestionnairesUtilisateur;
import utilisateur.entities.Utilisateur;

/**
 *
 * @author Justin
 */
@Stateless
@Path("utilisateur.entities.utilisateur")
public class UtilisateurFacadeREST extends AbstractFacade<Utilisateur> {
    @EJB
    private GestionnairesUtilisateur gestionnairesUtilisateur;
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;
    

    public UtilisateurFacadeREST() {
        super(Utilisateur.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Utilisateur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Utilisateur entity) {
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
    public Utilisateur find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Utilisateur> findAll() {
        gestionnairesUtilisateur.creerUtilisateursDeTest();
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Utilisateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("/check/{user}/{mdp}")
    @Produces("text/html")
    public String findUser(@PathParam("user") String user, @PathParam("mdp") String mdp) {

        System.out.println("######### user :   " + user);
        System.out.println("######### mdp :   " + mdp);

        Query q = em.createNamedQuery("findUserByUsernameAndPassword");
        q.setParameter("nomUtilisateur", user);
        q.setParameter("motDePasse", mdp);

        if (q.getResultList().isEmpty()) {
            return "ko";
        } else {
            return "ok";
        }
    }

    @POST
    @Path("/check")
    @Produces({"application/json"})
    public Object authUser(@FormParam("user") String user, @FormParam("mdp") String mdp) {

        Query q = em.createNamedQuery("findUserByUsernameAndPassword");

        q.setParameter("nomUtilisateur", user);
        q.setParameter("motDePasse", mdp);

        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            Utilisateur u = (Utilisateur) q.getSingleResult();
            
            u.setAuthorizationKey(Utilisateur.randInt(10000, 99999));
            return u;
        }
    }
}
