/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.cv.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "dictionary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dictionary.findAll", query = "SELECT d FROM Dictionary d"),
    @NamedQuery(name = "Dictionary.findByIdDictionary", query = "SELECT d FROM Dictionary d WHERE d.idDictionary = :idDictionary"),
    @NamedQuery(name = "Dictionary.findByPrefix", query = "SELECT d FROM Dictionary d WHERE d.prefix = :prefix"),
    @NamedQuery(name = "Dictionary.findByPrefixCount", query = "SELECT d FROM Dictionary d WHERE d.prefixCount = :prefixCount"),
    @NamedQuery(name = "Dictionary.findByDescription", query = "SELECT d FROM Dictionary d WHERE d.description = :description")})
public class Dictionary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dictionary")
    private Integer idDictionary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prefix")
    private int prefix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prefix_count")
    private int prefixCount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;

    public Dictionary() {
    }

    public Dictionary(Integer idDictionary) {
        this.idDictionary = idDictionary;
    }

    public Dictionary(Integer idDictionary, int prefix, int prefixCount, String description) {
        this.idDictionary = idDictionary;
        this.prefix = prefix;
        this.prefixCount = prefixCount;
        this.description = description;
    }

    public Integer getIdDictionary() {
        return idDictionary;
    }

    public void setIdDictionary(Integer idDictionary) {
        this.idDictionary = idDictionary;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getPrefixCount() {
        return prefixCount;
    }

    public void setPrefixCount(int prefixCount) {
        this.prefixCount = prefixCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDictionary != null ? idDictionary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dictionary)) {
            return false;
        }
        Dictionary other = (Dictionary) object;
        if ((this.idDictionary == null && other.idDictionary != null) || (this.idDictionary != null && !this.idDictionary.equals(other.idDictionary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.cv.data.Dictionary[ idDictionary=" + idDictionary + " ]";
    }
    
}
