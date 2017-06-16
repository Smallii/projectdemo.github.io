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
@Table(name = "function_operation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FunctionOperation.findAll", query = "SELECT f FROM FunctionOperation f")
    , @NamedQuery(name = "FunctionOperation.findByOperationId", query = "SELECT f FROM FunctionOperation f WHERE f.operationId = :operationId")
    , @NamedQuery(name = "FunctionOperation.findByOperationName", query = "SELECT f FROM FunctionOperation f WHERE f.operationName = :operationName")
    , @NamedQuery(name = "FunctionOperation.findByOperationCode", query = "SELECT f FROM FunctionOperation f WHERE f.operationCode = :operationCode")
    , @NamedQuery(name = "FunctionOperation.findByOperationUrl", query = "SELECT f FROM FunctionOperation f WHERE f.operationUrl = :operationUrl")})
public class FunctionOperation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "operation_id")
    private Long operationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "operation_name")
    private String operationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "operation_code")
    private String operationCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "operation_url")
    private String operationUrl;
    @OneToMany(mappedBy = "operationId")
    private Collection<FkAuthorityOperation> fkAuthorityOperationCollection;

    public FunctionOperation() {
    }

    public FunctionOperation(Long operationId) {
        this.operationId = operationId;
    }

    public FunctionOperation(Long operationId, String operationName, String operationCode, String operationUrl) {
        this.operationId = operationId;
        this.operationName = operationName;
        this.operationCode = operationCode;
        this.operationUrl = operationUrl;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationUrl() {
        return operationUrl;
    }

    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    @XmlTransient
    public Collection<FkAuthorityOperation> getFkAuthorityOperationCollection() {
        return fkAuthorityOperationCollection;
    }

    public void setFkAuthorityOperationCollection(Collection<FkAuthorityOperation> fkAuthorityOperationCollection) {
        this.fkAuthorityOperationCollection = fkAuthorityOperationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operationId != null ? operationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunctionOperation)) {
            return false;
        }
        FunctionOperation other = (FunctionOperation) object;
        if ((this.operationId == null && other.operationId != null) || (this.operationId != null && !this.operationId.equals(other.operationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.FunctionOperation[ operationId=" + operationId + " ]";
    }
    
}
