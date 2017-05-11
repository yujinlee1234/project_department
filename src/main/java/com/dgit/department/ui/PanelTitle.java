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
import javax.swing.JPopupMenu;
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

import com.dgit.department.dto.Title;
import com.dgit.department.service.TitleService;
import com.dgit.department.ui.table.TableMenu;
import com.dgit.department.ui.table.TitleTable;
import com.dgit.department.util.UseJOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTitle extends JPanel implements ActionListener {
	private JTextField tftcode;
	private JTextField tftname;
	private JPanel panel_title;
	private JButton btnAdd;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private TitleTable table;
	private JPanel panel;
	private JMenuItem itemUpdate;
	private JMenuItem itemDelete;
	private int selectedIndex;

	/**
	 * Create the panel.
	 */
	public PanelTitle() {
		/* 화면 구성 */
		setLayout(new BorderLayout(0, 0));
		
		JPanel contentPane = new JPanel();
		add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 100));
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		
		table = new TitleTable();		
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
		btnAdd.addActionListener(this);
		panel_btn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_btn.add(btnCancel);
		// end of 화면구성
		TableMenu tMenu = new TableMenu();
		table.setComponentPopupMenu(tMenu);
		itemUpdate = tMenu.getItemUpdate();
		itemDelete = tMenu.getItemDelete();
		
		itemUpdate.addActionListener(this);
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
	protected void itemDeleteActionPerformed(ActionEvent e) {//삭제
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
		if(index<0){
			UseJOptionPane.showWarningMessage("삭제할 아이템이 선택되지 않았습니다.");
		}else{
			try{
				Title title = table.getSelectedItem(index);
				TitleService.getInstance().deleteTitle(title.getTcode());
				table.setTable();
				resetFields();
				btnAdd.setText("추가");
				UseJOptionPane.showMessage("성공적으로 삭제되었습니다.");				
			}catch(Exception ex){
				UseJOptionPane.showWarningMessage("오류가 발생하여 삭제되지 못했습니다.\n"+ex.getMessage());
			}
		}
	}

	protected void itemUpdateActionPerformed(ActionEvent e) {//수정
		// TODO Auto-generated method stub		
		selectedIndex = table.getSelectedRow();
		if(selectedIndex<0){
			UseJOptionPane.showWarningMessage("수정할 아이템이 선택되지 않았습니다.");
		}else{
			btnAdd.setText("수정");
			serFieldsWithTitle();
			
		}
	}

	protected void btnAddActionPerformed(ActionEvent e) {//추가
		
		if(tftname.getText().trim().length()==0){
			UseJOptionPane.showWarningMessage("직책명을 입력해 주세요.");
			tftname.requestFocus();
		}else{
			try{
				String tcode = tftcode.getText();
				String tname = tftname.getText().trim();
				
				Title title = new Title();
				title.setTcode(Integer.parseInt(tcode.substring(1)));
				title.setTname(tname);
				if(btnAdd.getText().equals("추가")){
					TitleService.getInstance().insertTitle(title);
					UseJOptionPane.showMessage("성공적으로 등록되었습니다.");
					
				}else if(btnAdd.getText().equals("수정")){
					TitleService.getInstance().updateTitle(title);
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
	protected void btnCancelActionPerformed(ActionEvent e) {//취소
		if(btnAdd.getText().equals("추가")){
			resetFields();
		}else if(btnAdd.getText().equals("수정")){
			serFieldsWithTitle();
		}
	}


	private void serFieldsWithTitle() {
		// TODO Auto-generated method stub
		Title title = table.getSelectedItem(selectedIndex);
		tftcode.setText(String.format("T%03d", title.getTcode()));
		tftname.setText(title.getTname());
	}

	private void resetFields() {
		// 필드 초기화
		int tcode = TitleService.getInstance().getMaxNo();
		tftcode.setText(String.format("T%03d", (tcode+1)));
		tftname.setText("");
	}
}
