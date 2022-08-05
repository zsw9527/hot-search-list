//注意替换成实际后端服务器ip
var baiduUrl = "http://127.0.0.1:8085/hotSearch/baidu";
var weiboUrl = "http://127.0.0.1:8085/hotSearch/sina";
var toutiaoUrl = "http://127.0.0.1:8085/hotSearch/toutiao";

//从后端接口获取数据渲染到页面中
function getHotWord(name, url) {
    var httpRequest = new XMLHttpRequest();

    httpRequest.open('GET', url, true);
    httpRequest.send();
    /**
     * 获取数据后的处理程序
     */
    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            var json = httpRequest.responseText;

            var obj = JSON.parse(json);

            var str = ""
            for (var i = 0; i < obj.length; ++i) {
                if (i <= 2) {
                    //前三个热搜No图标
                    str += '<img src="img/NO.' + (i + 1) + '.png"' + ' width=30px;height=30px/>'
                    str += '<a style="text-decoration:none;color:black;" href=\"' + obj[i].url + '\">' +  obj[i].word + '</a>';

                    //前三个热搜加上带火的图标
                    str += '<img src="img/huo.png"  width="30px" height="30px"/>'
                } else {
                    str += '<a style="text-decoration:none;color:black;" href=\"' + obj[i].url + '\">' + (i + 1) + '.' + obj[i].word + '</a>';
                }
                //换行
                str += '<br><hr class="layui-border-green">'
            }
            //console.log(str);
            document.getElementById(name).innerHTML = str;
        }
    };
}

getHotWord('baidu', baiduUrl);
getHotWord('weibo', weiboUrl);
getHotWord('toutiao', toutiaoUrl);