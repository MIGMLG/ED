package Graph;

import Lists.ArrayList;
import Lists.ListADT;
import Lists.UnorderedArray;
import Lists.UnorderedListADT;

import java.util.Iterator;

public class GraphNode<T> {

    protected T element;
    protected UnorderedListADT<GraphNode<T>> edgeList;

    public GraphNode(T element) {
        this.element = element;
        edgeList = new UnorderedArray();
    }

    @Override
    public String toString() {
        String text = "Element: " + element + "";
        Iterator<GraphNode<T>> printItr = edgeList.iterator();
        while (printItr.hasNext()) {
            text += "\nEdge: " + element + "->" + printItr.next().element + "";
        }
        return text;
    }
}
