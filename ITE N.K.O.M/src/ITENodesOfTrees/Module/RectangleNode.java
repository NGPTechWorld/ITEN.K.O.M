package ITENodesOfTrees.Module;

import java.util.ArrayList;
import java.util.List;

public class RectangleNode {
    List<Integer> Rectangles;

    public RectangleNode(int width, int height, List<Integer> rectangles) {
        Rectangles = rectangles;
        this.width = width;
        this.height = height;
    }

    int width, height;

    RectangleNode collecting(RectangleNode left, RectangleNode right) {
        for (Integer Index : left.Rectangles) {
            if (right.Rectangles.contains(Index))
                return null;
        }
        List<Integer> Index = new ArrayList<>();
        Index.addAll(left.Rectangles);
        Index.addAll(right.Rectangles);
        for (int i = 0; i < 2; i++) {
            if (left.height == right.height) {
                return new RectangleNode(left.width + right.width, left.height, Index);
            }
            if (left.width == right.width) {
                return new RectangleNode(left.width, left.height + right.height, Index);
            }
            int tmp = left.width;
            left.width = left.height;
            left.height = tmp;
        }
        return null;
    }

    boolean Rectangle(List<Node> Rec) {
        List<RectangleNode> Nodes = new ArrayList<>();
        for (int i = 0; i < Rec.size(); i++) {
            List<Integer> Index = new ArrayList<>();
            Index.add(i);
            Nodes.add(new RectangleNode(Rec.get(i).width, Rec.get(i).height, Index));
        }
        for (int i = 0; i < Nodes.size(); i++) {
            for (int j = 0; j < Nodes.size(); j++) {
                if (i == j)
                    continue;
                if (j < i && Nodes.get(i).Rectangles.size() == Nodes.get(j).Rectangles.size())
                    continue;
                RectangleNode node = collecting(Nodes.get(i), Nodes.get(j));
                if (node == null)
                    continue;
                System.out.println(node.Rectangles + " " + node.width + " " + node.height);
                if (node.Rectangles.size() == Rec.size())
                    return true;
                Nodes.add(node);
            }
        }
        return false;
    }

    int NumberOfRectangles(List<Node> Nodes) {
        int counter = 0;
        for (int i = 0; i < (1 << Nodes.size()); i++) {
            List<Node> collection = new ArrayList<>();
            for (int j = 0; j < Nodes.size(); j++) {
                if (((1 << j) & i) > 0)
                    collection.add(Nodes.get(j));
            }
            counter += (Rectangle(collection) ? 1 : 0);
        }
        return counter;
    }
}
