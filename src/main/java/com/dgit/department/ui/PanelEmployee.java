package com.dgit.department.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Employee;
import com.dgit.department.dto.Title;
import com.dgit.department.service.DepartmentService;
import com.dgit.department.service.EmployeeService;
import com.dgit.department.service.TitleService;
import com.dgit.department.ui.table.EmployeeTable;
import com.dgit.department.ui.table.TableMenu;
import com.dgit.department.util.UseJOptionPane;

public class PanelEmployee extends JPanel implements ActionListener {
	private JTextField tfEno;
	private JTextField tfEname;
	private JFormattedTextField tfJoinDate;
	private JComboBox<Title> cmbTitle;
	private JSpinner spnSalary;
	private JPanel panel_employee;
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	private JComboBox<Department> cmbDepart;
	private JButton btnAdd;
	private JButton btnCancel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private EmployeeTable table;
	private JPanel panel;
	private int defaultSalary = 1500000;
	private JMenuItem itemUpdate;
	private JMenuItem itemDelete;
	private int selectedIndex;

	/**
	 * Create the panel.
	 */
	public PanelEmployee() {
		/* 화면 구성 */
		setLayout(new BorderLayout(0, 0));
		
		JPanel contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(700, 120));
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		table = new EmployeeTable();
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
		
		cmbTitle = new JComboBox<>(); 
		//cmbTitle.setModel(new DefaultComboBoxModel(new String[] {"사장", "부장", "과장", "대리", "사원"}));
		
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
		spnSalary.setModel(new SpinnerNumberModel(defaultSalary, 1000000, 5000000, 100000));
		
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
		
		cmbDepart = new JComboBox<>();
		//cmbDepart.setModel(new DefaultComboBoxModel(new String[] {"마케팅(10층)", "개발(9층)", "인사(6층)", "총무(7층)", "경영(4층)"}));
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
		
		try{
			MaskFormatter mf = new MaskFormatter("####-##-##");
			mf.setPlaceholder("_");
			tfJoinDate = new JFormattedTextField(mf);			
		}catch(java.text.ParseException e){
			e.printStackTrace();
		}
		
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
		btnAdd.addActionListener(this);
		panel_btn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_btn.add(btnCancel);
		//화면 구성 끝
		
		setTitleCmb();
		setDepartmentCmb();
		
		TableMenu tMenu = new TableMenu();
		table.setComponentPopupMenu(tMenu);
		
		itemUpdate = tMenu.getItemUpdate();
		itemDelete = tMenu.getItemDelete();
		
		itemUpdate.addActionListener(this);
		itemDelete.addActionListener(this);
		
		resetFields();
	}
	private void setDepartmentCmb() {
		// TODO Auto-generated method stub
		List<Department> dList = DepartmentService.getInstance().getAllDepartments();
		for(Department d:dList){
			cmbDepart.addItem(d);
		}
	}


	private void setTitleCmb() {
		List<Title> tList = TitleService.getInstance().getAllTitles();
		for(Title t:tList){
			cmbTitle.addItem(t);
		}
		
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
			UseJOptionPane.showWarningMessage("삭제할 사원이 선택되지 않았습니다.");
		}else{
			try{
				Employee employee = table.getSelectedItem(index);
				EmployeeService.getInstance().deleteEmployee(employee.getEno());
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
			UseJOptionPane.showWarningMessage("수정할 사원이 선택되지 않았습니다.");
		}else{
			btnAdd.setText("수정");
			setFieldsWithEmp();
		}
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		if(tfEname.getText().trim().length()==0){
			UseJOptionPane.showWarningMessage("사원명을 입력해 주세요.");
			tfEname.requestFocus();
		}else {
			String eno = tfEno.getText().trim();
			String ename = tfEname.getText().trim();
			Title title = (Title) cmbTitle.getSelectedItem();
			Department department = (Department) cmbDepart.getSelectedItem();
			String joinDate = tfJoinDate.getText().trim();
			boolean gender = rbtnMale.isSelected()?true:false;
			int salary = (int) spnSalary.getValue();
			
			try{
				Employee employee = new Employee();
				employee.setEno(Integer.parseInt(eno.substring(1)));
				employee.setEname(ename);
				employee.setTitle(title);
				employee.setDno(department);
				employee.setJoindate(Employee.joinDateFormat.parse(joinDate));
				employee.setGender(gender);
				employee.setSalary(salary);
				if(btnAdd.getText().equals("추가")){
					EmployeeService.getInstance().insertEmployee(employee);
					UseJOptionPane.showMessage("성공적으로 추가하였습니다.");
				}else if(btnAdd.getText().equals("수정")){
					EmployeeService.getInstance().updateEmployee(employee);
					UseJOptionPane.showMessage("성공적으로 수정하였습니다.");
					btnAdd.setText("추가");
				}
				table.setTable();
				resetFields();
			}catch(Exception ex){
				UseJOptionPane.showWarningMessage("오류가 발생하여 추가하지 못했습니다.\n"+ex.getMessage());
			}
		}
		
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		if(btnAdd.getText().equals("추가")){
			resetFields();
		}else if(btnAdd.getText().equals("수정")){
			setFieldsWithEmp();
		}
	}

	private void setFieldsWithEmp() {
		// TODO Auto-generated method stub
		Employee employee = table.getSelectedItem(selectedIndex);
		tfEno.setText("E"+employee.getEno());
		tfEname.setText(employee.getEname());
		tfJoinDate.setText(employee.joinDateFormat.format(employee.getJoindate()));
		cmbDepart.setSelectedItem(employee.getDno());
		cmbTitle.setSelectedItem(employee.getTitle());
		spnSalary.setValue(employee.getSalary());
		if(employee.isGender()){
			//남자
			rbtnMale.setSelected(true);
		}else{
			rbtnFemale.setSelected(true);
		}
	}

	private void resetFields() {
		// TODO Auto-generated method stub
		int eno = EmployeeService.getInstance().getMaxNo();
		if(eno == 0){
			tfEno.setText("E17001");
		}else{
			tfEno.setText("E"+(EmployeeService.getInstance().getMaxNo()+1));
		}
		tfEname.setText("");
		tfJoinDate.setText(Employee.joinDateFormat.format(new Date()));
		if(cmbDepart.getItemCount()>0){
			cmbDepart.setSelectedIndex(0);
		}
		if(cmbTitle.getItemCount()>0){
			cmbTitle.setSelectedIndex(0);
		}
		rbtnMale.setSelected(true);
		spnSalary.setValue(defaultSalary);
	}
}
