<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*" %>
<%@page import="java.text.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
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
		#nav span{
			margin-left:1%;
			margin-right:1%;
		}
		.table{
			display:none;
			weight:100%;
			height:70%;
			background: #87CEFA;
		}
</style>

<script type="text/javascript">
tbname="${table}";
function doclick(val){//根据val值修改
	var tbname="${table}";
    if(val==1){  //判断参数dep
    	var list=document.getElementsByClassName("table");
    	for(var i=0;i<list.length;i++)
    		list[i].style.display="none";
    	 document.getElementById("dep").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="dep";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }   
    if(val==2){  //判断参数staff
    	//var list=document.getElementsByClassName("table");
    	//for(var i=0;i<list.length;i++)
    	//	list[i].style.display="none";
    	//document.getElementById("table2").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="staff";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
    if(val==3){  //判断参数recruit
    	//var list=document.getElementsByClassName("table");
    	//for(var i=0;i<list.length;i++)
    	//	list[i].style.display="none";
    	//document.getElementById("table3").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="recruit";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
    if(val==4){  //判断参数train
    	//var list=document.getElementsByClassName("table");
    	//for(var i=0;i<list.length;i++)
    	//	list[i].style.display="none";
    	//document.getElementById("table4").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="train";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
    if(val==5){  //判断参数reward
    	//var list=document.getElementsByClassName("table");
    	//for(var i=0;i<list.length;i++)
    	//	list[i].style.display="none";
    	//document.getElementById("table5").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="reward";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
    if(val==6){  //判断参数pay
    	//var list=document.getElementsByClassName("table");
    	//for(var i=0;i<list.length;i++)
    	//	list[i].style.display="none";
    	//document.getElementById("table6").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="pay";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
    if(val==7){  //判断参数manager
    	//var list=document.getElementsByClassName("table");
    	//for(var i=0;i<list.length;i++)
    	//	list[i].style.display="none";
    	//document.getElementById("table7").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="manager";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
    if(val==8){  //判断参数user    -->manager &&staff
    	//var list=document.getElementsByClassName("table");
    	//for(var i=0;i<list.length;i++)
    	//	list[i].style.display="none";
    	//document.getElementById("nav_op").style.display="block";
    	//
    	var op= document.getElementById("nav_table").value="user";
        var op= document.getElementById("nav_op");
        op.value="Allqurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
}
function test(val){//根据val值修改传给后台op的值
    if(val==1){  //判断参数，Qurry
        var op= document.getElementById("dep_op");
        op.value="Qurry";
         document.form1.action="myservlet";
         document.form1.submit();
    }
    if(val==2){  //Update
        if(form1.id.value==""){
		        alert("请输入id,id不能为空");
		        form1.id.focus();
        }else {
        	 document.getElementById("dep_op").value="Update";
             document.form1.action="myservlet";
             document.form1.submit();
        }
       
    }
    if(val==3){  //Insert
        document.getElementById("dep_op").value="Insert";
        document.form1.action="myservlet";
        document.form1.submit();
    }
    if(val==4){  //Delete
        document.getElementById("dep_op").value="Delete";
        document.form1.action="myservlet";
        document.form1.submit();
    }
}
</script>
</head>
<body onload="document.getElementById("${table}").style.display='block';">
	<div id="nav">
		<a href="javascript:void(0);" onclick="doclick(1)">部门管理</a>
			<span >·</span>
		<a href="javascript:void(0);" onclick="doclick(2)">员工管理</a>
			<span >·</span>
		<a href="javascript:void(0);" onclick="doclick(3)">招聘管理</a>
			<span >·</span>
		<a href="javascript:void(0);" onclick="doclick(4)">培训管理</a>
			<span >·</span>
		<a href="javascript:void(0);" onclick="doclick(5)">奖惩管理</a>
			<span >·</span>
		<a href="javascript:void(0);" onclick="doclick(6)">薪资管理</a>
			<span >·</span>
		<a href="javascript:void(0);" onclick="doclick(7)">系统管理</a>
			<span >·</span>
		<a href="javascript:void(0);" onclick="doclick(8)">用户修改</a>
		<form action="" method="post" id="form2" name="form2">
			<input class="hidden" id="nav_table" type="text" name="table" value="" style="display:none;"/><%--表的种类--%>
			<input class="hidden" id="nav_op" type="text" name="operation" value="Allqurry" style="display:none;"/><%--操作类型 --%>
		</form>
	</div>
	<hr/>
	<%
	   String name=(String)session.getAttribute("my_name");
		int staff_id=(int)session.getAttribute("my_staff_id");
	   Date date=new Date();
	   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:MM");
	    String datetime=df.format(date);
	 %>
	<div id="content"><!--导航栏下面所有的内容-->
		<div id="left" style="float:left;width: 15%;height: 1000px;background: #F8F8FF;"><!--左边框-->
			<div id="user"><!--用户信息栏-->
				<img src="image/01.BMP" alt="员工头像" style="width: 100%;height: 200px; "/><hr>
				用户名：<%=name %><br>
				员工号：<%=staff_id %><br>
				登录时间: <%=datetime %><br><br>
				<div style="text-align:right"><input type="button" value="安全退出" name="exit" onclick="window.location.href('exit.jsp')"/></div>	
			</div>
			<!--分隔框-->
			<hr/><div style="height:20px;background-color:white;"></div><hr/>
			<!--     -->
			
			<div style="display:none;"><!--操作(动态变化，可出现消失)-->
				<div style="text-align:center;"><p>当前可对表格执行操作</p></div>
				<hr/>
				<div style="text-align:center"><a href="#">查询</a></div><hr/>
				<div style="text-align:center;"><a href="#">添加</a></div><hr/>
				<div style="text-align:center;"><a href="#">删除</a></div><hr/>
				<div style="text-align:center;"><a href="#">修改</a></div><hr/>
			</div>
		
		</div>
		
		<!--分割线-->
		 <div  id="line" style="float:left;width: 1px;height: 1000px; background: black;"></div>
		<!--分割线-->

		<div id="right" style="width: 85%;height: 1000px;background: white;">
			<div id="table_name" style="text-align:center;"><p>表格名</p></div><!--表格名（动态改变）--><hr/>				
			
			<%--表  department类  部门管理 --%>
			<div class="table" id="dep" >
				<div style="height=60%;">
					<table border=1 style="border-collapse:collapse; border: 1px solid black;">
						<tr>
							<th>id</th>
							<th>部门</th>
							<th>描述</th>
						</tr>
						<c:forEach items="${list}" var="department"><!--forEach taglib标签-->					
							<tr>
								<td>${department.id }</td>
								<td>${department.dep}</td>
								<td>${department.des}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				
				<div>
					<form action="" method="post" id="form1" name="form1"><!--查询栏-->
						<input class="hidden" type="text" name="table" value="dep" style="display:none;"/><%--表的种类--%>
						<input class="hidden" id="dep_op" type="text" name="operation" value="Allqurry" style="display:none;"/><%--操作类型 --%>
						序号：<input type="text" name="id" ><br/>
						部门：<input type="text" name="dep"><br/>
						描述：<input type="text" name="des"><br/>
						<input type="button" value="查询" onclick="test(1)"/>
						<input type="button" value="修改" onclick="test(2)"/>
						<input type="button" value="添加" onclick="test(3)"/>
						<input type="button" value="删除" onclick="test(4)"/>
					</form>
				</div>
			</div>	
			<div class="table" id="staff" ><%--表  staff类  部门管理 --%>	</div>
			<div class="table" id="recruit" ><%--表  recruit类  部门管理 --%>	</div>
			<div class="table" id="train" ><%--表  train类  部门管理 --%>	</div>
			<div class="table" id="reward" ><%--表  reward类  部门管理 --%>	</div>
			<div class="table" id="pay" ><%--表  pay类  部门管理 --%>	</div>
			<div class="table" id="manager" ><%--表  managert类  部门管理 --%>	</div>
			<div class="table" id="user" ><%--表  staff  managert类  部门管理 --%>			</div>	
		</div>
	</div>
	<hr/>
	<div id="bottom" style="display:none;float:none;width：100%"><!--页脚-->
	<p>www.hello,world.com</p>
	</div>
</body>
</html>
