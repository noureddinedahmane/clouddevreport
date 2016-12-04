
$('#confirm-yes').on('click', function(e) {
    e.preventDefault();	
    var url = $(this).data('url');	    
    window.location.href = url;
    
});

$('.confirm-delete').on('click', function(e) {
	
	e.preventDefault();	
	
    var url = $(this).data('url'); 
    
    $("#confirm-yes").attr("data-url",url);
    
    $('#myModal').modal('show');
    
});

