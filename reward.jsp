<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<%--<script type="text/javascript" src="jquery-3.5.1.min.js"></script> (弃用)  --%>
<script type="text/javascript">
function test(val){//根据val值修改传给后台op的值
    if(val==1){  //判断参数，Qurry
        var op= document.getElementById("reward_op");
        op.value="Qurry";
         document.form5.action="myservlet";
         document.form5.submit();
    }
    if(val==2){  //Update
        if(form1.id.value==""){
		        alert("请输入id,id不能为空");
		        form1.id.focus();
        }else {
        	 document.getElementById("reward_op").value="Update";
             document.form5.action="myservlet";
             document.form5.submit();
        }
       
    }
    if(val==3){  //Insert
        document.getElementById("reward_op").value="Insert";
        document.form5.action="myservlet";
        document.form5.submit();
    }
    if(val==4){  //Delete
        document.getElementById("reward_op").value="Delete";
        document.form5.action="myservlet";
        document.form5.submit();
    }
}
</script>
<title>部门管理</title>
</head>
<body>
<div class="table" id="reward" style="weight:100%;heght:70%;"><%--表  department类  部门管理 --%>
	<div>
		<table border=1 style="border-collapse:collapse; border: 1px solid black;"><%--table style 应重设 --%>
			<tr>
				<th>序号</th>
				<th>职员号</th>
				<th>姓名</th>
				<th>奖罚状态</th>
				<th>说明</th>
			</tr>
			<c:forEach items="${list}" var="reward"><!--forEach taglib标签-->
				<tr>
					<td>${reward.id }</td>
					<td>${reward.staff_id}</td>
					<td>${reward.name}</td>
					<td>${reward.state}</td>
					<td>${reward.des}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="" method="post" id="form5" name="form5"><!--查询栏-->
		<input type="text" name="table" value="reward" style="display:none;"><!--表的种类-->
		<input id="reward_op" type="text" name="operation" value="Allqurry" style="display:none;"><!--操作类型  -->
		序号：<input type="text" name="id" ><br/>
		职员号：<input type="text" name="staff_id"><br/>
		姓名：<input type="text" name="name"><br/>
		奖罚状态：<input type="text" name="state"><br/>
		说明：<input type="text" name="des"><br/>
		<input type="button" value="查询" onclick="test(1)"/>
		<input type="button" value="修改" onclick="test(2)"/>
		<input type="button" value="添加" onclick="test(3)"/>
		<input type="button" value="删除" onclick="test(4)"/>
	</form>
</div>
</body>
</html>
