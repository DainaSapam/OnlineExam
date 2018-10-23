$(document).ready(function(){
	
	$('#courseForm').submit(function(e){
		
		var course = $("#course").val();
		var marks = $("#marks").val();
		var duration = $("#duration").val();
		
		if(course.length == ""){
			$("#course").after('<span class="text-danger">Please Enter the Course.</span>');
			$("#course").focus();
			e.preventDefault();
		}
		
		if(marks.length == ""){
			$("#marks").after('<span class="text-danger">Please Enter the Total Marks.</span>');
			$("#marks").focus();
			e.preventDefault();
		
		}
		
		if(duration.length == ""){
			$("#duration").after('<span class="text-danger">Please Enter the Duration of the exam.</span>');
			$("#duration").focus();
			e.preventDefault();
		}
		
		var inputJSON = null;
		console.log("course: "+course+"\n Total Marks: "+marks+"\n Duration: "+duration);
		e.preventDefault();
		if((course.length != 0) && (marks.length != 0) && 
				(duration.length != 0)){
			inputJSON = {course: course, marks: marks, duration: duration};
		}
		
		$.ajax({
			cache: 'false',
			url: "./Course",
			type: 'GET',			
			data: inputJSON,			
			success: function(data, xhr){
				
				$('#message').html('<div class="alert-success text-center">'
						+'Course successfully inserted into the database</div>');
				$('#message').fadeOut(3000);
				$("#courseForm").each(function(){
					this.reset();
				});
			},
			error : function(xhr) {
				$('#message').html('<div class="alert-danger text-center">'
						+'Unable to insert the course </div>');
				$('#message').fadeOut(3000);
				$("#courseForm").each(function(){
					this.reset();
				});
				console.log("error");
			},
			complete : function(data){
				console.log("complete");
			}
		});
	});
});