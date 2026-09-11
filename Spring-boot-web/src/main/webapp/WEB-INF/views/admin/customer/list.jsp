<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>
    <div class="main-container" id="main-container">
        <script type="text/javascript">
            try {
                ace.settings.check("main-container", "fixed");
            } catch (e) {}
        </script>

        <div id="sidebar" class="sidebar responsive">
            <script type="text/javascript">
                try {
                    ace.settings.check("sidebar", "fixed");
                } catch (e) {}
            </script>
            <script type="text/javascript">
                try {
                    ace.settings.check("sidebar", "collapsed");
                } catch (e) {}
            </script>
        </div>

        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs" id="breadcrumbs">
                    <script type="text/javascript">
                        try {
                            ace.settings.check("breadcrumbs", "fixed");
                        } catch (e) {}
                    </script>
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="/admin/home">Home</a>
                        </li>
                        <li class="active">Danh sách khách hàng</li>
                    </ul>
                </div>

                <div class="page-content">
                    <div class="page-header">
                        <h1>Danh sách khách hàng</h1>
                    </div>
                    <div class="row">
                        <div class="widget-box" style="font-family: 'Times New Roman', Times, serif;">
                            <div class="widget-header">
                                <h4 class="widget-title">Tìm kiếm</h4>
                                <span class="widget-toolbar">
                                    <a href="#" data-action="reload">
                                        <i class="ace-icon fa fa-refresh"></i>
                                    </a>
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                    <a href="#" data-action="close">
                                        <i class="ace-icon fa fa-times"></i>
                                    </a>
                                </span>
                            </div>

                            <div class="widget-body" style="display: block">
                                <div class="widget-main">
                                    <form:form id="listForm" modelAttribute="modelSearch" action="/admin/customer-list" method="get">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="col-xs-6">
                                                    <label>Tên khách hàng</label>
                                                    <form:input path="fullName" class="form-control"></form:input>
                                                </div>
                                                <div class="col-xs-6">
                                                    <label>Email</label>
                                                    <form:input path="email" class="form-control"></form:input>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="col-xs-6">
                                                    <label>Di động</label>
                                                    <form:input path="phone" class="form-control"></form:input>
                                                </div>
                                                <div class="col-xs-6">
                                                    <label>Tình trạng</label>
                                                    <form:select path="status" class="form-control">
                                                        <option value="">---Chọn tình trạng---</option>
                                                        <c:forEach var="it" items="${statusList}">
                                                            <form:option value="${it.key}">${it.value}</form:option>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <label>Nhân viên quản lý</label>
                                                        <form:select path="staffId" class="form-control">
                                                            <option value="">---Chọn nhân viên---</option>
                                                            <c:forEach var="it" items="${staffList}">
                                                                <form:option value="${it.key}">${it.value}</form:option>
                                                            </c:forEach>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </security:authorize>
                                            <div class="col-xs-12">
                                                <br>
                                                <div class="col-xs-2">
                                                    <button class="btn btn-success" id="btn-search">
                                                        <i class="ace-icon glyphicon glyphicon-search"></i>
                                                        Tìm kiếm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <div class="pull-right">
                            <a href="/admin/customer-edit">
                                <button class="btn btn-app btn-primary btn-sm" title="Thêm khách hàng">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>
                                </button>
                            </a>
                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-app btn-danger btn-sm" title="Xóa tòa nhà" id="btn-deleteCustomer">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>
                                </button>
                            </security:authorize>
                        </div>
                    </div>
                    <div class="hr hr-18 dotted hr-double"></div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <display:table name="model.listResult" cellpadding="0" cellspacing="0"
                                           requestURI="${formUrl}" partialList="true" sort="external"
                                           size="${model.totalItem}" defaultsort="2" defaultorder="ascending"
                                           id="tableList" pagesize="${model.maxPageItems}"
                                           export="false"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">
                                <display:column title="<fieldset class='form-group'>
                                                        <input type='checkbox' id='checkAll' class='check-box-element'>
                                                        </fieldset>" class="center select-cell"
                                                headerClass="center select-cell">
                                    <fieldset>
                                        <input type="checkbox" name="checkList" value="${tableList.id}"
                                                id="checkbox_${tableList.id}" class="check-box-element"/>
                                    </fieldset>
                                </display:column>
                                <display:column headerClass="text-center" property="fullName" title="Tên khách hàng"/>
                                <display:column headerClass="text-center" property="phone" title="Di động"/>
                                <display:column headerClass="text-center" property="email" title="Email"/>
                                <display:column headerClass="text-center" property="demand" title="Nhu cầu"/>
                                <display:column headerClass="text-center" property="createdBy" title="Người thêm"/>
                                <display:column headerClass="text-center" property="createdDate" title="Ngày thêm"/>
                                <display:column headerClass="text-center" property="status" title="Tình trạng"/>
                                <display:column headerClass="col-actions" title="Thao tác">
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <security:authorize access="hasRole('MANAGER')">
                                            <button class="btn btn-xs btn-success" onclick="assignmentCustomer(${tableList.id})" title="Giao khách hàng">
                                                    <i class="ace-icon fa fa-check"></i>
                                            </button>
                                        </security:authorize>
                                        <button class="btn btn-xs btn-info" onclick="updateEachCustomer(${tableList.id})" title="Sửa khách hàng">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                        </button>
                                        <security:authorize access="hasRole('MANAGER')">
                                            <button class="btn btn-xs btn-danger" onclick="deleteCustomer(${tableList.id})" title="Xóa khách hàng">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </security:authorize>
                                    </div>
                                </display:column>
                            </display:table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <form:form modelAttribute="modelSearch" action="/admin/customer-list" class="modal" id="assignmentCustomerModal" style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title center">Danh sách nhân viên</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table id="staff-list" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th class="center">Họ tên nhân viên</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="btn-assignmentCustomer">Giao tòa nhà</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                </div>
            </div>
        </div>
        <input type="hidden" id="customerId" value="">
    </form:form>
</div>

<script src="assets/js/jquery.2.1.1.min.js"></script>
<script>
    $('#btnSearch').click(function (e){
        e.preventDefault();
        $('#listForm').submit();
    });

    function assignmentCustomer(id){
        $('#customerId').val(id);
        $('#assignmentCustomerModal').modal();
        loadStaff(id);
    }

    function loadStaff(id){
        $.ajax({
            url: "/api/admin/customers/" + id + "/staffs",
            type: "GET",
            dataType: "JSON",
            success: function (response){
                console.log(response.data);
                var row = '';
                $.each(response.data, function (index, item){
                    var isChecked = (item.checked === 'checked' || item.checked === true) ? 'checked' : "";
                    row += '<tr>';
                    row += '<td class="center">';
                    row += '<label class="pos-rel">';
                    row += '<input type="checkbox" class="ace" value="' + item.id + '" ' + isChecked + '>';
                    row +='<span class="lbl"></span>';
                    row += '</label>';
                    row += '</td>';
                    row += '<td class="center">' + item.fullName + '</td>';
                    row += '</tr>';
                });
                $('#staff-list tbody').html(row);
            },
            error: function (response){
                console.log('Lỗi tải danh sách nhân viên');
            }
        })
    }

    $('#btn-assignmentCustomer').click(function (e){
        e.preventDefault();
        var json = {};
        json['customerId'] = $('#customerId').val();
        var staffIds = $('#staff-list').find('tbody input[type = checkbox]:checked').map(function (){
            return $(this).val();
        }).get();
        json['staffIds'] = staffIds;
        if(json['staffIds'] != '' || json['staffIds'].length != 0)
            updateAssignment(json);
        else
            alert("Không thể sửa !");
    })

    function updateAssignment(data){
        $.ajax({
            url: "/api/admin/customerassignments",
            type: "POST",
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function (response){
                alert("Giao khách hàng thành công !");
                location.reload();
            },
            error: function (response){
                console.error("Lỗi:", response);
                alert("Giao khách hàng thất bại !");
            }
        })
    }

    $("#")

    function deleteCustomer(id){
        if (confirm("Bạn có chắc chắn muốn xóa khách hàng này?")) {
            deleteCustomers([id]);
        }
    }

    $('#btn-deleteCustomer').click(function (e){
        e.preventDefault();
        var ids = $('#tableList').find('tbody input[type = checkbox]:checked').map(function (){
            return $(this).val();
        }).get();
        if(ids.length === 0){
            alert("Vui lòng chọn ít nhất 1 khách hàng để xóa!")
            return
        }
        if (confirm("Bạn có chắc chắn muốn xóa " + ids.length + " khách hàng đã chọn?")) {
            deleteCustomers(ids);
        }
    })

    function deleteCustomers(ids){
        $.ajax({
            url: "/api/admin/customer-list",
            type: "DELETE",
            data: JSON.stringify(ids),
            contentType: 'application/json',
            success: function (response) {
                console.log("success");
                alert("Xóa thành công !");
                location.reload();
            },
            error: function (response) {
                console.log("failed");
                alert("Xóa không thành công !");
            }
        })
    }

    function updateEachCustomer(id){
        window.location.href = "/admin/customer-edit?id=" + id;
    }

</script>
</body>
</html>
