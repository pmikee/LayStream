/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author Miklós
 */
public class Main {

    public static void main(String[] args) {
        SimpleGraphView sgv = new SimpleGraphView();
        Layout<LayNode, LayEdge> layout = new CircleLayout<>(sgv.g);
        layout.setSize(new Dimension(800, 600));

        VisualizationViewer<LayNode, LayEdge> vv
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
        JMenu modeMenu = gm.getModeMenu();
        modeMenu.setText("Mouse Mode");
        menuBar.add(modeMenu);
        frame.setJMenuBar(menuBar);
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING); // Start off in editing mode
        frame.pack();
        frame.setVisible(true);
    }

}
