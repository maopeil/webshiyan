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
        var op= document.getElementById("staff_op");
        op.value="Qurry";
         document.form2.action="myservlet";
         document.form2.submit();
    }
    if(val==2){  //Update
        if(form1.id.value==""){
		        alert("请输入id,id不能为空");
		        form1.id.focus();
        }else {
        	 document.getElementById("staff_op").value="Update";
             document.form2.action="myservlet";
             document.form2.submit();
        }
       
    }
    if(val==3){  //Insert
        document.getElementById("staff_op").value="Insert";
        document.form2.action="myservlet";
        document.form2.submit();
    }
    if(val==4){  //Delete
        document.getElementById("staff_op").value="Delete";
        document.form2.action="myservlet";
        document.form2.submit();
    }
}
</script>
<title>部门管理</title>
</head>
<body>
<div class="table" id="staff" style="weight:100%;heght:70%;"><%--表  department类  部门管理 --%>
	<div>
		<table border=1 style="border-collapse:collapse; border: 1px solid black;"><%--table style 应重设 --%>
			<tr>
				<th>员工号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>家庭地址</th>
				<th>电话</th>
				<th>职位</th>
				<th>所在部门</th>
				<th>薪资</th>
				<th>简介</th>
			</tr>
			<c:forEach items="${list}" var="staff"><!--forEach taglib标签-->
				<tr>
					<td>${staff.staff_id }</td>
					<td>${staff.name}</td>
					<td>${staff.sex}</td>
					<td>${staff.bir}</td>
					<td>${staff.adr}</td>
					<td>${staff.tel}</td>
					<td>${staff.pos}</td>
					<td>${staff.dep}</td>
					<td>${staff.wage}</td>
					<td>${staff.des}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="" method="post" id="form2" name="form2"><!--查询栏-->
		<input type="text" name="table" value="staff" style="display:none;"><!--表的种类-->
		<input id="staff_op" type="text" name="operation" value="Allqurry" style="display:none;"><!--操作类型  -->
		员工号：<input type="text" name="staff_id" ><br/>
		姓名：<input type="text" name="name"><br/>
		性别：<input type="text" name="sex"><br/>
		出生日期：<input type="text" name="bir"><br/>
		家庭地址：<input type="text" name="adr"><br/>
		电话：<input type="text" name="tel"><br/>
		职位：<input type="text" name="pos"><br/>
		所在部门：<input type="text" name="dep"><br/>
		薪资：<input type="text" name="wage"><br/>
		简介：<input type="text" name="des"><br/>
		<input type="button" value="查询" onclick="test(1)"/>
		<input type="button" value="修改" onclick="test(2)"/>
		<input type="button" value="添加" onclick="test(3)"/>
		<input type="button" value="删除" onclick="test(4)"/>
	</form>
</div>
</body>
</html>
