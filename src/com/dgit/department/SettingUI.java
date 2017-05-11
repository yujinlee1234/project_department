package com.dgit.department;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SettingUI extends JFrame {
	/* FIELDS */
	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnExport;
	private JButton btnImport;	
	/* MAIN */
	public static void main(String[] args) {
		new SettingUI();	
	}
	/* CONSTRUCTOR */
	public SettingUI() {		
		setTitle("DB관리 메뉴");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));
		
		btnInit = new JButton("초기화");		
		contentPane.add(btnInit);
		
		btnExport = new JButton("백업");
		contentPane.add(btnExport);
		
		btnImport = new JButton("복원");
		contentPane.add(btnImport);
		
		setVisible(true);		
		pack();
	}	
}
