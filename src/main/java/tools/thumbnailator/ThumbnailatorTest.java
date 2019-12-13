package tools.thumbnailator;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * 生成缩略图的工具
 * 使用Thumbnailator生成缩略图（缩放、旋转、裁剪、水印）
 */
public class ThumbnailatorTest {

    public static void main(String[] args) throws IOException {
        String picturePath = "E:\\IdeaProjects\\javapracticeFile\\thumbnailatorTest\\";
        File originalPic = new File("E:\\IdeaProjects\\javapracticeFile\\thumbnailatorTest\\test.JPG");
        Thumbnails.of(originalPic).size(200,300).toFile(picturePath + "1.jpg");


        //参数大且比例不等
        //则按比例放大，取最小的值
        Thumbnails.of(originalPic)
                .size(4400, 3400)
                .toFile(picturePath + "climb-up.size.4400X3300.jpeg");
        //参数小且比例不等
        //则按比例缩小，取最小的值
        Thumbnails.of(originalPic)
                .size(200, 300)
                .toFile(picturePath + "climb-up.size.200X150.jpeg");
        //不保持比例
        //则按参数输出结果
        Thumbnails.of(originalPic)
                .size(200, 300)
                .keepAspectRatio(false)
                .toFile(picturePath + "climb-up.size.notKeepRatio.200X300.jpeg");
        //强制设置大小
        //则按参数输出结果，与上个例子一样
        Thumbnails.of(originalPic)
                .forceSize(200, 300)
                .toFile(picturePath + "climb-up.forceSize.200X300.jpeg");


        //按比例进行缩放:按比例进行缩放是指按宽和高的比例同时缩放
        //比例小于1，缩小
        //宽和高同时缩小为原来的0.1倍
        Thumbnails.of(originalPic)
                .scale(0.1f)
                .toFile(picturePath + "climb-up.scale.403X302.jpeg");
        //比例大于1，放大
        //宽和高同时放大为原来的1.1倍
        Thumbnails.of(originalPic)
                .scale(1.1f)
                .toFile(picturePath + "climb-up.scale.4435X3326.jpeg");



        //按角度旋转:按角度旋转时，角度为正数时，顺时针；角度为负数时，逆时针。
        Thumbnails.of(originalPic)
                .size(400,300)
                .rotate(45)
                .toFile(picturePath + "climb-up.rotate.45.jpeg");

        //添加水印:添加水印也是十分方便，我们示例将水印放在右上角.
        Thumbnails.of(originalPic)
                .size(2000,1500)
                .watermark(Positions.TOP_RIGHT, ImageIO.read(
                        new File(picturePath + "pkslow.size.400X300.jpeg")), 0.5f)
                .toFile(picturePath + "climb-up.watermark.jpeg");

    }


}
