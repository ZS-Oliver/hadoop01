package hadoop.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsUtil {

    FileSystem fs = null;

    @Before
    public void init() throws IOException, URISyntaxException, InterruptedException {

        // 读取项目目录中resources下的xxx-site.xml配置文件，解析其内容，封装到conf对象中
        Configuration conf = new Configuration();

        // 在代码中对conf中的配置信息进行手动设置，覆盖掉原配置文件中读取的值
        conf.set("fs.defaultFS", "hdfs://hadoop01:9000");

        // 根据配置信息，获取一个具体文件系统的客户端操作实例对象
        fs = FileSystem.get(new URI("hdfs://hadoop01:9000"),conf,"hadoop");

    }

    /**
     * 上传文件
     * 较底层写法
     */
    @Test
    public void upload() throws IOException {

        //System.setProperty("HADOOP_USER_NAME","hadoop");
        Path dst = new Path("hdfs://hadoop01:9000/txt/test.txt");

        FSDataOutputStream os = fs.create(dst);

        FileInputStream is = new FileInputStream("d:/test.txt");

        IOUtils.copy(is, os);
    }

    /**
     * 上传文件
     * 封装好的写法
     */
    @Test
    public void upload2() throws IOException {
        fs.copyFromLocalFile(new Path("d:/test.txt"),new Path("hdfs://hadoop01:9000/txt/test1.txt"));
    }
    /**
     * 下载文件
     */
    @Test
    public void download() throws Exception {
        // 第一个false为不删除源文件，第四个true为使用本地原文件系统
        fs.copyToLocalFile(false,new Path("hdfs://hadoop01:9000/txt/test.txt"),new Path("d:/test1.txt"),true);
    }

    /**
     * 查看文件信息
     */
    @Test
    public void listFiles() throws IOException {

        // listFiles列出文件信息，且支持递归遍历
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), false);
        while (listFiles.hasNext()){
            LocatedFileStatus file = listFiles.next();
            Path path = file.getPath();
            System.out.println(path.getName());
        }

        // listStatus列出文件和文件夹的信息，但不支持递归遍历
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for(FileStatus status:listStatus){
            System.out.println(status.getPath().getName());
        }
    }

    /**
     * 创建文件夹
     */
    @Test
    public void mkdir() throws IOException {

        fs.mkdirs(new Path("/test"));
    }

    /**
     * 删除文件或文件夹
     */
    @Test
    public void rm() throws IOException {

        // 第二个参数为是否递归删除
        fs.delete(new Path("/test"),true);
    }
}
