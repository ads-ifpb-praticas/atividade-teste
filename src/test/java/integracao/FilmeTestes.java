package integracao;

import br.edu.ifpb.praticas.atividade.praticas.entidades.Estado;
import br.edu.ifpb.praticas.atividade.praticas.entidades.Filme;
import br.edu.ifpb.praticas.atividade.praticas.servicos.FilmeService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class FilmeTestes extends GenericDatabaseTestCase {
    
    private FilmeService filmeService;

    @Before
    public void setUp() {
        this.filmeService = new FilmeService();
    }
    
    @Test
    public void salvarTeste() {
        Filme filme = new Filme("A lagoa Azul", "Romance", 100, Estado.DISPONIVEL);
        filmeService.salvar(filme);
    }
    
    @Test
    public void exibeFilmeTeste() {
        filmeService.getFilmePoTitulo("A lagoa Azul");
    }
    
    @Test
    public void editarTeste() {
        Filme filme = filmeService.getFilmePoTitulo("A lagoa Azul");
        filme.setTitulo("De volta a lagoa azul");
        filmeService.editar(filme);
    }
    
    @Test
    public void listarTeste() {
        List<Filme> filmes = filmeService.listar();
    }

    @Override
    public String getDataSetFile() {
        return "src/test/java/resources/filmes.xml";
    }
}
