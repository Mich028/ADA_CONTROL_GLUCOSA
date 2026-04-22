package ADAGLUCOSA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	
	private HashMap<String, Persona> personas = new HashMap<>();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel<String> modeloLista;private JList<String> listaHistorial;
	
	
	private int convertirMes(String mes) {
        switch (mes) {
            case "Enero": return 1;
            case "Febrero": return 2;
            case "Marzo": return 3;
            case "Abril": return 4;
            case "Mayo": return 5;
            case "Junio": return 6;
            case "Julio": return 7;
            case "Agosto": return 8;
            case "Septiembre": return 9;
            case "Octubre": return 10;
            case "Noviembre": return 11;
            case "Diciembre": return 12;
            default: return 1;
        }
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo = new JLabel("Controlador de glucosa");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		Titulo.setBounds(128, 30, 164, 24);
		contentPane.add(Titulo);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblNombre.setBounds(10, 55, 164, 24);
		contentPane.add(lblNombre);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValor.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblValor.setBounds(10, 90, 164, 24);
		contentPane.add(lblValor);
		
		JLabel lblFecha = new JLabel("Dia:");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblFecha.setBounds(10, 137, 56, 24);
		contentPane.add(lblFecha);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(88, 59, 235, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 93, 235, 20);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox.setMaximumRowCount(30);
		comboBox.setBounds(53, 139, 56, 22);
		contentPane.add(comboBox);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setHorizontalAlignment(SwingConstants.LEFT);
		lblMes.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblMes.setBounds(137, 137, 56, 24);
		contentPane.add(lblMes);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBox_1.setMaximumRowCount(12);
		comboBox_1.setBounds(173, 139, 96, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblAo = new JLabel("Año:");
		lblAo.setHorizontalAlignment(SwingConstants.LEFT);
		lblAo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblAo.setBounds(290, 137, 56, 24);
		contentPane.add(lblAo);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"2026", "2027", "2028", "2029", "2030"}));
		comboBox_1_1.setMaximumRowCount(5);
		comboBox_1_1.setBounds(327, 139, 56, 22);
		contentPane.add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nombre = textField.getText();
			//	String Valor = textField_1.getText();
				int Valor = Integer.parseInt(textField_1.getText());
				int Dia = Integer.parseInt(comboBox.getSelectedItem().toString());
				String Mes = comboBox_1.getSelectedItem().toString();
				int mes = convertirMes(Mes);
				int Año = Integer.parseInt(comboBox_1_1.getSelectedItem().toString());
				LocalDate Fecha = LocalDate.of(Año, mes, Dia);
				
				Persona persona = personas.get(Nombre);
			    if (persona == null) {
			        persona = new Persona(Nombre);
			        personas.put(Nombre, persona);
			    }
			    
			    Registro registro = new Registro (Fecha, Valor);
			    persona.AgregarRegistro(registro);
			    
			    JOptionPane.showMessageDialog(null, "Registro guardado:\n" + "Persona: " + Nombre + "\n" + "Valor: " + Valor + " mg/dL\n" +"Fecha: " + Fecha);
			
		
				
			}
			
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\miche\\Downloads\\registrar.png"));
		btnNewButton.setBounds(128, 193, 154, 22);
		contentPane.add(btnNewButton);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 198, 35);
		contentPane.add(toolBar);
		
		modeloLista = new DefaultListModel<>();
		listaHistorial = new JList<>(modeloLista);
		JScrollPane scrollHistorial = new JScrollPane(listaHistorial);
		scrollHistorial.setBounds(10, 230, 380, 200);
		contentPane.add(scrollHistorial);
		
		
		JButton btnNewButton_1 = new JButton("Historial");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\miche\\Downloads\\hia.png"));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Busqueda");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\miche\\Downloads\\Busqueda.png"));
		toolBar.add(btnNewButton_1_1);

	}
}
