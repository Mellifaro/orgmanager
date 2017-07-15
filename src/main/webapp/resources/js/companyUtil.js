function renderEditBtn(id){
    // return '<a class="btn btn-xs btn-primary" onclick="updateRow(id)">Edit</a>';
    return '<a class="teal-text" onclick="updateRow(id)"><i class="fa fa-pencil"></i></a>'
}

function renderDeleteBtn(id){
    return '<a class="btn btn-xs btn-danger" onclick="deleteRow(id)">Delete</a>';
}

function updateTable() {
    var table = $('#datatable');
    var data = $.ajax({
        type: 'GET',
        url: 'companies'
    });

    for(var i = 0; i < data.length; i++){
        printRaw(data[i], table);
    }
}

function printRaw(company, table) {
    // TODO fill table
    var children = company.listChildCompanies;
    for(var j = 0; j < children.length; j++){
        printRaw(children[j]);
    }
}