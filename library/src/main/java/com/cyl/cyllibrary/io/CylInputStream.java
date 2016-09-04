package com.cyl.cyllibrary.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * io流中的辅助类   从 输入流中读取数据  字符串   或者 下载 内容
 * 字符串默认编码为GBK
 *
 * @author cyl
 *         <p/>
 *         2015-11-29
 */
public class CylInputStream {
    private InputStream inputStream;
    //字符编码
    private String charSet = "GBK";

    public CylInputStream(InputStream inputStream) {
        super();
        this.inputStream = inputStream;
    }

    /**
     * 从流中读取字符串  如果要非常准确的 读取不能使用这个方法
     *
     * @return
     * @throws IOException
     */
    public String getStringFromStream() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charSet));
        String line = null;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
        }
        reader.close();
        return buffer.toString();
    }

    /**
     * 得到流中字符串 （通过字节读取）
     *
     * @return
     * @throws IOException
     */
    public String getString() throws IOException {
        BufferedInputStream ioStream = new BufferedInputStream(inputStream);
        byte[] data = new byte[1024];
        StringBuffer buffer = new StringBuffer();
        int ln = -1;
        while ((ln = ioStream.read(data)) != -1) {
            buffer.append(new String(data, 0, ln, charSet));
        }
        ioStream.close();
        return buffer.toString();
    }

    /**
     * 下载文件
     *
     * @param target
     * @throws IOException
     */
    public void downFile(String target) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(this.inputStream);
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));
        byte[] data = new byte[1024 * 10];
        int ln = -1;
        while ((inputStream.read(data)) != -1) {
            outputStream.write(data, 0, ln);
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
    }

    public String getCharSet() {
        return charSet;
    }

    /**
     * 设置字符编码集
     *
     * @param charSet
     */
    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

}
