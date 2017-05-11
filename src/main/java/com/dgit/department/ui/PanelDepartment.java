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
import javax.swing.JMenuItem;
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

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Title;
import com.dgit.department.service.DepartmentService;
import com.dgit.department.service.TitleService;
import com.dgit.department.ui.table.DepartmentTable;
import com.dgit.department.ui.table.TableMenu;
import com.dgit.department.util.UseJOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelDepartment extends JPanel implements ActionListener, KeyListener {
	private JTextField tfDcode;
	private JTextField tfDname;
	private JTextField tfFloor;
	private JPanel panel_department;
	private JButton btnAdd;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private DepartmentTable table;
	private JPanel panel;
	private JMenuItem itemUpdate;
	private JMenuItem itemDelete;
	private int selectedIndex;

	/**
	 * Create the panel.
	 */
	public PanelDepartment() {
		/* 화면구성 */
		setLayout(new BorderLayout(0, 0));		
		JPanel contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 100));
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		table = new DepartmentTable();
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
		tfFloor.addKeyListener(this);
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
		btnAdd.addActionListener(this);
		panel_btn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_btn.add(btnCancel);
		//화면 구성 끝
		TableMenu tMenu = new TableMenu();
		table.setComponentPopupMenu(tMenu);
		itemUpdate  = tMenu.getItemUpdate();
		itemUpdate.addActionListener(this);
		itemDelete = tMenu.getItemDelete();
		itemDelete.addActionListener(this);
		
		resetFields();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
		
		if (e.getSource() == itemUpdate) {
			itemUpdateActionPerformed(e);
		}
		
		if (e.getSource() == itemDelete) {
			itemDeleteActionPerformed(e);
		}
	}
	private void itemDeleteActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
		if(index<0){
			UseJOptionPane.showWarningMessage("삭제할 아이템이 선택되지 않았습니다.");
		}else{
			try{
				Department department = table.getSelectedItem(index);
				DepartmentService.getInstance().deleteDepartment(department.getDcode());
				table.setTable();
				resetFields();
				btnAdd.setText("추가");
				UseJOptionPane.showMessage("성공적으로 삭제되었습니다.");
			}catch(Exception ex){
				UseJOptionPane.showWarningMessage("오류가 발생하여 삭제되지 못했습니다.\n"+ex.getMessage());
			}
		}
	}

	private void itemUpdateActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		selectedIndex = table.getSelectedRow();
		if(selectedIndex<0){
			UseJOptionPane.showWarningMessage("수정할 아이템이 선택되지 않았습니다.");
		}else{
			btnAdd.setText("수정");
			setFiledsWithDepartment();
			
		}
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		if(tfDname.getText().trim().length()==0){
			UseJOptionPane.showWarningMessage("부서명을 입력해 주세요.");
			tfDname.requestFocus();
		}else if(tfFloor.getText().trim().length()==0){
			UseJOptionPane.showWarningMessage("위치를 입력해 주세요.");
			tfFloor.requestFocus();
		}else{
			try{
				String dcode = tfDcode.getText();
				String dname = tfDname.getText().trim();
				String floor = tfFloor.getText();
				
				Department department = new Department();
				department.setDcode(Integer.parseInt(dcode.substring(1)));
				department.setDname(dname);
				department.setFloor(Integer.parseInt(floor.trim()));
				if(btnAdd.getText().equals("추가")){
					DepartmentService.getInstance().insertDepartment(department);
					UseJOptionPane.showMessage("성공적으로 등록되었습니다.");
				}else if(btnAdd.getText().equals("수정")){
					DepartmentService.getInstance().updateDepartment(department);
					UseJOptionPane.showMessage("성공적으로 수정되었습니다.");
					btnAdd.setText("추가");
				}
				table.setTable();
				resetFields();
				
			}catch(Exception ex){
				String result = "";
				if(btnAdd.getText().equals("추가")){
					result = "등록";
				}else if(btnAdd.getText().equals("수정")){
					result = "수정";
				}
				UseJOptionPane.showWarningMessage("오류가 발생하여 "+result+"하지 못했습니다.\n"+ex.getMessage());
			}
		}
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		if(btnAdd.getText().equals("추가")){
			resetFields();
		}else if(btnAdd.getText().equals("수정")){
			setFiledsWithDepartment();
		}
	}


	private void setFiledsWithDepartment() {
		// TODO Auto-generated method stub
		Department department = table.getSelectedItem(selectedIndex);
		tfDcode.setText(String.format("D%03d", department.getDcode()));
		tfDname.setText(department.getDname());
		tfFloor.setText(department.getFloor()+"");
	}

	private void resetFields() {
		// TODO Auto-generated method stub
		int dcode = DepartmentService.getInstance().getMaxNo();
		tfDcode.setText(String.format("D%03d", (dcode+1)));
		tfDname.setText("");
		tfFloor.setText("");
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == tfFloor) {
			tfFloorKeyTyped(e);
		}
	}
	protected void tfFloorKeyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(tfFloor.getText().trim().length()>=2){//층 수가 99를 넘기면 더이상 입력 안되도록
			e.consume();
			return;
		}
		if(!Character.isDigit(c)){
			e.consume();
			return;
		}		
	}
}
