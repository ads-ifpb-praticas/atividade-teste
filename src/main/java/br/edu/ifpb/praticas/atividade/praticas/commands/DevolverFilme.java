package br.edu.ifpb.praticas.atividade.praticas.commands;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.servicos.FilmeService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class DevolverFilme implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        FilmeService fs = new FilmeService();
        int id = Integer.parseInt(request.getParameter("id"));
        Filme filme = fs.getFilme(id);
        request.setAttribute("pagina", "filmes.jsp");
        filme.setEstado(Estado.DISPONIVEL);
        if (fs.editar(filme)) {
            try {
                request.getRequestDispatcher("editarFilme.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ExibirFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
