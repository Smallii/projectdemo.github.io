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
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByUrole", query = "SELECT r FROM Role r WHERE r.urole = :urole")
    , @NamedQuery(name = "Role.findByUroleName", query = "SELECT r FROM Role r WHERE r.uroleName = :uroleName")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "urole")
    private Long urole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "urole_name")
    private String uroleName;
    @OneToMany(mappedBy = "urole")
    private Collection<FkUsersgroupRole> fkUsersgroupRoleCollection;
    @OneToMany(mappedBy = "urole")
    private Collection<FkUsersRole> fkUsersRoleCollection;
    @OneToMany(mappedBy = "urole")
    private Collection<FkRoleAuthority> fkRoleAuthorityCollection;

    public Role() {
    }

    public Role(Long urole) {
        this.urole = urole;
    }

    public Role(Long urole, String uroleName) {
        this.urole = urole;
        this.uroleName = uroleName;
    }

    public Long getUrole() {
        return urole;
    }

    public void setUrole(Long urole) {
        this.urole = urole;
    }

    public String getUroleName() {
        return uroleName;
    }

    public void setUroleName(String uroleName) {
        this.uroleName = uroleName;
    }

    @XmlTransient
    public Collection<FkUsersgroupRole> getFkUsersgroupRoleCollection() {
        return fkUsersgroupRoleCollection;
    }

    public void setFkUsersgroupRoleCollection(Collection<FkUsersgroupRole> fkUsersgroupRoleCollection) {
        this.fkUsersgroupRoleCollection = fkUsersgroupRoleCollection;
    }

    @XmlTransient
    public Collection<FkUsersRole> getFkUsersRoleCollection() {
        return fkUsersRoleCollection;
    }

    public void setFkUsersRoleCollection(Collection<FkUsersRole> fkUsersRoleCollection) {
        this.fkUsersRoleCollection = fkUsersRoleCollection;
    }

    @XmlTransient
    public Collection<FkRoleAuthority> getFkRoleAuthorityCollection() {
        return fkRoleAuthorityCollection;
    }

    public void setFkRoleAuthorityCollection(Collection<FkRoleAuthority> fkRoleAuthorityCollection) {
        this.fkRoleAuthorityCollection = fkRoleAuthorityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urole != null ? urole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.urole == null && other.urole != null) || (this.urole != null && !this.urole.equals(other.urole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.Role[ urole=" + urole + " ]";
    }
    
}
