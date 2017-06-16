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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Smalli
 */
@Entity
@Table(name = "fk_users_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FkUsersRole.findAll", query = "SELECT f FROM FkUsersRole f")
    , @NamedQuery(name = "FkUsersRole.findById", query = "SELECT f FROM FkUsersRole f WHERE f.id = :id")})
public class FkUsersRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "urole", referencedColumnName = "urole")
    @ManyToOne
    private Role urole;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne
    private Users uid;

    public FkUsersRole() {
    }

    public FkUsersRole(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getUrole() {
        return urole;
    }

    public void setUrole(Role urole) {
        this.urole = urole;
    }

    public Users getUid() {
        return uid;
    }

    public void setUid(Users uid) {
        this.uid = uid;
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
        if (!(object instanceof FkUsersRole)) {
            return false;
        }
        FkUsersRole other = (FkUsersRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.FkUsersRole[ id=" + id + " ]";
    }
    
}
