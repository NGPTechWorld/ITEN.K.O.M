package ITETransTrees;

import ControllersUI.DataBase;
import ITENodesOfTrees.Controller.TextFormatController;
import ITETransTrees.View.DrawerUI;
import ITETransTrees.View.HomePageTrans;

public class ITETransTrees {
        public static void main(String[] args) throws Exception {

            /*
             * 
             *
A -> B,C,D,E
B -> F,G,H
C -> I
D -> J
E -> K
             */
            new DataBase();
            TextFormatController.Import("(A[20,10] | (B[20,10]|C[30,10])) - (D[30,50] | (E[40,30] - F[40,20]))\r");
            new HomePageTrans();
            
            //     String test1[] = {
            //         "B -> E,F",
            //         "C -> G",
            //         "D -> H,I,J",
            //         "J -> K",
            //         "A -> B,C,D",
            // };
            // String test2[] = {
            //         "A -> B,C,D,E",
            //         "B -> F,G,H",
            //         "C -> I",
            //         "D -> J",
            //         "E -> K"
            // };
            // String test3[] = {
            //         "A -> B",
            //         "B -> C",
            //         "C -> D",
            //         "D -> E",
            //         "E -> F",
            //         "F -> G",
            // };
            // String test4[] = {
            //         "hasan -> kasm,nour",
            //         "nour -> kareem",
            //         "kareem -> manar,nuaimi",
            //         "manar -> aydi,usama",
            // };
            // Node p = new Node();
            // p.value = "parent";
            // Tree t = new Tree();
            //     t.Export(test1);
            // //        t.dfs(t.G_root , p);
            //     t.Import();
            //     for (String s : t.edges) {
            //         System.out.println(s);
            //     }
            // //        t.ImportGtoB(t.G_root);
            // //        t.dfs(t.B_root , p);
            // //        t.G_root = null;
            // //        t.ExportBtoG(t.B_root);
            // //        t.dfs(t.G_root, p);
            // //        t.Import();
            // //        for (String s : t.edges)
            // //            System.out.println(s);
        }

}
