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
        var op= document.getElementById("train_op");
        op.value="Qurry";
         document.form4.action="myservlet";
         document.form4.submit();
    }
    if(val==2){  //Update
        if(form1.id.value==""){
		        alert("请输入id,id不能为空");
		        form1.id.focus();
        }else {
        	 document.getElementById("train_op").value="Update";
             document.form4.action="myservlet";
             document.form4.submit();
        }
       
    }
    if(val==3){  //Insert
        document.getElementById("train_op").value="Insert";
        document.form4.action="myservlet";
        document.form4.submit();
    }
    if(val==4){  //Delete
        document.getElementById("train_op").value="Delete";
        document.form4.action="myservlet";
        document.form4.submit();
    }
}
</script>
<title>培训管理</title>
</head>
<body>
<div class="table" id="train" style="weight:100%;heght:70%;"><%--表  train类  培训管理 --%>
	<div>
		<table border=1 style="border-collapse:collapse; border: 1px solid black;"><%--表格style 应重设 --%>
			<tr>
				<th>序号</th>
				<th>员工号</th>
				<th>姓名</th>
				<th>电话</th>
				<th>培训课程</th>
				<th>考核评价</th>
			</tr>
			<c:forEach items="${list}" var="train"><!--forEach taglib标签-->
				<tr>
					<td>${train.id }</td>
					<td>${train.staff_id}</td>
					<td>${train.name}</td>
					<td>${train.tel}</td>
					<td>${train.course}</td>
					<td>${train.assm}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="" method="post" id="form4" name="form4"><!--查询栏-->
		<input type="text" name="table" value="train" style="display:none;"><!--表的种类-->
		<input id="train_op" type="text" name="operation" value="Allqurry" style="display:none;"><!--操作类型  -->
		序号：<input type="text" name="id" ><br/>
		员工号：<input type="text" name="staff_id"><br/>
		姓名：<input type="text" name="name"><br/>
		电话：<input type="text" name="tel"><br/>
		培训课程：<input type="text" name="course"><br/>
		考核评价：<input type="text" name="assm"><br/>
		<input type="button" value="查询" onclick="test(1)"/>
		<input type="button" value="修改" onclick="test(2)"/>
		<input type="button" value="添加" onclick="test(3)"/>
		<input type="button" value="删除" onclick="test(4)"/>
	</form>
</div>
</body>
</html>
