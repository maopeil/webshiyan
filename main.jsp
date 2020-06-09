<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*" %>
<%@page import="java.text.*" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>企业管理系统</title>
<style type="text/css" >
	*{
		margin:0;
		padding:0;
	}
		#nav{	
			margin:0 auto;		
			font-size:12;
			text-align:center;
			dispaly:inline-block;
		}	
		a{
			dispaly:inline-block;
			width:80px;
			height:30px;
			font-size:14px;
			text-align:center;
			line-height:30px;
			text-decoration:none;
			border-bottom:1px solid #ccc; 
		}

		#nav a:hover{
			border:1px solid;
			color:white;
			background-color:gray;
		}
</style>
</head>
<body>
	<div id=nav>
		<a href="#">部门管理</a>
			<span style="margin-left:1%;margin-right:1%;">·</span>
		<a href="#">员工管理</a>
			<span style="margin-left:1%;margin-right:1%;">·</span>
		<a href="#">招聘管理</a>
			<span style="margin-left:1%;margin-right:1%;">·</span>
		<a href="#">培训管理</a>
			<span style="margin-left:1%;margin-right:1%;">·</span>
		<a href="#">奖惩管理</a>
			<span style="margin-left:1%;margin-right:1%;">·</span>
		<a href="#">薪资管理</a>
			<span style="margin-left:1%;margin-right:1%;">·</span>
		<a href="#">系统管理</a>
			<span style="margin-left:1%;margin-right:1%;">·</span>
		<a href="#">用户修改</a>
	</div>
	<hr/>
	<%
	   String name=(String)session.getAttribute("loginname");
	   Date date=new Date();
	   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM");
	    String datetime=df.format(date);
	 %>
	<div id=content>
		<div id=left style="float:left;width: 15%;height: 750px;background: #F8F8FF;">
			<div id=user>
				<img src="01.BMP" alt="员工头像"/ style="width: 100%;height: 200px; "/>
				用户名：<%=name %><br>
				登录时间: <%=datetime %><br><br>
				<div style="text-align:right"><input type="button" value="安全退出" name="exit" onclick="window.location.href('hello.jsp')"/></div>	
			</div>
			<hr/><div style="height:20px;background-color:white;"></div><hr/>
			<!--分隔框-->
			<div style=""><!--操作(动态变化，可出现消失)-->
				<div style="text-align:center;"><p>当前可对表格执行操作</p></div>
				<hr/>
				<div style="text-align:center;"><a href="#">查询</a></div><hr/>
				<div style="text-align:center;"><a href="#">添加</a></div><hr/>
				<div style="text-align:center;"><a href="#">删除</a></div><hr/>
				<div style="text-align:center;"><a href="#">修改</a></div><hr/>
			</div>
		</div>

		 <div  id=line style="float:left;width: 1px;height: 750px; background: black;"></div><!--分割线-->

		<div id=right style="display:none;width: 85%;height: 750px;background: white;">
			<div style="text-align:center;"><p>表格名</p></div><!--表格名（动态改变）-->
			<div style="background: #87CEFA;"> 表格内容</div><!--表格主体(带滚动条)-->
			<div></div><!--查询栏-->
		</div>
	</div>
	<hr/>
	<div id=bottom style="display:none;float:none;width：100%"><!--页脚-->
	<p>www.hello,world.com</p>
	</div>
</body>
</html>