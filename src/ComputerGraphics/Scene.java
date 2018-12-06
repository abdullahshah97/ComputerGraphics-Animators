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
import java.awt.*;
import static java.awt.Color.*;
import java.awt.image.BufferedImage;
import static java.lang.Math.PI;
import javax.swing.JCheckBox;

public class Scene {

    private GObject[] obj;
    private JCheckBox w;

    public Scene(String[] fileName, JCheckBox wire) {
        obj = new GObject[fileName.length];

        for (int i = 0; i < fileName.length; i++) {
            obj[i] = new GObject(fileName[i]);
        }
        w = wire;

    }

    public void transform(Matrix m) {
        for (int i = 0; i < obj.length; i++) {
            obj[i].transform(m);
        }
    }

    //wait until next lab for Camera
    public void draw(Camera c, Graphics g) {
        Point3D[] points;
        int[] xPoints;
        int[] yPoints;
        
        GObject temp;
        double running = 0;
        int runobj = 0;

        
            for (int i = 0; i < obj.length-1; i++) {     
                
            for(int a=0; a<obj[i].vertex.length-1;a++){
                

                    
                if(obj[i].vertex[a].z<running){
                     running = obj[i].vertex[a].z;
                     runobj=i;
                 } 
                
                    temp=obj[i];
                    obj[i]=obj[runobj+1];
                    obj[i+1]=temp;                  
                
                
                }      

                
            }
            
            for (int i = 0; i < obj.length; i++) {           
                
            for (int j = 0; j < obj[i].face.length; j++) {
                
                points = new Point3D[obj[i].face[j].index.length];
                for (int n = 0; n < points.length; n++) {
                    
                    int a = obj[i].face[j].index[n];
                    points[n] = c.project(obj[i].vertex[a]);
                    
                }

                if (Point3D.isFrontFace(points[0],points[1],points[2], c.getVPN())) {
                    
                    xPoints = new int[points.length];
                    yPoints = new int[points.length];

                    for (int q = 0; q < points.length; q++) {
                        xPoints[q] = (int) points[q].x;
                        yPoints[q] = (int) points[q].y;
                    }
                                          
                    g.setColor(obj[i].face[j].color);
                    if(!w.isSelected()){
                    g.fillPolygon(xPoints, yPoints, points.length);
                    }
                    else{g.drawPolygon(xPoints, yPoints, points.length);
                    
                    }
                            

                }              
            }
        }
    }
 

    public String toString() {
        String output="";
        for(int i=0; i<obj.length;i++){
            for (int j=0; j<obj[i].vertex.length; j++){
                output= output+" ADD"+obj[i].vertex[j];
            }
        }
        return output;
        
    }
}
