package com.resonance.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private RoundJTextArea textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setSize(new Dimension(1280, 720));
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(1280, 720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 21, 438, 594);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnEncuentraLosMejores = new JTextPane();
		txtpnEncuentraLosMejores.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		txtpnEncuentraLosMejores.setText("Encuentra los mejores lugares a los mejores precios");
		txtpnEncuentraLosMejores.setBounds(10, 11, 418, 69);
		panel.add(txtpnEncuentraLosMejores);
		
		JLabel lblDnde = new JLabel("D\u00D3NDE");
		lblDnde.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblDnde.setBounds(20, 91, 69, 14);
		panel.add(lblDnde);
		
		textField = new RoundJTextArea();
		textField.setBounds(10, 116, 273, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLlegada = new JLabel("LLEGADA");
		lblLlegada.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblLlegada.setBounds(20, 167, 69, 14);
		panel.add(lblLlegada);
		
		RoundJTextArea roundJTextArea = new RoundJTextArea();
		roundJTextArea.setColumns(10);
		roundJTextArea.setBounds(10, 192, 148, 31);
		panel.add(roundJTextArea);
		
		JLabel lblSalida = new JLabel("SALIDA");
		lblSalida.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblSalida.setBounds(257, 167, 69, 14);
		panel.add(lblSalida);
		
		RoundJTextArea roundJTextArea_1 = new RoundJTextArea();
		roundJTextArea_1.setColumns(10);
		roundJTextArea_1.setBounds(227, 192, 148, 31);
		panel.add(roundJTextArea_1);
		
		JLabel lblHuspedes = new JLabel("HU\u00C9SPEDES");
		lblHuspedes.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblHuspedes.setBounds(20, 271, 91, 14);
		panel.add(lblHuspedes);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 305, 178, 53);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(332, 555, 43, 14);
		panel.add(lblNewLabel);
	}
}
