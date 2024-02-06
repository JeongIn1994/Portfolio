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
            // content: $('#content').val()
            content: escapeHtml(CKEDITOR.instances.content.getData()),
            summary: $("#summary").attr("src").split("/display?fileName=")[1],
            start_date: $("#start_date").val(),
            end_date: $("#end_date").val()

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
            content: $('#content').val()
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
                window.location.href = '/';
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
                window.location.href = '/';
            })
            .fail((error) => {
                alert(JSON.stringify(error));
            });
    }
};

function escapeHtml(unsafe) {
    return unsafe
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}

main.init();