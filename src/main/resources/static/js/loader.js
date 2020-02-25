//用于统一封装加载jQuery以及bootstrap对应的css以及js文件，供html简洁调用加载
/**
 *获取项目URL路径
 * @returns {string}
 */
function getRootPath() {
    //如：http://localhost:8087/itsdf07/
    let curWWWPath = window.document.location.href;
    //如：/itsdf07/
    let pathName = window.document.location.pathname;
    //如：21
    let pos = curWWWPath.indexOf(pathName);
    //如：http://localhost:8087
    let localHostPath = curWWWPath.substring(0, pos);
    //如：/itsdf07
    let projectName = pathName.substring(0, pathName.substring(1).indexOf('/') + 1);
    console.log("curWWWPath:" + curWWWPath);
    console.log("pathName:" + pathName);
    console.log("pos:" + pos);
    console.log("localHostPath:" + localHostPath);
    console.log("projectName:" + projectName);
    return (localHostPath + projectName);
}

//引入jquery
document.write('<script src="' + getRootPath() + '/js/jquery-3.3.1.min.js"></script>');
//引入bootstrap
document.write('<script src="' + getRootPath() + '/js/bootstrap.min.js"></script>');
document.write('<link rel="stylesheet" href="' + getRootPath() + '/css/bootstrap.min.css"/>');
document.write('<link rel="stylesheet" href="' + getRootPath() + '/css/style.css"/>');


/**
 * 时间格式，如2019-11-22 16-32-04
 * @param fmt
 * @param date
 * @returns {void | string}
 */
function dateFtt(fmt, date) {
    let o = {
        "M+": date.getMonth() + 1,                 //月份
        "d+": date.getDate(),                    //日
        "h+": date.getHours(),                   //小时
        "m+": date.getMinutes(),                 //分
        "s+": date.getSeconds(),                 //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (let k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/**
 * 判断字符串为空
 * @param content
 * @returns {boolean}
 */
function isEmpty(content) {
    if (typeof content == "undefined" || content == null || content == "") {
        return true;
    } else {
        return false;
    }
}


