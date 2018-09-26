$(document).ready(function() {
    initData();
});

var example;
//加载初始化数据
function initData(){
    example =
    $('#odt-table').DataTable({
        "searching": false,
        "processing": false,
        "serverSide" : true,
        "destroy": true,
        "retrieve":true,
        "ajax": {
            url: "/orderThirdLevels",
            "dataType" : 'json',
            type: 'GET',
            "data":function(d){
                d.FIRST_LEVEL_ID = getParam();
            }
        },
        "dom": "<'dt-toolbar'r>t<'dt-toolbar-footer'<'col-sm-10 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-10' p v>>",
        "columns": [
            {"data" : "id", "defaultContent" : ""},
            {"data" : "FIRST_LEVEL_ID", "defaultContent" : ""},
            {"data" : "USER_CODE", "defaultContent" : ""},
            {"data" : "telephone", "defaultContent" : ""},
            {"data" : "SERIAL_NUMBER", "defaultContent" : ""},
            {"data" : "P_SERIAL_NUMBER", "defaultContent" : ""},
            {"data" : "PRODUCT_ORIGIN_PRICE", "defaultContent" : ""},
            {"data" : "PRODUCT_SALE_PRICE", "defaultContent" : ""},
            {"data" : "ORDER_STATUS", "defaultContent" : ""},
            {"data" : "ERROR_CODE", "defaultContent" : ""},
            {"data" : "PRODUCT_TYPE_ID", "defaultContent" : ""},
            {"data" : "PRODUCT_TYPE_NAME", "defaultContent" : ""},
            {"data" : "PRODUCT_NAME", "defaultContent" : ""},
            {"data" : "PRODUCT_CODE", "defaultContent" : ""},
            {"data" : "PRODUCT_IMG_URL", "defaultContent" : ""},
            {"data" : "PRODUCT_DESC", "defaultContent" : ""},
            {"data" : "BUY_NUM", "defaultContent" : ""},
            {"data" : "ACTIVITY_NAME", "defaultContent" : ""},
            {"data" : "MKT_INV_ID", "defaultContent" : ""},
            {"data" : "DATA_STATE", "defaultContent" : ""},

        ],
        "iDisplayLength": 10,
        "order": [[ 0, "asc" ]]
    } );
}

function getParam(){
    C1=window.location.href.split("?")[1];
    C2=C1.split("=")[1];
    return C2;
}

