<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="login" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
      <div class="modal-header">
             <legend>�α���</legend>
   
       <div class="login-box well">
        <form accept-charset="UTF-8" role="form" method="post" action="login">
     
            <div class="form-group">
                <label for="id"> ���̵�</label>
                <input name="u_id" value='' id="u_id" placeholder="user_id" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="pass">��й�ȣ</label>
                <input name="u_pass" id="u_pass" value='' placeholder="Password" type="password" class="form-control" />
                
            </div>
           
              <div class="checkbox">
      <label><input type="checkbox"> Remember me</label><br><br><br>
      </div>
            <div class="form-group" align="center" >
                <input type="submit" class="btn btn-default btn-login-submit btn-block m-t-md" value="Login" id="logins"/>
            </div>
          
        
     <span class='text-center' ><a href="missingPassword" class="text-sm">��й�ȣ ã��</a></span>&nbsp;&nbsp;&nbsp;	
            <span class='text-center'>
            <a href="MIssingID" class="text-sm">���̵�  ã��</a></span>
           
    
            <hr />
            
            <div class="form-group">
                <a href="" class="btn btn-default btn-block m-t-md"> ȸ������</a>
            </div>
        </form>
      </div>
     
        </div>
      </div>
    </div>
 
     </div>
</body>
</html>