$(document).ready(function(){
	
	$('#questionForm').submit(function(e){
		
		alert("Hi");
		
		var question = $("#question").val();
		var opt1 = $("#opt1").val();
		var opt2 = $("#opt2").val();
		var opt3 = $("#opt3").val();
		var opt4 = $("#opt4").val();
		var answer = $("#answer").val();
		
		
		if(question.length == ""){
			$("#question").after('<span class="error">Please Enter the Question.</span>');
			$("#question").focus();
			e.preventDefault();
		}
		
		if(opt1.length == ""){
			$("#opt1").after('<span class="error">Please Enter the First Option.</span>');
			$("#opt1").focus();
			e.preventDefault();
		
		}
		
		if(opt2.length == ""){
			$("#opt2").after('<span class="error">Please Enter the Second Option.</span>');
			$("#opt2").focus();
			e.preventDefault();
		}
		
		if(opt3.length == ""){
			$("#opt3").after('<span class="error">Please Enter the Third Option.</span>');
			$("#opt3").focus();
			e.preventDefault();
		}
		
		if(opt4.length == ""){
			$("#opt4").after('<span class="error">Please Enter the Fouth Option.</span>');
			$("#opt4").focus();
			e.preventDefault();
		}
		
		if(answer.length == ""){
			$("#answer").after('<span class="error">Please Enter the Correct Answer.</span>');
			$("#answer").focus();
			e.preventDefault();
		}
		
		var inputJSON = null;
		console.log("question: "+question+"\n opt1: "+opt1+"\n opt2: "+opt2+"\n opt3: "+opt3+
				"\n opt4: "+opt4+"\n answer: "+answer);
		e.preventDefault();
		if((question.length != 0) && (opt1.length != 0) && 
				(opt2.length != 0) && (opt3.length != 0) && 
				(opt4.length != 0) && (answer.length != 0)){
			inputJSON = {question: question, opt1: opt1, opt2: opt2, opt3: opt3, opt4: opt4, answer: answer};
		}
		
		$.ajax({
			cache: 'false',
			url: "./Questions",
			type: 'GET',			
			data: inputJSON,			
			success: function(data, xhr){
				
				$('#message').html('<div>'
						+'Question successfully inserted into the database</div>');
				$('#message').fadeOut(2000);
				$("#questionForm").each(function(){
					this.reset();
				});
			},
			error : function(xhr) {
				$('#message').html('<div>'
						+'Unable to insert the question </div>');
				$('#message').fadeOut(2000);
				$("#questionForm").each(function(){
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