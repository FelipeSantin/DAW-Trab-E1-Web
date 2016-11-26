/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PessoaDao;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe
 */
@ManagedBean(name = "controlePessoa")
@SessionScoped
public class ControlePessoa implements Serializable{
    private PessoaDao<Pessoa> dao;
    private Pessoa objeto;

    public ControlePessoa() {
        dao = new PessoaDao<>();
    }
    
    public String listar(){
        return "/privado/pessoa/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Pessoa();
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
    
    public PessoaDao getDao() {
        return dao;
    }

    public void setDao(PessoaDao dao) {
        this.dao = dao;
    }

    public Pessoa getObjeto() {
        return objeto;
    }

    public void setObjeto(Pessoa objeto) {
        this.objeto = objeto;
    }
}
