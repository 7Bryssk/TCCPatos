/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.DAO;

import br.senai.sc.Entidades.InfoUsuario;
import br.senai.sc.Entidades.Usuariopatos;
import br.senai.sc.Entidades.Usuarios;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.eclipse.persistence.sessions.Session;


/**
 *
 * @author bruno_verbinnen
 */
public class UsuariopatosDAO extends BasicoDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    
    public void cadastrar(Usuariopatos usuariopato) throws Exception{
        super.cadastrar(usuariopato);
    }    
    public Usuariopatos getUsuariopatosPorID(int id) throws Exception{
        EntityManager em = getEntityManager();
        return em.find(Usuariopatos.class, id);
    }
    public void alterar(Usuariopatos usuariopato) throws Exception{
        super.alterar(usuariopato);
    }
    public void deletar(int id) throws Exception{
        super.excluir(Usuariopatos.class, id);
    }
    
    public int AcharPato(Usuariopatos up) throws Exception{
        String sql="select * from usuariopatos up where up.usuarioID = '" + up.getUsuarioID().getIdusuario()+ 
                "' and up.uso = '" + 1 + "'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        if(rs.getRow()==0){
            int i = -1;
//            JOptionPane.showMessageDialog(null, i);
            return i;
        }else{
            int cod = rs.getInt("patoID");
//            JOptionPane.showMessageDialog(null, cod);
            return cod;
        }
        
    }
    
    public int ComproPato(Usuariopatos up) throws Exception{
        String sql="select * from usuariopatos up where up.usuarioID = '" + up.getUsuarioID().getIdusuario()+"'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        if(rs.getRow()==0){
            return 0;
        }else{
            return 1;
        }
        
    }
    
    public int AcharUsuPato(Usuariopatos up) throws Exception{
        String sql="select * from usuariopatos up where up.usuarioID = '" + up.getUsuarioID().getIdusuario()+"' and up.patoID = '"+ up.getPatoID().getIdpato()+"'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        int cod = rs.getInt("idusuariopato");
//        JOptionPane.showMessageDialog(null, rs.getInt("idusuariopato"));
        return cod;
    }
    
    public int AcharUsuPatonull(Usuariopatos up) throws Exception{
        String sql="select * from usuariopatos up where up.usuarioID = '" + up.getUsuarioID().getIdusuario()+"'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        int cod = rs.getInt("idusuariopato");
//        JOptionPane.showMessageDialog(null, rs.getInt("idusuariopato"));
        return cod;
    }
    
    public DefaultTableModel getTabelaComprados() throws Exception {
        InfoUsuario IU =  new InfoUsuario();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Cod");
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        modelo.addColumn("Uso");
       
        List<Usuariopatos> lista;

        EntityManager em = getEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        
//        em.getTransaction().begin();    
        
//        Query query = em.createQuery("select * from usuarios u where u.idusuario = '"+IU.getIdusu()+"'");
        Query query = em.createQuery("select u from Usuarios u where u.idusuario= :usuarioid");
        query.setParameter("usuarioid", IU.getIdusu());
        lista = new ArrayList<>();
        Usuarios user = (Usuarios)query.getSingleResult();
        for(Usuariopatos up : user.getUsuariopatosCollection()){
            lista.add(up);
        }
        
//        Query query = em.createQuery("select p from Patos p where size(p.usuariopatosCollection) = 0 ");
//        lista = query.getResultList();
        
        for (Usuariopatos up : lista) {
            
            Object[] linha = {
                up.getPatoID().getIdpato(),
                up.getPatoID().getNome(),
                up.getPatoID().getDescr(),
                up.getUso()
            };
    
            
            modelo.addRow(linha);

        }
        return modelo;
    }
    
}
