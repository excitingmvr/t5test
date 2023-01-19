let goUrlInst = "/infra/codegroup/codeGroupInst";               /*###*/
let goUrlUpdt = "/infra/codegroup/codeGroupUpdt";               /*###*/
let goUrlDele = "/infra/codegroup/codeGroupDele";               /*###*/
let goUrlList = "/infra/codegroup/codeGroupList";               /*###*/
let goUrlUele = "/infra/codegroup/codeGroupUele";               /*###*/

let seq = document.querySelector("input[name=ifcgSeq]");        /*###*/
let form = document.querySelector("form[name=formList]");       /*###*/

validationInst = function() {
    if(validationUpdt() == false) return false;
}
function validationUpdt() {
    if(!checkOnlyEnglishNumber('ifcgSeqAnother', 2, 1, "코드그룹 코드 (Another)는 영대소문자, 숫자만 입력 가능합니다.")) return false;
    if(!checkOnlyKoreanEnglishNumber('ifcgName', 2, 0, "코드그룹 이름은 한글, 영문대소문자, 숫자만 입력 가능합니다.")) return false;
    if(!checkOnlyEnglishNumber('ifcgNameEng', 2, 1, "코드그룹 이름 (영문)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
    if(!checkOnlyNumber('ifcgOrder', 2, 0, 1, 0, 255, "순서는 숫자(0~255)만 입력 가능합니다.")) return false;
    if(!checkOnlyEnglishNumber('ifcgReferenceV1', 2, 1, "예비1 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
    if(!checkOnlyEnglishNumber('ifcgReferenceV2', 2, 1, "예비2 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
    if(!checkOnlyEnglishNumber('ifcgReferenceV3', 2, 1, "예비3 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
    if(!checkOnlyEnglishNumber('ifcgReferenceV4', 2, 1, "예비4 (varchar type)은 영문대소문자, 숫자만 입력 가능합니다.")) return false;
    if(!checkOnlyNumber('ifcgReferenceI1', 2, 1, 1, -128, 127, "예비1 (Int type)은 숫자(-128~127)만 입력 가능합니다.")) return false;
    if(!checkOnlyNumber('ifcgReferenceI2', 2, 1, 1, -128, 127, "예비2 (Int type)은 숫자(-128~127)만 입력 가능합니다.")) return false;
    if(!checkOnlyNumber('ifcgReferenceI3', 2, 1, 1, -128, 127, "예비3 (Int type)은 숫자(-128~127)만 입력 가능합니다.")) return false;
    if(!checkOnlyNumber('ifcgReferenceI4', 2, 1, 1, -128, 127, "예비4 (Int type)은 숫자(-128~127)만 입력 가능합니다.")) return false;
}

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
