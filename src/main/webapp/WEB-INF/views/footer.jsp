<!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
  </footer>

  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script  src="<c:url value="/resources/plugins/jQuery/jquery-2.2.3.min.js"/>" ></script>

<!-- Bootstrap 3.3.6 -->
<script  src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>" ></script>

<!-- AdminLTE App -->
<script  src="<c:url value="/resources/dist/js/app.min.js"/>" ></script>

<!-- CK Editor -->
<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>

<!-- DataTables -->
<script  src="<c:url value="/resources/plugins/datatables/jquery.dataTables.min.js"/>" ></script>
<script  src="<c:url value="/resources/plugins/datatables/dataTables.bootstrap.min.js"/>" ></script>

<!-- datetimepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>


<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
     
 <script>
 
   /* listing the notifications*/
 function listNotifications(){
	  $.ajax({
		  url: "listNotReadNotifications",
		  dataType: "json",
		  success: function(data){
			  executeNotifications(data);
		  },
		  error: function(error, status){
			    console.log("error:" + status);
			  }
		});
   }
   
   function executeNotifications(data){
	   if(data.length != 0){
		   var list="";
		   $("#notification_numb").html(data.length);
		   
		   for(i=0;i<data.length;i++){
			   list += "<li>" +
                       "<a href='viewNotification?idNotification=" + data[i][0]+ "'>" + 
                         "<h4>" + data[i][1] + "</h4>" +
                         "<p>" + data[i][2]+ " " + data[i][3]  +"</p>" + 
                       "</a>" + 
                     "</li>";
		   }
		   
		   $("#listNotification").html("");
		   $("#listNotification").html(list);
		   
	   }
	   
   }
   
   
   //calls
   listNotifications();
   
   //list the notification every 5 second
   
   setInterval(function() {      
	   listNotifications();	   
    }, 5 * 1000);

 </script>
 
 
</body>
</html>
