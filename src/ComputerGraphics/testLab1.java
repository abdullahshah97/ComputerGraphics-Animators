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
public class testLab1 {
    public static void main(String[]args){
        Vector3D v1 = new Vector3D(1.0,1.0,1.0);
        Vector3D v2 = new Vector3D(1.0,1.0,-1.0);
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        
            try{
                Vector3D v3 = v1.clone();
                System.out.println("Cloned Vector = " + v3);
            }
            catch(CloneNotSupportedException e)
            {
                System.out.println("Could not clone");
            }
        double norm = v1.L2norm();
        System.out.println("Norm of v1 " + norm);
        
        Vector3D crossProduct = v1.crossProduct(v2);
        System.out.println("Cross Product of v1, v2 = " + crossProduct.toString());
        
        double dot = v1.dotProduct(v2);
        System.out.println("dot product of v1 and v2 is " + dot);
        
        v1.normalize();
        v1.toString();
        
    GObject al = new GObject("/homes/as358/NetBeansProjects/CG/cube.dat");
    System.out.println(al.toString());
    
    }
}
