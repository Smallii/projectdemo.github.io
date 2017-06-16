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
@Table(name = "fk_usersgroup_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FkUsersgroupRole.findAll", query = "SELECT f FROM FkUsersgroupRole f")
    , @NamedQuery(name = "FkUsersgroupRole.findById", query = "SELECT f FROM FkUsersgroupRole f WHERE f.id = :id")})
public class FkUsersgroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "urole", referencedColumnName = "urole")
    @ManyToOne
    private Role urole;
    @JoinColumn(name = "ugroup_id", referencedColumnName = "ugroup_id")
    @ManyToOne
    private UsersGroup ugroupId;

    public FkUsersgroupRole() {
    }

    public FkUsersgroupRole(Long id) {
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

    public UsersGroup getUgroupId() {
        return ugroupId;
    }

    public void setUgroupId(UsersGroup ugroupId) {
        this.ugroupId = ugroupId;
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
        if (!(object instanceof FkUsersgroupRole)) {
            return false;
        }
        FkUsersgroupRole other = (FkUsersgroupRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.FkUsersgroupRole[ id=" + id + " ]";
    }
    
}