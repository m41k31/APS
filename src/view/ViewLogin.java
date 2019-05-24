package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import connection.ConnectionFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ViewLogin extends JFrame {

	private JFrame frame;
	private JTextField txtCdFuncionario;
	private JPasswordField txtPassFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
			System.err.println(e);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 324, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JLabel lbCdFuncionario = new JLabel("C\u00F3digo funcion\u00E1rio:");
		lbCdFuncionario.setFont(new Font("Arial", Font.PLAIN, 11));
		lbCdFuncionario.setBounds(37, 175, 130, 14);
		frame.getContentPane().add(lbCdFuncionario);
		
		JLabel lbPassFuncionario = new JLabel("Senha:");
		lbPassFuncionario.setFont(new Font("Arial", Font.PLAIN, 11));
		lbPassFuncionario.setBounds(37, 239, 46, 14);
		frame.getContentPane().add(lbPassFuncionario);
		
		txtCdFuncionario = new JTextField();
		txtCdFuncionario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCdFuncionario.setBounds(37, 200, 251, 28);
		frame.getContentPane().add(txtCdFuncionario);
		txtCdFuncionario.setColumns(10);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(199, 305, 89, 28);
		frame.getContentPane().add(btnFechar);
		
		JLabel lbInstrucoes = new JLabel("<html>Informe seu c\u00F3digo de funcion\u00E1rio e senha<br />para acessar a aplica\u00E7\u00E3o</html>");
		lbInstrucoes.setFont(new Font("Arial", Font.PLAIN, 11));
		lbInstrucoes.setBounds(37, 130, 277, 42);
		frame.getContentPane().add(lbInstrucoes);
		
		JLabel lbLogin = new JLabel("LOGIN");
		lbLogin.setForeground(new Color(0, 139, 139));
		lbLogin.setFont(new Font("Arial", Font.BOLD, 18));
		lbLogin.setBounds(37, 105, 130, 28);
		frame.getContentPane().add(lbLogin);
		
		JLabel lbImgLogo = new JLabel(new ImageIcon(this.getClass().getResource("/logo.png")));
		lbImgLogo.setText("");
		lbImgLogo.setBounds(90, 25, 170, 70);
		frame.getContentPane().add(lbImgLogo);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCdFuncionario.getText().equals("12345") && txtPassFuncionario.getText().equals("12345")) {
					ViewMain frameMain = new ViewMain();
					frameMain.getJFMain().setVisible(true);
					frame.setVisible(false);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Código funcionário e/ou senha inválidas.", "Login", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEntrar.setBounds(96, 305, 89, 28);
		frame.getContentPane().add(btnEntrar);
		
		txtPassFuncionario = new JPasswordField();
		txtPassFuncionario.setBounds(37, 264, 251, 28);
		frame.getContentPane().add(txtPassFuncionario);
	}
}
