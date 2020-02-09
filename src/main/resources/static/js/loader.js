//用于统一封装加载jQuery以及bootstrap对应的css以及js文件，供html简洁调用加载
/**
 *获取项目URL路径
 * @returns {string}
 */
function getRootPath() {
    //如：http://localhost:8087/itsdf07/
    var curWWWPath = window.document.location.href;
    //如：/itsdf07/
    var pathName = window.document.location.pathname;
    //如：21
    var pos = curWWWPath.indexOf(pathName);
    //如：http://localhost:8087
    var localHostPath = curWWWPath.substring(0, pos);
    //如：/itsdf07
    var projectName = pathName.substring(0, pathName.substring(1).indexOf('/') + 1);
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

