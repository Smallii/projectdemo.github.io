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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Smalli
 */
@Entity
@Table(name = "userinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u")
    , @NamedQuery(name = "Userinfo.findByUinfoId", query = "SELECT u FROM Userinfo u WHERE u.uinfoId = :uinfoId")
    , @NamedQuery(name = "Userinfo.findByUinfoAge", query = "SELECT u FROM Userinfo u WHERE u.uinfoAge = :uinfoAge")
    , @NamedQuery(name = "Userinfo.findByUinfoSex", query = "SELECT u FROM Userinfo u WHERE u.uinfoSex = :uinfoSex")
    , @NamedQuery(name = "Userinfo.findByUinfoBirthday", query = "SELECT u FROM Userinfo u WHERE u.uinfoBirthday = :uinfoBirthday")})
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uinfo_id")
    private Long uinfoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uinfo_age")
    private int uinfoAge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uinfo_sex")
    private int uinfoSex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "uinfo_birthday")
    private String uinfoBirthday;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne
    private Users uid;

    public Userinfo() {
    }

    public Userinfo(Long uinfoId) {
        this.uinfoId = uinfoId;
    }

    public Userinfo(Long uinfoId, int uinfoAge, int uinfoSex, String uinfoBirthday) {
        this.uinfoId = uinfoId;
        this.uinfoAge = uinfoAge;
        this.uinfoSex = uinfoSex;
        this.uinfoBirthday = uinfoBirthday;
    }

    public Long getUinfoId() {
        return uinfoId;
    }

    public void setUinfoId(Long uinfoId) {
        this.uinfoId = uinfoId;
    }

    public int getUinfoAge() {
        return uinfoAge;
    }

    public void setUinfoAge(int uinfoAge) {
        this.uinfoAge = uinfoAge;
    }

    public int getUinfoSex() {
        return uinfoSex;
    }

    public void setUinfoSex(int uinfoSex) {
        this.uinfoSex = uinfoSex;
    }

    public String getUinfoBirthday() {
        return uinfoBirthday;
    }

    public void setUinfoBirthday(String uinfoBirthday) {
        this.uinfoBirthday = uinfoBirthday;
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
        hash += (uinfoId != null ? uinfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinfo)) {
            return false;
        }
        Userinfo other = (Userinfo) object;
        if ((this.uinfoId == null && other.uinfoId != null) || (this.uinfoId != null && !this.uinfoId.equals(other.uinfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.Model.Userinfo[ uinfoId=" + uinfoId + " ]";
    }
    
}
