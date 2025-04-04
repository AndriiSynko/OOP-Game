package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class LoadData {
    public static final String PLAYER = "entity/lancelot_.png";

    public static BufferedImage getEntityImage(String path) {
        BufferedImage img = null;

        InputStream is = LoadData.class.getResourceAsStream("/"+path);
        try {
            img = ImageIO.read(is);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
}
