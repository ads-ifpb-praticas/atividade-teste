package br.edu.ifpb.praticas.atividade.praticas.servicos;

import br.edu.ifpb.praticas.atividade.praticas.dao.EmprestimoDao;
import br.edu.ifpb.praticas.atividade.praticas.dao.EmprestimoDaoBD;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import br.edu.ifpb.praticas.atividade.praticas.validacao.ValidadorEmprestimo;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class EmprestimoService {

    private EmprestimoDao dao;
    private ValidadorEmprestimo ve;

    public EmprestimoService() {
        this.dao = new EmprestimoDaoBD();
        this.ve = new ValidadorEmprestimo();
    }

    public boolean salvar(Emprestimo emprestimo) {
        if (ve.validar(emprestimo)) {
            return dao.salvar(emprestimo);
        }
        return false;
    }

    public boolean editar(Emprestimo emprestimo) {
        if (ve.validar(emprestimo)) {
            return dao.editar(emprestimo);
        }
        return false;
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
