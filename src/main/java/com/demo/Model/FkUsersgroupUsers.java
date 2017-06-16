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
@Table(name = "fk_usersgroup_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FkUsersgroupUsers.findAll", query = "SELECT f FROM FkUsersgroupUsers f")
    , @NamedQuery(name = "FkUsersgroupUsers.findById", query = "SELECT f FROM FkUsersgroupUsers f WHERE f.id = :id")})
public class FkUsersgroupUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "ugroup_id", referencedColumnName = "ugroup_id")
    @ManyToOne
    private UsersGroup ugroupId;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne
    private Users uid;

    public FkUsersgroupUsers() {
    }

    public FkUsersgroupUsers(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersGroup getUgroupId() {
        return ugroupId;
    }

    public void setUgroupId(UsersGroup ugroupId) {
        this.ugroupId = ugroupId;
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
        if (!(object instanceof FkUsersgroupUsers)) {
            return false;
        }
        FkUsersgroupUsers other = (FkUsersgroupUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.FkUsersgroupUsers[ id=" + id + " ]";
    }
    
}
