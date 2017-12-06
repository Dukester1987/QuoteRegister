package DO;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldulka
 */
public class GuiCollector {
    private List<JFrame> guis;
    
    public GuiCollector(){
        guis = new ArrayList<JFrame>();
    }
    
    public void addGui(JFrame gui){
        guis.add(gui);
    }
    
    public void removeGui(JFrame gui){
        guis.remove(gui);
    }
        
    public static boolean isGuiOpened(JFrame gui){
        return true;
    }        
    
}
