package one.alura.hotel.br.Modelo;

import java.sql.Date;

public class Reserva {
	
	private Integer id;
	private String dataEntrada;
	private String dataSaida;
	private String valor;
	private String FormaPagamento;
	
	public Reserva(String dataEntrada, String dataSaida, String valor, String FormaPagamento) {
		super();
		this.dataEntrada = dataEntrada; //ele irá receber a data de entrada do usuário
		this.dataSaida = dataSaida;
		this.FormaPagamento = FormaPagamento;
		this.valor = valor;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return FormaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		FormaPagamento = formaPagamento;
	}

		
}

	