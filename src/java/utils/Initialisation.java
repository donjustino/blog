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
        Article art1 = art.creerArticle("Carla Bruni : mais pourquoi ne quitte-t-elle plus son col roulé ?!", "People", "Mannequin, chanteuse, Carla Bruni a défilé et posé pour les plus grands. Mais lors de ces dernières apparitions publiques, l'épouse de l'ancien président opte pour une stratégie low profile.\n" +
"\n" +
"Lors de la marche républicaine du 11 janvier dernier, le col roulé de Carla Bruni Sarkozy avait beaucoup fait parler. Le Monde notait, malicieusement, que l'ex first lady avait salué François Hollande sur le perron de l'Elysée \"cachée derrière son col roulé\", tandis que le Daily Mail se lançait dans une interprétation très personnelle de ce choix vestimentaire.\n" +
"\n" +
"Alors opération des dents de sagesse, gros coup de froid, ou relooking version Cristina Cordula ? Que nous dit le col roulé de Carla Bruni ?\n" +
"\n" +
"ELLE N'A PAS ENVIE D'ÊTRE LÀ\n" +
"\n" +
"Tête baissée au milieu du cortège des chef d'Etat du monde entier – de peur peut-être de se faire marcher sur les pieds par le garde du corps du premier ministre israélien ? – Carla Bruni se fait toute petite. Elle s'efface derrière son mari, bien décidé à tout faire pour apparaître au premier rang de la photo officielle.\n" +
"\n" +
"Rebelote dimanche à la pour le congrès de l'UMP à la Mutualité où Carla Bruni avait troqué son col roulé bleu ciel pour un col roulé beige et des grosses lunettes de soleil. Rien d'étonnant à voir la femme de l'ex président emmitouflée de la sorte alors qu'il fait à peine zéro à Paris. Et pourtant. En as de la comm, Carla Sarkozy ne laisse rien au hasard quand il s'agit d'apparaître sur une photo officielle. Celle que l'on a dit un temps réticente à l'idée de se remettre dans la bataille politique, se cache désormais derrière d'épaisses lunettes noires.\n" +
"\n" +
"BYE BYE BLING BLING\n" +
"\n" +
"Si Carla Bruni est l'héritière d'une grande famille italienne, pas question de faire preuve d'ostentation. Quand elle offre une montre à Nicolas, ce n'est pas une Rolex (trop m'as-tu vu) mais une Patek Philip, une montre de luxe tout aussi exclusive – comptez 40.000 euros pour vous offrir le modèle de l'ancien président – mais moins connotée \"époque bling-bling\". Retraitée des podiums, mère de famille (Aurélien et Giulia), Carla Bruni a semble-t-il troqué les tenues de créateur pour des tenues beaucoup plus casual et confortables : jeans, bottes, pull douillets, Carla Bruni dit non au bling-bling. Avec Nicolas, ils donnent à voir l'image d'une famille presque comme tout le monde...",justin,"https://s.yimg.com/bt/api/res/1.2/h.oY9thxGiek4aj84nGzgA--/YXBwaWQ9eW5ld3M7Y2g9NjA4O2NyPTE7Y3c9ODEwO2R4PTA7ZHk9MDtmaT11bGNyb3A7aD00NzI7aWw9cGxhbmU7cT03NTt3PTYyOQ--/http://media.zenfs.com/fr_FR/News/closer/PHOTOS-Carla-Bruni-mais-pourquoi-ne-quitte-t-elle-plus-son-col-roule_exact810x609_l.jpg");
        
        Comment c1 = com.creerCommentaire("Coucou1", justin);
        Comment c3 = com.creerCommentaire("Coucou2", justin);
        Comment c4 = com.creerCommentaire("Coucou3", justin);
     
        c1.setA_article(art1);
        c4.setA_article(art1);
        c3.setA_article(art1);
        
        Users rudy = gu.creeUtilisateur("Ricciardi", "Rudy", "rudyr", "mgs123");
        Article art2 = art.creerArticle("Le compte en Suisse de Dugarry", "Finance", "Le dernier transfert de Dugarry sent le roussi.\n" +
"\n" +
"Le Monde, ainsi que plusieurs médias étrangers, a révélé ce dimanche une liste de personnalités françaises ayant un compte bancaire en Suisse. Parmi elles, Christophe Dugarry, consultant pour Canal+. L'ancien international français aurait ainsi ouvert un compte en 2005, année lors de laquelle l'attaquant a arrêté sa carrière, après une dernière pige dans un club qatari, au Qatar SC, à Doha. Selon le quotidien français, ce sont plus de 2 millions d'euros qui auraient été amassés par Dugarry. \"Le champion du monde de football en 1998, reconverti en consultant sportif, a ouvert en 2005 un compte associé à une société offshore  Faroe Capital, ouverte par la filiale de HSBC dans les Îles Vierges britanniques  nanti de plus de 2 millions d'euros selon les données de la banque.\"\n" +
"\n" +
"Duga s'est pour l'instant refusé à tout commentaire. ",rudy,"https://s1.yimg.com/bt/api/res/1.2/H9PWqgG5C3MFh3ckiVjUbw--/YXBwaWQ9eW5ld3M7Zmk9ZmlsbDtoPTM5NDtpbD1wbGFuZTtweW9mZj0wO3E9NzU7dz01OTk-/http://media.zenfs.com/fr_FR/Sports/SoFoot/img-le-compte-en-suisse-de-dugarry-1423478761_x600_articles-195956.jpg");
        Comment c2 = com.creerCommentaire("en revoir", rudy);
        c2.setA_article(art2);
        
        Article art3 = art.creerArticle("Coup de feu à Marseille", "Violence", "PARIS (Reuters) - Des hommes cagoulés ont tiré lundi à la Kalachnikov en direction d'un véhicule de police dans une cité sensible de Marseille, a déclaré à Reuters Pierre-Marie Bourniquel, directeur départemental de la sécurité publique des Bouches-du-Rhône.\n" +
"\"Il y a eu des tirs provenant de gens cagoulés et armés de Kalachnikovs en direction d’un véhicule de police\", a-t-il dit.\n" +
"Le Premier ministre Manuel Valls doit mener lundi et mardi une visite de deux jours à Marseille pour saluer la baisse de la délinquance dans la deuxième ville de France.\n" +
"Le Groupe d'intervention de la police nationale (GIPN) s'est déployé dans la cité de la Castellane, où les coups de feu ont été tirés, et les forces de l’ordre bouclaient les entrées de la cité située dans les quartiers Nord de la ville.\n" +
"Les 7.000 habitants de la cité ont été confinés chez eux et une crèche a été évacuée. Des collégiens ont également été confinés dans leur établissement.\n" +
"Caroline Pozmentier, adjointe à la sécurité du maire UMP de Marseille, a estimé sur BFM TV que l'incident était probablement lié au trafic de drogue dans la cité.\n" +
"Mardi dernier, un homme de 30 ans, Moussa Coulibaly, avait légèrement blessé deux militaires à Nice devant un centre communautaire juif, une agression que les autorités ont attribuée à sa \"radicalisation\".\n" +
"Les forces de l'ordre sont en alerte maximale après les attentats de début janvier qui ont fait 17 morts en France.\n" +
"(François Revilla, édité par Yves Clarisse)",justin,"https://s.yimg.com/bt/api/res/1.2/FenWWWjpCn0pKeVBcdNshA--/YXBwaWQ9eW5ld3M7Zmk9aW5zZXQ7aD0zNDI7aWw9cGxhbmU7cT03NTt3PTUxMg--/http://l.yimg.com/os/publish-images/news/2015-02-09/f3fba680-b052-11e4-a040-c1ccd102df16_marseille.jpg");
             
    art1.setStatus(true);
    art2.setStatus(true);
    art3.setStatus(true);
    c1.setStatus(true);
    c2.setStatus(true);
    c3.setStatus(true);
    }
   
}
