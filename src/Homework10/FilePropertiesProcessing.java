//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Homework10;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilePropertiesProcessing {
    private static final String PATH = "D:\\Java\\IdeaProjects\\Homework\\src\\Homework10\\Properties.txt";
    private static final String PATH2 = "D:\\Java\\IdeaProjects\\Homework\\src\\Homework10\\Properties1.txt";
    private static int BUFFER_SIZE = 1024;
    private static String fileContent;

    public FilePropertiesProcessing() {
    }

    public static void main(String[] args) throws IOException {
        readPropertiesFile(PATH, BUFFER_SIZE);
        propertiesFileProcessing();
        writePropertiesFile(PATH2, fileContent);
    }

    public static void readPropertiesFile(String path, int bufSize) throws IOException {
        File file = new File(path);
        FileInputStream inputStream = null;

        try {
            for(int size = 128; size < bufSize; size *= 2) {
                inputStream = new FileInputStream(file);
                readWithBuffer(inputStream, bufSize);
            }
        } catch (IOException var8) {
            throw new IOException("Error opening or reading file" + path, var8);
        } finally {
            closeSilentlyIn(inputStream);
        }

    }

    public static void writePropertiesFile(String path, String fileProperties) {
        File file = new File(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileOutputStream out = null;
        byte[] buffer = fileProperties.getBytes();

        try {
            baos.write(buffer);
            out = new FileOutputStream(file);
            baos.writeTo(out);
        } catch (IOException var10) {
            System.out.println("Error writing file" + path);
        } finally {
            closeSilentlyOut(baos);
        }

    }

    private static void closeSilentlyOut(OutputStream out) {
        if(out != null) {
            try {
                out.flush();
            } catch (IOException var4) {
                try {
                    out.close();
                } catch (IOException var3) {
                    ;
                }
            }
        }

    }

    private static void readWithBuffer(InputStream is, int bufSize) throws IOException {
        for(byte[] buffer = new byte[bufSize]; is.read(buffer) != -1; fileContent = new String(buffer)) {
            is.read(buffer);
        }

    }

    private static void closeSilentlyIn(InputStream is) {
        if(is != null) {
            try {
                is.close();
            } catch (IOException var2) {
                ;
            }
        }

    }

    private static void propertiesFileProcessing() {
        String[] string = fileContent.split("\r");
        boolean isExist = false;
        fileContent = "";
        String[] var2 = string;
        int j = string.length;

        for(int var4 = 0; var4 < j; ++var4) {
            String current = var2[var4];
            if(!current.startsWith("\n#") && !current.startsWith("#") && !current.equals("\n")) {
                fileContent = fileContent + current + "\r";
            }
        }

        string = fileContent.split("\r");
        fileContent = "";

        for(int i = 0; i < string.length - 1; ++i) {
            for(j = i + 1; j < string.length; ++j) {
                if(string[i].equals(string[j])) {
                    isExist = true;
                    break;
                }
            }

            if(!isExist) {
                fileContent = fileContent + string[i] + "\r";
            } else {
                isExist = false;
            }
        }

        fileContent = fileContent + string[string.length - 1];
        alphabeticlOrder(fileContent);
    }

    private static void alphabeticlOrder(String string) {
        String[] temp = string.split("\r");

        for(int i = 0; i < temp.length - 1; ++i) {
            for(int j = i; j < temp.length; ++j) {
                if(temp[i].compareToIgnoreCase(temp[j]) > 0) {
                    String str = temp[j];
                    temp[j] = temp[i];
                    temp[i] = str;
                }
            }
        }

    }
}
