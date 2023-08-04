const main = {
    init: () => {
        $('#btn-save').on('click', () => main.save());
    },
    save: () => {
        const data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts/',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        })
            .done(() => {
                alert('Resist Was Done!');
                window.location.href = '/';
            })
            .fail((error) => {
                alert(JSON.stringify(error));
            });
    }
};

main.init();