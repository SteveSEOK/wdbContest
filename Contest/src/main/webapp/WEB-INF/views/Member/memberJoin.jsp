<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="insertmember" method="post">

���̵�<input type="text" name="id">
<br>
��й�ȣ<input type="text" name="pass">

<br>
�ּ�<input type="text" name="address">
<br>
������<input type="text" name="hp	">
<br>
�������<input type="date" name="birthyear">
<br>
�̸���<input type="text" name="email">
<br>
����<select name="major">
<option value="manage">����
<option value="video">������
<option value="document">����
<option value="design">������
<option value="marketting">������

</select>
<br>
���<select name="grade">
<option value="member">������
<option value="e-member">������


</select>
<br>
<input type="submit" value="�����ۼ�">
<input type="reset" value="�ʱ�ȭ">
</form> 
</body>
</html>