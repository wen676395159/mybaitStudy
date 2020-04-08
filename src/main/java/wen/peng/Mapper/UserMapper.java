package wen.peng.Mapper;

import wen.peng.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectList();
    User selectByUserid(int UserId);
    int insertUser(User user);
    int updateByUserID(User user);
    int deleteByUserid(int UserId);
    void  selectUserNumsByprocedure(Map<String,Object> map);

}
