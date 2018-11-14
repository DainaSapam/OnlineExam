var question_no = 1;
var question_id=0;
var prev_qID = 0;
var max_questions = 100;

var timer = 3600;
var min = 0;
var sec = 0;

window.onbeforeunload = function() {
	if (question_no != max_questions) {
		return "Warning: Your work will be lost!";
	}
};

function startTimer() {
	min = parseInt(timer / 60);
	sec = parseInt(timer % 60);

	if (timer < 1) {
		window.location = "./Logout";
	}

	document.getElementById("time").innerHTML = "<b>Time Left: </b>"
			+ min.toString() + ":" + sec.toString();
	timer--;
	setTimeout(function() {
		startTimer();
	}, 1000);
}

$(document).ready(
		function() {
			$("#qNo").html('Question No.'+question_no+'/'+max_questions);
			$.get('getQuestion.jsp?question_no='+question_no+'&req=first',
					function(data,status){
				console.log(status);
				var obj = JSON.parse(data);
				console.log(data);
				console.log("Question ID: "+obj.qID+"\n"
						+"Q. "+obj.question+'\n'
						+'a) '+obj.opt1+'\n'
						+'b) '+obj.opt2+'\n'
						+'c) '+obj.opt3+'\n'
						+'d) '+obj.opt4+'\n');
				question_id=obj.qID;
				console.log("CurrentID: "+question_id);
				$("#questionID").val(obj.qID);
				$("#question").html('<b>Q. '+obj.question+'</b>');
				$("#opt1").html('<input type="radio" id="opt1" name="answer" value="'+obj.opt1+'">'+obj.opt1);
				$("#opt2").html('<input type="radio" id="opt2" name="answer" value="'+obj.opt2+'">'+obj.opt2);
				$("#opt3").html('<input type="radio" id="opt3" name="answer" value="'+obj.opt3+'">'+obj.opt3);
				$("#opt4").html('<input type="radio" id="opt4" name="answer" value="'+obj.opt4+'">'+obj.opt4);
			});
			
			if (question_no == 1) {
				$('#prev').hide();
			} else {
				$('#prev').show();
			}

			if (question_no == max_questions) {
				$('#next').hide();
			} else {
				$('#next').show();
			}

			if (question_no != max_questions) {
				$('#submit').hide();
			} else {
				$('#submit').show();
			}

			$('#next').click(
					function() {
						var answer = $('input[name=answer]:checked').val();
						var s = $('input[name=answer]:checked').length;

						if (s == 0) {
							alert("Please select answer for this question");
						} else {
							console.log("CurrentID: "+question_id);
							console.log("PreviousID: "+prev_qID);
							prev_qID=question_id;
							question_no++;
							$("#qNo").html('Question No.'+question_no+'/'+max_questions);
							$.get('getQuestion.jsp?question_no='+question_no+'&question_id='+question_id+'&answer='+answer,function(data,status){
								console.log(status);
								var obj = JSON.parse(data);
								console.log(data);
								console.log("Question ID: "+obj.qID
										+"\nQ. "+obj.question+'\n'
										+'a) '+obj.opt1+'\n'
										+'b) '+obj.opt2+'\n'
										+'c) '+obj.opt3+'\n'
										+'d) '+obj.opt4+'\n');
								question_id=obj.qID;
								console.log("CurrentID: "+question_id);
								$("#questionID").val(obj.qID);
								$("#question").html('<b>Q. '+obj.question+'</b>');
								$("#opt1").html('<input type="radio" id="opt1" name="answer" value="'+obj.opt1+'">'+obj.opt1);
								$("#opt2").html('<input type="radio" id="opt2" name="answer" value="'+obj.opt2+'">'+obj.opt2);
								$("#opt3").html('<input type="radio" id="opt3" name="answer" value="'+obj.opt3+'">'+obj.opt3);
								$("#opt4").html('<input type="radio" id="opt4" name="answer" value="'+obj.opt4+'">'+obj.opt4);
							});

							if (question_no == 1) {
								$('#prev').hide();
							} else {
								$('#prev').show();
							}

							if (question_no == max_questions) {
								$('#next').hide();
							} else {
								$('#next').show();
							}

							if (question_no != max_questions) {
								$('#submit').hide();
							} else {
								$('#submit').show();
							}
						}
					});
			

			$('#submit').click(
					function() {
						var answer = $('input[name=answer]:checked').val();
						var s = $('input[name=answer]:checked').length;

						if (s == 0) {
							alert("Please select answer for this question");
						} else {
							$.post('getQuestion.jsp?question_no='+question_no+'&question_id='+question_id+'&answer='+answer+"&req=last");
							window.location = '#';
						}
					});

			$('#prev').click(
					function() {
						question_no--;
						var answer = $('input[name=answer]:checked').val();
						$("#qNo").html('Question No.'+question_no+'/'+max_questions);
						$("#previous").val();
						console.log("PreviousID: "+prev_qID);
						prev_qID=question_id;
						$.get('getPreviousQuestion.jsp?question_no='+question_no+'&question_id='+prev_qID+'&answer='+answer,function(data,status){
			                var obj=JSON.parse(data);
			                console.log(status);
							var obj = JSON.parse(data);
							console.log(data);
							console.log("Question ID: "+obj.qID
									+"\nQ. "+obj.question+'\n'
									+'a) '+obj.opt1+'\n'
									+'b) '+obj.opt2+'\n'
									+'c) '+obj.opt3+'\n'
									+'d) '+obj.opt4+'\n');
							question_id=obj.qID;
							console.log("CurrentID: "+question_id);
							$("#question").html('<b>Q. '+obj.question+'</b>');
							$("#opt1").html('<input type="radio" id="opt1" name="answer" value="'+obj.opt1+'">'+obj.opt1);
							$("#opt2").html('<input type="radio" id="opt2" name="answer" value="'+obj.opt2+'">'+obj.opt2);
							$("#opt3").html('<input type="radio" id="opt3" name="answer" value="'+obj.opt3+'">'+obj.opt3);
							$("#opt4").html('<input type="radio" id="opt4" name="answer" value="'+obj.opt4+'">'+obj.opt4);
						});

						if (question_no == 1) {
							$('#prev').hide();
						} else {
							$('#prev').show();
						}

						if (question_no == max_questions) {
							$('#next').hide();
						} else {
							$('#next').show();
						}

						if (question_no != max_questions) {
							$('#submit').hide();
						} else {
							$('#submit').show();
						}
					});

		});