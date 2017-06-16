/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Smalli
 */
@Entity
@Table(name = "users_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersGroup.findAll", query = "SELECT u FROM UsersGroup u")
    , @NamedQuery(name = "UsersGroup.findByUgroupId", query = "SELECT u FROM UsersGroup u WHERE u.ugroupId = :ugroupId")
    , @NamedQuery(name = "UsersGroup.findByUgroupName", query = "SELECT u FROM UsersGroup u WHERE u.ugroupName = :ugroupName")})
public class UsersGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ugroup_id")
    private Long ugroupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ugroup_name")
    private String ugroupName;
    @OneToMany(mappedBy = "ugroupId")
    private Collection<FkUsersgroupRole> fkUsersgroupRoleCollection;
    @OneToMany(mappedBy = "ugroupId")
    private Collection<FkUsersgroupUsers> fkUsersgroupUsersCollection;

    public UsersGroup() {
    }

    public UsersGroup(Long ugroupId) {
        this.ugroupId = ugroupId;
    }

    public UsersGroup(Long ugroupId, String ugroupName) {
        this.ugroupId = ugroupId;
        this.ugroupName = ugroupName;
    }

    public Long getUgroupId() {
        return ugroupId;
    }

    public void setUgroupId(Long ugroupId) {
        this.ugroupId = ugroupId;
    }

    public String getUgroupName() {
        return ugroupName;
    }

    public void setUgroupName(String ugroupName) {
        this.ugroupName = ugroupName;
    }

    @XmlTransient
    public Collection<FkUsersgroupRole> getFkUsersgroupRoleCollection() {
        return fkUsersgroupRoleCollection;
    }

    public void setFkUsersgroupRoleCollection(Collection<FkUsersgroupRole> fkUsersgroupRoleCollection) {
        this.fkUsersgroupRoleCollection = fkUsersgroupRoleCollection;
    }

    @XmlTransient
    public Collection<FkUsersgroupUsers> getFkUsersgroupUsersCollection() {
        return fkUsersgroupUsersCollection;
    }

    public void setFkUsersgroupUsersCollection(Collection<FkUsersgroupUsers> fkUsersgroupUsersCollection) {
        this.fkUsersgroupUsersCollection = fkUsersgroupUsersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ugroupId != null ? ugroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersGroup)) {
            return false;
        }
        UsersGroup other = (UsersGroup) object;
        if ((this.ugroupId == null && other.ugroupId != null) || (this.ugroupId != null && !this.ugroupId.equals(other.ugroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.UsersGroup[ ugroupId=" + ugroupId + " ]";
    }
    
}
