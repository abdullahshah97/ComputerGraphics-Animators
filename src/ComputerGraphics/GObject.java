/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComputerGraphics;

/**
 *
 * @author as358
 */
import java.util.Scanner;
import java.io.*;
import java.awt.Color;

public class GObject
{
  public Point3D[] vertex;
  public Face[] face;
  
  public GObject(Point3D[] v, Face[] f){
      face = new Face[f.length];
      vertex = new Point3D[v.length];
      
      for(int i=0; i <f.length;i++){
          face[i]=f[i];
      }
      for (int j =0; j<v.length;j++){
                vertex[j]=v[j];
      }
      
  }
    
  
  public GObject(String fileName){
      
    File file = new File(fileName);

    try {
        Scanner sc = new Scanner(file);
        vertex= new Point3D[sc.nextInt()];
        sc.nextLine();
        int i =0;
        while (sc.hasNextLine() && i<vertex.length) {
            String  line = sc.nextLine();
            String [] splitLine = line.split(" ");
            vertex[i]= new Point3D(Double.parseDouble(splitLine[0]),Double.parseDouble(splitLine[1]),Double.parseDouble(splitLine[2]));
            i++;
        }
        
        sc.nextLine();
        face=new Face[sc.nextInt()];
        int j = 0;
        while (sc.hasNextLine()&&j<face.length){
            int [] noV = new int[sc.nextInt()];
            sc.nextLine();
            String  line1 = sc.nextLine();
            String [] splitLine1 = line1.split(" ");
                for (int n=0; n<noV.length;n++){
                    noV[n]= Integer.parseInt(splitLine1[n]);
                }
            float[] colors = new float[3];
            String  line = sc.nextLine();
            String [] splitLine = line.split(" ");            
            colors[0] = Float.parseFloat(splitLine[0]);
            colors[1] = Float.parseFloat(splitLine[1]);
            colors[2] = Float.parseFloat(splitLine[2]);
            Color pol = new Color(colors[0],colors[1],colors[2]);
            face[j]= new Face(noV,pol);
            j++;
        }
        sc.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
 }    
      
  public void transform(Matrix m){
      for(int i =0; i< vertex.length;i++)
      {     vertex[i]=vertex[i].transform(m);          
      }   
      
  }

  public String toString(){
      String info="";
      for(int i =0; i<face.length;i++){
      info = info+face[i].toString()+"\n";
      }
      return info;
  }
}