package of;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class noktasal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField length1Text;
	private JTextField length2Text;
	private JTextField lengthTotalText;
	private JTextField qText;
	private JTextField densityText;
	private JTextField deflectionText;
	private JTextField addMaterialNameText;
	private JTextField addMaterialCoefficientText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					noktasal frame = new noktasal();
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
	public noktasal() {
		setTitle("FDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(220, 213, 255));
		tabbedPane.setBounds(10, 11, 679, 394);
		contentPane.add(tabbedPane);
		
		JPanel calculatorPanelTab = new JPanel();
		calculatorPanelTab.setBackground(new Color(220, 213, 255));
		tabbedPane.addTab("Calculator", null, calculatorPanelTab, null);
		calculatorPanelTab.setLayout(null);
		
		JPanel materialPanel = new JPanel();
		materialPanel.setForeground(new Color(220, 213, 255));
		materialPanel.setBackground(new Color(220, 213, 255));
		materialPanel.setBounds(20, 11, 156, 232);
		calculatorPanelTab.add(materialPanel);
		materialPanel.setLayout(null);

		JLabel materialLabel = new JLabel("MATERIAL");
		materialLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		materialLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		materialLabel.setHorizontalAlignment(SwingConstants.CENTER);
		materialLabel.setForeground(new Color(140, 1, 216));
		materialLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		materialLabel.setBounds(10, 11, 136, 29);
		materialPanel.add(materialLabel);
		
		Vector<String> elementVector = new Vector<String>(1);
		Vector<Double> coefficientVector = new Vector<Double>(1);
		try {
		      BufferedReader reader = new BufferedReader(new FileReader("materialList.txt"));
		      String line;
		      while((line = reader.readLine()) != null) {
		    	  elementVector.addElement(line);
		      }
		      reader.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		try {
		      BufferedReader reader = new BufferedReader(new FileReader("coefficientList.txt"));
		      String line;
		      while((line = reader.readLine()) != null) {
		    	  coefficientVector.addElement(Double.parseDouble(line));
		      }
		      reader.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		JComboBox<String> materialComboBox = new JComboBox<String>(elementVector);
		materialComboBox.setBounds(10, 40, 136, 22);
		materialPanel.add(materialComboBox);
		
		JLabel fdfLogo = new JLabel("");
		fdfLogo.setBounds(0, 103, 151, 80);
		materialPanel.add(fdfLogo);
		fdfLogo.setIcon(new ImageIcon("C:\\Users\\Aziz\\eclipse-workspace\\projectX\\fdf-logo.png"));
		
		
		JPanel lengthPanel = new JPanel();
		lengthPanel.setBackground(new Color(220, 213, 255));
		lengthPanel.setBounds(176, 11, 156, 232);
		calculatorPanelTab.add(lengthPanel);
		lengthPanel.setLayout(null);
		
		JLabel length1Label = new JLabel("LENGTH 1 (a)");
		length1Label.setVerticalTextPosition(SwingConstants.CENTER);
		length1Label.setHorizontalTextPosition(SwingConstants.CENTER);
		length1Label.setHorizontalAlignment(SwingConstants.CENTER);
		length1Label.setForeground(new Color(140, 1, 216));
		length1Label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		length1Label.setBounds(10, 11, 136, 29);
		lengthPanel.add(length1Label);
		
		length1Text = new JTextField();
		length1Text.setHorizontalAlignment(SwingConstants.RIGHT);
		length1Text.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		length1Text.setColumns(10);
		length1Text.setBounds(10, 42, 136, 25);
		lengthPanel.add(length1Text);
		
		JLabel length2Label = new JLabel("LENGTH 2 (b)");
		length2Label.setVerticalTextPosition(SwingConstants.CENTER);
		length2Label.setHorizontalTextPosition(SwingConstants.CENTER);
		length2Label.setHorizontalAlignment(SwingConstants.CENTER);
		length2Label.setForeground(new Color(140, 1, 216));
		length2Label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		length2Label.setBounds(10, 82, 136, 29);
		lengthPanel.add(length2Label);
		
		length2Text = new JTextField();
		length2Text.setHorizontalAlignment(SwingConstants.RIGHT);
		length2Text.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		length2Text.setColumns(10);
		length2Text.setBounds(10, 112, 136, 25);
		lengthPanel.add(length2Text);
		
		JLabel lengthTotalLabel = new JLabel("LENGTH TOTAL");
		lengthTotalLabel.setVerticalTextPosition(SwingConstants.CENTER);
		lengthTotalLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lengthTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lengthTotalLabel.setForeground(new Color(140, 1, 216));
		lengthTotalLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lengthTotalLabel.setBounds(10, 152, 136, 29);
		lengthPanel.add(lengthTotalLabel);
		
		lengthTotalText = new JTextField();
		lengthTotalText.setHorizontalAlignment(SwingConstants.RIGHT);
		lengthTotalText.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lengthTotalText.setColumns(10);
		lengthTotalText.setBounds(10, 181, 136, 25);
		lengthPanel.add(lengthTotalText);
		
		JPanel qPanel = new JPanel();
		qPanel.setBackground(new Color(220, 213, 255));
		qPanel.setBounds(342, 11, 156, 90);
		calculatorPanelTab.add(qPanel);
		qPanel.setLayout(null);
		
		JLabel qLabel = new JLabel("Q");
		qLabel.setVerticalTextPosition(SwingConstants.CENTER);
		qLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		qLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qLabel.setForeground(new Color(140, 1, 216));
		qLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		qLabel.setBounds(10, 11, 136, 29);
		qPanel.add(qLabel);
		
		qText = new JTextField();
		qText.setHorizontalAlignment(SwingConstants.RIGHT);
		qText.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		qText.setColumns(10);
		qText.setBounds(10, 40, 136, 25);
		qPanel.add(qText);
		
		JPanel densityPanel = new JPanel();
		densityPanel.setBackground(new Color(220, 213, 255));
		densityPanel.setBounds(508, 11, 156, 90);
		calculatorPanelTab.add(densityPanel);
		densityPanel.setLayout(null);
		
		JLabel densityLabel = new JLabel("DENSITY");
		densityLabel.setVerticalTextPosition(SwingConstants.CENTER);
		densityLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		densityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		densityLabel.setForeground(new Color(140, 1, 216));
		densityLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		densityLabel.setBounds(10, 11, 136, 29);
		densityPanel.add(densityLabel);
		
		densityText = new JTextField();
		densityText.setHorizontalAlignment(SwingConstants.RIGHT);
		densityText.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		densityText.setColumns(10);
		densityText.setBounds(10, 40, 136, 25);
		densityPanel.add(densityText);
		
		JPanel deflectionPanel = new JPanel();
		deflectionPanel.setLayout(null);
		deflectionPanel.setBounds(176, 267, 483, 57);
		calculatorPanelTab.add(deflectionPanel);
		
		deflectionText = new JTextField();
		deflectionText.setText("0");
		deflectionText.setHorizontalAlignment(SwingConstants.RIGHT);
		deflectionText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deflectionText.setEditable(false);
		deflectionText.setColumns(10);
		deflectionText.setBounds(158, 11, 321, 34);
		deflectionPanel.add(deflectionText);
		
		JLabel deflectionLabel = new JLabel("DEFLECTION");
		deflectionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		deflectionLabel.setForeground(new Color(128, 0, 255));
		deflectionLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		deflectionLabel.setBounds(10, 12, 136, 34);
		deflectionPanel.add(deflectionLabel);
		
		JButton calculateButton = new JButton("CALCULATE");
		calculateButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		calculateButton.setForeground(new Color(128, 0, 255));
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coefficientString = "";	
				try {
					      BufferedReader reader = new BufferedReader(new FileReader("coefficientList.txt"));
					      for(int i = 0; i < materialComboBox.getSelectedIndex()+1; i++) {
					    	  coefficientString = reader.readLine();
								System.out.println("malzemeKatsayisi " + i + " = "+coefficientString);
					      }
					      reader.close();
					    } catch (IOException z) {
					      z.printStackTrace();
					    }
				
				double materialCoefficient = Double.parseDouble(coefficientString);

				System.out.println("malzemeKatsayisi = "+materialCoefficient);
				
				double lengthTotal = Double.parseDouble(lengthTotalText.getText());
				System.out.println("uzunluk = "+lengthTotal);

				double q = Double.parseDouble(qText.getText());
				System.out.println("quaresma = "+q);
				
				double density = Double.parseDouble(densityText.getText());
				System.out.println("yogunluk = "+density);
				
				
				double length1 = Double.parseDouble(length1Text.getText());
				System.out.println(length1);
				
				double length2 = Double.parseDouble(length2Text.getText());
				System.out.println(length2);
				
				double result = (q*length1*length2*length2*length2)/(3*materialCoefficient*density*lengthTotal);
				System.out.println(result);
				
				
				deflectionText.setText(""+result);
				
				
			}
		});
		calculateButton.setBackground(new Color(255, 255, 255));
		calculateButton.setBounds(10, 254, 156, 75);
		calculateButton.setFocusable(false);
		calculatorPanelTab.add(calculateButton);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon("C:\\Users\\Aziz\\eclipse-workspace\\projectX\\gorsel.jpg"));
		imageLabel.setBounds(370, 127, 254, 66);
		calculatorPanelTab.add(imageLabel);
		
		
		
		
		
		
		JPanel addPanelTab = new JPanel();
		tabbedPane.addTab("Add Material", null, addPanelTab, null);
		addPanelTab.setLayout(null);
		
		JPanel addPanel = new JPanel();
		addPanel.setLayout(null);
		addPanel.setBackground(Color.WHITE);
		addPanel.setBounds(10, 11, 654, 344);
		addPanelTab.add(addPanel);
		
		JLabel addLabel = new JLabel("ADD MATERIAL");
		addLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addLabel.setVerticalTextPosition(SwingConstants.CENTER);
		addLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		addLabel.setForeground(new Color(0, 55, 111));
		addLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		addLabel.setBounds(10, 11, 634, 62);
		addPanel.add(addLabel);
		
		JLabel addMaterialNameLabel = new JLabel("Material Name");
		addMaterialNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		addMaterialNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMaterialNameLabel.setBounds(80, 69, 184, 50);
		addPanel.add(addMaterialNameLabel);
		
		JLabel addMaterialCoefficientLabel = new JLabel("Material Coefficient");
		addMaterialCoefficientLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMaterialCoefficientLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		addMaterialCoefficientLabel.setBounds(363, 69, 227, 50);
		addPanel.add(addMaterialCoefficientLabel);
		
		addMaterialNameText = new JTextField();
		addMaterialNameText.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		addMaterialNameText.setBounds(80, 130, 184, 50);
		addPanel.add(addMaterialNameText);
		addMaterialNameText.setColumns(10);
		
		addMaterialCoefficientText = new JTextField();
		addMaterialCoefficientText.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		addMaterialCoefficientText.setColumns(10);
		addMaterialCoefficientText.setBounds(388, 130, 184, 50);
		addPanel.add(addMaterialCoefficientText);
		
		JButton addMaterialButton = new JButton("ADD");
		addMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newMaterialName = addMaterialNameText.getText();
				String newMaterialCoefficientStr = addMaterialCoefficientText.getText();
				Double newMaterialCoefficient = Double.parseDouble(newMaterialCoefficientStr);
				
				
				if(newMaterialName.length() != 0 && newMaterialCoefficientStr.length() != 0) {
					elementVector.addElement(newMaterialName);
					materialComboBox.setSelectedItem(newMaterialName);
					addMaterialNameText.setText("");
				      
				     
				      try {
					      BufferedWriter writer = new BufferedWriter(new FileWriter("materialList.txt"));
					      for(int i = 0; i < elementVector.size(); i++){
					    	  String name = elementVector.elementAt(i);
					    	  writer.write(name + "\n");
							}
					      writer.close();
					    } catch (IOException b) {
					      b.printStackTrace();
					    }
				      
				      
				      
				      coefficientVector.addElement(newMaterialCoefficient);
				      addMaterialCoefficientText.setText("");
				      
				      try {
					      BufferedWriter writer = new BufferedWriter(new FileWriter("coefficientList.txt"));
					      for(int i = 0; i < coefficientVector.size(); i++){
					    	  double coefficient = coefficientVector.elementAt(i);
					    	  writer.write(coefficient + "\n");
							}
					      writer.close();
					    } catch (IOException b) {
					      b.printStackTrace();
					    }
				    
				}
				
			}
		});
		addMaterialButton.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		addMaterialButton.setBounds(227, 218, 205, 50);
		addMaterialButton.setFocusable(false);
		addPanel.add(addMaterialButton);
		String[] languages = {"English","Deutsch"};
		JComboBox<String> languageBox = new JComboBox<String>(languages);
		languageBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(languageBox.getSelectedIndex() == 0) {
					materialLabel.setText("MATERIAL");
					length1Label.setText("LENGTH 1 (a)");
					length2Label.setText("LENGTH 2 (b)");
					lengthTotalLabel.setText("LENGTH TOTAL");
					densityLabel.setText("DENSITY");
					deflectionLabel.setText("DEFLECTION");
					calculateButton.setText("CALCULATE");
					addLabel.setText("ADD MATERIAL");
					addMaterialNameLabel.setText("MATERIAL NAME");
					addMaterialCoefficientLabel.setText("MATERIAL COEFFICIENT");
					addMaterialButton.setText("ADD");
				}
				if(languageBox.getSelectedIndex() == 1) {
					materialLabel.setText("MATERIAL");
					length1Label.setText("LANGE 1 (a)");
					length2Label.setText("LANGE 2 (b)");
					lengthTotalLabel.setText("GESAMTLANGE");
					densityLabel.setText("DICHTE");
					deflectionLabel.setText("ABLENKUNG");
					calculateButton.setText("BERECHNUNG");
					addLabel.setText("MATERIAL HINZUFÜGEN");
					addMaterialNameLabel.setText("MATERIAL NAME");
					addMaterialCoefficientLabel.setText("MATERIALKOEFFIZIENT");
					addMaterialButton.setText("HINZUFÜGEN");
				}
			}
		});

		languageBox.setBounds(577, 333, 82, 20);	
		
		calculatorPanelTab.add(languageBox);
	}
}
