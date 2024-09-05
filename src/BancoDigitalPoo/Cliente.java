package BancoDigitalPoo;

import java.util.Date;
import java.util.List;

public class Cliente {
	private String nomeCliente;

	
	private List<Double> cpf;

	public List<Double> getCpf() {
		return cpf;
	}

	public void setCpf(List<Double> cpf) {
		this.cpf = cpf;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	protected List<Double> verificaCpf(List<Double> cpf){
		if(cpf.size()>11) {
			throw  new RuntimeException("Cpf invalido");
		}else { 
			return cpf;
		}
		
	}
}
