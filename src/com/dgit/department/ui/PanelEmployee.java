package com.dgit.department.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelEmployee() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"E17001", "나사장", "사장", "5,000,000", "남자", "경영(4층)", "2017-03-01"},
				{"E17002", "나부장", "부장", "4,000,000", "남자", "마케팅(10층)", "2017-03-01"},
				{"E17003", "너부장", "부장", "4,000,000", "여자", "개발(9층)", "2017-03-01"},
				{"E17004", "나과장", "과장", "3,500,000", "남자", "마케팅(10층)", "2017-03-01"},
				{"E17005", "너과장", "과장", "3,500,000", "여자", "개발(9층)", "2017-03-01"},
				{"E17006", "나대리", "대리", "3,000,000", "남자", "마케팅(10층)", "2017-03-01"},
				{"E17007", "너대리", "대리", "3,000,000", "여자", "개발(9층)", "2017-03-01"}
			},
			new String[] {
				"번호", "사원명", "직책", "급여", "성별", "부서", "입사일"
			}
		));
		tableCellAlignment(SwingConstants.CENTER, 0,1,2,4,5,6);
		tableCellAlignment(SwingConstants.RIGHT, 3);
		tableSetWidth(3,4,2,5,2,4,4);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_employee = new JPanel();
		panel.add(panel_employee, BorderLayout.CENTER);
		panel_employee.setBorder(new EmptyBorder(10, 60, 0, 60));
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
		tfEno.setText("E017014");
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
		cmbTitle.setModel(new DefaultComboBoxModel(new String[] {"사장", "부장", "과장", "대리", "사원"}));
		
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
		spnSalary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		
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
		rbtnMale.setSelected(true);
		buttonGroup.add(rbtnMale);
		
		rbtnMale.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_rbtnMale = new GridBagConstraints();
		gbc_rbtnMale.anchor = GridBagConstraints.EAST;
		gbc_rbtnMale.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnMale.gridx = 1;
		gbc_rbtnMale.gridy = 4;
		panel_employee.add(rbtnMale, gbc_rbtnMale);
		
		rbtnFemale = new JRadioButton("여");
		buttonGroup.add(rbtnFemale);
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
		cmbDepart.setModel(new DefaultComboBoxModel(new String[] {"마케팅(10층)", "개발(9층)", "인사(6층)", "총무(7층)", "경영(4층)"}));
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
		tfJoinDate.setText(sdf.format(today));
		
		
		JPanel panel_btn = new JPanel();
		panel.add(panel_btn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		panel_btn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		panel_btn.add(btnCancel);

	}

	
	protected void tableCellAlignment(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	protected void tableSetWidth(int... width) {//
		TableColumnModel model = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}		
	}
}
