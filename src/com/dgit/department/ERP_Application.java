package com.dgit.department;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dgit.department.ui.PanelDepartment;
import com.dgit.department.ui.PanelEmployee;
import com.dgit.department.ui.PanelTitle;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnEmployee;
	private JButton btnDepartment;
	private JButton btnTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_Application frame = new ERP_Application();
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
	public ERP_Application() {
		setTitle("대구 아이티 ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 20, 0));
		
		
		btnEmployee = new JButton("사원관리");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);
		
		btnDepartment = new JButton("부서관리");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
		
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitle) {
			btnTitleActionPerformed(e);
		}
		if (e.getSource() == btnDepartment) {
			btnDepartmentActionPerformed(e);
		}
		if (e.getSource() == btnEmployee) {
			btnEmployeeActionPerformed(e);
		}
	}
	protected void btnEmployeeActionPerformed(ActionEvent e) {
		//사원관리 클릭 시 
		ERP_Frame subFrame = new ERP_Frame();
		PanelEmployee ePanel = new PanelEmployee();
		subFrame.setTitle("사원 관리");
		subFrame.setContentPane(ePanel);
		subFrame.pack();
		subFrame.setVisible(true);
		subFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		//부서 관리 클릭 시
		ERP_Frame subFrame = new ERP_Frame();
		PanelDepartment dPanel = new PanelDepartment();
		subFrame.setTitle("부서 관리");
		subFrame.setContentPane(dPanel);
		subFrame.pack();
		subFrame.setVisible(true);	
		subFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	protected void btnTitleActionPerformed(ActionEvent e) {
		ERP_Frame subFrame = new ERP_Frame();
		PanelTitle tPanel = new PanelTitle();
		subFrame.setTitle("직책 관리");
		subFrame.setContentPane(tPanel);
		subFrame.pack();
		subFrame.setVisible(true);	
		subFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
