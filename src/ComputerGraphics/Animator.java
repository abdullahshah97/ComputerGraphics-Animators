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
import java.awt.image.BufferedImage;

public class Animator extends JFrame
{
  private javax.swing.JCheckBox Wireframe;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JToolBar jToolBar1;
   private static final int WIDTH=450;
  private static final int HEIGHT=300;
  private static final int INTERVAL=80;
  private BufferedImage image;
  
  public Animator()
  {
    setSize(WIDTH,HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
  
        jToolBar1 = new javax.swing.JToolBar();
        Wireframe = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        Wireframe.setText("Wireframe");
        jToolBar1.add(Wireframe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        jToolBar1.getAccessibleContext().setAccessibleParent(null);

        pack();
  }

  private int R;
  protected void animate(Graphics g)
  {
    g.setColor(Color.PINK);
    R=R>20?0:R+1;
    g.fillPolygon(new int[]{100,200,R*3},new int[]{100,900/2,R*3},3);
  }

  protected final void loop()
  {
    while(true)
    {
      image=new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D g2 = image.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(Color.GRAY);
      g2.fillRect(0,0,getWidth(),getHeight());
      
      animate(g2);

      ((Graphics2D)getGraphics()).drawImage(image,0,0,null);
      paint(getGraphics());
      try {Thread.sleep(INTERVAL);}
      catch(InterruptedException e){}
    }
  }
  
  public JCheckBox getBox(){
      return Wireframe;
  }

  public final void paint(Graphics g){}

  
  
  
  
  
  public static void main(String[] args) 
  {
    new Animator().loop();
  }
}
