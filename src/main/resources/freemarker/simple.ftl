<html xmlns:c="http://www.w3.org/1999/html">
<head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
</head>
<body>
<p>${call}</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${content}</p>
<#if pdfUrl??>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pdfUrl}">${pdfUrl}</a></p>
</#if>
<p style="text-align: right">${footer}</p>
</body>
</html>
