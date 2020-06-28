package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entire.*;
import conn.*;
public class managerdao {
	
	public List<manager> Qurry(int id,int staff_id,String name,String passwd,String power){
		List<manager> lstpost=new ArrayList<manager>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from manager where ";
		String strAND=" and ";
		Boolean And_add=false;
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
		if(null!=passwd)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"passwd='"+passwd+"'";
			And_add=true;
		}
		if(null!=power) {	
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"power='"+power+"'";
			And_add=true;
		}
		strSQL=strSQL+";";
		System.out.println(strSQL);
		if(And_add)
		{
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				manager cls=new manager();
				cls.setId(rs.getInt("id"));
				cls.setStaff_id(rs.getInt("staff_id"));
				cls.setName(rs.getString("name"));
				cls.setPasswd(rs.getString("passwd"));
				cls.setPower(rs.getString("power"));
				lstpost.add(cls);
			}
			dbconn.disConn();
			return lstpost;
		} catch(Exception e){
			e.printStackTrace();
			dbconn.disConn();
			return null;
		}
		}else
			System.out.println("查询语句异常");//test输出警告
			return null;
	}	
	public List<manager> Allqurry(){
		List<manager> lstpost=new ArrayList<manager>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from manager;";
		System.out.println(strSQL);
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				manager cls=new manager();
				cls.setId(rs.getInt("id"));
				cls.setStaff_id(rs.getInt("staff_id"));
				cls.setName(rs.getString("name"));
				cls.setPasswd(rs.getString("passwd"));
				cls.setPower(rs.getString("power"));
				lstpost.add(cls);
			}
			dbconn.disConn();
			return lstpost;
		} catch(Exception e){
			e.printStackTrace();
			dbconn.disConn();
			return null;
		}
	}
	public int Update(int id,int staff_id,String name,String passwd,String power){
		
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="update ";//                   编写sql update语句
		String table="manager ";
		strSQL=strSQL+table;
		if(staff_id>0)
			strSQL=strSQL+"set "+"staff_id="+staff_id+" ";
		if(null!=name)
			strSQL=strSQL+"set "+"name='"+name+"' ";
		if(null!=passwd)
			strSQL=strSQL+"set "+"passwd='"+passwd+"' ";
		if(null!=power)
			strSQL=strSQL+"set "+"power='"+power+"' ";
		strSQL=strSQL+"where id="+id+";";
		System.out.println(strSQL);
		try{
			count=dbconn.eUpdate(strSQL);
		} catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public int Insert(int id,int staff_id,String name,String passwd,String power){
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="insert into ";//                   编写sql insert语句
		String table="manager ";
		strSQL=strSQL+table+"values (";
		strSQL=strSQL+id;
		strSQL=strSQL+","+staff_id;
		strSQL=strSQL+",'"+name+"'";
		strSQL=strSQL+",'"+passwd+"'";
		strSQL=strSQL+",'"+power+"'";
		strSQL=strSQL+");";
		System.out.println(strSQL);
		try{
			count=dbconn.eUpdate(strSQL);
		} catch(Exception e){
			e.printStackTrace();
		}
		dbconn.disConn();
		return count;
	}
	public int Delete(int id,int staff_id,String name,String passwd,String power){
		DB_Conn dbconn=new DB_Conn();
		int count=0;
		String strSQL="Delete from department where ";
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
		if(null!=passwd)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"passwd='"+passwd+"'";
			And_add=true;
		}
		if(null!=power)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"power='"+power+"'";
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
