package com.dgit.department;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.dgit.department.setting.ExportSettingService;
import com.dgit.department.setting.ImportSettingService;
import com.dgit.department.setting.InitSettingService;
import com.dgit.department.setting.SettingService;

public class DataBaseSettingUI extends JPanel implements ActionListener {
	private JButton btnInit;
	private JButton btnExport;
	private JButton btnImport;
	private SettingService service;
	
	public DataBaseSettingUI() {		
		btnInit = new JButton("초기화");
		btnInit.addActionListener(this);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(btnInit);
		
		btnExport = new JButton("백업");
		btnExport.addActionListener(this);
		add(btnExport);
		
		btnImport = new JButton("복원");
		btnImport.addActionListener(this);
		add(btnImport);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnImport) {
			actionPerformedBtnImport(arg0);
		}
		if (arg0.getSource() == btnExport) {
			actionPerformedBtnExport(arg0);
		}
		if (arg0.getSource() == btnInit) {
			actionPerformedBtnInit(arg0);
		}
	}
	protected void actionPerformedBtnInit(ActionEvent arg0) {
		//초기화
		service = new InitSettingService();
		service.doSetting();		
	}
	protected void actionPerformedBtnExport(ActionEvent arg0) {
		//백업
		service = new ExportSettingService();
		service.doSetting();
		
	}
	protected void actionPerformedBtnImport(ActionEvent arg0) {
		//복원
		service = new ImportSettingService();
		service.doSetting();
	}
}
