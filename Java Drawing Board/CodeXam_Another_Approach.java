
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class CodeXam_Another_Approach extends JFrame
{


    public static void main(String [] args)
    {
        new CodeXam_Another_Approach();
    }

    public CodeXam_Another_Approach()
    {
        this.setSize(600, 600);
        this.setTitle("The Drawing Board");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent comp = new PaintSurface();


        this.add(comp, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private static class PaintSurface extends JComponent {
        ArrayList<Shape> shapes = new ArrayList<>();
        Point startDrag, endDrag;

        public PaintSurface() {
            this.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    startDrag = new Point(e.getX(), e.getY());
                    endDrag = startDrag;
                    repaint();
                }


            });
            this.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    startDrag = endDrag;
                    endDrag = new Point(e.getX(), e.getY());
                    repaint();

                }
            });
        }

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;


            g2.setStroke(new BasicStroke(2));

            for (Shape s : shapes) {
                g2.setPaint(Color.BLACK);
                g2.draw(s);
            }

            // paint the temporary rectangle
            if (startDrag != null && endDrag != null) {

                Shape r = makeline(startDrag.x, startDrag.y,
                        endDrag.x, endDrag.y);
                shapes.add(r);
                g2.draw(r);
            }
        }


        private Line2D.Float makeline(
                int x1, int y1, int x2, int y2) {
            return new Line2D.Float(
                    x1, y1, x2, y2);
        }
    }
}