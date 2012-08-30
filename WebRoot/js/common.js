
  

// 把多行数据，绑定到一个表格上
function bindTrInTable(tbObj, trStr) {
	$(tbObj).children().find("tr").last().after(trStr);
}

// 清空表格中的所有行
function clearTableTr(tbObj) {
	$(tbObj).children().find("tr").each(function(i, element) {
				if (i > 0) {
					$(element).remove();
				}
			});
}

// 判断字符串中是否含有某个字串
function hasStr(strSrc, subStr) {
	if (is.String(strSrc) && strSrc != null && strSrc != undefined) {
		var i = strSrc.toString().indexOf(subStr)
		if (i >= 0) {
			return true;
		}
	}
	return false;
}
 

// 判断数据类型
var is = {
	types : ["Array", "Boolean", "Date", "Number", "Object", "RegExp",
			"String", "Window", "HTMLDocument"]
};
for (var i = 0, c; c = is.types[i++];) {
	is[c] = (function(type) {
		return function(obj) {
			return Object.prototype.toString.call(obj) == "[object " + type
					+ "]";
		}
	})(c);
}

// 所有table的行变化
function tableline(tbs) {

	$(tbs).each(function(index, element) {

				$(this).find("tr").each(function(i, e) {

							if (i % 2 == 0) {
								$(e).css("background-color", "#f5f5f5");
							} else {
								$(e).css("background-color", "#ffffff");
							}

							// 为每一行设置鼠标移动事件
							var aa;
							$(e).mouseover(function() {
										aa = $(e).css("background-color");
										$(e).css("background-color", "#dff0ff");
									});
							$(e).mouseout(function() {
										$(e).css("background-color", aa);
									});
						});
			});
}
 
// 跳转到登录页面
function gologon(event) {
	window.location.href = event.data.path + "/l/logout.do"
}

/**
 * ajax提交数据
 * 
 * @param {}
 *            data_v
 * @param {}
 *            action
 */
function postForm(data_v, action) {
	var out;
	$.ajax({
				async : false,
				url : action,
				data : data_v,
				type : "post",
				success : function(result) {
					out = result;
				}

			});
	return out;
}

/**
 * 
 * 更上面的函数没有区别;仅仅为了方法名的见名知意
 * @param {} data_v
 * @param {} action
 * @return {}
 */
function getJson(data_v, action) {
	var out;
	$.ajax({
				async : false,
				url : action,
				data : data_v,
				type : "post",
				success : function(result) {
					out = result;
				}

			});
	return out;
}



// 取得一个页面上的数据
// 调用示例:getPostDatas($(document));
function getPostDatas(win) {

	var data_v = new Object();
	
	// 搜集参数 [肯定就两种形式一种是input,一种是select]
	
	$(win).find("input").each(function(index, element) {
		// checkbox    ck1=true 或者  ck1=true,false
		if ($(element).attr("name") && $(element).attr("type") == "checkbox") {
			if (data_v[$(element).attr("name")] != undefined) {
				data_v[$(element).attr("name")] = data_v[$(element)
						.attr("name")]
						+ "," + $(element).attr("checked");
			} else {
				data_v[$(element).attr("name")] = $(element).attr("checked");
			}
			return;
		}
		// radio  :  rabtn1="v1" 或者 rabtn1=""
		if ($(element).attr("name") && $(element).attr("type") == "radio") 
		{
			//如果已经设置过值,直接退出
			if(data_v[$(element).attr("name")]!=undefined&&data_v[$(element).attr("name")]!="")
			{	
				 return;
			}
			if($(element).attr("checked"))
			{
				data_v[$(element).attr("name")] = $(element).attr("value");
				return;
			}
			else
			{
				data_v[$(element).attr("name")] = "";
				return;
			}			
		}

		// text hidden
		if ($(element).attr("name")) {

			if (data_v[$(element).attr("name")] != undefined) 
			{
				data_v[$(element).attr("name")] = data_v[$(element).attr("name")]+ "," + $(element).val();
					
			} 
			else 
			{
				data_v[$(element).attr("name")] = $(element).val();
			}
		}
	});

	$(win).find("select").each(function(index, element) {
		if ($(element).attr("name") != undefined) {
			if (data_v[$(element).attr("name")]) {
				data_v[$(element).attr("name")] = data_v[$(element)
						.attr("name")]
						+ "," + $(element).val();
			} else {
				data_v[$(element).attr("name")] = $(element).val();
			}
		}
	});

	// textarea
	$(win).find("textarea").each(function(index, element) {
		if ($(element).attr("name") != undefined) {
			if (data_v[$(element).attr("name")]) {
				data_v[$(element).attr("name")] = data_v[$(element)
						.attr("name")]
						+ "," + $(element).val();
			} else {
				data_v[$(element).attr("name")] = $(element).val();
			}
		}
	});

	return data_v;
}


/**
 * 
 * 因为base64的编码中含有 / 在url中传递会被当成路径符号，这里替换成[x]
 * 
 */
function replaceX(base64) {
	var regS = new RegExp("/", "gi");
	var s = base64.replace(regS, "[x]"); // 全部替换
	return s;
}

// 把srcStr中的targetStr替换成replaceStr
function replace(srcStr, targetStr, replaceStr) {
	var regS = new RegExp(targetStr, "gi");
	var s = srcStr.replace(regS, replaceStr); // 全部替换
	return s;
}

// 毫秒数 转换成 日期格式
function changeDateFormat(cellval) {
	var date = new Date(parseInt(cellval));
	var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date
			.getMonth()
			+ 1;
	var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date
			.getDate();
	// var hour=date.getHours()< 10 ? "0" + date.getHours() : date.getHours();
	// var mints=date.getMinutes()< 10 ? "0" + date.getMinutes() :
	// date.getMinutes();
	// var sec=date.getSeconds()< 10 ? "0" + date.getSeconds()
	// :date.getSeconds();
	return date.getFullYear() + "-" + month + "-" + currentDate;
}
 

function goURL(url) {
	location = url;
}

// 取得当前时间，表单没有变化的时候，提交到springmvc会提示404
function getTime() {
	var myDate = new Date();
	myDate.getYear(); // 获取当前年份(2位)
	myDate.getFullYear(); // 获取完整的年份(4位,1970-????)
	myDate.getMonth(); // 获取当前月份(0-11,0代表1月)
	myDate.getDate(); // 获取当前日(1-31)
	myDate.getDay(); // 获取当前星期X(0-6,0代表星期天)
	myDate.getTime(); // 获取当前时间(从1970.1.1开始的毫秒数)
	myDate.getHours(); // 获取当前小时数(0-23)
	myDate.getMinutes(); // 获取当前分钟数(0-59)
	myDate.getSeconds(); // 获取当前秒数(0-59)
	myDate.getMilliseconds(); // 获取当前毫秒数(0-999)
	// myDate.toLocaleDateString(); //获取当前日期
	// var mytime=myDate.toLocaleTimeString(); //获取当前时间
	// myDate.toLocaleString( ); //获取日期与时间
	// if (mytime<"23:30:00"){
	// alert(mytime);
	// }
	myDate = myDate.toLocaleDateString() + " " + myDate.toLocaleTimeString()
			+ "." + myDate.getMilliseconds();
	// alert(myDate);
	return myDate;

}
 

function winreload(win) {
	win.location.reload();
}


