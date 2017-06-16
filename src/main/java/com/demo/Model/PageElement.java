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
@Table(name = "page_element")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PageElement.findAll", query = "SELECT p FROM PageElement p")
    , @NamedQuery(name = "PageElement.findByElementId", query = "SELECT p FROM PageElement p WHERE p.elementId = :elementId")
    , @NamedQuery(name = "PageElement.findByElementCode", query = "SELECT p FROM PageElement p WHERE p.elementCode = :elementCode")})
public class PageElement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "element_id")
    private Long elementId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "element_code")
    private String elementCode;
    @OneToMany(mappedBy = "elementId")
    private Collection<FkPageelementAuthority> fkPageelementAuthorityCollection;

    public PageElement() {
    }

    public PageElement(Long elementId) {
        this.elementId = elementId;
    }

    public PageElement(Long elementId, String elementCode) {
        this.elementId = elementId;
        this.elementCode = elementCode;
    }

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    @XmlTransient
    public Collection<FkPageelementAuthority> getFkPageelementAuthorityCollection() {
        return fkPageelementAuthorityCollection;
    }

    public void setFkPageelementAuthorityCollection(Collection<FkPageelementAuthority> fkPageelementAuthorityCollection) {
        this.fkPageelementAuthorityCollection = fkPageelementAuthorityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementId != null ? elementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PageElement)) {
            return false;
        }
        PageElement other = (PageElement) object;
        if ((this.elementId == null && other.elementId != null) || (this.elementId != null && !this.elementId.equals(other.elementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.PageElement[ elementId=" + elementId + " ]";
    }
    
}
