package application;

import java.io.IOException;

public class Bridge {
	
	public static String registerResponseOptions(Boolean response) {
		String registerOk = "Cadastro realizado com sucesso!";
		String registerExists = "O usuário já está cadastrado!";
		String registerProblem = "Não foi possível realizar o cadastro!";
		if(response == true) return registerOk;
		else if(response == false) return registerExists;
		else return registerProblem;
		
	}
	
	// Se registrar, retorna true em response, se não false. Se esses opções não funcionarem, resta null.
	public static Boolean registerUser(String path, String transferData) {
		Boolean response = null;
		try {
			response = Register.registerUser(path, transferData);
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		return response;
	}
	
	// Se existir usuário response retorna true, se não existir retorna false, se nenhum dos dois, retorna null.
	public static Boolean checkIfUserExists(String path, String transferData) {
			Boolean response = null;
			
			// response pode receber true ou false.
			try {
				response = Register.check(path, transferData);
			}
			catch (IOException e1) {
				System.out.println("Impossível acessar o arquivo.");
				e1.printStackTrace();
			} 
		return response;
		
	}
}
