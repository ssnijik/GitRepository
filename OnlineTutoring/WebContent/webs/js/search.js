// JavaScript Document

function createTab()
{
	//$tabNum=$("#myTab").children().length;
	var $words=$selectedCategory.text();
/*	$words=$words+":"+$("#searchCourseName").val();
	$words=$words+" "+$("#searchTeacherName").val();
	$words=$words+" "+$("#searchDescription").val();
	
	if($words.length>5)
	{
		$words=$words.substr(0,5)+"..."
	}*/
	
	$tabNO++;
	var $x=$("#tabTemplate").clone(true);
	$x.find("a").attr("href","#tab_"+$tabNO);
	$x.find("a").html($words+$x.find("a").html());
	$("#myTab:last").append($x);
	
	var $y=$("#tabContentTemplate").clone(true);
	//$y.css("display","block");
	$y.attr("id","tab_"+$tabNO);
	$y.find("p").text("xxx"+$tabNO+"zzz");
	$("#myTabContent").append($y);
	
	$x.find("a").tab('show');
}

function delTab()
{
	$x=$(event.srcElement).parent();
	$y=$x.attr("href");
	if($x.parent().next().length==0)
	{
		$x.parent().prev().find("a").tab('show');
		$($y).prev().addClass("active");
		$($y).prev().addClass("in");
	}
	else
	{
		$x.parent().next().find("a").tab('show');
		$($y).next().addClass("active");
		$($y).next().addClass("in");
	}

	$x.parent().remove();
	$($y).remove();
}

function selectCategory()
{
	//$x=$(event.srcElement);
	$selectedCategory.removeClass("activecourse");
	$(event.srcElement).addClass("activecourse");
	$selectedCategory=$(event.srcElement);
}

function customizedFunc()
{
	//alert("here is executed on loading");
	$selectedCategory=$("#course_list div:eq(0)");
	$tabNO=5;
	$advancedSearchPointer=0;
}

function showAdvancedSearch()
{
	if($advancedSearchPointer==0)
	{
		$("#adv_search_bar").addClass("active_bar");
		$("#adv_search_content").fadeIn(800,null_function(),showAdvancedSearch_callback());
		$("#adv_search_bar img:eq(0)").fadeOut();
		$("#adv_search_bar img:eq(1)").fadeIn();
		
	}
	else
	{
		$("#adv_search_bar").removeClass("active_bar");
		$("#adv_search_bar img:eq(1)").fadeOut(800);
		$("#adv_search_bar img:eq(0)").fadeIn(800);
		$("#adv_search_content").fadeOut(800,null_function(),showAdvancedSearch_callback());
		
	}
}

function showAdvancedSearch_callback()
{
	if($advancedSearchPointer==0)
	{
		$("html,body").animate({scrollTop:$("#adv_search_bar").offset().top-50},1000);
		$advancedSearchPointer=1;
	}
	else
	{
		$("html,body").animate({scrollTop:$("#myTab").offset().top-50},1000);
		$advancedSearchPointer=0;
	}
}

function adv_selectCourse()
{
	$("#adv_courseBtn").text($(event.srcElement).text());
}

function adv_selectEval()
{
	
	if($(event.srcElement).text()!="")
	{
		$("#adv_evalBtn").text($(event.srcElement).text());
	}
	else
	{
		var $x=$("#customized_eval").clone(true);
		$("#adv_evalBtn").html($x.html());
	}

}

function null_function()
{

}