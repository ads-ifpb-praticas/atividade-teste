package br.edu.ifpb.praticas.atividade.praticas.commands;

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
public class ExibirFilme implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String c = request.getParameter("c");
        FilmeService fs = new FilmeService();
        Filme filme = fs.getFilme(id);
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        request.setAttribute("filme", filme);
        if (c.equals("edit")) {
            try {
                request.getRequestDispatcher("editarFilme.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ExibirFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.getRequestDispatcher("emprestimos.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ExibirFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
