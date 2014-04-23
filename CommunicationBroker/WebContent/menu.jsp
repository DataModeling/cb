	<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="javascript:void(0)"
		onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">Compose</a>
	</li>
	<div id="light" class="white_content">
		<form action="/CommunicationBroker/module1/compose">
			<table>
				<tr>
					<td><b>To</b></td>
					<td><input type="text" name="reciever_email" size="40"><br></td>
				</tr>
				<tr>
					<td><b>Cc</b></td>
					<td><input type="text" name="cc_email" size="40"></td>
				</tr>
				<tr>
					<td><b>Subject</b></td>
					<td><input type="text" name="subject" size="40"></td>
				<tr>
					<td><b>body</b></td>
					<td><textarea rows="8" cols="42" name="body" id="body"></textarea></td>
				</tr>
			</table>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button type="submit" class="btn btn-success">Submit</button><br>
			<br>
		</form>
		<a href="javascript:void(0)"
			onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
			<center><button type="button" class="btn btn-primary btn-sm" >Close</button></center></a>
	</div>
	<div id="fade" class="black_overlay"></div>
					      <li><a href="#">Delete</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Move<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">Family</a></li>
            <li><a href="#">Office</a></li>
            <li><a href="#">Close Friends</a></li>
          </ul>
        </li>
        <li><a href="#">Spam</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">More<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">Mark Read</a></li>
            <li><a href="#">Mark Unread</a></li>
            <li><a href="#">Label</a></li>
          </ul>
        </li>  
				</ul>


			</div>