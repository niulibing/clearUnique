package cn.commdata.cleardatabase.service.impl;

import cn.commdata.cleardatabase.common.BaseVO;
import cn.commdata.cleardatabase.dao.IClearDao;
import cn.commdata.cleardatabase.service.IClearUniqueService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * @author libing.niu
 * @version 1.0
 * @classname: ClearUniqueServiceImpl
 * @since 2019/12/18 10:07
 */
@Service
@Slf4j
public class ClearUniqueServiceImpl implements IClearUniqueService {


    /**
     * clearDao
     */
    @Autowired
    private IClearDao clearDao;

    /**
     * @param jsonFile json文件
     * @return BaseVO
     */
    @Override
    public BaseVO<String> clearUnique(MultipartFile jsonFile) {


        String json = "null";
        try {
            json = readJsonData(jsonFile.getInputStream());
            Object records = JSONObject.parseObject(json).get("RECORDS");
            JSONArray objects = JSONArray.parseArray(JSON.toJSONString(records));
            log.info(String.format("======%s文件总共%s条数据=====", jsonFile.getOriginalFilename(), objects.size()));
            int num = 1;

            List<Long> ids = new ArrayList<>();
            for (Object object : objects) {
                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(object));
                String dataId = (String) JSONObject.parseObject(JSON.toJSONString(jsonObject.get("_id"))).get("$numberLong");

                log.info(String.format("====第【%s】条数据为【%s】==", num, dataId));
                num++;
                ids.add(Long.parseLong(dataId));
            }
            // int i = clearDao.deleteUnique(ids);
            //  System.out.println(String.format("成功删除[%s]行数据", i));


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new BaseVO<String>(BaseVO.SUCCESS_CODE, "操作成功");
    }

    /**
     * 读取json数据
     *
     * @param jsonFileInputStream 文件输入流
     * @return String
     * @throws IOException 异常
     */
    private String readJsonData(InputStream jsonFileInputStream) throws IOException {


        log.info("开始读取文件");
        StringBuffer strbuffer = new StringBuffer();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(jsonFileInputStream, "UTF-8");
            BufferedReader in = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                strbuffer.append(str);  //new String(str,"UTF-8")
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        log.info("读取文件结束");
        return strbuffer.toString();
    }
}
