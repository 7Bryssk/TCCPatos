/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno_verbinnen
 */
@Entity
@Table(name = "usuariopatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariopatos.porusuario", query = "select p from Usuariopatos p where p.usuarioID= :usuarioid"),
    @NamedQuery(name = "Usuariopatos.findAll", query = "SELECT u FROM Usuariopatos u"),
    @NamedQuery(name = "Usuariopatos.findByIdusuariopato", query = "SELECT u FROM Usuariopatos u WHERE u.idusuariopato = :idusuariopato"),
    @NamedQuery(name = "Usuariopatos.findByUso", query = "SELECT u FROM Usuariopatos u WHERE u.uso = :uso")})
public class Usuariopatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idusuariopato")
    private Integer idusuariopato;
    @Column(name = "uso")
    private Boolean uso;
    @JoinColumn(name = "patoID", referencedColumnName = "idpato")
    @ManyToOne(optional = false)
    private Patos patoID;
    @JoinColumn(name = "usuarioID", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuarios usuarioID;

    public Usuariopatos() {
    }

    public Usuariopatos(Integer idusuariopato) {
        this.idusuariopato = idusuariopato;
    }

    public Integer getIdusuariopato() {
        return idusuariopato;
    }

    public void setIdusuariopato(Integer idusuariopato) {
        this.idusuariopato = idusuariopato;
    }

    public Boolean getUso() {
        return uso;
    }

    public void setUso(Boolean uso) {
        this.uso = uso;
    }

    public Patos getPatoID() {
        return patoID;
    }

    public void setPatoID(Patos patoID) {
        this.patoID = patoID;
    }

    public Usuarios getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuarios usuarioID) {
        this.usuarioID = usuarioID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariopato != null ? idusuariopato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariopatos)) {
            return false;
        }
        Usuariopatos other = (Usuariopatos) object;
        if ((this.idusuariopato == null && other.idusuariopato != null) || (this.idusuariopato != null && !this.idusuariopato.equals(other.idusuariopato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.senai.sc.Entidades.Usuariopatos[ idusuariopato=" + idusuariopato + " ]";
    }
    
}
