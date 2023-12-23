package of;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class son extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uzunlukField;
	private JTextField quaresmaField;
	private JTextField malzemeAdi;
	private JTextField malzemeKatsayi;
	private JTextField DEFLECTIONSONUC;
	private JTextField YOGUNLUKTEXT;
	private JTextField MAXIMUMMOMENTSONUC;
	private JTextField MAXIMUMSTRESSSONUC;
	private JTextField wField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					son frame = new son();
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
	public son() {
		setForeground(new Color(128, 128, 255));
		setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		setIconImage(Toolkit.getDefaultToolkit().getImage("fdf-logo.png"));
		setTitle("FDF FORCE CALCULATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(206, 231, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel malzemepaneli = new JPanel();
		malzemepaneli.setBackground(new Color(210, 232, 255));
		malzemepaneli.setBounds(0, 10, 161, 90);
		contentPane.add(malzemepaneli);
		malzemepaneli.setLayout(null);
		
		JLabel malzemelabel = new JLabel("MATERIAL");
		malzemelabel.setHorizontalAlignment(SwingConstants.CENTER);
		malzemelabel.setForeground(new Color(0, 55, 111));
		malzemelabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		malzemelabel.setBounds(10, 11, 141, 29);
		malzemelabel.setHorizontalTextPosition(SwingConstants.CENTER);
		malzemelabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		malzemepaneli.add(malzemelabel);
		
		
		
		
		
		//String[] malzemeliste = {"Alüminyum", "Çelik", "PVC"};
		//Double[] katsayiDizisi = {3.80952,1.26984,101.587};

		String[] malzemeliste = {};
		Double[] katsayiDizisi = {};
		
		
		
		
		DefaultComboBoxModel<Double> katsayiModel = new DefaultComboBoxModel<>(katsayiDizisi);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(malzemeliste);
		
		try {
		      BufferedReader reader = new BufferedReader(new FileReader("materialList.txt"));
		      String line;
		      while((line = reader.readLine()) != null) {
		    	  model.addElement(line);
		      }
		      reader.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		try {
		      BufferedReader reader = new BufferedReader(new FileReader("coefficientList.txt"));
		      String line;
		      while((line = reader.readLine()) != null) {
		    	  katsayiModel.addElement(Double.parseDouble(line));
		      }
		      reader.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		
		
		
		JComboBox<String> comboBox = new JComboBox<>(model);
		
		
		
		comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		comboBox.setBounds(10, 40, 141, 29);
		malzemepaneli.add(comboBox);
		
		JPanel uzunlukpaneli = new JPanel();
		uzunlukpaneli.setBackground(new Color(210, 232, 255));
		uzunlukpaneli.setLayout(null);
		uzunlukpaneli.setBounds(171, 10, 161, 90);
		contentPane.add(uzunlukpaneli);
		
		JLabel uzunlukLabel = new JLabel("LENGTH");
		uzunlukLabel.setHorizontalAlignment(SwingConstants.CENTER);
		uzunlukLabel.setForeground(new Color(0, 55, 111));
		uzunlukLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		uzunlukLabel.setVerticalTextPosition(SwingConstants.CENTER);
		uzunlukLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		uzunlukLabel.setBounds(10, 11, 141, 29);
		uzunlukpaneli.add(uzunlukLabel);
		
		uzunlukField = new JTextField();
		uzunlukField.setHorizontalAlignment(SwingConstants.RIGHT);
		uzunlukField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		uzunlukField.setBounds(10, 40, 141, 29);
		uzunlukpaneli.add(uzunlukField);
		uzunlukField.setColumns(10);
		
		JPanel gizemliOzellik = new JPanel();
		gizemliOzellik.setBackground(new Color(210, 232, 255));
		gizemliOzellik.setLayout(null);
		gizemliOzellik.setBounds(342, 10, 161, 90);
		contentPane.add(gizemliOzellik);
		
		JLabel lblQuaresma = new JLabel("Q");
		lblQuaresma.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuaresma.setForeground(new Color(0, 55, 111));
		lblQuaresma.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblQuaresma.setVerticalTextPosition(SwingConstants.CENTER);
		lblQuaresma.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQuaresma.setBounds(10, 11, 141, 29);
		gizemliOzellik.add(lblQuaresma);
		
		quaresmaField = new JTextField();
		quaresmaField.setHorizontalAlignment(SwingConstants.RIGHT);
		quaresmaField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		quaresmaField.setColumns(10);
		quaresmaField.setBounds(10, 40, 141, 29);
		gizemliOzellik.add(quaresmaField);
		
		JPanel ekleme = new JPanel();
		ekleme.setBackground(new Color(255, 255, 255));
		ekleme.setLayout(null);
		ekleme.setBounds(10, 269, 455, 99);
		contentPane.add(ekleme);
		
		JLabel eklemeLabel = new JLabel("ADD MATERIAL");
		eklemeLabel.setForeground(new Color(0, 55, 111));
		eklemeLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		eklemeLabel.setVerticalTextPosition(SwingConstants.CENTER);
		eklemeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		eklemeLabel.setBounds(10, 11, 141, 29);
		ekleme.add(eklemeLabel);
		
		malzemeAdi = new JTextField();
		malzemeAdi.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		malzemeAdi.setColumns(10);
		malzemeAdi.setBounds(10, 63, 141, 20);
		ekleme.add(malzemeAdi);
		
		JLabel lblMalzemeIsmi = new JLabel("Material Name:");
		lblMalzemeIsmi.setForeground(new Color(0, 55, 111));
		lblMalzemeIsmi.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblMalzemeIsmi.setVerticalTextPosition(SwingConstants.CENTER);
		lblMalzemeIsmi.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMalzemeIsmi.setBounds(10, 34, 141, 29);
		ekleme.add(lblMalzemeIsmi);
		
		JLabel lblMalzemeKatsays = new JLabel("Material Coefficient:");
		lblMalzemeKatsays.setForeground(new Color(0, 55, 111));
		lblMalzemeKatsays.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblMalzemeKatsays.setVerticalTextPosition(SwingConstants.CENTER);
		lblMalzemeKatsays.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMalzemeKatsays.setBounds(161, 34, 141, 29);
		ekleme.add(lblMalzemeKatsays);
		
		malzemeKatsayi = new JTextField();
		malzemeKatsayi.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		malzemeKatsayi.setColumns(10);
		malzemeKatsayi.setBounds(161, 63, 141, 20);
		ekleme.add(malzemeKatsayi);

		
		
		JButton eklemeButonu = new JButton("Add");
		eklemeButonu.setForeground(new Color(0, 55, 111));
		eklemeButonu.setFocusable(false);
		eklemeButonu.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		eklemeButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = malzemeAdi.getText();
			      String girilenKatsayi = malzemeKatsayi.getText();
				if(text.length() != 0 && girilenKatsayi.length() != 0) {
					model.addElement(text);
				      comboBox.setSelectedItem(text);
				      malzemeAdi.setText("");
				      
				     
				      try {
					      BufferedWriter writer = new BufferedWriter(new FileWriter("materialList.txt"));
					      for(int i = 0; i < model.getSize(); i++){
					    	  String name = model.getElementAt(i);
					    	  writer.write(name + "\n");
							}
					      writer.close();
					    } catch (IOException b) {
					      b.printStackTrace();
					    }
				      
				      
				      
				      katsayiModel.addElement(Double.parseDouble(malzemeKatsayi.getText()));
				      malzemeKatsayi.setText("");
				      
				      try {
					      BufferedWriter writer = new BufferedWriter(new FileWriter("coefficientList.txt"));
					      for(int i = 0; i < katsayiModel.getSize(); i++){
					    	  double name = katsayiModel.getElementAt(i);
					    	  writer.write(name + "\n");
							}
					      writer.close();
					    } catch (IOException b) {
					      b.printStackTrace();
					    }
				    
				}
			}
		});
		eklemeButonu.setBounds(312, 62, 117, 23);
		ekleme.add(eklemeButonu);
		
		
		
		
		DEFLECTIONSONUC = new JTextField();
		DEFLECTIONSONUC.setHorizontalAlignment(SwingConstants.RIGHT);
		DEFLECTIONSONUC.setText("0");
		DEFLECTIONSONUC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DEFLECTIONSONUC.setEditable(false);
		DEFLECTIONSONUC.setBounds(248, 137, 294, 34);
		contentPane.add(DEFLECTIONSONUC);
		DEFLECTIONSONUC.setColumns(10);
		
		JLabel DEFLECTIONLABEL = new JLabel("DEFLECTION");
		DEFLECTIONLABEL.setHorizontalAlignment(SwingConstants.RIGHT);
		DEFLECTIONLABEL.setForeground(new Color(0, 55, 111));
		DEFLECTIONLABEL.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		DEFLECTIONLABEL.setBounds(27, 138, 143, 34);
		contentPane.add(DEFLECTIONLABEL);
		
		JPanel YOGUNLUK = new JPanel();
		YOGUNLUK.setLayout(null);
		YOGUNLUK.setBackground(new Color(210, 232, 255));
		YOGUNLUK.setBounds(513, 10, 161, 90);
		contentPane.add(YOGUNLUK);
		
		JLabel Y = new JLabel("DENSITY");
		Y.setVerticalTextPosition(SwingConstants.CENTER);
		Y.setHorizontalTextPosition(SwingConstants.CENTER);
		Y.setHorizontalAlignment(SwingConstants.CENTER);
		Y.setForeground(new Color(0, 55, 111));
		Y.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		Y.setBounds(10, 11, 151, 29);
		YOGUNLUK.add(Y);
		
		YOGUNLUKTEXT = new JTextField();
		YOGUNLUKTEXT.setHorizontalAlignment(SwingConstants.RIGHT);
		YOGUNLUKTEXT.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		YOGUNLUKTEXT.setColumns(10);
		YOGUNLUKTEXT.setBounds(10, 40, 141, 29);
		YOGUNLUK.add(YOGUNLUKTEXT);
		
		MAXIMUMMOMENTSONUC = new JTextField();
		MAXIMUMMOMENTSONUC.setText("0");
		MAXIMUMMOMENTSONUC.setHorizontalAlignment(SwingConstants.RIGHT);
		MAXIMUMMOMENTSONUC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MAXIMUMMOMENTSONUC.setEditable(false);
		MAXIMUMMOMENTSONUC.setColumns(10);
		MAXIMUMMOMENTSONUC.setBounds(248, 182, 294, 34);
		contentPane.add(MAXIMUMMOMENTSONUC);
		
		MAXIMUMSTRESSSONUC = new JTextField();
		MAXIMUMSTRESSSONUC.setText("0");
		MAXIMUMSTRESSSONUC.setHorizontalAlignment(SwingConstants.RIGHT);
		MAXIMUMSTRESSSONUC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MAXIMUMSTRESSSONUC.setEditable(false);
		MAXIMUMSTRESSSONUC.setColumns(10);
		MAXIMUMSTRESSSONUC.setBounds(248, 226, 294, 34);
		contentPane.add(MAXIMUMSTRESSSONUC);
		
		JLabel MAXIMUMMOMENTLABEL = new JLabel("MAXIMUM MOMENT");
		MAXIMUMMOMENTLABEL.setHorizontalAlignment(SwingConstants.RIGHT);
		MAXIMUMMOMENTLABEL.setForeground(new Color(0, 55, 111));
		MAXIMUMMOMENTLABEL.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		MAXIMUMMOMENTLABEL.setBounds(10, 181, 228, 34);
		contentPane.add(MAXIMUMMOMENTLABEL);
		
		JLabel MAXIMUMSTRESSLABEL = new JLabel("MAXIMUM STRESS");
		MAXIMUMSTRESSLABEL.setHorizontalAlignment(SwingConstants.RIGHT);
		MAXIMUMSTRESSLABEL.setForeground(new Color(0, 55, 111));
		MAXIMUMSTRESSLABEL.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		MAXIMUMSTRESSLABEL.setBounds(-36, 227, 208, 34);
		contentPane.add(MAXIMUMSTRESSLABEL);
		
		JButton hesapla = new JButton("CALCULATE");
		hesapla.setBackground(Color.WHITE);
		hesapla.setForeground(new Color(0, 55, 111));
		hesapla.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		hesapla.setFocusable(false);
		hesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String katsayiString = "";	
				try {
					      BufferedReader reader = new BufferedReader(new FileReader("coefficientList.txt"));
					      for(int i = 0; i < comboBox.getSelectedIndex()+1; i++) {
					    	  katsayiString = reader.readLine();
								System.out.println("malzemeKatsayisi " + i + " = "+katsayiString);
					      }
					      reader.close();
					    } catch (IOException z) {
					      z.printStackTrace();
					    }
				double malzemeKatsayisi = Double.parseDouble(katsayiString);
				System.out.println("malzemeKatsayisi = "+malzemeKatsayisi);

				
				
				double uzunluk = Double.parseDouble(uzunlukField.getText());
				System.out.println("uzunluk = "+uzunluk);

				double quaresma = Double.parseDouble(quaresmaField.getText());
				System.out.println("quaresma = "+quaresma);
				
				double yogunluk = Double.parseDouble(YOGUNLUKTEXT.getText());
				System.out.println("yogunluk = "+yogunluk);
				
				
				double defHesapSonucu = (5*quaresma*uzunluk*uzunluk*uzunluk*uzunluk)/(malzemeKatsayisi*384*yogunluk);
				//System.out.println(defHesapSonucu);
				DEFLECTIONSONUC.setText(""+ defHesapSonucu + "cm");
				
				
				double maxMoment = (quaresma*uzunluk*uzunluk)/8;
				System.out.println(maxMoment);
				MAXIMUMMOMENTSONUC.setText("" + maxMoment );
				
				double w = Double.parseDouble(wField.getText());
				System.out.println(w);
				
				double maxStress = (maxMoment/w);
				System.out.println(maxMoment);
				MAXIMUMSTRESSSONUC.setText("" + maxStress );
				
				
				
				
			}
		});
		
		hesapla.setBounds(475, 307, 186, 61);
		contentPane.add(hesapla);
		
		JPanel wPanel = new JPanel();
		wPanel.setBounds(684, 10, 161, 90);
		contentPane.add(wPanel);
		wPanel.setLayout(null);
		wPanel.setBackground(new Color(210, 232, 255));
		
		JLabel malzemelabel_1_1 = new JLabel("W");
		malzemelabel_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		malzemelabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		malzemelabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		malzemelabel_1_1.setForeground(new Color(0, 55, 111));
		malzemelabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 9));
		malzemelabel_1_1.setBounds(0, 10, 151, 29);
		wPanel.add(malzemelabel_1_1);
		
		wField = new JTextField();
		wField.setHorizontalAlignment(SwingConstants.RIGHT);
		wField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		wField.setColumns(10);
		wField.setBounds(10, 40, 141, 29);
		wPanel.add(wField);
		
		
		
		
		
		
		
		
		
		JLabel lblLanguage = new JLabel("LANGUAGE ");
		
		
		lblLanguage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLanguage.setForeground(new Color(0, 55, 111));
		lblLanguage.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLanguage.setBounds(698, 295, 101, 34);
		contentPane.add(lblLanguage);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(595, 167, 222, 71);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("image (1).jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		
		uzunlukLabel.setText("BEAM LENGTH(cm)");
		lblQuaresma.setText("LOADING(kg/cm)");
		Y.setText("MOMENT OF INERTA(cm^4)");
		malzemelabel_1_1.setText("MOMENT OF STRENGTH(cm^4)");
		lblMalzemeKatsays.setText("Elasticity Modulus");
		MAXIMUMMOMENTLABEL.setText("MAXIMUM MOMENT (kgcm)");
		DEFLECTIONLABEL.setText("DEFLECTION(cm)");
		
		String[] languages = {"English","Deutsch"};
		JComboBox<String> languageBox = new JComboBox<String>(languages);
		languageBox.setBounds(671, 339, 168, 29);
		contentPane.add(languageBox);
		languageBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(languageBox.getSelectedIndex() == 0) {
					uzunlukLabel.setText("BEAM LENGTH(cm)");
					lblQuaresma.setText("LOADING(kg/cm)");
					Y.setText("MOMENT OF INERTA(cm^4)");
					malzemelabel_1_1.setText("MOMENT OF STRENGTH(cm^4)");
					lblMalzemeKatsays.setText("Elasticity Modulus");
					MAXIMUMMOMENTLABEL.setText("MAXIMUM MOMENT (kgcm)");
					DEFLECTIONLABEL.setText("DEFLECTION(cm)");
					
				}
				if(languageBox.getSelectedIndex() == 1) {
					uzunlukLabel.setText("LANGE(cm)");
					lblQuaresma.setText("LADEN(kg/cm)");
					Y.setText("TRÄGHEITSMOMENT(cm^4)");
					malzemelabel_1_1.setText("MOMENT DER KRAFT(cm^4)");
					lblMalzemeKatsays.setText("Elastizitätsmodul");
					MAXIMUMMOMENTLABEL.setText("MAXIMALER MOMENT (kgcm)");
					DEFLECTIONLABEL.setText("ABLENKUNG(cm)");
					
				}
			}
		});
		
		
	}
}
