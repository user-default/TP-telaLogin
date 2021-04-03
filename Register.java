package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Register{
	
		public static String createFile() throws IOException{
			File path = new File("/tmp/file.txt");
			String pathString;
			if(!path.exists()){
				if(!path.getParentFile().exists()) {
					path.getParentFile().mkdirs();
				}
				path.createNewFile();
			}
			pathString = path.toString();
			return pathString;	
		}

		public static Boolean check(String path, String transferData) throws IOException{

			Boolean userNotFound = true;
			@SuppressWarnings("resource")
			BufferedReader bufferR = new BufferedReader(new FileReader(path));
			String lineR = "";
			// Lê cada linha por iteração, se o valor da linha for null, o laço quebra.
			for(lineR = bufferR.readLine(); lineR != null; lineR = bufferR.readLine()){
				if(lineR.equals(transferData)){
					userNotFound = false;
					return userNotFound;
				}
			}
			return userNotFound;	
		}
		
		public static Boolean registerUser(String path, String transferData) throws IOException{

			@SuppressWarnings("unused")
			String lineW = "";
			Boolean userNotExist = check(path, transferData);
			BufferedWriter bufferW = new BufferedWriter(new FileWriter(path, true));

			if(userNotExist == true){
				bufferW.append(transferData + "\n");
				bufferW.close();
				return true;		
			}
			else if(userNotExist == false){
				bufferW.close();
				return false;
			}
			bufferW.close();
			return null;
		}
}
