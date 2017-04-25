package ces29_P1.Questao8;

import java.util.UUID;

public class Usuario {
	
	private String nome;
	private boolean bloqueado;
	private int dias_bloqueado;
	private UUID id;
	
	public Usuario(String nome) {
		this.nome = nome;
		this.bloqueado = false;
		this.dias_bloqueado = 0;
		this.id = UUID.randomUUID();
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
	
	public UUID getId(){
		return this.id;
	}
}
