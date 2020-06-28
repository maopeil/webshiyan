package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entire.*;
import conn.*;

public class paydao {
	//不能查询，修改total，total值由basic,reward,punish计算得到，total并不实际存储在数据库中
	public List<pay> Qurry(int id,int staff_id,String name,String ym,int basic,int reward,int punish){
		List<pay> lstpost=new ArrayList<pay>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from pay where ";
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
		if(null!=ym)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"ym='"+ym+"'";
			And_add=true;
		}
		if(basic>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"basic="+basic;
			And_add=true;
		}
		if(reward>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"reward="+reward;
			And_add=true;
		}
		if(punish>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"punish="+punish;
			And_add=true;
		}	
		strSQL=strSQL+";";
		System.out.println(strSQL);
		if(And_add)
		{
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				pay cls=new pay();
				cls.setId(rs.getInt("id"));
				cls.setStaff_id(rs.getInt("staff_id"));
				cls.setName(rs.getString("name"));
				cls.setYm(rs.getString("ym"));
				cls.setBasic(rs.getInt("basic"));
				cls.setReward(rs.getInt("reward"));
				cls.setPunish(rs.getInt("punish"));
				cls.setTotal();//调用total的set方法设置值
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
	public List<pay> Allqurry(){
		List<pay> lstpost=new ArrayList<pay>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from pay";
		System.out.println(strSQL);
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				pay cls=new pay();
				cls.setId(rs.getInt("id"));
				cls.setStaff_id(rs.getInt("staff_id"));
				cls.setName(rs.getString("name"));
				cls.setYm(rs.getString("ym"));
				cls.setBasic(rs.getInt("basic"));
				cls.setReward(rs.getInt("reward"));
				cls.setPunish(rs.getInt("punish"));
				cls.setTotal();//调用total的set方法设置值
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
	public int Update(int id,int staff_id,String name,String ym,int basic,int reward,int punish){
		
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="update ";//                   编写sql update语句
		String table="pay ";
		strSQL=strSQL+table;
		boolean flag=false;		//添加flag位对异常输入做判断
		if(staff_id>0) {
			strSQL=strSQL+"set "+"staff_id="+staff_id+" ";
			flag=true;
		}
		if(null!=name) {
			strSQL=strSQL+"set "+"name='"+name+"' ";
			flag=true;
		}
		if(null!=ym) {
			strSQL=strSQL+"set "+"ym='"+ym+"' ";
			flag=true;
		}
		if(basic>=0) {
			strSQL=strSQL+"set "+"basic="+basic+" ";
			flag=true;
		}
		if(reward>=0) {
			strSQL=strSQL+"set "+"reward="+reward+" ";
			flag=true;
		}
		if(punish>=0) {
			strSQL=strSQL+"set "+"punish="+punish+" ";
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
	public int Insert(int id,int staff_id,String name,String ym,int basic,int reward,int punish){
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		boolean flag=true;
		String strSQL="insert into ";//                   编写sql insert语句
		String table="pay ";
		if(id<=0)
			flag=false;
		strSQL=strSQL+table+"values (";
		strSQL=strSQL+id;
		strSQL=strSQL+","+staff_id;
		strSQL=strSQL+",'"+name+"'";
		strSQL=strSQL+","+basic;
		strSQL=strSQL+","+reward;
		strSQL=strSQL+","+punish;
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
	public int Delete(int id,int staff_id,String name,String ym,int basic,int reward,int punish){
		DB_Conn dbconn=new DB_Conn();
		int count=0;
		String strSQL="Delete from pay where ";
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
		if(null!=ym)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"ym='"+ym+"'";
			And_add=true;
		}
		if(basic>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"basic="+basic;
			And_add=true;
		}
		if(reward>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"reward="+reward;
			And_add=true;
		}
		if(punish>0)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"punish="+punish;
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
