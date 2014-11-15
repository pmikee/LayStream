/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

import java.awt.Point;
import java.util.Random;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author Miklós
 */
public class LayNodeFactory implements Factory<LayNode> {

    private int nodeCount = 0;
    private LayNodeFactory instance = new LayNodeFactory();
    private Random rnd;

    private LayNodeFactory() {
    }

    public LayNodeFactory getInstance() {
        return instance;
    }

    public LayNode create() {
        String id = "Node" + nodeCount++;
        Point position = new Point(rnd.nextInt(90), rnd.nextInt(90));
        LayNode v = new LayNode(id, position);
        return v;
    }

}
