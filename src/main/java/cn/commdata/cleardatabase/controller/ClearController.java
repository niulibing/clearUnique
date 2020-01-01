package cn.commdata.cleardatabase.controller;

import cn.commdata.cleardatabase.common.BaseVO;
import cn.commdata.cleardatabase.service.IClearUniqueService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author libing.niu
 * @version 1.0
 * @classname： ClearController
 * @since 2019/12/17 19:12
 */
@RestController
public class ClearController {

    /**
     * clearUniqueService
     */
    @Autowired
    private IClearUniqueService clearUniqueService;

    /**
     * 清除唯一字段
     * @param jsonFile
     * @return BaseVO<String>
     */
    @ApiOperation("清除唯一字段")
    @DeleteMapping("/unique")
    public BaseVO<String> clearUnique(@ApiParam(value = "json文件", required = true) @RequestParam("file") MultipartFile jsonFile) {

        return clearUniqueService.clearUnique(jsonFile);

    }

}
