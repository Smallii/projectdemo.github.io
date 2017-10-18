/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smalli
 */
@Entity
@Table(name = "captions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Captions.findAll", query = "SELECT c FROM Captions c")
    , @NamedQuery(name = "Captions.findById", query = "SELECT c FROM Captions c WHERE c.id = :id")
    , @NamedQuery(name = "Captions.findByMainTitle", query = "SELECT c FROM Captions c WHERE c.mainTitle = :mainTitle")
    , @NamedQuery(name = "Captions.findBySubtitled", query = "SELECT c FROM Captions c WHERE c.subtitled = :subtitled")
    , @NamedQuery(name = "Captions.findByPhotosPath", query = "SELECT c FROM Captions c WHERE c.photosPath = :photosPath")})
public class Captions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "main_title")
    private String mainTitle;
    @Size(max = 255)
    @Column(name = "subtitled")
    private String subtitled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photos_path")
    private String photosPath;

    public Captions() {
    }

    public Captions(Long id) {
        this.id = id;
    }

    public Captions(Long id, String photosPath) {
        this.id = id;
        this.photosPath = photosPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubtitled() {
        return subtitled;
    }

    public void setSubtitled(String subtitled) {
        this.subtitled = subtitled;
    }

    public String getPhotosPath() {
        return photosPath;
    }

    public void setPhotosPath(String photosPath) {
        this.photosPath = photosPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Captions)) {
            return false;
        }
        Captions other = (Captions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.Captions[ id=" + id + " ]";
    }
    
}
