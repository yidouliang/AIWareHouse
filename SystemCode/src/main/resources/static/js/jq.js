$.ajaxSetup({
	cache : false,
	headers : {
		"token" : localStorage.getItem("token")
	},
	error : function(xhr, textStatus, errorThrown) {
		var msg = xhr.responseText;
		var response = JSON.parse(msg);
		var code = response.code;
		var message = response.message;
		if (code == 400) {
			layer.msg(message);
		} else if (code == 401) {
			localStorage.removeItem("token");
			location.href = '/login.html';
		} else if (code == 403) {
			console.log("未授权:" + message);
			layer.msg('未授权');
		} else if (code == 500) {
			layer.msg('系统错误：' + message);
		}
	}
});

function buttonDel(data, permission, pers){
	if(permission != ""){
		if ($.inArray(permission, pers) < 0) {
			return "";
		}
	}
	
	var btn = $("<button class='layui-btn layui-btn-xs' title='删除' onclick='del(\"" + data +"\")'><i class='layui-icon'>&#xe640;</i></button>");
	return btn.prop("outerHTML");
}

function buttonEdit(href, permission, pers){
	if(permission != ""){
		if ($.inArray(permission, pers) < 0) {
			return "";
		}
	}
	
	var btn = $("<button class='layui-btn layui-btn-xs' title='编辑' onclick='window.location=\"" + href +"\"'><i class='layui-icon'>&#xe642;</i></button>");
	return btn.prop("outerHTML");
}

function buttonAbout(href, permission, pers){
    if(permission != ""){
        if ($.inArray(permission, pers) < 0) {
            return "";
        }
    }
    var btn = $("<button class='layui-btn layui-btn-xs' title='详情' onclick='window.location=\"" + href +"\"'><i class='layui-icon'>查看详情</i></button>");
    return btn.prop("outerHTML");
}

function buttonCreate(href, permission, pers){
    if(permission != ""){
        if ($.inArray(permission, pers) < 0) {
            return "";
        }
    }
    var btn = $("<button class='layui-btn layui-btn-xs' title='添加盒子' onclick='window.location=\"" + href +"\"'><i class='layui-icon'>添加盒子</i></button>");
    return btn.prop("outerHTML");
}

function buttonCreateWare(href, permission, pers){
    if(permission != ""){
        if ($.inArray(permission, pers) < 0) {
            return "";
        }
    }
    var btn = $("<button class='layui-btn layui-btn-xs' title='添加仓库' onclick='window.location=\"" + href +"\"'><i class='layui-icon'>添加仓库</i></button>");
    return btn.prop("outerHTML");
}




function deleteCurrentTab(){
	var lay_id = $(parent.document).find("ul.layui-tab-title").children("li.layui-this").attr("lay-id");
	parent.active.tabDelete(lay_id);
}
