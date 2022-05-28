package com.example.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

import static com.example.netty.ByteBufferUtil.debugAll;

public class TestByteBuffer {
    //    public static void main(String[] args) {
//        // 1.字符串转为byteBuffer，不会切换到镀膜室
//        ByteBuffer buffer = ByteBuffer.allocate(10);
//        buffer.put("hello".getBytes());
//        debugAll(buffer);
//
//        buffer.flip();//从头开始读
//        debugAll(buffer);
//        System.out.println((char)buffer.get());//获取0号位置数据
//        debugAll(buffer);
//        // 2.rewind从头开始读
//        buffer.rewind();
//        debugAll(buffer);
//        // 3.mark标记
//        System.out.println((char)buffer.get());//获取0号位置数据
//        System.out.println((char)buffer.get());//获取1号位置数据
//        buffer.mark();//标记当前索引位置
//        System.out.println((char)buffer.get());//获取0号位置数据
//        System.out.println((char)buffer.get());//获取1号位置数据
//        buffer.reset();//将索引重置标记的位置
//        debugAll(buffer);
//        System.out.println((char)buffer.get(0));//不会改变读索引位置
//        debugAll(buffer);
//        // 2.charset切换到镀膜室
//        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
//        debugAll(buffer1);
//        // 3.wrap，切换到读模式
//        ByteBuffer buffer2 = ByteBuffer.wrap("hello".getBytes());
//        debugAll(buffer2);
//
//        String str1 = StandardCharsets.UTF_8.decode(buffer).toString();
//        System.out.println(str1);
//    }
    //分散读出
//    public static void main(String[] args) {
//        try {
//            FileChannel channel = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Netty\\src\\test\\java\\com\\example\\netty\\helloword\\3parts.txt", "r").getChannel();
//            ByteBuffer b1 = ByteBuffer.allocate(3);
//            ByteBuffer b2 = ByteBuffer.allocate(3);
//            ByteBuffer b3 = ByteBuffer.allocate(5);
//            channel.read(new ByteBuffer[]{b1,b2,b3});
//            b1.flip();
//            b2.flip();
//            b3.flip();
//            debugAll(b1);
//            debugAll(b2);
//            debugAll(b3);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    //集中写入
//    public static void main(String[] args) throws IOException {
//        ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello");
//        ByteBuffer b2 = StandardCharsets.UTF_8.encode("world");
//        ByteBuffer b3 = StandardCharsets.UTF_8.encode("你好");
//        FileChannel channel = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Netty\\src\\test\\java\\com\\example\\netty\\helloword\\word.txt", "rw").getChannel();
//        channel.write(new ByteBuffer[]{b1,b2,b3});
//    }
    /*
        网络上有多条数据发送给服务器，数据之间用\n分割
        由于某种原因这些数据在接收时，被进行了重新组合，例如原始数据有3条为
            Hello,world\n
            I'm zhangsan\n
            How are you?\n
        变成了下面的两个bytebuffer（粘包，半包）
            Hello,world\nI'm zhangsan\nHo
            w are you?\n
     */
//    public static void main(String[] args) {
//        ByteBuffer source = ByteBuffer.allocate(32);
//        source.put("Hello world\nI'm zhangsan\nHo".getBytes());
//        split(source);
//        debugAll(source);
//        source.put("w are you?\n".getBytes());
//        split(source);
//        debugAll(source);
//    }

//    public static void split(ByteBuffer source) {
//        source.flip();//读模式
//        for (int i = 0; i < source.limit(); i++) {
//            // 找到完整消息
//            if (source.get(i) == '\n') {
//                int length = i + 1 - source.position();
//                // 把这条完整消息存入新的bytebuffer
//                ByteBuffer target = ByteBuffer.allocate(length);
//                // 从source读，向target写
//                for (int j = 0; j < length; j++) {
//                    target.put(source.get());
//                }
//                debugAll(target);
//            }
//        }
//        source.compact();//写模式,把后面的字符向前移动
//    }
//    流
//    public static void main(String[] args) throws IOException {
//        FileInputStream inputStream = new FileInputStream("C:\\\\Users\\\\DELL\\\\Desktop\\\\Netty\\\\src\\\\test\\\\java\\\\com\\\\example\\\\netty\\\\helloword\\\\word.txt");
//        ByteBuffer buffer = ByteBuffer.allocate(32);
//        inputStream.getChannel().read(buffer);
//        debugAll(buffer);
//        FileOutputStream outputStream = new FileOutputStream("C:\\\\Users\\\\DELL\\\\Desktop\\\\Netty\\\\src\\\\test\\\\java\\\\com\\\\example\\\\netty\\\\helloword\\\\word.txt");
//        ByteBuffer buffer1 = ByteBuffer.allocate(32);
//        buffer1.put(StandardCharsets.UTF_8.encode("sbm"));
//        buffer1.flip();
        //channel写入能力有上线
//        while (buffer1.hasRemaining()){
//            outputStream.getChannel().write(buffer1);
//        }
//        debugAll(buffer1);
//    }
    // 两个通道之间的数据传输
//    public static void main(String[] args) throws IOException {
//        FileChannel channelFrom = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Netty\\src\\test\\java\\com\\example\\netty\\helloword\\dataFrom.txt", "r").getChannel();
//        FileChannel channelTo = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Netty\\src\\test\\java\\com\\example\\netty\\helloword\\dataTo.txt", "rw").getChannel();
//        //效率高，底层操作系统零拷贝优化,最多能传输2g数据
//        channelFrom.transferTo(0,channelFrom.size(),channelTo);
//        FileChannel channelFrom1 = new FileInputStream("C:\\Users\\DELL\\Desktop\\Netty\\src\\test\\java\\com\\example\\netty\\helloword\\dataFrom.txt").getChannel();
//        FileChannel channelTo1 = new FileOutputStream("C:\\Users\\DELL\\Desktop\\Netty\\src\\test\\java\\com\\example\\netty\\helloword\\dataTo.txt").getChannel();
//        //效率高，底层操作系统零拷贝优化,最多能传输2g数据
//        channelFrom1.transferTo(0,channelFrom1.size(),channelTo1);
//        //left代表还剩多少个字节
//        long size = channelFrom.size();
//        for (long left = size;left>0;){
//            left -= channelFrom.transferTo(size-left,left, channelTo);
//        }
//    }
//    public static void main(String[] args) {
//        Files.walkFileTree(Paths.get(),new SimpleFileVisitor<Path>(){
//
//        });
//    }
}
