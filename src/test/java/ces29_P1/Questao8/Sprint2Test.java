package ces29_P1.Questao8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sprint2Test {
	
	Biblioteca  biblioteca;
	Usuario usuario;
	int id;
	Livro livro1, livro2;
	
	@Before
	public void initialize(){
	    biblioteca = new Biblioteca("BiblITA");
	    biblioteca.inserirUsuario("Thayza");
	}
	
	@Test
	public void adicionarLivroNaoCadastrado(){
		biblioteca.inserirLivro("L1", "A1", 1);
		assertTrue(biblioteca.existeLivro("L1"));
	}
	
	@Test
	public void registrarEmprestimo(){
		biblioteca.inserirLivro("L1", "A1",1);
		livro1 = biblioteca.procurarLivroPorNome("L1");
		id = livro1.getNumCatalogo();
		biblioteca.registrarEmprestimo("Thayza", id);
		assertFalse(livro1.getDisponibilidade());
	}

	@Test
	public void registrarDevolucao() {
		biblioteca.inserirLivro("L1", "A1", 1);
		livro1 = biblioteca.procurarLivroPorNome("L1");
		id = livro1.getNumCatalogo();
		biblioteca.registrarDevolucao(id);
		assertTrue(livro1.getDisponibilidade());
	}

}
