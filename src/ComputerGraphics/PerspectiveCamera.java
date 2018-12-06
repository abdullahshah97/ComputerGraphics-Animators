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
public class PerspectiveCamera extends Camera
{    
private Point3D vrp=new Point3D(0,0,0);
 
private Vector3D vpn=new Vector3D(0,0,1);

private Vector3D vuv=new Vector3D(0,1,0);    
    
private Point3D cop=new Point3D(0,0,-4);
  
  
public PerspectiveCamera(double xmin_, double xmax_, double ymin_, double ymax_){
super (xmin_,xmax_,ymin_,ymax_);
}  
    
  
protected Point3D cameraTransform(final Point3D p){
    Vector3D vpn2 =vpn;
    Vector3D vuv2 =vuv;
    
    Vector3D vun = vuv.crossProduct(vpn);
    vun.normalize();
    vpn.normalize();
    
    Vector3D u = vun;    
    Vector3D n = vpn;
    Vector3D v = n.crossProduct(u);
    
    Matrix R= new Matrix();
    
    R.m[0][0] = u.x;
    R.m[0][1] = u.y;
    R.m[0][2] = u.z;
    
    R.m[1][0] = v.x;
    R.m[1][1] = v.y;
    R.m[1][2] = v.z;
    
    R.m[2][0] = n.x;
    R.m[2][1] = n.y;
    R.m[2][2] = n.z; 
    
    Matrix T = new Matrix();
    
    T.m[0][3]=-(vrp.x);
    T.m[1][3]=-(vrp.y);
    T.m[2][3]=-(vrp.z); 
    
    Matrix M = R.multiply(T);
    
    Point3D nP= p.transform(M);
    return nP;
    
   

}

public void setupUVN(Point3D vrp_, Vector3D vpn_, Vector3D vuv_){
        vrp = vrp_;
        vpn = vpn_;
        vuv = vuv_;

}

private Matrix m=new Matrix(); //camera transformation matrix
{ m.setIdentity(); }
  
  
  
  public Vector3D getVPN(){ 
      return new Vector3D (0,0,1);  
  }

  
  protected Point3D projectionTransform(final Point3D p){
      Matrix nM= new Matrix();
      nM.m[2][2]=0;
      nM.m[3][2]=(1/cop.z);
      Point3D nP = p.transform(nM);
      return nP;
      
      
     /* Point3D nPoint = new Point3D(0,0,0);
      nPoint.x = p.x/((-p.z/cop.z)+1);
      nPoint.y = p.y/((-p.z/cop.z)+1); 
      return nPoint;*/
  }
  
  
  public void setupCOP(Point3D cop_){
      cop= cop_;
  
  }     

   //centre of projection
}