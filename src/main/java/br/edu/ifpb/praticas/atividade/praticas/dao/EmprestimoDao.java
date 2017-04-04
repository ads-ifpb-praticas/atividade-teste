
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface EmprestimoDao {
    
    public boolean salvar(Emprestimo emprestimo);
    public boolean editar(Emprestimo emprestimo);
    public boolean excluir(int id);
    public List<Emprestimo> listar();
    public Emprestimo getEmprestimo(int id);
}
