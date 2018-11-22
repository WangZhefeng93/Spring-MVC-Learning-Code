<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h1>单文件上传演示案例</h1>
    <form action="doUploadSingle.action" method="post" enctype="multipart/form-data">
        请选择上传的图片：<input type="file" name="photo" /><br/><br/>
        <input type="submit" value="上传单个文件" />
    </form>
    <br/>
    <hr>
    <br/>
    <h1>多文件上传演示案例</h1>
    <form action="doUploadMore.action" method="post" enctype="multipart/form-data">
        请选择需要上传的图片1：<input type="file" name="images" /><br/>
        请选择需要上传的图片2：<input type="file" name="images" /><br/>
        请选择需要上传的图片3：<input type="file" name="images" /><br/><br/>
        <input type="submit" value="上传多个文件" />
    </form>
</body>
</html>
