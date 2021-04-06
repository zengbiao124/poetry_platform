package cn.com.poetry_platform.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

    /**
     * 按行读取文件。
     *
     * @param file
     * @return
     */
    public static List<String> readFileByLines(File file) throws Exception {

        List<String> lines = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line = null;
        // 按行读取
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            lines.add(line);
        }

        return lines;
    }

    /**
     * 按行读取文件。
     *
     * @param path
     * @return
     */
    public static List<String> readFileByLines(String path) throws Exception {
        return readFileByLines(new File(path));
    }

    /**
     * 把LIST内容逐行写入文件。
     *
     * @param path  文件路径
     * @param lines 数据
     * @throws Exception
     */
    public static void writeFileByList(String path, List<String> lines) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    /**
     * 拷贝文件。
     *
     * @param source
     * @param dest
     */
    public static void copyFile(String source, String dest) {
    }


    public static void main(String[] args) throws Exception {
        IOUtils.readFileByLines("D:\\WorkSpace\\jsp_12.3\\src\\com\\test\\jsp\\utils\\IOUtils.java");
    }
}