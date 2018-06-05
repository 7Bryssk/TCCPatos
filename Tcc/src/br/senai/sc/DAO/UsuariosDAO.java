/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senai.sc.DAO;

import br.senai.sc.Entidades.InfoUsuario;
import br.senai.sc.Entidades.Usuarios;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno_verbinnen
 */
public class UsuariosDAO extends BasicoDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    
    public void cadastrar(Usuarios usuario) throws Exception{
        super.cadastrar(usuario);
    }    
    public Usuarios getUsuarioPorID(int id) throws Exception{
        EntityManager em = getEntityManager();
        return em.find(Usuarios.class, id);
    }
    public void alterar(Usuarios usuarios) throws Exception{
        super.alterar(usuarios);
    }
    public void deletar(int id) throws Exception{
        super.excluir(Usuarios.class, id);
    }
    
    public DefaultTableModel getMd10() throws Exception{
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NickName");
        modelo.addColumn("Pontuação");
        
        List<Usuarios> lista = null;
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        lista = em.createNamedQuery("Usuarios.find10").setMaxResults(10).getResultList();
        
        for(Usuarios usu : lista){
            Object [] linha = { usu.getNickname(),
                                usu.getPontos()
                              };
                modelo.addRow(linha);
            }
        return modelo;
    }
    
    
    
    
    
    public int ChecarLogin(Usuarios usu) throws Exception{
        InfoUsuario inf = new InfoUsuario();
        
        String sql="select * from Usuarios u where u.login = '" + usu.getLogin() + 
                "' and u.senha = '" + usu.getSenha() + "'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        
        if(rs.getRow() == 0)        
            return 0;
        else{ 
            
            inf.setAdm(rs.getBoolean("adm"));
            inf.setIdusu(rs.getInt("idusuario"));
            
            return 1;
        }
    }
    
    public int validarLogin(Usuarios usu) throws Exception{
        String sql="select * from Usuarios u where u.login = '" + usu.getLogin() + "'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        
        if(rs.getRow() == 0)        
            return 0;
        else{            
            return 1;
        }
    }
    
    public int validarLoginregistrado(Usuarios usu) throws Exception{
        String sql="select * from Usuarios u where u.login = '" + usu.getLogin() + "' and u.Idusuario <> '"+ usu.getIdusuario() +"'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        
        if(rs.getRow() == 0)        
            return 0;
        else{            
            return 1;
        }
    }
    
    public int validarNick(Usuarios usu) throws Exception{
        String sql="select * from Usuarios u where u.nickname = '" + usu.getNickname()+ "'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        
        if(rs.getRow() == 0)        
            return 0;
        else{            
            return 1;
        }
    }
    
    public int validarNickregistrado(Usuarios usu) throws Exception{
        String sql="select * from Usuarios u where u.nickname = '" + usu.getNickname()+ "' and u.Idusuario <> '"+ usu.getIdusuario() +"'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        
        if(rs.getRow() == 0)        
            return 0;
        else{            
            return 1;
        }
    }
    
    public int validarEmail(Usuarios usu) throws Exception{
        String sql="select * from Usuarios u where u.email = '" + usu.getEmail()+ "' and u.Idusuario <> '"+ usu.getIdusuario() +"'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        
        if(rs.getRow() == 0)        
            return 0;
        else{
            
            return 1;
        }
    }
    
    public int validarEmailregistrado(Usuarios usu) throws Exception{
        String sql="select * from Usuarios u where u.email = '" + usu.getEmail()+ "' and u.Idusuario <> '"+ usu.getIdusuario() +"'";
        
        java.sql.PreparedStatement sqlPrep = Conexao.getConnection().prepareStatement(sql);
        ResultSet rs = sqlPrep.executeQuery();
        
        rs.first();
        
        if(rs.getRow() == 0)        
            return 0;
        else{
            
            return 1;
        }
    }
    
    
}
