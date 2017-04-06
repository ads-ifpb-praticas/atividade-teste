
package br.edu.ifpb.praticas.atividade.praticas.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public interface Command {
    
    void execute(HttpServletRequest request, HttpServletResponse response);
}
