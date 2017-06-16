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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUid", query = "SELECT u FROM Users u WHERE u.uid = :uid")
    , @NamedQuery(name = "Users.findByUname", query = "SELECT u FROM Users u WHERE u.uname = :uname")
    , @NamedQuery(name = "Users.findByUpwd", query = "SELECT u FROM Users u WHERE u.upwd = :upwd")
    , @NamedQuery(name = "Users.findByUisoverdue", query = "SELECT u FROM Users u WHERE u.uisoverdue = :uisoverdue")
    , @NamedQuery(name = "Users.findByUislock", query = "SELECT u FROM Users u WHERE u.uislock = :uislock")
    , @NamedQuery(name = "Users.findByUisactivation", query = "SELECT u FROM Users u WHERE u.uisactivation = :uisactivation")
    , @NamedQuery(name = "Users.findByUisdisable", query = "SELECT u FROM Users u WHERE u.uisdisable = :uisdisable")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uid")
    private Long uid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "uname")
    private String uname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "upwd")
    private String upwd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uisoverdue")
    private int uisoverdue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uislock")
    private int uislock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uisactivation")
    private int uisactivation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uisdisable")
    private int uisdisable;
    @OneToMany(mappedBy = "uid")
    private Collection<FkUsersgroupUsers> fkUsersgroupUsersCollection;
    @OneToMany(mappedBy = "uid")
    private Collection<FkUsersRole> fkUsersRoleCollection;
    @OneToMany(mappedBy = "uid")
    private Collection<Userinfo> userinfoCollection;

    public Users() {
    }

    public Users(Long uid) {
        this.uid = uid;
    }

    public Users(Long uid, String uname, String upwd, int uisoverdue, int uislock, int uisactivation, int uisdisable) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.uisoverdue = uisoverdue;
        this.uislock = uislock;
        this.uisactivation = uisactivation;
        this.uisdisable = uisdisable;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public int getUisoverdue() {
        return uisoverdue;
    }

    public void setUisoverdue(int uisoverdue) {
        this.uisoverdue = uisoverdue;
    }

    public int getUislock() {
        return uislock;
    }

    public void setUislock(int uislock) {
        this.uislock = uislock;
    }

    public int getUisactivation() {
        return uisactivation;
    }

    public void setUisactivation(int uisactivation) {
        this.uisactivation = uisactivation;
    }

    public int getUisdisable() {
        return uisdisable;
    }

    public void setUisdisable(int uisdisable) {
        this.uisdisable = uisdisable;
    }

    @XmlTransient
    public Collection<FkUsersgroupUsers> getFkUsersgroupUsersCollection() {
        return fkUsersgroupUsersCollection;
    }

    public void setFkUsersgroupUsersCollection(Collection<FkUsersgroupUsers> fkUsersgroupUsersCollection) {
        this.fkUsersgroupUsersCollection = fkUsersgroupUsersCollection;
    }

    @XmlTransient
    public Collection<FkUsersRole> getFkUsersRoleCollection() {
        return fkUsersRoleCollection;
    }

    public void setFkUsersRoleCollection(Collection<FkUsersRole> fkUsersRoleCollection) {
        this.fkUsersRoleCollection = fkUsersRoleCollection;
    }

    @XmlTransient
    public Collection<Userinfo> getUserinfoCollection() {
        return userinfoCollection;
    }

    public void setUserinfoCollection(Collection<Userinfo> userinfoCollection) {
        this.userinfoCollection = userinfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.Users[ uid=" + uid + " ]";
    }
    
}
