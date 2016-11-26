/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Felipe
 */
@FacesConverter(value = "ConverterPessoa")
public class ConverterPessoa implements Serializable, Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equalsIgnoreCase("Selecione um registro")){
            return null;
        }else{
            try{
                return EntityManagerUtil.getEntityManager().find(Pessoa.class, Integer.parseInt(string));
            }catch(Exception e){
                return null;
            }
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null){
            return null;
        }
        return ((Pessoa) o).getId().toString();
    }
    
}
