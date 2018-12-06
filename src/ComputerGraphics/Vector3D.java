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
import static java.lang.Math.*;  /* Now you can use math functions without the Math. prefix */

public class Vector3D implements Cloneable     
{
  public double x,y,z;
  
  public Vector3D(double X, double Y, double Z){
  x=X;
  y=Y;
  z=Z;
  }

  public Vector3D transform(Matrix m){
  double w = 1;
  double nx = 0;
  double ny = 0;
  double nz = 0;
  nx = x*m.m[0][0]+y*m.m[0][1]+z*m.m[0][2];
  ny = x*m.m[1][0]+y*m.m[1][1]+z*m.m[1][2];
  nz = x*m.m[2][0]+y*m.m[2][1]+z*m.m[2][2];
  w = x*m.m[3][0]+y*m.m[3][1]+z*m.m[3][2]+m.m[3][3];  
  Vector3D vec = new Vector3D(nx/w,ny/w,nz/w);
  return vec;
  }
  

  public Vector3D clone() throws CloneNotSupportedException{
  Vector3D second = new Vector3D(this.x,this.y,this.z);
  return second;  
  }

  public double L2norm(){
  double norm = sqrt(Math.pow((this.x),2)+Math.pow((this.y),2)+Math.pow((this.z),2));
  return norm;
  }

  public double dotProduct(Vector3D v){
  double dot = this.x*v.x+this.y*v.y+this.z*v.z;
 // System.out.println("Dot product is"+dot);
  return dot;
  }
  

  public Vector3D crossProduct(Vector3D v){
  double xCross = 0;
  double yCross = 0;
  double zCross = 0;
  xCross = (this.y*v.z)-(this.z*v.y);
  yCross = (this.z*v.x)-(this.x*v.z);
  zCross = (this.x*v.y)-(this.y*v.x);
  Vector3D crossd = new Vector3D(xCross,yCross,zCross);
  return crossd;
  }  
  
  public void normalize(){
  double norm = sqrt(Math.pow((this.x),2)+Math.pow((this.y),2)+Math.pow((this.z),2));
  this.x=this.x/norm;
  this.y=this.y/norm;
  this.z=this.z/norm;
  //System.out.println("("+this.x/norm+","+this.y/norm+","+this.z/norm+")");
  } 
  
  public String toString(){
  return ("Vector has co-ordinates-("+this.x+","+this.y+","+this.z+")");
  }
}