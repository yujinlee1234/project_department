package com.dgit.department;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	DataBaseSettingUI dbPanel;
	public static void main(String[] args) {
		new MainFrame();	
	}
	public MainFrame() {		
		setTitle("DB관리 메뉴");
		setBounds(50, 50, 350, 100);
		dbPanel = new DataBaseSettingUI();
		setContentPane(dbPanel);
		setVisible(true);		
	}	
}
