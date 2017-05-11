package com.dgit.department;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dgit.department.ui.FrameDepartment;
import com.dgit.department.ui.FrameEmployee;
import com.dgit.department.ui.FrameTitle;
import com.dgit.department.ui.PanelDepartment;
import com.dgit.department.ui.PanelEmployee;
import com.dgit.department.ui.PanelTitle;

public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnEmployee;
	private JButton btnDepartment;
	private JButton btnTitle;
	private final FrameTitle tFrame;
	private final FrameDepartment dFrame;
	private final FrameEmployee eFrame;

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		tFrame = new FrameTitle();
		dFrame = new FrameDepartment();
		eFrame = new FrameEmployee();		
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
		PanelEmployee ePanel = new PanelEmployee();
		eFrame.setContentPane(ePanel);		
		eFrame.setVisible(true);	
		eFrame.pack();
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		//부서 관리 클릭 시
		PanelDepartment dPanel = new PanelDepartment();
		dFrame.setContentPane(dPanel);		
		dFrame.setVisible(true);
		dFrame.pack();
	}
	protected void btnTitleActionPerformed(ActionEvent e) {
		PanelTitle tPanel = new PanelTitle();		
		tFrame.setContentPane(tPanel);		
		tFrame.setVisible(true);
		tFrame.pack();
	}
}
