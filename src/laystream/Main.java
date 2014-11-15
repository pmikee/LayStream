/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import laystream.ui.LayMouseMenu;
import laystream.ui.PopupVertexEdgeMenuMousePlugin;

/**
 *
 * @author Miklós
 */
public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Editing and Mouse Menu Demo");
        SparseMultigraph<LayNode, LayEdge> g
                = new SparseMultigraph<>();
        // Layout<V, E>, VisualizationViewer<V,E>
//        Map<LayNode,Point2D> vertexLocations = new HashMap<LayNode, Point2D>();
        Layout<LayNode, LayEdge> layout = new StaticLayout(g);
        layout.setSize(new Dimension(300, 300));
        VisualizationViewer<LayNode, LayEdge> vv
                = new VisualizationViewer<LayNode, LayEdge>(layout);
        vv.setPreferredSize(new Dimension(350, 350));
        // Show vertex and edge labels
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        // Create a graph mouse and add it to the visualization viewer
        EditingModalGraphMouse gm = new EditingModalGraphMouse(vv.getRenderContext(),
                LayNode.LayNodeFactory.getInstance(),
                LayEdge.LayEdgeFactory.getInstance());
        // Set some defaults for the Edges...
        // Trying out our new popup menu mouse plugin...
        PopupVertexEdgeMenuMousePlugin myPlugin = new PopupVertexEdgeMenuMousePlugin();
        // Add some popup menus for the edges and vertices to our mouse plugin.
        JPopupMenu edgeMenu = new LayMouseMenu.EdgeMenu(frame);
        JPopupMenu vertexMenu = new LayMouseMenu.VertexMenu();
        myPlugin.setEdgePopup(edgeMenu);
        myPlugin.setVertexPopup(vertexMenu);
        gm.remove(gm.getPopupEditingPlugin());  // Removes the existing popup editing plugin

        gm.add(myPlugin);   // Add our new plugin to the mouse

        vv.setGraphMouse(gm);

        //JFrame frame = new JFrame("Editing and Mouse Menu Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);

        // Let's add a menu for changing mouse modes
        JMenuBar menuBar = new JMenuBar();
        JMenu modeMenu = gm.getModeMenu();
        modeMenu.setText("Mouse Mode");
        modeMenu.setIcon(null); // I'm using this in a main menu
        modeMenu.setPreferredSize(new Dimension(80, 20)); // Change the size so I can see the text

        menuBar.add(modeMenu);
        frame.setJMenuBar(menuBar);
        gm.setMode(ModalGraphMouse.Mode.EDITING); // Start off in editing mode
        frame.pack();
        frame.setVisible(true);
    }
//    public static void main(String[] args) {
//        SimpleGraphView sgv = new SimpleGraphView();
//        Layout<LayNode, LayEdge> layout = new CircleLayout<>(sgv.g);
//        layout.setSize(new Dimension(800, 600));
//
//        VisualizationViewer<LayNode, LayEdge> vv
//                = new VisualizationViewer<>(layout);
//        vv.setPreferredSize(new Dimension(350, 350));
//        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
//        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
//
//        EditingModalGraphMouse gm
//                = new EditingModalGraphMouse(vv.getRenderContext(),
//                        sgv.vertexFactory, sgv.edgeFactory);
//        vv.setGraphMouse(gm);
//
//        JFrame frame = new JFrame("layStream");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(vv);
//
//        JMenuBar menuBar = new JMenuBar();
//        JMenu modeMenu = gm.getModeMenu();
//        modeMenu.setText("Mouse Mode");
//        menuBar.add(modeMenu);
//        frame.setJMenuBar(menuBar);
//        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING); // Start off in editing mode
//        frame.pack();
//        frame.setVisible(true);
//    }

}
