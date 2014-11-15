/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

import org.apache.commons.collections15.Factory;

/**
 *
 * @author Miklós
 */
public class LayEdge {

    private String id;
    private double weight;

    public LayEdge(String id, double weiht) {
        this.id = id;
        this.weight = weiht;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return id;
    }

    public static class LayEdgeFactory implements Factory<LayEdge> {

        private static int linkCount = 0;
        private static double defaultWeight = 0;
        private static double defaultCapacity;

        private static LayEdgeFactory instance = new LayEdgeFactory();

        private LayEdgeFactory() {
        }

        public static LayEdgeFactory getInstance() {
            return instance;
        }

        public LayEdge create() {
            String id = "Link" + linkCount++;
            double weight = 0.0;
            LayEdge edge = new LayEdge(id, weight);
            edge.setWeight(defaultWeight);
            return edge;
        }

        public static double getDefaultWeight() {
            return defaultWeight;
        }

        public static void setDefaultWeight(double aDefaultWeight) {
            defaultWeight = aDefaultWeight;
        }

        public static double getDefaultCapacity() {
            return defaultCapacity;
        }

        public static void setDefaultCapacity(double aDefaultCapacity) {
            defaultCapacity = aDefaultCapacity;
        }

    }

}
