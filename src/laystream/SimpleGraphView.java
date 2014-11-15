/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Pair;
import java.awt.Point;
import java.util.Collection;
import java.util.Random;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author Dr. Greg M. Bernstein
 */
public class SimpleGraphView {

    Graph<LayNode, LayEdge> g;
    Factory<LayNode> vertexFactory;
    Factory<LayEdge> edgeFactory;
    Random rnd = new Random();

    /**
     * Creates a new instance of SimpleGraphView
     */
    public SimpleGraphView() {
        g = new DirectedSparseMultigraph<>();
        vertexFactory = new Factory<LayNode>() {

            @Override
            public LayNode create() {
                return new LayNode("asd", new Point(rnd.nextInt(90), rnd.nextInt(90)));
            }
        };
        edgeFactory = new Factory<LayEdge>() {
            @Override
            public LayEdge create() {
                return new LayEdge("asd", 10);
            }
        };
        for (int i = 0; i < Util.NUMBE_OF_NODES; i++) {
            g.addVertex(new LayNode("" + i, new Point(rnd.nextInt(90), rnd.nextInt(90))));
        }
    }

    public Collection<LayNode> getNodes() {
        return g.getVertices();
    }

    public int getNodeCount() {
        return g.getVertexCount();
    }

    public Collection<LayEdge> getEdges() {
        return g.getEdges();
    }

    public int getEdgeCount() {
        return g.getEdgeCount();
    }

    /**
     * él hozzáadása a gráfhoz
     *
     * @param e él
     * @param nodes Pair<LayNode>, forrás: első tag, cél: 2. tag
     */
    public void addEdge(LayEdge e, Pair<LayNode> nodes) {
        g.addEdge(e, nodes.getFirst(), nodes.getSecond());
    }

    public void removeEdge(LayEdge e) {
        g.removeEdge(e);
    }

}
