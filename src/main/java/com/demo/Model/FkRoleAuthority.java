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
@Table(name = "fk_role_authority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FkRoleAuthority.findAll", query = "SELECT f FROM FkRoleAuthority f")
    , @NamedQuery(name = "FkRoleAuthority.findById", query = "SELECT f FROM FkRoleAuthority f WHERE f.id = :id")})
public class FkRoleAuthority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "authority_id", referencedColumnName = "authority_id")
    @ManyToOne
    private Authority authorityId;
    @JoinColumn(name = "urole", referencedColumnName = "urole")
    @ManyToOne
    private Role urole;

    public FkRoleAuthority() {
    }

    public FkRoleAuthority(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Authority getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Authority authorityId) {
        this.authorityId = authorityId;
    }

    public Role getUrole() {
        return urole;
    }

    public void setUrole(Role urole) {
        this.urole = urole;
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
        if (!(object instanceof FkRoleAuthority)) {
            return false;
        }
        FkRoleAuthority other = (FkRoleAuthority) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.FkRoleAuthority[ id=" + id + " ]";
    }
    
}
