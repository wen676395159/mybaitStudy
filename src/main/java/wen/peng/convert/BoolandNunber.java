package wen.peng.convert;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoolandNunber extends BaseTypeHandler<Boolean> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean o, JdbcType jdbcType) throws SQLException {
        if(o){
            preparedStatement.setInt(i,1);
        }else{
            preparedStatement.setInt(i,0);
        }
    }
    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sexNum = resultSet.getInt(s);
        return  sexNum == 1 ?true:false;
    }
    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sexNum = resultSet.getInt(i);
        return  sexNum == 1 ?true:false;
    }
    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sexNum = callableStatement.getInt(i);
        return  sexNum == 1 ?true:false;
    }
}
