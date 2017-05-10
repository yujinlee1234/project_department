package com.dgit.department;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class ERP_Application extends JFrame {

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
		contentPane.add(btnEmployee);
		
		btnDepartment = new JButton("부서관리");
		contentPane.add(btnDepartment);
		
		btnTitle = new JButton("직책관리");
		contentPane.add(btnTitle);
		
		pack();
	}

}
