/**
 * 分类联动功能的js
 */

layui.config({
    base: '/js/',
});

/**
 * 获得二级分类信息
 */
layui.use(['interact'],function(){
    var linkageData = [];		//分类联动信息数据
    $.ajax({
        type : 'get',
        url : '/categorys/twoLinkage',
        async: false,
        success: function (data) {
            linkageData = JSON.stringify(data);     //将JSON对象转换为字符串
            linkageData = JSON.parse(linkageData);      //将字符串转换为数组
        }
    });
    var interact = layui.interact;
    interact.render({
        elem : '.twoLinkage',
        categoryname : '选择父级分类',
        data : linkageData,
        name : 'parentids'
    });
});

/**
 * 处理表格中获取的数据
 * @param formdata
 * @returns {*}
 */
function formdataHandler(formdata) {
    var parentids = formdata["parentids[]"];
    id = 0;
    for(var i=0; i<parentids.length; i++) {
        if(parentids[i] !== "") {
            id = parentids[i];
        }
    }
    delete formdata["parentids[]"];
    formdata.parentid = id;
    return formdata;
}