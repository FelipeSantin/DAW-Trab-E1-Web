/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CondominioDao;
import br.edu.ifsul.dao.UnidadeCondominialDao;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.UnidadeCondominial;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe
 */
@ManagedBean(name = "controleCondominio")
@SessionScoped
public class ControleCondominio implements Serializable{
    private CondominioDao<Condominio> dao;
    private Condominio objeto;
    private UnidadeCondominialDao<UnidadeCondominial> daoUnidadeCondominial;

    public ControleCondominio() {
        dao = new CondominioDao<>();
        daoUnidadeCondominial = new UnidadeCondominialDao();
    }
    
    public String listar(){
        return "/privado/condominio/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Condominio();
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
    
    public CondominioDao getDao() {
        return dao;
    }

    public void setDao(CondominioDao dao) {
        this.dao = dao;
    }

    public Condominio getObjeto() {
        return objeto;
    }

    public void setObjeto(Condominio objeto) {
        this.objeto = objeto;
    }

    public UnidadeCondominialDao<UnidadeCondominial> getDaoUnidadeCondominial() {
        return daoUnidadeCondominial;
    }

    public void setDaoUnidadeCondominial(UnidadeCondominialDao<UnidadeCondominial> daoUnidadeCondominial) {
        this.daoUnidadeCondominial = daoUnidadeCondominial;
    }
    
}
