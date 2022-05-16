package chess_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.Timer;

public class GamePannel extends JPanel implements EventListener {
    DrowPiece drowPiece = new DrowPiece();
    LinkedList<Pieces> pc = new LinkedList<>();
    Pieces selectedPiece = null;
    Point prevPt;
    //private final Timer timer = new Timer(10,this);
    GamePannel(){
        //white
        new Pieces(0,0,true,"rook",pc);
        new Pieces(1,0,true,"knight",pc);
        new Pieces(2,0,true,"bishop",pc);
        new Pieces(3,0,true,"king",pc);
        new Pieces(4,0,true,"queen",pc);
        new Pieces(5,0,true,"bishop",pc);
        new Pieces(6,0,true,"knight",pc);
        new Pieces(7,0,true,"rook",pc);
        new Pieces(0,1,true,"pown",pc);
        new Pieces(1,1,true,"pown",pc);
        new Pieces(2,1,true,"pown",pc);
        new Pieces(3,1,true,"pown",pc);
        new Pieces(4,1,true,"pown",pc);
        new Pieces(5,1,true,"pown",pc);
        new Pieces(6,1,true,"pown",pc);
        new Pieces(7,1,true,"pown",pc);
        //black
        new Pieces(0,7,false,"rook",pc);
        new Pieces(1,7,false,"knight",pc);
        new Pieces(2,7,false,"bishop",pc);
        new Pieces(3,7,false,"king",pc);
        new Pieces(4,7,false,"queen",pc);
        new Pieces(5,7,false,"bishop",pc);
        new Pieces(6,7,false,"knight",pc);
        new Pieces(7,7,false,"rook",pc);
        new Pieces(0,6,false,"pown",pc);
        new Pieces(1,6,false,"pown",pc);
        new Pieces(2,6,false,"pown",pc);
        new Pieces(3,6,false,"pown",pc);
        new Pieces(4,6,false,"pown",pc);
        new Pieces(5,6,false,"pown",pc);
        new Pieces(6,6,false,"pown",pc);
        new Pieces(7,6,false,"pown",pc);
    }

    protected JPanel panel() {
        JPanel panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                boolean white = true;
                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (white) {
                            g.setColor(new Color(235,235,208));
                        } else {
                            g.setColor(new Color(119,148,85));
                        }
                        g.fillRect(x*80,y*80,80,80);
                        white=!white;
                    }
                    white = !white;
                }
                for (Pieces p:pc) {
                    int i = -1;
                    if (p.nameOfPiece.equals("king")) {
                        i = 0;
                    }
                    if (p.nameOfPiece.equals("queen")) {
                        i = 1;
                    }
                    if (p.nameOfPiece.equals("bishop")) {
                        i = 2;
                    }
                    if (p.nameOfPiece.equals("knight")) {
                        i = 3;
                    }
                    if (p.nameOfPiece.equals("rook")) {
                        i = 4;
                    }
                    if (p.nameOfPiece.equals("pown")) {
                        i = 5;
                    }
                    if (!p.isWhite) {
                        i +=6;
                    }

                    try {
                        g.drawImage(drowPiece.piece()[i],p.xPos,p.yPos,null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        panel.setPreferredSize(new Dimension(640,640));
        panel.setBackground(Color.black);

        panel.addMouseListener(new ClickListener(panel));
        //panel.addMouseMotionListener(new DragListener(panel));
        return panel;
    }

    /*private class DragListener extends MouseMotionAdapter {

        private final JPanel panel;

        public DragListener(JPanel panel) {
            this.panel = panel;
        }

        public void mouseDragged(MouseEvent e) {
            if (selectedPiece!=null) {
                selectedPiece.xPos= e.getX()-40;
                selectedPiece.yPos= e.getY()-40;
                Point point = new Point(selectedPiece.xPos,selectedPiece.yPos);

                point.translate((int)(point.getX()-prevPt.getX()),(int)(point.getY()-prevPt.getY()));
                panel.repaint();
            }
        }
    }*/

    private class ClickListener extends MouseAdapter {
        private final JPanel panel;

        public ClickListener(JPanel panel) {
            this.panel = panel;
        }

        public void mousePressed(MouseEvent e) {
            selectedPiece = getPiece(e.getX(),e.getY());
            prevPt = e.getPoint();
        }
        public void mouseReleased(MouseEvent e) {
            selectedPiece.move(e.getX()/80, e.getY()/80);
            //timer.start;
            panel.repaint();
        }
    }

    public Pieces getPiece(int x,int y) {
        int xpos = x/80;
        int ypos = y/80;
        for (Pieces p: pc) {
            if (p.x == xpos && p.y==ypos) {
                return p;
            }
        }
        return null;
    }
}
