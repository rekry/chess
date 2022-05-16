package chess_game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class DrowPiece {
    public Image[] piece() throws IOException {
        //BufferedImage allPieces = ImageIO.read(new File("/resources/chess.png"));
        InputStream in = DrowPiece.class.getClassLoader().getResourceAsStream("resources/chess.png");
        BufferedImage allPieces = ImageIO.read(Objects.requireNonNull(in));
        Image[] img = new Image[12];
        int i = 0;
        for (int y = 0;y<400;y+=200) {
            for (int x = 0;x<1200;x+=200) {
                img[i] = allPieces.getSubimage(x,y,200,200).getScaledInstance(80,80, BufferedImage.SCALE_SMOOTH);
                i++;
            }
        }
        return img;
    }
}
