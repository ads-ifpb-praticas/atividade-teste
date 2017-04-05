
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import br.edu.ifpb.praticas.atividade.praticas.exception.EmprestimoException;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface EmprestimoDao {
    
    public boolean salvar(Emprestimo emprestimo) throws EmprestimoException;
    public boolean editar(Emprestimo emprestimo) throws EmprestimoException;
    public boolean excluir(int id) throws EmprestimoException;
    public List<Emprestimo> listar() throws EmprestimoException;
    public Emprestimo getEmprestimo(int id) throws EmprestimoException;
}
