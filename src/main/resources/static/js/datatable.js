
const dataTableOptions = {
        columnDefs: [
        {orderable: false, targets: [1, 2, 3]},
        {searchable: false, targets: [1, 2]}
        ],
        destroy: true,
        language: {
        lengthMenu: "Mostrar _MENU_ registros por página",
                zeroRecords: "Ningún usuario encontrado",
                info: "Mostrando de _START_ a _END_ de un total de _TOTAL_ registros",
                infoEmpty: "Ningún usuario encontrado",
                infoFiltered: "(filtrados desde _MAX_ registros totales)",
                search: "Buscar:",
                loadingRecords: "Cargando...",
                paginate: {
                first: "Primero",
                        last: "Último",
                        next: "Siguiente",
                        previous: "Anterior"
                }
        }
                                };

                                dataTable = $("#myTabla").DataTable(dataTableOptions);
                                

