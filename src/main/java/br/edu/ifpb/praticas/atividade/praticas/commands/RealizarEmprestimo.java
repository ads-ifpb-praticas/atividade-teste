package br.edu.ifpb.praticas.atividade.praticas.commands;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Emprestimo;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.servicos.EmprestimoService;
import br.edu.ifpb.praticas.atividade.praticas.servicos.FilmeService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class RealizarEmprestimo implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pagina", "emprestimos.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        LocalDate data = LocalDate.parse(request.getParameter("data"));
        FilmeService fs = new FilmeService();
        Filme filme = fs.getFilme(id);
        filme.setEstado(Estado.EMPRESTADO);
        if (fs.editar(filme)) {
            Emprestimo emprestimo = new Emprestimo(filme, LocalDate.now(), data);
            EmprestimoService es = new EmprestimoService();
            if (es.salvar(emprestimo)) {
                request.setAttribute("mensagem", "Emprestimo realizado com sucesso!");

                try {
                    request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.setAttribute("mensagem", "Erro ao realizar emprestimo!");
                try {
                    request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(RealizarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
