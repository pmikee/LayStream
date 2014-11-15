/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author Dr. Greg M. Bernstein
 */
public class SimpleGraphView {

    Graph<LayNode, String> g;
    Factory<LayNode> vertexFactory;
    Factory<LayEdge> edgeFactory;
    Random rnd = new Random();

    /**
     * Creates a new instance of SimpleGraphView
     */
    public SimpleGraphView() {
        g = new SparseMultigraph<>();
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

    public static void main(String[] args) {
        SimpleGraphView sgv = new SimpleGraphView();
        Layout<LayNode, String> layout = new CircleLayout(sgv.g);
        layout.setSize(new Dimension(800, 600));

        VisualizationViewer<LayNode, String> vv
                = new VisualizationViewer<>(layout);
        vv.setPreferredSize(new Dimension(350, 350));
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

        EditingModalGraphMouse gm
                = new EditingModalGraphMouse(vv.getRenderContext(),
                        sgv.vertexFactory, sgv.edgeFactory);
        vv.setGraphMouse(gm);

        JFrame frame = new JFrame("layStream");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);

        JMenuBar menuBar = new JMenuBar();
        JMenu modeMenu = gm.getModeMenu(); // Obtain mode menu from the mouse
        modeMenu.setText("Mouse Mode");
        modeMenu.setPreferredSize(new Dimension(80, 20)); // Change the size  menuBar.add(modeMenu);
        frame.setJMenuBar(menuBar);
        gm.setMode(ModalGraphMouse.Mode.EDITING); // Start off in editing mode
        frame.pack();
        frame.setVisible(true);
    }

}
