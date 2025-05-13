/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Response;

import Model.Medecin;
import java.util.List;

/**
 *
 * @author pc
 */
public class ListMedocResponse {
    private List<Medecin> data;
    private String message;
    private int status;

    public List<Medecin> getData() {
        return data;
    }

    public void setData(List<Medecin> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
