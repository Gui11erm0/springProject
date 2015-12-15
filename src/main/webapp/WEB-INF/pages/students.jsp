<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="studentList.title"/></title>
    <meta name="menu" content="StudentMenu"/>
</head>

<h2><fmt:message key="studentList.heading"/></h2>

<div id="actions" class="btn-group">
    <a href='<c:url value="/personform"/>' class="btn btn-primary">
        <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
    <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
</div>

<display:table name="studentList" class="table table-condensed table-striped table-hover" requestURI=""
               id="studentList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="personform" media="html"
        paramId="id" paramProperty="id" titleKey="student.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="student.id"/>
    <display:column property="firstName" sortable="true" titleKey="student.firstName"/>
    <display:column property="lastName" sortable="true" titleKey="student.lastName"/>
    <display:column property="course" sortable="true" titleKey="student.course"/>
    <display:column property="grade" sortable="true" titleKey="student.grade"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="studentList.students"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="studentList.students"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="studentList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="studentList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="studentList.title"/>.pdf</display:setProperty>
</display:table>