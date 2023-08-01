import com.dxz.WyApplication;
import com.mongodb.client.gridfs.GridFSBucket;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.ContextConfiguration;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/11/28(星期五) 18:11
 * request：
 */

@SpringBootTest
@ContextConfiguration(classes = WyApplication.class)
public class GridFSTest {
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Test //上传
    public void test() throws Exception {
        ObjectId fileId = gridFsTemplate.store(Files.newInputStream(Paths.get("D://Administrator/Videos/202303031921.mp4")), "202303031921.mp4");
        System.out.println(fileId.toString());
    }

    @Test //下载视频
    public void test2() throws Exception {
        gridFSBucket.downloadToStream(new ObjectId("64c3a682f4066b74ec21f70d"), Files.newOutputStream(Paths.get("D://Administrator/Videos/2.mp4")));
    }
}