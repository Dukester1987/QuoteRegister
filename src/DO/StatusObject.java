/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DO;

/**
 *
 * @author ldulka
 */
public class StatusObject {
    private String status;
    private boolean actionNeeded;

    public StatusObject(String status, boolean actionNeeded) {
        this.status = status;
        this.actionNeeded = actionNeeded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActionNeeded() {
        return actionNeeded;
    }

    public void setActionNeeded(boolean actionNeeded) {
        this.actionNeeded = actionNeeded;
    }


    
}
