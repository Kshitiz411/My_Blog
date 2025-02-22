
<%@page import="com.project.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.connector.ConnectionProvider"%>
<%@page import="com.project.dao.PostDao"%>
<%@page import="com.project.entities.Message"%>
<%@page import="com.project.entities.User"%>

<%
User user = (User)session.getAttribute("currentUser");
if(user==null){
	response.sendRedirect("Login.jsp");
}

%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">




</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark primary-background">
  <a class="navbar-brand" href="Home.jsp">My Blog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categories
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Programming Language</a>
          <a class="dropdown-item" href="#">Project Implementation</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Data Structure</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contact</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#add-post-modal">Do Post</a>
      </li>
     
    </ul>
    
    <ul class ="navbar-nav mr-right">
    
    <li class="nav-item">
        <a class="nav-link" href="#!" data-toggle="modal" data-target="#profile-modal"><%=user.getNameString() %></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Log out</a>
      </li>
    </ul>
  </div>
</nav>

 <%
                   Message m =(Message)session.getAttribute("message");
                   if(m!=null)
                   {
                   %>
                   
                   <div class="alert <%=m.getCssClass() %>" role="alert">
                    <%= m.getContent()  %>
                   </div>
                 
                   <% 
                   
                   session.removeAttribute("message");
                   }
                   
                   %>
<!-- modal -->

<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header primary-background text-white ">
        <h5 class="modal-title" id="exampleModalLabel">MyBlog</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
          <img src="pics/<%=user.getProfile() %>" class="img-fluid" style="border-radius:50%;max-width:150px;">
        <h5 class="modal-title mt-3" id="exampleModalLabel"><%=user.getNameString() %></h5>
         <!-- details -->
         <div id="profile-details">
         <table class="table">
  
    <tbody>
    <tr>
      <th scope="row">ID</th>
      <td><%=user.getId() %></td>
      
    </tr>
    <tr>
      <th scope="row">Email:</th>
      <td><%=user.getEmail() %></td>
      
    </tr>
    <tr>
      <th scope="row">Gender</th>
      <td><%=user.getGender() %></td>
      
    </tr>
    <tr>
      <th scope="row">Registered on</th>
      <td><%=user.getDateTimestamp().toString() %></td>
      
    </tr>
  </tbody>
</table> 
         </div>
         
         <!-- profile edit -->
     <div id="profile-edit" style="display:none;">
      
      <h3 class ="mt-2">Please Edit Carefully </h3>
      <form action="EditServlet" method="post" enctype="multipart/form-data">
       <table class="table">
         <tr> 
           <td>ID:</td>
           <td><%=user.getId() %></td>
         </tr>
         <tr>
           <td>Email:</td>
           <td><input type="email" class="form-control" name="user_email" value="<%=user.getEmail() %>"></td>
         </tr>
       <tr>
           <td>Name:</td>
           <td><input type="text" class="form-control" name="user_name" value="<%=user.getNameString() %>"></td>
         </tr>
         <tr>
           <td>Password:</td>
           <td><input type="password" class="form-control" name="user_password" value="<%=user.getPassword() %>"></td>
         </tr>
         <tr>
           <td>Gender:</td>
           <td><%=user.getGender().toUpperCase() %></td>
         </tr>
         
         <tr>
           <td>New Profile:</td>
           <td>
             <input type="file" name="image" class="form-control">
           </td>
         </tr>
         
       </table>
        <div class = "conntainer">
        <button type="submit" class="btn btn-outline-primary">Save </button>
        
        </div>
       
      </form>
     
     </div>
         
         
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button id="edit-profile-button" type="button" class="btn btn-primary">EDIT</button>
      </div>
    </div>
  </div>
</div>


<!-- end of modal -->

<!-- add postmodal -->

<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="add-post-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Provide the post details.. </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form  id="add-post-form" action="AddPostServlet" method="post">
      
      <div>
        <select class="form-control" name="cid">
        
       <option selected disabled>---Selected Category</option>
       <%
       PostDao postd = new PostDao(ConnectionProvider.getConnection());
       ArrayList<Category> list =postd.getAllCategories();
       for(Category c:list)
       {
       %>
       <option value="<%=c.getCid()  %>"> <%=c.getName() %></option>
        
       <%
       }
       %>
       
       </select>
      
      </div>
      
      
      <div class="form-group">
        <input name = "pTitle"type="text" placeholder="Enter post Tittle" class="form-control"/>
      </div>
      <div class="form-group">
        <textarea name ="pContent"class="form-control" style ="height: 100px;"placeholder ="Enter your content"></textarea>
      </div>
      
      <div class="form-group">
        <textarea name ="pCode" class="form-control" style ="height: 100px;"placeholder ="Enter your program (if any )"></textarea>
      </div>
      
      <div class="form-group">
      <label>Select your pic..</label>
      <br>
      <input type = "file" name ="pic">
      </div>
      
      <div class="container text-center">
      
      <button type="submit" class="btn btn-outline-primary">Post</button>
      
      </div>
      
      </form>
        
      </div>
      
    </div>
  </div>
</div>

<!-- end post modal -->
 <!-- javascript -->
   
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src = "js/Script.js" type="text/javascript"></script>
 
 <script >
    $(document).ready(function(){
    	
    	let editStatus = false;
       $('#edit-profile-button').click(function(){
  //  	   alert("button clicked")
  
        if(editStatus==false)
        	{
        	 $("#profile-details").hide()
        	  
             $("#profile-edit").show();
        	 editStatus = true;
        	 $(this).text("Back")
        	 
        	}else
        		{
        		 $("#profile-details").show()
        		  
                 $("#profile-edit").hide();
        		 editStatus = false;
        		 $(this).text("Edit")
        		}
       })
       
    });
 
 </script>
 
 <!-- now add post js -->
 
 <script>
  $(document).ready(function(e){
	  
	  //alert("loaded..")
	  $("#add-post-form").on("submit",function(event){
		  
		  //this code gets called when form is submitted..
		  event.preventDefault();
		  console.log("you have clicked on submit..")
		  let form=new FormData(this);
		  //now requesting to server
		  $.ajax({
			  url:"AddPostServlet",
			  type: 'POST',
			  data:form,
			  success:function(data,textStatus,jqXHR){
				  //success
				  console.log(data);
			  },
			  error:function(jqXHR,textStatus,errorThrown){
				  //error
			  },
			  processData:false,
			  contentType:false
		  })
		  })
	  })
 
 </script>
 
</body>
</html>