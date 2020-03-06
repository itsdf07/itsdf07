/**
 * 请求数据开始
 */
$(function () {
    getGoods();
});

function getGoods(groupText) {
    $.ajax({
        url: "good/getGood",
        type: "post",
        contentType: "application/json",
        /*traditional:true,*/
        dataType: "json",
        data: JSON.stringify({group: groupText}),
        success: function (content) {
            console.log(content);
            if (content.code == 200) {
                let body = '';
                for (let i = 0; i < content.datas.length; i++) {
                    let dateT = new Date(content.datas[i].goodCreateDtime);
                    body += '<tr>';
                    body += '<td>' + content.datas[i].goodPicture + '</td>';
                    body += '<td>' + content.datas[i].goodName + '</td>';
                    body += '<td>' + content.datas[i].goodSku + '</td>';
                    body += '<td>' + content.datas[i].goodMark + '</td>';
                    body += '<td>' + dateFtt("yyyy-MM-dd hh-mm-ss", dateT) + '</td>';
                    body += '</tr>';
                }

                $("#goods_list_table_body").html(body);
            } else {
                alert(content.desc);
            }

        },
        beforeSend: function () {
        },
        complete: function (content, status) {
        }
    });
}

function addGoods() {
    let goodName = $("#id_goodName").val().trim();
    if ('' == goodName) {
        alert("商品名称不能为空");
        return;
    }
    let goodSku = $("#id_goodSku").val().trim();
    if ('' == goodSku) {
        alert("商品SKU不能为空");
        return;
    }
    let goodMark = $("#id_goodMark").val().trim();

    let goodObj = new Object();
    goodObj.goodName = goodName;
    goodObj.goodSku = goodSku;
    goodObj.mark = goodMark;
    console.log(JSON.stringify(goodObj));
    $.ajax({
        url: "good/addGood",
        type: "post",
        contentType: "application/json",
        /*traditional:true,*/
        dataType: "json",
        data: JSON.stringify(goodObj),
        success: function (content) {
            alert(content.desc)
            if (content.code == 200) {
                getGoods();
            }
        },
        beforeSend: function () {
        },
        complete: function (content, status) {
        }
    });
}

