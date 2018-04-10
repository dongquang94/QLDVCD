package createNewUser;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateNewUser createUserProcess = new CreateNewUser();
		try {
			createUserProcess.Login();
			createUserProcess.CreateUser();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
