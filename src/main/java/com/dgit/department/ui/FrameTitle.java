package com.dgit.department.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameTitle extends JFrame {

	private JPanel contentPane;
	private PanelTitle tPanel;

	/**
	 * Create the frame.
	 */
	public FrameTitle() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("직책 관리");
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setContentPane(contentPane);
		
		tPanel = new PanelTitle();		
		contentPane.add(tPanel, BorderLayout.CENTER);
		pack();
	}

}
