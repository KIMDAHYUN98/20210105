$(function () {
    // ajax 호출.
    $.ajax({
        url: '../data/MOCK_DATA.json',
        dataType: 'json',
        success: showContent,
        error: function (result) {
            console.log('에러: ' + result.statusText);
        }
    });
    // button 클릭 이벤트
    $('#btn').on('click', function() {
        $('input:checked').parent().parent().css('background-color', 'red'); 
        // 첫번째 parent : tr, 두번째 parent : td
        // input 태그의 checked는 뛰어쓰기 X
    });
    // all_check 클릭 이벤트.
    $('body').on('click','#all_check', function() {
        console.log('checked');
        // $('id > input').prop('checked', $('#all_check').is(":checked"));
        if($('#all_check').is(":checked"))
            $('td > input').prop('checked', true);
        else
            $('td > input').prop('checked', false);
    })
    $('body').on('click', '#id', function() {
        if($('#id').is(":checked")) {
            $('#all_check').prop('checked', true);
        } else {
            $('#all_check').prop('checked', false);
        }
    })
});

function showContent(result) {
    let headers = ['chkbox', 'id', 'first_name', 'last_name', 'email'];
    let data = result;
    let table = $('<table id="tbl" />').attr('border', '1');
    let titles = $('<tr />');
    for (field of headers) {
        let td;
        if(field == 'chkbox') {
            let chkbox = $('<input />').attr('type', 'checkbox').attr('id', 'all_check');
            td = $('<th />').append(chkbox);
        } else {
            td = $('<th />').html(field.replace('_', ' ').toUpperCase());
            
        }
        td.css('height', '40px');
        titles.append(td);
    }
    table.append(titles);

    $(data).each(function (idx, obj) {
        if (idx < 5) {
            let tr = $('<tr />');
            $(tr).attr('id', obj.id);
            $(tr).hover(function () {
                $(this).css('background-color', 'yellow');
            }, function () {
                $(this).css('background-color', '');
            });
            for (field of headers) {
                let td = $('<td />');
                if(field == 'chkbox') {
                    let checkbox = $('<input />')
                    .attr('type', 'checkbox');
                    td.attr('align', 'center');
                    checkbox.attr('id', 'id');

                    td.append(checkbox);
                }else{ 
                    td.html(obj[field]);
                
                }
                tr.append(td);
            }
            table.append(tr);
        }
    })
    $('#show').append(table);

    // $('#all_check').on('click', function() {
    //     console.log('checked');
    // })
}