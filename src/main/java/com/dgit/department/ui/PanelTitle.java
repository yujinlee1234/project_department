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

public class PanelTitle extends JPanel {
	private JTextField tftcode;
	private JTextField tftname;
	private JTextField tfFloor;
	private JPanel panel_title;
	private JButton btnAdd;
	private JButton btnCancel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelTitle() {
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
				{"T001", "사장"},
				{"T002", "부장"},
				{"T003", "과장"},
				{"T004", "대리"},
				{"T005", "사원"},				
			},
			new String[] {
				"번호", "직책"
			}
		));
		tableCellAlignment(SwingConstants.CENTER, 0,1);
		tableSetWidth(1,3);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_title = new JPanel();
		panel.add(panel_title, BorderLayout.CENTER);
		panel_title.setBorder(new EmptyBorder(10, 60, 0, 60));
		GridBagLayout gbl_panel_title = new GridBagLayout();
		gbl_panel_title.columnWidths = new int[] {0, 0, 0};
		gbl_panel_title.rowHeights = new int[] {0, 0};
		gbl_panel_title.columnWeights = new double[]{2.0, 1.0, 1.0};
		gbl_panel_title.rowWeights = new double[]{0.0, 0.0};
		panel_title.setLayout(gbl_panel_title);
		
		JLabel lbltcode = new JLabel("번호");
		lbltcode.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbltcode = new GridBagConstraints();
		gbc_lbltcode.anchor = GridBagConstraints.EAST;
		gbc_lbltcode.insets = new Insets(0, 0, 5, 5);
		gbc_lbltcode.gridx = 0;
		gbc_lbltcode.gridy = 0;
		panel_title.add(lbltcode, gbc_lbltcode);
		
		tftcode = new JTextField();
		tftcode.setEditable(false);
		tftcode.setText("T006");
		GridBagConstraints gbc_tftcode = new GridBagConstraints();
		gbc_tftcode.gridwidth = 2;
		gbc_tftcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftcode.insets = new Insets(0, 0, 5, 0);
		gbc_tftcode.anchor = GridBagConstraints.NORTH;
		gbc_tftcode.gridx = 1;
		gbc_tftcode.gridy = 0;
		panel_title.add(tftcode, gbc_tftcode);
		tftcode.setColumns(10);
		
		JLabel lbltname = new JLabel("직책명");
		GridBagConstraints gbc_lbltname = new GridBagConstraints();
		gbc_lbltname.anchor = GridBagConstraints.EAST;
		gbc_lbltname.insets = new Insets(0, 0, 5, 5);
		gbc_lbltname.gridx = 0;
		gbc_lbltname.gridy = 1;
		panel_title.add(lbltname, gbc_lbltname);
		
		tftname = new JTextField();
		tftname.setColumns(10);
		GridBagConstraints gbc_tftname = new GridBagConstraints();
		gbc_tftname.gridwidth = 2;
		gbc_tftname.insets = new Insets(0, 0, 5, 0);
		gbc_tftname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tftname.gridx = 1;
		gbc_tftname.gridy = 1;
		panel_title.add(tftname, gbc_tftname);
		
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
