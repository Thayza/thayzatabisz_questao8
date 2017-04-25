package ces29_P1.Questao8;

public class Livro {
	
	private String titulo, autor;
	private int numCatalogo;
	private boolean disponivel = true;
	private boolean extraviado = false;
	private String usuario;
	
	public Livro(String titulo, String autor, int id){
		this.titulo = titulo;
		this.autor = autor;
		this.numCatalogo = id;
		this.disponivel = true;
		this.usuario = null;
	}
	
	public void registrarEmprestimo(String nome_usuario){
		if(this.disponivel){
			this.disponivel = false;
			this.usuario = nome_usuario;
		}
	}
	
	public void registrarDevolucao(){
		this.disponivel = true;
		this.usuario = null;
	}
	
	public int getNumCatalogo(){
		return this.numCatalogo;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public boolean getDisponibilidade(){
		return this.disponivel;
	}
	
	public boolean getStatusLost(){
		return this.extraviado;
	}
	
}