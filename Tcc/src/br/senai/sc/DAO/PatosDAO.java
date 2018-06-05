package br.senai.sc.DAO;
import br.senai.sc.Entidades.InfoUsuario;
import br.senai.sc.Entidades.Patos;
import br.senai.sc.Entidades.Usuariopatos;
import br.senai.sc.Entidades.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno_verbinnen
 */
public class PatosDAO extends BasicoDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    
    public void cadastrar(Patos pato) throws Exception{
        super.cadastrar(pato);
    }    
    public Patos getPatoPorID(int id) throws Exception{
        EntityManager em = getEntityManager();
        return em.find(Patos.class, id);
    }
    public void alterar(Patos pato) throws Exception{
        super.alterar(pato);
    }
    public void deletar(int id) throws Exception{
        super.excluir(Patos.class, id);
    }

    public TableModel getTabelaNComprados() {
        InfoUsuario IU = new InfoUsuario();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Cod");
        modelo.addColumn("Nome");
        modelo.addColumn("descrição ");
        modelo.addColumn("Preço");
       
        List<Patos> lista;

        EntityManager em = getEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
//        em.getTransaction().begin();    

//        Query query = em.createQuery("select p from Patos p where p.usuariopatosCollection");
        
//        Query query = em.createQuery("select u from Usuarios u where u.idusuario= :usuarioid");
//        query.setParameter("usuarioid", IU.getIdusu());
        
        Query query = em.createQuery("select u from Usuarios u where u.idusuario = :idusuario");
        query.setParameter("idusuario", IU.getIdusu());
        Usuarios user = (Usuarios)query.getSingleResult();
//        lista = query.getResultList();
        Query query2 = em.createQuery("select p from Patos p");
        lista = query2.getResultList();
        for(Usuariopatos usupatos : user.getUsuariopatosCollection()){
            for(Patos pato : lista){
                if(usupatos.getPatoID().getIdpato() == pato.getIdpato()){
                    lista.remove(pato);
                    break;
                }
            }
        }
        
        for (Patos personagem : lista) {
            
            Object[] linha = {
                personagem.getIdpato(),
                personagem.getNome(),
                personagem.getDescr(),
                personagem.getPreco()
            };
    
            
            modelo.addRow(linha);

        }
        return modelo;
    }

    
}
