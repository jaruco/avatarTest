package view;

import javax.swing.*;

import controller.ControllerClass;

public class PrincipalForm extends JFrame {

	private static final long serialVersionUID = 181213588483368512L;

	private JPanel container;

	private JLabel labelName;
	private JLabel labelLastName;

	public JTextField txtNickName;

	public JButton btnValidate;
	
	public JComboBox jcb;

	private String[] sites = { "MNI", "MCO", "MLA", "MEC", "MLV", "MPA", "MPY", "MLC", "MCR", "MGT", "MRD", "MBO", "MLU", "MPT", "MSV", "MLB", "MPE", "MHN", "MCU", "MLM"};; 
	
	public PrincipalForm() {
		
		setBounds(100, 100, 450, 300);
		setTitle("Welcome Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		container = new JPanel();
		getContentPane().add(container);

		SpringLayout sp = new SpringLayout();
		container.setLayout(sp);

		labelName = new JLabel("SITE ");
		container.add(labelName);
		sp.putConstraint(SpringLayout.NORTH, labelName, 10, SpringLayout.NORTH, container);
		sp.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, container);

		labelLastName = new JLabel("NICKNAME ");
		container.add(labelLastName);
		sp.putConstraint(SpringLayout.NORTH, labelLastName, 50, SpringLayout.NORTH, container);
		sp.putConstraint(SpringLayout.WEST, labelLastName, 10, SpringLayout.WEST, container);

		jcb = new JComboBox(sites);
		container.add(jcb);
		sp.putConstraint(SpringLayout.NORTH, jcb, 10, SpringLayout.NORTH, container);
		sp.putConstraint(SpringLayout.WEST, jcb, 100, SpringLayout.WEST, container);
		sp.putConstraint(SpringLayout.EAST, jcb, 300, SpringLayout.WEST, container);

		txtNickName = new JTextField();
		container.add(txtNickName);
		sp.putConstraint(SpringLayout.NORTH, txtNickName, 50, SpringLayout.NORTH, container);
		sp.putConstraint(SpringLayout.WEST, txtNickName, 100, SpringLayout.WEST, container);
		sp.putConstraint(SpringLayout.EAST, txtNickName, 300, SpringLayout.WEST, container);

		btnValidate = new JButton("Validate");
		container.add(btnValidate);
		sp.putConstraint(SpringLayout.SOUTH, btnValidate, -10, SpringLayout.SOUTH, container);
		sp.putConstraint(SpringLayout.WEST, btnValidate, 60, SpringLayout.WEST, container);

		setVisible(true);

	}
	
	public void conectaControlador(ControllerClass c) {

		btnValidate.addActionListener(c);
		btnValidate.setActionCommand("VALIDATE");
		jcb.addActionListener(c);
	}
}
