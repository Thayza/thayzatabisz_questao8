package ces29_P1.Questao8;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca{

	private ArrayList<Usuario> lista_usuarios = new ArrayList<Usuario>();
	private ArrayList<Livro> lista_livros = new ArrayList<Livro>();
	private String nome_biblioteca;

	public Biblioteca(String nome) {
		this.nome_biblioteca = nome;
	}
	
	public void registrarEmprestimo(String nome, int id){
		Usuario usuario = procurarUsuario(nome);
		Livro livro = procurarLivroPorId(id);
		if(usuario != null){
			if(livro != null)
				livro.registrarEmprestimo(usuario.getName());
			else
				System.out.println("Biblioteca não possui este livro\n");
		}
		else 
			System.out.println("Usuario nao cadastrado\n");
	}
	
	public void registrarDevolucao(int id){
		Livro livro = procurarLivroPorId(id);
		if(livro != null)
			livro.registrarDevolucao();
		else
			System.out.println("Biblioteca não possui este livro\n");
	}
	
	public void inserirLivro(String titulo, String autor, int id){
		lista_livros.add(new Livro(titulo, autor, id));
	}
	
	public void inserirUsuario(String nome){
		if(procurarUsuario(nome) == null)
			lista_usuarios.add(new Usuario(nome));
		else
			System.out.println("Usuario já cadastrado\n");
	}
	
	public Usuario procurarUsuario(String nome) {
		for(int i = 0 ; i< lista_usuarios.size() ; i++)
            if(this.lista_usuarios.get(i).getName() == nome)
            	return lista_usuarios.get(i);
		return null;
	}
	
	public Livro procurarLivroPorNome(String titulo) {
		for(int i = 0 ; i< lista_livros.size() ; i++)
            if(this.lista_livros.get(i).getTitulo() == titulo)
            	return lista_livros.get(i);
		return null;
	}
	
	public void removerLivro(int id) {
		for(int i = 0 ; i< lista_livros.size() ; i++)
            if(this.lista_livros.get(i).getNumCatalogo() == id)
            	lista_livros.remove(i);
	}	
	
	public Livro procurarLivroPorId(int id) {
		for(int i = 0 ; i< lista_livros.size() ; i++)
            if(this.lista_livros.get(i).getNumCatalogo() == id)
            	return lista_livros.get(i);
		return null;
	}
	
	public boolean existeLivro(String titulo) {
		for(int i = 0 ; i< lista_livros.size() ; i++)
            if(this.lista_livros.get(i).getTitulo().equals(titulo))
            	return true;
		return false;
	}
	
	public boolean estaCadastrado(String nome) {
		for(int i = 0 ; i< lista_usuarios.size() ; i++)
            if(this.lista_usuarios.get(i).getName() == nome)
            	return true;
		return false;
	}

	public void removerUsuario(Usuario usuario){
		if(estaCadastrado(usuario.getName()))
			lista_usuarios.remove(usuario);
		else
			System.out.println("Usuario não existe\n");
	}
	
	public void bloquearUsuario(Usuario usuario, int dias){
		usuario.setStatus(true);
		usuario.setDias(dias);
	}

	public String getStatusLivro(Livro livro) {
		if(livro.getStatusLost()){
			return "Extraviado";
		}
		else{
			if(livro.getDisponibilidade())
				return "Disponivel";
			else
				return "Emprestado";
		}
	}
}