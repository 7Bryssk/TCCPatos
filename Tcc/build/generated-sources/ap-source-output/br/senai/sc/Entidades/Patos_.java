package br.senai.sc.Entidades;

import br.senai.sc.Entidades.Usuariopatos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-28T15:03:08")
@StaticMetamodel(Patos.class)
public class Patos_ { 

    public static volatile SingularAttribute<Patos, Integer> preco;
    public static volatile SingularAttribute<Patos, Integer> idpato;
    public static volatile SingularAttribute<Patos, String> nome;
    public static volatile SingularAttribute<Patos, String> foto;
    public static volatile SingularAttribute<Patos, String> descr;
    public static volatile SingularAttribute<Patos, String> gif;
    public static volatile CollectionAttribute<Patos, Usuariopatos> usuariopatosCollection;

}