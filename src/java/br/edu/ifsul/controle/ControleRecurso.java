/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.RecursoDao;
import br.edu.ifsul.modelo.Recurso;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe
 */
@ManagedBean(name = "controleRecurso")
@SessionScoped
public class ControleRecurso implements Serializable{
    private RecursoDao<Recurso> dao;
    private Recurso objeto;

    public ControleRecurso() {
        dao = new RecursoDao<>();
    }
    
    public String listar(){
        return "/privado/recurso/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Recurso();
    }
    
    public void salvar(){
        boolean persistiu;
        if(objeto.getId() == null){
            persistiu = dao.persist(objeto);
        }else{
            persistiu = dao.merge(objeto);
        }
        if(persistiu){
            UtilMensagens.mensagemInformacao(dao.getMensagem());
        }else{
            UtilMensagens.mensagemErro(dao.getMensagem());
        }
    }
    
    public void editar(int id){
        objeto = dao.localizar(id);
    }
    
    public void excluir(){
        if(dao.remove(objeto)){
            UtilMensagens.mensagemInformacao(dao.getMensagem());
        }else{
            UtilMensagens.mensagemErro(dao.getMensagem());
        }
    }
    
    public RecursoDao getDao() {
        return dao;
    }

    public void setDao(RecursoDao dao) {
        this.dao = dao;
    }

    public Recurso getObjeto() {
        return objeto;
    }

    public void setObjeto(Recurso objeto) {
        this.objeto = objeto;
    }
}
