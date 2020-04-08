package wen.peng;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import wen.peng.Mapper.UserMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        newFUnction();


    }

    private  static  void newFUnction() throws  IOException{
        String resouce = "mybatis-config.xml";
        Reader resourceAsReader = Resources.getResourceAsReader(resouce);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> listUser = mapper.selectList();
        System.out.println(listUser.toString());

        User user = mapper.selectByUserid(2);
        System.out.println(user.toString());


        int Addresult = mapper.insertUser(new User(4,"如意","北大",false));
        System.out.println("插入成功,"+Addresult);
        sqlSession.commit();

        listUser = mapper.selectList();
        System.out.println(listUser.toString());

        int UpdateResult = mapper.updateByUserID(new User(4,"吉祥","清华",true));
        System.out.println("更新成功,"+UpdateResult);
        sqlSession.commit();

        listUser = mapper.selectList();
        System.out.println(listUser.toString());

        int deleteResult = mapper.deleteByUserid(4);
        System.out.println("删除成功,"+deleteResult);
        sqlSession.commit();

        listUser = mapper.selectList();
        System.out.println(listUser.toString());

        Map<String,Object> map = new HashMap();
        map.put("sexp",1);

        mapper.selectUserNumsByprocedure(map);

        Object nums = map.get("nums");
        System.out.println("调用存储过程成功,"+nums);

    }

    private static void oldfunction() throws IOException {
        String resource = "mybatis-config.xml";
        Reader resourceAsReader = Resources.getResourceAsReader(resource);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = sessionFactory.openSession();
        String stateElement = "wen.peng.Mapper.selectList";
        List<User> listUser = sqlSession.selectList(stateElement);
        System.out.println(listUser.toString());
        stateElement = "wen.peng.Mapper.selectByUserid";
        User user = sqlSession.selectOne(stateElement,2);
        System.out.println(user.toString());
        User needAdd = new User(4,"ruyi","中科院",false);
        stateElement = "wen.peng.Mapper.insertUser";
        int addResout = sqlSession.insert(stateElement,needAdd);
        System.out.println("插入成功,"+addResout);
        sqlSession.commit();
        stateElement = "wen.peng.Mapper.selectList";
        listUser = sqlSession.selectList(stateElement);
        System.out.println(listUser.toString());

        stateElement = "wen.peng.Mapper.updateByUserID";
        User needUpdate = new User(4,"jixiang","清华",true);
        int updateResout = sqlSession.update(stateElement,needUpdate);
        sqlSession.commit();
        System.out.println("更新成功,"+updateResout);

        stateElement = "wen.peng.Mapper.selectList";
        listUser = sqlSession.selectList(stateElement);
        System.out.println(listUser.toString());

        stateElement = "wen.peng.Mapper.deleteByUserid";
        int deleteResult = sqlSession.delete(stateElement,4);
        sqlSession.commit();
        System.out.println("删除成功,"+deleteResult);

        stateElement = "wen.peng.Mapper.selectList";
        listUser = sqlSession.selectList(stateElement);
        System.out.println(listUser.toString());
    }

}
