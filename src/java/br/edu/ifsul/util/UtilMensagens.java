/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe
 */
public class UtilMensagens {
    public static void mensagemInformacao(String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,"");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    public static void mensagemErro(String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,"");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
    public static void mensagemAviso(String msg){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN,msg,"");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
}
