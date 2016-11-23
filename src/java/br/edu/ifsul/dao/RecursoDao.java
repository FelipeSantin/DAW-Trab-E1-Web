/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Recurso;
import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class RecursoDao<T> extends DAOGenerico<Recurso> implements Serializable{
    public RecursoDao(){
        super();
        super.setClassePersistente(Recurso.class);
        super.setOrdem("descricao");
    }
}
