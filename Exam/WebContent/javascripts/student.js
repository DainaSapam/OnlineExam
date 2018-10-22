// multiplication table d
	var d=[
	    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
	    [1, 2, 3, 4, 0, 6, 7, 8, 9, 5], 
	    [2, 3, 4, 0, 1, 7, 8, 9, 5, 6], 
	    [3, 4, 0, 1, 2, 8, 9, 5, 6, 7], 
	    [4, 0, 1, 2, 3, 9, 5, 6, 7, 8], 
	    [5, 9, 8, 7, 6, 0, 4, 3, 2, 1], 
	    [6, 5, 9, 8, 7, 1, 0, 4, 3, 2], 
	    [7, 6, 5, 9, 8, 2, 1, 0, 4, 3], 
	    [8, 7, 6, 5, 9, 3, 2, 1, 0, 4], 
	    [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
	];

	// permutation table p
	var p=[
	    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], 
	    [1, 5, 7, 6, 2, 8, 3, 0, 9, 4], 
	    [5, 8, 0, 3, 7, 9, 6, 1, 4, 2], 
	    [8, 9, 1, 6, 0, 4, 3, 5, 2, 7], 
	    [9, 4, 5, 3, 1, 2, 6, 8, 7, 0], 
	    [4, 2, 8, 6, 5, 7, 3, 9, 0, 1], 
	    [2, 7, 9, 3, 8, 0, 6, 4, 1, 5], 
	    [7, 0, 4, 6, 9, 1, 3, 2, 5, 8]
	];

	// inverse table inv
	var inv = [0, 4, 3, 2, 1, 5, 6, 7, 8, 9];

	// converts string or number to an array and inverts it
	function invArray(array){
	    
	    if (Object.prototype.toString.call(array) == "[object Number]"){
	        array = String(array);
	    }
	    
	    if (Object.prototype.toString.call(array) == "[object String]"){
	        array = array.split("").map(Number);
	    }
	    
		return array.reverse();
		
	}

	// generates checksum
	function generate(array){
	    	
		var c = 0;
		var invertedArray = invArray(array);
		
		for (var i = 0; i < invertedArray.length; i++){
			c = d[c][p[((i + 1) % 8)][invertedArray[i]]];
		}
		
		return inv[c];
	}

	// validates checksum
	function validate(array) {
	    
	    var c = 0;
	    var invertedArray = invArray(array);
	    
	    for (var i = 0; i < invertedArray.length; i++){
	    	c=d[c][p[(i % 8)][invertedArray[i]]];
	    }

	    return (c === 0);
	}


$(document).ready(function(){
	
	$('#studentForm').submit(function(e){
		
		var aadhar = $("#aadhar").val();
		var name = $("#studentName").val();
		
		if(aadhar.length == 0){
			$("#aadhar").after('<span class="text-danger">Please Enter the Aadhar Number.</span>');
			$("#aadhar").focus();
			e.preventDefault();
		}else if(aadhar.length < 12){
			  $("#aadharNumber").after('<span class="text-danger ">Aadhar Number should be of 12 digits</span>');
			  $("#aadhar").focus();
			  e.preventDefault();
			  return false;
		  }else if(aadhar.length > 12){
			  $("#aadharNumber").after('<span class="text-danger ">Aadhar Number should not be more than 12 digits</span>');
			  $("#aadhar").focus();
			  e.preventDefault();
			  return false;
		  }
		
		validate(aadhar);
		
		if(name.length == ""){
			$("#studentName").after('<span class="text-danger ">Please Enter Student Name.</span>');
			$("#studentName").focus();
			e.preventDefault();
		
		}
		
		
		
		var inputJSON = null;
		console.log("aadhar: "+aadhar+"\n Student Name: "+name);
		e.preventDefault();
		if((aadhar.length != 0) && (studentName.length != 0)){
			inputJSON = {aadhar: aadhar, name: name};
		}
		
		$.ajax({
			cache: 'false',
			url: "./Student",
			type: 'GET',			
			data: inputJSON,			
			success: function(data, xhr){
				
				$('#message').html('<div class="alert-success text-center">'
						+'Student successfully inserted into the database</div>');
				$('#message').fadeOut(2000);
				$("#studentForm").each(function(){
					this.reset();
				});
			},
			error : function(xhr) {
				$('#message').html('<div class="alert-danger text-center">'
						+'Unable to insert the student </div>');
				$('#message').fadeOut(2000);
				$("#studentForm").each(function(){
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