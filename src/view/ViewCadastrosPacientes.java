package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import controller.EnderecosControl;
import controller.PacientesControl;
import controller.PessoaControl;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Choice;
import javax.swing.JTextPane;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import model.Pessoa;
import modelDAO.EnderecosDAO;
import modelDAO.PessoaDAO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ViewCadastrosPacientes extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtRG;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JTextField txtFoneResidencial;
	private JTextField txtFoneCelular;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField textField;
	private JFormattedTextField txtDataNascimento;
	private JTable table;
	private Choice selEstadoCivil; 
	private Choice selSexo;
	private Choice selEstado;
	private JTextPane txtObservacao;
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		ArrayList<String[]> pacientes = PacientesControl.resgatarPacientes();
		for(int i = 0; i < pacientes.size(); i++) {
			modelo.addRow(new Object[] {					
				pacientes.get(i)[0],
				pacientes.get(i)[1],
				pacientes.get(i)[2],
				pacientes.get(i)[3],
				pacientes.get(i)[4]
			});
		}
	}
	
	public void resgatarPacienteTotal(int id) {
		ArrayList<String[]> pacientes = PacientesControl.resgatarPacienteTotal(id);
		for(int i = 0; i < pacientes.size(); i++) {
			txtNome.setText(pacientes.get(i)[1]);
			txtDataNascimento.setValue(pacientes.get(i)[2]);
			txtEmail.setText(pacientes.get(i)[3]);
			txtRG.setText(pacientes.get(i)[4]);
			txtCPF.setText(pacientes.get(i)[5]);
			for (int j = 0; j < selSexo.getItemCount(); j++) {
				if (selSexo.getItem(j).equals(pacientes.get(i)[6])) {
					selSexo.select(j);
					break;
				}
			}
			for (int j = 0; j < selEstadoCivil.getItemCount(); j++) {
				if (selEstadoCivil.getItem(j).equals(pacientes.get(i)[7])) {
					selEstadoCivil.select(j);
					break;
				}
			}
			txtEndereco.setText(pacientes.get(i)[8]);
			txtCep.setText(pacientes.get(i)[9]);
			txtNumero.setText(pacientes.get(i)[10]);
			txtComplemento.setText(pacientes.get(i)[11]);
			txtBairro.setText(pacientes.get(i)[12]);
			for (int j = 0; j < selEstado.getItemCount(); j++) {
				if (selEstado.getItem(j).equals(pacientes.get(i)[13])) {
					selEstado.select(j);
					break;
				}
			}
			txtCidade.setText(pacientes.get(i)[14]);
			txtObservacao.setText(pacientes.get(i)[15]);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastrosPacientes frame = new ViewCadastrosPacientes();
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
	public ViewCadastrosPacientes() {		
		setTitle("Cadastro de Pacientes");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 618, 575);
		CardLayout cardLayout  = new CardLayout(0, 0);
		getContentPane().setLayout(cardLayout);
		
		JPanel pnlCadastros = new JPanel();
		getContentPane().add(pnlCadastros, "pnlCadastros");
		
		JLabel label_17 = new JLabel("Pesquisar:");
		label_17.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRemover = new JButton("Apagar");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
				PacientesControl.deletarPaciente(id);
				readJTable();
				
			}
		});
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 9));
		JButton btnUpdate = new JButton("Salvar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigoPaciente = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
				int codigoEndereco = PacientesControl.updatePaciente(codigoPaciente, txtNome.getText(), txtDataNascimento.getText(), txtEmail.getText(), txtRG.getText(), txtCPF.getText(), selSexo.getSelectedItem(), selEstadoCivil.getSelectedItem(), txtObservacao.getText());
				EnderecosControl.updateEndereco(codigoEndereco, txtCep.getText(), txtEndereco.getText(), txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), selEstado.getSelectedItem(), txtCidade.getText());
				limparCampos();
				cardLayout.show(getContentPane(), "pnlCadastros");
				readJTable();	
			}
		});
		JButton btnNovo = new JButton("Novo");
		JButton btnSalvar = new JButton("Salvar");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(getContentPane(), "pnlCadastrar");
			}
		});
		btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 9));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
				resgatarPacienteTotal(id);
				cardLayout.show(getContentPane(), "pnlCadastrar");
				btnSalvar.setVisible(false);
				btnUpdate.setVisible(true);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 9));
		GroupLayout gl_pnlCadastros = new GroupLayout(pnlCadastros);
		gl_pnlCadastros.setHorizontalGroup(
			gl_pnlCadastros.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCadastros.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
						.addComponent(label_17, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlCadastros.createSequentialGroup()
							.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlCadastros.setVerticalGroup(
			gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCadastros.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_17)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		table = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex) {        
				return false;
			}
		};
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnEditar.setEnabled(true);
				btnRemover.setEnabled(true);
				//System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		pnlCadastros.setLayout(gl_pnlCadastros);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		table.setRowSorter(new TableRowSorter(modelo));
		table.setModel(modelo);     //tableActivities é o nome da minha jTable
		btnNovo.setIcon(new ImageIcon(this.getClass().getResource("/add.png")));
		btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setIcon(new ImageIcon(this.getClass().getResource("/page_edit.png")));
		btnRemover.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRemover.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRemover.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
		btnRemover.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRemover.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JPanel pnlCadastrar = new JPanel();
		getContentPane().add(pnlCadastrar, "pnlCadastrar");
		pnlCadastrar.setLayout(null);
		
		JTabbedPane tabCadastrarPacientes = new JTabbedPane(JTabbedPane.TOP);
		tabCadastrarPacientes.setBounds(10, 11, 591, 478);
		pnlCadastrar.add(tabCadastrarPacientes);
		
		JPanel tabDadosPaciente = new JPanel();
		tabDadosPaciente.setLayout(null);
		tabDadosPaciente.setBorder(null);
		tabCadastrarPacientes.addTab("Dados do Paciente", null, tabDadosPaciente, null);
		
		JLabel label = new JLabel("Nome:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Arial", Font.PLAIN, 11));
		label.setBounds(46, 30, 46, 14);
		tabDadosPaciente.add(label);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(102, 24, 456, 26);
		tabDadosPaciente.add(txtNome);
		
		JLabel label_1 = new JLabel("RG:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Arial", Font.PLAIN, 11));
		label_1.setBounds(46, 66, 46, 14);
		tabDadosPaciente.add(label_1);
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		txtRG.setBounds(102, 60, 174, 26);
		tabDadosPaciente.add(txtRG);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial", Font.PLAIN, 11));
		label_2.setBounds(313, 66, 61, 14);
		tabDadosPaciente.add(label_2);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(384, 60, 174, 26);
		tabDadosPaciente.add(txtCPF);
		
		JLabel label_3 = new JLabel("Data de Nasc:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Arial", Font.PLAIN, 11));
		label_3.setBounds(27, 103, 68, 14);
		tabDadosPaciente.add(label_3);
		
		try {
			txtDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataNascimento.setBounds(102, 97, 174, 26);
		tabDadosPaciente.add(txtDataNascimento);
		txtDataNascimento.setDocument(new JTextFieldLimit(10));
		txtDataNascimento.setCaretPosition(0);
		
		selEstadoCivil = new Choice();
		selEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		selEstadoCivil.setBounds(386, 99, 170, 21);
		tabDadosPaciente.add(selEstadoCivil);
		
		JLabel label_4 = new JLabel("Estado Civil:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 11));
		label_4.setBounds(313, 103, 61, 14);
		tabDadosPaciente.add(label_4);

		selSexo = new Choice();
		selSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		selSexo.setBounds(104, 136, 170, 21);
		tabDadosPaciente.add(selSexo);
		
		JLabel label_5 = new JLabel("Sexo:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Arial", Font.PLAIN, 11));
		label_5.setBounds(27, 140, 65, 14);
		tabDadosPaciente.add(label_5);
		
		JLabel label_6 = new JLabel("E-mail:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Arial", Font.PLAIN, 11));
		label_6.setBounds(27, 176, 65, 14);
		tabDadosPaciente.add(label_6);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(102, 170, 456, 26);
		tabDadosPaciente.add(txtEmail);
		
		JLabel label_7 = new JLabel("Fone Resid.:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Arial", Font.PLAIN, 11));
		label_7.setBounds(10, 214, 86, 14);
		tabDadosPaciente.add(label_7);
		
		txtFoneResidencial = new JTextField();
		txtFoneResidencial.setColumns(10);
		txtFoneResidencial.setBounds(102, 207, 174, 26);
		tabDadosPaciente.add(txtFoneResidencial);
		
		JLabel label_8 = new JLabel("Fone Celular:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Arial", Font.PLAIN, 11));
		label_8.setBounds(301, 214, 73, 14);
		tabDadosPaciente.add(label_8);
		
		txtFoneCelular = new JTextField();
		txtFoneCelular.setColumns(10);
		txtFoneCelular.setBounds(384, 207, 174, 26);
		tabDadosPaciente.add(txtFoneCelular);
		
		JLabel label_9 = new JLabel("CEP:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Arial", Font.PLAIN, 11));
		label_9.setBounds(46, 251, 46, 14);
		tabDadosPaciente.add(label_9);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(102, 245, 174, 26);
		tabDadosPaciente.add(txtCep);
		
		JLabel label_10 = new JLabel("Endere\u00E7o:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Arial", Font.PLAIN, 11));
		label_10.setBounds(19, 290, 73, 14);
		tabDadosPaciente.add(label_10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(102, 284, 456, 26);
		tabDadosPaciente.add(txtEndereco);
		
		JLabel label_11 = new JLabel("N\u00FAmero:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Arial", Font.PLAIN, 11));
		label_11.setBounds(27, 329, 65, 14);
		tabDadosPaciente.add(label_11);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(102, 323, 174, 26);
		tabDadosPaciente.add(txtNumero);
		
		JLabel label_12 = new JLabel("Complemento:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Arial", Font.PLAIN, 11));
		label_12.setBounds(286, 329, 88, 14);
		tabDadosPaciente.add(label_12);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(384, 321, 174, 28);
		tabDadosPaciente.add(txtComplemento);
		
		JLabel label_13 = new JLabel("Bairro:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Arial", Font.PLAIN, 11));
		label_13.setBounds(27, 368, 65, 14);
		tabDadosPaciente.add(label_13);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(102, 362, 174, 26);
		tabDadosPaciente.add(txtBairro);
		
		JLabel label_14 = new JLabel("Cidade:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Arial", Font.PLAIN, 11));
		label_14.setBounds(309, 366, 65, 14);
		tabDadosPaciente.add(label_14);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(384, 362, 174, 26);
		tabDadosPaciente.add(txtCidade);
		
		JLabel label_15 = new JLabel("Estado:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("Arial", Font.PLAIN, 11));
		label_15.setBounds(31, 407, 61, 14);
		tabDadosPaciente.add(label_15);
		
		selEstado = new Choice();
		selEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		selEstado.setBounds(104, 404, 174, 21);
		tabDadosPaciente.add(selEstado);
		
		JPanel tabObservacoes = new JPanel();
		tabObservacoes.setLayout(null);
		tabObservacoes.setBorder(null);
		tabCadastrarPacientes.addTab("Observações", null, tabObservacoes, null);
		
		JLabel label_16 = new JLabel("Caso tenha alguma observa\u00E7\u00E3o do paciente, digitar no campo abaixo.");
		label_16.setBounds(10, 11, 566, 14);
		tabObservacoes.add(label_16);
		
		txtObservacao = new JTextPane();
		txtObservacao.setBounds(12, 36, 566, 407);
		tabObservacoes.add(txtObservacao);		
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o nome do paciente");
				} else if (txtRG.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o RG paciente");
				} else if (txtCPF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o CPF paciente");
				} else if (txtDataNascimento.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite a Data de Nascimento do paciente");
				} else if (selEstadoCivil.getSelectedItem().equals("Selecione o Estado Civil")) {
					JOptionPane.showMessageDialog(null, "Selecione o Estado Civil");
				} else if (selSexo.getSelectedItem().equals("Selecione o Sexo")) {
					JOptionPane.showMessageDialog(null, "Selecione o Sexo");
				} else if (txtCep.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o CEP do endereço");
				} else if (txtEndereco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite a Rua do endereço");
				} else if (txtNumero.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o Número do endereço");
				} else if (txtBairro.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o Bairro do endereço");
				} else if (txtCidade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite a Cidade do endereço");
				} else if (selEstado.getSelectedItem().equals("Selecione o Estado")) {
					JOptionPane.showMessageDialog(null, "Selecione o Estado do endereço");
				} else {
					int codEndereco = EnderecosControl.salvarEndereco(txtCep.getText(), txtEndereco.getText(), txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), selEstado.getSelectedItem(), txtCidade.getText());
					PacientesControl.salvarPaciente(txtNome.getText(), txtDataNascimento.getText(), txtEmail.getText(), txtRG.getText(), txtCPF.getText(), selSexo.getSelectedItem(), selEstadoCivil.getSelectedItem(), txtObservacao.getText(), codEndereco);
					limparCampos();
					cardLayout.show(getContentPane(), "pnlCadastros");
					readJTable();	
				}
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSalvar.setBounds(359, 500, 100, 30);
		pnlCadastrar.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				cardLayout.show(getContentPane(), "pnlCadastros");
				readJTable();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar.setBounds(469, 500, 100, 30);
		pnlCadastrar.add(btnCancelar);
		
		selEstadoCivil.add("Selecione o Estado Civil");
		selEstadoCivil.add("Solteiro(a)");
		selEstadoCivil.add("Casado(a)");
		selEstadoCivil.add("Viúvo(a)");
		selEstadoCivil.add("Desquitado(a)");
		selEstadoCivil.add("Divorciado(a)");
		selEstadoCivil.add("Sep. Judicial");
		
		selSexo.add("Selecione o Sexo");
		selSexo.add("Masculino");
		selSexo.add("Feminino");
		selSexo.add("Outro");
		
		selEstado.add("Selecione o Estado");
		selEstado.add("Acre (AC)");
		selEstado.add("Alagoas (AL)");
		selEstado.add("Amapá (AP)");
		selEstado.add("Amazonas (AM)");
		selEstado.add("Bahia (BA)");
		selEstado.add("Ceará (CE)");
		selEstado.add("Distrito Federal (DF)");
		selEstado.add("Espírito Santo (ES)");
		selEstado.add("Goiás (GO)");
		selEstado.add("Maranhão (MA)");
		selEstado.add("Mato Grosso (MT)");
		selEstado.add("Mato Grosso do Sul (MS)");
		selEstado.add("Minas Gerais (MG)");
		selEstado.add("Pará (PA)");
		selEstado.add("Paraíba (PB)");
		selEstado.add("Paraná (PR)");
		selEstado.add("Pernambuco (PE)");
		selEstado.add("Piauí (PI)");
		selEstado.add("Rio de Janeiro (RJ)");
		selEstado.add("Rio Grande do Norte (RN)");
		selEstado.add("Rio Grande do Sul (RS)");
		selEstado.add("Rondônia (RO)");
		selEstado.add("Roraima (RR)");
		selEstado.add("Santa Catarina (SC)");
		selEstado.add("São Paulo (SP)");
		selEstado.add("Sergipe (SE)");
		selEstado.add("Tocantins (TO");
		
		btnSalvar.setIcon(new ImageIcon(this.getClass().getResource("/page_save.png")));
		btnUpdate.setIcon(new ImageIcon(this.getClass().getResource("/page_save.png")));
		btnCancelar.setIcon(new ImageIcon(this.getClass().getResource("/cancel.png")));
		
		
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnUpdate.setBounds(359, 500, 100, 30);
		pnlCadastrar.add(btnUpdate);
		btnUpdate.setVisible(false);
		
		/*
			    TableColumn col = table.getColumnModel().getColumn(0);
			    col = table.getColumnModel().getColumn(1);
			    //col.setPreferredWidth(200);
			    col = table.getColumnModel().getColumn(2);
			    //col.setPreferredWidth(200);
			    col = table.getColumnModel().getColumn(3);
			    col = table.getColumnModel().getColumn(4);*/
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Data de Nascimento");
		modelo.addColumn("RG");
		modelo.addColumn("CPF");
		/*modelo.addColumn("ID"); cd_paciente, nm_pessoa, dt_nascimento, nr_rg, nr_cpf 
		modelo.addColumn("Nome");
		modelo.addColumn("Especialidade Principal");
		modelo.addColumn("Fone Fixo");
		modelo.addColumn("Fone Celular");*/
	    /*modelo.addRow(new Object[]{"a", "c894083 24 238904238 9490238", "Clinico geral"});  
	    modelo.addRow(new Object[]{"a", "b", "c"});  
	    modelo.addRow(new Object[]{"a", "b", "c"});*/
		TableColumn col = table.getColumnModel().getColumn(0);
	    col.setMinWidth(60);
	    col.setMaxWidth(60);
	    col.setWidth(60);
	    col.setPreferredWidth(60);
	    col.setMinWidth(200);
	    //col.setMaxWidth(200);
	    col.setWidth(200);
	    col.setMinWidth(150);
	    col.setMaxWidth(150);
	    col.setWidth(150);
	    col.setMinWidth(150);
	    col.setMaxWidth(150);
	    col.setWidth(150);
	    col.setPreferredWidth(150);
	    col.setMinWidth(150);
	    col.setMaxWidth(150);
	    col.setWidth(150);
	    col.setPreferredWidth(150);
		
		/*
		 * table
		 */
		readJTable();
		
		/* Add selects
		 * 
		 */
		
		/* 
		 * Images
		 */
	}
	
	public void limparCampos() {
		txtNome.setText("");
		txtRG.setText("");
		txtCPF.setText("");
		txtDataNascimento.setValue(null);
		selEstadoCivil.select(0);
		selSexo.select(0);
		txtEmail.setText("");
		txtFoneResidencial.setText("");
		txtFoneCelular.setText("");
		txtCep.setText("");
		txtEndereco.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		selEstado.select(0);		
	}
	
	class JTextFieldLimit extends PlainDocument {
		  private int limit;
		  JTextFieldLimit(int limit) {
		    super();
		    this.limit = limit;
		  }

		  JTextFieldLimit(int limit, boolean upper) {
		    super();
		    this.limit = limit;
		  }

		  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    if (str == null)
		      return;

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
		  }
		}
}
