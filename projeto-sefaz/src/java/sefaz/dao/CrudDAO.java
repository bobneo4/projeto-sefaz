/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefaz.dao;

import java.util.List;
import sefaz.util.exception.ErroSistema;

/**
 *
 * @author RODRIGO
 */
public interface CrudDAO<E> {
    
    public void salvar(E entidade) throws ErroSistema;
    public void deletar(E entidade) throws ErroSistema;
    public List<E> consultar() throws ErroSistema;
    
}
