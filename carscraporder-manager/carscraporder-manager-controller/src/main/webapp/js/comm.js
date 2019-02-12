(function ($) {
    loduserinfo();
})(jQuery);

function loduserinfo() {
    console.log("localStorage.username:" + localStorage.username)
    if (localStorage.username != "" && localStorage.username != null && localStorage.username != undefined) {
        $("#loginusername").text("用户名：" + localStorage.username)
    } else {
        window.location.href = "login.html"
    }
}
function loginout() {
    localStorage.username = "";
    window.location.href = "login.html"
}