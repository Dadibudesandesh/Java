<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="MyServlet" method="post">

			<table>
				<tr>Add Question
				</tr>
				<tr>
					<td>Question :</td>
					<td><textarea rows="10" cols="50" name="que"></textarea></td>
				</tr>
				<tr>
					<td>Option A</td>
					<td><input type="text" name="opt1" /></td>
				</tr>
				<tr>
					<td>Option B</td>
					<td><input type="text" name="opt2" /></td>
				</tr>
				<tr>
					<td>Option C</td>
					<td><input type="text" name="opt3" /></td>
				</tr>
				<tr>
					<td>Option D</td>
					<td><input type="text" name="opt4" /></td>
				</tr>
				<tr>
					<td>Correct Ans :</td>
					<td><select name="ans">
							<option value="">Select</option>
							<option value="opt1">Option A</option>
							<option value="opt2">Option B</option>
							<option value="opt3">Option C</option>
							<option value="opt4">Option D</option>
					</select></td>
				</tr>
				<tr>
					<td>Marks :</td>
					<td><input type="number" name="marks" /></td>
				</tr>
				<tr>
					
					<td><input type="submit" name="addque" value="Add Question"/>
					<a href="ViewQue">View Questions</a>
					
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>