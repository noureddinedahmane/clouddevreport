<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
    <!-- Content header-->
    <section class="content-header">
        
         <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              <spring:message code="label.note"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
       
          <!-- Left col -->
          <section class="col-lg-4 connectedSortable ui-sortable note-section">
          
	         <div class="box box-primary note-box">
	           <div class="box-header with-border">
	             <h3 class="box-title"><p><spring:message code="label.listNotes"/></p></h3>
	
	             <div class="box-tools pull-right">
	               <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
	               </button>
	             </div>
	             <!-- /.box-tools -->
	           </div>
	           <!-- /.box-header -->
	           
	           <div class="box-body note-list" style="display: block;">
	               <ul id="noteSelect">
	               
	                 <c:choose>
	                     <c:when test="${listNotes!=null}">
	                     
	                       <c:forEach items="${listNotes}" var="note">
	                     
		                        <li id="${note.idNote}">
				                    <div class="tools">
			                             <i class="fa fa-edit editNote"></i>
			                             <i class="fa fa-trash-o deleteNote"></i>
			                         </div>
			                         <div class="note_title">
			                             <h3 class="noteTitle">${note.title}</h3>
			                         </div>
			                         <div class="note_body">
			                           <p class="noteBody">${note.note}</p>
			                         </div>
		                        </li>
	                       </c:forEach>
	 
	                     </c:when>
	                 </c:choose>
	                
	                   
	               </ul>
	           </div>
	           
	           <!-- /.box-body -->
	         </div>
          
         </section>
          
          <!-- Right col -->
          <section class="col-lg-8 connectedSortable ui-sortable note-section">

		          <div class="box box-primary note-box">
		            <div class="box-header">
		              <i class="fa fa-fw fa-sticky-note"></i>
		
		              <h3 class="box-title">Edit Your Note</h3>
		              <!-- tools box -->
		              <div class="box-tools pull-right">
	                      <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
	                       </button>
	                   </div>
		              <!-- /. tools -->
		            </div>
		            <div class="box-body">
		              <form action="#" method="post">
		                <input type="hidden" id="idNote" name="idNote" value />
		                <div class="form-group">
		                  <input type="text" class="form-control note-title-input" id="subjectNote" name="subject" placeholder="Note Title...">
		                </div>
		                <div>
		                  <textarea class="textarea" id="contentNote" name="contentNote" placeholder="Note Body ..." style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
		                </div>
		              </form>
		            </div>
		            <div class="box-footer clearfix">
		               <button type="button" class="pull-right btn btn-primary" id="saveNote">Save
		                <i class="fa fa-arrow-circle-right"></i></button>
		                <button type="button" style="margin-right:5px;" class="pull-right btn btn-primary" id="newNote">New Note</button>
		                <img class="pull-right" id="progress" style="display:none;" src="<c:url value="/resources/dist/img/progress.gif"/>"  height="35" width="35" />
		            </div>
		           </div>
		            
          </section>
          
       </div>
       
    </section>

      
  </div>
  

<%@include file="../footer.jsp" %>



<script type="text/javascript">


  $(document).ready(function(){
	  
	  $(document).on("click","#saveNote",function(){
		 
		    //start progress icon
		    $("#progress").css("display","block");
		    
			$.ajax({
				type : "POST",
				url : "saveNote",
				dataType : 'json',
				data:{
					 "idNote":$("#idNote").val(),
					 "subjectNote":$("#subjectNote").val(),
					 "contentNote":$("#contentNote").val()
				},

				success : function(data) {
				   
					//show success msg
					var msgElem ='<div class="alert alert-success alert-dismissible message">'+data[0]+'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button></div>';
				    $("#msg").html(msgElem);
				    
				    //check if save or update
				    if($("#idNote").val()==""){
				    	//es geht neue Notiz
				    	insertNewNoteInList(data[1], $("#subjectNote").val(), $("#contentNote").val())
				    }else{
				    	//es geht um updating
				    	var noteLi = document.getElementById($("#idNote").val());
				    	noteLi.getElementsByClassName("noteTitle")[0].innerHTML=$("#subjectNote").val();
				    	noteLi.getElementsByClassName("noteBody")[0].innerHTML=$("#contentNote").val();

				    }
				    
				    //change the idNote
					$("#idNote").val(data[1])
						
					//hide progress icon
					$("#progress").css("display","none");
				},
				error : function(e) {
					alert("error");
				},
				done : function(e) {
					alert("done");
				}
			});
			
			
	  });
	  
	  $(document).on("click",".editNote",function(e){
		  
		      var li = this.parentNode.parentNode;
		      var idNote = $(li).attr("id");
		      var noteTitle = li.getElementsByClassName("noteTitle")[0].innerHTML;
		      var noteBody = li.getElementsByClassName("noteBody")[0].innerHTML;
		     
		      $("#idNote").attr("value",idNote);
		      $("#subjectNote").attr("value",noteTitle);
		      $("#contentNote").val(noteBody);
			 
	   });
	  
	  $(document).on("click","#noteSelect li",function(e){
		  
		  var li = this;
	      var idNote = $(li).attr("id");
	      var noteTitle = li.getElementsByClassName("noteTitle")[0].innerHTML;
	      var noteBody = li.getElementsByClassName("noteBody")[0].innerHTML;
	     
	      $("#idNote").val(idNote);
	      $("#subjectNote").val(noteTitle);
	      $("#contentNote").val(noteBody);
	      
	      
	  });
	  
	  $(document).on("click","#newNote",function(){
		  $("#idNote").val("");
	      $("#subjectNote").val("");
	      $("#contentNote").val("");
			 
	  });
	  
	  $(document).on("click",".deleteNote",function(){
		  
		//start progress icon
		    $("#progress").css("display","block");
		    
			$.ajax({
				type : "POST",
				url : "deleteNote",
				dataType : 'json',
				data:{
					 "idNote":$(this.parentNode.parentNode).val()
				},
				
				success : function(data) {
					//show success msg
					var msgElem ='<div class="alert alert-success alert-dismissible message">'+data[0]+'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button></div>';
				    $("#msg").html(msgElem);
				    
				    //remove note from note list
				    var noteLi = document.getElementById(data[1]);
				    $(noteLi).remove();
				    
				   //hide progress icon
					$("#progress").css("display","none");
				},
				error : function(e) {
					alert("error");
				},
				done : function(e) {
					alert("done");
				}			
				
	    });
	  });
	  
	  function insertNewNoteInList(idNote, noteTitle, noteBody){
		  
		  var html='<li id="'+idNote+'">'+
              '<div class="tools">'+
               ' <i class="fa fa-edit editNote"></i>'+
                '<i class="fa fa-trash-o deleteNote"></i>'+
              '</div>'+
              '<div class="note_title">'+
                '<h3 class="noteTitle">'+noteTitle+'${note.title}</h3>'+
             '</div>'+
             '<div class="note_body">'+
                '<p class="noteBody">'+noteBody+'${note.note}</p>'+
             '</div>'+
           '</li>';
           
           $("#noteSelect").prepend(html);

	  }
	  
	  
  });
  
	
</script>
