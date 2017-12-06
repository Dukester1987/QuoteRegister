/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import java.util.List;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import org.jdesktop.swingx.treetable.TreeTableNode;

/**
 *
 * @author ldulka
 */
public class TreeTableModel extends DefaultTreeTableModel {
    
    static protected Class<?>[] columnTypes = null;

    public TreeTableModel() {
    }

    public TreeTableModel(TreeTableNode root) {
        super(root);
    }

    public TreeTableModel(TreeTableNode root, List<?> columnNames, Class<?>[] columnTypes) {        
        super(root, columnNames);
        setColumnClass(columnTypes);        
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if(columnTypes==null){
            return super.getColumnClass(column); //To change body of generated methods, choose Tools | Templates.
        } else {
            return columnTypes[column];
        }
    }
    
    
   
    public static void setColumnClass(Class<?>[] columnTypes) {
        TreeTableModel.columnTypes = columnTypes;
    }
    
    
    
      
    
}
