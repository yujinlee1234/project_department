package com.dgit.department.ui.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Employee;
import com.dgit.department.service.DepartmentService;
import com.dgit.department.service.EmployeeService;

public class EmployeeTable extends JTable {
	private List<Employee> eList;
	public EmployeeTable() {	
		setTable();		
	}
	
	public void setTable() {
		// TODO Auto-generated method stub
		eList = EmployeeService.getInstance().getAllEmployees();
		String[][] rowDatas = new String[eList.size()][];
		for(int i=0;i<rowDatas.length;i++){
			rowDatas[i] = eList.get(i).toArray();
		}
		setModel(new DefaultTableModel(rowDatas, new String[]{"번호", "사원명","직책","급여","성별","부서","입사일"}));
		tableCellAlignment(SwingConstants.CENTER, 0,1,2,4,5,6);
		tableCellAlignment(SwingConstants.RIGHT, 3);
		tableSetWidth(3,4,2,5,2,4,4);
		
		invalidate();
	}

	protected void tableCellAlignment(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	protected void tableSetWidth(int... width) {//
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}		
	}
	
	/* 테이블에서 수정 못하도록 하는 메소드. 유진 사용 테이블에서 적용 */
	@Override
	public boolean isCellEditable(int row, int column) {
		if(column >= 0){
			return false;
		}else{
			return true;
		}
	}
	
	public Employee getSelectedItem(int index){
		return eList.get(index);		
	}
}
