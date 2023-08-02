<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>

<ul>
    <#list menu as menuItem>
        <li><a href="${menuItem.link}">${menuItem.label}</a></li>
    </#list>
</ul>

<h1>Student List</h1>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Type</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <#list students as student>
        <tr>
            <td>${student.id!""}</td>
            <td>${student.type!""}</td>
            <td><li><a href="/Java4Tihonenko_war_exploded/student/${student.id!""}">${student.name!""}</a></li></td>
            <td>${student.email!""}</td>
        </tr>
    </#list>
    </tbody>
</table>


<h2>Add Student</h2>
<form method="post" action="/badex_war_exploded/add">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name"><br>
    <label for="type">Type:</label>
    <input type="text" name="type" id="type"><br>
    <label for="email">Email:</label>
    <input type="email" name="email" id="email"><br>
    <input type="submit" value="Add">
</form>
</body>
</html>