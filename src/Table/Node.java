/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode;

/**
 *
 * @author ldulka
 */
public class Node extends AbstractMutableTreeTableNode {
    
    public Node(Object[] data) {
        super(data);
    }

    @Override
    public Object getValueAt(int column) {
        return getData()[column];
    }

    @Override
    public int getColumnCount() {
        return getData().length;
    }
    
    public Object[] getData() {
        return (Object[]) getUserObject();
    }
    
}
