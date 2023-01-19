let goUrlList = "/infra/codegroup/codeGroupAjaxList";               /*###*/
let goUrlLita = "/infra/codegroup/codeGroupAjaxLita";               /*###*/
let goUrlMultiUele = "/infra/codegroup/codeGroupMultiUele";         /*###*/
let goUrlMultiDele = "/infra/codegroup/codeGroupMultiDele";         /*###*/
let goUrlAjaxList = "/infra/codegroup/codeGroupAjaxList?thisPage="; /*###*/
let goUrlForm = "/infra/codegroup/codeGroupForm";                   /*###*/

let seq = document.querySelector("input[name=ifcgSeq]");        /*###*/
let form = document.querySelector("form[name=formList]");
let checkboxSeqArray = [];

window.addEventListener('load', function() {
    setLita();
});

document.getElementById("btnShowHide").onclick = function () {
    let wrap = document.getElementById("searchWrap");
    let viewBtn = document.getElementById("btnShowHide");

    if(wrap.style.display == "none" && viewBtn.innerHTML == '<i class="fa fa-chevron-down"></i>') {
        wrap.style.display = "block";
        viewBtn.innerHTML = '<i class="fa fa-chevron-up"></i>'
    } else {
        wrap.style.display = "none";
        viewBtn.innerHTML = '<i class="fa fa-chevron-down"></i>'
    }
}

document.getElementById("btnReset").onclick = function () {
    form.href = goUrlList;
    form.submit();
}

document.getElementById("btnSearch").onclick = function(){
    form.action = goUrlList;
    form.submit();
};

function setLita() {
    $.ajax({
        async: true
        ,cache: false
        ,type: "post"
        ,url: goUrlLita
        ,data : $("#formList").serialize()
        ,success: function(response) {
            $("#ajaxList").html(response);
            let thisPage = $("input[name=thisPage]").val();
            history.pushState({data: response}, null, goUrlAjaxList + thisPage);
        }
        ,error : function(jqXHR, textStatus, errorThrown){
            alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
        }
    });
}

$(window).on('popstate', function(event) {
    let data = event.originalEvent.state;
    $('#ajaxList').html(data.data);
});