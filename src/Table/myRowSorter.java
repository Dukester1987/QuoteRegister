/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ldulka
 */
public class myRowSorter extends TableRowSorter<TableModel> {    

    public myRowSorter(TreeTableModel tableModel) {
        super((TableModel) tableModel);
        //setComparator(0, numberAwareCompare);
        //setComparator(1,intCompare);
        //setComparator(2,intCompare);
    }
    
}
