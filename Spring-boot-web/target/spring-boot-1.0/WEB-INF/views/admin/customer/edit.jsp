<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>
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
                    <a href="#">Home</a>
                </li>
                <li class="active">Chỉnh sửa khách hàng</li>
            </ul>
        </div>
        <div class="page-content">
            <div class="page-header">
                <h1>
                    Thông tin khách hàng
                </h1>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <form:form modelAttribute="modelInsertOrUpdate" class="form-horizontal" action="/admin/customer-edit" id="listForm" method="post">
                    <div class="form-group">
                        <label class="col-xs-3 ">Tên khách hàng <span style="color: red">(*)</span></label>
                        <div class="col-xs-9">
                                <form:input path="fullName" class="form-control" id="fullName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Số điện thoại<span style="color: red">(*)</span></label>
                        <div class="col-xs-9">
                            <form:input path="phone" class="form-control" id="phone"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Email</label>
                        <div class="col-xs-9">
                            <form:input path="email" class="form-control" id="email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Tên công ty</label>
                        <div class="col-xs-9">
                            <form:input path="companyName" class="form-control" id="companyName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Nhu cầu</label>
                        <div class="col-xs-9">
                            <form:input path="demand" class="form-control" id="demand"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3" >Trạng thái xử lý <span style="color: red">(*)</span></label>
                        <div class="col-xs-4">
                            <form:select path="status" class="form-control" id="status">
                                <c:forEach var="item" items="${statusList}">
                                    <form:option value="${item.key}">${item.value}</form:option>
                                </c:forEach>
                            </form:select>
                            <form:hidden path="id" id="customerId"/>
                        </div>
                    </div>
                </form:form>
                </div>
            </div>
            <form:form modelAttribute="modelInsertOrUpdate" class="form-group">
            <label class="col-xs-3 "></label>
            <div class="col-xs-9">
                <c:if test="${mode == 'insert'}">
                    <button type="button" class="btn btn-primary" id="btnAddCustomer">
                        Thêm khách hàng
                    </button>
                </c:if>
                <c:if test="${mode == 'update'}">
                    <button type="button" class="btn btn-primary" id="btnAddCustomer">
                        Sửa khách hàng
                    </button>
                </c:if>
                <button type="button" class="btn btn-danger" id="btnCancel">
                    Hủy thao tác
                </button>
            </div>
        </form:form>
            <div class="hr hr-18 dotted hr-double"></div>
            <c:if test="${not empty modelInsertOrUpdate.id}">
                <c:forEach var="it" items="${transactionList}">
                    <div class="col-xs-12">
                        <h2 class="smaller lighter blue">
                                ${it.value}
                            <button class="btn btn-md btn-success pull-right" title="Thêm giao dịch"
                            onclick="addTransaction('${it.key}', $('#customerId').val())">
                                <i class="ace-icon glyphicon glyphicon-plus smaller-80"></i>Thêm giao dịch
                            </button>
                        </h2>
                        <div class="hr hr-16 dotted hr-dotted"></div>
                    </div>
                    <c:if test="${it.key == 'CSKH'}">
                        <div class="col-xs-12" style="margin-bottom: 24px">
                            <table id="tableList-CSKH" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr class="center">
                                        <th class="center">Ngày tạo</th>
                                        <th class="center">Người tạo</th>
                                        <th class="center">Ngày sửa</th>
                                        <th class="center">Người sửa</th>
                                        <th class="center">Chi tiết giao dịch</th>
                                        <th class="center">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="transaction" items="${CSKH}">
                                        <tr class="center">
                                            <td>${transaction.createdDate}</td>
                                            <td>${transaction.createdBy}</td>
                                            <td>${transaction.modifiedDate}</td>
                                            <td>${transaction.modifiedBy}</td>
                                            <td>${transaction.note}</td>
                                            <td class="center">
                                                <div class="hidden-sm hidden-xs center">
                                                    <button class="btn btn-sm btn-info"
                                                            title="Chỉnh sửa giao dịch"
                                                            type="button"
                                                            data-note="${transaction.note}"
                                                            onclick="updateTransaction('${it.key}', ${transaction.id}, $('#customerId').val(), this)"
                                                    >
                                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger"
                                                    title="Xóa giao dịch" type="button" onclick="deleteTransaction(${transaction.id})">
                                                        <i class="ace-icon glyphicon glyphicon-trash"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                    <c:if test="${it.key == 'DDX'}">
                        <div class="col-xs-12" style="margin-bottom: 24px">
                            <table id="tableList-DDX" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr class="center">
                                        <th class="center">Ngày tạo</th>
                                        <th class="center">Người tạo</th>
                                        <th class="center">Ngày sửa</th>
                                        <th class="center">Người sửa</th>
                                        <th class="center">Chi tiết giao dịch</th>
                                        <th class="center">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${DDX}" var="transaction">
                                        <tr class="center">
                                            <td>${transaction.createdDate}</td>
                                            <td>${transaction.createdBy}</td>
                                            <td>${transaction.modifiedDate}</td>
                                            <td>${transaction.modifiedBy}</td>
                                            <td>${transaction.note}</td>
                                            <td class="center">
                                                <div class="hidden-sm hidden-xs center">
                                                    <button class="btn btn-sm btn-info"
                                                            title="Chỉnh sửa giao dịch"
                                                            type="button"
                                                            data-note="${transaction.note}"
                                                            onclick="updateTransaction('${it.key}', ${transaction.id}, $('#customerId').val(), this)">
                                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                    </button>
                                                    <button class="btn btn-sm btn-danger"
                                                            title="Xóa giao dịch"
                                                            type="button"
                                                            onclick="deleteTransaction(${transaction.id})">
                                                        <i class="ace-icon glyphicon glyphicon-trash"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </c:forEach>
            </c:if>
        </div>
        <div class="modal fade" id="addOrUpdateTransactionModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title border blue" id="exampleModalLabel">Nhập thông tin giao dịch</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                        style="position: absolute; top: 0px; right: 0px; padding: 12px;">
                            <span aria-hidden="true">x</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group" style="display: flex; align-items: center; margin-bottom: 15px;">
                            <label class="col-xs-3 control-label no-padding-right">Chi tiết giao dịch</label>
                            <div class="col-sm-9">
                                <input id="note" value="" class="form-control"/>
                            </div>
                        </div>
                        <input type="hidden" id="modalCustomerId" value="">
                        <input type="hidden" id="transactionId" value="">
                        <input type="hidden" id="code" value="">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateTransaction">Xác nhận</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <script src="assets/js/jquery.2.1.1.min.js"></script>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
    </script>
    <script>
        $('#btnCancel').click(function (){
            window.location.href = "/admin/customer-list";
        });

        $('#btnAddCustomer').click(function (e){
            e.preventDefault();
            $('.error-msg').remove();
            var formData = $('#listForm').serializeArray();
            var json = {};
            $.each(formData, function (index, item){
                json[item.name] = item.value;
            })

            var isValid = true;
            function checkEmpty(value){
                return !value || String(value).trim() == '';
            }
            if(checkEmpty(json['fullName'])){
                $('#fullName').after('<span class="error-msg" style="color: red; display: block;"> Họ và tên không được thiếu ! </span>');
                isValid = false;
            }
            if(checkEmpty(json['phone'])){
                $('#phone').after('<span class="error-msg" style="color: red; display: block;"> Số điện thoại không được thiếu ! </span>');
                isValid = false;
            }
            if(isValid)
                addCustomer(json);
            else
                alert("Vui lòng nhập đầy đủ thông tin !");
        })

        function addCustomer(data){
            $.ajax({
                url: "/api/admin/customer-edit",
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json",
                success: function (data){
                    alert("Thêm khách hàng thành công !");
                    window.location.href ="/admin/customer-list";
                },
                error: function (data){
                    console.log(data);
                    alert("Thêm khách hàng không thành công !")
                }
            })
        }
        function addTransaction(code, customerId){
            $('#addOrUpdateTransactionModal').modal();
            $('#note').val('');
            $('#transactionId').val('');
            $('#modalCustomerId').val(customerId);
            $('#code').val(code);
        }
        function updateTransaction(code, transactionId, customerId, btn){
            $('#addOrUpdateTransactionModal').modal('show');
            var oldNote = $(btn).attr('data-note');
            loadTransaction(transactionId);
            $('#note').val(oldNote);
            $('#code').val(code);
            $('#modalCustomerId').val(customerId);
            $('#transactionId').val(transactionId);
        }
        function loadTransaction(transactionId){
            $.ajax({
                url: "/api/transactions/" + transactionId,
                type: "GET",
                dataType: "json",
                success: function (response){
                    $('#note').val(response['data']);
                },
                error: function (response){
                    console.log("failed");
                }
            })
        }
        $('#btnAddOrUpdateTransaction').click(function (e){
            e.preventDefault();
            var data = {};
            data['id'] = $('#transactionId').val();
            data['code'] = $('#code').val();
            data['note'] = $('#note').val().trim();
            data['customerId'] = $('#modalCustomerId').val();
            if(data['note'] !== ''){
                handleAddOrUpdateTransaction(data);
            }else{
                $('#note').attr("placeholder", "Vui lòng điền chi tiết giao dịch");
            }
        })
        function handleAddOrUpdateTransaction(data){
            $.ajax({
                url: "/api/admin/transactions",
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json",
                success: function (){
                    location.reload();
                },
                error: function (){
                    alert("Sửa giao dịch không thành công !");
                }
            })
        }
        function deleteTransaction(transactionId){
            $.ajax({
                url: "/api/admin/transaction/" + transactionId,
                type: "Delete",
                contentType: "application/json",
                success: function (){
                    alert("Xóa giao dịch thành công");
                    location.reload();
                },
                error: function (){
                    alert("Xóa giao dịch không thành công !");
                }
            })
        }
    </script>
</body>
</html>
