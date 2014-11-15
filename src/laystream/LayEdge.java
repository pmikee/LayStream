/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

/**
 *
 * @author Miklós
 */
public class LayEdge {

    private String id;
    private double weiht;

    public LayEdge(String id, double weiht) {
        this.id = id;
        this.weiht = weiht;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeiht() {
        return weiht;
    }

    public void setWeiht(double weiht) {
        this.weiht = weiht;
    }

    @Override
    public String toString() {
        return id;
    }

}
