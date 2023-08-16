const main = {
    init: () => {
        $('#btn-save').on('click', () => main.save());

        $('#btn-update').on('click', () => main.update());
        $('#btn-delete').on('click', () => main.delete())
    },
    save: () => {

        const data = {
            title: $('#title').val(),
            user_name: $('#user_name').val(),
            // content: $('#content').val()
            content: CKEDITOR.instances.content.getData()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
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

main.init();