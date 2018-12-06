
package ComputerGraphics;
import static java.lang.Math.sqrt;

public class Point3D
{
  public double x,y,z;

  public Point3D(double X,double Y,double Z){
  this.x=X;
  this.y=Y;
  this.z=Z;
  }

  public double distance(Point3D p){
      double distance=0;
      distance = sqrt(Math.pow((this.x-p.x),2)+Math.pow((this.y-p.y),2)+Math.pow((this.z-p.z),2));
      System.out.println("Distance is:"+distance);
      return distance;
  }

  public Point3D transform(Matrix m){
  double w = 1;
  double nx = 0;
  double ny = 0;
  double nz = 0;
  nx = x*m.m[0][0]+y*m.m[0][1]+z*m.m[0][2]+m.m[0][3];
  ny = x*m.m[1][0]+y*m.m[1][1]+z*m.m[1][2]+m.m[1][3];
  nz = x*m.m[2][0]+y*m.m[2][1]+z*m.m[2][2]+m.m[2][3];
  w =  x*m.m[3][0]+y*m.m[3][1]+z*m.m[3][2]+m.m[3][3];
  
  Point3D P3D = new Point3D(nx/w,ny/w,nz/w);
  return P3D;   
  }
   
  public Vector3D vector(Point3D p){
    double nx = 0;
    double ny = 0;
    double nz= 0;
    
    nx = p.x - this.x;
    ny = p.y - this.y;
    nz = p.z - this.z;
    
    Vector3D vec = new Vector3D(nx,ny,nz);    
    return vec;
  }
  
  public static Vector3D faceNormal(Point3D p1, Point3D p2, Point3D p3){
      Vector3D vec1 = p1.vector(p2);
      Vector3D vec2 = p1.vector(p3);
      Vector3D n = vec1.crossProduct(vec2);
      return n;
       
  }
  
  public static boolean isFrontFace(Point3D p1, Point3D p2, Point3D p3, Vector3D vpn){
      Vector3D n = faceNormal(p1,p2,p3);
      double css = 0;
      css = n.dotProduct(vpn);
      return (css<0);

  }
          
  public String toString(){
  return ("Point has co-ordinates-("+this.x+","+this.y+","+this.z+")");
          }
}
