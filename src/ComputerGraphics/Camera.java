package ComputerGraphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author as358
 */

public class Camera
{
    
  private double xmin, xmax, ymin, ymax;
  private double fcp, bcp;  //NOT USED: front & back clippling planes
  private double ax, bx, ay, by;
  
  public Camera(double xmin_, double xmax_, double ymin_, double ymax_){
  this.xmin=xmin_;
  this.xmax=xmax_;
  this.ymin=ymin_;
  this.ymax=ymax_;
  }
  
  public Vector3D getVPN(){
  
      return new Vector3D(0,0,1);
  }
 
  protected Point3D cameraTransform(final Point3D p){ 
  return p;
  }
 
  protected Point3D projectionTransform(final Point3D p){
  return new Point3D(p.x,p.y,0);
  } 
 
  private final Point3D viewportTransform(final Point3D p){
  //x' = aX + bX*x, and y' = aY + bY*y.
  double nx = ax + bx*p.x;
  double ny = ay + bx*p.y;
  Point3D a = new Point3D(nx,ny,0);
  return a;
  }
 
  public final Point3D project(final Point3D p){
    
    Point3D temp=cameraTransform(p);
    
    temp=projectionTransform(temp);
    
    return viewportTransform(temp);
  }
 

 
  public void setViewport(int width, int height){
  double umin;
      umin = 0;
  double umax;
      umax = width;
  double vmin;
      vmin = 0;
  double vmax;
      vmax = height;
  double dx= xmax-xmin;
  double dy= ymax-ymin;
  double du= umax-umin;
  double dv= vmax-vmin;
  bx= du/dx;
  by=dv/dy;
  ax=umin - bx*xmin;
  ay=vmin - by*ymin;
  

//dX = Xmax - Xmin, dY = Ymax - Ymin    
      //bX = dU/dX; aX = Umin - bX*Xmin; 
    //  bY = dV/dY; aY = Vmin - bY*Ymin;
      
  
  }
 
  public String toString(){
  return null;
  }

}

