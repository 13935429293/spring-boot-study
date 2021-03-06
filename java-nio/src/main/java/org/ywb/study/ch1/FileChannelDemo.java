package org.ywb.study.ch1;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * User: yangwenbiao
 * Date: 2017/3/20
 * Time: 11:14
 */
public class FileChannelDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("test.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);

        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }



        aFile.close();
    }
}
