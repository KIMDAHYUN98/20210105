// ajax1.js

$(function () {
    // ajax 호출
    $.ajax({
        url: '../data/MOCK_DATA.json', // 문자열로 실행할 파일 위치 경로
        dataType: 'json',
        success: showContent,
        error: function (result) {
            console.log('에러 : ' + result.statusText);
        }
    });

    // 버튼 이벤트
    $('#btn').click(addRow);

    //찾기 이벤트
    $('#findBtn').on('click', findRow());
});


$(function(){})
function findRow() {
    let findId = $('#find_id').val();
    let findRow = $('#' + findId).css('background-color', 'gray')
    // 신규 row 생성
    let tr = makeNewTR();
    findRow.before(tr);
}

function makeNewTR() {
    let inputs = $('.input_val');
    let tr = $('<tr />');
    $(tr).click(trToInputFunc)
    $(tr).hover(function () {
        $(this).css('background-color', 'yellow');
    }, function () {
        $(this).css('background-color', '');
    });
    for (let i = 0; i < inputs.length; i++) {
        let td = $('<td />').html(inputs[i].value);
        tr.append(td);
    }
    //findRow.before(tr);

    let btn = $('<button />');
    btn.html('삭제');
    tr.append(btn);
    $(btn).click(function () {
        $(tr).remove();
    })

    return tr;
}

function addRow() {
    let tr = makeNewTR();
    $('#tbl').append(tr);
}


function btnFunc() {
    console.log($(this));
    let tr = $('<tr />');
    let tdId = $('<td />').html($('#id').val());
    let tdFname = $('<td />').html($('#last_name').val());
    let tdLname = $('<td />').html($('#last_name').val());
    let tdEmail = $('<td />').html($('#email').val());
    let trVal = $(tr).append(tdId, tdFname, tdLname, tdEmail);
    $('#tbl').append(trVal);
}

function showContent(result) { // 실행될 콜백함수(성공), result = 매개값
    let headers = ['id', 'first_name', 'last_name', 'email'];
    let data = result;
    let table = $('<table id = "tbl" />').attr('border', '1');
    let title = $('<tr />');
    for (field of headers) {
        let td = $('<th />').html(field);
        title.append(td);
    }
    td = $('<th />');
    td.html('삭제');
    title.append(td);

    table.append(title);
    $(data).each(function (idx, obj) {
        if (idx < 5) {
            let tr = $('<tr />');
            $(tr).attr('id', obj.id);
            // $(tr).click(trToInputFunc);
            // $(tr).mouseover(function() { // 3.mouseout
            //     $(this).css('background-color', 'yellow');
            // })
            // $(tr).mouseout(function() {
            //     $(this).css('background-color', '');
            // })
            $(tr).on({
                'click': trToInputFunc,
                'mouseover': function () {
                    $(this).css('background-color', 'yellow');
                },
                'mouseout': function () {
                    $(this).css('background-color', '');
                }
            }); // --> end

            for (field of headers) {
                let td = $('<td />');
                td.html(obj[field]);
                tr.append(td);
            }

            // let btn = $('<button />');
            // btn.html('삭제');
            // tr.append(btn);
            // $(btn).click(function () {
            //     $(tr).remove();
            // })
            table.append(tr);
        }
    })
    $('#show').append(table);
}

function trToInputFunc() {
    console.log($(this).children().eq(1).html());
    $('#id').val($(this).children().eq(0).html());
    $('#first_name').val($(this).children().eq(1).html());
    $('#last_name').val($(this).children().eq(2).html());
    $('#email').val($(this).children().eq(3).html());
}


