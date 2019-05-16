package aplicacaoSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaCadastro {

	private JFrame frmCadastro;
	private JLabel lbl_nome;
	private JTextField textField_nome;
	private JTextField textField_nacio;
	private JButton btnCadastrarAstronomo;
	private DefaultListModel<String> model;
	private JLabel label2;
	private JLabel lbl_nascimento;
	private JTextField textField_nasc;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastro window = new TelaCadastro();
//					window.frmCadastro.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 250, 250);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		lbl_nome = new JLabel("nome:");
		lbl_nome.setBounds(10, 11, 46, 14);
		frmCadastro.getContentPane().add(lbl_nome);
		
		label2 = new JLabel("");
		label2.setBounds(31, 150, 189, 14);
		frmCadastro.getContentPane().add(label2);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(106, 8, 86, 20);
		frmCadastro.getContentPane().add(textField_nome);
		textField_nome.setColumns(10);
		
		textField_nacio = new JTextField();
		textField_nacio.setBounds(106, 33, 86, 20);
		frmCadastro.getContentPane().add(textField_nacio);
		textField_nacio.setColumns(10);
		
		btnCadastrarAstronomo = new JButton("Cadastrar Astronomo");
		btnCadastrarAstronomo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nascimento = textField_nasc.getText();
					String nacionalidade = textField_nacio.getText();
					String nome = textField_nome.getText();
					Fachada.cadastrarAstronomo(nome, nacionalidade, nascimento);
					model.clear();
					textField_nome.setText("");
					textField_nacio.setText("");
					textField_nasc.setText("");
					label2.setText("cadastro concluido");
				}
				catch(Exception e) {
					
				}
			}
		});
		btnCadastrarAstronomo.setBounds(51, 116, 145, 23);
		frmCadastro.getContentPane().add(btnCadastrarAstronomo);
		
		model = new DefaultListModel<String>() ;
		
		JLabel lbl_nacional = new JLabel("nacionalidade");
		lbl_nacional.setBounds(10, 36, 65, 14);
		frmCadastro.getContentPane().add(lbl_nacional);
		
		lbl_nascimento = new JLabel("Nascimento");
		lbl_nascimento.setBounds(10, 61, 65, 14);
		frmCadastro.getContentPane().add(lbl_nascimento);
		
		textField_nasc = new JTextField();
		textField_nasc.setColumns(10);
		textField_nasc.setBounds(106, 58, 86, 20);
		frmCadastro.getContentPane().add(textField_nasc);
		
		//mostrar a janela
		frmCadastro.setVisible(true);
	}
}
