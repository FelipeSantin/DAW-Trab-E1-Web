/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.UnidadeCondominial;
import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class UnidadeCondominialDao<T> extends DAOGenerico<UnidadeCondominial> implements Serializable{
    public UnidadeCondominialDao(){
        super();
        super.setClassePersistente(UnidadeCondominial.class);
        super.setOrdem("nome");
    }
}
