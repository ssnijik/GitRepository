function checkTitle()
{
	var title = $("#title").val();
	//alert(title.length);
	if(title.length>30)
	{
		alert("���ⳤ�ȴ���30");
		return false;
	}
	else if(title.length==0)
	{
		alert("���ⲻ��Ϊ��");
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
		alert("δѡ�����");
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
			alert("ͼƬ��ʽ������");
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