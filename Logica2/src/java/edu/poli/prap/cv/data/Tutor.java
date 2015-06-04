/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.cv.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author usuario
 */
@Entity
@Table(name = "tutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findByDocumentNumber", query = "SELECT t FROM Tutor t WHERE t.documentNumber = :documentNumber"),
    @NamedQuery(name = "Tutor.findByUsername", query = "SELECT t FROM Tutor t WHERE t.username = :username"),
    @NamedQuery(name = "Tutor.findByNames", query = "SELECT t FROM Tutor t WHERE t.names = :names"),
    @NamedQuery(name = "Tutor.findBySurnames", query = "SELECT t FROM Tutor t WHERE t.surnames = :surnames"),
    @NamedQuery(name = "Tutor.findByPersonalEmail", query = "SELECT t FROM Tutor t WHERE t.personalEmail = :personalEmail"),
    @NamedQuery(name = "Tutor.findByInstitutionalEmail", query = "SELECT t FROM Tutor t WHERE t.institutionalEmail = :institutionalEmail"),
    @NamedQuery(name = "Tutor.findByCellNumber", query = "SELECT t FROM Tutor t WHERE t.cellNumber = :cellNumber"),
    @NamedQuery(name = "Tutor.findByTypeContract", query = "SELECT t FROM Tutor t WHERE t.typeContract = :typeContract"),
    @NamedQuery(name = "Tutor.findByStreetAddress", query = "SELECT t FROM Tutor t WHERE t.streetAddress = :streetAddress"),
    @NamedQuery(name = "Tutor.findByState", query = "SELECT t FROM Tutor t WHERE t.state = :state")})
public class Tutor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_number")
    private Long documentNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "names")
    private String names;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "surnames")
    private String surnames;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "personal_email")
    private String personalEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "institutional_email")
    private String institutionalEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cell_number")
    private long cellNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_contract")
    private int typeContract;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "street_address")
    private String streetAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private Collection<Module> moduleCollection;

    public Tutor() {
    }

    public Tutor(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Tutor(Long documentNumber, String username, String names, String surnames, String personalEmail, String institutionalEmail, long cellNumber, int typeContract, String streetAddress, int state) {
        this.documentNumber = documentNumber;
        this.username = username;
        this.names = names;
        this.surnames = surnames;
        this.personalEmail = personalEmail;
        this.institutionalEmail = institutionalEmail;
        this.cellNumber = cellNumber;
        this.typeContract = typeContract;
        this.streetAddress = streetAddress;
        this.state = state;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(int typeContract) {
        this.typeContract = typeContract;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        hash += (documentNumber != null ? documentNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.documentNumber == null && other.documentNumber != null) || (this.documentNumber != null && !this.documentNumber.equals(other.documentNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.cv.data.Tutor[ documentNumber=" + documentNumber + " ]";
    }
    
}
