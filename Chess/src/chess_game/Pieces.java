package chess_game;

import java.util.LinkedList;

public class Pieces {
    int x,y,xPos,yPos;
    boolean isWhite;
    LinkedList<Pieces> pc;
    String nameOfPiece;

    Pieces(int x, int y, boolean isWhite,String name,LinkedList<Pieces> pc) {
        this.x = x;
        this.y = y;
        xPos = x*80;
        yPos = y*80;
        this.isWhite = isWhite;
        this.nameOfPiece = name;
        this.pc = pc;
        pc.add(this);
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

    public void move(int xpos, int ypos) {
        if (getPiece(xpos*80,ypos*80) != null) {
            if (getPiece(xpos*80,ypos*80).isWhite != isWhite) {
                getPiece(xpos*80,ypos*80).removePiece();
            } else {
               return;
            }
        }
        this.x = xpos;
        this.y = ypos;
        xPos = x*80;
        yPos = y*80;
    }

    public void removePiece() {
        pc.remove(this);
    }
}
