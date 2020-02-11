package com.kipa.test.service.sftp;

import com.kipa.base.BasicTestNGSpringContextTests;
import com.kipa.common.DataConstant;
import com.kipa.sftp.SftpHelper;
import com.kipa.test.utils.PrintUtils;
import org.testng.annotations.Test;

import java.util.List;

/**
 * sftpUtils工具测试类, 注意：sftp只会读application.properties文件中的sftp配置，不会随着框架切换环境的配置文件去读对应文件的配置
 */
public class SftpUtilsTest extends BasicTestNGSpringContextTests {

    private static final String FILE = DataConstant.BASE_PATH + "data/file/PI1906250002_kipa_1.txt";
    private static final String UPLOAD_PATH = "/kipa/hello/increment/20190612/";

    @Test
    public void test() {
        SftpHelper.upload(FILE, UPLOAD_PATH, "PI1906250002_kipa_1.txt");
    }

    @Test
    public void test1() {
        String filePath = DataConstant.BASE_PATH + "data/file/";
        SftpHelper.download(UPLOAD_PATH,filePath);
    }

    @Test
    public void test2() {
        boolean remoteExist = SftpHelper.isRemoteExist(UPLOAD_PATH + "PI1906250002_kipa_1.txt");
        PrintUtils.println(remoteExist);
    }

    @Test
    public void test3() {
        List<String> list = SftpHelper.listRemoteFile(UPLOAD_PATH);
        PrintUtils.println(list);
    }

    @Test
    public void test5() {
      SftpHelper.batchDownload(UPLOAD_PATH, DataConstant.BASE_PATH+ "data\\");
    }

    @Test
    public void test6() {
        SftpHelper.download("test",UPLOAD_PATH, DataConstant.BASE_PATH+ "data\\");
    }
}
