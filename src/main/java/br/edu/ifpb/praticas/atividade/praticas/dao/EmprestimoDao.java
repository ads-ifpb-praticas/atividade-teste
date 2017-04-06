
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import br.edu.ifpb.praticas.atividade.praticas.exception.EmprestimoException;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface EmprestimoDao {
    
    boolean salvar(Emprestimo emprestimo) throws EmprestimoException;
    boolean editar(Emprestimo emprestimo) throws EmprestimoException;
    boolean excluir(int id) throws EmprestimoException;
    List<Emprestimo> listar() throws EmprestimoException;
    Emprestimo getEmprestimo(int id) throws EmprestimoException;
}
