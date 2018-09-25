var pers = checkPermission();

layui.use(['layer','laydate'], function(){
    var layer = layui.layer;
    var laydate = layui.laydate;
    laydate.render({
        elem: '#paytime1'
    });
    laydate.render({
        elem: '#paytime2'
    });
});
var example;
function init(){
    example =
        $('#dt-table').DataTable({
            "searching": false,
            "processing": false,
            "serverSide" : true,
            "ajax": {
                "url" : "/orderFirstLevels",
                "type":"get",
                "data":function(d){
                    d.telephone = $("#telephone").val();
                    d.serialnumber = $("#serialnumber").val();
                    d.paytime1 = $("#paytime1").val();
                    d.paytime2 = $("#paytime2").val();
                }
            },
            "dom": "<'dt-toolbar'r>t<'dt-toolbar-footer'<'col-sm-10 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-10' p v>>",
            "columns": [
                {"data" : "id", "defaultContent" : ""},
                {"data" : "serialnumber", "defaultContent" : ""},
                {"data" : "usercode", "defaultContent" : ""},
                {"data" : "createtime", "defaultContent" : ""},
                {"data" : "telephone", "defaultContent" : ""},
                {"data" : "paytime", "defaultContent" : ""},
                {"data" : "sendtime", "defaultContent" : ""},
                // {"data" : "replytime", "defaultContent" : ""},
                {"data" : "orderpreprice", "defaultContent" : ""},
                {"data" : "orderrealprice", "defaultContent" : ""},
                {"data" : "orderno", "defaultContent" : ""},
                {"data" : "paystatus", "defaultContent" : ""},
                {"data" : "failreason", "defaultContent" : ""},
                {"data" : "paytype", "defaultContent" : ""},
                {"data" : "payurl", "defaultContent" : ""},
                // {"data" : "ordercomment", "defaultContent" : ""},
                // {"data" : "datastate", "defaultContent" : ""}
                {
                    "data": "",
                    "defaultContent": "",
                    "orderable":false,
                    "render": function (data, type, row) {
                        var id = row['id'];
                        var href = "updateOrderFirstLevel.html?id=" + id;
                        var href2 = "orderThirdLevelList.html?id=" + id;
                        var edit = buttonEdit(href, "", pers);
                        var del = buttonDel(id, "", pers);
                        var about = buttonAbout(href2, "", pers);
                        return edit + del + about;
                    }
                },

            ],
            "iDisplayLength": 3,
            "order": [[ 0, "asc" ]]
        } );
}




function  setchart() {

    var myCharttoday=echarts.init(document.getElementById("echartToday"))  ;
    var myChart=echarts.init(document.getElementById("echart"))  ;
    option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            show:false,
            orient : 'vertical',
            x : 'left',
            data:['支付宝','微信','建设银行']
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'center',
                            max: 1548
                        }
                    }
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'访问来源',
                legendHoverLink:false,//是否启用图例 hover 时的联动高亮。
                type:'pie',
                radius : ['50%', '70%'],
                itemStyle : {
                    normal : {
                        label : {
                            show : false
                        },
                        labelLine : {
                            show : false
                        }
                    },
                    emphasis : {
                        label : {
                            show : true,
                            position : 'center',
                            textStyle : {
                                fontSize : '30',
                                fontWeight : 'bold'
                            }
                        }
                    }
                },
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                lableLine: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                    {value:335, name:'微信'},
                    {value:310, name:'支付宝'},
                    {value:234, name:'建设银行'}

                ]
            }
        ]
    };


    optiontoday = {
        title : {
            text: '',
            subtext: ''
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['食品','非食品']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'销售额',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            },
            {
                name:'销售额',
                type:'bar',
                data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                markPoint : {
                    data : [
                        {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                        {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            }
        ]
    };



    myChart.setOption(option)  ;
    myCharttoday.setOption(optiontoday)  ;

}


function del(id){
    layer.confirm('确定要删除吗？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            type : 'delete',
            url : '/orderFirstLevels/'+id,
            success : function(data) {
                example.ajax.reload();
                layer.msg("删除成功");
            }
        });

        layer.close(1);
    });
}



layui.use('layer', function(){
    var layer = layui.layer;
});
$(document).ready(function() {
    $("#searchBt").click(function(){
        example.ajax.reload();
    });

    init();
    setchart();
});
