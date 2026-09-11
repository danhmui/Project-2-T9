<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Thêm tòa nhà</title>
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
                <li class="active">Dashboard</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Thông tin tòa nhà
                </h1>
            </div>
            <!-- /.page-header -->
            <div class="row">
                <div class="col-xs-12">
                    <form:form class="form-horizontal" role="form" id="form-edit" modelAttribute="building">
                        <div class="form-group">
                            <label class="col-xs-3 ">Tên tòa nhà (*)</label>
                            <div class="col-xs-9">
                                <form:input path="name" type="text" class="form-control" id="1"></form:input>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3" >Quận (*)</label>
                            <div class="col-xs-4">
                                <form:select path="district" class="form-control">
                                    <option value="">-- Chọn Quận --</option>
                                    <form:options items="${districts}"></form:options>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phường (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="ward">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Đường (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="street">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Kết cấu</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="structure">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Số tầng hầm (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="numberOfBasement">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Diện tích sàn</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="floorArea">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Hướng</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="direction">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Hạng (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="level">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Diện tích thuê (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="rentArea">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Giá thuê (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="rentPrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Mô tả giá</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="rentPriceDescription">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí dịch vụ</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="serviceFee">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí ô tô</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="carFee">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí mô tô</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="motoFee">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí ngoài giờ</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="overtimeFee">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tiền điện</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="electricityFee">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tiền nước</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="waterPrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Đặt cọc (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="deposit">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Thanh toán (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="payment">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Thời hạn thuê</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="rentTime">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-3">Thời gian trang trí</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="decorationTime">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tên quản lý (*)</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="managerName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">SĐT quản lý (*)</label>
                            <div class="col-xs-9">
                                <input type="number" class="form-control" name="managerPhone">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí môi giới</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="brokerageFee">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Ghi chú  </label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="note">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 ">Loại tòa nhà (*)</label>
                            <div class="col-xs-6">
                                <form:checkboxes path="typeCode" items="${typeCode}"></form:checkboxes>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>


            <div class="form-group">
                <label class="col-xs-3 "></label>
                <div class="col-xs-9">
<%--                    <c:if test="${not empty building.id}">--%>
                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">
                            Thêm tòa nhà
                        </button>
<%--                    </c:if>--%>
<%--                    <c:if test="${not empty building.id}">--%>
<%--                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">--%>
<%--                            Sửa tòa nhà--%>
<%--                        </button>--%>
<%--                    </c:if>--%>
                    <button type="button" class="btn btn-danger" >
                        Hủy thao tác
                    </button>
                </div>
            </div>

        </div>
        </form>
    </div>

    <!-- /.page-content -->
</div>

<!-- /.main-content -->
<script src="assets/js/jquery.2.1.1.min.js"></script>




<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
</script>
<!-- <![endif]-->
<script>
    $('#btnAddOrUpdateBuilding').click(function (e) {
        e.preventDefault();
        var formData = $("#form-edit").serializeArray(); //Mảng các đối tượng
        var json = {}; //Object ten la JSON trong JS
        var typeCode = [];
        $.each(formData, function(i,it){
            if(it.name != 'typeCode')
                json["" + it.name + ""] = it.value;
            else
                typeCode.push(it.value);
        });
        json['typeCode'] = typeCode;
        if(json['name'] != '' && typeCode.length != 0){
            AddBuilding(json);
        }else{
            alert("Tên và loại tòa nhà không được thiếu !")
        }
    })

    function AddBuilding(data){
        $.ajax({
            url:"/api/buildings",
            type: "POST",
            data: JSON.stringify(data), //Convert tu Object trong JS qua JSON
            // dataType: "JSON", //Kieu du lieu ma server se tra ra
            contentType: 'application/json',
            success : function (response) {
                console.log("success");
            },
            error : function(response){
                console.log("failed");
                alert(response.responseJSON);
            }
        });
    }

</script>
</body>
</html>
