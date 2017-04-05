package br.edu.ifpb.praticas.atividade.praticas.servicos;

import br.edu.ifpb.praticas.atividade.praticas.dao.FilmeDao;
import br.edu.ifpb.praticas.atividade.praticas.dao.FilmeDaoBD;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.validacao.ValidadorFilme;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class FilmeService {

    private FilmeDao dao;
    private ValidadorFilme vf;

    public FilmeService() {
        this.dao = new FilmeDaoBD();
        this.vf = new ValidadorFilme();
    }

    public boolean salvar(Filme filme) {
        if (vf.validar(filme)) {
            return dao.salvar(filme);
        }
        return false;
    }

    public boolean editar(Filme filme) {
        if (vf.validar(filme)) {
            return dao.editar(filme);
        }
        return false;
    }

    public boolean remover(int id) {
        return dao.excluir(id);
    }

    public List<Filme> listar() {
        return dao.listar();
    }

    public Filme getFilme(int id) {
        return dao.getFilme(id);
    }
    
    public Filme getFilmePoTitulo(String titulo) {
        return dao.getFilmePorTitulo(titulo);
    }

}
