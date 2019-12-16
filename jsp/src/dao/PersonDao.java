package dao;

import entity.Person;
import util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author songsong
 * @create 2019/12/11 11:22
 */
public class PersonDao {
    //查询所有数据
    public List<Person> queryAll(Integer pageIndex,Integer pageCount){
        String  sql="select * from(select p.*,rownum r from person p)" +
                " where r between ? and ?";
        ResultSet rs= DBUtil.query(sql,(pageIndex-1)*pageCount+1,pageIndex*pageCount);
        List<Person> list=new ArrayList<>();
        try {
            while(rs.next()){
                Integer id=rs.getInt("id");
                String name=rs.getString("name");
                Integer age=rs.getInt("age");
                Person p=new Person(id,name,age);
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //查询总条数
    public int queryCount(){
        String sql="select count(*) from person";
        ResultSet rs=DBUtil.query(sql);
        int result=0;
        try {
            if(rs.next()){
                result=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
