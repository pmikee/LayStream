/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author Miklós
 */
public class LayNode {

    private String id;
    private Point location;
    private ArrayList<String> pss;
    private ArrayList<String> tc;
    private ArrayList<String> sentPackets;
    private ArrayList<String> receivedPackets;

    public LayNode(String id, Point location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public ArrayList<String> getPss() {
        return pss;
    }

    public void setPss(ArrayList<String> pss) {
        this.pss = pss;
    }

    public ArrayList<String> getTc() {
        return tc;
    }

    public void setTc(ArrayList<String> tc) {
        this.tc = tc;
    }

    public String toString() {
        return "V" + id;
    }

    public ArrayList<String> getSentPackets() {
        return sentPackets;
    }

    public void setSentPackets(ArrayList<String> sentPackets) {
        this.sentPackets = sentPackets;
    }

    public ArrayList<String> getReceivedPackets() {
        return receivedPackets;
    }

    public void setReceivedPackets(ArrayList<String> receivedPackets) {
        this.receivedPackets = receivedPackets;
    }

    public static class LayNodeFactory implements Factory<LayNode> {

        private static int nodeCount = 0;
        private static LayNodeFactory instance = new LayNodeFactory();
        private static Random rnd = new Random();

        private LayNodeFactory() {
        }

        public static LayNodeFactory getInstance() {
            return instance;
        }

        public LayNode create() {
            String id = "Node" + nodeCount++;
            Point position = new Point(rnd.nextInt(90), rnd.nextInt(90));
            LayNode v = new LayNode(id, position);
            return v;
        }

    }
}
