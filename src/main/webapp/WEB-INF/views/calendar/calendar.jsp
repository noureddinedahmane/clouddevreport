<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
    
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              Calendar
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
	     <div class="col-md-3">
	     
	     <!--  
	        <div class="box box-solid">
	            <div class="box-header with-border">
	              <h4 class="box-title">Draggable Events</h4>
	            </div>
	            <div class="box-body">
	              
	              <div id="external-events">
	                <div class="external-event bg-green">Lunch</div>
	                <div class="checkbox">
	                  <label for="drop-remove">
	                    <input type="checkbox" id="drop-remove">
	                    remove after drop
	                  </label>
	                </div>
	              </div>
	            </div>
	            
	          </div>
	          -->
	          <!-- /. box -->
	          <div class="box box-solid">
	            <div class="box-header with-border">
	              <h3 class="box-title">Create Event</h3>
	            </div>
	            <div class="box-body">
                   Here comes the calendar!!
	            </div>
	          </div>
	          
	      <div class="box box-solid">
            <div class="box-header">
             <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus" style="margin-right:2px;"></i></button>
            </div>
            
	         <div class="box-body no-padding">
	              <table class="table table-condensed table_calendar">
	                <tbody id="calendarList">
	                   <c:choose>
	                   
		                     <c:when test="${listCalendar!=null}">
		                     
		                       <c:forEach items="${listCalendar}" var="calendar">
	                                  <tr>
	                                      <td class="calendar_Name">${calendar.calendarName}</td>
	                                      <td id="${calendar.idCalendar}">
	                                         <span class="edit_calendar calendar_tools"><i class="fa fa-edit"></i></span>
		                                     <span class="delete_calendar calendar_tools"><i class="fa fa-trash-o"></i></span>
	                                      </td>
	                                  </tr>
		                       </c:forEach>
		 
		                     </c:when>
	                     
	                    </c:choose>

	              </tbody>
	             </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
          
	        </div>
	        
	        <div class="col-md-9">
	          <div class="box box-primary">
	            <div class="box-body no-padding">
	              <!-- THE CALENDAR -->
	              <div id="calendar"></div>
	            </div>
	            <!-- /.box-body -->
	          </div>
                 <!-- /. box -->
            </div>
        
       </div><!-- ./Main Row -->
       
        <!-- Modal -->
		 <div class="modal fade"  id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Save Calendar</h4>
		        </div>
		        <div class="modal-body">
		          <div class="form-group">
		             <input type="hidden" id="idCalendar" value="">
		             <label for="firstname" class="control-label">Calendar Name:</label>
		             <input type="text" class="form-control" id="calendarName" name="calendarName" placeholder="Calendar Name...">	             
		           </div>
		        </div>
		        <div class="modal-footer">
		          <button type="button" id="saveCalendar" class="btn btn-primary" data-dismiss="modal">Save</button>
		          <button type="button" class="btn btn-danger" class="close" data-dismiss="modal">Cancel</button>
		          <img class="pull-right" id="progress" style="display:none;" src="<c:url value="/resources/dist/img/progress.gif"/>"  height="35" width="35" />
		        </div>
		      </div>
		      
		    </div>
		  </div>
		  
		   <!-- Modal for editing event -->
		   
		 <div class="modal fade"  id="myModalEvent" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Edit Event</h4>
		        </div>
		        <div class="modal-body">
		          <input type="hidden" id="idCalendarEvent" value="">
		          <input type="hidden" id="idEvent" value="">
		           
		           <div class="form-group">
		              <label for="event location" class="control-label">Title:</label>
			           <div class="input-group">      
		                 <input type="text" class="form-control" id="eventTitle" name="eventTitle" placeholder="Event Title...">
		                 <div class="input-group-btn">
		                   <button id="add-new-event" type="button" class="btn btn-primary btn-flat">Color</button>
		                 </div>
		               </div>
	               </div>
	               
	               <div class="form-group">
		               <div class="btn-group">
		                <!--<button type="button" id="color-chooser-btn" class="btn btn-info btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></button>-->
		                <ul class="fc-color-picker" id="color-chooser">
		                  <li><a class="text-aqua" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-blue" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-light-blue" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-teal" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-yellow" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-orange" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-green" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-lime" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-red" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-purple" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-fuchsia" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-muted" href="#"><i class="fa fa-square"></i></a></li>
		                  <li><a class="text-navy" href="#"><i class="fa fa-square"></i></a></li>
		                </ul>
		               </div>
	              </div>
		           
		           <div class="form-group">
		             <label for="event location" class="control-label">Location:</label>
		             <input type="text" class="form-control" id="eventLocation" name="eventLocation" placeholder="Event Location...">
		           </div>
		           
		           <div class="form-group">
		             <label for="event start date" class="control-label">Start Date:</label>
		             <input type="datetime-local" class="form-control" id="eventStartDate" name="eventstartDate">
		           </div>
		           
		           <div class="form-group">
		             <label for="event end date" class="control-label">End Date:</label>
		             <input type="datetime-local" class="form-control" id="eventEndDate" name="eventEndDate">
		           </div>
		           
		           <div class="form-group">
		             <label for="event " class="control-label">Occupation:</label>
		             <select class="form-control" id="eventOccupation">
		                 <option value="occupe" selected>Occupé(e)</option>
		                 <option value="libre">Libre</option>
		                 <option value="provisoire">Provisoire</option>
		                 <option value="absent">Absent(e)</option>
		             </select>
		           </div>
		           
		           <div class="form-group">
		             <label for="event description" class="control-label">Description:</label>
                     <textarea class="form-control" id="eventDescription" rows="4" cols=""></textarea>
		           </div>
		           
		           
		        </div>
		        <div class="modal-footer">
		          <button type="button" id="saveEvent" class="btn btn-primary" data-dismiss="modal">Save</button>
		          <button type="button" class="btn btn-danger" class="close" data-dismiss="modal">Cancel</button>
		        </div>
		      </div>
		      
		    </div>
		  </div>
		  <!-- end MODAL-->
		       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>

<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<!-- fullCalendar 2.2.5 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="<c:url value="/resources/plugins/fullcalendar/fullcalendar.min.js"/>" ></script>

<!-- Page specific script -->
<script>
  $(function () {

    /* initialize the external events
     -----------------------------------------------------------------*/
    function ini_events(ele) {
      ele.each(function () {

        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
        // it doesn't need to have a start or end
        var eventObject = {
          title: $.trim($(this).text()) // use the element's text as the event title
        };

        // store the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject);

        // make the event draggable using jQuery UI
        $(this).draggable({
          zIndex: 1070,
          revert: true, // will cause the event to go back to its
          revertDuration: 0  //  original position after the drag
        });

      });
    }

    ini_events($('#external-events div.external-event'));

    /* initialize the calendar
     -----------------------------------------------------------------*/
    //Date for the calendar events (dummy data)
    var date = new Date();
    var d = date.getDate(),
        m = date.getMonth(),
        y = date.getFullYear();
    
    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
      },
      buttonText: {
        today: 'today',
        month: 'month',
        week: 'week',
        day: 'day'
      },
      //Random default events
      events: [
        {
          title: 'All Day Event',
          start: new Date(y, m, 1),
          backgroundColor: "#f56954", //red
          borderColor: "#f56954" //red
        }
      ],
        
      editable: true,
      selectable:true,
      selectHelper:true,
      droppable: true, // this allows things to be dropped onto the calendar !!!
     
     //event mouseover
     eventMouseover:function( event, jsEvent, view ) { 
         //show tootip menu 
     },
     
     //event mouseover
     eventMouseout:function( event, jsEvent, view ) { 
          //hide tootltip menu
     },
     
     //event click
     eventClick:function( event, jsEvent, view ) { 
    	 start=moment(event.start).format('YYYY-MM-DDThh:mm');
   	     end=moment(event.end).format('YYYY-MM-DDThh:mm');
   	  
    	 $('#idEvent').val(event.id);
    	 $('#eventTitle').val(event.title);
    	 $('#eventStartDate').val(start);
   	     $('#eventEndDate').val(end);
   	     $('#eventLocation').val(event.location);
   	     $('#eventDescription').val(event.description);
   	     $('#eventOccupation').val(event.occupation);
   	     $("#add-new-event").css("background-color",event.backgroundColor);
   	  
   	     $('#myModalEvent').modal('show');
     },
     
     
    //select event
      select:function( startDate, endDate){
    	  
    	  //show the modal to edit event
    	  start=moment(startDate).format('YYYY-MM-DDThh:mm');
    	  end=moment(endDate).format('YYYY-MM-DDThh:mm');
    	  
    	  $('#eventStartDate').val(start);
    	  $('#eventEndDate').val(end);
    	  
    	  $('#myModalEvent').modal('show');

    	  
      }//end select event
      
    });
    
    /* ADDING EVENTS */
    var currColor = "#3c8dbc"; //Red by default
    $("#color-chooser > li > a").click(function (e) {
      e.preventDefault();
      //Save color
      currColor = $(this).css("color");
      //Add color effect to button
      $('#add-new-event').css({"background-color": currColor, "border-color": currColor});
    });
    

  });
  

  $(document).on("click","#saveEvent",function(e){
	  $.ajax({
			type : "POST",
			url : "saveEvent",
			dataType : 'json',
			data:{
				 "idCalendarEvent":$("#idCalendarEvent").val(),
				 "idEvent":$("#idEvent").val(),
				 "eventTitle":$("#eventTitle").val(),
				 "eventLocation":$("#eventLocation").val(),
				 "eventStartDate":$("#eventStartDate").val(),
				 "eventEndDate":$("#eventEndDate").val(),
				 "eventOccupation":$("#eventOccupation").val(),
				 "eventDescription":$("#eventDescription").val(),
				 "eventColor":$("#add-new-event").css("background-color")
			},

			success : function(data) {
			   
				//show success msg
				var msgElem ='<div class="alert alert-success alert-dismissible message">'+data[0]+'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button></div>';
			    $("#msg").html(msgElem);
			    
			    //render the new event 
			    var newEvent={
						  id:data[1],
						  title:$('#eventTitle').val(),
						  location:$('#eventLocation').val(),
						  occupation:$('#eventOccupation').val(),
						  description:$('#eventDescription').val(),
						  start:$('#eventStartDate').val(),
						  end:$('#eventEndDate').val(),
						  backgroundColor:$("#add-new-event").css("background-color")
				  };
				  
				$('#calendar').fullCalendar('renderEvent', newEvent, true);
				
				//nettoyer le modal
				$("#idEvent").val("");
				$("#eventTitle").val("");
				$("#eventLocation").val("");
				$("#eventOccupation").val("");
				$("#eventDescription").val("");
			},
			error : function(e) {
				alert("error");
			},
			done : function(e) {
				//alert("done");
			}
		});
	  
	  
	  
  });// end $(document).on("click","#saveEvent",function(e)  
		  
</script>

<script type="text/javascript">


  $(document).ready(function(){
	  
	  //select first calendar
	  var tr = $("#calendarList").children('tr:first');
	  if(tr!=null){
		  tr.css("background","#3c8dbc");
		  var calID =  $(tr).find("td:last-child").attr("id");
		  $("#idCalendarEvent").val(calID);
	  }
	  
	  $(document).on("click","#saveCalendar",function(){
		 
		    //start progress icon
		    $("#progress").css("display","block");
		    
			$.ajax({
				type : "POST",
				url : "saveCalendar",
				dataType : 'json',
				data:{
					 "idCalendar":$("#idCalendar").val(),
					 "calendarName":$("#calendarName").val()
				},

				success : function(data) {
				   
					//show success msg
					var msgElem ='<div class="alert alert-success alert-dismissible message">'+data[0]+'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button></div>';
				    $("#msg").html(msgElem);
				    
				    //check if save or update
				    if($("#idCalendar").val()==""){
				    	//insert calendar in calendar list
				    	insertCalendarToList(data[1], $("#calendarName").val());
				    }else{
				    	//es geht um updating
				    	var tdCalendar = document.getElementById($("#idCalendar").val());
				    	$(tdCalendar.parentNode).find("td:first").text($("#calendarName").val());


				    }
				    
				    //reset calendar input fields
				     $("#idCalendar").val("");
				     $("#calendarName").val("");
						
					//hide progress icon
					$("#progress").css("display","none");
				},
				error : function(e) {
					alert("error");
				},
				done : function(e) {
					//alert("done");
				}
			});
			
			
	  });
	  
	  $(document).on("click",".edit_calendar",function(e){
		  var idCalendar = $(this.parentNode).attr("id");
		  var calendarName =  $(this.parentNode.parentNode).find("td:first").text();
		  
		  $("#idCalendar").val(idCalendar);
		  $("#calendarName").val(calendarName);
		  
		  $('#myModal').modal('show');
	  });
	
	  
	  $(document).on("click",".calendar_Name",function(e){
		  $("#calendarList tr").css("background","");
		  $(this.parentNode).css("background","#3c8dbc");
		  
		  //get calendar id
		  var calID =  $(this.parentNode).find("td:last-child").attr("id");
		  $("#idCalendarEvent").val(calID);
		  
		  //refresh the calendar
		  alert("next step to refresh the calendar;;;;");
	  });
	  
	  function insertCalendarToList(idCalendar, calendarName){
		  
		  var html="<tr>"+
		           "<td class='calendar_Name'>"+calendarName+"</td>"+
		           "<td id='"+idCalendar+"'>"+
		           "<span class='edit_calendar calendar_tools'><i class='fa fa-edit'></i></span>"+
		           "<span class='delete_calendar calendar_tools'><i class='fa fa-trash-o'></i></span>"+
		           "</td>"+
		           "</tr>";
		           
		  $("#calendarList").prepend(html);
	  }
	  
	  
	// end ---$(document).ready(function()
   });
	</script>