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
public class Util {

    public static final int C = 8;
    public static final int K = 4;
    public static final int NUMBE_OF_NODES = 15;
    public static final int NUMBE_OF_EDGES = 0;

    public double getDistanceFromOther(LayNode from, LayNode to) {
        double xDistance = Math.abs(from.getLocation().x - to.getLocation().x);
        double yDistance = Math.abs(from.getLocation().y - to.getLocation().y);
        double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));

        return distance;

    }
}
