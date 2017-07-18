var form;

$(document).ready(function() {
    form = $('#detailsForm');

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });

    updateTable();
    form.submit(function () {
        save();
        return false;
    });
});

function renderAddChildBtn(parentId){
    var addChildText = 'Add child company';
    return '<a class="btn btn-xs btn-primary" onclick="addCompany(' + parentId + ')">Add child</a>';
    // return '<a class="teal-text" onclick="updateRow(id)"><i class="fa fa-pencil"></i></a>'
}

function renderEditBtn(id){
    return '<a class="btn btn-xs btn-primary" onclick="editCompany(' + id + ')">Edit</a>';
    // return '<a class="teal-text" onclick="updateRow(id)"><i class="fa fa-pencil"></i></a>'
}

function renderDeleteBtn(id){
    return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + id + ')">Delete</a>';
}

function updateTable() {
    var tbody = $('#datatable > tbody');
    $.ajax({
        type: 'GET',
        url: 'rest/companies',
        success: function (data) {
            tbody.empty();
            for(var i = 0, depth = 1; i < data.length; i++){
                printRaw(data[i], tbody, depth);
            }
        },
        error: function () {
            alert("error");
        }
    });
}

function printRaw(company, tbody, depth) {
    var nameWithDepth = '';
    nameWithDepth = nameWithDepth + '<tr><td>';
    for(var k = 0; k < depth; k++){
        nameWithDepth = nameWithDepth + '--';
    }
    tbody.append(nameWithDepth + company.name + '</td>'
                +'<td>' + company.earnings + '</td>'
                +'<td>' + company.totalEarnings + '</td>'
                +'<td>' + renderAddChildBtn(company.id) + '</td>'
                +'<td>' + renderEditBtn(company.id) +'</td>'
                +'<td>' + renderDeleteBtn(company.id) +'</td>'
                +'</tr>'
    );
    
    var children = company.listChildCompanies;
    depth++;
    for(var j = 0; j < children.length; j++){
        printRaw(children[j], tbody, depth);
    }
}

function addCompany(parentId){
    $('#detailsForm').find(":input").val("");
    $('#detailsForm').find("input[name='parentId']").val(parentId);
    $('#modalTitle').html('Add company');
    $('#editRow').modal();
}

function editCompany(id){
    $('#modalTitle').html('Edit company');
    $.get('rest/companies/' + id, function (data) {
        $.each(data, function (key, value) {
            $('#detailsForm').find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function save(){
    $.ajax({
        type: 'POST',
        url: 'rest/companies',        
        data: $('#detailsForm').serialize(),
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

function deleteRow(id) {
    $.ajax({
        url: 'rest/companies/' + id,
        type: 'DELETE',
        success: function(){
            updateTable();
            successNoty('Deleted');
        }
    })
}

var failedNote;

function closeNoty() {
    if(failedNote){
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        timeout: 2000,
        layout: 'bottomRight'
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + '<br>' + jqXHR.responseText,
        type: 'error',
        layout: 'bottomRight'
    });
}