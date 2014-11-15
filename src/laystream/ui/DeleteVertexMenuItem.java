/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laystream.ui;

import edu.uci.ics.jung.visualization.VisualizationViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import laystream.interfaces.NodeMenuListener;

public class DeleteVertexMenuItem<V> extends JMenuItem implements NodeMenuListener<V> {

    private V vertex;
    private VisualizationViewer visComp;

    public DeleteVertexMenuItem() {
        super("Delete Vertex");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visComp.getPickedVertexState().pick(vertex, false);
                visComp.getGraphLayout().getGraph().removeVertex(vertex);
                visComp.repaint();
            }
        });
    }

    /**
     * Implements the VertexMenuListener interface.
     *
     * @param v
     * @param visComp
     */
    public void setNodeAndView(V v, VisualizationViewer visComp) {
        this.vertex = v;
        this.visComp = visComp;
        this.setText("Delete Vertex " + v.toString());
    }

}
