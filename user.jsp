<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css" >
	.hidden1{
		display:none;
	
	}
	#OK{
		display:none;
	
	}

</style>
<%--<script type="text/javascript" src="jquery-3.5.1.min.js"></script> (弃用)  --%>
<script type="text/javascript">
function test(val){//根据val值修改传给后台op的值
    if(val==1){  //判断参数，Qurry
        var op= document.getElementById("reward_op");
        op.value="Qurry";
         document.form8.action="myservlet";
         document.form8.submit();
    }
    if(val==2){  //Update
    	var list=document.getElementsByClassName("hidden1");
    	for(var i=0;i<list.length;i++)
    		list[i].style.display="block";
        document.getElementById("user_op").value="Update";
        document.getElementById("user_passwd").style.display="none";
        document.getElementById("OK").style.display="block";
        }
       
    }
    if(val==3){  //Insert
    	var list=document.getElementsByClassName("hidden1");
    	for(var i=0;i<list.length;i++)
    		list[i].style.display="none";
        document.getElementById("user_op").value="new_passwd";
        document.getElementById("user_passwd").style.display="block";
        document.getElementById("OK").style.display="block";
    }
    if(val==4){  //Delete
        document.form8.action="myservlet";
        document.form8.submit();
    }
}
</script>
<title>部门管理</title>
</head>
<body>
<div class="table" id="user" style="weight:100%;heght:70%;"><%--表  department类  部门管理 --%>
	
	<form action="" method="post" id="form8" name="form8"><!--查询栏-->
		<input type="text" name="table" value="user" style="display:none;"><!--表的种类-->
		<input id="user_op" type="text" name="operation" value="Allqurry" style="display:none;"><!--操作类型  -->
		<div id="user_passwd">重设登录密码：<input type="text" name="passwd"><br/></div>
		<div>
			<input type="button" value="查询" onclick="test(1)"/>
			<input type="button" value="设置个人信息" onclick="test(2)"/>
			<input type="button" value="重设密码" onclick="test(3)"/>
			<input id="OK" type="button" value="确认输入信息" onclick="test(4)"/>
		</div>
	</form>
</div>
</body>
</html>
