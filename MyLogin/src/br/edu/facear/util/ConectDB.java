package br.edu.facear.util;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;

public class ConectDB {
	private String driver =  "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=My_login";
	private String usuario = "Rodrigo";
	private String senha = "123";
	public Connection con;
	public Connection getConexao() throws MyClassException {
		try {
			Connection con;
			Class.forName(driver);
		//	System.setProperty("com.microsoft.sqlserver.jdbc.SQLServerDriver", driver);
			con = DriverManager.getConnection(caminho,usuario,senha);
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			
			return con;
		} catch (Exception e) {
			MyClassException obj = new MyClassException("Erro em ClassNotFoundException");
			obj.setClasse(getClass().getName());
			obj.setMensagem(e.getMessage());
			obj.setMetodo("getConexao");
			JOptionPane.showMessageDialog(null, "Erro ao Conectar");
			throw obj;
		}
	}
}
