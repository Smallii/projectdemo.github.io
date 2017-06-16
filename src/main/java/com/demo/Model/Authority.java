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
@Table(name = "authority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authority.findAll", query = "SELECT a FROM Authority a")
    , @NamedQuery(name = "Authority.findByAuthorityId", query = "SELECT a FROM Authority a WHERE a.authorityId = :authorityId")
    , @NamedQuery(name = "Authority.findByAuthorityKey", query = "SELECT a FROM Authority a WHERE a.authorityKey = :authorityKey")})
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authority_id")
    private Long authorityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "authority_key")
    private String authorityKey;
    @OneToMany(mappedBy = "authorityId")
    private Collection<FkAuthorityOperation> fkAuthorityOperationCollection;
    @OneToMany(mappedBy = "authorityId")
    private Collection<FkPageelementAuthority> fkPageelementAuthorityCollection;
    @OneToMany(mappedBy = "authorityId")
    private Collection<FkRoleAuthority> fkRoleAuthorityCollection;
    @OneToMany(mappedBy = "authorityId")
    private Collection<FkFileAuthority> fkFileAuthorityCollection;
    @OneToMany(mappedBy = "authorityId")
    private Collection<FkMenuAuthority> fkMenuAuthorityCollection;

    public Authority() {
    }

    public Authority(Long authorityId) {
        this.authorityId = authorityId;
    }

    public Authority(Long authorityId, String authorityKey) {
        this.authorityId = authorityId;
        this.authorityKey = authorityKey;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityKey() {
        return authorityKey;
    }

    public void setAuthorityKey(String authorityKey) {
        this.authorityKey = authorityKey;
    }

    @XmlTransient
    public Collection<FkAuthorityOperation> getFkAuthorityOperationCollection() {
        return fkAuthorityOperationCollection;
    }

    public void setFkAuthorityOperationCollection(Collection<FkAuthorityOperation> fkAuthorityOperationCollection) {
        this.fkAuthorityOperationCollection = fkAuthorityOperationCollection;
    }

    @XmlTransient
    public Collection<FkPageelementAuthority> getFkPageelementAuthorityCollection() {
        return fkPageelementAuthorityCollection;
    }

    public void setFkPageelementAuthorityCollection(Collection<FkPageelementAuthority> fkPageelementAuthorityCollection) {
        this.fkPageelementAuthorityCollection = fkPageelementAuthorityCollection;
    }

    @XmlTransient
    public Collection<FkRoleAuthority> getFkRoleAuthorityCollection() {
        return fkRoleAuthorityCollection;
    }

    public void setFkRoleAuthorityCollection(Collection<FkRoleAuthority> fkRoleAuthorityCollection) {
        this.fkRoleAuthorityCollection = fkRoleAuthorityCollection;
    }

    @XmlTransient
    public Collection<FkFileAuthority> getFkFileAuthorityCollection() {
        return fkFileAuthorityCollection;
    }

    public void setFkFileAuthorityCollection(Collection<FkFileAuthority> fkFileAuthorityCollection) {
        this.fkFileAuthorityCollection = fkFileAuthorityCollection;
    }

    @XmlTransient
    public Collection<FkMenuAuthority> getFkMenuAuthorityCollection() {
        return fkMenuAuthorityCollection;
    }

    public void setFkMenuAuthorityCollection(Collection<FkMenuAuthority> fkMenuAuthorityCollection) {
        this.fkMenuAuthorityCollection = fkMenuAuthorityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorityId != null ? authorityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authority)) {
            return false;
        }
        Authority other = (Authority) object;
        if ((this.authorityId == null && other.authorityId != null) || (this.authorityId != null && !this.authorityId.equals(other.authorityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.Authority[ authorityId=" + authorityId + " ]";
    }
    
}
