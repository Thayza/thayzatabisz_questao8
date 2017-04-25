package ces29_P1.Questao8;

import java.util.UUID;

public class Usuario {
	
	private String nome;
	private boolean bloqueado;
	private int dias_bloqueado;
	private boolean status_acesso;
	
	public Usuario(String nome) {
		this.nome = nome;
		this.bloqueado = false;
		this.dias_bloqueado = 0;
		this.status_acesso = false;
	}

	public void setStatus(boolean novo_status){
		this.bloqueado = novo_status;
	}
	
	public void setDias(int dias){
		this.dias_bloqueado = dias;
	}
	
	public String getName(){
		return this.nome;
	}
	
	public boolean getStatus(){
		return this.bloqueado;
	}
	
	public boolean getStatusAcesso(){
		return this.status_acesso;
	}
	
	public void login(Biblioteca biblioteca){
		if(!status_acesso && biblioteca!=null){
			this.status_acesso = true;
		}	
	}
	
	public void logout(Biblioteca biblioteca){
		if(status_acesso){
			this.status_acesso = false;
		}	
	}
	 
	public String pesquisarLivro(Biblioteca biblioteca, String titulo){
		String status_livro = null;
		if(status_acesso){
			if(biblioteca.existeLivro(titulo)){
				Livro livro = biblioteca.procurarLivroPorNome(titulo);
				status_livro = biblioteca.getStatusLivro(livro);
			}
		}
		return status_livro;
	}
	
}
