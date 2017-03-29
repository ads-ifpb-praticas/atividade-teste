
package br.edu.ifpb.praticas.atividade.praticas.dao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface EmprestimoDao {
    
    public void salvar(Emprestimo emprestimo);
    public void editar(Emprestimo emprestimo);
    public void excluir(int id);
    public List<Emprestimo> salvar();
    public Emprestimo getFilme();
}
