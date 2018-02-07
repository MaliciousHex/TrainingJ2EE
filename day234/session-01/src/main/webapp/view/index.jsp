<%@page import="java.util.List"%>
<%@page import="com.bukulapuk.test.model.User"%>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Harry Ermawan</title> 
    <style>
		.ajax-load{
            background: #e1e1e1;
            padding: 10px 0px;
            width: 100%;
        }
	   
	</style>
  </head>
    
  <body> 
  
  <div class="ajax-load text-center" style="display:none">

  <p><img src="http://demo.itsolutionstuff.com/plugin/loader.gif">Loading More post</p>

</div>

<div id="main-content">

  <% for(User user : (List<User>)request.getAttribute("users")) {%>
				<div class="data-user">
					<span class="user-id" id="<%= user.getId() %>"><%= user.getId() %></span>
					<span><%= user.getName() %></span>
					<span><%= user.getEmail() %></span>
					<span> <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean convallis eu tortor ut varius. Integer elit eros, sodales quis sem non, sollicitudin gravida lorem. Praesent porttitor congue nunc, a egestas justo sodales et. Suspendisse non mauris ut metus facilisis congue vitae sit amet mi. Vivamus gravida massa sit amet orci imperdiet, a accumsan orci placerat. Quisque auctor tortor ut lorem volutpat, ac lobortis nisi interdum. Aliquam porta, nulla suscipit iaculis iaculis, mi leo scelerisque nunc, ac egestas lectus quam ut elit. Nunc at felis ut leo dignissim sagittis nec consequat ante. Curabitur ut libero non purus semper eleifend. Ut vel risus non libero tempus tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ac mauris sed justo pretium ultricies. Aliquam erat volutpat. Nulla ut quam id justo bibendum sodales. Ut cursus augue libero, id ultrices urna molestie et. Praesent bibendum erat nec neque facilisis, at dapibus tellus luctus. </p>
  			 		</span>
			
				</div>
	<%} %>
			
</div>   
  </body>

 		<script
			  src="http://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
  <script>
  	  var last_id = $(".user-id:last").attr("id");
  	  
      $(window).scroll(function() {

        if($(window).scrollTop() + $(window).height() >= $(document).height()) {
			
        	$.ajax({
				url: 'http://localhost:8080/users/fetch/3/' + last_id,
				type: "get",
				beforeSend: function(){
					$('.ajax-load').show();
				}
			})
			.done(function(data){
				console.log("last_id" + last_id);
				$('.ajax-load').hide();
				console.log(data.length);
				retrieveData(data);
				//$("#data-user").append(data);
			})
			.fail(function(){
				console.log("server not respond call admin");
			});
			

        }

   	 	});
      
      function retrieveData(data){
    	  var htmlString = "";
    		//console.log(data.movies.length);

    		for(var i = 0 ; i < data.length ; i++){
    			console.log("data id" + i + " = " + data[i].id);
    			console.log("name" + data[i].name);
    		}
    			//htmlString += 	"<div class='data-user'>" +
				//				
				//					
				//					
				// <span></span>
				///<span></span>
				///<span> <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean convallis eu tortor ut varius. Integer elit eros, sodales quis sem non, sollicitudin gravida lorem. Praesent porttitor congue nunc, a egestas justo sodales et. Suspendisse non mauris ut metus facilisis congue vitae sit amet mi. Vivamus gravida massa sit amet orci imperdiet, a accumsan orci placerat. Quisque auctor tortor ut lorem volutpat, ac lobortis nisi interdum. Aliquam porta, nulla suscipit iaculis iaculis, mi leo scelerisque nunc, ac egestas lectus quam ut elit. Nunc at felis ut leo dignissim sagittis nec consequat ante. Curabitur ut libero non purus semper eleifend. Ut vel risus non libero tempus tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ac mauris sed justo pretium ultricies. Aliquam erat volutpat. Nulla ut quam id justo bibendum sodales. Ut cursus augue libero, id ultrices urna molestie et. Praesent bibendum erat nec neque facilisis, at dapibus tellus luctus. </p>
			 	//	</span>
		
			//</div>;
    			//console.log(data.movies[i]);
    		
    		//contentjs.insertAdjacentHTML('beforeend',htmlString);
      }
  </script>
  
</html>

