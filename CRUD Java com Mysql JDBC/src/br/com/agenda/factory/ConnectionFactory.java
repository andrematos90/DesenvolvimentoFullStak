package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//usuario mysql
	private static final String USERNAME = "root";
	
	//senha do usuario
	private static final String PASSWORD = "1990";
	
	//url de conexao com a base de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	//conexao com o banco de dados
	
	public static Connection createConnectionToMySQL() throws Exception  {
		
		//faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		//cria conexao com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		//Recuperar conexao com o banco de dados
		
		Connection con = createConnectionToMySQL();
				
	    //testa a conexao
		if(con != null) {
			System.out.println("Conexão estabelecida!");
			con.close();
		}
	}
	
}
