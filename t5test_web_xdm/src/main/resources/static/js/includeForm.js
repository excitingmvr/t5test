let form = document.querySelector("form[name=formList]");       /*###*/

document.getElementById("btnDelete").onclick = function () {
    document.querySelector(".modal-title").textContent = "확 인";
    document.querySelector(".modal-body").textContent = "해당 데이터를 삭제하시겠습니까 ?";
    document.querySelector("#btnModalUelete").style.display = 'none';
    document.querySelector("#btnModalDelete").style.display = '';
}

document.getElementById("btnUelete").onclick = function () {
    document.querySelector(".modal-title").textContent = "확 인";
    document.querySelector(".modal-body").textContent = "해당 데이터를 삭제하시겠습니까 ?";
    document.querySelector("#btnModalUelete").style.display = '';
    document.querySelector("#btnModalDelete").style.display = 'none';
}

document.getElementById("btnModalUelete").onclick = function () {
    form.action = goUrlUele;
    form.submit();
}

document.getElementById("btnModalDelete").onclick = function () {
    form.action = goUrlDele;
    form.submit();
}

document.getElementById("btnList").onclick = function () {
    form.action = goUrlList;
    form.submit();
}

document.getElementById("btnSubmit").onclick = function () {
    if(seq.value == "0" || seq.value == "") {
        if(validationInst() == false) return false;
        form.action = goUrlInst;
        form.submit();
    } else {
        if(validationUpdt() == false) return false;
        form.action = goUrlUpdt;
        form.submit();
    }
}
