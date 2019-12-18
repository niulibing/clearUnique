package cn.commdata.cleardatabase.service;

import cn.commdata.cleardatabase.common.BaseVO;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author libing.niu
 * @version 1.0
 * @classname: IClearUniqueService
 * @since 2019/12/18 10:01
 */
public interface IClearUniqueService {


    /**
     * 清除数据库唯一字段
     * @param jsonFile json文件
     * @return BaseVO
     */
   BaseVO<String> clearUnique(MultipartFile jsonFile);
}
