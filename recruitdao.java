package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entire.*;
import conn.*;

public class recruitdao {

	public List<recruit> Qurry(int id,String name,String sex,String bir,String adr,String tel,String edu,String des,int state){
		List<recruit> lstpost=new ArrayList<recruit>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from recruit where ";
		String strAND=" and ";
		Boolean And_add=false;//该位判断是否添加为下一个"列=xxx"前添加add,亦可判断qurry语句的正常
		if(id>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"id="+id;
			And_add=true;
		}
		if(null!=name)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"name='"+name+"'";
			And_add=true;
		}
		if(null!=sex)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"sex='"+sex+"'";
			And_add=true;
		}
		if(null!=bir)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"bir='"+bir+"'";
			And_add=true;
		}
		if(null!=adr)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"adr='"+adr+"'";
			And_add=true;
		}
		if(null!=tel)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"tel='"+tel+"'";
			And_add=true;
		}
		if(null!=edu)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"edu='"+edu+"'";
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"des='"+des+"'";
			And_add=true;
		}
		if(state>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"state="+state;
			And_add=true;
		}
		strSQL=strSQL+";";
		System.out.println(strSQL);
		if(And_add)
		{
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				recruit cls=new recruit();
				cls.setId(rs.getInt("id"));
				cls.setName(rs.getString("name"));
				cls.setSex(rs.getString("sex"));
				cls.setBir(rs.getString("bir"));
				cls.setAdr(rs.getString("adr"));
				cls.setTel(rs.getString("tel"));
				cls.setSex(rs.getString("sex"));
				cls.setEdu(rs.getString("edu"));
				cls.setDes(rs.getString("des"));
				cls.setState(rs.getInt("state"));
				lstpost.add(cls);
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
	public List<recruit> Allqurry(){
		List<recruit> lstpost=new ArrayList<recruit>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from recruit;";
		System.out.println(strSQL);
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				recruit cls=new recruit();
				cls.setId(rs.getInt("id"));
				cls.setName(rs.getString("name"));
				cls.setSex(rs.getString("sex"));
				cls.setBir(rs.getString("bir"));
				cls.setAdr(rs.getString("adr"));
				cls.setTel(rs.getString("tel"));
				cls.setSex(rs.getString("sex"));
				cls.setEdu(rs.getString("edu"));
				cls.setDes(rs.getString("des"));
				cls.setState(rs.getInt("state"));
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
	public int Update(int id,String name,String sex,String bir,String adr,String tel,String edu,String des,int state){
		
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="update ";//                   编写sql update语句
		String table="recruit ";
		strSQL=strSQL+table;
		boolean flag=false;		//添加flag位对异常输入做判断
		if(null!=name) {
			strSQL=strSQL+"set "+"name='"+name+"' ";
			flag=true;
		}
		if(null!=sex) {
			strSQL=strSQL+"set "+"sex='"+sex+"' ";
			flag=true;
		}
		if(null!=bir) {
			strSQL=strSQL+"set "+"bir='"+bir+"' ";
			flag=true;
		}
		if(null!=adr) {
			strSQL=strSQL+"set "+"adr='"+adr+"' ";
			flag=true;
		}
		if(null!=tel) {
			strSQL=strSQL+"set "+"tel='"+tel+"' ";
			flag=true;
		}
		if(null!=edu) {
			strSQL=strSQL+"set "+"edu='"+edu+"' ";
			flag=true;
		}
		if(null!=des) {
			strSQL=strSQL+"set "+"desr='"+des+"' ";
			flag=true;
		}
		if(state>0) {
			strSQL=strSQL+"set "+"state="+state+" ";
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
	public int Insert(int id,String name,String sex,String bir,String adr,String tel,String edu,String des,int state){
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="insert into ";//                   编写sql insert语句
		String table="recruit ";
		boolean flag=true;
		if(id<=0)
			flag=false;
		strSQL=strSQL+table+"values (";
		strSQL=strSQL+id;
		strSQL=strSQL+",'"+name+"'";
		strSQL=strSQL+",'"+sex+"'";
		strSQL=strSQL+",'"+bir+"'";
		strSQL=strSQL+",'"+adr+"'";
		strSQL=strSQL+",'"+tel+"'";
		strSQL=strSQL+",'"+edu+"'";
		strSQL=strSQL+",'"+des+"'";
		strSQL=strSQL+","+state;
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
	public int Delete(int id,String name,String sex,String bir,String adr,String tel,String edu,String des,int state){
		DB_Conn dbconn=new DB_Conn();
		int count=0;
		String strSQL="Delete from recruit where ";
		String strAND=" and ";
		Boolean And_add=false;//该位判断是否添加为下一个"列=xxx"前添加add,亦可判断qurry语句的正常
		if(id>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"id="+id;
			And_add=true;
		}
		if(null!=name)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"name='"+name+"'";
			And_add=true;
		}
		if(null!=sex)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"sex='"+sex+"'";
			And_add=true;
		}
		if(null!=bir)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"bir='"+bir+"'";
			And_add=true;
		}
		if(null!=adr)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"adr='"+adr+"'";
			And_add=true;
		}
		if(null!=tel)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"tel='"+tel+"'";
			And_add=true;
		}
		if(null!=edu)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"edu='"+edu+"'";
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"des='"+des+"'";
			And_add=true;
		}
		if(state>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"state="+state;
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
