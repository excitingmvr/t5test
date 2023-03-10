document.write("<script src='/js/constants.js'></script>");
document.write("<script src='/js/validation.js'></script>");

$.datepicker.setDefaults($.datepicker.regional['ko']);
$("#shDateStart").datepicker({
    showMonthAfterYear: true,
    changeMonth: true,
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달',
    closeText:'취소',
    currentText: '오늘',
    showButtonPanel: true,
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dateFormat: "yy-mm-dd",
    onClose: function( selectedDate ) {
        $("#shDateEnd").datepicker( "option", "minDate", selectedDate );
    }
});

$("#shDateEnd").datepicker({
    showMonthAfterYear: true,
    changeMonth: true,
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달',
    closeText:'취소',
    currentText: '오늘',
    showButtonPanel: true,
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dateFormat: "yy-mm-dd",
    onClose: function( selectedDate ) {
        $("#shDateStart").datepicker( "option", "maxDate", selectedDate );
    }
});
