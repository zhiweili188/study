package com.bird.example.discovery;

import java.io.File;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;

public class GenerateNewPerson {
	public static void main(String[] args) throws Exception {  
        // 使用全限定名，创建一个ClassReader对象  
        ClassReader classReader = new ClassReader(  
                "com.bird.example.discovery.HelloWorld");  
        // 构建一个ClassWriter对象，并设置让系统自动计算栈和本地变量大小  
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);  

        ClassAdapter classAdapter = new GeneralClassAdapter(classWriter);  

        classReader.accept(classAdapter, ClassReader.SKIP_DEBUG);  

        byte[] classFile = classWriter.toByteArray();  

        // 将这个类输出到原先的类文件目录下，这是原先的类文件已经被修改  
        File file = new File("target/classes/com/bird/example/discovery/HelloWorld.class");  
        FileOutputStream stream = new FileOutputStream(file);  
        stream.write(classFile);  
        stream.close();  
    }  
}
