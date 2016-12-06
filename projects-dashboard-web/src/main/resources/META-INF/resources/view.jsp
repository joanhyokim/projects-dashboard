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

<div class="view">
	<div class="container">
		<div class="col-md-3">
			<h3>
				Business Units

				<liferay-portlet:renderURL var="editBusinessUnitURL">
					<portlet:param name="mvcRenderCommandName" value="/edit_business_unit" />
				</liferay-portlet:renderURL>

				<liferay-ui:icon
					cssClass="pull-right"
					iconCssClass="icon-plus-sign"
					message="Add Business Unit"
					url="<%= editBusinessUnitURL %>"
				/>
			</h3>

			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="javascript:;">Engineering</a></li>
				<li><a href="javascript:;">Information Services</a></li>
				<li><a href="javascript:;">Marketing</a></li>
				<li><a href="javascript:;">Marketplace</a></li>
				<li><a href="javascript:;">Sales</a></li>
				<li><a href="javascript:;">Support</a></li>
				<li><a href="javascript:;">Training</a></li>
			</ul>
		</div>
		<div class="col-md-9">
			<h3>
				Projects

				<liferay-portlet:renderURL var="editProjectURL">
					<portlet:param name="mvcRenderCommandName" value="/edit_project" />
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