package br.com.xti.java.socket.chat.novo;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AcessFrame extends JFrame{
	private JLabel lbl_Nickname;
	private JTextField txt_Nickname;
	private JButton btn_Acess;
	
	public AcessFrame() {
		super("JumpJackChat - Acesso");
			
		setType(Type.UTILITY);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {160, 30};
		gridBagLayout.rowHeights = new int[] {15, 15};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
				
				btn_Acess = new JButton("Acessar");
				btn_Acess.setFont(new Font("Calibri", Font.PLAIN, 20));
				btn_Acess.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Client client  =  new Client(txt_Nickname.getText());
							new ClientView(client);
							new ClientView(new Client("Teste"));
							dispose();
						} catch (Exception error) {
							error.printStackTrace();
						}
					}
				});
				
				lbl_Nickname = new JLabel("Nickname:");
				lbl_Nickname.setFont(new Font("Calibri", Font.PLAIN, 20));
				lbl_Nickname.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_lbl_Nickname = new GridBagConstraints();
				gbc_lbl_Nickname.anchor = GridBagConstraints.SOUTH;
				gbc_lbl_Nickname.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl_Nickname.insets = new Insets(5, 5, 0, 5);
				gbc_lbl_Nickname.gridx = 0;
				gbc_lbl_Nickname.gridy = 0;
				getContentPane().add(lbl_Nickname, gbc_lbl_Nickname);
				txt_Nickname = new JTextField(0);
				txt_Nickname.setFont(new Font("Calibri", Font.PLAIN, 20));
				GridBagConstraints gbc_txt_Nickname = new GridBagConstraints();
				gbc_txt_Nickname.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_Nickname.anchor = GridBagConstraints.NORTH;
				gbc_txt_Nickname.insets = new Insets(0, 5, 5, 5);
				gbc_txt_Nickname.gridx = 0;
				gbc_txt_Nickname.gridy = 1;
				getContentPane().add(txt_Nickname, gbc_txt_Nickname);
				GridBagConstraints gbc_btn_Acess = new GridBagConstraints();
				gbc_btn_Acess.insets = new Insets(0, 5, 5, 5);
				gbc_btn_Acess.fill = GridBagConstraints.HORIZONTAL;
				gbc_btn_Acess.gridx = 1;
				gbc_btn_Acess.gridy = 1;
				getContentPane().add(btn_Acess, gbc_btn_Acess);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AcessFrame();
	}
}
