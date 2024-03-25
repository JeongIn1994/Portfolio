const getCurrentDate = () => {
    const now = new Date();
    const year = now.getFullYear();
    const month = (now.getMonth() + 1).toString().padStart(2, '0');
    const day = now.getDate().toString().padStart(2, '0');

    return `${year}-${month}-${day}`;
}
const setProgress = (endDate) => {
    let result;
    if(endDate > getCurrentDate()){
        result = 1;
    }else if(endDate <= getCurrentDate()){
        result = 0;
    }
    return result
}

const main = {
    init: () => {
        $('#btn-save').on('click', () => main.save());
        $('#btn-update').on('click', () => main.update());
        $('#btn-delete').on('click', () => main.delete())
    },
    save: () => {

        const data = {
            title: $('#title').val(),
            language: $('#selectedLanguage').val(),
            content: editor.getHTML(),
            summary: $("#summary").attr("src").split("/display?fileName=")[1],
            start_date: new Date($("#start_date").val()).toISOString(),
            end_date: new Date($("#end_date").val()).toISOString(),
            progress: setProgress($("#end_date").val())

        };

        console.log(data);

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            })
            .done(() => {
                alert('Resist Was Done!');
                window.location.href = '/history/list';
            })
            .fail((error) => {
                alert(JSON.stringify(error));
            });
    },
    update:() => {
        const data = {
            title: $('#title').val(),
            language: $('#selectedLanguage').val(),
            content: editor.getHTML(),
            summary: $("#summary").attr("src").split("/display?fileName=")[1],
            start_date: $("#start_date").val(),
            end_date: $("#end_date").val(),
            progress: setProgress($("#end_date").val())

        };

        const id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
            }).done(() => {
                alert('Update Was Done!');
                window.location.href = document.referrer;
            })
            .fail((error) => {
                alert(JSON.stringify(error));
            });
    },

    delete : () => {
        const id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
            }).done(() => {
                alert('Delete Was Done!');
                window.location.href = "/history/list";
            })
            .fail((error) => {
                alert(JSON.stringify(error));
            });
    }
};

main.init();