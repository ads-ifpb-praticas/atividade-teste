
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
public class EditarFilme implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Filme filme = dadosFilme(request);
        FilmeService fs = new FilmeService();
        request.setAttribute("pagina", "filmes.jsp");

        if (fs.editar(filme)) {
            request.setAttribute("mensagem", "O filme " + filme.getTitulo() + " foi atualizado com sucesso!");

            try {
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("mensagem", "Erro ao atualizar filme!");
            try {
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(EditarFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Filme dadosFilme(HttpServletRequest request) {
        Filme filme = new Filme();
        
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            filme.setId(id);
        }

        if (request.getParameter("titulo") != null) {
            String nome = request.getParameter("titulo");
            filme.setTitulo(nome);
        }

        if (request.getParameter("genero") != null) {
            String genero = request.getParameter("genero");
            filme.setGenero(genero);
        }

        if (request.getParameter("duracao") != null) {
            int duracao = Integer.valueOf(request.getParameter("duracao"));
            filme.setDuracao(duracao);
        }
        
        if (request.getParameter("estado") != null) {
            
            Estado estado = Estado.valueOf(request.getParameter("estado"));
            filme.setEstado(estado);
        }

        return filme;
    }
    
}
