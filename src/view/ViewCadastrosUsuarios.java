package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTable;

public class ViewCadastrosUsuarios extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastrosUsuarios frame = new ViewCadastrosUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewCadastrosUsuarios() {
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setTitle("Cadastro de Usu\u00E1rios");
		setBounds(100, 100, 618, 575);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel pnlConsultaUsuarios = new JPanel();
		getContentPane().add(pnlConsultaUsuarios, "name_265330749405100");
		pnlConsultaUsuarios.setLayout(null);
		
		JLabel label = new JLabel("Pesquisar:");
		label.setFont(new Font("Arial", Font.PLAIN, 11));
		label.setBounds(10, 11, 78, 14);
		pnlConsultaUsuarios.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 31, 582, 30);
		pnlConsultaUsuarios.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 582, 320);
		pnlConsultaUsuarios.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setColumnHeaderView(table);
		
		JPanel sss = new JPanel();
		getContentPane().add(sss, "name_265328422133000");
		sss.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	}
}
