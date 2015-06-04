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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "message_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageModule.findAll", query = "SELECT m FROM MessageModule m"),
    @NamedQuery(name = "MessageModule.findByIdMessageModule", query = "SELECT m FROM MessageModule m WHERE m.idMessageModule = :idMessageModule")})
public class MessageModule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_message_module")
    private Integer idMessageModule;
    @JoinColumn(name = "id_message", referencedColumnName = "id_message")
    @ManyToOne(optional = false)
    private Message idMessage;
    @JoinColumn(name = "id_module", referencedColumnName = "id_module")
    @ManyToOne(optional = false)
    private Module idModule;

    public MessageModule() {
    }

    public MessageModule(Integer idMessageModule) {
        this.idMessageModule = idMessageModule;
    }

    public Integer getIdMessageModule() {
        return idMessageModule;
    }

    public void setIdMessageModule(Integer idMessageModule) {
        this.idMessageModule = idMessageModule;
    }

    public Message getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Message idMessage) {
        this.idMessage = idMessage;
    }

    public Module getIdModule() {
        return idModule;
    }

    public void setIdModule(Module idModule) {
        this.idModule = idModule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessageModule != null ? idMessageModule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageModule)) {
            return false;
        }
        MessageModule other = (MessageModule) object;
        if ((this.idMessageModule == null && other.idMessageModule != null) || (this.idMessageModule != null && !this.idMessageModule.equals(other.idMessageModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.prap.cv.data.MessageModule[ idMessageModule=" + idMessageModule + " ]";
    }
    
}
