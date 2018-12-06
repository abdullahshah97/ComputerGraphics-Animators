/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComputerGraphics;

import javax.swing.JOptionPane;

/**
 *
 * @author as358
 */

public class PerspectiveAnimator extends ParallelAnimator
{
  protected void setupCamera()
  {
    camera= new PerspectiveCamera(-5,5,-5,5);
    ((PerspectiveCamera)camera).setupUVN(new Point3D(0,0,0), new Vector3D(0,0,5), new Vector3D(0,2,0));
    ((PerspectiveCamera)camera).setupCOP(new Point3D(0,0,3));
    String cop = "";
    Point3D cp = new Point3D(0,0,0);
    cop = JOptionPane.showInputDialog(null, "Would you like to change Center of Projection?\ny/n");
    if("y".equals(cop)){
        cop = JOptionPane.showInputDialog(null,"What are the new coordinates? Please seperate them with a comma");
        String [] a;
        a = cop.split(",");
        int [] b = new int [a.length];
        for (int i=0;i<a.length;i++){
        b[i]=Integer.parseInt(a[i]);     
        ((PerspectiveCamera)camera).setupCOP(new Point3D(b[0],b[1],b[2]));
    }
    }
  }
    

  public static void main(String[] args)
  { 
    new PerspectiveAnimator().loop();
  }
}