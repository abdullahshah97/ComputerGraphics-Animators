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
import javax.swing.*;
import static java.lang.Math.*;
 
public class ParallelAnimator extends Animator
{
  private static final String[] files={"./cube.dat","./pyramid.dat"};
  public ParallelAnimator()
  {
    super();
 
    scene=new Scene(files, getBox());
    setupCamera();
  }
 
  protected void setupCamera()
  {
    camera= new Camera(-5,5,-5,5);
  }
 
  protected void animate(Graphics g)
  {
    camera.setViewport(getWidth(),getHeight());
 
    if(g==null || scene==null || camera==null)
      return;
 
    Matrix mX=new Matrix(), mY=new Matrix(), mZ=new Matrix();
    mX.setRotationX(-PI/5);
    mY.setRotationY(PI/9);
    mZ.setRotationZ(PI/10); 
    scene.transform(mZ.multiply(mY.multiply(mX)));  
    scene.draw(camera,g);
  }
 
  public static void main(String[] args) 
  {
    new ParallelAnimator().loop();
  }
 
  private Scene scene;
  protected Camera camera;
}