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
import java.awt.Color;

public class Face
{
  public int[] index;
  public Color color;

  public Face(int[] i, Color c){
      index = new int[i.length];
      for(int j=0; j<i.length;j++){
          index[j]=i[j];
      }
      this.color=c;
  }

  
  public String toString()
  {   String info ="";
      for(int i =0; i<index.length;i++)
      { info = info+""+index[i]+", ";
          }
      info = info + color.toString();
      return info;
  }
}


