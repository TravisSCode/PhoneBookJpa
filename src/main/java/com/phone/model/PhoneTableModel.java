/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phone.model;

import com.phone.entity.Phone;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Root
 * модель таблицы телефонов
 */
public class PhoneTableModel extends  AbstractTableModel{
   private String[] columnNames = {"Номер", "Заметка"};
    private List<Phone> phones;

    public PhoneTableModel(List<Phone> phones) {
        this.phones = phones;
    }
    
    

    @Override
    public int getRowCount() {
        if (phones==null) return 0;
        return phones.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (phones.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phone phone = phones.get(rowIndex);
        Object returnValue = null;
         
        switch (columnIndex) {
        case 0:
            returnValue = phone.getPhone();
            break;
        case 1:
            returnValue = phone.getNote();
            break;
        default:
            throw new IllegalArgumentException("Invalid column index");
        }
         
        return returnValue;
    }  
}
