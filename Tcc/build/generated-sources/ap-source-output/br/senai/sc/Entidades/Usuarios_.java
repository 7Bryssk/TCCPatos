package br.senai.sc.Entidades;

import br.senai.sc.Entidades.Usuariopatos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-28T15:03:08")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Integer> pontos;
    public static volatile SingularAttribute<Usuarios, Integer> idusuario;
    public static volatile SingularAttribute<Usuarios, String> nickname;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile SingularAttribute<Usuarios, Boolean> adm;
    public static volatile SingularAttribute<Usuarios, Integer> moedas;
    public static volatile SingularAttribute<Usuarios, String> login;
    public static volatile SingularAttribute<Usuarios, String> senha;
    public static volatile CollectionAttribute<Usuarios, Usuariopatos> usuariopatosCollection;

}