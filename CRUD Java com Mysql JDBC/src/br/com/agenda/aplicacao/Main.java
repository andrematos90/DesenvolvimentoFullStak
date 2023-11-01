package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.models.Contato;

public class Main {
	public static void main(String[] args) {
		ContatoDAO contatoDao = new  ContatoDAO();
		
		// seta dados
		Contato contato = new Contato();
		contato.setNome("Simba");
		contato.setIdade(2);
		contato.setDataRegistro(new Date());
		
		/*contatoDao.save(contato);*/
		
		//Atualizar contato
		Contato contato2 = new Contato();
		contato2.setNome("Simba Rough Collie");
		contato2.setId(3);
		contato2.setDataRegistro(new Date());
		contato2.setId(2);
		
		//contatoDao.update(contato2);
		
		//deleta contato
		Contato contato3 = new Contato();
		contato3.setId(3);
		contatoDao.delete(contato3);
		
		//visualização de todos os registros
		for(Contato c:contatoDao.getContatos()) {
			System.out.println("Contato: " + c.getNome());
		}
	}
}
