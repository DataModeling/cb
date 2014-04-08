
	$(document).ready(function(){
		 $("#previous").attr("disabled", "disabled");

		

		$("#next").click(function(event){
			var head = "<table class=\"table table-striped table-hover\"><tr>";
			head += "<td align=\"left\"><h4>Sender</h4></td>";
			head += "<td align=\"center\"><h4>Subject</h4></td>";
			head += "<td align=\"right\"><h4>Time</h4></td></tr>";;
			debugger;
			$("#main_body").fadeOut();
			$.ajax({
				
					type:'POST',
					url:'module3/loadNextEmailsAjax.action',
					success:function(data){
						
						if(data.saturateNext){
							$("#next").attr("disabled", "disabled");
						}
						$.each(data.emailsList, function(index,value){
							date = value.timestamp;
							var temp = date.split("T");
							var fullDate = temp[0].split("-");
							var year = fullDate[0];
							var month = fullDate[1];
							var day = fullDate[2];
							
							var fullTime = temp[1].split(":");
							var hour = fullTime[0];
							var minute = fullTime[1];
							var sec = fullTime[2];
							
							var format = day+"/"+month+"/"+year+"("+temp[1]+")";
							head += '<tr class=\'clickableRow clickable\'><td align=\"left\">'+value.sender.name+","+value.sender.email+'</td>';
							head += '<td align=\"center\">'+value.subject+'</td>';
							head += '<td align=\"right\">'+format+'</td></tr>';
							
						
						});
						$("#previous").removeAttr("disabled");

						$("#main_body").html(head);
						$("#main_body").fadeIn();
						
					}
			});

		});
		$("#previous").click(function(event){
			var head = "<table class=\"table table-striped table-hover\"><tr class='clickableRow'>";
			head += "<td align=\"left\"><h4>Sender</h4></td>";
			head += "<td align=\"center\"><h4>Subject</h4></td>";
			head += "<td align=\"right\"><h4>Time</h4></td></tr>";
			debugger;
			$("#main_body").fadeOut();
			$.ajax({
				
					type:'POST',
					url:'module3/loadPreviousEmailAjax.action',
					success:function(data){
						if(data.saturatePrevious){
							 $("#previous").attr("disabled", "disabled");

						}
						$.each(data.emailsList, function(index,value){
							date = value.timestamp;
							var temp = date.split("T");
							var fullDate = temp[0].split("-");
							var year = fullDate[0];
							var month = fullDate[1];
							var day = fullDate[2];
							
							var fullTime = temp[1].split(":");
							var hour = fullTime[0];
							var minute = fullTime[1];
							var sec = fullTime[2];
							
							var format = day+"/"+month+"/"+year+"("+temp[1]+")";
							head += '<tr class=\'clickableRow clickable\'><td align=\"left\">'+value.sender.name+","+value.sender.email+'</td>';
							head += '<td align=\"center\">'+value.subject+'</td>';
							head += '<td align=\"right\">'+format+'</td></tr>';
							
						
						});
						 $("#next").removeAttr("disabled");

						$("#main_body").html(head);
						$("#main_body").fadeIn();
						
					}
			});

		});

	    $('#main_body').on("click","tr",function() { 
	    	var sender = $(this).find('td').eq(0).text();
	    	var subject = $(this).find('td').eq(1).text();
	    	var timestamp = $(this).find('td').eq(2).text();
	    	debugger;
	    	window.location = "module3/loadSelectedEmail?sender="+sender+"&"+"subject="+subject+"&"+"timestamp="+timestamp;
	    });
	});