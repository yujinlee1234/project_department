package com.dgit.department.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class PanelDepartment extends JPanel {
	private JTextField tfDcode;
	private JTextField tfDname;
	private JTextField tfFloor;
	private JPanel panel_department;
	private JButton btnAdd;
	private JButton btnCancel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelDepartment() {
		setLayout(new BorderLayout(0, 0));		
		JPanel contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 100));
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"D001", "마케팅", "10"},
				{"D002", "개발", "9"},
				{"D003", "인사", "6"},
				{"D004", "총무", "7"},
				{"D005", "경영", "4"},				
			},
			new String[] {
				"번호", "부서명", "위치"
			}
		));
		tableCellAlignment(SwingConstants.CENTER, 0,1,2);
		tableSetWidth(1,2,1);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_department = new JPanel();
		panel.add(panel_department, BorderLayout.CENTER);
		panel_department.setBorder(new EmptyBorder(10, 60, 0, 60));
		GridBagLayout gbl_panel_department = new GridBagLayout();
		gbl_panel_department.columnWidths = new int[] {0, 0, 0};
		gbl_panel_department.rowHeights = new int[] {0, 0, 0};
		gbl_panel_department.columnWeights = new double[]{2.0, 1.0, 1.0};
		gbl_panel_department.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_department.setLayout(gbl_panel_department);
		
		JLabel lblDcode = new JLabel("번호");
		lblDcode.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDcode = new GridBagConstraints();
		gbc_lblDcode.anchor = GridBagConstraints.EAST;
		gbc_lblDcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcode.gridx = 0;
		gbc_lblDcode.gridy = 0;
		panel_department.add(lblDcode, gbc_lblDcode);
		
		tfDcode = new JTextField();
		tfDcode.setEditable(false);
		tfDcode.setText("D006");
		GridBagConstraints gbc_tfDcode = new GridBagConstraints();
		gbc_tfDcode.gridwidth = 2;
		gbc_tfDcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDcode.insets = new Insets(0, 0, 5, 0);
		gbc_tfDcode.anchor = GridBagConstraints.NORTH;
		gbc_tfDcode.gridx = 1;
		gbc_tfDcode.gridy = 0;
		panel_department.add(tfDcode, gbc_tfDcode);
		tfDcode.setColumns(10);
		
		JLabel lblDname = new JLabel("부서명");
		GridBagConstraints gbc_lblDname = new GridBagConstraints();
		gbc_lblDname.anchor = GridBagConstraints.EAST;
		gbc_lblDname.insets = new Insets(0, 0, 5, 5);
		gbc_lblDname.gridx = 0;
		gbc_lblDname.gridy = 1;
		panel_department.add(lblDname, gbc_lblDname);
		
		tfDname = new JTextField();
		tfDname.setColumns(10);
		GridBagConstraints gbc_tfDname = new GridBagConstraints();
		gbc_tfDname.gridwidth = 2;
		gbc_tfDname.insets = new Insets(0, 0, 5, 0);
		gbc_tfDname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDname.gridx = 1;
		gbc_tfDname.gridy = 1;
		panel_department.add(tfDname, gbc_tfDname);
		
		JLabel lblFloor = new JLabel("위치");
		GridBagConstraints gbc_lblFloor = new GridBagConstraints();
		gbc_lblFloor.anchor = GridBagConstraints.EAST;
		gbc_lblFloor.insets = new Insets(0, 0, 0, 5);
		gbc_lblFloor.gridx = 0;
		gbc_lblFloor.gridy = 2;
		panel_department.add(lblFloor, gbc_lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		GridBagConstraints gbc_tfFloor = new GridBagConstraints();
		gbc_tfFloor.gridwidth = 2;
		gbc_tfFloor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFloor.gridx = 1;
		gbc_tfFloor.gridy = 2;
		panel_department.add(tfFloor, gbc_tfFloor);		
		
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
