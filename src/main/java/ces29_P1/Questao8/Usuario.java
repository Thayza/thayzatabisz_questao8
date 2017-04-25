package ces29_P1.Questao8;

public class Usuario {
	
	private String nome;
	private boolean bloqueado;
	private int dias_bloqueado;
	
	public Usuario(String nome) {
		this.nome = nome;
		this.bloqueado = false;
		this.dias_bloqueado = 0;
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
	

}
