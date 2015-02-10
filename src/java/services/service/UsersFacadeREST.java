/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import commentaire.service.AbstractFacade;
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
@Path("utilisateur.entities.users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;
    @EJB
    GestionnairesUtilisateur gu;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Users entity) {
        System.out.println("reception des données");
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Users entity) {
        entity.setStatus(true);
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
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @POST
    @Path("{login}/{password}")
    @Consumes({"application/xml", "application/json"})
    public Object check(@PathParam("login") String log, @PathParam("password") String pass) {
        System.out.println("login :" + log + "password :" + pass);
        boolean test = gu.checkUser(log, pass);
        if(test == true){
             Query q = em.createQuery("select u from Users u where u.username =:login");
             q.setParameter("login", log);
             System.out.println("Requete :" + q.getResultList());
             return q.getResultList();
        }
         return null;
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
    @Path("/mod/{user}")
    @Produces({"application/json"})
    public Object ckhUser(@PathParam("user") String user) {
        //Users use = (Users) gu.checkUser(user);
        //System.out.println(use.getUsername());
        //return use;
        Query q = em.createQuery("select u from Users u where u.username =:login");
        q.setParameter("login", user);
        System.out.println("Requete :" + q.getResultList());
        return q.getResultList();
    }

    @GET
    @Path("/valid/{id}")
    @Produces({"application/xml", "application/json"})
    public Boolean validArticle(@PathParam("id") Integer id) {
        System.out.println("fonction ok");
        gu.validerUtilisateur(id);
        return true;
    }

    @GET
    @Path("/disabled/{id}")
    @Produces({"application/xml", "application/json"})
    public Boolean disabledArticle(@PathParam("id") Integer id) {
        System.out.println("fonction ok");
        gu.DesactiverUtilisateur(id);
        return true;
    }
    @GET
    @Path("/stat")
    @Produces({"application/xml", "application/json"})
    public List<Users> findMostArticle() {
        Query q = em.createQuery("select COUNT(u) from Users u where u.status = true ");
        System.out.println("Requete :" + q.getResultList().toString());

        return q.getResultList();
    }

}
