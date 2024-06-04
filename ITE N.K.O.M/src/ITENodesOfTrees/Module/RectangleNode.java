package ITENodesOfTrees.Module;

import java.util.ArrayList;
import java.util.List;

public class RectangleNode {
    List<Integer> Rectangles;
    String value;
    int width, height;
    RectangleNode left, right;

    public RectangleNode(List<Integer> rectangles, String value, int width, int height, RectangleNode left,
            RectangleNode right) {
        Rectangles = rectangles;
        this.value = value;
        this.width = width;
        this.height = height;
        this.left = left;
        this.right = right;
    }

    List<RectangleNode> collecting(RectangleNode left, RectangleNode right) {

        for (Integer Index : left.Rectangles) {
            if (right.Rectangles.contains(Index))
                return null;
        }
        List<Integer> Index = new ArrayList<>();
        List<RectangleNode> Rec = new ArrayList<>();
        Index.addAll(left.Rectangles);
        Index.addAll(right.Rectangles);
        if (left.height == right.height) {
            int height, width;
            height = left.height;
            width = left.width + right.width;
            Rec.add(new RectangleNode(Index, "|", width, height, left, right));
            // System.out.println("left : " + left.name + " " + left.width + " " +
            // left.length);
            // System.out.println("right : " + right.name + " " + right.width + " " +
            // right.length);
        }
        if (left.width == right.width) {
            int height, width;
            width = left.width;
            height = left.height + right.height;
            Rec.add(new RectangleNode(Index, "-", width, height, left, right));
            // System.out.println("left : " + left.name + " " + left.width + " " +
            // left.length);
            // System.out.println("right : " + right.name + " " + right.width + " " +
            // right.length);
        }
        return Rec;
    }

    RectangleNode Rectangle(List<Node> Rec) {
        List<RectangleNode> Nodes = new ArrayList<>();
        for (int i = 0; i < Rec.size(); i++) {
            List<Integer> Index = new ArrayList<>();
            Index.add(i);
            Nodes.add(new RectangleNode(Index, Rec.get(i).value, Rec.get(i).width, Rec.get(i).height, null, null));
        }
        for (int i = 0; i < Nodes.size(); i++) {
            for (int j = 0; j < Nodes.size(); j++) {
                if (i == j)
                    continue;
                if (j < i && Nodes.get(i).Rectangles.size() == Nodes.get(j).Rectangles.size())
                    continue;
                List<RectangleNode> RecNodes = collecting(Nodes.get(i), Nodes.get(j));
                if (RecNodes == null || RecNodes.isEmpty())
                    continue;
                for (RectangleNode node : RecNodes) {
                    if (node.Rectangles.size() == Rec.size())
                        return node;
                    Nodes.add(node);
                }
            }
        }
        return null;
    }

    int NumberOfRectangles(List<Node> Nodes) {
        int counter = 0;
        for (int i = 0; i < (1 << Nodes.size()); i++) {
            List<Node> collection = new ArrayList<>();
            for (int j = 0; j < Nodes.size(); j++) {
                if (((1 << j) & i) > 0)
                    collection.add(Nodes.get(j));
            }
            counter += (Rectangle(collection) != null ? 1 : 0);
        }
        return counter;
    }
}
