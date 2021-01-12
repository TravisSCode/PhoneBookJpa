/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phone.model;

import com.phone.entity.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Root
 * модель таблицы пользователей
 */
public class UserTableModel extends AbstractTableModel {
    
    private String[] columnNames = {"No #", "Имя", "Фамилия"};
    private List<User> users;

    public UserTableModel(List<User> users) {
        this.users = users;
    }
    
    

    @Override
    public int getRowCount() {
        if (users==null) return 0;
        return users.size();
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
        if (users.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        Object returnValue = null;
         
        switch (columnIndex) {
        case 0:
            returnValue = user.getId();
            break;
        case 1:
            returnValue = user.getFirstName();
            break;
        case 2:
            returnValue = user.getLastName();
            break;
        default:
            throw new IllegalArgumentException("Invalid column index");
        }
         
        return returnValue;
    }
    
}
