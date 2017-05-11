package com.dgit.department.ui.table;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class TableMenu extends JPopupMenu {
	private JMenuItem itemUpdate;
	private JMenuItem itemDelete;
	
	public JMenuItem getItemUpdate() {
		return itemUpdate;
	}


	public JMenuItem getItemDelete() {
		return itemDelete;
	}

	public TableMenu() {
		// TODO Auto-generated constructor stub
		itemUpdate = new JMenuItem("수정");
		itemDelete = new JMenuItem("삭제");
		
		add(itemUpdate);
		add(itemDelete);
	}
	
	
	
}
