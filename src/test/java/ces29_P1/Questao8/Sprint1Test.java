package ces29_P1.Questao8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Sprint1Test {

	Biblioteca  biblioteca;
	Usuario usuario;
	
	@Before
	public void initialize(){
	    biblioteca = new Biblioteca("BiblITA");
	}

	@Test
	public void adicionarUsuarioNaoCadastrado() {
		assertFalse(biblioteca.estaCadastrado("Thayza"));
		biblioteca.inserirUsuario("Thayza");
		assertTrue(biblioteca.estaCadastrado("Thayza"));
	}

	
	@Test
	public void removerUsuarioCadastrado(){
		biblioteca.inserirUsuario("Thayza");
		usuario = biblioteca.procurarUsuario("Thayza");
		biblioteca.removerUsuario(usuario);
		assertFalse(biblioteca.estaCadastrado("Thayza"));
	}

	
	@Test
	public void bloquearUsuario() {
		biblioteca.inserirUsuario("Thayza");
		usuario = biblioteca.procurarUsuario("Thayza");
		biblioteca.bloquearUsuario(usuario, 3);
		assertTrue(usuario.getStatus());
	}
	

}
