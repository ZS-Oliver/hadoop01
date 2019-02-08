package hadoop.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileInputStream;
import java.io.IOException;

public class HafsUtil {

    /**
     * 上传文件
     */
    public void upload() throws IOException {

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        Path dst = new Path("hdfs://hadoop01:9000/test.txt");

        FSDataOutputStream os = fs.create(dst);

        FileInputStream is = new FileInputStream("d:test.txt");

        IOUtils.copy(is, os);
    }

    /**
     * 下载文件
     */

    /**
     * 查看文件信息
     */

    /**
     * 创建文件夹
     */

    /**
     * 删除文件或文件夹
     */
}
