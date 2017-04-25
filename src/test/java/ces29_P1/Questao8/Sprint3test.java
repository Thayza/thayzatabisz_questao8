package ces29_P1.Questao8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Sprint3test {
	Biblioteca  biblioteca;
	Usuario usuario;
	int id;
	
	@Before
	public void initialize(){
	    biblioteca = new Biblioteca("BiblITA");
	    biblioteca.inserirUsuario("Thayza");
	    biblioteca.inserirUsuario("Joao");
		biblioteca.inserirLivro("L1", "A1", 1);
	}
	
	@Test
	public void usuarioLogado(){
		usuario = biblioteca.procurarUsuario("Thayza");
		usuario.login(biblioteca);
		assertTrue(usuario.getStatusAcesso());
	}
	
	@Test
	public void usuarioLogadoDeslogado(){
		usuario = biblioteca.procurarUsuario("Thayza");
		usuario.login(biblioteca);
		usuario.logout(biblioteca);
		assertFalse(usuario.getStatusAcesso());
	}
	
	@Test
	public void usuarioPesquisaLivroDisponivel(){
		usuario = biblioteca.procurarUsuario("Thayza");
		usuario.login(biblioteca);
		String status = usuario.pesquisarLivro(biblioteca, "L1");
		assertTrue(status.equals("Disponivel"));
	}
	
	@Test
	public void usuarioPesquisaLivroEmprestado(){
		usuario = biblioteca.procurarUsuario("Thayza");
		usuario.login(biblioteca);
		biblioteca.registrarEmprestimo("Joao", 1);
		String status = usuario.pesquisarLivro(biblioteca, "L1");
		assertTrue(status.equals("Emprestado"));
	}
	
}
