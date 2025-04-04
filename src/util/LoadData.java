package util;

import gui.GameModel;
import map.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class LoadData {
    public static final String PLAYER = "entity/lancelot_.png";
    public static final String LEVEL_1_MAP = "world/game_world01.txt";
    public static final String LEVEL_1_DESIGN = "tiles/world_tileset.png";

    public static BufferedImage getImage(String path) {
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

    public static int[][] getLevelData(String fileName) {
        int[][] mapTileNum = new int[GameModel.TILES_IN_HEIGHT][GameModel.TILES_IN_WIDTH];

        try {
            InputStream input = LoadData.class.getClassLoader().getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            int row = 0;
            while (row < GameModel.TILES_IN_HEIGHT) {
                String line = reader.readLine();
                if (line == null) break;

                String[] numbers = line.split(" ");
                for (int col = 0; col < Math.min(numbers.length, GameModel.TILES_IN_WIDTH); col++) {
                    mapTileNum[row][col] = Integer.parseInt(numbers[col]);
                }
                row++;
            }

            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return mapTileNum;
    }
}
