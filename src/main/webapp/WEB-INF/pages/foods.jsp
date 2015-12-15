<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="foodList.title"/></title>
    <meta name="menu" content="FoodMenu"/>
</head>

<h2><fmt:message key="foodList.heading"/></h2>

<div id="actions" class="btn-group">
    <a href='<c:url value="/foodform"/>' class="btn btn-primary">
        <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
    <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
</div>

<display:table name="foodList" class="table table-condensed table-striped table-hover" requestURI=""
               id="foodList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="foodform" media="html"
        paramId="id" paramProperty="id" titleKey="food.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="food.id"/>
    <display:column property="name" sortable="true" titleKey="food.name"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="foodList.food"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="foodList.foods"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="foodList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="foodList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="foodList.title"/>.pdf</display:setProperty>
</display:table>