/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.cv.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "cohort")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cohort.findAll", query = "SELECT c FROM Cohort c"),
    @NamedQuery(name = "Cohort.findByIdCohort", query = "SELECT c FROM Cohort c WHERE c.idCohort = :idCohort"),
    @NamedQuery(name = "Cohort.findByName", query = "SELECT c FROM Cohort c WHERE c.name = :name"),
    @NamedQuery(name = "Cohort.findByStartDate", query = "SELECT c FROM Cohort c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "Cohort.findByEndDate", query = "SELECT c FROM Cohort c WHERE c.endDate = :endDate")})
public class Cohort implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cohort")
    private Integer idCohort;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cohort")
    private Collection<Module> moduleCollection;

    public Cohort() {
    }

    public Cohort(Integer idCohort) {
        this.idCohort = idCohort;
    }

    public Cohort(Integer idCohort, String name, Date startDate, Date endDate) {
        this.idCohort = idCohort;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getIdCohort() {
        return idCohort;
    }

    public void setIdCohort(Integer idCohort) {
        this.idCohort = idCohort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Collection<Module> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Module> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCohort != null ? idCohort.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cohort)) {
            return false;
        }
        Cohort other = (Cohort) object;
        if ((this.idCohort == null && other.idCohort != null) || (this.idCohort != null && !this.idCohort.equals(other.idCohort))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.cv.data.Cohort[ idCohort=" + idCohort + " ]";
    }
    
}
