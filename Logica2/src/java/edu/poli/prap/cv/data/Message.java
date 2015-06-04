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
 * @author usuario
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByIdMessage", query = "SELECT m FROM Message m WHERE m.idMessage = :idMessage"),
    @NamedQuery(name = "Message.findBySubject", query = "SELECT m FROM Message m WHERE m.subject = :subject"),
    @NamedQuery(name = "Message.findByMessage", query = "SELECT m FROM Message m WHERE m.message = :message"),
    @NamedQuery(name = "Message.findByShippingDays", query = "SELECT m FROM Message m WHERE m.shippingDays = :shippingDays"),
    @NamedQuery(name = "Message.findByBefore", query = "SELECT m FROM Message m WHERE m.before = :before"),
    @NamedQuery(name = "Message.findByState", query = "SELECT m FROM Message m WHERE m.state = :state")})
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_message")
    private Integer idMessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_days")
    private int shippingDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "before")
    private boolean before;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessage")
    private Collection<MessageModule> messageModuleCollection;

    public Message() {
    }

    public Message(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Message(Integer idMessage, String subject, String message, int shippingDays, boolean before, int state) {
        this.idMessage = idMessage;
        this.subject = subject;
        this.message = message;
        this.shippingDays = shippingDays;
        this.before = before;
        this.state = state;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getShippingDays() {
        return shippingDays;
    }

    public void setShippingDays(int shippingDays) {
        this.shippingDays = shippingDays;
    }

    public boolean getBefore() {
        return before;
    }

    public void setBefore(boolean before) {
        this.before = before;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<MessageModule> getMessageModuleCollection() {
        return messageModuleCollection;
    }

    public void setMessageModuleCollection(Collection<MessageModule> messageModuleCollection) {
        this.messageModuleCollection = messageModuleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.cv.data.Message[ idMessage=" + idMessage + " ]";
    }
    
}
