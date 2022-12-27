package com.tuyo.associations.onetomany.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 									// Como este campo é auto-incremento ou serial(no postgresql) nós usaremos um @GeneratedValue e AUTO em strategy.
	private long id;
	private String name; 																// Definimos a associação mas o hibernate ou JPA ainda não sabe dessa associação.
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch=FetchType.EAGER)   // Daí por isso colocar a @OneToMany anotação do JPA para fazê-los saber da associação.
	private Set<NumeroTelefone> numbers; 												// Também precisamos dizer à eles quem quer o mapeamento: NumeroTelefone que tem seu próprio mapeamento.
																						// "cliente" é quem diz que a Primary Key está no Cliete e ele próprio salva o mapeamento,
																						//  e dessa maneira mapeamos com sucesso Cliente para o NumeroTelefone.
	public long getId() {																// cascade é utilizado para realizar o efeito cascata (útil para CRUD também neste contexto
		return id;																		// ALL = é usado para vários tipos.
	}																					// fetch=FetchType.EAGER é passado no Pai e faz referência ao Lazy que está no objeto Filho.

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<NumeroTelefone> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<NumeroTelefone> numbers) {
		this.numbers = numbers;
	}

	public void addNumeroTelefone(NumeroTelefone number) { // Este método será invocado para muitos NumeroTelefone assim como nós não queremos que passe através dele, os números "numbers" serão adicionados em uma coleção em particular alí em numbers = new HashSet<>();
		if (number != null) {
			if (numbers == null) { // Se NumeroTelefone for igual a Null ele será instanciado.
				numbers = new HashSet<>(); // O fato de usarmos null, precisamos criar o HashSet (collection) toda as vezes.
			}
			number.setCustomer(this); //Passo importante que é setCustomer que permitirá que a Foreign Key faça isso não importando qualquer que seja o objeto cliente, este método será invocado.
			numbers.add(number);		// Nós estamos "settando" esse objeto no Cliene tornando a vida de nossos clientes mais fáceis pelos clientes.
		}

	}

}
