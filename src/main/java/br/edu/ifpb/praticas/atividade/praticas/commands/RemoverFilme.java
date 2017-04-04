package br.edu.ifpb.praticas.atividade.praticas.commands;

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
public class RemoverFilme implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        FilmeService fs = new FilmeService();
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);

        if (fs.remover(id)) {
            request.setAttribute("mensagem", "O filme removido com sucesso!");

            try {
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("mensagem", "O filme não pode ser removido!");
            try {
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(RemoverFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
