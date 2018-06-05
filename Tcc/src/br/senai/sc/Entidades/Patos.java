/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.Entidades;

import br.senai.sc.DAO.PatosDAO;
import br.senai.sc.DAO.UsuariopatosDAO;
import br.senai.sc.DAO.UsuariosDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bruno_verbinnen
 */
@Entity
@Table(name = "patos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patos.findAll", query = "SELECT p FROM Patos p"),
    @NamedQuery(name = "Patos.findByIdpato", query = "SELECT p FROM Patos p WHERE p.idpato = :idpato"),
    @NamedQuery(name = "Patos.findByNome", query = "SELECT p FROM Patos p WHERE p.nome = :nome"),
    @NamedQuery(name = "Patos.findByDescr", query = "SELECT p FROM Patos p WHERE p.descr = :descr"),
    @NamedQuery(name = "Patos.findByPreco", query = "SELECT p FROM Patos p WHERE p.preco = :preco")})
public class Patos implements Serializable {
    @Column(name = "foto")
    private String foto;
    @Column(name = "gif")
    private String gif;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpato")
    private Integer idpato;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descr")
    private String descr;
    @Column(name = "preco")
    private Integer preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patoID")
    private Collection<Usuariopatos> usuariopatosCollection;
    
    public Patos() {
    }

    public Patos(Integer idpato) {
        this.idpato = idpato;
    }

    public Integer getIdpato() {
        return idpato;
    }

    public void setIdpato(Integer idpato) {
        this.idpato = idpato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    @XmlTransient
    public Collection<Usuariopatos> getUsuariopatosCollection() {
        return usuariopatosCollection;
    }

    public void setUsuariopatosCollection(Collection<Usuariopatos> usuariopatosCollection) {
        this.usuariopatosCollection = usuariopatosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpato != null ? idpato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patos)) {
            return false;
        }
        Patos other = (Patos) object;
        if ((this.idpato == null && other.idpato != null) || (this.idpato != null && !this.idpato.equals(other.idpato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.senai.sc.Entidades.Patos[ idpato=" + idpato + " ]";
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }
    
    public void Comprar(int id) {
        Usuarios usu = new Usuarios();
        UsuariosDAO usuDAO = new UsuariosDAO();
        Patos pato = new Patos();
        PatosDAO patoDAO = new PatosDAO();
        Usuariopatos up = new Usuariopatos();
        UsuariopatosDAO upDAO = new UsuariopatosDAO();
        InfoUsuario IU = new InfoUsuario();
        
        
        try {
            usu = usuDAO.getUsuarioPorID(IU.getIdusu());
            pato = patoDAO.getPatoPorID(id);
        } catch (Exception ex) {
            Logger.getLogger(Patos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(usu.getMoedas()>=pato.getPreco()){
            usu.setMoedas(usu.getMoedas()-pato.getPreco());
            up.setPatoID(pato);
            up.setUsuarioID(usu);
            try {
                if(upDAO.AcharPato(up)!=-1){
                    up.setUso(false);
                }else{
                    up.setUso(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(Patos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                usuDAO.alterar(usu);
                upDAO.cadastrar(up);
                JOptionPane.showMessageDialog(null, "Comprado com Sucesso!");
            } catch (Exception ex) {
                Logger.getLogger(Patos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não há Moedas Suficientes para Comprar esse Personagem!");
        }
        
        
    }

    public void Escolher(int id) {
        Usuarios usu = new Usuarios();
        UsuariosDAO usuDAO = new UsuariosDAO();
        Patos pato = new Patos();
        PatosDAO patoDAO = new PatosDAO();
        Usuariopatos up = new Usuariopatos();
        UsuariopatosDAO upDAO = new UsuariopatosDAO();
        InfoUsuario IU = new InfoUsuario();
        
        try {
            usu.setIdusuario(IU.getIdusu());
            up.setUsuarioID(usu);
            pato.setIdpato(upDAO.AcharPato(up));
            up.setPatoID(pato);
            int idup = upDAO.AcharUsuPato(up);
            up = upDAO.getUsuariopatosPorID(idup);
            up.setUso(false);
            upDAO.alterar(up);
            pato.setIdpato(id);
            up.setPatoID(pato);
            idup = upDAO.AcharUsuPato(up);
            up = upDAO.getUsuariopatosPorID(idup);
            up.setUso(true);
            upDAO.alterar(up);
            JOptionPane.showMessageDialog(null, "Escolhido com Sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(Usuariopatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
