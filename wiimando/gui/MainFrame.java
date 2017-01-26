package wiimando.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import wiimando.model.WiiMando;
import wiimando.model.XMLReader;
import wiiremotej.WiiRemote;

/**
 * The Class MainFrame. Responsible for building the GUI.
 * 
 * @author Boris Júnior
 * @author Jorge Pereira
 * @version 2009/10/19
 */
public class MainFrame {

	protected JButton disconnectButton, connectButton;
	private JCheckBox vMovCB, hMovCB;
	private JPanel checkBoxPanel;
	private JLabel connectionStateLabel, informationLabel;
	private WiiMando wiimando;
	private WiiRemote remote;
	private JMenuBar menuBar;
	private JMenu configMenu, helpMenu;
	private JMenuItem buttonConfigItem, urlConfigItem, speedConfigItem;
	private JMenuItem helpItem, aboutItem;
	private JPanel menuPanel, infoPanel, connectionStatePanel, buttonsPanel;
	private JTextArea urlTextArea;
	private JFrame mainFrame, urlFrame, buttonsFrame;
	private JComboBox comboBoxA, comboBoxB, comboBoxHome, comboBoxPlus,
			comboBoxMinus;
	private JComboBox comboBoxAPlus, comboBoxBPlus, comboBoxHomePlus,
			comboBoxPlusPlus;
	private JComboBox comboBoxMinusPlus, comboBoxUp, comboBoxDown,
			comboBoxRight, comboBoxLeft;
	private JComboBox comboBoxOne, comboBoxTwo, comboBoxUpPlus,
			comboBoxDownPlus;
	private JComboBox comboBoxRightPlus, comboBoxLeftPlus, comboBoxOnePlus,
			comboBoxTwoPlus;
	private Thread t;
	private JSlider fastSpeedSlider, slowSpeedSlider;
	private XMLReader xmlReader;
	private JFrame mouseSpeedFrame;
	@SuppressWarnings("unused")
	private Icon connectIcon, disconnectIcon, checkIcon, crossIcon, infoIcon,
			warnIcon, waitIcon, calibrationIcon;
	private List<String> comboboxList;
	private JMenuItem calibrationConfigItem;
	private JFrame calibrationFrame;
	private double xCalibration, yCalibration, zCalibration;
	private JSpinner xSpinner, ySpinner, zSpinner;
	private SpinnerNumberModel xSpinnerModel;
	private SpinnerNumberModel ySpinnerModel;
	private SpinnerNumberModel zSpinnerModel;
	private boolean configurationState;
	private static final int RUN_PORT = 9666;

	// use an obscure port

	/**
	 * Instantiates a new main frame.
	 */
	public MainFrame() {
		this.comboboxList = new ArrayList<String>();
		this.wiimando = new WiiMando(remote);
		this.xmlReader = wiimando.getXMLReaderObj();
		this.mainFrame = new JFrame("WiiMando");
		this.configurationState = false;

		this.calibrationIcon = new ImageIcon("icons" + File.separator
				+ "config_16x16.png");
		this.checkIcon = new ImageIcon("icons" + File.separator
				+ "16-em-check.png");
		this.waitIcon = new ImageIcon("icons" + File.separator + "wait3.gif");
		this.crossIcon = new ImageIcon("icons" + File.separator
				+ "16-em-cross.png");
		this.infoIcon = new ImageIcon("icons" + File.separator
				+ "16-message-info.png");
		this.warnIcon = new ImageIcon("icons" + File.separator
				+ "icon_alert.gif");
		this.connectIcon = new ImageIcon("icons" + File.separator
				+ "16-circle-green.png");
		this.disconnectIcon = new ImageIcon("icons" + File.separator
				+ "16-circle-red.png");
	}

	/**
	 * Builds the main interface.
	 */
	public void buildMainInterface() {

		this.mainFrame.setLayout(new BorderLayout());
		this.mainFrame.setIconImage(new ImageIcon("icons" + File.separator
				+ "remote.png").getImage());

		Font font = new Font("Dialog", Font.PLAIN, 12);

		TitledBorder connectionStateBorder = BorderFactory
				.createTitledBorder("Estado");
		Border btnActionBorder = BorderFactory.createTitledBorder("Acção");
		Border menuBorder = BorderFactory.createTitledBorder("");
		Border infoBorder = BorderFactory.createTitledBorder("Informação");

		this.menuPanel = new JPanel();
		this.connectionStatePanel = new JPanel();
		this.buttonsPanel = new JPanel();
		this.infoPanel = new JPanel();

		this.buttonsPanel.setBorder(btnActionBorder);
		this.connectionStatePanel.setBorder(connectionStateBorder);
		this.menuPanel.setBorder(menuBorder);
		this.infoPanel.setBorder(infoBorder);

		this.menuPanel.setLayout(new BorderLayout());
		this.connectionStatePanel.setLayout(new BorderLayout());
		this.infoPanel.setLayout(new BorderLayout());

		this.menuBar = new JMenuBar();

		this.configMenu = new JMenu("Configurar");
		this.configMenu.setMnemonic(KeyEvent.VK_C);

		this.buttonConfigItem = new JMenuItem("Botões", KeyEvent.VK_B);
		this.buttonConfigItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_B, Event.ALT_MASK));

		this.urlConfigItem = new JMenuItem("Página Inicial", KeyEvent.VK_P);
		this.urlConfigItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				Event.ALT_MASK));

		this.calibrationConfigItem = new JMenuItem("Calibração", KeyEvent.VK_L);
		this.calibrationConfigItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_L, Event.ALT_MASK));

		this.speedConfigItem = new JMenuItem("Movimento do ponteiro",
				KeyEvent.VK_O);
		this.speedConfigItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, Event.ALT_MASK));

		this.configMenu.add(this.buttonConfigItem);
		this.configMenu.add(this.calibrationConfigItem);
		this.configMenu.add(this.speedConfigItem);
		this.configMenu.add(this.urlConfigItem);
		this.menuBar.add(this.configMenu);

		this.helpMenu = new JMenu("Ajuda");
		this.helpMenu.setMnemonic(KeyEvent.VK_A);
		this.menuBar.add(this.helpMenu);

		this.helpItem = new JMenuItem("Conteúdos de Ajuda");
		this.helpItem.setIcon(new ImageIcon("icons" + File.separator
				+ "Help.gif"));
		this.helpItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Runtime
							.getRuntime()
							.exec(
									"rundll32 url.dll,FileProtocolHandler Ajuda WiiMando.chm");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		this.helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
				Event.ALT_MASK));
		this.aboutItem = new JMenuItem("Acerca do WiiMando", KeyEvent.VK_A);
		this.helpMenu.add(helpItem);
		this.helpMenu.add(aboutItem);

		this.buttonConfigItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (wiimando.isConnected() == true) {
					JOptionPane pane = new JOptionPane(
							"Para alterar a configuração, o comando será "
									+ "desligado. \nPretende continuar?");
					Object[] options = new String[] { "Sim", "Não" };
					pane.setOptions(options);
					JDialog dialog = pane.createDialog(new JFrame(),
							"Configuração de botões");
					dialog.show();
					Object obj = pane.getValue();
					int result = -1;
					for (int k = 0; k < options.length; k++)
						if (options[k].equals(obj))
							result = k;
					if (result == 0) {
						MainFrame.this.configurationState = true;
						MainFrame.this.wiimando.disconnect();
						MainFrame.this.updateConnection();
						MainFrame.this.buildButtonConfigWindow();
					} else {
						// close dialog
					}

				} else {
					MainFrame.this.buildButtonConfigWindow();
				}
			}
		});

		this.urlConfigItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if (wiimando.isConnected() == true) {
					JOptionPane pane = new JOptionPane(
							"Para alterar a configuração, o comando será "
									+ "desligado. \nPretende continuar?");
					Object[] options = new String[] { "Sim", "Não" };
					pane.setOptions(options);
					JDialog dialog = pane.createDialog(new JFrame(),
							"Configuração de botões");
					dialog.show();
					Object obj = pane.getValue();
					int result = -1;
					for (int k = 0; k < options.length; k++)
						if (options[k].equals(obj))
							result = k;
					if (result == 0) {
						MainFrame.this.configurationState = true;
						MainFrame.this.wiimando.disconnect();
						MainFrame.this.updateConnection();
						MainFrame.this.buildUrlWindow();
					} else {
						// close dialog
					}

				} else {
					MainFrame.this.buildUrlWindow();
				}
			}
		});

		this.calibrationConfigItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if (wiimando.isConnected() == true) {
					JOptionPane pane = new JOptionPane(
							"Para alterar a configuração, o comando será "
									+ "desligado. \nPretende continuar?");
					Object[] options = new String[] { "Sim", "Não" };
					pane.setOptions(options);
					JDialog dialog = pane.createDialog(new JFrame(),
							"Configuração de botões");
					dialog.show();
					Object obj = pane.getValue();
					int result = -1;
					for (int k = 0; k < options.length; k++)
						if (options[k].equals(obj))
							result = k;
					if (result == 0) {
						MainFrame.this.configurationState = true;
						MainFrame.this.wiimando.disconnect();
						MainFrame.this.updateConnection();
						MainFrame.this.buildMouseMovementWin();
					} else {
						// close dialog
					}

				} else {
					MainFrame.this.buildCalibrationWin();
				}

			}
		});

		this.speedConfigItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if (wiimando.isConnected() == true) {
					JOptionPane pane = new JOptionPane(
							"Para alterar a configuração, o comando será "
									+ "desligado. \nPretende continuar?");
					Object[] options = new String[] { "Sim", "Não" };
					pane.setOptions(options);
					JDialog dialog = pane.createDialog(new JFrame(),
							"Configuração de botões");
					dialog.show();
					Object obj = pane.getValue();
					int result = -1;
					for (int k = 0; k < options.length; k++)
						if (options[k].equals(obj))
							result = k;
					if (result == 0) {
						MainFrame.this.configurationState = true;
						MainFrame.this.wiimando.disconnect();
						MainFrame.this.updateConnection();
						MainFrame.this.buildMouseMovementWin();
					} else {
						// close dialog
					}

				} else {
					MainFrame.this.buildMouseMovementWin();
				}

			}
		});
		this.aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.aboutWindow();
			}
		});

		this.connectionStateLabel = new JLabel("Desligado");
		this.connectionStateLabel.setFont(font);
		this.connectionStateLabel.setIcon(this.crossIcon);

		this.informationLabel = new JLabel("Clique em ligar");
		this.informationLabel.setFont(font);
		this.informationLabel.setIcon(this.infoIcon);

		this.connectButton = new JButton("Ligar", this.connectIcon);
		this.connectButton.setMnemonic(KeyEvent.VK_E);
		this.connectButton.setActionCommand("enable");
		this.connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrame.this.disconnectButton.setEnabled(false);
				MainFrame.this.connectButton.setEnabled(false);

				MainFrame.this.t = new Thread(new Runnable() {

					public void run() {
						MainFrame.this.wiimando.connect(MainFrame.this);
					}
				});
				MainFrame.this.t.start();
				if (MainFrame.this.isConnected() == true) {

					MainFrame.this.connectionStateLabel.setText("Ligado");
					MainFrame.this.connectionStateLabel.setIcon(checkIcon);

				} else {
					MainFrame.this.connectionStateLabel.setText("Desligado");
					MainFrame.this.connectionStateLabel.setIcon(crossIcon);
				}
			}
		});

		this.disconnectButton = new JButton("Desligar", this.disconnectIcon);
		this.disconnectButton.setVerticalTextPosition(AbstractButton.CENTER);
		this.disconnectButton.setHorizontalTextPosition(AbstractButton.LEADING);
		this.disconnectButton.setEnabled(false);
		this.disconnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (MainFrame.this.isConnected() == true) {

					MainFrame.this.wiimando.disconnect();
					MainFrame.this.disconnectButton.setEnabled(false);
					MainFrame.this.connectButton.setEnabled(true);
					MainFrame.this.connectionStateLabel.setText("Desligado");
					MainFrame.this.connectionStateLabel.setIcon(crossIcon);
					MainFrame.this.informationLabel
							.setText("Desligado pelo utilizador");
				}
			}
		});

		this.disconnectButton
				.setToolTipText("Clique neste botão para desligar do comando");
		this.connectButton
				.setToolTipText("Clique neste botão para ligar ao comando");

		final JSplitPane jSplitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, connectionStatePanel, infoPanel);
		jSplitPane.setContinuousLayout(true);

		this.menuPanel.add(menuBar);
		this.connectionStatePanel.add(this.connectionStateLabel);
		this.infoPanel.add(this.informationLabel);
		this.buttonsPanel.add(this.connectButton);
		this.buttonsPanel.add(this.disconnectButton);

		this.mainFrame.add(this.menuPanel, BorderLayout.NORTH);
		this.mainFrame.getContentPane().add(jSplitPane);
		this.mainFrame.add(this.buttonsPanel, BorderLayout.SOUTH);
		this.mainFrame.addWindowListener(listener);
		this.mainFrame.setSize(390, 175);
		this.centerWindow(mainFrame);
		this.mainFrame.setResizable(false);
		this.mainFrame.setVisible(true);
	}

	/**
	 * Centers the dialog windows within the screen.
	 */
	public void centerWindow(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle abounds = frame.getBounds();
		frame.setLocation((dim.width / 2) - (abounds.width / 2),
				(dim.height / 2) - (abounds.height / 2));
		frame.requestFocus();
	}

	/**
	 * Builds the about window.
	 */
	public void aboutWindow() {
		String t = "Acerca do WiiMando";
		String s = "Versão 1.0 (09/11/2009)\n"
				+ "\nDesenvolvido por:\nBoris Júnior & Jorge Pereira"
				+ "\n\nEscola Superior de Tecnologia e Gestão de Beja"
				+ "\n2008/2009" + "\n\nBibliotecas utilizadas:"
				+ "\nWiiRemotej 1.6" + "\nBluecove 2.1.0";

		JOptionPane.showMessageDialog(null, s, t,
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Builds the acceleration calibration window.
	 */
	public void buildCalibrationWin() {

		this.calibrationFrame = new JFrame("WiiMando - Calibração");

		this.calibrationFrame.setIconImage(new ImageIcon("icons"
				+ File.separator + "scope.png").getImage());

		Double currentX = this.xmlReader.getXCalibration();
		Double currentY = this.xmlReader.getYCalibration();
		Double currentZ = this.xmlReader.getZCalibration();

		Double min = new Double(-20.0);
		Double max = new Double(20.0);
		Double step = new Double(0.01);

		this.xSpinnerModel = new SpinnerNumberModel(currentX, min, max, step);
		this.xSpinner = new JSpinner(this.xSpinnerModel);
		this.xSpinner.setPreferredSize(new Dimension(50, 20));

		this.ySpinnerModel = new SpinnerNumberModel(currentY, min, max, step);
		this.ySpinner = new JSpinner(this.ySpinnerModel);
		this.ySpinner.setPreferredSize(new Dimension(50, 20));

		this.zSpinnerModel = new SpinnerNumberModel(currentZ, min, max, step);
		this.zSpinner = new JSpinner(this.zSpinnerModel);
		this.zSpinner.setPreferredSize(new Dimension(50, 20));

		JLabel xLabel = new JLabel("X =");
		JPanel xPanel = new JPanel(new BorderLayout());
		xPanel.add(xLabel, BorderLayout.WEST);
		xPanel.add(this.xSpinner, BorderLayout.CENTER);

		JLabel yLabel = new JLabel("Y =");
		JPanel yPanel = new JPanel(new BorderLayout());
		yPanel.add(yLabel, BorderLayout.WEST);
		yPanel.add(this.ySpinner, BorderLayout.CENTER);

		JLabel zLabel = new JLabel("Z =");
		JPanel zPanel = new JPanel(new BorderLayout());
		zPanel.add(zLabel, BorderLayout.WEST);
		zPanel.add(this.zSpinner, BorderLayout.CENTER);

		JPanel calibrationPanel = new JPanel();
		calibrationPanel.add(xPanel, BorderLayout.NORTH);
		calibrationPanel.add(yPanel, BorderLayout.CENTER);
		calibrationPanel.add(zPanel, BorderLayout.SOUTH);

		JButton cancelButton = new JButton("Cancelar");
		JButton saveButton = new JButton("Guardar");

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrame.this.xCalibration = ((SpinnerNumberModel) MainFrame.this.xSpinnerModel)
						.getNumber().doubleValue();
				MainFrame.this.yCalibration = ((SpinnerNumberModel) MainFrame.this.ySpinnerModel)
						.getNumber().doubleValue();
				MainFrame.this.zCalibration = ((SpinnerNumberModel) MainFrame.this.zSpinnerModel)
						.getNumber().doubleValue();

				MainFrame.this.xmlReader.saveCalibrationValues(
						MainFrame.this.xCalibration,
						MainFrame.this.yCalibration,
						MainFrame.this.zCalibration);

				MainFrame.this.configurationState = false;
				MainFrame.this.calibrationFrame.setVisible(false);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrame.this.calibrationFrame.setVisible(false);
			}
		});

		JPanel buttonsPanel = new JPanel();

		buttonsPanel.add(saveButton);
		buttonsPanel.add(cancelButton);

		JButton helpButton = new JButton("Informação", infoIcon);
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String t = "Calibração do Comando";
				String s = "Com o comando em repouso,"
						+ "\ndeverá alterar os valores até que "
						+ "o ponteiro do rato esteja parado.";

				JOptionPane.showMessageDialog(null, s, t,
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JPanel helpPanel = new JPanel(new BorderLayout());
		helpPanel.add(helpButton, BorderLayout.CENTER);

		this.calibrationFrame.add(helpPanel, BorderLayout.NORTH);
		this.calibrationFrame.add(calibrationPanel, BorderLayout.CENTER);
		this.calibrationFrame.add(buttonsPanel, BorderLayout.SOUTH);

		this.calibrationFrame.setSize(250, 125);

		this.centerWindow(this.calibrationFrame);
		this.calibrationFrame.setVisible(true);
	}

	/**
	 * Builds the mouse pointer movement window. Configures both orientation and
	 * speed.
	 */
	public void buildMouseMovementWin() {

		this.mouseSpeedFrame = new JFrame("Movimento do Ponteiro");
		this.mouseSpeedFrame.setIconImage(new ImageIcon("icons"
				+ File.separator + "icon_pointer.png").getImage());

		this.fastSpeedSlider = new JSlider();
		this.slowSpeedSlider = new JSlider();

		JButton cancelButton = new JButton("Cancelar");
		JButton saveButton = new JButton("Guardar");

		this.slowSpeedSlider.setBorder(BorderFactory
				.createTitledBorder("Movimentos Lentos"));
		this.slowSpeedSlider.setValue(this.wiimando.getPointerSlowSpeed());
		this.slowSpeedSlider.setMajorTickSpacing(1);
		this.slowSpeedSlider.setMinorTickSpacing(1);
		this.slowSpeedSlider.setMinimum(3);
		this.slowSpeedSlider.setMaximum(5);
		this.slowSpeedSlider.setPaintTicks(true);

		this.fastSpeedSlider.setBorder(BorderFactory
				.createTitledBorder("Movimentos Rápidos"));
		this.fastSpeedSlider.setValue(this.wiimando.getPointerFastSpeed());
		this.fastSpeedSlider.setMajorTickSpacing(2);
		this.fastSpeedSlider.setMinorTickSpacing(1);
		this.fastSpeedSlider.setMinimum(6);
		this.fastSpeedSlider.setMaximum(25);
		this.fastSpeedSlider.setPaintTicks(true);

		JPanel speedPanel = new JPanel();

		speedPanel.setBorder(BorderFactory
				.createTitledBorder("Velocidade do Ponteiro"));

		speedPanel.add(slowSpeedSlider);
		speedPanel.add(fastSpeedSlider);

		this.mouseSpeedFrame.add(speedPanel, BorderLayout.NORTH);

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrame.this.xmlReader.saveXMLSpeedConfig(fastSpeedSlider
						.getValue(), slowSpeedSlider.getValue());

				MainFrame.this.xmlReader.saveXMLMovConfig(vMovCB.isSelected(),
						hMovCB.isSelected());

				MainFrame.this.mouseSpeedFrame.setVisible(false);
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrame.this.mouseSpeedFrame.setVisible(false);
			}
		});

		this.checkBoxPanel = new JPanel();
		this.vMovCB = new JCheckBox("Inverter Movimento Vertical",
				this.xmlReader.getXMLVertInv());
		this.hMovCB = new JCheckBox("Inverter Movimento Horizontal",
				this.xmlReader.getXMLHorInv());

		this.checkBoxPanel.add(this.vMovCB);
		this.checkBoxPanel.add(this.hMovCB);

		this.mouseSpeedFrame.add(this.checkBoxPanel, BorderLayout.CENTER);

		JPanel buttonsPanel = new JPanel();

		buttonsPanel.add(saveButton);
		buttonsPanel.add(cancelButton);

		mouseSpeedFrame.add(buttonsPanel, BorderLayout.SOUTH);
		mouseSpeedFrame.pack();
		this.centerWindow(mouseSpeedFrame);
		mouseSpeedFrame.setVisible(true);
	}

	/**
	 * Builds the URL configuration window.
	 */
	public void buildUrlWindow() {

		JPanel p0 = new JPanel();
		JPanel p1 = new JPanel();

		this.urlFrame = new JFrame("Definir Página Inicial");

		this.urlFrame.setIconImage(new ImageIcon("icons" + File.separator
				+ "icon_home.gif").getImage());

		JLabel urlLabel = new JLabel("Página Inicial: ");
		this.urlTextArea = new JTextArea(this.xmlReader.getXMLUrl(), 2, 25);

		JButton cancelButton = new JButton("Cancelar");
		JButton saveButton = new JButton("Guardar");

		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(this.urlTextArea, v, h);

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainFrame.this.xmlReader
						.saveXMLUrlConfig(MainFrame.this.urlTextArea.getText());
				MainFrame.this.urlFrame.setVisible(false);

			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.urlFrame.setVisible(false);

			}
		});

		p0.add(urlLabel);
		p0.add(jsp);
		p1.add(saveButton);
		p1.add(cancelButton);

		this.urlFrame.add(p0, BorderLayout.NORTH);
		this.urlFrame.add(p1, BorderLayout.SOUTH);

		this.urlFrame.pack();
		this.centerWindow(urlFrame);
		this.urlFrame.setVisible(true);
		this.urlFrame.setResizable(false);
	}

	/**
	 * Builds the button configuration window.
	 */
	public void buildButtonConfigWindow() {

		this.configurationState = true;

		this.buttonsFrame = new JFrame("Configuração Actual - "
				+ this.xmlReader.getXMLLastLoadedFile());

		this.buttonsFrame.setIconImage(new ImageIcon("icons" + File.separator
				+ "configuration-16x16.png").getImage());

		JPanel simplePanel = new JPanel();
		JPanel comboPanel = new JPanel();

		simplePanel.setLayout(new GridLayout(11, 0));
		comboPanel.setLayout(new GridLayout(11, 0));

		Border simpleBtnborder = BorderFactory.createTitledBorder("Simples");
		Border comboBtnborder = BorderFactory.createTitledBorder("Combinações");

		JLabel a = new JLabel("A");
		JLabel b = new JLabel("B");
		JLabel home = new JLabel("HOME");
		JLabel plus = new JLabel("MAIS");
		JLabel minus = new JLabel("MENOS");
		JLabel up = new JLabel("CIMA");
		JLabel down = new JLabel("BAIXO");
		JLabel right = new JLabel("DIREITA");
		JLabel left = new JLabel("ESQUERDA");
		JLabel one = new JLabel("UM");
		JLabel two = new JLabel("DOIS");

		String[] str = { "Combinação", "Clique Esquerdo", "Clique Direito",
				"Home", "End", "Tab", "Enter", "Retroceder", "Avançar",
				"Abrir Separador", "Fechar Separador", "Cima", "Baixo",
				"Esquerda", "Direita", "Aumentar Tamanho do Texto",
				"Diminuir Tamanho do Texto", "Clique Esquerdo Continuo",
				"Abrir Página Inicial", "Sair", "Abrir Marcadores" };

		JLabel aPlus = new JLabel("Combinação + A");
		JLabel bPlus = new JLabel("Combinação + B");
		JLabel homePlus = new JLabel("Combinação + HOME");
		JLabel plusPlus = new JLabel("Combinação + MAIS");
		JLabel minusPlus = new JLabel("Combinação + MENOS");
		JLabel upPlus = new JLabel("Combinação + CIMA");
		JLabel downPlus = new JLabel("Combinação + BAIXO");
		JLabel rightPlus = new JLabel("Combinação + DIREITA");
		JLabel leftPlus = new JLabel("Combinação + ESQUERDA");
		JLabel onePlus = new JLabel("Combinação + UM");
		JLabel twoPlus = new JLabel("Combinação + DOIS");

		String[] strPlus = { "", "Clique Esquerdo", "Clique Direito", "Home",
				"End", "Tab", "Enter", "Retroceder", "Avançar",
				"Abrir Separador", "Fechar Separador", "Cima", "Baixo",
				"Esquerda", "Direita", "Aumentar Tamanho do Texto",
				"Diminuir Tamanho do Texto", "Clique Esquerdo Continuo",
				"Abrir Página Inicial", "Sair", "Abrir Marcadores" };

		this.comboBoxA = new JComboBox(str);
		this.comboBoxB = new JComboBox(str);
		this.comboBoxHome = new JComboBox(str);
		this.comboBoxPlus = new JComboBox(str);
		this.comboBoxMinus = new JComboBox(str);
		this.comboBoxUp = new JComboBox(str);
		this.comboBoxDown = new JComboBox(str);
		this.comboBoxRight = new JComboBox(str);
		this.comboBoxLeft = new JComboBox(str);
		this.comboBoxOne = new JComboBox(str);
		this.comboBoxTwo = new JComboBox(str);

		this.comboBoxAPlus = new JComboBox(strPlus);
		this.comboBoxBPlus = new JComboBox(strPlus);
		this.comboBoxHomePlus = new JComboBox(strPlus);
		this.comboBoxPlusPlus = new JComboBox(strPlus);
		this.comboBoxMinusPlus = new JComboBox(strPlus);
		this.comboBoxUpPlus = new JComboBox(strPlus);
		this.comboBoxDownPlus = new JComboBox(strPlus);
		this.comboBoxRightPlus = new JComboBox(strPlus);
		this.comboBoxLeftPlus = new JComboBox(strPlus);
		this.comboBoxOnePlus = new JComboBox(strPlus);
		this.comboBoxTwoPlus = new JComboBox(strPlus);

		this.comboBoxA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxA.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxAPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxAPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxAPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxB.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxBPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxBPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxBPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxDown.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxDownPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxDownPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxDownPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxHome.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxHomePlus.setSelectedIndex(0);
					MainFrame.this.comboBoxHomePlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxHomePlus.setEnabled(true);
				}
			}
		});

		this.comboBoxLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxLeft.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxLeftPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxLeftPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxLeftPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxMinus.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxMinusPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxMinusPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxMinusPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxOne.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxOnePlus.setSelectedIndex(0);
					MainFrame.this.comboBoxOnePlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxOnePlus.setEnabled(true);
				}
			}
		});

		this.comboBoxPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxPlus.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxPlusPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxPlusPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxPlusPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxRight.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxRightPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxRightPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxRightPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxTwo.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxTwoPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxTwoPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxTwoPlus.setEnabled(true);
				}
			}
		});

		this.comboBoxUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.this.comboBoxUp.getSelectedIndex() == 0) {
					MainFrame.this.comboBoxUpPlus.setSelectedIndex(0);
					MainFrame.this.comboBoxUpPlus.setEnabled(false);
				} else {
					MainFrame.this.comboBoxUpPlus.setEnabled(true);
				}
			}
		});

		JButton cancelButton = new JButton("Fechar");
		JButton openButton = new JButton("Abrir...");
		JButton resetButton = new JButton("Predefinição");
		JButton saveButton = new JButton("Guardar");
		JButton saveAsButton = new JButton("Guardar como...");

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.buttonsFrame.setVisible(false);
				MainFrame.this.buttonsFrame.dispose();

			}
		});

		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fc
						.setFileFilter(new FileNameExtensionFilter("XML files",
								"xml"));

				try {
					int returnVal = fc
							.showOpenDialog(MainFrame.this.buttonsFrame);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						if (file.getName().endsWith(".xml")) {
							System.out.println("LastLoadedFile: "
									+ MainFrame.this.xmlReader
											.getLastLoadedFile());

							MainFrame.this.xmlReader
									.saveXMLLastLoadedFileConfig(file
											.getAbsolutePath());

							JOptionPane.showMessageDialog(
									MainFrame.this.buttonsFrame, file
											.getAbsolutePath(),
									"Configuração carregada com sucesso",
									JOptionPane.INFORMATION_MESSAGE);

							MainFrame.this.xmlReader
									.getXMLConfiguration(MainFrame.this.xmlReader
											.getXMLLastLoadedFile());

							MainFrame.this.xmlReader
									.getXMLConfiguration(MainFrame.this.xmlReader
											.getXMLLastLoadedFile());

							MainFrame.this.showConfiguration();

							MainFrame.this.buttonsFrame
									.setTitle("Configuração Actual - "
											+ MainFrame.this.xmlReader
													.getXMLLastLoadedFile());
						} else {
							JOptionPane.showMessageDialog(
									MainFrame.this.buttonsFrame,
									"Ficheiro escolhido é incorrecto."
											+ " Por favor seleccione um "
											+ "ficheiro do tipo .xml.", "Erro",
									JOptionPane.ERROR_MESSAGE);
						}

					}

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(MainFrame.this.buttonsFrame,
							"Não foi possível guardar a configuração", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainFrame.this.buttonsFrame,
						"Configuração por defeito carregada com sucesso", "",
						JOptionPane.INFORMATION_MESSAGE);

				MainFrame.this.xmlReader.saveXMLDefaultButtonsConfig();

				MainFrame.this.xmlReader
						.getXMLConfiguration(MainFrame.this.xmlReader
								.getXMLLastLoadedFile());

				MainFrame.this.showConfiguration();

				MainFrame.this.buttonsFrame
						.setTitle("Configuração Actual - Pré-definida");
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (MainFrame.this.isFunctionRepeated() == false) {
					try {
						MainFrame.this.xmlReader.saveXMLButtonsConfig(
								MainFrame.this, MainFrame.this.xmlReader
										.getLastLoadedFile());
						MainFrame.this.xmlReader
								.getXMLConfiguration(MainFrame.this.xmlReader
										.getLastLoadedFile());
						JOptionPane.showMessageDialog(
								MainFrame.this.buttonsFrame,
								"Configuração guardada com sucesso", "",
								JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(
								MainFrame.this.buttonsFrame,
								"Não foi possível guardar a configuração",
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(MainFrame.this.buttonsFrame,
							"Existem botões com funções repetidas", "",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		saveAsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create a file chooser
				if (MainFrame.this.isFunctionRepeated() == false) {
					JFileChooser fc = new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					fc.setFileFilter(new FileNameExtensionFilter("XML files",
							"xml"));

					try {
						int returnVal = fc
								.showSaveDialog(MainFrame.this.buttonsFrame);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							if (file.getName().endsWith(".xml")) {
								MainFrame.this.xmlReader.saveXMLButtonsConfig(
										MainFrame.this, file.getAbsolutePath());
								JOptionPane.showMessageDialog(
										MainFrame.this.buttonsFrame, file
												.getAbsolutePath(),
										"Configuração guardada com sucesso",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								MainFrame.this.xmlReader.saveXMLButtonsConfig(
										MainFrame.this, file.getAbsolutePath()
												+ ".xml");
								JOptionPane.showMessageDialog(
										MainFrame.this.buttonsFrame, file
												.getAbsolutePath()
												+ ".xml",
										"Configuração guardada com sucesso",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(
								MainFrame.this.buttonsFrame,
								"Não foi possível guardar a configuração",
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(MainFrame.this.buttonsFrame,
							"Existem botões com funções repetidas", "",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JPanel buttonPanel = new JPanel();

		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(saveAsButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(cancelButton);

		simplePanel.add(a);
		simplePanel.add(comboBoxA);
		simplePanel.add(b);
		simplePanel.add(comboBoxB);
		simplePanel.add(home);
		simplePanel.add(comboBoxHome);
		simplePanel.add(plus);
		simplePanel.add(comboBoxPlus);
		simplePanel.add(minus);
		simplePanel.add(comboBoxMinus);
		simplePanel.add(up);
		simplePanel.add(comboBoxUp);
		simplePanel.add(down);
		simplePanel.add(comboBoxDown);
		simplePanel.add(left);
		simplePanel.add(comboBoxLeft);
		simplePanel.add(right);
		simplePanel.add(comboBoxRight);
		simplePanel.add(one);
		simplePanel.add(comboBoxOne);
		simplePanel.add(two);
		simplePanel.add(comboBoxTwo);

		comboPanel.add(aPlus);
		comboPanel.add(comboBoxAPlus);
		comboPanel.add(bPlus);
		comboPanel.add(comboBoxBPlus);
		comboPanel.add(homePlus);
		comboPanel.add(comboBoxHomePlus);
		comboPanel.add(plusPlus);
		comboPanel.add(comboBoxPlusPlus);
		comboPanel.add(minusPlus);
		comboPanel.add(comboBoxMinusPlus);
		comboPanel.add(upPlus);
		comboPanel.add(comboBoxUpPlus);
		comboPanel.add(downPlus);
		comboPanel.add(comboBoxDownPlus);
		comboPanel.add(leftPlus);
		comboPanel.add(comboBoxLeftPlus);
		comboPanel.add(rightPlus);
		comboPanel.add(comboBoxRightPlus);
		comboPanel.add(onePlus);
		comboPanel.add(comboBoxOnePlus);
		comboPanel.add(twoPlus);
		comboPanel.add(comboBoxTwoPlus);

		MainFrame.this.xmlReader.getXMLConfiguration(MainFrame.this.xmlReader
				.getXMLLastLoadedFile());
		this.showConfiguration();

		simplePanel.setBorder(simpleBtnborder);
		comboPanel.setBorder(comboBtnborder);

		final JSplitPane jSplitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, simplePanel, comboPanel);
		jSplitPane.setContinuousLayout(true);
		this.buttonsFrame.getContentPane().add(jSplitPane);

		this.buttonsFrame.add(buttonPanel, BorderLayout.SOUTH);

		this.buttonsFrame.pack();
		this.centerWindow(this.buttonsFrame);
		this.buttonsFrame.setVisible(true);
		this.buttonsFrame.setResizable(false);
	}

	/**
	 * Shows the current configuration in the comboboxes.
	 */
	public void showConfiguration() {

		this.comboBoxA.setSelectedIndex(this.xmlReader.getComboBoxAIndex());
		this.comboBoxB.setSelectedIndex(this.xmlReader.getComboBoxBIndex());
		this.comboBoxHome.setSelectedIndex(this.xmlReader
				.getComboBoxHomeIndex());
		this.comboBoxPlus.setSelectedIndex(this.xmlReader
				.getComboBoxPlusIndex());
		this.comboBoxMinus.setSelectedIndex(this.xmlReader
				.getComboBoxMinusIndex());
		this.comboBoxUp.setSelectedIndex(this.xmlReader.getComboBoxUpIndex());
		this.comboBoxDown.setSelectedIndex(this.xmlReader
				.getComboBoxDownIndex());
		this.comboBoxLeft.setSelectedIndex(this.xmlReader
				.getComboBoxLeftIndex());
		this.comboBoxRight.setSelectedIndex(this.xmlReader
				.getComboBoxRightIndex());
		this.comboBoxOne.setSelectedIndex(this.xmlReader.getComboBoxOneIndex());
		this.comboBoxTwo.setSelectedIndex(this.xmlReader.getComboBoxTwoIndex());

		this.comboBoxAPlus.setSelectedIndex(this.xmlReader
				.getComboBoxAPlusIndex());
		this.comboBoxBPlus.setSelectedIndex(this.xmlReader
				.getComboBoxBPlusIndex());
		this.comboBoxHomePlus.setSelectedIndex(this.xmlReader
				.getComboBoxHomePlusIndex());
		this.comboBoxPlusPlus.setSelectedIndex(this.xmlReader
				.getComboBoxPlusPlusIndex());
		this.comboBoxMinusPlus.setSelectedIndex(this.xmlReader
				.getComboBoxMinusPlusIndex());
		this.comboBoxUpPlus.setSelectedIndex(this.xmlReader
				.getComboBoxUpPlusIndex());
		this.comboBoxDownPlus.setSelectedIndex(this.xmlReader
				.getComboBoxDownPlusIndex());
		this.comboBoxLeftPlus.setSelectedIndex(this.xmlReader
				.getComboBoxLeftPlusIndex());
		this.comboBoxRightPlus.setSelectedIndex(this.xmlReader
				.getComboBoxRightPlusIndex());
		this.comboBoxOnePlus.setSelectedIndex(this.xmlReader
				.getComboBoxOnePlusIndex());
		this.comboBoxTwoPlus.setSelectedIndex(this.xmlReader
				.getComboBoxTwoPlusIndex());

		if (MainFrame.this.comboBoxA.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxAPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxAPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxAPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxB.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxBPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxBPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxBPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxDown.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxDownPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxDownPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxDownPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxHome.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxHomePlus.setSelectedIndex(0);
			MainFrame.this.comboBoxHomePlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxHomePlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxLeft.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxLeftPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxLeftPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxLeftPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxMinus.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxMinusPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxMinusPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxMinusPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxOne.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxOnePlus.setSelectedIndex(0);
			MainFrame.this.comboBoxOnePlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxOnePlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxPlus.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxPlusPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxPlusPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxPlusPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxRight.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxRightPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxRightPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxRightPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxTwo.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxTwoPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxTwoPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxTwoPlus.setEnabled(true);
		}
		if (MainFrame.this.comboBoxUp.getSelectedIndex() == 0) {
			MainFrame.this.comboBoxUpPlus.setSelectedIndex(0);
			MainFrame.this.comboBoxUpPlus.setEnabled(false);
		} else {
			MainFrame.this.comboBoxUpPlus.setEnabled(true);
		}

	}

	/**
	 * Window Listener. When the window is closing, confirms if the user really
	 * wants to exit.
	 */
	WindowListener listener = new WindowAdapter() {
		public void windowOpened(WindowEvent evt) {
		}

		public void windowClosing(WindowEvent evt) {
			MainFrame.this.exit();

		}

		public void windowClosed(WindowEvent evt) {
		}
	};

	/**
	 * Disconnects the wiiremote if connect before exiting.
	 */
	public void exit() {

		if (this.wiimando.isConnected() == true) {
			System.out.println("disconnect");
			this.wiimando.disconnect();
			System.exit(0);
		} else {
			System.exit(0);
		}
	}

	/**
	 * Returns true if the wiiremote remote is connected.
	 */
	public boolean isConnected() {
		return this.wiimando.isConnected();
	}

	/**
	 * Returns true if the wii remote is calibrating.
	 */
	public boolean isConfiguring() {
		return this.configurationState;
	}

	/**
	 * Updates the main frame icons and labels when connecting.
	 */
	public void connecting() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				MainFrame.this.informationLabel
						.setText("Pressione simultaneamente os botões 1 e 2");
				MainFrame.this.informationLabel.setIcon(infoIcon);
				MainFrame.this.connectionStateLabel.setFont(new Font("Dialog",
						Font.PLAIN, 12));
				MainFrame.this.connectionStateLabel.setText(" A ligar");
				MainFrame.this.connectionStateLabel.setIcon(waitIcon);
			}
		});
	}

	/**
	 * Updates the main frame icons and labels when connected or disconnected.
	 */
	public void updateConnection() {
		SwingUtilities.invokeLater(new Runnable() {

			@SuppressWarnings("deprecation")
			public void run() {
				if (MainFrame.this.isConnected() == true) {
					disconnectButton.setEnabled(true);
					connectButton.setEnabled(false);

					MainFrame.this.connectionStateLabel.setText("Ligado");
					MainFrame.this.connectionStateLabel.setIcon(checkIcon);
					MainFrame.this.informationLabel.setIcon(infoIcon);
					MainFrame.this.informationLabel
							.setText("Ligação efectuada");
				} else if (MainFrame.this.isConfiguring() == true) {
					MainFrame.this.informationLabel
							.setText("Desligado para configuração");
					MainFrame.this.connectionStateLabel.setIcon(crossIcon);
					MainFrame.this.informationLabel.setIcon(infoIcon);
					MainFrame.this.connectionStateLabel.setText("Desligado");
					MainFrame.this.t.stop();
					disconnectButton.setEnabled(false);
					connectButton.setEnabled(true);
				} else {
					MainFrame.this.informationLabel
							.setText("Nenhum WiiRemote encontrado!");
					MainFrame.this.connectionStateLabel.setIcon(crossIcon);
					MainFrame.this.informationLabel.setIcon(warnIcon);
					MainFrame.this.connectionStateLabel.setText("Desligado");
					MainFrame.this.t.stop();
					disconnectButton.setEnabled(false);
					connectButton.setEnabled(true);
				}

			}
		});
	}

	/**
	 * @return the combobox A selected event.
	 */
	public String getComboASelectedEvent() {
		return (String) this.comboBoxA.getSelectedItem();
	}

	/**
	 * @return the combobox B selected event.
	 */
	public String getComboBSelectedEvent() {
		return (String) this.comboBoxB.getSelectedItem();
	}

	/**
	 * @return the combobox HOME selected event.
	 */
	public String getComboHomeSelectedEvent() {
		return (String) this.comboBoxHome.getSelectedItem();
	}

	/**
	 * @return the combobox PLUS selected event.
	 */
	public String getComboPlusSelectedEvent() {
		return (String) comboBoxPlus.getSelectedItem();
	}

	/**
	 * @return the combobox MINUS selected event.
	 */
	public String getComboMinusSelectedEvent() {
		return (String) this.comboBoxMinus.getSelectedItem();
	}

	/**
	 * @return the combobox UP selected event.
	 */
	public String getComboUpSelectedEvent() {
		return (String) this.comboBoxUp.getSelectedItem();
	}

	/**
	 * @return the combobox DOWN selected event.
	 */
	public String getComboDownSelectedEvent() {
		return (String) this.comboBoxDown.getSelectedItem();
	}

	/**
	 * @return the combobox RIGHT selected event.
	 */
	public String getComboRightSelectedEvent() {
		return (String) this.comboBoxRight.getSelectedItem();
	}

	/**
	 * @return the combobox LEFT selected event.
	 */
	public String getComboLeftSelectedEvent() {
		return (String) this.comboBoxLeft.getSelectedItem();
	}

	/**
	 * @return the combobox ONE selected event.
	 */
	public String getComboOneSelectedEvent() {
		return (String) this.comboBoxOne.getSelectedItem();
	}

	/**
	 * @return the combobox TWO selected event.
	 */
	public String getComboTwoSelectedEvent() {
		return (String) this.comboBoxTwo.getSelectedItem();
	}

	/**
	 * @return the combobox COMBO + A selected event.
	 */
	public String getComboAPlusSelectedEvent() {
		if (this.comboBoxAPlus.isVisible() == true) {
			return (String) this.comboBoxAPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + B selected event.
	 */
	public String getComboBPlusSelectedEvent() {
		if (this.comboBoxBPlus.isVisible() == true) {
			return (String) this.comboBoxBPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + HOME selected event.
	 */
	public String getComboHomePlusSelectedEvent() {
		if (this.comboBoxHomePlus.isVisible() == true) {
			return (String) this.comboBoxHomePlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + PLUS selected event.
	 */
	public String getComboPlusPlusSelectedEvent() {
		if (this.comboBoxPlusPlus.isVisible() == true) {
			return (String) this.comboBoxPlusPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + MINUS selected event.
	 */
	public String getComboMinusPlusSelectedEvent() {
		if (this.comboBoxMinusPlus.isVisible() == true) {
			return (String) this.comboBoxMinusPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + UP selected event.
	 */
	public String getComboUpPlusSelectedEvent() {
		if (this.comboBoxUpPlus.isVisible() == true) {
			return (String) this.comboBoxUpPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + DOWN selected event.
	 */
	public String getComboDownPlusSelectedEvent() {
		if (this.comboBoxDownPlus.isVisible() == true) {
			return (String) this.comboBoxDownPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + RIGHT selected event.
	 */
	public String getComboRightPlusSelectedEvent() {
		if (this.comboBoxRightPlus.isVisible() == true) {
			return (String) this.comboBoxRightPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + LEFT selected event.
	 */
	public String getComboLeftPlusSelectedEvent() {
		if (this.comboBoxLeftPlus.isVisible() == true) {
			return (String) this.comboBoxLeftPlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + ONE selected event.
	 */
	public String getComboOnePlusSelectedEvent() {
		if (this.comboBoxOnePlus.isVisible() == true) {
			return (String) this.comboBoxOnePlus.getSelectedItem();
		} else {
			return "";
		}
	}

	/**
	 * @return the combobox COMBO + TWO selected event.
	 */
	public String getComboTwoPlusSelectedEvent() {
		if (this.comboBoxTwoPlus.isVisible() == true) {
			return (String) this.comboBoxTwoPlus.getSelectedItem();
		} else {
			return null;
		}
	}

	/**
	 * Returns true if there are buttons with repeated functions, if not returns
	 * false.
	 * 
	 * @return boolean
	 */
	public boolean isFunctionRepeated() {

		this.comboboxList.clear();

		this.comboboxList.add(getComboASelectedEvent());
		this.comboboxList.add(getComboBSelectedEvent());
		this.comboboxList.add(getComboHomeSelectedEvent());
		this.comboboxList.add(getComboDownSelectedEvent());
		this.comboboxList.add(getComboUpSelectedEvent());
		this.comboboxList.add(getComboOneSelectedEvent());
		this.comboboxList.add(getComboTwoSelectedEvent());
		this.comboboxList.add(getComboPlusSelectedEvent());
		this.comboboxList.add(getComboMinusSelectedEvent());
		this.comboboxList.add(getComboLeftSelectedEvent());
		this.comboboxList.add(getComboRightSelectedEvent());

		this.comboboxList.add(getComboAPlusSelectedEvent());
		this.comboboxList.add(getComboBPlusSelectedEvent());
		this.comboboxList.add(getComboHomePlusSelectedEvent());
		this.comboboxList.add(getComboDownPlusSelectedEvent());
		this.comboboxList.add(getComboUpPlusSelectedEvent());
		this.comboboxList.add(getComboOnePlusSelectedEvent());
		this.comboboxList.add(getComboTwoPlusSelectedEvent());
		this.comboboxList.add(getComboPlusPlusSelectedEvent());
		this.comboboxList.add(getComboMinusPlusSelectedEvent());
		this.comboboxList.add(getComboLeftPlusSelectedEvent());
		this.comboboxList.add(getComboRightPlusSelectedEvent());

		Set<String> set = new HashSet<String>(this.comboboxList);

		return set.size() != this.comboboxList.size();
	}

	/**
	 * The main method. Builds a main interface window.
	 */
	public static void main(String[] args) {

		try {
			java.net.ServerSocket ss = new java.net.ServerSocket(RUN_PORT);
			File dir = new File("xml");

			if (dir.exists()) {
				MainFrame mainFrame = new MainFrame();
				mainFrame.buildMainInterface();
			} else {
				dir.mkdir();
				String t = "Aviso";
				String s = "Não foi encontrada a pasta de configuração"
						+ "\nSerá carregada a configuração por defeito.";

				JOptionPane.showMessageDialog(null, s, t,
						JOptionPane.WARNING_MESSAGE);
				MainFrame mainFrame = new MainFrame();
				mainFrame.buildMainInterface();
			}
		} catch (java.net.BindException ex) {
			System.out.println("Program already running");
			String t = "Aviso";
			String s = "O programa já está a ser executado.";

			JOptionPane.showMessageDialog(null, s, t,
					JOptionPane.WARNING_MESSAGE);
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
			String t = "Aviso";
			String s = "O programa já está a ser executado.";

			JOptionPane.showMessageDialog(null, s, t,
					JOptionPane.WARNING_MESSAGE);
		}

		
	}
}