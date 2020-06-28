package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entire.*;
import conn.*;

public class staff_dao {
	
	public List<staff> Qurry(int staff_id,String name,String sex,String bir,String adr,String tel,String pos,String dep,String wage,String des){
		List<staff> lstpost=new ArrayList<staff>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from staff where ";
		String strAND=" and ";
		Boolean And_add=false;//该位判断是否添加为下一个"列=xxx"前添加add,亦可判断qurry语句的正常
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
		if(null!=pos)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"pos='"+pos+"'";
			And_add=true;
		}
		if(null!=dep)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"dep='"+dep+"'";
			And_add=true;
		}
		if(null!=wage)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"wage='"+wage+"'";
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"des='"+des+"'";
			And_add=true;
		}
		strSQL=strSQL+";";
		if(And_add)
		{
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				staff Sta=new staff();
				Sta.setStaff_id(rs.getInt("staff_id"));
				Sta.setName(rs.getString("name"));
				Sta.setSex(rs.getString("sex"));
				Sta.setBir(rs.getString("bir"));
				Sta.setAdr(rs.getString("adr"));
				Sta.setTel(rs.getString("tel"));
				Sta.setPos(rs.getString("pos"));
				Sta.setDep(rs.getString("dep"));
				Sta.setWage(rs.getString("wage"));
				Sta.setDes(rs.getString("des"));
				lstpost.add(Sta);
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
	public List<staff> Allqurry(){
		List<staff> lstpost=new ArrayList<staff>();
		DB_Conn dbconn=new DB_Conn();
		String strSQL="select * from staff";
		ResultSet rs=dbconn.eQuery(strSQL);
		try{
			while(rs.next()){
				staff Sta=new staff();
				Sta.setStaff_id(rs.getInt("staff_id"));
				Sta.setName(rs.getString("name"));
				Sta.setSex(rs.getString("sex"));
				Sta.setBir(rs.getString("bir"));
				Sta.setAdr(rs.getString("adr"));
				Sta.setTel(rs.getString("tel"));
				Sta.setPos(rs.getString("pos"));
				Sta.setDep(rs.getString("dep"));
				Sta.setWage(rs.getString("wage"));
				Sta.setDes(rs.getString("des"));
				lstpost.add(Sta);
			}
			return lstpost;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			dbconn.disConn();
		}
	}
	public int Update(int staff_id,String name,String sex,String bir,String adr,String tel,String pos,String dep,String wage,String des){
		
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="update ";//                   编写sql update语句
		String table="staff ";
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
		if(null!=pos) {
			strSQL=strSQL+"set "+"pos='"+pos+"' ";
			flag=true;
		}
		if(null!=dep) {
			strSQL=strSQL+"set "+"dep='"+dep+"' ";
			flag=true;
		}
		if(null!=wage) {
			strSQL=strSQL+"set "+"wage='"+wage+"' ";
			flag=true;
		}
		if(null!=des) {
			strSQL=strSQL+"set "+"des='"+des+"' ";
			flag=true;
		}
		if(staff_id<=0)
			flag=false;
		strSQL=strSQL+"where staff_id="+staff_id+";";
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
	public int Insert(int staff_id,String name,String sex,String bir,String adr,String tel,String pos,String dep,String wage,String des){
		DB_Conn dbconn=new DB_Conn();
		int count = 0;
		String strSQL="insert into ";//                   编写sql insert语句
		String table="staff ";
		boolean flag=true;
		if(staff_id<=0)
			flag=false;
		strSQL=strSQL+table+"values (";
		strSQL=strSQL+staff_id;
		strSQL=strSQL+",'"+name+"'";
		strSQL=strSQL+",'"+sex+"'";
		strSQL=strSQL+",'"+bir+"'";
		strSQL=strSQL+",'"+adr+"'";
		strSQL=strSQL+",'"+tel+"'";
		strSQL=strSQL+",'"+pos+"'";
		strSQL=strSQL+",'"+dep+"'";
		strSQL=strSQL+",'"+wage+"'";
		strSQL=strSQL+",'"+des+"'";
		strSQL=strSQL+");";
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
	public int Delete(int staff_id,String name,String sex,String bir,String adr,String tel,String pos,String dep,String wage,String des){
		DB_Conn dbconn=new DB_Conn();
		int count=0;
		String strSQL="delete * from staff where ";
		String strAND=" and ";
		Boolean And_add=false;//该位判断是否添加为下一个"列=xxx"前添加add,亦可判断qurry语句的正常
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
		if(null!=pos)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"pos='"+pos+"'";
			And_add=true;
		}
		if(null!=dep)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"dep='"+dep+"'";
			And_add=true;
		}
		if(null!=wage)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"wage='"+wage+"'";
			And_add=true;
		}
		if(null!=des)	{
			if(And_add)
				strSQL+=strAND;
			strSQL=strSQL+"des='"+des+"'";
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