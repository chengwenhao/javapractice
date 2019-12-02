package NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        System.out.println(l);
        String rFile = "E:\\IdeaProjects\\javapracticeFile\\NIOtest\\test1.JPG";
        String wFile = "E:\\IdeaProjects\\javapracticeFile\\NIOtest\\test3.JPG";
        String wFile1 = "E:\\IdeaProjects\\javapracticeFile\\NIOtest\\test4.JPG";
        //NIO
        FileChannel fcin = new FileInputStream(rFile).getChannel();
        FileChannel fcout = new FileOutputStream(wFile).getChannel();
        //1.方法一
        /*ByteBuffer buff = ByteBuffer.allocate(1024);
        while(true){
            buff.clear();
            if((fcin.read(buff)) == -1){
                break;
            }
            buff.flip();
            fcout.write(buff);
        }*/

        //2.方法二
       /* fcin.transferTo(0, fcin.size(), fcout);
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        System.out.println(l1-l);*/


        //IO
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(rFile)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(wFile1)));
        byte[] bytes = new byte[1024];
        int i = 0;
        while (i != -1){
            i = in.read(bytes);
            out.write(bytes);
        }
        in.close();
        out.close();
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        System.out.println(l1-l);
    }




}
