<%--
    Document   : productdetail
    Created on : May 25, 2024, 5:34:14 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>
        <div class="product-essential">
            <div class="product-essential-media">
                <div class="product-view-image">
                    <div id="imageContainer" class="position-relative">
                        <img id="previewImage" src="${pro.getProductImage()}" alt="alt"/>
                    </div>
                </div>
                <div class="product_view_add_box">
                    <button type="button" title="Thêm vào giỏ hàng" class="btn-cart-to-cart" onclick="productAddToCartForm.submit(this);
                            return false;">
                        <span class="fhs_icon_cart"></span>
                        <span>Thêm vào giỏ hàng</span>
                    </button>
                    <button type="button" title="Mua ngay" is_buynow="true" class="btn-buy-now" onclick="productAddToCartForm.submit(this);
                            return false;
                            ">
                        <span>Mua ngay</span>
                    </button>				
                </div>
            </div>
            <div class="product-essential-detail">
                <c:set var="pro" value="${pro}"/>
                <div class="product-title">
                    <span>${pro.getProductTitle()}</span>
                </div>
                <div class="product-content">
                    <div class="product-author">
                        <span>Tác giả:</span>
                        <span>${pro.getProductAuthor()}</span>
                    </div>
                    <div class="product-publishhouse">
                        <span>Nhà xuất bản:</span>
                        <span>${rs.getProductPublishHouse()}</span>
                    </div>
                    <div class="product-price">
                        <span>Giá :</span>
                        <span>${pro.getProductPrice()}</span>
                    </div>
                    <div class="quantity-selector">
                        <span class="quantity-label">Số lượng:</span>
                        <button class="btn-decrease" onclick="decreaseQuantity()">-</button>
                        <input type="text" id="quantity" value="1" readonly>
                        <button class="btn-increase" onclick="increaseQuantity()">+</button>
                    </div> 
                    <script>
                        function decreaseQuantity() {
                            var quantityInput = document.getElementById("quantity");
                            var currentQuantity = parseInt(quantityInput.value);
                            if (currentQuantity > 1) {
                                quantityInput.value = currentQuantity - 1;
                            }
                        }

                        function increaseQuantity() {
                            var quantityInput = document.getElementById("quantity");
                            var currentQuantity = parseInt(quantityInput.value);
                            quantityInput.value = currentQuantity + 1;
                        }
                    </script>
                </div>
            </div>
        </div>

        <div class="product-info">
            <div class="product-info-title">Thông tin sản phẩm</div>
            <div class="product_view_tab_content_ad">
                <div class="product_view_tab_content_additional">
                    <c:set var="pro" value="${pro}"/>
                    <table class="data-table table-additional">
                        <colgroup><col width="25%">
                            <col>
                        </colgroup><tbody
                            <tr>
                                <th class="table-label">
                                    Mã hàng</th>
                                <td class="data_sku">
                                    ${pro.getProductId()}</td>
                            </tr>
                            <tr>
                                <th class="table-label">
                                    Tác Giả</th>
                                <td class="data_author">
                                    ${pro.getProductAuthor()}</td>
                            </tr>
                            <tr>
                                <th class="table-label">
                                    Nhà Xuất Bản</th>
                                <td class="data_publishhouse">
                                    ${pro.getProductPublishHouse()}</td>
                            </tr>
                            <tr>
                                <th class="table-label">
                                    Năm Xuất Bản</th>
                                <td class="data_publish_year">
                                    ${pro.getProductYear()}</td>
                            </tr>
                            <tr>
                                <th class="table-label">
                                    Trọng lượng (gr)</th>
                                <td class="data_weight">
                                    ${pro.getProductWeight()}</td>
                            </tr>
                            <tr>
                                <th class="table-label">
                                    Kích Thước</th>
                                <td class="data_size">
                                    ${pro.getProductSize()}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="clear"></div>
                <div id="product_description">
                    <div id="desc_content" class="std">
                        <p> ${pro.getProductDescription()}</p>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="include/footer.jsp"/>
    </body>
</html>
