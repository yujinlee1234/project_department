package com.dgit.department.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameDepartment extends JFrame {

	private JPanel contentPane;
	private PanelDepartment dPanel;

	/**
	 * Create the frame.
	 */
	public FrameDepartment() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("부서 관리");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dPanel = new PanelDepartment();
		contentPane.add(dPanel, BorderLayout.CENTER);
		pack();
	}

}
