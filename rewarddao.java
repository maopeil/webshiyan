package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entire.*;
import conn.*;

public class rewarddao {
	
	public List<reward> Qurry(int id,int staff_id,String name,int state,String des){
		List<reward> lstpost=new ArrayList<reward>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from reward where ";
		String strAND=" and ";
		Boolean And_add=false;//该位判断是否添加为下一个"列=xxx"前添加add,亦可判断qurry语句的正常
		if(id>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"id="+id;
			And_add=true;
		}
		if(staff_id>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"staff_id="+staff_id;
			And_add=true;
		}
		if(null!=name)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"name='"+name+"'";
			And_add=true;
		}
		if(state>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"state="+state;
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"power='"+des+"'";
			And_add=true;
		}
		strSQL=strSQL+";";
		System.out.println(strSQL);
		if(And_add)
		{
			ResultSet rs=dbconn.eQuery(strSQL);
			try{
				while(rs.next()){
					reward cls=new reward();
					cls.setId(rs.getInt("id"));
					cls.setStaff_id(rs.getInt("staff_id"));
					cls.setName(rs.getString("name"));
					cls.setState(rs.getInt("state"));
					cls.setDes(rs.getString("des"));
					lstpost.add(cls);
				}
				return lstpost;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dbconn.disConn();
			}
		}else {
			System.out.println("查询语句异常");//test输出警告
			return null;
		}
	}	
	public List<reward> Allqurry(){
		List<reward> lstpost=new ArrayList<reward>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from reward;";
		System.out.println(strSQL);
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				reward cls=new reward();
				cls.setId(rs.getInt("id"));
				cls.setStaff_id(rs.getInt("staff_id"));
				cls.setName(rs.getString("name"));
				cls.setState(rs.getInt("state"));
				cls.setDes(rs.getString("des"));
				lstpost.add(cls);
			}
			return lstpost;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbconn.disConn();
		}
	}
	public int Update(int id,int staff_id,String name,int state,String des){
		
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="update ";//                   编写sql update语句
		String table="reward ";
		strSQL=strSQL+table;
		boolean flag=false;		//添加flag位对异常输入做判断
		if(staff_id>0) {
			strSQL=strSQL+"set "+"staff_id="+staff_id;
			flag=true;
		}
		if(null!=name) {
			strSQL=strSQL+"set "+"name='"+name+"'";
			flag=true;
		}
		if(state>0) {
			strSQL=strSQL+"set "+"state="+state;
			flag=true;
		}
		if(null!=des) {
			strSQL=strSQL+"set "+"des='"+des+"'";
			flag=true;
		}
		if(id<=0)
			flag=false;
		strSQL=strSQL+"where id="+id+";";
		System.out.println(strSQL);
		try{
			if(flag)
				count=dbconn.eUpdate(strSQL);
			else
				count=-2;
		} catch(Exception e){
			e.printStackTrace();
		}
		dbconn.disConn();
		return count;
	}
	public int Insert(int id,int staff_id,String name,int state,String des){
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="insert into ";//                   编写sql insert语句
		String table="reward ";
		boolean flag=true;
		if(id<=0)
			flag=false;
		strSQL=strSQL+table+"values (";
		strSQL=strSQL+id;
		strSQL=strSQL+","+staff_id;
		strSQL=strSQL+",'"+name+"'";
		strSQL=strSQL+","+state;
		strSQL=strSQL+",'"+des+"'";
		strSQL=strSQL+");";
		System.out.println(strSQL);
		try{
			if(flag)
				count=dbconn.eUpdate(strSQL);
			else
				count=-2;
		} catch(Exception e){
			e.printStackTrace();
		}
		dbconn.disConn();
		return count;
	}
	public int Delete(int id,int staff_id,String name,int state,String des){
		DB_Conn dbconn=new DB_Conn();
		int count=0;
		String strSQL="Delete from reward where ";
		String strAND=" and ";
		Boolean And_add=false;//该位判断是否添加为下一个"列=xxx"前添加add,亦可判断delete语句的正常
		if(id>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"id="+id;
			And_add=true;
		}
		if(staff_id>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"staff_id="+staff_id;
			And_add=true;
		}
		if(null!=name)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"name='"+name+"'";
			And_add=true;
		}
		if(state>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"state="+state;
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"power='"+des+"'";
			And_add=true;
		}
		strSQL=strSQL+";";
		System.out.println(strSQL);//test输出SQL语句
		try{
			if(And_add)
				count=dbconn.eUpdate(strSQL);
			else
				count=-2;
		} catch(Exception e){
			e.printStackTrace();
		}
		dbconn.disConn();
		return count;
	}	
}
