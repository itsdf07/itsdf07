function addHosts() {
    var host = $("#id_host").val().trim();

    var groupObj = document.getElementById("host_group"); //定位id
    var groupIndex = groupObj.selectedIndex; // 选中索引
    var groupText = groupObj.options[groupIndex].text; // 选中文本
    var groupValue = groupObj.options[groupIndex].value; // 选中值
    console.log("新增Host：" + host + ",新增到了" + groupText + "分组[" + groupValue + "]中");
    var hostObj = new Object();
    hostObj.host = host;
    hostObj.group = groupText;
    console.log(JSON.stringify(hostObj));
    console.log(JSON.stringify({host: host, group: groupText}));
    var hostList2Add = new Array();
    hostList2Add.push({
        "host": host,
        "group": groupText
    })
    console.log(JSON.stringify({hostList2Add: hostList2Add}));
    $.ajax({
        url: "ping/addhost",
        type: "post",
        contentType: "application/json",
        /*traditional:true,*/
        dataType: "json",
        data: JSON.stringify(hostObj),
        success: function (content) {
            alert(content.desc)
        },
        beforeSend: function () {
        },
        complete: function (content, status) {
        }
    });
}