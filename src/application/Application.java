package application;

import controller.ControllerClass;
import view.PrincipalForm;

public class Application {

	public static void main(String[] args) {
		PrincipalForm pf = new PrincipalForm();
		ControllerClass cc = new ControllerClass(pf);
		pf.conectaControlador(cc);
	}

}
