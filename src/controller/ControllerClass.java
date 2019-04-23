package controller;

import java.awt.event.ActionEvent;
import model.Database;
import view.PrincipalForm;

public class ControllerClass implements java.awt.event.ActionListener {

	private PrincipalForm pf;
	private String siteValue;
	private String nicknameValue;

	public ControllerClass(PrincipalForm pf) {
		this.pf = pf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(this.pf.jcb)) {
			this.siteValue = (String) this.pf.jcb.getSelectedItem();
		}

		if (e.getSource().equals(this.pf.btnValidate)) {

			this.nicknameValue = this.pf.txtNickName.getText();

			try {
				Database.sendRequest(this.siteValue, this.nicknameValue);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

}
