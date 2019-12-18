package cn.commdata.cleardatabase.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author libing.niu
 * @version 1.0
 * @classname: IClearDao
 * @since 2019/12/17 19:20
 */
@Mapper
public interface IClearDao {


    @Delete("<script> delete from unique_validate "
            + "where second_level_id in "
            + "<foreach collection=\"ids\" item=\"id\" separator=\",\" open=\"(\" close=\")\" >"
            + "#{id}"
            + "</foreach>"
            + "</script>")
    int deleteUnique(@Param("ids") List<Long> ids);
}
