/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream.ui;

import edu.uci.ics.jung.visualization.VisualizationViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import laystream.LayEdge;
import laystream.LayNode;
import laystream.interfaces.EdgeMenuListener;
import laystream.interfaces.MenuPointListener;
import laystream.interfaces.NodeMenuListener;

/**
 * A collection of classes used to assemble popup mouse menus for the custom
 * edges and vertices developed in this example.
 *
 * @author Dr. Greg M. Bernstein
 */
public class LayMouseMenu {

    public static class EdgeMenu extends JPopupMenu {

        // private JFrame frame;
        public EdgeMenu(final JFrame frame) {
            super("Edge Menu");
            // this.frame = frame;
            this.add(new WeightDisplay());
            this.addSeparator();
            this.add(new EdgePropItem(frame));
        }

    }

    public static class EdgePropItem extends JMenuItem implements EdgeMenuListener<LayEdge>,
            MenuPointListener {

        LayEdge edge;
        VisualizationViewer visComp;
        Point2D point;

        public void setEdgeAndView(LayEdge edge, VisualizationViewer visComp) {
            this.edge = edge;
            this.visComp = visComp;
        }

        public void setPoint(Point2D point) {
            this.point = point;
        }

        public EdgePropItem(final JFrame frame) {
            super("Edit Edge Properties...");
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    EdgePropertyDialog dialog = new EdgePropertyDialog(frame, edge);
                    dialog.setLocation((int) point.getX() + frame.getX(), (int) point.getY() + frame.getY());
                    dialog.setVisible(true);
                }

            });
        }

    }

    public static class WeightDisplay extends JMenuItem implements EdgeMenuListener<LayEdge> {

        @Override
        public void setEdgeAndView(LayEdge e, VisualizationViewer visComp) {
            this.setText("Weight " + e + " = " + e.getWeight());
        }
    }

    public static class VertexMenu extends JPopupMenu {

        public VertexMenu() {
            super("Vertex Menu");
            this.add(new DeleteVertexMenuItem());
            this.add(new NodeView());
            this.add(new PSSView());
        }
    }

    public static class NodeView extends JMenuItem implements NodeMenuListener<LayNode> {

        @Override
        public void setNodeAndView(LayNode n, VisualizationViewer visComp) {
            this.setText("Position: " + n + " = " + n.getLocation().toString());
        }

    }

    public static class PSSView extends JMenuItem implements NodeMenuListener<LayNode> {

        @Override
        public void setNodeAndView(LayNode n, VisualizationViewer visComp) {
            this.setText("PSS: " + n + " = " + n.getPss().toString());
        }

    }

}
