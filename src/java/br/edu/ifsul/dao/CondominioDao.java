/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Condominio;
import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class CondominioDao<T> extends DAOGenerico<Condominio> implements Serializable{
    public CondominioDao(){
        super();
        super.setClassePersistente(Condominio.class);
        super.setOrdem("nome");
    }
}
