package br.com.xti.java.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField txtResultado;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
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
	public Conversor() {
		setTitle("Conversor de temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 324, 0 };
		gbl_contentPane.rowHeights = new int[] { 111, 27, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(2, 2, 5, 5));

		JLabel lblFahrenheit = new JLabel("Fahrenheit:");
		lblFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFahrenheit.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel.add(lblFahrenheit);

		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.LEFT);
		txtValor.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtValor.setText("Valor");
		panel.add(txtValor);
		txtValor.setColumns(10);

		JLabel lblCelsius = new JLabel("Celsius:");
		lblCelsius.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelsius.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel.add(lblCelsius);

		txtResultado = new JTextField();
		txtResultado.setEnabled(false);
		txtResultado.setBackground(Color.WHITE);
		txtResultado.setHorizontalAlignment(SwingConstants.LEFT);
		txtResultado.setFont(new Font("Calibri", Font.PLAIN, 15));
		txtResultado.setText("Resultado");
		panel.add(txtResultado);
		txtResultado.setColumns(10);

		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double fahrenheit = Double.parseDouble(txtValor.getText());
				double celcius = (fahrenheit - 32) / 1.8;
				txtResultado.setText(celcius + " °c");

			}
		});
		btnConverter.setFont(new Font("Calibri", Font.PLAIN, 15));
		GridBagConstraints gbc_btnConverter = new GridBagConstraints();
		gbc_btnConverter.anchor = GridBagConstraints.NORTH;
		gbc_btnConverter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConverter.gridx = 0;
		gbc_btnConverter.gridy = 1;
		contentPane.add(btnConverter, gbc_btnConverter);
	}

}
