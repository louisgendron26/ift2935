import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class WindowShare {

	private JFrame frame;
	public CreateUserFrame createframe;
	private JLabel iDLabel;
	private JTextField iDField;
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JLabel phoneLabel;
	private JLabel adressLabel;
	private JLabel provinceLabel;
	private JTextField phoneNumberField;
	private JTextField adressField;
	private JTextField provinceField;
	private JTextField postalCodeField;
	private JTextField townField;
	private JTextField emailField;
	private JTextField loginIDField;
	private JTextField logInPasswordField;
	private JLabel userLoginLabel;
	private JLabel passwordLogInLabel;
	private JPanel borrowPanel;
	private JTextField borrowField;
	private JLabel objectIDLabel;
	private JLabel borrowPaneTitle;
	private JButton borrowButton;
	private JPanel shareObjectPanel;
	private JLabel shareObjectTitleLabel;
	private JPanel chooseTypeSharepanel;
	private JPanel logPanel;
	private JLabel lblChooseAType;
	private JComboBox comboBox;
	private JButton btnNext;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JButton btnDisconnect;
	private JButton shareObject;
	private JPanel afterLogPanel;
	private JButton btnShareBack;
	private JTextField givebackObjectIDField;
	private JTextField shareIDField;
	private JTextArea shareDescriptionField;
	private JTextField sharePriceField;
	private JTextField shareTimeField;
	private JPanel shareCarTypePanel;
	private JPanel shareHouseTypePanel;
	private JPanel shareBikeTypePanel;
	private JLabel lblTypeCar;
	private JLabel lblYear;
	private JLabel lblCompany;
	private JLabel lblKm;
	private JLabel lblTransmission;
	private JLabel lblConsumption;
	private JLabel lblCouleur;
	private JTextField carYearField;
	private JTextField carCompanyField;
	private JTextField carKmField;
	private JComboBox transmissionComboBox;
	private JTextField carConsumationField;
	private JTextField carColorField;
	private JLabel lblhousetitle;
	private JLabel lblHouseYear;
	private JLabel lblHouseLotSize;
	private JLabel lblHouseFlournumber;
	private JLabel lblHousefurniture;
	private JLabel lblAmountOfBedroom;
	private JLabel lblAmountOfBathroom;
	private JTextField houseYearField;
	private JTextField houseLotSizeField;
	private JTextField houseFloorsField;
	private JComboBox houseFurnitureComboBox;
	private JTextField houseBedroomField;
	private JTextField houseBathroomField;
	private JTextField bicycleMarkField;
	private JTextField bicycleFrameField;
	private JTextField bicycleSpeedsField;
	private JTextField bicycleWheelField;
	private JTextField bicycleBrakeField;
	private JTextField bicycleTypeField;
	private JTextField bicycleColorField;
	private JLabel lblcarType;
	private JTextField carTypeField;
	private JPanel searchObjectPanel;
	private JTable table;
	private JTextField searchField;
	private JButton btnMoreOption;
	private JButton searchSimpleButton;
	private JPanel searchObjPanel;
	private JPanel searchObjectComplexePanel;
	private JLabel lblSearchAdvanced;
	private JLabel lblPrice;
	private JLabel lblDistance;
	private JLabel lblType_1;
	private JLabel lblAvaible;
	private JTextField searchPriceField;
	private JTextField searchDistanceField;
	private JComboBox searchTypeComboBox;
	private JComboBox searchAvaibleCombobox;
	private JButton btnSearchObjComplexe;
	private JButton btnSearchObjBack;
	private JPanel myObjectPanel;
	private JLabel lblMyObject;
	private JButton btnSeeMyObject;
	private JPanel Modifpanel;
	private JLabel lblModificationById;
	private JButton btnModif;
	private JComboBox ModificationComboBox;
	private JTextArea ModificationArea;
	private JTextField userOnjectIdField;
	private JPanel findInterrestedpanel;
	private JLabel lblUsersInterrestedBy;
	private JLabel lblObjectId_1;
	private JTextField usersInterrestedField;
	private JButton btnFind_1;
	private JPanel otherPanel;
	private JLabel lblNewLabel;
	private JButton btnGetMyNotification;
	private JLabel lblRemoveNotification;
	private JComboBox notificationTypeComboBox;
	private JButton btnRemove;
	private JLabel lblNotifyMeFor;
	private JTextField objectIdNotifField;
	private JButton btnNotifyMe;
	private JButton btnSeeMyNotification_1;
	private JButton btnGetMyUser;
	private JLabel lblmodifObjectID;
	private JTextField modifObjectIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowShare window = new WindowShare();
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
	public WindowShare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("penis");
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(0, 0, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel createUserpanel = new JPanel();
		createUserpanel.setVisible(false);
		
		logPanel = new JPanel();
		SpringLayout sl_logPanel = new SpringLayout();
		logPanel.setLayout(sl_logPanel);
		
		JButton buttonLogIn = new JButton("LogIn");
		buttonLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(true){
					logPanel.setVisible(false);
					afterLogPanel.setVisible(true);
					//TODO get user info
				}
				
				else 
					JOptionPane.showMessageDialog(null,"invalide user input");
				
			}
		});
		sl_logPanel.putConstraint(SpringLayout.EAST, buttonLogIn, 0, SpringLayout.EAST, logPanel);
		logPanel.add(buttonLogIn);
		
		JButton buttonOpenCreateUserPanel = new JButton("create");
		buttonOpenCreateUserPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logPanel.setVisible(false);
				createUserpanel.setVisible(true);
			}
		});
		sl_logPanel.putConstraint(SpringLayout.NORTH, buttonOpenCreateUserPanel, 10, SpringLayout.SOUTH, buttonLogIn);
		sl_logPanel.putConstraint(SpringLayout.EAST, buttonOpenCreateUserPanel, 0, SpringLayout.EAST, logPanel);
		logPanel.add(buttonOpenCreateUserPanel);
		
		loginIDField = new JTextField();
		sl_logPanel.putConstraint(SpringLayout.EAST, loginIDField, 0, SpringLayout.EAST, logPanel);
		loginIDField.setText("ID");
		loginIDField.setColumns(10);
		logPanel.add(loginIDField);
		
		JLabel titleLoginLabel = new JLabel("Connection");
		sl_logPanel.putConstraint(SpringLayout.NORTH, titleLoginLabel, 0, SpringLayout.NORTH, logPanel);
		sl_logPanel.putConstraint(SpringLayout.WEST, titleLoginLabel, 0, SpringLayout.WEST, logPanel);
		logPanel.add(titleLoginLabel);
		SpringLayout sl_createUserpanel = new SpringLayout();
		createUserpanel.setLayout(sl_createUserpanel);
		
		iDLabel = new JLabel("ID");
		sl_createUserpanel.putConstraint(SpringLayout.WEST, iDLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(iDLabel);
		
		iDField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.EAST, iDField, 0, SpringLayout.EAST, createUserpanel);
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, iDField, 0, SpringLayout.NORTH, iDLabel);
		createUserpanel.add(iDField);
		iDField.setColumns(10);
		
		firstNameLabel = new JLabel("FirstName");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, firstNameLabel, 0, SpringLayout.SOUTH, iDLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, firstNameLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(firstNameLabel);
		
		firstNameField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, firstNameField, 0, SpringLayout.NORTH, firstNameLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, firstNameField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameLabel = new JLabel("LastName");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, lastNameLabel, 0, SpringLayout.SOUTH, firstNameLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, lastNameLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(lastNameLabel);
		
		lastNameField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, lastNameField, 0, SpringLayout.NORTH, lastNameLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, lastNameField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(lastNameField);
		lastNameField.setColumns(10);
		
		phoneLabel = new JLabel("PhoneNumber");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, phoneLabel, 0, SpringLayout.SOUTH, lastNameLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, phoneLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(phoneLabel);
		
		adressLabel = new JLabel("Adress");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, adressLabel, 0, SpringLayout.SOUTH, phoneLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, adressLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(adressLabel);
		
		provinceLabel = new JLabel("Province");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, provinceLabel, 0, SpringLayout.SOUTH, adressLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, provinceLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(provinceLabel);
		
		JLabel postalCodeLabel = new JLabel("PostalCode");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, postalCodeLabel, 0, SpringLayout.SOUTH, provinceLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, postalCodeLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(postalCodeLabel);
		
		JLabel townLabel = new JLabel("Town");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, townLabel, 0, SpringLayout.SOUTH, postalCodeLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, townLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(townLabel);
		
		JLabel emailLabel = new JLabel("Email");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, emailLabel, 0, SpringLayout.SOUTH, townLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, emailLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(emailLabel);
		
		JLabel titleCreatepane = new JLabel("Create User");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, iDLabel, 0, SpringLayout.SOUTH, titleCreatepane);
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, titleCreatepane, 0, SpringLayout.NORTH, createUserpanel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, titleCreatepane, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(titleCreatepane);
		
		phoneNumberField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, phoneNumberField, 0, SpringLayout.NORTH, phoneLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, phoneNumberField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(phoneNumberField);
		phoneNumberField.setColumns(10);
		
		adressField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, adressField, 0, SpringLayout.NORTH, adressLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, adressField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(adressField);
		adressField.setColumns(10);
		
		provinceField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, provinceField, 0, SpringLayout.NORTH, provinceLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, provinceField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(provinceField);
		provinceField.setColumns(10);
		
		postalCodeField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, postalCodeField, 0, SpringLayout.NORTH, postalCodeLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, postalCodeField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(postalCodeField);
		postalCodeField.setColumns(10);
		
		townField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, townField, 0, SpringLayout.NORTH, townLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, townField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(townField);
		townField.setColumns(10);
		
		emailField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, emailField, 0, SpringLayout.NORTH, emailLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, emailField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(emailField);
		emailField.setColumns(10);
		
		JButton btnCreateUser = new JButton("Create");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUserpanel.setVisible(false);
				logPanel.setVisible(true);
			}
		});
		sl_createUserpanel.putConstraint(SpringLayout.SOUTH, btnCreateUser, 0, SpringLayout.SOUTH, createUserpanel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, btnCreateUser, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(btnCreateUser);
		
		JButton btnCancelCreateUser = new JButton("Cancel");
		btnCancelCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUserpanel.setVisible(false);
				logPanel.setVisible(true);
			}
		});
		sl_createUserpanel.putConstraint(SpringLayout.WEST, btnCancelCreateUser, 0, SpringLayout.WEST, createUserpanel);
		sl_createUserpanel.putConstraint(SpringLayout.SOUTH, btnCancelCreateUser, 0, SpringLayout.SOUTH, btnCreateUser);
		createUserpanel.add(btnCancelCreateUser);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, createUserpanel, 230, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, createUserpanel, 300, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, logPanel, 200, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, logPanel, 150, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, createUserpanel, 12, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, logPanel, 12, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, createUserpanel, 6, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, logPanel, 6, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(logPanel);
		
		logInPasswordField = new JTextField();
		sl_logPanel.putConstraint(SpringLayout.NORTH, buttonLogIn, 0, SpringLayout.SOUTH, logInPasswordField);
		sl_logPanel.putConstraint(SpringLayout.EAST, logInPasswordField, 0, SpringLayout.EAST, logPanel);
		logInPasswordField.setText("PassWord");
		logPanel.add(logInPasswordField);
		logInPasswordField.setColumns(10);
		
		userLoginLabel = new JLabel("ID");
		sl_logPanel.putConstraint(SpringLayout.NORTH, loginIDField, 0, SpringLayout.NORTH, userLoginLabel);
		sl_logPanel.putConstraint(SpringLayout.NORTH, userLoginLabel, 0, SpringLayout.SOUTH, titleLoginLabel);
		sl_logPanel.putConstraint(SpringLayout.WEST, userLoginLabel, 0, SpringLayout.WEST, logPanel);
		logPanel.add(userLoginLabel);
		
		passwordLogInLabel = new JLabel("Password");
		sl_logPanel.putConstraint(SpringLayout.NORTH, passwordLogInLabel, 0, SpringLayout.SOUTH, userLoginLabel);
		sl_logPanel.putConstraint(SpringLayout.NORTH, logInPasswordField, 0, SpringLayout.NORTH, passwordLogInLabel);
		sl_logPanel.putConstraint(SpringLayout.WEST, passwordLogInLabel, 0, SpringLayout.WEST, logPanel);
		logPanel.add(passwordLogInLabel);
		frame.getContentPane().add(createUserpanel);
		
		passwordLabel = new JLabel("Password");
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, passwordLabel, 0, SpringLayout.SOUTH, emailLabel);
		sl_createUserpanel.putConstraint(SpringLayout.WEST, passwordLabel, 0, SpringLayout.WEST, createUserpanel);
		createUserpanel.add(passwordLabel);
		
		passwordField = new JTextField();
		sl_createUserpanel.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH, passwordLabel);
		sl_createUserpanel.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, createUserpanel);
		createUserpanel.add(passwordField);
		passwordField.setColumns(10);
		
		afterLogPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, afterLogPanel, 6, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, afterLogPanel, 550, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, afterLogPanel, 1555, SpringLayout.WEST, frame.getContentPane());
		afterLogPanel.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, afterLogPanel, 12, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(afterLogPanel);
		SpringLayout sl_afterLogPanel = new SpringLayout();
		afterLogPanel.setLayout(sl_afterLogPanel);
		
		borrowPanel = new JPanel();
		borrowPanel.setBackground(Color.LIGHT_GRAY);
		sl_afterLogPanel.putConstraint(SpringLayout.NORTH, borrowPanel, 0, SpringLayout.NORTH, afterLogPanel);
		sl_afterLogPanel.putConstraint(SpringLayout.WEST, borrowPanel, 0, SpringLayout.WEST, afterLogPanel);
		sl_afterLogPanel.putConstraint(SpringLayout.SOUTH, borrowPanel, 114, SpringLayout.NORTH, afterLogPanel);
		sl_afterLogPanel.putConstraint(SpringLayout.EAST, borrowPanel, 232, SpringLayout.WEST, afterLogPanel);
		springLayout.putConstraint(SpringLayout.NORTH, borrowPanel, 0, SpringLayout.NORTH, afterLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, borrowPanel, 0, SpringLayout.WEST, afterLogPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, borrowPanel, 0, SpringLayout.NORTH, afterLogPanel);
		springLayout.putConstraint(SpringLayout.EAST, borrowPanel, 200, SpringLayout.WEST, afterLogPanel);
		afterLogPanel.add(borrowPanel);
				SpringLayout sl_borrowPanel = new SpringLayout();
				borrowPanel.setLayout(sl_borrowPanel);
				
				borrowField = new JTextField();
				sl_borrowPanel.putConstraint(SpringLayout.EAST, borrowField, 0, SpringLayout.EAST, borrowPanel);
				borrowPanel.add(borrowField);
				borrowField.setColumns(10);
				
				objectIDLabel = new JLabel("Object ID");
				sl_borrowPanel.putConstraint(SpringLayout.NORTH, borrowField, 0, SpringLayout.NORTH, objectIDLabel);
				sl_borrowPanel.putConstraint(SpringLayout.WEST, objectIDLabel, 0, SpringLayout.WEST, borrowPanel);
				borrowPanel.add(objectIDLabel);
				
				borrowPaneTitle = new JLabel("Borrow by object ID");
				sl_borrowPanel.putConstraint(SpringLayout.NORTH, objectIDLabel, 6, SpringLayout.SOUTH, borrowPaneTitle);
				sl_borrowPanel.putConstraint(SpringLayout.NORTH, borrowPaneTitle, 0, SpringLayout.NORTH, borrowPanel);
				sl_borrowPanel.putConstraint(SpringLayout.WEST, borrowPaneTitle, 0, SpringLayout.WEST, borrowPanel);
				borrowPanel.add(borrowPaneTitle);
				
				borrowButton = new JButton("Borrow Object");
				sl_borrowPanel.putConstraint(SpringLayout.NORTH, borrowButton, 0, SpringLayout.SOUTH, borrowField);
				sl_borrowPanel.putConstraint(SpringLayout.EAST, borrowButton, 0, SpringLayout.EAST, borrowPanel);
				borrowPanel.add(borrowButton);
				
				JPanel giveBackPanel = new JPanel();
				giveBackPanel.setBackground(Color.LIGHT_GRAY);
				sl_afterLogPanel.putConstraint(SpringLayout.NORTH, giveBackPanel, 0, SpringLayout.NORTH, afterLogPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.WEST, giveBackPanel, 6, SpringLayout.EAST, borrowPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.SOUTH, giveBackPanel, 114, SpringLayout.NORTH, afterLogPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.EAST, giveBackPanel, 238, SpringLayout.EAST, borrowPanel);
				afterLogPanel.add(giveBackPanel);
				SpringLayout sl_giveBackPanel = new SpringLayout();
				giveBackPanel.setLayout(sl_giveBackPanel);
				
				JLabel giveBacktitleLabel = new JLabel("Give back by object ID");
				sl_giveBackPanel.putConstraint(SpringLayout.NORTH, giveBacktitleLabel, 0, SpringLayout.NORTH, giveBackPanel);
				sl_giveBackPanel.putConstraint(SpringLayout.WEST, giveBacktitleLabel, 0, SpringLayout.WEST, giveBackPanel);
				giveBackPanel.add(giveBacktitleLabel);
				
				JLabel giveBackIDLabel = new JLabel("Object ID");
				sl_giveBackPanel.putConstraint(SpringLayout.NORTH, giveBackIDLabel, 6, SpringLayout.SOUTH, giveBacktitleLabel);
				sl_giveBackPanel.putConstraint(SpringLayout.WEST, giveBackIDLabel, 0, SpringLayout.WEST, giveBackPanel);
				giveBackPanel.add(giveBackIDLabel);
				
				givebackObjectIDField = new JTextField();
				sl_giveBackPanel.putConstraint(SpringLayout.NORTH, givebackObjectIDField, 0, SpringLayout.NORTH, giveBackIDLabel);
				sl_giveBackPanel.putConstraint(SpringLayout.EAST, givebackObjectIDField, 0, SpringLayout.EAST, giveBackPanel);
				giveBackPanel.add(givebackObjectIDField);
				givebackObjectIDField.setColumns(10);
				
				JButton giveBackObjectbutton = new JButton("Give Back Object");
				sl_giveBackPanel.putConstraint(SpringLayout.NORTH, giveBackObjectbutton, 0, SpringLayout.SOUTH, givebackObjectIDField);
				sl_giveBackPanel.putConstraint(SpringLayout.EAST, giveBackObjectbutton, 0, SpringLayout.EAST, giveBackPanel);
				giveBackPanel.add(giveBackObjectbutton);
				
				shareObjectPanel = new JPanel();
				sl_afterLogPanel.putConstraint(SpringLayout.NORTH, shareObjectPanel, 10, SpringLayout.SOUTH, borrowPanel);
				shareObjectPanel.setBackground(Color.LIGHT_GRAY);
				sl_afterLogPanel.putConstraint(SpringLayout.WEST, shareObjectPanel, 0, SpringLayout.WEST, afterLogPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.SOUTH, shareObjectPanel, 317, SpringLayout.SOUTH, borrowPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.EAST, shareObjectPanel, 300, SpringLayout.WEST, afterLogPanel);
				springLayout.putConstraint(SpringLayout.SOUTH, shareObjectPanel, 378, SpringLayout.SOUTH, borrowPanel);
				afterLogPanel.add(shareObjectPanel);
				springLayout.putConstraint(SpringLayout.WEST, shareObjectPanel, 586, SpringLayout.EAST, createUserpanel);
				springLayout.putConstraint(SpringLayout.EAST, shareObjectPanel, -32, SpringLayout.EAST, frame.getContentPane());
				SpringLayout sl_shareObjectPanel = new SpringLayout();
				shareObjectPanel.setLayout(sl_shareObjectPanel);
				
				shareObjectTitleLabel = new JLabel("Share Object");
				sl_shareObjectPanel.putConstraint(SpringLayout.NORTH, shareObjectTitleLabel, 0, SpringLayout.NORTH, shareObjectPanel);
				sl_shareObjectPanel.putConstraint(SpringLayout.WEST, shareObjectTitleLabel, 0, SpringLayout.WEST, shareObjectPanel);
				shareObjectPanel.add(shareObjectTitleLabel);
				
				shareObject = new JButton("ShareObject");
				shareObject.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						shareObject.setVisible(false);
						btnShareBack.setVisible(false);
						chooseTypeSharepanel.setVisible(true);
						shareCarTypePanel.setVisible(false);
						shareHouseTypePanel.setVisible(false);
						shareBikeTypePanel.setVisible(false);
						
					}
				});
				sl_shareObjectPanel.putConstraint(SpringLayout.SOUTH, shareObject, 0, SpringLayout.SOUTH, shareObjectPanel);
				sl_shareObjectPanel.putConstraint(SpringLayout.EAST, shareObject, 0, SpringLayout.EAST, shareObjectPanel);
				shareObjectPanel.add(shareObject);
				shareObject.setVisible(false);
				
				btnShareBack = new JButton("Back");
				btnShareBack.setVisible(false);
				sl_shareObjectPanel.putConstraint(SpringLayout.WEST, btnShareBack, 0, SpringLayout.WEST, shareObjectPanel);
				sl_shareObjectPanel.putConstraint(SpringLayout.SOUTH, btnShareBack, 0, SpringLayout.SOUTH, shareObjectPanel);
				btnShareBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						shareObject.setVisible(false);
						btnShareBack.setVisible(false);
						chooseTypeSharepanel.setVisible(true);
						shareCarTypePanel.setVisible(false);
						shareHouseTypePanel.setVisible(false);
						shareBikeTypePanel.setVisible(false);
					}
				});
				shareObjectPanel.add(btnShareBack);
				
				chooseTypeSharepanel = new JPanel();
				sl_shareObjectPanel.putConstraint(SpringLayout.NORTH, chooseTypeSharepanel, 0, SpringLayout.SOUTH, shareObjectTitleLabel);
				sl_shareObjectPanel.putConstraint(SpringLayout.WEST, chooseTypeSharepanel, 10, SpringLayout.WEST, shareObjectPanel);
				sl_shareObjectPanel.putConstraint(SpringLayout.SOUTH, chooseTypeSharepanel, -10, SpringLayout.SOUTH, shareObjectPanel);
				sl_shareObjectPanel.putConstraint(SpringLayout.EAST, chooseTypeSharepanel, -10, SpringLayout.EAST, shareObjectPanel);
				shareObjectPanel.add(chooseTypeSharepanel);
				SpringLayout sl_chooseTypeSharepanel = new SpringLayout();
				chooseTypeSharepanel.setLayout(sl_chooseTypeSharepanel);
				
				lblChooseAType = new JLabel("Choose a type");
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, lblChooseAType, 0, SpringLayout.WEST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(lblChooseAType);
				
				comboBox = new JComboBox();
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, lblChooseAType);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, chooseTypeSharepanel);
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Car", "House", "Bike"}));
				comboBox.setMaximumRowCount(3);
				chooseTypeSharepanel.add(comboBox);
				
				btnNext = new JButton("Next");
				btnNext.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						btnShareBack.setVisible(true);
						shareObject.setVisible(true);
						int index = comboBox.getSelectedIndex();
						chooseTypeSharepanel.setVisible(false);
						if(index==0){shareCarTypePanel.setVisible(true);}
						else if(index==1){shareHouseTypePanel.setVisible(true);}
						else if(index==2){shareBikeTypePanel.setVisible(true);}
						else{}
						
						
					}
				});
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, btnNext, 0, SpringLayout.SOUTH, comboBox);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, btnNext, 0, SpringLayout.EAST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(btnNext);
				
				JLabel lblId = new JLabel("ID");
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, lblId, 6, SpringLayout.NORTH, chooseTypeSharepanel);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, lblId, 0, SpringLayout.WEST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(lblId);
				
				JLabel lblDescription = new JLabel("Description");
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, lblDescription, 0, SpringLayout.SOUTH, lblId);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, lblDescription, 0, SpringLayout.WEST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(lblDescription);
				
				JLabel lblPrices = new JLabel("Prices");
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, lblPrices, 0, SpringLayout.WEST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(lblPrices);
				
				JLabel lblShareTime = new JLabel("Share time");
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, lblShareTime, 0, SpringLayout.SOUTH, lblPrices);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, lblShareTime, 0, SpringLayout.WEST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(lblShareTime);
				
				JLabel lblSetAvailbeNow = new JLabel("Set availbe now ?");
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, lblChooseAType, 6, SpringLayout.SOUTH, lblSetAvailbeNow);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, lblSetAvailbeNow, 6, SpringLayout.SOUTH, lblShareTime);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, lblSetAvailbeNow, 0, SpringLayout.WEST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(lblSetAvailbeNow);
				
				shareIDField = new JTextField();
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, shareIDField, 0, SpringLayout.NORTH, lblId);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, shareIDField, 0, SpringLayout.EAST, comboBox);
				chooseTypeSharepanel.add(shareIDField);
				shareIDField.setColumns(10);
				
				shareDescriptionField = new JTextArea();
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, shareDescriptionField, 0, SpringLayout.SOUTH, lblDescription);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, shareDescriptionField, 0, SpringLayout.WEST, chooseTypeSharepanel);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.SOUTH, shareDescriptionField, 50, SpringLayout.SOUTH, lblDescription);
				shareDescriptionField.setLineWrap(true);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, lblPrices, 0, SpringLayout.SOUTH, shareDescriptionField);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, shareDescriptionField, 0, SpringLayout.EAST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(shareDescriptionField);
				shareDescriptionField.setColumns(10);
				
				sharePriceField = new JTextField();
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, sharePriceField, 0, SpringLayout.NORTH, lblPrices);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, sharePriceField, 0, SpringLayout.EAST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(sharePriceField);
				sharePriceField.setColumns(10);
				
				shareTimeField = new JTextField();
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, shareTimeField, 0, SpringLayout.NORTH, lblShareTime);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, shareTimeField, 0, SpringLayout.EAST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(shareTimeField);
				shareTimeField.setColumns(10);
				
				JComboBox shareSetAvaibleComboBox = new JComboBox();
				shareSetAvaibleComboBox.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
				shareSetAvaibleComboBox.setSelectedIndex(0);
				shareSetAvaibleComboBox.setMaximumRowCount(2);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.NORTH, shareSetAvaibleComboBox, 0, SpringLayout.NORTH, lblSetAvailbeNow);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, shareSetAvaibleComboBox, 0, SpringLayout.EAST, chooseTypeSharepanel);
				chooseTypeSharepanel.add(shareSetAvaibleComboBox);
				springLayout.putConstraint(SpringLayout.NORTH, shareObjectPanel, 6, SpringLayout.SOUTH, borrowPanel);
				
				btnDisconnect = new JButton("Disconnect");
				sl_afterLogPanel.putConstraint(SpringLayout.NORTH, btnDisconnect, 10, SpringLayout.SOUTH, shareObjectPanel);
				
				shareCarTypePanel = new JPanel();
				sl_shareObjectPanel.putConstraint(SpringLayout.SOUTH, shareCarTypePanel, 0, SpringLayout.NORTH, btnShareBack);
				sl_shareObjectPanel.putConstraint(SpringLayout.EAST, shareCarTypePanel, -10, SpringLayout.EAST, shareObjectPanel);
				shareCarTypePanel.setVisible(false);
				sl_shareObjectPanel.putConstraint(SpringLayout.NORTH, shareCarTypePanel, 0, SpringLayout.SOUTH, shareObjectTitleLabel);
				sl_shareObjectPanel.putConstraint(SpringLayout.WEST, shareCarTypePanel, 10, SpringLayout.WEST, shareObjectPanel);
				shareObjectPanel.add(shareCarTypePanel);
				SpringLayout sl_shareCarTypePanel = new SpringLayout();
				shareCarTypePanel.setLayout(sl_shareCarTypePanel);
				
				lblTypeCar = new JLabel("Type : Car");
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblTypeCar, 0, SpringLayout.NORTH, shareCarTypePanel);
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblTypeCar, 0, SpringLayout.WEST, shareCarTypePanel);
				shareCarTypePanel.add(lblTypeCar);
				
				lblYear = new JLabel("Year");
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblYear, 6, SpringLayout.SOUTH, lblTypeCar);
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblYear, 0, SpringLayout.WEST, shareCarTypePanel);
				shareCarTypePanel.add(lblYear);
				
				lblCompany = new JLabel("Company");
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblCompany, 0, SpringLayout.SOUTH, lblYear);
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblCompany, 0, SpringLayout.WEST, shareCarTypePanel);
				shareCarTypePanel.add(lblCompany);
				
				lblKm = new JLabel("Km");
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblKm, 0, SpringLayout.SOUTH, lblCompany);
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblKm, 0, SpringLayout.WEST, shareCarTypePanel);
				shareCarTypePanel.add(lblKm);
				
				lblcarType = new JLabel("Type");
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblcarType, 0, SpringLayout.SOUTH, lblKm);
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblcarType, 0, SpringLayout.WEST, shareCarTypePanel);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.SOUTH, lblcarType, -22, SpringLayout.SOUTH, chooseTypeSharepanel);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.EAST, lblcarType, 0, SpringLayout.EAST, lblChooseAType);
				shareCarTypePanel.add(lblcarType);
				
				lblTransmission = new JLabel("Transmission");
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblTransmission, 0, SpringLayout.WEST, shareCarTypePanel);
				shareCarTypePanel.add(lblTransmission);
				
				lblConsumption = new JLabel("Consumption");
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblConsumption, 0, SpringLayout.SOUTH, lblcarType);
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblConsumption, 0, SpringLayout.WEST, shareCarTypePanel);
				shareCarTypePanel.add(lblConsumption);
				
				lblCouleur = new JLabel("color");
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblTransmission, 6, SpringLayout.SOUTH, lblCouleur);
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, lblCouleur, 0, SpringLayout.SOUTH, lblConsumption);
				sl_shareCarTypePanel.putConstraint(SpringLayout.WEST, lblCouleur, 0, SpringLayout.WEST, shareCarTypePanel);
				shareCarTypePanel.add(lblCouleur);
				 
				carTypeField = new JTextField();
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, carTypeField, 0, SpringLayout.NORTH, lblcarType);
				sl_shareCarTypePanel.putConstraint(SpringLayout.EAST, carTypeField, 0, SpringLayout.EAST, shareCarTypePanel);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.WEST, carTypeField, 0, SpringLayout.WEST, chooseTypeSharepanel);
				sl_chooseTypeSharepanel.putConstraint(SpringLayout.SOUTH, carTypeField, -27, SpringLayout.SOUTH, chooseTypeSharepanel);
				shareCarTypePanel.add(carTypeField);
				carTypeField.setColumns(10);
				
				carYearField = new JTextField();
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, carYearField, 0, SpringLayout.NORTH, lblYear);
				sl_shareCarTypePanel.putConstraint(SpringLayout.EAST, carYearField, 0, SpringLayout.EAST, shareCarTypePanel);
				shareCarTypePanel.add(carYearField);
				carYearField.setColumns(10);
				
				carCompanyField = new JTextField();
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, carCompanyField, 0, SpringLayout.NORTH, lblCompany);
				sl_shareCarTypePanel.putConstraint(SpringLayout.EAST, carCompanyField, 0, SpringLayout.EAST, shareCarTypePanel);
				shareCarTypePanel.add(carCompanyField);
				carCompanyField.setColumns(10);
				
				carKmField = new JTextField();
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, carKmField, 0, SpringLayout.NORTH, lblKm);
				sl_shareCarTypePanel.putConstraint(SpringLayout.EAST, carKmField, 0, SpringLayout.EAST, shareCarTypePanel);
				shareCarTypePanel.add(carKmField);
				carKmField.setColumns(10);
				
				transmissionComboBox = new JComboBox();
				transmissionComboBox.setModel(new DefaultComboBoxModel(new String[] {"Manual", "Automatic"}));
				transmissionComboBox.setSelectedIndex(0);
				transmissionComboBox.setMaximumRowCount(2);
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, transmissionComboBox, 0, SpringLayout.NORTH, lblTransmission);
				sl_shareCarTypePanel.putConstraint(SpringLayout.EAST, transmissionComboBox, 0, SpringLayout.EAST, shareCarTypePanel);
				shareCarTypePanel.add(transmissionComboBox);
				
				carConsumationField = new JTextField();
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, carConsumationField, 0, SpringLayout.NORTH, lblConsumption);
				sl_shareCarTypePanel.putConstraint(SpringLayout.EAST, carConsumationField, 0, SpringLayout.EAST, shareCarTypePanel);
				shareCarTypePanel.add(carConsumationField);
				carConsumationField.setColumns(10);
				
				carColorField = new JTextField();
				sl_shareCarTypePanel.putConstraint(SpringLayout.NORTH, carColorField, 0, SpringLayout.NORTH, lblCouleur);
				sl_shareCarTypePanel.putConstraint(SpringLayout.EAST, carColorField, 0, SpringLayout.EAST, shareCarTypePanel);
				shareCarTypePanel.add(carColorField);
				carColorField.setColumns(10);
				
				shareHouseTypePanel = new JPanel();
				sl_shareObjectPanel.putConstraint(SpringLayout.SOUTH, shareHouseTypePanel, 0, SpringLayout.NORTH, btnShareBack);
				sl_shareObjectPanel.putConstraint(SpringLayout.EAST, shareHouseTypePanel, -10, SpringLayout.EAST, shareObjectPanel);
				shareHouseTypePanel.setVisible(false);
				sl_shareObjectPanel.putConstraint(SpringLayout.NORTH, shareHouseTypePanel, 0, SpringLayout.SOUTH, shareObjectTitleLabel);
				sl_shareObjectPanel.putConstraint(SpringLayout.WEST, shareHouseTypePanel, 10, SpringLayout.WEST, shareObjectPanel);
				shareObjectPanel.add(shareHouseTypePanel);
				SpringLayout sl_shareHouseTypePanel = new SpringLayout();
				shareHouseTypePanel.setLayout(sl_shareHouseTypePanel);
				
				lblhousetitle = new JLabel("Type : House");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblhousetitle, 0, SpringLayout.NORTH, shareHouseTypePanel);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblhousetitle, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblhousetitle);
				
				lblHouseYear = new JLabel("Year");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblHouseYear, 6, SpringLayout.SOUTH, lblhousetitle);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblHouseYear, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblHouseYear);
				
				lblHouseLotSize = new JLabel("Lot size");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblHouseLotSize, 0, SpringLayout.SOUTH, lblHouseYear);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblHouseLotSize, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblHouseLotSize);
				
				lblHouseFlournumber = new JLabel("Amount of floor");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblHouseFlournumber, 0, SpringLayout.SOUTH, lblHouseLotSize);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblHouseFlournumber, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblHouseFlournumber);
				
				lblAmountOfBedroom = new JLabel("amount of bedroom");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblAmountOfBedroom, 0, SpringLayout.SOUTH, lblHouseFlournumber);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblAmountOfBedroom, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblAmountOfBedroom);
				
				lblAmountOfBathroom = new JLabel("Amount of bathroom");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblAmountOfBathroom, 0, SpringLayout.SOUTH, lblAmountOfBedroom);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblAmountOfBathroom, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblAmountOfBathroom);
				
				lblHousefurniture = new JLabel("Come with furniture ?");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblHousefurniture, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblHousefurniture);
				
				JLabel lblAvaibleParking = new JLabel("Avaible parking");
				sl_shareHouseTypePanel.putConstraint(SpringLayout.WEST, lblAvaibleParking, 0, SpringLayout.WEST, shareHouseTypePanel);
				shareHouseTypePanel.add(lblAvaibleParking);
				
				houseYearField = new JTextField();
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, houseYearField, 0, SpringLayout.NORTH, lblHouseYear);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.EAST, houseYearField, 0, SpringLayout.EAST, shareHouseTypePanel);
				houseYearField.setColumns(10);
				shareHouseTypePanel.add(houseYearField);
				
				houseLotSizeField = new JTextField();
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, houseLotSizeField, 0, SpringLayout.NORTH, lblHouseLotSize);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.EAST, houseLotSizeField, 0, SpringLayout.EAST, shareHouseTypePanel);
				houseLotSizeField.setColumns(10);
				shareHouseTypePanel.add(houseLotSizeField);
				
				houseFloorsField = new JTextField();
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, houseFloorsField, 0, SpringLayout.NORTH, lblHouseFlournumber);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.EAST, houseFloorsField, 0, SpringLayout.EAST, shareHouseTypePanel);
				houseFloorsField.setColumns(10);
				shareHouseTypePanel.add(houseFloorsField);
				
				houseBedroomField = new JTextField();
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, houseBedroomField, 0, SpringLayout.NORTH, lblAmountOfBedroom);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.EAST, houseBedroomField, 0, SpringLayout.EAST, shareHouseTypePanel);
				houseBedroomField.setColumns(10);
				shareHouseTypePanel.add(houseBedroomField);
				
				houseBathroomField = new JTextField();
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, houseBathroomField, 0, SpringLayout.NORTH, lblAmountOfBathroom);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.EAST, houseBathroomField, 0, SpringLayout.EAST, shareHouseTypePanel);
				houseBathroomField.setColumns(10);
				shareHouseTypePanel.add(houseBathroomField);
				
				houseFurnitureComboBox = new JComboBox();
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblHousefurniture, 0, SpringLayout.NORTH, houseFurnitureComboBox);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, houseFurnitureComboBox, 0, SpringLayout.SOUTH, houseBathroomField);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.EAST, houseFurnitureComboBox, 0, SpringLayout.EAST, shareHouseTypePanel);
				houseFurnitureComboBox.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
				houseFurnitureComboBox.setSelectedIndex(1);
				houseFurnitureComboBox.setMaximumRowCount(2);
				shareHouseTypePanel.add(houseFurnitureComboBox);
				
				JComboBox houseParkingcomboBox = new JComboBox();
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, lblAvaibleParking, 0, SpringLayout.NORTH, houseParkingcomboBox);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.NORTH, houseParkingcomboBox, 0, SpringLayout.SOUTH, houseFurnitureComboBox);
				sl_shareHouseTypePanel.putConstraint(SpringLayout.EAST, houseParkingcomboBox, 0, SpringLayout.EAST, shareHouseTypePanel);
				houseParkingcomboBox.setMaximumRowCount(2);
				houseParkingcomboBox.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
				houseParkingcomboBox.setSelectedIndex(0);
				shareHouseTypePanel.add(houseParkingcomboBox);
				
				shareBikeTypePanel = new JPanel();
				sl_shareObjectPanel.putConstraint(SpringLayout.SOUTH, shareBikeTypePanel, 0, SpringLayout.NORTH, btnShareBack);
				sl_shareObjectPanel.putConstraint(SpringLayout.EAST, shareBikeTypePanel, -10, SpringLayout.EAST, shareObjectPanel);
				shareBikeTypePanel.setVisible(false);
				sl_shareObjectPanel.putConstraint(SpringLayout.NORTH, shareBikeTypePanel, 0, SpringLayout.SOUTH, shareObjectTitleLabel);
				sl_shareObjectPanel.putConstraint(SpringLayout.WEST, shareBikeTypePanel, 10, SpringLayout.WEST, shareObjectPanel);
				shareObjectPanel.add(shareBikeTypePanel);
				SpringLayout sl_shareBikeTypePanel = new SpringLayout();
				shareBikeTypePanel.setLayout(sl_shareBikeTypePanel);
				
				JLabel lblTypeBike = new JLabel("Type : Bike");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblTypeBike, 0, SpringLayout.NORTH, shareBikeTypePanel);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblTypeBike, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblTypeBike);
				
				JLabel lblMark = new JLabel("Mark");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblMark, 6, SpringLayout.SOUTH, lblTypeBike);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblMark, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblMark);
				
				JLabel lblFrame = new JLabel("Frame size");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblFrame, 0, SpringLayout.SOUTH, lblMark);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblFrame, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblFrame);
				
				JLabel lblAmountOfSpeeds = new JLabel("Amount of speeds");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblAmountOfSpeeds, 0, SpringLayout.SOUTH, lblFrame);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblAmountOfSpeeds, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblAmountOfSpeeds);
				
				JLabel lblWheelSize = new JLabel("Wheel size");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblWheelSize, 0, SpringLayout.SOUTH, lblAmountOfSpeeds);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblWheelSize, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblWheelSize);
				
				JLabel lblBrake = new JLabel("Brake");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblBrake, 0, SpringLayout.SOUTH, lblWheelSize);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblBrake, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblBrake);
				
				JLabel lblType = new JLabel("Type");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblType, 0, SpringLayout.SOUTH, lblBrake);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblType, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblType);
				
				JLabel lblColor = new JLabel("Color");
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, lblColor, 0, SpringLayout.SOUTH, lblType);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.WEST, lblColor, 0, SpringLayout.WEST, shareBikeTypePanel);
				shareBikeTypePanel.add(lblColor);
				
				bicycleMarkField = new JTextField();
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, bicycleMarkField, 0, SpringLayout.NORTH, lblMark);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.EAST, bicycleMarkField, 0, SpringLayout.EAST, shareBikeTypePanel);
				bicycleMarkField.setColumns(10);
				shareBikeTypePanel.add(bicycleMarkField);
				
				bicycleFrameField = new JTextField();
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, bicycleFrameField, 0, SpringLayout.NORTH, lblFrame);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.EAST, bicycleFrameField, 0, SpringLayout.EAST, shareBikeTypePanel);
				bicycleFrameField.setColumns(10);
				shareBikeTypePanel.add(bicycleFrameField);
				
				bicycleSpeedsField = new JTextField();
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, bicycleSpeedsField, 0, SpringLayout.NORTH, lblAmountOfSpeeds);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.EAST, bicycleSpeedsField, 0, SpringLayout.EAST, shareBikeTypePanel);
				bicycleSpeedsField.setColumns(10);
				shareBikeTypePanel.add(bicycleSpeedsField);
				
				bicycleWheelField = new JTextField();
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, bicycleWheelField, 0, SpringLayout.NORTH, lblWheelSize);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.EAST, bicycleWheelField, 0, SpringLayout.EAST, shareBikeTypePanel);
				bicycleWheelField.setColumns(10);
				shareBikeTypePanel.add(bicycleWheelField);
				
				bicycleBrakeField = new JTextField();
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, bicycleBrakeField, 0, SpringLayout.NORTH, lblBrake);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.EAST, bicycleBrakeField, 0, SpringLayout.EAST, shareBikeTypePanel);
				bicycleBrakeField.setColumns(10);
				shareBikeTypePanel.add(bicycleBrakeField);
				
				bicycleTypeField = new JTextField();
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, bicycleTypeField, 0, SpringLayout.NORTH, lblType);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.EAST, bicycleTypeField, 0, SpringLayout.EAST, shareBikeTypePanel);
				bicycleTypeField.setColumns(10);
				shareBikeTypePanel.add(bicycleTypeField);
				
				bicycleColorField = new JTextField();
				sl_shareBikeTypePanel.putConstraint(SpringLayout.NORTH, bicycleColorField, 0, SpringLayout.NORTH, lblColor);
				sl_shareBikeTypePanel.putConstraint(SpringLayout.EAST, bicycleColorField, 0, SpringLayout.EAST, shareBikeTypePanel);
				bicycleColorField.setColumns(10);
				shareBikeTypePanel.add(bicycleColorField);
				springLayout.putConstraint(SpringLayout.WEST, btnDisconnect, 0, SpringLayout.WEST, afterLogPanel);
				afterLogPanel.add(btnDisconnect);
				
				searchObjPanel = new JPanel();
				sl_afterLogPanel.putConstraint(SpringLayout.WEST, searchObjPanel, 10, SpringLayout.EAST, shareObjectPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.EAST, searchObjPanel, 300, SpringLayout.EAST, shareObjectPanel);
				searchObjPanel.setBackground(Color.LIGHT_GRAY);
				sl_afterLogPanel.putConstraint(SpringLayout.NORTH, searchObjPanel, 6, SpringLayout.SOUTH, giveBackPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.SOUTH, searchObjPanel, 390, SpringLayout.NORTH, afterLogPanel);
				afterLogPanel.add(searchObjPanel);
				SpringLayout sl_searchObjPanel = new SpringLayout();
				searchObjPanel.setLayout(sl_searchObjPanel);
				 
				searchObjectPanel = new JPanel();
				sl_searchObjPanel.putConstraint(SpringLayout.NORTH, searchObjectPanel, 6, SpringLayout.NORTH, searchObjPanel);
				sl_searchObjPanel.putConstraint(SpringLayout.WEST, searchObjectPanel, 6, SpringLayout.WEST, searchObjPanel);
				sl_searchObjPanel.putConstraint(SpringLayout.SOUTH, searchObjectPanel, -6, SpringLayout.SOUTH, searchObjPanel);
				sl_searchObjPanel.putConstraint(SpringLayout.EAST, searchObjectPanel, -6, SpringLayout.EAST, searchObjPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.NORTH, searchObjectPanel, 0, SpringLayout.NORTH, searchObjPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.WEST, searchObjectPanel, 0, SpringLayout.WEST, searchObjPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.SOUTH, searchObjectPanel, 0, SpringLayout.SOUTH, searchObjPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.EAST, searchObjectPanel, 0, SpringLayout.EAST, searchObjPanel);
				searchObjPanel.add(searchObjectPanel);
				SpringLayout sl_searchObjectPanel = new SpringLayout();
				searchObjectPanel.setLayout(sl_searchObjectPanel);
				
				JLabel lblSearch = new JLabel("Search");
				sl_searchObjectPanel.putConstraint(SpringLayout.NORTH, lblSearch, 0, SpringLayout.NORTH, searchObjectPanel);
				sl_searchObjectPanel.putConstraint(SpringLayout.WEST, lblSearch, 0, SpringLayout.WEST, searchObjectPanel);
				searchObjectPanel.add(lblSearch);
				 
				JComboBox comboBox_1 = new JComboBox();
				sl_searchObjectPanel.putConstraint(SpringLayout.NORTH, comboBox_1, 10, SpringLayout.SOUTH, lblSearch);
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Type", "Price", "Avaibility", "Proximity"}));
				sl_searchObjectPanel.putConstraint(SpringLayout.WEST, comboBox_1, 0, SpringLayout.WEST, lblSearch);
				searchObjectPanel.add(comboBox_1);
				
				searchField = new JTextField();
				sl_searchObjectPanel.putConstraint(SpringLayout.SOUTH, searchField, 0, SpringLayout.SOUTH, comboBox_1);
				sl_searchObjectPanel.putConstraint(SpringLayout.EAST, searchField, 0, SpringLayout.EAST, searchObjectPanel);
				searchObjectPanel.add(searchField);
				searchField.setColumns(10);
				
				btnMoreOption = new JButton("More option");
				btnMoreOption.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						searchObjectComplexePanel.setVisible(true);
						searchObjectPanel.setVisible(false);
					}
				});
				sl_searchObjectPanel.putConstraint(SpringLayout.SOUTH, btnMoreOption, 0, SpringLayout.SOUTH, searchObjectPanel);
				sl_searchObjectPanel.putConstraint(SpringLayout.EAST, btnMoreOption, 0, SpringLayout.EAST, searchObjectPanel);
				searchObjectPanel.add(btnMoreOption);
				
				searchSimpleButton = new JButton("Search");
				searchSimpleButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object[][] rows = {
							    {"element","symbol","atomicNumber","atomicMass","valence"},
							    {"element","symbol","atomicNumber","atomicMass","valence"}
							};
							Object[] cols = {
							    "ID","Price","ShareTime","Type", "avaible"
							};
							JTable table = new JTable(rows, cols);
							JOptionPane.showMessageDialog(null, new JScrollPane(table), "Results", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				sl_searchObjectPanel.putConstraint(SpringLayout.SOUTH, searchSimpleButton, 0, SpringLayout.NORTH, btnMoreOption);
				sl_searchObjectPanel.putConstraint(SpringLayout.EAST, searchSimpleButton, 0, SpringLayout.EAST, btnMoreOption);
				searchObjectPanel.add(searchSimpleButton);
				
				searchObjectComplexePanel = new JPanel();
				sl_searchObjPanel.putConstraint(SpringLayout.NORTH, searchObjectComplexePanel, 6, SpringLayout.NORTH, searchObjPanel);
				sl_searchObjPanel.putConstraint(SpringLayout.WEST, searchObjectComplexePanel, 6, SpringLayout.WEST, searchObjPanel);
				sl_searchObjPanel.putConstraint(SpringLayout.SOUTH, searchObjectComplexePanel, -6, SpringLayout.SOUTH, searchObjPanel);
				sl_searchObjPanel.putConstraint(SpringLayout.EAST, searchObjectComplexePanel, -6, SpringLayout.EAST, searchObjPanel);

				searchObjectComplexePanel.setVisible(false);
				searchObjPanel.add(searchObjectComplexePanel);
				SpringLayout sl_searchObjectComplexePanel = new SpringLayout();
				searchObjectComplexePanel.setLayout(sl_searchObjectComplexePanel);
				
				lblSearchAdvanced = new JLabel("Search advanced");
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.NORTH, lblSearchAdvanced, 0, SpringLayout.NORTH, searchObjectComplexePanel);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.WEST, lblSearchAdvanced, 0, SpringLayout.WEST, searchObjectComplexePanel);
				searchObjectComplexePanel.add(lblSearchAdvanced);
				
				lblPrice = new JLabel("Price < ");
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.NORTH, lblPrice, 10, SpringLayout.SOUTH, lblSearchAdvanced);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.WEST, lblPrice, 0, SpringLayout.WEST, lblSearchAdvanced);
				searchObjectComplexePanel.add(lblPrice);
				
				lblDistance = new JLabel("Distance <");
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.NORTH, lblDistance, 0, SpringLayout.SOUTH, lblPrice);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.WEST, lblDistance, 0, SpringLayout.WEST, searchObjectComplexePanel);
				searchObjectComplexePanel.add(lblDistance);
				
				lblType_1 = new JLabel("type");
				searchObjectComplexePanel.add(lblType_1);
				
				lblAvaible = new JLabel("Avaible ");
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.WEST, lblAvaible, 0, SpringLayout.WEST, lblSearchAdvanced);
				searchObjectComplexePanel.add(lblAvaible);
				
				searchPriceField = new JTextField();
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.SOUTH, searchPriceField, 0, SpringLayout.SOUTH, lblPrice);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.EAST, searchPriceField, 0, SpringLayout.EAST, searchObjectComplexePanel);
				searchObjectComplexePanel.add(searchPriceField);
				searchPriceField.setColumns(10);
				
				searchDistanceField = new JTextField();
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.NORTH, searchDistanceField, 0, SpringLayout.NORTH, lblDistance);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.EAST, searchDistanceField, 0, SpringLayout.EAST, searchPriceField);
				searchObjectComplexePanel.add(searchDistanceField);
				searchDistanceField.setColumns(10);
				
				searchTypeComboBox = new JComboBox();
				searchTypeComboBox.setMaximumRowCount(3);
				searchTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Car", "House", "Bike"}));
				searchTypeComboBox.setSelectedIndex(0);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.SOUTH, lblType_1, 0, SpringLayout.SOUTH, searchTypeComboBox);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.NORTH, searchTypeComboBox, 0, SpringLayout.SOUTH, searchDistanceField);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.EAST, searchTypeComboBox, 0, SpringLayout.EAST, searchPriceField);
				searchObjectComplexePanel.add(searchTypeComboBox);
				
				searchAvaibleCombobox = new JComboBox();
				searchAvaibleCombobox.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
				searchAvaibleCombobox.setSelectedIndex(0);
				searchAvaibleCombobox.setMaximumRowCount(2);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.SOUTH, lblAvaible, 0, SpringLayout.SOUTH, searchAvaibleCombobox);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.NORTH, searchAvaibleCombobox, 0, SpringLayout.SOUTH, searchTypeComboBox);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.EAST, searchAvaibleCombobox, 0, SpringLayout.EAST, searchPriceField);
				searchObjectComplexePanel.add(searchAvaibleCombobox);
				
				btnSearchObjComplexe = new JButton("Search");
				btnSearchObjComplexe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Object[][] rows = {
							    {"element","symbol","atomicNumber","atomicMass","valence"},
							    {"element","symbol","atomicNumber","atomicMass","valence"}
							};
							Object[] cols = {
							    "ID","Price","ShareTime","Type", "avaible"
							};
							JTable table = new JTable(rows, cols);
							JOptionPane.showMessageDialog(null, new JScrollPane(table), "Results", JOptionPane.INFORMATION_MESSAGE);
							
						searchObjectComplexePanel.setVisible(false);
						searchObjectPanel.setVisible(true);
					}
				});
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.SOUTH, btnSearchObjComplexe, 0, SpringLayout.SOUTH, searchObjectComplexePanel);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.EAST, btnSearchObjComplexe, 0, SpringLayout.EAST, searchPriceField);
				searchObjectComplexePanel.add(btnSearchObjComplexe);
				
				btnSearchObjBack = new JButton("Back");
				btnSearchObjBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						searchObjectComplexePanel.setVisible(false);
						searchObjectPanel.setVisible(true);
					}
				});
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.NORTH, btnSearchObjBack, 0, SpringLayout.NORTH, btnSearchObjComplexe);
				sl_searchObjectComplexePanel.putConstraint(SpringLayout.WEST, btnSearchObjBack, 0, SpringLayout.WEST, searchObjectComplexePanel);
				searchObjectComplexePanel.add(btnSearchObjBack);
				
				myObjectPanel = new JPanel();
				myObjectPanel.setBackground(Color.LIGHT_GRAY);
				sl_afterLogPanel.putConstraint(SpringLayout.NORTH, myObjectPanel, 0, SpringLayout.NORTH, shareObjectPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.WEST, myObjectPanel, 11, SpringLayout.EAST, searchObjPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.SOUTH, myObjectPanel, 0, SpringLayout.SOUTH, shareObjectPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.EAST, myObjectPanel, 300, SpringLayout.EAST, searchObjPanel);
				afterLogPanel.add(myObjectPanel);
				SpringLayout sl_myObjectPanel = new SpringLayout();
				myObjectPanel.setLayout(sl_myObjectPanel);
				
				lblMyObject = new JLabel("My Object");
				sl_myObjectPanel.putConstraint(SpringLayout.NORTH, lblMyObject, 0, SpringLayout.NORTH, myObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.WEST, lblMyObject, 0, SpringLayout.WEST, myObjectPanel);
				myObjectPanel.add(lblMyObject);
				
				btnSeeMyObject = new JButton("See my Object");
				sl_myObjectPanel.putConstraint(SpringLayout.NORTH, btnSeeMyObject, 0, SpringLayout.NORTH, myObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.EAST, btnSeeMyObject, 0, SpringLayout.EAST, myObjectPanel);
				btnSeeMyObject.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object[][] rows = {
							    {"element","symbol","atomicNumber","atomicMass","valence"},
							    {"element","symbol","atomicNumber","atomicMass","valence"}
							};
							Object[] cols = {
							    "ID","Price","ShareTime","Type", "avaible"
							};
							JTable table = new JTable(rows, cols);
							JOptionPane.showMessageDialog(null, new JScrollPane(table), "Results", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				myObjectPanel.add(btnSeeMyObject);
				
				Modifpanel = new JPanel();
				sl_myObjectPanel.putConstraint(SpringLayout.NORTH, Modifpanel, 0, SpringLayout.SOUTH, btnSeeMyObject);
				sl_myObjectPanel.putConstraint(SpringLayout.WEST, Modifpanel, 10, SpringLayout.WEST, myObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.SOUTH, Modifpanel, -177, SpringLayout.SOUTH, myObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.EAST, Modifpanel, -6, SpringLayout.EAST, myObjectPanel);
				myObjectPanel.add(Modifpanel);
				SpringLayout sl_Modifpanel = new SpringLayout();
				Modifpanel.setLayout(sl_Modifpanel);
				
				lblModificationById = new JLabel("Modification by ID");
				sl_Modifpanel.putConstraint(SpringLayout.NORTH, lblModificationById, 0, SpringLayout.NORTH, Modifpanel);
				sl_Modifpanel.putConstraint(SpringLayout.WEST, lblModificationById, 0, SpringLayout.WEST, Modifpanel);
				Modifpanel.add(lblModificationById);
				
				btnModif = new JButton("Modif");
				sl_Modifpanel.putConstraint(SpringLayout.SOUTH, btnModif, 0, SpringLayout.SOUTH, Modifpanel);
				sl_Modifpanel.putConstraint(SpringLayout.EAST, btnModif, 0, SpringLayout.EAST, Modifpanel);
				Modifpanel.add(btnModif);
				
				ModificationComboBox = new JComboBox();
				ModificationComboBox.setMaximumRowCount(4);
				ModificationComboBox.setModel(new DefaultComboBoxModel(new String[] {"Disponibility", "Price", "Share Time", "Description"}));
				ModificationComboBox.setSelectedIndex(0);
				sl_Modifpanel.putConstraint(SpringLayout.WEST, ModificationComboBox, 0, SpringLayout.WEST, lblModificationById);
				Modifpanel.add(ModificationComboBox);
				
				ModificationArea = new JTextArea();
				ModificationArea.setBackground(Color.WHITE);
				ModificationArea.setLineWrap(true);
				sl_Modifpanel.putConstraint(SpringLayout.NORTH, ModificationArea, 0, SpringLayout.NORTH, ModificationComboBox);
				sl_Modifpanel.putConstraint(SpringLayout.WEST, ModificationArea, 0, SpringLayout.EAST, ModificationComboBox);
				sl_Modifpanel.putConstraint(SpringLayout.SOUTH, ModificationArea, 0, SpringLayout.NORTH, btnModif);
				sl_Modifpanel.putConstraint(SpringLayout.EAST, ModificationArea, 0, SpringLayout.EAST, Modifpanel);
				Modifpanel.add(ModificationArea);
				ModificationArea.setColumns(10);
				
				JPanel findUserbyObjectPanel = new JPanel();
				sl_myObjectPanel.putConstraint(SpringLayout.NORTH, findUserbyObjectPanel, 3, SpringLayout.SOUTH, Modifpanel);
				sl_myObjectPanel.putConstraint(SpringLayout.WEST, findUserbyObjectPanel, 10, SpringLayout.WEST, myObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.SOUTH, findUserbyObjectPanel, 95, SpringLayout.SOUTH, Modifpanel);
				
				lblmodifObjectID = new JLabel("Object ID");
				sl_Modifpanel.putConstraint(SpringLayout.NORTH, lblmodifObjectID, 3, SpringLayout.SOUTH, lblModificationById);
				sl_Modifpanel.putConstraint(SpringLayout.WEST, lblmodifObjectID, 0, SpringLayout.WEST, Modifpanel);
				Modifpanel.add(lblmodifObjectID);
				
				modifObjectIDField = new JTextField();
				sl_Modifpanel.putConstraint(SpringLayout.NORTH, ModificationComboBox, 0, SpringLayout.SOUTH, modifObjectIDField);
				sl_Modifpanel.putConstraint(SpringLayout.NORTH, modifObjectIDField, 0, SpringLayout.NORTH, lblmodifObjectID);
				sl_Modifpanel.putConstraint(SpringLayout.EAST, modifObjectIDField, 0, SpringLayout.EAST, Modifpanel);
				Modifpanel.add(modifObjectIDField);
				modifObjectIDField.setColumns(10);
				sl_myObjectPanel.putConstraint(SpringLayout.EAST, findUserbyObjectPanel, -6, SpringLayout.EAST, myObjectPanel);
				myObjectPanel.add(findUserbyObjectPanel);
				SpringLayout sl_findUserbyObjectPanel = new SpringLayout();
				findUserbyObjectPanel.setLayout(sl_findUserbyObjectPanel);
				 
				JLabel lblUserWithMy = new JLabel("User with my object");
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.NORTH, lblUserWithMy, 0, SpringLayout.NORTH, findUserbyObjectPanel);
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.WEST, lblUserWithMy, 0, SpringLayout.WEST, findUserbyObjectPanel);
				findUserbyObjectPanel.add(lblUserWithMy);
				
				JLabel lblObjectId = new JLabel("Object ID");
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.NORTH, lblObjectId, 6, SpringLayout.SOUTH, lblUserWithMy);
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.WEST, lblObjectId, 0, SpringLayout.WEST, lblUserWithMy);
				findUserbyObjectPanel.add(lblObjectId);
				
				JComboBox userByObjectcomboBox = new JComboBox();
				userByObjectcomboBox.setModel(new DefaultComboBoxModel(new String[] {"All user who touch it", "The last one"}));
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.WEST, userByObjectcomboBox, 0, SpringLayout.WEST, lblUserWithMy);
				findUserbyObjectPanel.add(userByObjectcomboBox);
				
				JButton btnFind = new JButton("Find");
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.NORTH, btnFind, 0, SpringLayout.NORTH, userByObjectcomboBox);
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.EAST, btnFind, 0, SpringLayout.EAST, findUserbyObjectPanel);
				findUserbyObjectPanel.add(btnFind);
				
				userOnjectIdField = new JTextField();
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.NORTH, userByObjectcomboBox, 0, SpringLayout.SOUTH, userOnjectIdField);
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.NORTH, userOnjectIdField, 0, SpringLayout.NORTH, lblObjectId);
				sl_findUserbyObjectPanel.putConstraint(SpringLayout.EAST, userOnjectIdField, 0, SpringLayout.EAST, findUserbyObjectPanel);
				findUserbyObjectPanel.add(userOnjectIdField);
				userOnjectIdField.setColumns(10);
				
				findInterrestedpanel = new JPanel();
				sl_myObjectPanel.putConstraint(SpringLayout.NORTH, findInterrestedpanel, 6, SpringLayout.SOUTH, findUserbyObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.WEST, findInterrestedpanel, 10, SpringLayout.WEST, myObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.SOUTH, findInterrestedpanel, -6, SpringLayout.SOUTH, myObjectPanel);
				sl_myObjectPanel.putConstraint(SpringLayout.EAST, findInterrestedpanel, -6, SpringLayout.EAST, myObjectPanel);
				myObjectPanel.add(findInterrestedpanel);
				SpringLayout sl_findInterrestedpanel = new SpringLayout();
				findInterrestedpanel.setLayout(sl_findInterrestedpanel);
				
				lblUsersInterrestedBy = new JLabel("Users interrested by my objects");
				sl_findInterrestedpanel.putConstraint(SpringLayout.NORTH, lblUsersInterrestedBy, 0, SpringLayout.NORTH, findInterrestedpanel);
				sl_findInterrestedpanel.putConstraint(SpringLayout.WEST, lblUsersInterrestedBy, 0, SpringLayout.WEST, findInterrestedpanel);
				findInterrestedpanel.add(lblUsersInterrestedBy);
				
				lblObjectId_1 = new JLabel("Object ID");
				sl_findInterrestedpanel.putConstraint(SpringLayout.NORTH, lblObjectId_1, 6, SpringLayout.SOUTH, lblUsersInterrestedBy);
				sl_findInterrestedpanel.putConstraint(SpringLayout.WEST, lblObjectId_1, 0, SpringLayout.WEST, findInterrestedpanel);
				findInterrestedpanel.add(lblObjectId_1);
				
				usersInterrestedField = new JTextField();
				sl_findInterrestedpanel.putConstraint(SpringLayout.NORTH, usersInterrestedField, 0, SpringLayout.NORTH, lblObjectId_1);
				sl_findInterrestedpanel.putConstraint(SpringLayout.EAST, usersInterrestedField, 0, SpringLayout.EAST, findInterrestedpanel);
				findInterrestedpanel.add(usersInterrestedField);
				usersInterrestedField.setColumns(10);
				
				btnFind_1 = new JButton("Find");
				sl_findInterrestedpanel.putConstraint(SpringLayout.SOUTH, btnFind_1, 0, SpringLayout.SOUTH, findInterrestedpanel);
				sl_findInterrestedpanel.putConstraint(SpringLayout.EAST, btnFind_1, 0, SpringLayout.EAST, usersInterrestedField);
				findInterrestedpanel.add(btnFind_1);
				
				otherPanel = new JPanel();
				otherPanel.setBackground(Color.LIGHT_GRAY);
				sl_afterLogPanel.putConstraint(SpringLayout.NORTH, otherPanel, 0, SpringLayout.NORTH, myObjectPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.WEST, otherPanel, 2, SpringLayout.EAST, myObjectPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.SOUTH, otherPanel, 0, SpringLayout.SOUTH, myObjectPanel);
				sl_afterLogPanel.putConstraint(SpringLayout.EAST, otherPanel, 270, SpringLayout.EAST, myObjectPanel);
				afterLogPanel.add(otherPanel);
				SpringLayout sl_otherPanel = new SpringLayout();
				otherPanel.setLayout(sl_otherPanel);
				
				lblNewLabel = new JLabel("Notification");
				sl_otherPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.NORTH, otherPanel);
				sl_otherPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.WEST, otherPanel);
				otherPanel.add(lblNewLabel);
				
				btnGetMyNotification = new JButton("Get my Notification");
				sl_otherPanel.putConstraint(SpringLayout.NORTH, btnGetMyNotification, 6, SpringLayout.NORTH, otherPanel);
				sl_otherPanel.putConstraint(SpringLayout.EAST, btnGetMyNotification, -6, SpringLayout.EAST, otherPanel);
				otherPanel.add(btnGetMyNotification);
				
				lblRemoveNotification = new JLabel("Remove Notification");
				sl_otherPanel.putConstraint(SpringLayout.WEST, lblRemoveNotification, 6, SpringLayout.WEST, lblNewLabel);
				otherPanel.add(lblRemoveNotification);
				
				notificationTypeComboBox = new JComboBox();
				sl_otherPanel.putConstraint(SpringLayout.EAST, notificationTypeComboBox, -6, SpringLayout.EAST, otherPanel);
				notificationTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Car", "House", "Bike"}));
				notificationTypeComboBox.setSelectedIndex(0);
				sl_otherPanel.putConstraint(SpringLayout.NORTH, notificationTypeComboBox, 0, SpringLayout.NORTH, lblRemoveNotification);
				otherPanel.add(notificationTypeComboBox);
				
				btnRemove = new JButton("Remove");
				sl_otherPanel.putConstraint(SpringLayout.NORTH, btnRemove, 0, SpringLayout.SOUTH, notificationTypeComboBox);
				sl_otherPanel.putConstraint(SpringLayout.EAST, btnRemove, -6, SpringLayout.EAST, otherPanel);
				otherPanel.add(btnRemove);
				
				lblNotifyMeFor = new JLabel("Notify me for object ID");
				sl_otherPanel.putConstraint(SpringLayout.NORTH, lblNotifyMeFor, 6, SpringLayout.SOUTH, btnRemove);
				sl_otherPanel.putConstraint(SpringLayout.WEST, lblNotifyMeFor, 6, SpringLayout.WEST, otherPanel);
				otherPanel.add(lblNotifyMeFor);
				
				objectIdNotifField = new JTextField();
				sl_otherPanel.putConstraint(SpringLayout.NORTH, objectIdNotifField, 0, SpringLayout.SOUTH, lblNotifyMeFor);
				sl_otherPanel.putConstraint(SpringLayout.WEST, objectIdNotifField, 6, SpringLayout.WEST, otherPanel);
				otherPanel.add(objectIdNotifField);
				objectIdNotifField.setColumns(10);
				
				btnNotifyMe = new JButton("Notify me");
				sl_otherPanel.putConstraint(SpringLayout.NORTH, btnNotifyMe, 0, SpringLayout.NORTH, objectIdNotifField);
				sl_otherPanel.putConstraint(SpringLayout.WEST, btnNotifyMe, 0, SpringLayout.EAST, objectIdNotifField);
				sl_otherPanel.putConstraint(SpringLayout.EAST, btnNotifyMe, -6, SpringLayout.EAST, otherPanel);
				otherPanel.add(btnNotifyMe);
				
				btnSeeMyNotification_1 = new JButton("See my notification parameters ");
				sl_otherPanel.putConstraint(SpringLayout.EAST, btnSeeMyNotification_1, -6, SpringLayout.EAST, otherPanel);
				sl_otherPanel.putConstraint(SpringLayout.NORTH, lblRemoveNotification, 10, SpringLayout.SOUTH, btnSeeMyNotification_1);
				sl_otherPanel.putConstraint(SpringLayout.NORTH, btnSeeMyNotification_1, 0, SpringLayout.SOUTH, btnGetMyNotification);
				otherPanel.add(btnSeeMyNotification_1);
				
				btnGetMyUser = new JButton("Get my user info");
				sl_otherPanel.putConstraint(SpringLayout.SOUTH, btnGetMyUser, -10, SpringLayout.SOUTH, otherPanel);
				sl_otherPanel.putConstraint(SpringLayout.EAST, btnGetMyUser, 0, SpringLayout.EAST, btnGetMyNotification);
				otherPanel.add(btnGetMyUser);
				 
				
				btnDisconnect.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logPanel.setVisible(true);
						afterLogPanel.setVisible(false);
						shareObject.setVisible(false);
						btnShareBack.setVisible(false);
						chooseTypeSharepanel.setVisible(true);
						shareCarTypePanel.setVisible(false);
						shareHouseTypePanel.setVisible(false);
						shareBikeTypePanel.setVisible(false);
					}
				});
	}
}
