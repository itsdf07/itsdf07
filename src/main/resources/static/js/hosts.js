/**
 * 请求数据开始
 */
$(function () {
    getHosts();
});

function getHosts(groupText) {
    $.ajax({
        url: "ping/hosts",
        type: "post",
        contentType: "application/json",
        /*traditional:true,*/
        dataType: "json",
        data: JSON.stringify({group: groupText}),
        success: function (content) {
            console.log(content.datas);
            let body = '';
            for (let i = 0; i < content.datas.length; i++) {
                let dateT = new Date(content.datas[i].createTime);
                body += '<tr>';
                body += '<td>' + content.datas[i].host + '</td>';
                body += '<td>' + content.datas[i].group + '</td>';
                body += '<td>' + dateFtt("yyyy-MM-dd hh-mm-ss", dateT) + '</td>';
                body += '</tr>';
            }

            $("#host_list_table_body").html(body);
        },
        beforeSend: function () {
        },
        complete: function (content, status) {
        }
    });
}

function addHosts() {
    let host = $("#id_host").val().trim();
    if ('' == host) {
        alert("填写的域名不能为空");
        return;
    }

    let groupObj = document.getElementById("host_group"); //定位id
    let groupIndex = groupObj.selectedIndex; // 选中索引
    let groupText = groupObj.options[groupIndex].text; // 选中文本
    let groupValue = groupObj.options[groupIndex].value; // 选中值
    console.log("新增Host：" + host + ",新增到了" + groupText + "分组[" + groupValue + "]中");
    if (groupValue == 0) {
        alert("请选择分组");
        return;
    }
    let hostObj = new Object();
    hostObj.host = host;
    hostObj.group = groupText;
    console.log(JSON.stringify(hostObj));
    console.log(JSON.stringify({host: host, group: groupText}));
    let hostList2Add = new Array();
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
            if (content.code == 200) {
                getHosts();
            }
        },
        beforeSend: function () {
        },
        complete: function (content, status) {
        }
    });
}

