<!DOCTYPE html>
<html>
<head>
    <title>Hello FreeMarker</title>
</head>
<body>

<ul>
    <#list menu as menuItem>
        <li><a href="${menuItem.link}">${menuItem.label}</a></li>
    </#list>
</ul>

<h1>Hello ${student.getName()!""}</h1>
<p> ${student}

</body>
</html>