package image.tool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by jianying.wcj on 2015/1/18 0018.
 */
public class ImageTypeChecker {

    public static boolean checkImage(byte[] src) {
        int v1 = src[0] & 0xFF;// byte to int
        String hv1 = Integer.toHexString(v1);
        int v2 = src[1] & 0xFF;// byte to int
        String hv2 = Integer.toHexString(v2);
        int v3 = src[2] & 0xFF;// byte to int
        String hv3 = Integer.toHexString(v3);
        int v4 = src[3] & 0xFF;// byte to int
        String hv4 = Integer.toHexString(v4);
        String type1 = hv1 + hv2;
        String type2 = hv1 + hv2 + hv3 + hv4;
        // gif 47 49 46 38
        // .bmp 42 4d
        // jpg ffd8
        // .png 89 50 4e 47
        if ("ffd8".equals(type1)) {  //.jpg
            return true;
        } else if ("424d".equals(type1)) { //.bmp
            return true;
        } else if ("89504e47".equals(type2)) { //.png
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        File file2 = new File("C:\\Users\\jianying.wcj\\Desktop\\test1.JPG");
        try {
            FileInputStream fis = new FileInputStream(file2);
            byte[] buf = new byte[(int) file2.length()];
            fis.read(buf);
            System.out.println(checkImage(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
