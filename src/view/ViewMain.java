package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import org.eclipse.swt.widgets.Display;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class ViewMain extends JDesktopPane {

	private JFrame JFMain;

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
					ViewMain window = new ViewMain();
					window.JFMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getJFMain() {
		return JFMain;
	}

	/**
	 * Create the application.
	 */
	public ViewMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFMain = new JFrame();
		JFMain.setTitle("SysClinic - version 1.0.0.0");
		JFMain.setBounds(100, 100, 1000, 800);
		JFMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

	
		JDesktopPane desktopPane = new JDesktopPane() {
			Image img = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
				
			@Override
			protected void paintComponent(Graphics grphcs) {
				Dimension dimension = this.getSize();
		        int dWidth = (int)dimension.getWidth();
		        int dHeight = (int)dimension.getHeight();
				super.paintComponent(grphcs);
				grphcs.drawImage(img, 0, 0, dWidth, dHeight, null);
			}
		};
		desktopPane.setToolTipText("d");
		desktopPane.setBackground(SystemColor.activeCaptionBorder);
		JFMain.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		JFMain.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mnCadastros_Pacientes = new JMenuItem("Pacientes");
		mnCadastros_Pacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCadastrosPacientes viewCadastrosPacientes = new ViewCadastrosPacientes();
				desktopPane.add(viewCadastrosPacientes);
				viewCadastrosPacientes.setVisible(true);
				BasicInternalFrameUI ui = (BasicInternalFrameUI) viewCadastrosPacientes.getUI(); 
				Container norte = (Container) ui.getNorthPane(); 
				norte.remove (0); 
				norte.validate (); 
				norte.repaint ();
			}
		});
		mnCadastros.add(mnCadastros_Pacientes);
		
		JMenuItem mnCadastros_profissionaisMedicos = new JMenuItem("Profissionais / M\u00E9dicos");
		mnCadastros_profissionaisMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCadastrosFuncionarios viewCadastrosFuncionarios = new ViewCadastrosFuncionarios();
				desktopPane.add(viewCadastrosFuncionarios);
				viewCadastrosFuncionarios.setVisible(true);
				BasicInternalFrameUI ui = (BasicInternalFrameUI) viewCadastrosFuncionarios.getUI(); 
				Container norte = (Container) ui.getNorthPane(); 
				norte.remove (0); 
				norte.validate (); 
				norte.repaint ();
			}
		});
		mnCadastros.add(mnCadastros_profissionaisMedicos);
		
		JMenuItem mnCadastros_usuariosPermissoesAcesso = new JMenuItem("Usu\u00E1rios / Permiss\u00F5es de acesso");
		mnCadastros_usuariosPermissoesAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrosUsuarios viewCadastrosUsuarios = new ViewCadastrosUsuarios();
				desktopPane.add(viewCadastrosUsuarios);
				viewCadastrosUsuarios.setVisible(true);
				BasicInternalFrameUI ui = (BasicInternalFrameUI) viewCadastrosUsuarios.getUI(); 
				Container norte = (Container) ui.getNorthPane(); 
				norte.remove (0); 
				norte.validate (); 
				norte.repaint ();
			}
		});
		mnCadastros.add(mnCadastros_usuariosPermissoesAcesso);
		
		JMenu mnNewMenu_1 = new JMenu("Recep\u00E7\u00E3o");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnAgendamento = new JMenu("Agendamento");
		menuBar.add(mnAgendamento);
		
		JMenuItem mntmAgendaDosProfissionais = new JMenuItem("Agenda dos profissionais");
		mnAgendamento.add(mntmAgendaDosProfissionais);
		
		JMenu mnNewMenu_2 = new JMenu("Atendimento");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		/*
		 * Icons menu
		 */
		mnCadastros_Pacientes.setIcon(new ImageIcon(this.getClass().getResource("/group.png")));
		mnCadastros_profissionaisMedicos.setIcon(new ImageIcon(this.getClass().getResource("/status_offline.png")));
		mnCadastros_usuariosPermissoesAcesso.setIcon(new ImageIcon(this.getClass().getResource("/user_green.png")));
	}

}
