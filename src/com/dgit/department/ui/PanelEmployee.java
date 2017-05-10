package com.dgit.department.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class PanelEmployee extends JPanel {
	private JTextField tfEno;
	private JTextField tfEname;
	private JTextField tfJoinDate;
	private JComboBox cmbTitle;
	private JSpinner spnSalary;
	private JPanel panel_employee;
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	private JComboBox cmbDepart;
	private JButton btnAdd;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public PanelEmployee() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_employee = new JPanel();
		panel_employee.setBorder(new EmptyBorder(10, 60, 0, 60));
		contentPane.add(panel_employee, BorderLayout.CENTER);
		GridBagLayout gbl_panel_employee = new GridBagLayout();
		gbl_panel_employee.columnWidths = new int[] {0, 0, 0};
		gbl_panel_employee.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gbl_panel_employee.columnWeights = new double[]{2.0, 1.0, 1.0};
		gbl_panel_employee.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_employee.setLayout(gbl_panel_employee);
		
		JLabel lblEno = new JLabel("번호");
		lblEno.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEno = new GridBagConstraints();
		gbc_lblEno.anchor = GridBagConstraints.EAST;
		gbc_lblEno.insets = new Insets(0, 0, 5, 5);
		gbc_lblEno.gridx = 0;
		gbc_lblEno.gridy = 0;
		panel_employee.add(lblEno, gbc_lblEno);
		
		tfEno = new JTextField();
		tfEno.setEditable(false);
		GridBagConstraints gbc_tfEno = new GridBagConstraints();
		gbc_tfEno.gridwidth = 2;
		gbc_tfEno.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEno.insets = new Insets(0, 0, 5, 0);
		gbc_tfEno.anchor = GridBagConstraints.NORTH;
		gbc_tfEno.gridx = 1;
		gbc_tfEno.gridy = 0;
		panel_employee.add(tfEno, gbc_tfEno);
		tfEno.setColumns(10);
		
		JLabel lblEname = new JLabel("사원명");
		GridBagConstraints gbc_lblEname = new GridBagConstraints();
		gbc_lblEname.anchor = GridBagConstraints.EAST;
		gbc_lblEname.insets = new Insets(0, 0, 5, 5);
		gbc_lblEname.gridx = 0;
		gbc_lblEname.gridy = 1;
		panel_employee.add(lblEname, gbc_lblEname);
		
		tfEname = new JTextField();
		tfEname.setColumns(10);
		GridBagConstraints gbc_tfEname = new GridBagConstraints();
		gbc_tfEname.gridwidth = 2;
		gbc_tfEname.insets = new Insets(0, 0, 5, 0);
		gbc_tfEname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEname.gridx = 1;
		gbc_tfEname.gridy = 1;
		panel_employee.add(tfEname, gbc_tfEname);
		
		JLabel lblTitle = new JLabel("직책");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 2;
		panel_employee.add(lblTitle, gbc_lblTitle);
		
		cmbTitle = new JComboBox();
		GridBagConstraints gbc_cmbTitle = new GridBagConstraints();
		gbc_cmbTitle.gridwidth = 2;
		gbc_cmbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTitle.gridx = 1;
		gbc_cmbTitle.gridy = 2;
		panel_employee.add(cmbTitle, gbc_cmbTitle);
		
		JLabel lblSalary = new JLabel("급여");
		GridBagConstraints gbc_lblSalary = new GridBagConstraints();
		gbc_lblSalary.anchor = GridBagConstraints.EAST;
		gbc_lblSalary.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalary.gridx = 0;
		gbc_lblSalary.gridy = 3;
		panel_employee.add(lblSalary, gbc_lblSalary);
		
		spnSalary = new JSpinner();
		GridBagConstraints gbc_spnSalary = new GridBagConstraints();
		gbc_spnSalary.gridwidth = 2;
		gbc_spnSalary.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnSalary.insets = new Insets(0, 0, 5, 0);
		gbc_spnSalary.gridx = 1;
		gbc_spnSalary.gridy = 3;
		panel_employee.add(spnSalary, gbc_spnSalary);
		
		JLabel lblGender = new JLabel("성별");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 4;
		panel_employee.add(lblGender, gbc_lblGender);
		
		rbtnMale = new JRadioButton("남");
		rbtnMale.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_rbtnMale = new GridBagConstraints();
		gbc_rbtnMale.anchor = GridBagConstraints.EAST;
		gbc_rbtnMale.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnMale.gridx = 1;
		gbc_rbtnMale.gridy = 4;
		panel_employee.add(rbtnMale, gbc_rbtnMale);
		
		rbtnFemale = new JRadioButton("여");
		rbtnFemale.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_rbtnFemale = new GridBagConstraints();
		gbc_rbtnFemale.anchor = GridBagConstraints.WEST;
		gbc_rbtnFemale.insets = new Insets(0, 0, 5, 0);
		gbc_rbtnFemale.gridx = 2;
		gbc_rbtnFemale.gridy = 4;
		panel_employee.add(rbtnFemale, gbc_rbtnFemale);
		
		JLabel lblDepart = new JLabel("부서");
		GridBagConstraints gbc_lblDepart = new GridBagConstraints();
		gbc_lblDepart.anchor = GridBagConstraints.EAST;
		gbc_lblDepart.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepart.gridx = 0;
		gbc_lblDepart.gridy = 5;
		panel_employee.add(lblDepart, gbc_lblDepart);
		
		cmbDepart = new JComboBox();
		GridBagConstraints gbc_cmbDepart = new GridBagConstraints();
		gbc_cmbDepart.gridwidth = 2;
		gbc_cmbDepart.insets = new Insets(0, 0, 5, 0);
		gbc_cmbDepart.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDepart.gridx = 1;
		gbc_cmbDepart.gridy = 5;
		panel_employee.add(cmbDepart, gbc_cmbDepart);
		
		JLabel lblJoinDate = new JLabel("입사일");
		GridBagConstraints gbc_lblJoinDate = new GridBagConstraints();
		gbc_lblJoinDate.anchor = GridBagConstraints.EAST;
		gbc_lblJoinDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblJoinDate.gridx = 0;
		gbc_lblJoinDate.gridy = 6;
		panel_employee.add(lblJoinDate, gbc_lblJoinDate);
		
		tfJoinDate = new JTextField();
		tfJoinDate.setColumns(10);
		GridBagConstraints gbc_tfJoinDate = new GridBagConstraints();
		gbc_tfJoinDate.gridwidth = 2;
		gbc_tfJoinDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfJoinDate.gridx = 1;
		gbc_tfJoinDate.gridy = 6;
		panel_employee.add(tfJoinDate, gbc_tfJoinDate);
		
		JPanel panel_btn = new JPanel();
		contentPane.add(panel_btn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		panel_btn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		panel_btn.add(btnCancel);

	}

}
