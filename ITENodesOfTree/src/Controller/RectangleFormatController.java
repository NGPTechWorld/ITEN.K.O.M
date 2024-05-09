// package Controller;

// import java.awt.List;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;

// import Module.Node;

// public class RectangleFormatController {
// public void Import(String[] c){
// rectangle = c;
// root = build(0,0,c.length - 1 , c[0].length() - 1);
// }
// Node build(int x1,int y1,int x2,int y2){
// Node node = new Node();
// for(int i=x1+1;i<x2;i++){
// boolean tmp = true;
// for (int j=y1+1;j<y2;j++){
// if(rectangle[i].charAt(j)!='-'){
// tmp = false;
// break;
// }
// }
// if(tmp){
// node.name = String.valueOf('-');
// node.width = (y2 - y1 - 1);
// node.right = build(i,y1,x2,y2);
// node.left = build(x1,y1,i,y2);
// node.length = node.right.length + node.left.length + 1;
// return node;
// }
// }
// for(int j=y1+1;j<y2;j++){
// boolean tmp = true;
// for (int i=x1+1;i<x2;i++){
// if(rectangle[i].charAt(j)!='|'){
// tmp = false;
// break;
// }
// }
// if(tmp){
// node.name = String.valueOf('|');
// node.length = (x2 - x1 - 1);
// node.right = build(x1,j,x2,y2);
// node.left = build(x1,y1,x2,j);
// node.width = node.right.width + node.left.width + 1;
// return node;
// }
// }
// node.name="";
// for(int i=x1+1;i<x2;i++){
// for (int j=y1+1;j<y2;j++){
// if(!Invalid(rectangle[i].charAt(j))){
// node.name += rectangle[i].charAt(j);
// }
// }
// }
// node.length = (x2 - x1 - 1);
// node.width = (y2 - y1 - 1);
// return node;
// }
// void print(){
// for(int i=0;i<=root.length+1;i++)
// {
// for(int j=0;j<= root.width+1;j++)
// System.out.print(rec[i][j]);
// System.out.println();
// }
// }
// public void Export(){
// rec = new char[root.length + 2][root.width + 2];
// for(int i=0;i<=root.length+1;i++)
// for(int j=0;j<=root.width+1;j++)
// rec[i][j]=' ';
// for(int i=0;i<= root.length+1;i++)
// rec[i][0] = rec[i][root.width+1] = '|';
// for (int i=1; i<= root.width;i++)
// rec[0][i] = rec[root.length+1][i] = '-';
// buildRec(1,1,root);
// }
// void buildRec(int x,int y,Node node){
// if(!node.name.equals("-") && !node.name.equals("|")){
// int in=0;
// for(int i=x;i<x+node.width;i++)
// for(int j=y;j<y+node.length && in<node.name.length();j++,in++)
// if(rec[i][j]==' ')
// rec[i][j] = node.name.charAt(in);
// print();
// return;
// }
// if(node.name.equals("|")){
// for(int i=x;i<x+node.length;i++)
// rec[i][y+node.left.width] = '|';
// print();
// buildRec(x,y,node.left);
// buildRec(x,y+node.left.width+1,node.right);
// }
// else{
// for(int i=y;i<y+node.width;i++)
// rec[x+node.left.length][i]='-';
// print();
// buildRec(x,y,node.left);
// buildRec(x+node.left.length+1,y,node.right);
// }
// }
// }

// }
