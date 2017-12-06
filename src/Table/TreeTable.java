/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import java.util.Arrays;
import java.util.List;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;

/**
 *
 * @author ldulka
 */
public class TreeTable {
    
    private String[] headings = {"ID", "Approved", "Column 3"};
    private Node root;
    private DefaultTreeTableModel model;
    private JXTreeTable table;
    private List<String[]> content;
    
    public TreeTable(List<String[]> content){
        this.content = content;
    }
    
    public JXTreeTable getTreeTable() {
        root = new RootNode("Root");
        ChildNode myChild = null;
        for (String[] data : this.content){
            ChildNode child = new ChildNode(data);
            if(data.length <= 1){
                root.add(child);
                myChild = child;
            } else {
                myChild.add(child);
            }
        }
        
        model = new DefaultTreeTableModel(root, Arrays.asList(headings));
        table = new JXTreeTable(model);
        table.setShowGrid(true,true);
        table.setColumnControlVisible(true);
        table.packAll();
        
        return table;
    }
            
    
}
