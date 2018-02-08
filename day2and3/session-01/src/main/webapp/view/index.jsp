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

 
			
</div>   
  </body>

 		<script
			  src="http://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
  <script>
	var limit = 5;
	var offset = 0;
	$(window).scroll(function(){
		if($(window).height() + $(window).scrollTop()
			< $(document).height()) return;
		fetch();
	});

	$(document).ready(function(){
		fetch();
	});

	function fetch(){
		$.ajax({
			url: "http://localhost:8080/users/fetch/" + limit + "/" + offset ,
			type: "get",
			beforeSend: function(){
				$('.ajax-load').show();
			}
		})
		.done(function(data){
			console.log(data);
			$('.ajax-load').hide();
			
			for(var i = 0; i < data.length; i++){
				$('#main-content').append("<h3>Data ke"+ data[i].id + "</h3> <div> <span>"+data[i].name+"</span><span>"+data[i].email+"</span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum architecto pariatur voluptas debitis quae vitae illo necessitatibus est dolor quod aliquid commodi dicta, quia rerum quos, atque quasi, ab omnis.Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum architecto pariatur voluptas debitis quae vitae illo necessitatibus est dolor quod aliquid commodi dicta, quia rerum quos, atque quasi, ab omnis.</span></div>");
			}
			
			offset += data.length;
		})
		.fail(function(){
			console.log("server not respond call admin");
		});
		
		
		
		
	}
	
	
 
  </script>
  
</html>

