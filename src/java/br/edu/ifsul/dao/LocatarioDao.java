/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Locatario;
import java.io.Serializable;

/**
 *
 * @author Felipe
 */
public class LocatarioDao<T> extends DAOGenerico<Locatario> implements Serializable{
    public LocatarioDao(){
        super();
        super.setClassePersistente(Locatario.class);
    }
}
