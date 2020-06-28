<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<%--<script type="text/javascript" src="jquery-3.5.1.min.js"></script> (弃用)  --%>
<script type="text/javascript">
function test(val){//根据val值修改传给后台op的值 test
    if(val==1){  //判断参数，Qurry
        var op= document.getElementById("pay_op");
        op.value="Qurry";
         document.form6.action="myservlet";
         document.form6.submit();
    }
    if(val==2){  //Update
        if(form1.id.value==""){
		        alert("请输入id,id不能为空");
		        form1.id.focus();
        }else {
        	 document.getElementById("pay_op").value="Update";
             document.form6.action="myservlet";
             document.form6.submit();
        }
       
    }
    if(val==3){  //Insert
        document.getElementById("pay_op").value="Insert";
        document.form6.action="myservlet";
        document.form6.submit();
    }
    if(val==4){  //Delete
        document.getElementById("pay_op").value="Delete";
        document.form6.action="myservlet";
        document.form6.submit();
    }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门管理</title>
</head>
<body>
<div class="table" id="pay" style="weight:100%;heght:70%;"><%--表  department类  部门管理 --%>
	<div>
		<table border=1 style="border-collapse:collapse; border: 1px solid black;"><%--待改--%>
			<tr>
				<th>序号</th>
				<th>员工号</th>
				<th>姓名</th>
				<th>年月</th>
				<th>基本工资</th>
				<th>奖金</th>
				<th>扣罚金额</th>
				<th>实发金额</th>
			</tr>
			<c:forEach items="${list}" var="pay"><!--forEach taglib标签-->
				<tr>
					<td>${pay.id }</td>
					<td>${pay.staff_id}</td>
					<td>${pay.name}</td>
					<td>${pay.ym}</td>
					<td>${pay.basic}</td>
					<td>${pay.reward}</td>
					<td>${pay.punish}</td>
					<td>${pay.total}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="" method="post" id="form6" name="form6"><!--查询栏-->
		<input type="text" name="table" value="pay" style="display:none;"><!--表的种类-->
		<input id="pay_op" type="text" name="operation" value="Allqurry" style="display:none;"><!--操作类型  -->
		序号：<input type="text" name="id" ><br/>
		员工号：<input type="text" name="staff_id"><br/>
		姓名：<input type="text" name="name"><br/>
		年月：<input type="text" name="ym"><br/>
		基本工资：<input type="text" name="basic"><br/>
		奖金：<input type="text" name="reward"><br/>
		扣罚金额：<input type="text" name="punish"><br/>
		<input type="button" value="查询" onclick="test(1)"/>
		<input type="button" value="修改" onclick="test(2)"/>
		<input type="button" value="添加" onclick="test(3)"/>
		<input type="button" value="删除" onclick="test(4)"/>
	</form>
</div>
</body>
</html>
