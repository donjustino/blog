/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package article.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Justin
 */
@Entity
@XmlRootElement
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String keyword;
    private String published_on;
    private String content;
    private String photo;
    private String position_longitude;
    private String position_latitude;
    private String position_name;
    private int idauthors;
    private int status;
    private int idcomments;
    
    public Article(){
        
    }
    
    public Article(String titre,String motclef,String article){
            this.title = titre;
            this.keyword = motclef;
            this.content = article;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPosition_longitude() {
        return position_longitude;
    }

    public void setPosition_longitude(String position_longitude) {
        this.position_longitude = position_longitude;
    }

    public String getPosition_latitude() {
        return position_latitude;
    }

    public void setPosition_latitude(String position_latitude) {
        this.position_latitude = position_latitude;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public int getIdauthors() {
        return idauthors;
    }

    public void setIdauthors(int idauthors) {
        this.idauthors = idauthors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdcomments() {
        return idcomments;
    }

    public void setIdcomments(int idcomments) {
        this.idcomments = idcomments;
    }
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "article.entities.Article[ id=" + id + " ]";
    }
    
}