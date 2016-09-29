
/*
 * 1- start document
 * 2- Dom manipulation 
 * 3- Adding list 
 * 4- Event handling
 * 5- AJAX
*/

// IIFE - Immediately Invoked Function Expression
  (function($, window, document) {

    // The $ is now locally scoped 

   // Listen for the jQuery ready event on the document
   $(function() {

     // The DOM is ready!

   });

   // The rest of the code goes here!

  }(window.jQuery, window, document));
  // The global jQuery object is passed as a parameter
  
  
  //*********************************************************************************************
  
  /*
   * 2- Dom manipulation 
  */
  
  // Stores the live DOM element inside of a variable
  var elem = $("#elem");

  // Set's an element's title attribute using it's current text
  elem.attr("title", elem.text());

  // Set's an element's text color to red
  elem.css("color", "red");

  // Makes the element fade out
  elem.fadeOut();
	
  
  //***********************************************************************************************
  /*
   * 3- Adding list 
  */
  // Dynamically building an unordered list from an array
  var localArr = ["Greg", "Peter", "Kyle", "Danny", "Mark"],
  	list = $("ul.people"),
  	dynamicItems = "";

  $.each(localArr, function(index, value) {

    dynamicItems += "<li id=" + index + ">" + value + "</li>";

  });

  list.append(dynamicItems);
  
//***********************************************************************************************
  /*
   * 4- Event handling
  */
  
  var list = $("#longlist");

  list.on("mouseenter", "li", function(){

    $(this).text("Click me!");

  });

  list.on("click", "li", function() {

    $(this).text("Why did you click me?!");

  });
	
  
//***********************************************************************************************
  /*
   * 5- AJAX
  */
  
  //this is very flexible
  

  function getName(personid) {
    var dynamicData = {};
    dynamicData["id"] = personID;
    return $.ajax({
      url: "getName.php",
      type: "get",
      data: dynamicData
    });
  }

  getName("2342342").done(function(data) {
    // Updates the UI based the ajax result
    $(".person-name").text(data.name); 
  });
  
  