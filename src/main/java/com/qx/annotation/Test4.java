package com.qx.annotation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Xuan
 * Date: 2021/11/22
 * Time: 20:30
 */

public class Test4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String packageName = "annotation";

        scanPackage(packageName);
    }


    public static void scanPackage(String iPackage){
        String path = iPackage.replace(".", "/");
        URL url = Thread.currentThread().getContextClassLoader().getResource(path);
        try {
            if(url!=null && url.toString().startsWith("file")){
                String filePath = URLDecoder.decode(url.getFile(),"utf-8");
                File dir = new File(filePath);
                List<File> fileList = new ArrayList<File>();
                fetchFileList(dir,fileList);
                for(File f:fileList){
                    String fileName =  f.getAbsolutePath();

                    if(fileName.endsWith(".class")){
                        String nosuffixFileName = fileName.substring(6+fileName.lastIndexOf("JiChu"),fileName.indexOf(".class"));
                        String filePackage = nosuffixFileName.replaceAll("/", ".");

                        System.out.println(filePackage);
                        Class clazz = Class.forName(filePackage);
                        if(clazz.isAnnotationPresent(MyAnnotation4.class)){
                            Object o = clazz.newInstance();
                            if(o instanceof Test3){
                                ((Test3) o).hello();
                            }
                        }
                    }else{
                        System.out.println(f.getName());
                    }
                    //TODO code........
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void  fetchFileList(File dir,List<File> fileList){
        if(dir.isDirectory()){
            for(File f:dir.listFiles()){
                fetchFileList(f,fileList);
            }
        }else{
            fileList.add(dir);
        }
    }


}
