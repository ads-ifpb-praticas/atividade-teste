package br.edu.ifpb.praticas.atividade.praticas.servicos;

import br.edu.ifpb.praticas.atividade.praticas.dao.EmprestimoDao;
import br.edu.ifpb.praticas.atividade.praticas.dao.EmprestimoDaoBD;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class EmprestimoService {

    private EmprestimoDao dao;

    public EmprestimoService() {
        this.dao = new EmprestimoDaoBD();
    }

    public boolean salvar(Emprestimo emprestimo) {
        return dao.salvar(emprestimo);
    }

    public boolean editar(Emprestimo emprestimo) {
        return dao.editar(emprestimo);
    }

    public boolean remover(int id) {
        return dao.excluir(id);
    }

    public List<Emprestimo> listar() {
        return dao.listar();
    }

    public Emprestimo getFilme(int id) {
        return dao.getEmprestimo(id);
    }
}
