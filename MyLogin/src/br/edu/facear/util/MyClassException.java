package br.edu.facear.util;

public class MyClassException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensagem = " ";
	private String classe = " ";
	private String pacote = " ";
	private String metodo = " ";
	private int codigo = 0;

	public MyClassException() {
		// executando o construtor vazio da superclasse
		super();
	}

	public MyClassException(String p_str) {
		super(p_str);
	}

	public MyClassException(Throwable arg0) {
		super(arg0);
	}

	public MyClassException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public void setClasse(String pclasse) {
		this.classe = pclasse;
	}

	public String getClasse() {
		return this.classe;
	}

	public void setMensagem(String pmensagem) {
		this.mensagem = pmensagem;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setPacote(String ppacote) {
		this.pacote = ppacote;
	}

	public String getPacote() {
		return this.pacote;
	}

	public void setMetodo(String pmetodo) {
		this.metodo = pmetodo;
	}

	public String getMetodo() {
		return this.metodo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}	
