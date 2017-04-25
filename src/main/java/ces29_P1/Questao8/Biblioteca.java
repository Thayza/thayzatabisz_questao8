package ces29_P1.Questao8;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca{

	private ArrayList<Usuario> lista_usuarios = new ArrayList<Usuario>();
	private String nome_biblioteca;

	public Biblioteca(String nome) {
		this.nome_biblioteca = nome;
	}
	
	public void inserirUsuario(String nome){
		if(procurarUsuario(nome) == null)
			lista_usuarios.add(new Usuario(nome));
	}
	
	public Usuario procurarUsuario(String nome) {
		for(int i = 0 ; i< lista_usuarios.size() ; i++)
            if(this.lista_usuarios.get(i).getName() == nome)
            	return lista_usuarios.get(i);
		return null;
	}
	
	public boolean estaCadastrado(String nome) {
		for(int i = 0 ; i< lista_usuarios.size() ; i++)
            if(this.lista_usuarios.get(i).getName() == nome)
            	return true;
		return false;
	}

	public void removerUsuario(Usuario usuario){
		lista_usuarios.remove(usuario);
	}
	
	public void bloquearUsuario(Usuario usuario, int dias){
		usuario.setStatus(true);
		usuario.setDias(dias);
	}
	
}