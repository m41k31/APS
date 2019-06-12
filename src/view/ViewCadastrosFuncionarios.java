package view;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import controller.CargosControl;
import controller.EnderecosControl;
import controller.EspecialidadeMedicaControl;
import controller.FuncionariosControl;
import controller.MedicosControl;

public class ViewCadastrosFuncionarios extends JInternalFrame {
	private ArrayList<Choice> listEspecialidade = new ArrayList<Choice>();
	private int listEspecialidadeY = 99;
	private int btnAddEspecialidadeY = 97;
	private JTable table;
	private JTextField txtPesquisar, txtNome, txtRG, txtCPF, txtEmail, txtFoneResidencial, txtFoneCelular, txtCep, txtEndereco, txtNumero, txtComplemento, txtBairro, txtCidade, txtLogin, txtCrm;
	private JFormattedTextField txtDataNascimento;
	private JPasswordField txtPassword;
	private Choice selEstadoCivil, selEstado, selTipoFuncionario, selSexo;
	private Checkbox cbSegunda, cbTerca, cbQuarta, cbQuinta, cbSexta, cbSabado, cbDomingo;
	private JTextField txtHoraEntrada1, txtHoraEntrada2, txtHoraEntrada3, txtHoraEntrada4, txtHoraEntrada5, txtHoraEntrada6, txtHoraEntrada7;
	private JTextField txtHoraSaida1, txtHoraSaida2, txtHoraSaida3, txtHoraSaida4, txtHoraSaida5, txtHoraSaida6, txtHoraSaida7;
	private HashMap<String, Integer> idCargos;
	private HashMap<String, Integer> idEspecialidadeMedica;
	private JButton btnNovo;
	private JButton btnEditar;
	private JButton btnRemover;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastrosFuncionarios frame = new ViewCadastrosFuncionarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void readCargos() {
		selTipoFuncionario.add("Selecione o tipo");
		ArrayList<String[]> cargos = CargosControl.listarCargos();
		for(int i = 0; i < cargos.size(); i++) {
			idCargos.put(cargos.get(i)[1], Integer.parseInt(cargos.get(i)[0]));
			selTipoFuncionario.add(cargos.get(i)[1]);
		}
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		ArrayList<String[]> funcionarios = FuncionariosControl.listarFuncionarios();
		for(int i = 0; i < funcionarios.size(); i++) {
			modelo.addRow(new Object[] {					
				funcionarios.get(i)[0],
				funcionarios.get(i)[1],
				funcionarios.get(i)[2],
				funcionarios.get(i)[3],
				funcionarios.get(i)[4],
				funcionarios.get(i)[5]
			});
		}
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

	/**
	 * Create the frame.
	 */
	public ViewCadastrosFuncionarios() {
		/*CargosControl.createBase("Gerente");
		CargosControl.createBase("Médico");
		CargosControl.createBase("Recepcionista");
		EspecialidadeMedicaControl.createBase("Cardiologista");
		EspecialidadeMedicaControl.createBase("Clinico geral");
		EspecialidadeMedicaControl.createBase("Geriatra");
		EspecialidadeMedicaControl.createBase("Reumatologista");
		EspecialidadeMedicaControl.createBase("Urologista");*/
		
		idCargos = new HashMap<String, Integer>();
		idEspecialidadeMedica = new HashMap<String, Integer>();
		
		setTitle("Cadastro de Profissionais");
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(100, 100, 618, 575);
		CardLayout cardLayout  = new CardLayout(0, 0);
		getContentPane().setLayout(cardLayout);
		
		JPanel pnlCadastros = new JPanel();
		getContentPane().add(pnlCadastros, "pnlCadastros");
		
		JLabel lblNewLabel = new JLabel("Pesquisar:");
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
				cardLayout.show(getContentPane(), "pnlCadastrar");
			}
		});
		btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 9));
		
		btnEditar = new JButton("Editar");
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 9));
		btnEditar.setEnabled(false);
		
		btnRemover = new JButton("Apagar");
		btnRemover.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRemover.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 9));
		btnRemover.setEnabled(false);
		GroupLayout gl_pnlCadastros = new GroupLayout(pnlCadastros);
		gl_pnlCadastros.setHorizontalGroup(
			gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCadastros.createSequentialGroup()
					.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pnlCadastros.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
						.addGroup(gl_pnlCadastros.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPesquisar, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_pnlCadastros.createSequentialGroup()
							.addContainerGap(403, Short.MAX_VALUE)
							.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlCadastros.setVerticalGroup(
			gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCadastros.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		table = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex) {        
				return false;
			}
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		pnlCadastros.setLayout(gl_pnlCadastros);
		
		JPanel pnlCadastrar = new JPanel();
		getContentPane().add(pnlCadastrar, "pnlCadastrar");
		
		JTabbedPane tabCadastrarMedicos = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				} else if (txtLogin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o login do funcionário");
				} else if (txtPassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite a senha do funcionário");
				} else if (selTipoFuncionario.getSelectedItem().equals("Selecione o tipo")) {
					JOptionPane.showMessageDialog(null, "Selecione o tipo de funcionário");
				} else if (selTipoFuncionario.getSelectedItem().equals("Médico") && listEspecialidade.get(0).getSelectedItem().equals("Selecione a Especialidade")) { 
					JOptionPane.showMessageDialog(null, "Selecione a Especialidade médica");
				} else if (selTipoFuncionario.getSelectedItem().equals("Médico") && txtCrm.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "Digite o crm do médico");
				} else if(cbSegunda.getState() && (txtHoraEntrada1.getText().isEmpty() || txtHoraSaida1.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Digite a hora de entrada e saída de segunda-feira");
				} else if(cbTerca.getState() && (txtHoraEntrada2.getText().isEmpty() || txtHoraSaida2.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Digite a hora de entrada e saída de terça-feira");
				} else if(cbQuarta.getState() && (txtHoraEntrada3.getText().isEmpty() || txtHoraSaida3.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Digite a hora de entrada e saída de quarta-feira");
				} else if(cbQuinta.getState() && (txtHoraEntrada4.getText().isEmpty() || txtHoraSaida4.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Digite a hora de entrada e saída de quinta-feira");
				} else if(cbSexta.getState() && (txtHoraEntrada5.getText().isEmpty() || txtHoraSaida5.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Digite a hora de entrada e saída de sexta-feira");
				} else if(cbSabado.getState() && (txtHoraEntrada6.getText().isEmpty() || txtHoraSaida6.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Digite a hora de entrada e saída de sábado");
				} else if(cbDomingo.getState() && (txtHoraEntrada7.getText().isEmpty() || txtHoraSaida7.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Digite a hora de entrada e saída de domingo");
				} else {
					if (selTipoFuncionario.getSelectedIndex() == 2) {
						int codigoPessoa = MedicosControl.salvarMedico(txtNome.getText(), txtDataNascimento.getText(), txtEmail.getText(), txtRG.getText(), txtCPF.getText(), selSexo.getSelectedItem(), selEstadoCivil.getSelectedItem(), Integer.parseInt(txtCrm.getText()), txtLogin.getText(), txtPassword.getText());
						EnderecosControl.salvarEndereco(txtCep.getText(), txtEndereco.getText(), txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), selEstado.getSelectedItem(), txtCidade.getText(), codigoPessoa);	
						CargosControl.salvarCargo(idCargos.get(selTipoFuncionario.getSelectedItem()), codigoPessoa);
						for(int i = 0; i < listEspecialidade.size(); i++) {
							EspecialidadeMedicaControl.salvarEspecialidade(idEspecialidadeMedica.get(listEspecialidade.get(i).getSelectedItem()), codigoPessoa);
						}
					} else {
						int codigoPessoa = FuncionariosControl.salvarFuncionario(txtNome.getText(), txtDataNascimento.getText(), txtEmail.getText(), txtRG.getText(), txtCPF.getText(), selSexo.getSelectedItem(), selEstadoCivil.getSelectedItem(), txtLogin.getText(), txtPassword.getText());
						EnderecosControl.salvarEndereco(txtCep.getText(), txtEndereco.getText(), txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), selEstado.getSelectedItem(), txtCidade.getText(), codigoPessoa);	
						CargosControl.salvarCargo(idCargos.get(selTipoFuncionario.getSelectedItem()), codigoPessoa);				
					}
					limparCampos();
					cardLayout.show(getContentPane(), "pnlCadastros");
					readJTable();	
				}
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				cardLayout.show(getContentPane(), "pnlCadastros");
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 11));
		GroupLayout gl_pnlCadastrar = new GroupLayout(pnlCadastrar);
		gl_pnlCadastrar.setHorizontalGroup(
			gl_pnlCadastrar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCadastrar.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabCadastrarMedicos, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_pnlCadastrar.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		gl_pnlCadastrar.setVerticalGroup(
			gl_pnlCadastrar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCadastrar.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabCadastrarMedicos, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCadastrar.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		JPanel tabMedicos = new JPanel();
		tabMedicos.setLayout(null);
		tabMedicos.setBorder(null);
		tabCadastrarMedicos.addTab("Dados do Funcionário", null, tabMedicos, null);
		
		JLabel label = new JLabel("Nome:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Arial", Font.PLAIN, 11));
		label.setBounds(46, 30, 46, 14);
		tabMedicos.add(label);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(102, 24, 456, 26);
		tabMedicos.add(txtNome);
		
		JLabel label_1 = new JLabel("RG:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Arial", Font.PLAIN, 11));
		label_1.setBounds(46, 66, 46, 14);
		tabMedicos.add(label_1);
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		txtRG.setBounds(102, 60, 174, 26);
		tabMedicos.add(txtRG);
		
		JLabel label_2 = new JLabel("CPF:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial", Font.PLAIN, 11));
		label_2.setBounds(313, 66, 61, 14);
		tabMedicos.add(label_2);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(384, 60, 174, 26);
		tabMedicos.add(txtCPF);
		
		JLabel label_3 = new JLabel("Data de Nasc:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Arial", Font.PLAIN, 11));
		label_3.setBounds(27, 103, 68, 14);
		tabMedicos.add(label_3);
		
		try {
			txtDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataNascimento.setBounds(102, 97, 174, 26);
		tabMedicos.add(txtDataNascimento);
		txtDataNascimento.setDocument(new JTextFieldLimit(10));
		txtDataNascimento.setCaretPosition(0);
		
		selEstadoCivil = new Choice();
		selEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		selEstadoCivil.setBounds(386, 99, 170, 21);
		tabMedicos.add(selEstadoCivil);
		
		JLabel label_4 = new JLabel("Estado Civil:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 11));
		label_4.setBounds(313, 103, 61, 14);
		tabMedicos.add(label_4);
		
		selSexo = new Choice();
		selSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		selSexo.setBounds(104, 136, 170, 21);
		tabMedicos.add(selSexo);
		
		JLabel label_5 = new JLabel("Sexo:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Arial", Font.PLAIN, 11));
		label_5.setBounds(27, 140, 65, 14);
		tabMedicos.add(label_5);
		
		JLabel label_6 = new JLabel("E-mail:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Arial", Font.PLAIN, 11));
		label_6.setBounds(27, 176, 65, 14);
		tabMedicos.add(label_6);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(102, 170, 456, 26);
		tabMedicos.add(txtEmail);
		
		JLabel label_7 = new JLabel("Fone Resid.:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Arial", Font.PLAIN, 11));
		label_7.setBounds(10, 214, 86, 14);
		tabMedicos.add(label_7);
		
		txtFoneResidencial = new JTextField();
		txtFoneResidencial.setColumns(10);
		txtFoneResidencial.setBounds(102, 207, 174, 26);
		tabMedicos.add(txtFoneResidencial);
		
		JLabel label_8 = new JLabel("Fone Celular:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Arial", Font.PLAIN, 11));
		label_8.setBounds(301, 214, 73, 14);
		tabMedicos.add(label_8);
		
		txtFoneCelular = new JTextField();
		txtFoneCelular.setColumns(10);
		txtFoneCelular.setBounds(384, 207, 174, 26);
		tabMedicos.add(txtFoneCelular);
		
		JLabel label_9 = new JLabel("CEP:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Arial", Font.PLAIN, 11));
		label_9.setBounds(46, 251, 46, 14);
		tabMedicos.add(label_9);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(102, 245, 174, 26);
		tabMedicos.add(txtCep);
		
		JLabel label_10 = new JLabel("Endere\u00E7o:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Arial", Font.PLAIN, 11));
		label_10.setBounds(19, 290, 73, 14);
		tabMedicos.add(label_10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(102, 284, 456, 26);
		tabMedicos.add(txtEndereco);
		
		JLabel label_11 = new JLabel("N\u00FAmero:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Arial", Font.PLAIN, 11));
		label_11.setBounds(27, 329, 65, 14);
		tabMedicos.add(label_11);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(102, 323, 174, 26);
		tabMedicos.add(txtNumero);
		
		JLabel label_12 = new JLabel("Complemento:");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Arial", Font.PLAIN, 11));
		label_12.setBounds(286, 329, 88, 14);
		tabMedicos.add(label_12);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(384, 321, 174, 28);
		tabMedicos.add(txtComplemento);
		
		JLabel label_13 = new JLabel("Bairro:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("Arial", Font.PLAIN, 11));
		label_13.setBounds(27, 368, 65, 14);
		tabMedicos.add(label_13);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(102, 362, 174, 26);
		tabMedicos.add(txtBairro);
		
		JLabel label_14 = new JLabel("Cidade:");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("Arial", Font.PLAIN, 11));
		label_14.setBounds(309, 366, 65, 14);
		tabMedicos.add(label_14);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(384, 362, 174, 26);
		tabMedicos.add(txtCidade);
		
		JLabel label_15 = new JLabel("Estado:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("Arial", Font.PLAIN, 11));
		label_15.setBounds(31, 407, 61, 14);
		tabMedicos.add(label_15);
		
		selEstado = new Choice();
		selEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		selEstado.setBounds(104, 404, 174, 21);
		tabMedicos.add(selEstado);
		
		JPanel tabInformacoesDoCargo = new JPanel();
		tabCadastrarMedicos.addTab("Informações do Cargo", null, tabInformacoesDoCargo, null);
		tabInformacoesDoCargo.setLayout(null);
		
		JLabel label_16 = new JLabel("Login:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setFont(new Font("Arial", Font.PLAIN, 11));
		label_16.setBounds(46, 30, 46, 14);
		tabInformacoesDoCargo.add(label_16);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(102, 24, 174, 26);
		tabInformacoesDoCargo.add(txtLogin);
		
		JLabel label_17 = new JLabel("Senha:");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setFont(new Font("Arial", Font.PLAIN, 11));
		label_17.setBounds(313, 30, 61, 14);
		tabInformacoesDoCargo.add(label_17);
		
		JLabel label_18 = new JLabel("Tipo Funcion\u00E1rio:");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setFont(new Font("Arial", Font.PLAIN, 11));
		label_18.setBounds(10, 64, 82, 14);
		tabInformacoesDoCargo.add(label_18);
		
		selTipoFuncionario = new Choice();
		selTipoFuncionario.setFont(new Font("Arial", Font.PLAIN, 12));
		selTipoFuncionario.setBounds(104, 62, 169, 21);
		tabInformacoesDoCargo.add(selTipoFuncionario);
		
		JLabel lbEspecialidades = new JLabel("Especialidades:");
		lbEspecialidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEspecialidades.setFont(new Font("Arial", Font.PLAIN, 11));
		lbEspecialidades.setBounds(10, 105, 82, 14);
		tabInformacoesDoCargo.add(lbEspecialidades);
		lbEspecialidades.setVisible(false);
		
		JLabel lbCrm = new JLabel("CRM:");
		lbCrm.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCrm.setFont(new Font("Arial", Font.PLAIN, 11));
		lbCrm.setBounds(313, 69, 61, 14);
		tabInformacoesDoCargo.add(lbCrm);
		lbCrm.setVisible(false);
		
		txtCrm = new JTextField();
		txtCrm.setColumns(10);
		txtCrm.setBounds(384, 63, 174, 26);
		tabInformacoesDoCargo.add(txtCrm);
		txtCrm.setVisible(false);
		
		JButton btnAddEspecialidade = new JButton("");
		btnAddEspecialidade.setBounds(526, 97, 26, 26);
		tabInformacoesDoCargo.add(btnAddEspecialidade);
		btnAddEspecialidade.setVisible(false);
		
		JButton btnRemEspecialidade = new JButton("");
		btnRemEspecialidade.setBounds(554, 133, 26, 26);
		tabInformacoesDoCargo.add(btnRemEspecialidade);
		pnlCadastrar.setLayout(gl_pnlCadastrar);
		btnRemEspecialidade.setVisible(false);
		
		JPanel tabCargaDeTrabalho = new JPanel();
		tabCadastrarMedicos.addTab("Carga de Trabalho", null, tabCargaDeTrabalho, null);
		tabCargaDeTrabalho.setLayout(null);
		
		JLabel label_20 = new JLabel("Selecione os dias de trabalho e os hor\u00E1rios de entrada e sa\u00EDda.");
		label_20.setBounds(37, 25, 486, 14);
		tabCargaDeTrabalho.add(label_20);
		
		JLabel label_21 = new JLabel("Dia da semana");
		label_21.setFont(new Font("Arial", Font.PLAIN, 11));
		label_21.setBounds(35, 50, 120, 14);
		tabCargaDeTrabalho.add(label_21);
		
		JLabel label_22 = new JLabel("Hora entrada");
		label_22.setFont(new Font("Arial", Font.PLAIN, 11));
		label_22.setBounds(191, 50, 76, 14);
		tabCargaDeTrabalho.add(label_22);
		
		JLabel label_23 = new JLabel("Hora sa\u00EDda");
		label_23.setFont(new Font("Arial", Font.PLAIN, 11));
		label_23.setBounds(344, 50, 113, 14);
		tabCargaDeTrabalho.add(label_23);
		
		cbSegunda = new Checkbox("Segunda-feira");
		cbSegunda.setFont(new Font("Arial", Font.PLAIN, 12));
		cbSegunda.setBounds(34, 72, 95, 22);
		tabCargaDeTrabalho.add(cbSegunda);
		
		cbTerca = new Checkbox("Ter\u00E7a-feira");
		cbTerca.setFont(new Font("Arial", Font.PLAIN, 12));
		cbTerca.setBounds(34, 103, 95, 22);
		tabCargaDeTrabalho.add(cbTerca);
		
		cbQuarta = new Checkbox("Quarta-feira");
		cbQuarta.setFont(new Font("Arial", Font.PLAIN, 12));
		cbQuarta.setBounds(34, 133, 95, 22);
		tabCargaDeTrabalho.add(cbQuarta);
		
		cbQuinta = new Checkbox("Quinta-feira");
		cbQuinta.setFont(new Font("Arial", Font.PLAIN, 12));
		cbQuinta.setBounds(34, 163, 95, 22);
		tabCargaDeTrabalho.add(cbQuinta);
		
		cbSexta = new Checkbox("Sexta-feira");
		cbSexta.setFont(new Font("Arial", Font.PLAIN, 12));
		cbSexta.setBounds(34, 191, 95, 22);
		tabCargaDeTrabalho.add(cbSexta);
		
		cbSabado = new Checkbox("S\u00E1bado");
		cbSabado.setFont(new Font("Arial", Font.PLAIN, 12));
		cbSabado.setBounds(34, 222, 95, 22);
		tabCargaDeTrabalho.add(cbSabado);
		
		cbDomingo = new Checkbox("Domingo");
		cbDomingo.setFont(new Font("Arial", Font.PLAIN, 12));
		cbDomingo.setBounds(34, 253, 95, 22);
		tabCargaDeTrabalho.add(cbDomingo);
		
		txtHoraEntrada1 = new JTextField();
		txtHoraEntrada1.setColumns(10);
		txtHoraEntrada1.setBounds(191, 71, 86, 26);
		tabCargaDeTrabalho.add(txtHoraEntrada1);
		
		txtHoraSaida1 = new JTextField();
		txtHoraSaida1.setColumns(10);
		txtHoraSaida1.setBounds(344, 71, 86, 26);
		tabCargaDeTrabalho.add(txtHoraSaida1);
		
		txtHoraEntrada2 = new JTextField();
		txtHoraEntrada2.setColumns(10);
		txtHoraEntrada2.setBounds(191, 101, 86, 26);
		tabCargaDeTrabalho.add(txtHoraEntrada2);
		
		txtHoraSaida2 = new JTextField();
		txtHoraSaida2.setColumns(10);
		txtHoraSaida2.setBounds(344, 101, 86, 26);
		tabCargaDeTrabalho.add(txtHoraSaida2);
		
		txtHoraSaida3 = new JTextField();
		txtHoraSaida3.setColumns(10);
		txtHoraSaida3.setBounds(344, 131, 86, 26);
		tabCargaDeTrabalho.add(txtHoraSaida3);
		
		txtHoraEntrada3 = new JTextField();
		txtHoraEntrada3.setColumns(10);
		txtHoraEntrada3.setBounds(191, 131, 86, 26);
		tabCargaDeTrabalho.add(txtHoraEntrada3);
		
		txtHoraEntrada4 = new JTextField();
		txtHoraEntrada4.setColumns(10);
		txtHoraEntrada4.setBounds(191, 161, 86, 26);
		tabCargaDeTrabalho.add(txtHoraEntrada4);
		
		txtHoraSaida4 = new JTextField();
		txtHoraSaida4.setColumns(10);
		txtHoraSaida4.setBounds(344, 161, 86, 26);
		tabCargaDeTrabalho.add(txtHoraSaida4);
		
		txtHoraSaida5 = new JTextField();
		txtHoraSaida5.setColumns(10);
		txtHoraSaida5.setBounds(344, 191, 86, 26);
		tabCargaDeTrabalho.add(txtHoraSaida5);
		
		txtHoraEntrada5 = new JTextField();
		txtHoraEntrada5.setColumns(10);
		txtHoraEntrada5.setBounds(191, 191, 86, 26);
		tabCargaDeTrabalho.add(txtHoraEntrada5);
		
		txtHoraEntrada6 = new JTextField();
		txtHoraEntrada6.setColumns(10);
		txtHoraEntrada6.setBounds(191, 221, 86, 26);
		tabCargaDeTrabalho.add(txtHoraEntrada6);
		
		txtHoraSaida6 = new JTextField();
		txtHoraSaida6.setColumns(10);
		txtHoraSaida6.setBounds(344, 221, 86, 26);
		tabCargaDeTrabalho.add(txtHoraSaida6);
		
		txtHoraSaida7 = new JTextField();
		txtHoraSaida7.setColumns(10);
		txtHoraSaida7.setBounds(344, 251, 86, 26);
		tabCargaDeTrabalho.add(txtHoraSaida7);
		
		txtHoraEntrada7 = new JTextField();
		txtHoraEntrada7.setColumns(10);
		txtHoraEntrada7.setBounds(191, 251, 86, 26);
		tabCargaDeTrabalho.add(txtHoraEntrada7);
		btnNovo.setIcon(new ImageIcon(this.getClass().getResource("/add.png")));
		btnNovo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNovo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setIcon(new ImageIcon(this.getClass().getResource("/page_edit.png")));
		btnRemover.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRemover.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRemover.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
		btnRemover.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRemover.setHorizontalTextPosition(SwingConstants.CENTER);
		
		/* Add selects
		 * 
		 */
		
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
		
		readCargos();		
				
		listEspecialidade.add(new Choice());
		listEspecialidade.get(0).setBounds(104, listEspecialidadeY, 416, 20);
		popSelectEspecialidades(listEspecialidade.get(0));	
		tabInformacoesDoCargo.add(listEspecialidade.get(0));
		listEspecialidade.get(0).setVisible(false);
		
		/*
		 * Actions
		 */
		
		btnAddEspecialidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listEspecialidade.size() < 9) {
					listEspecialidade.add(new Choice());
					listEspecialidade.get(listEspecialidade.size()-1).setBounds(104, (listEspecialidadeY += 36), 416, 20);
					tabInformacoesDoCargo.add(listEspecialidade.get(listEspecialidade.size()-1));
					btnAddEspecialidade.setLocation(526, btnAddEspecialidadeY += 36);
					btnRemEspecialidade.setLocation(554, btnAddEspecialidadeY);
					btnRemEspecialidade.setVisible(true);
					popSelectEspecialidades(listEspecialidade.get(listEspecialidade.size()-1));
				}
			}
		});
		
		btnRemEspecialidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listEspecialidade.size() > 1) {
					btnRemEspecialidade.setLocation(554, btnAddEspecialidadeY -= 36);	
					btnAddEspecialidade.setLocation(526, btnAddEspecialidadeY);
					tabInformacoesDoCargo.remove(listEspecialidade.get(listEspecialidade.size()-1));	
					listEspecialidade.remove(listEspecialidade.get(listEspecialidade.size()-1));
					listEspecialidadeY -= 36;
					if (listEspecialidade.size() == 1) {
						btnRemEspecialidade.setVisible(false);
					}
				}
			}
		});
		
		selTipoFuncionario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (selTipoFuncionario.getSelectedIndex() == 2) {
					lbCrm.setVisible(true);
					txtCrm.setVisible(true);
					lbEspecialidades.setVisible(true);
					listEspecialidade.get(0).setVisible(true);
					btnAddEspecialidade.setVisible(true);
					btnRemEspecialidade.setVisible(false);
				} else {
					lbCrm.setVisible(false);
					txtCrm.setVisible(false);
					lbEspecialidades.setVisible(false);
					listEspecialidade.get(0).setVisible(false);
					btnAddEspecialidade.setVisible(false);
					btnRemEspecialidade.setVisible(false);
				}
			}
		});
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Data de Nascimento");
		modelo.addColumn("RG");
		modelo.addColumn("CPF");
		modelo.addColumn("Tipo Funcionário");
		TableColumn col = table.getColumnModel().getColumn(0);
	    col.setMinWidth(60);
	    col.setMaxWidth(60);
	    col.setPreferredWidth(60);
		
		/*
		 * table
		 */
		readJTable();
		
		/* 
		 * Images
		 */
		
		btnSalvar.setIcon(new ImageIcon(this.getClass().getResource("/page_save.png")));
		btnCancelar.setIcon(new ImageIcon(this.getClass().getResource("/cancel.png")));
		btnAddEspecialidade.setIcon(new ImageIcon(this.getClass().getResource("/add.png")));
		btnRemEspecialidade.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(384, 24, 174, 26);
		tabInformacoesDoCargo.add(txtPassword);
		
		//temp
		//cardLayout.show(getContentPane(), "pnlCadastrar");
	}
	
	private void popSelectEspecialidades(Choice c) {
		c.add("Selecione o tipo");
		ArrayList<String[]> especialidades = EspecialidadeMedicaControl.listarEspecialidades();
		for(int i = 0; i < especialidades.size(); i++) {
			idEspecialidadeMedica.put(especialidades.get(i)[1], Integer.parseInt(especialidades.get(i)[0]));
			c.add(especialidades.get(i)[1]);
		}
		/*c.add("Selecione a Especialidade");
		c.add("Cardiologista");
		c.add("Clinico geral");
		c.add("Geriatra");
		c.add("Reumatologista");
		c.add("Urologista");*/
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
