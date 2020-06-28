package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entire.*;
import conn.*;

public class departmentdao {
	
	public List<department> Qurry(int id,String dep,String des){
		List<department> lstpost=new ArrayList<department>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from department where ";
		String strAND=" and ";
		Boolean And_add=false;//该位判断是否添加为下一个"列=xxx"前添加add,亦可判断qurry语句的正常
		if(id>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"id="+id;
			And_add=true;
		}
		if(null!=dep)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"dep='"+dep+"' ";
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"des='"+des+"' ";
			And_add=true;
		}
		strSQL=strSQL+";";
		System.out.println(strSQL);//test输出SQL语句
		if(And_add)
		{
			ResultSet rs=dbconn.eQuery(strSQL);
			try{
				while(rs.next()){
					department depart=new department();
					depart.setId(rs.getInt("id"));
					depart.setDep(rs.getString("dep"));
					depart.setDes(rs.getString("des"));
					lstpost.add(depart);
				}
				return lstpost;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				dbconn.disConn();
			}
		}else
			System.out.println("查询语句异常");//test输出警告
			return null;
	}	
	public List<department> Allqurry(){
		List<department> lstpost=new ArrayList<department>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from department;";
		System.out.println(strSQL);//test
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				department depart=new department();
				depart.setId(rs.getInt("id"));
				depart.setDep(rs.getString("dep"));
				depart.setDes(rs.getString("des"));
				lstpost.add(depart);
			}
			return lstpost;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbconn.disConn();
		}
	}
	public int Update(int id,String dep,String des){//该方法要求必须输入id,即id项非null,且id>0
		
		DB_Conn dbconn=new DB_Conn();
		int count = 0;	
		String strSQL="update ";//                   编写sql update语句
		String table="department ";
		strSQL=strSQL+table;
		boolean flag=false;		//添加flag位对异常输入做判断
		if(null!=dep) {
			strSQL=strSQL+"set "+"dep='"+dep+"' ";
			flag=true;
		}
		if(null!=des) {
			strSQL=strSQL+"set "+"des='"+des+"' ";
			flag=true;
		}
		if(id<=0)
			flag=false;
		strSQL=strSQL+"where id="+id+";";
		System.out.println(strSQL);//test输出SQL语句
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
	public int Insert(int id,String dep,String des){
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="insert into ";//                   编写sql insert语句
		String table="department ";
		boolean flag=true;
		if(id<=0)
			flag=false;
		strSQL=strSQL+table+"values (";
		strSQL=strSQL+id;
		strSQL=strSQL+",'"+dep+"'";
		strSQL=strSQL+",'"+des+"'";
		strSQL=strSQL+");";
		System.out.println(strSQL);//test输出SQL语句
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
	public int Delete(int id,String dep,String des){
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
		if(null!=dep)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"dep='"+dep+"' ";
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"des='"+des+"' ";
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
