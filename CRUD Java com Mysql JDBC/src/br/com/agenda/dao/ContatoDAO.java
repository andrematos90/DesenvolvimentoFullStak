package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.models.Contato;

public class ContatoDAO {
	
	
	//método para salvar
	public void save(Contato contato) {
		String sql = "INSERT INTO contatos(nome, idade, dataRegistro) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexao com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//prepareStament para executar query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//adiciona valores esperados pela query
			pstm.setString(1, contato.getNome());	
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataRegistro().getTime()));
			
			//executa query
			pstm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//fecha as conexoes
			try {
				if(pstm!= null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	//método para listar contatos
	public List<Contato>getContatos(){
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//classe que vai recuperar banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()){
				Contato contato = new Contato();
				
				//recuperar id
				contato.setId(rset.getInt("id"));
				//recuperar o nome
				contato.setNome(rset.getString("nome"));
				//recuperar idade
				contato.setIdade(rset.getInt("idade"));
				//recuperar data de registro
				contato.setDataRegistro(rset.getDate("dataRegistro"));
				
				contatos.add(contato);
			}
		}catch(Exception e) {
			e.printStackTrace();
			}finally {
				try {
					if(rset != null) {
						rset.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		return contatos;
	}
	
	
	
	//método para atualizar contatos
	public void update(Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataRegistro = ?" + "WHERE id = ? ";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			//criar conexao 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criar classe para executar query
			pstm = conn.prepareStatement(sql);
			
			//adiciona valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataRegistro().getTime()));
			
			//id do registro que deseja atualizar
			pstm.setInt(4, contato.getId());
			
			//executa query
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//método para atualizar contatos
		public void delete(Contato contato) {
			
			String sql = "DELETE from contatos WHERE id = ?";
			Connection conn = null;
			PreparedStatement pstm = null;
			
			
			try {
				//criar conexao 
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//criar classe para executar query
				pstm = conn.prepareStatement(sql);
				
				//id que sera excluido
				pstm.setInt(1, contato.getId());
				
				//executa query
				pstm.execute();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
}
	
