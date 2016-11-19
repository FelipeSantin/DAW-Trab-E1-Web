/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fsul.controle;

import br.edu.ifsul.dao.LocatarioDao;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe
 */
@ManagedBean(name = "controleLocatario")
@SessionScoped
public class ControleLocatario extends Pessoa implements Serializable{
    private LocatarioDao<Locatario> dao;
    private Locatario objeto;

    public ControleLocatario() {
        dao = new LocatarioDao<>();
    }
    
    public String listar(){
        return "/privado/locatario/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Locatario();
        return "formulario";
    }
    
    public String salvar(){
        boolean persistiu;
        if(objeto.getId() == null){
            persistiu = dao.persist(objeto);
        }else{
            persistiu = dao.merge(objeto);
        }
        if(persistiu){
            UtilMensagens.mensagemInformacao(dao.getMensagem());
            return "listar";
        }else{
            UtilMensagens.mensagemErro(dao.getMensagem());
            return "formulario";
        }
    }
    
    public String cancelar(){
        objeto = null;
        return "listar";
    }
    
    public String editar(int id){
        objeto = dao.localizar(id);
        return "formulario";
    }
    
    public void excluir(){
        if(dao.remove(objeto)){
            UtilMensagens.mensagemInformacao(dao.getMensagem());
        }else{
            UtilMensagens.mensagemErro(dao.getMensagem());
        }
    }
    
    public LocatarioDao getDao() {
        return dao;
    }

    public void setDao(LocatarioDao dao) {
        this.dao = dao;
    }

    public Locatario getObjeto() {
        return objeto;
    }

    public void setObjeto(Locatario objeto) {
        this.objeto = objeto;
    }
}
