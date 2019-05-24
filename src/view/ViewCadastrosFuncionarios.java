package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Choice;
import java.awt.Checkbox;
import javax.swing.JPasswordField;

public class ViewCadastrosFuncionarios extends JInternalFrame {
	private ArrayList<Choice> listEspecialidade = new ArrayList<Choice>();
	private int listEspecialidadeY = 99;
	private int btnAddEspecialidadeY = 97;
	private JTextField txtPesquisar;
	private JTable table;
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
	private JTextField txtLogin;
	private JTextField txtCrm;
	private JTextField txtHoraEntrada1;
	private JTextField txtHoraSaida1;
	private JTextField txtHoraEntrada2;
	private JTextField txtHoraSaida2;
	private JTextField txtHoraSaida3;
	private JTextField txtHoraEntrada3;
	private JTextField txtHoraEntrada4;
	private JTextField txtHoraSaida4;
	private JTextField txtHoraSaida5;
	private JTextField txtHoraEntrada5;
	private JTextField txtHoraEntrada6;
	private JTextField txtHoraSaida6;
	private JTextField txtHoraSaida7;
	private JTextField txtHoraEntrada7;
	private JPasswordField txtPassword;

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

	/**
	 * Create the frame.
	 */
	public ViewCadastrosFuncionarios() {
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				 DefaultTableModel modelo = new DefaultTableModel();
				  table.setModel(modelo);     //tableActivities é o nome da minha jTable
				  modelo.addColumn("ID");
				  modelo.addColumn("Nome");
				  modelo.addColumn("Especialidade Principal");
				  modelo.addColumn("Fone Fixo");
				  modelo.addColumn("Fone Celular");
			      modelo.addRow(new Object[]{"a", "c894083 24 238904238 9490238", "Clinico geral"});  
			      modelo.addRow(new Object[]{"a", "b", "c"});  
			      modelo.addRow(new Object[]{"a", "b", "c"});  

			      TableColumn col = table.getColumnModel().getColumn(0);
			      col.setMinWidth(60);
			      col.setMaxWidth(60);
			      col.setWidth(60);
			      col.setPreferredWidth(60);
			      col = table.getColumnModel().getColumn(1);
			      col.setMinWidth(200);
			      //col.setMaxWidth(200);
			      col.setWidth(200);
			      //col.setPreferredWidth(200);
			      col = table.getColumnModel().getColumn(2);
			      col.setMinWidth(150);
			      col.setMaxWidth(150);
			      col.setWidth(150);
			      //col.setPreferredWidth(200);
			      col = table.getColumnModel().getColumn(3);
			      col.setMinWidth(150);
			      col.setMaxWidth(150);
			      col.setWidth(150);
			      col.setPreferredWidth(150);
			      col = table.getColumnModel().getColumn(4);
			      col.setMinWidth(150);
			      col.setMaxWidth(150);
			      col.setWidth(150);
			      col.setPreferredWidth(150);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCadastros = new GroupLayout(pnlCadastros);
		gl_pnlCadastros.setHorizontalGroup(
			gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCadastros.createSequentialGroup()
					.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCadastros.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_pnlCadastros.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPesquisar, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_pnlCadastros.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
						.addGroup(gl_pnlCadastros.createSequentialGroup()
							.addGap(209)
							.addComponent(btnNewButton)))
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
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(btnNewButton)
					.addGap(54))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		pnlCadastros.setLayout(gl_pnlCadastros);
		
		JPanel pnlCadastrar = new JPanel();
		getContentPane().add(pnlCadastrar, "pnlCadastrar");
		
		JTabbedPane tabCadastrarMedicos = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton btnCancelar = new JButton("Cancelar");
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
		tabCadastrarMedicos.addTab("Médicos", null, tabMedicos, null);
		
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
		
		JFormattedTextField txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBounds(102, 97, 174, 26);
		tabMedicos.add(txtDataNascimento);
		
		Choice selEstadoCivil = new Choice();
		selEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		selEstadoCivil.setBounds(386, 99, 170, 21);
		tabMedicos.add(selEstadoCivil);
		
		JLabel label_4 = new JLabel("Estado Civil:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 11));
		label_4.setBounds(313, 103, 61, 14);
		tabMedicos.add(label_4);
		
		Choice selSexo = new Choice();
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
		
		Choice selEstado = new Choice();
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
		
		Choice selTipoFuncionario = new Choice();
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
		
		Checkbox checkbox = new Checkbox("Segunda-feira");
		checkbox.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox.setBounds(34, 72, 95, 22);
		tabCargaDeTrabalho.add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("Ter\u00E7a-feira");
		checkbox_1.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox_1.setBounds(34, 103, 95, 22);
		tabCargaDeTrabalho.add(checkbox_1);
		
		Checkbox checkbox_2 = new Checkbox("Quarta-feira");
		checkbox_2.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox_2.setBounds(34, 133, 95, 22);
		tabCargaDeTrabalho.add(checkbox_2);
		
		Checkbox checkbox_3 = new Checkbox("Quinta-feira");
		checkbox_3.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox_3.setBounds(34, 163, 95, 22);
		tabCargaDeTrabalho.add(checkbox_3);
		
		Checkbox checkbox_4 = new Checkbox("Sexta-feira");
		checkbox_4.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox_4.setBounds(34, 191, 95, 22);
		tabCargaDeTrabalho.add(checkbox_4);
		
		Checkbox checkbox_5 = new Checkbox("S\u00E1bado");
		checkbox_5.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox_5.setBounds(34, 222, 95, 22);
		tabCargaDeTrabalho.add(checkbox_5);
		
		Checkbox checkbox_6 = new Checkbox("Domingo");
		checkbox_6.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox_6.setBounds(34, 253, 95, 22);
		tabCargaDeTrabalho.add(checkbox_6);
		
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
		
		selTipoFuncionario.add("Selecione o tipo");
		selTipoFuncionario.add("Gerente");
		selTipoFuncionario.add("Médico");
		selTipoFuncionario.add("Recpcionista");
		
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
					btnRemEspecialidade.setVisible(true);
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
	}
	
	private void popSelectEspecialidades(Choice c) {
		c.add("Selecione a Especialdidade");
		c.add("Cardiologista");
		c.add("Clinico geral");
		c.add("Geriatra");
		c.add("Reumatologista");
		c.add("Urologista");
	}
}
