$(function() {

    $("#searchBar").autocomplete({
        source: function(request, response) {
            $.ajax({
                url: "http://localhost:8080/elastic/find/"+request.term.toLowerCase(),
                type: "GET",
                dataType: "JSON",
                success: function(data) {
                    $('#auto_complete_options')
                        .find('option')
                        .remove()
                        .end()
                    $.each(data, function() {
                        var id_ ;
                        $.each(this, function(k, v) {
                            debugger
                            if(Number.isInteger(k) && v.title != null) {
                                id_ = v.id;

                                    $("#auto_complete_options").append('<option value=http://localhost:8080/link/' + id_ + '><a href="http://localhost:8080/link/"' + id_ + '>' + v.title + '</a></option>');

                            } });
                    });
                },
            });
        },
        minLength: 2
    })

});