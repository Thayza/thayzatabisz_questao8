package ces29_P1.Questao8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.UUID;


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
	public void adicionarUsuarioCadastrado() {
		UUID id1;
		assertFalse(biblioteca.estaCadastrado("Thayza"));
		biblioteca.inserirUsuario("Thayza");
		usuario = biblioteca.procurarUsuario("Thayza");
		id1 = usuario.getId();
		assertTrue(biblioteca.estaCadastrado("Thayza"));
		biblioteca.inserirUsuario("Thayza");
		assertEquals(id1, biblioteca.procurarUsuario("Thayza").getId());
		
	}
	
	@Test
	public void removerUsuarioCadastrado(){
		biblioteca.inserirUsuario("Thayza");
		usuario = biblioteca.procurarUsuario("Thayza");
		biblioteca.removerUsuario(usuario);
		assertFalse(biblioteca.estaCadastrado("Thayza"));
	}
	
	@Test
	public void removerUsuarioNaoCadastrado(){
		assertFalse(biblioteca.estaCadastrado("Thayza"));
		biblioteca.removerUsuario(usuario);
	}
	
	@Test
	public void bloquearUsuario() {
		biblioteca.inserirUsuario("Thayza");
		usuario = biblioteca.procurarUsuario("Thayza");
		biblioteca.bloquearUsuario(usuario, 3);
		assertTrue(usuario.getStatus());
	}
	

}
