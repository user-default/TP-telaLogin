package application;

// It's a fake persistence.

import java.util.ArrayList;

public class Persistence {
	
		private String name;
		private String password;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
  
		/*
		public static void main(String[] args) {
		
			ArrayList<Persistence> persistence = new ArrayList<Persistence>();
			persistence.add(new Persistence());
			System.out.println("ArrayList criado e primeiro objeto adicionado");
			
		}*/
  
public static Boolean register(ArrayList<Persistence> persistence, Persistence ps) {
	//Persistence ps1 = new Persistence();
	//ps1.setName(ps.name);
	//ps1.setPassword(ps.password);
	Boolean getResult = true;//check(persistence, ps);
	if(getResult == true)
		System.out.println("Usuário já cadastrado!");
	else {
		persistence.add(ps);
		System.out.println("Cadastro realizado com sucesso!");
	}
	ps.setName(null); ps.setPassword(null);
	System.out.println("register: objeto persistence limpo");
	return getResult;
}

/*
public static Boolean check(ArrayList<Persistence> persistence, Persistence ps) {
	Persistence ps2 = new Persistence();
	ps2.setName(ps.getName());
	ps2.setPassword(ps.getPassword());
	Boolean result = null;
	ps.setName(null); ps.setPassword(null);
	System.out.println("check: objeto persistence limpo");
	// Verifica se os dados recebidos em ps2 estão registrados no ArrayList persistence, se estiverem,
	// há um break no laço e a variável result retorna o valor true para quem chamou. Já que a variável é inicializada com false,
	// se na iteração não for achado os valores de entrada, continuará sendo falso.
	for(int i = 0; i <= persistence.size(); i++) {
		if( (persistence.get(i).getName() == ps2.getName()) && (persistence.get(i).getPassword() == ps2.getPassword()) ) {
			result = true;
			System.out.println("check -> for -> persistentece.get(i) == ps2 -> achei correspondencia.");
			break;
		}
		else {
			result = false;
			System.out.println("check -> for -> persistence.get(i) == ps2 -> Não achei correspondencia.");
		}
			
	}
	return result;
	}*/
}
