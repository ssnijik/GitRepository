function checkTitle()
{
	var title = $("#title").val();
	//alert(title.length);
	if(title.length>30)
	{
		alert("标题长度大于30");
		return false;
	}
	else if(title.length==0)
	{
		alert("标题不能为空");
		return false;
	}
	else
		return true;
		
}

function checkType()
{
	var type = $("#choosetype option:selected").text();
	if(type=="")
	{
		alert("未选择分类");
		return false;
	}
	else
		return true;
}

function checkPicture()
{
	var picturename = $("#pictureopen").val();
	//alert(picturename.split('.')[1]);
	if(picturename!="")
	{
		if(picturename.split('.')[1]=="jpg"||picturename.split('.')[1]=="png"||picturename.split('.')[1]=="jpeg"
			||picturename.split('.')[1]=="bmp")
			return true;
		else
		{
			alert("图片格式不允许");
			return false;
		}
	}
	return true;
}

function checkInfo()
{
	if(checkTitle()&&checkType()&&checkPicture())
	{
		$("#launchform").submit();
	}
}