<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.addMember"/> : ${group.label}
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
         
          <div class="col-xs-12">
	        <div class="box box-info">
	        <form action="saveMembersToGroups" method="POST">
	            <input type="hidden" name="idGroup" value="${group.idApprovementGroup}">
	            <div class="box-header">
	              <h3 class="box-title"></h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <table id="patients" class="table table-bordered table-striped">
	                <thead>
	                <tr>
	                   <th></th>
	                  <th> <spring:message code="label.firstName"/></th>
	                  <th> <spring:message code="label.secondName"/></th>
                      <th> <spring:message code="label.domain"/></th>
                      <th> <spring:message code="label.position"/></th>
                      <th> <spring:message code="label.roles"/></th>
	                </tr>
	                </thead>
	                <tbody>
	                                     
	                   <!--  LIst User already in group -->
	                   <c:choose >
	                       <c:when test="${listUserInGroup!=null}">
	                           <c:forEach items="${listUserInGroup}" var="userInGroup">
	                             <tr>
	                                <td><input type="checkbox" name = "users" value="${userInGroup.idClient}" checked></td>
	                                <td>${userInGroup.name}</td>
	                                <td>${userInGroup.prenom}</td>
									<td><a href="editDomain?idDomain=${userInGroup.domain.idDomain}"> ${userInGroup.domain.domainName} </a></td>
									<td>${userInGroup.position}</td>
									<td>ROLE_ADMIN</td>
	                             </tr>
	                           </c:forEach>
	                       </c:when>
	                   </c:choose>
	                   
	                   <!--  LIst User dos not exist in group -->
	                    <c:choose >
	                       <c:when test="${listUsers!=null}">
	                           <c:forEach items="${listUsers}" var="user">
	                             <tr>
	                                <td><input type="checkbox" name = "users" value="${user.idClient}"></td>
	                                <td>${user.name}</td>
	                                <td>${user.prenom}</td>
									<td><a href="editDomain?idDomain=${user.domain.idDomain}"> ${user.domain.domainName} </a></td>
									<td>${user.position}</td>
									<td>ROLE_ADMIN</td>
	                             </tr>
	                           </c:forEach>
	                       </c:when>
	                   </c:choose>
	                   
	                   
	                </tbody>
	              </table>
	            </div>
	            <!-- /.box-body -->
	             <button type="submit" class="btn btn-primary" style="margin:5px;"> <spring:message code="label.send"/></button>
               </form>
	          </div>     	          
	          
        </div>
            
        <!-- /.box -->
          
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>