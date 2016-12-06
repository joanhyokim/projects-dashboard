<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
long businessUnitId = ParamUtil.getLong(request, "businessUnitId", getDefaultBusinessUnitId());
%>

<div class="view">
	<div class="container">
		<div class="col-md-3">
			<h3>
				Business Units

				<liferay-portlet:renderURL var="editBusinessUnitURL">
					<portlet:param name="mvcRenderCommandName" value="/edit_business_unit" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</liferay-portlet:renderURL>

				<liferay-ui:icon
					cssClass="pull-right"
					iconCssClass="icon-plus-sign"
					message="Add Business Unit"
					url="<%= editBusinessUnitURL %>"
				/>
			</h3>

			<ul class="nav nav-pills nav-stacked">

				<%
				List<BusinessUnit> businessUnits = BusinessUnitLocalServiceUtil.getBusinessUnits(-1, -1);

				for (BusinessUnit businessUnit : businessUnits) {

				%>

					<li<%= (businessUnit.getBusinessUnitId() == businessUnitId) ? " class=\"active\"" : StringPool.BLANK%>>
						<liferay-portlet:renderURL var="viewURL">
							<portlet:param name="mvcRenderCommandName" value="/edit_business_unit" />
							<portlet:param name="businessUnitId" value="<%= String.valueOf(businessUnit.getBusinessUnitId()) %>" />
						</liferay-portlet:renderURL>

						<a href="<%= viewURL %>"><%= businessUnit.getName() %></a>
					</li>

				<%
				}
				%>

			</ul>
		</div>
		<div class="col-md-9">
			<h3>
				Projects

				<liferay-portlet:renderURL var="editProjectURL">
					<portlet:param name="mvcRenderCommandName" value="/edit_project" />
					<portlet:param name="businessUnitId" value="<%= String.valueOf(businessUnitId) %>" />
				</liferay-portlet:renderURL>

				<liferay-ui:icon
					cssClass="pull-right"
					iconCssClass="icon-plus-sign"
					message="Add Project"
					url="<%= editProjectURL %>"
				/>
			</h3>
		</div>
	</div>
</div>

<%!
protected long getDefaultBusinessUnitId() {
	List<BusinessUnit> businessUnits = BusinessUnitLocalServiceUtil.getBusinessUnits(0, 1);

	if (!businessUnits.isEmpty()) {
		return businessUnits.get(0).getBusinessUnitId();
	}

	return 0;
}
%>