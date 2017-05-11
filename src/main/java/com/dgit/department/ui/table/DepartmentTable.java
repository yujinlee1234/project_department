package com.dgit.department.ui.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.dgit.department.dto.Department;
import com.dgit.department.dto.Title;
import com.dgit.department.service.DepartmentService;
import com.dgit.department.service.TitleService;

public class DepartmentTable extends JTable {
	private List<Department> dList;
	public DepartmentTable() {	
		setTable();		
	}
	
	public void setTable() {
		// TODO Auto-generated method stub
		dList = DepartmentService.getInstance().getAllDepartments();
		String[][] rowDatas = new String[dList.size()][];
		for(int i=0;i<rowDatas.length;i++){
			rowDatas[i] = dList.get(i).toArray();
		}
		setModel(new DefaultTableModel(rowDatas, new String[]{"번호", "부서명", "위치"}));
		tableCellAlignment(SwingConstants.CENTER, 0,1,2);
		tableSetWidth(1,2,1);
		
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
	
	public Department getSelectedItem(int index){
		return dList.get(index);		
	}
}
