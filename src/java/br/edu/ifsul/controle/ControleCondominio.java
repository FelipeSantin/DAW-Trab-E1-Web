/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CondominioDao;
import br.edu.ifsul.dao.PessoaDao;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
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
    private PessoaDao<Pessoa> pessoaDao;
    private UnidadeCondominial unidadeCondominial;
    private Boolean novoItem;

    public ControleCondominio() {
        dao = new CondominioDao<>();
        pessoaDao = new PessoaDao();
    }
    
    public void novoItem(){
        unidadeCondominial = new UnidadeCondominial();
        novoItem = true;
    }
    
    public void alterarItem(int index){
        unidadeCondominial = objeto.getUnidadesCond().get(index);
        novoItem = false;
    }

    public void removerItem(int index){
        objeto.removerUnidadesCond(index);
        UtilMensagens.mensagemInformacao("Item removido com sucesso.");
    }

    public void salvarItem(){
        if(novoItem){
            objeto.adicionarUnidadesCond(unidadeCondominial);
        }
        UtilMensagens.mensagemInformacao("Operacao executada com sucesso.");
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

    public UnidadeCondominial getUnidadeCondominial() {
        return unidadeCondominial;
    }

    public void setUnidadeCondominial(UnidadeCondominial unidadeCondominial) {
        this.unidadeCondominial = unidadeCondominial;
    }

    public Boolean getNovoItem() {
        return novoItem;
    }

    public void setNovoItem(Boolean novoItem) {
        this.novoItem = novoItem;
    }

    public PessoaDao<Pessoa> getPessoaDao() {
        return pessoaDao;
    }

    public void setPessoaDao(PessoaDao<Pessoa> pessoaDao) {
        this.pessoaDao = pessoaDao;
    }
    
}
