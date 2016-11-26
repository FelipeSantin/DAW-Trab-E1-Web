/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class PessoaDao<T> extends DAOGenerico<Pessoa> implements Serializable{
    public PessoaDao(){
        super();
        super.setClassePersistente(Pessoa.class);
        super.setOrdem("nome");
    }
}
