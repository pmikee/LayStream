package laystream.interfaces;

import edu.uci.ics.jung.visualization.VisualizationViewer;

public interface NodeMenuListener<V> {

    void setNodeAndView(V v, VisualizationViewer visView);
}
