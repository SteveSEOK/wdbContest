<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
<form action="payment" method="post">
<input type="hidden" value="${reservation.pr_id}" name="pr_id">
��Ҹ�:${reservation.p_name}<br><br>
�����ȣ:${reservation.pr_id}<br>
<br>

������:${sessionScope.u_id}
<br>
<br>
��������:<select name="pay_kind">
<option value="1">üũ ī��</option>
<option value="2">�ſ� ī��</option>
<option value="3">������ü</option>
<option value="4">�޴��� ����</option>
</select>

<br>
<input type="submit" value="����"  onclick="return confirm('�����Ͻðڽ��ϱ�?')"><input type="reset" value="����" >




</form>
</body>
</html>