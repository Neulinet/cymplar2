/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.leancrm.portlet.library.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Enterprise. This utility wraps
 * {@link com.leancrm.portlet.library.service.impl.EnterpriseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EnterpriseLocalService
 * @see com.leancrm.portlet.library.service.base.EnterpriseLocalServiceBaseImpl
 * @see com.leancrm.portlet.library.service.impl.EnterpriseLocalServiceImpl
 * @generated
 */
public class EnterpriseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.leancrm.portlet.library.service.impl.EnterpriseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the enterprise to the database. Also notifies the appropriate model listeners.
	*
	* @param enterprise the enterprise
	* @return the enterprise that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise addEnterprise(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEnterprise(enterprise);
	}

	/**
	* Creates a new enterprise with the primary key. Does not add the enterprise to the database.
	*
	* @param enterpriseId the primary key for the new enterprise
	* @return the new enterprise
	*/
	public static com.leancrm.portlet.library.model.Enterprise createEnterprise(
		long enterpriseId) {
		return getService().createEnterprise(enterpriseId);
	}

	/**
	* Deletes the enterprise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise that was removed
	* @throws PortalException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise deleteEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEnterprise(enterpriseId);
	}

	/**
	* Deletes the enterprise from the database. Also notifies the appropriate model listeners.
	*
	* @param enterprise the enterprise
	* @return the enterprise that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise deleteEnterprise(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEnterprise(enterprise);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.leancrm.portlet.library.model.Enterprise fetchEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEnterprise(enterpriseId);
	}

	/**
	* Returns the enterprise with the primary key.
	*
	* @param enterpriseId the primary key of the enterprise
	* @return the enterprise
	* @throws PortalException if a enterprise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise getEnterprise(
		long enterpriseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnterprise(enterpriseId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the enterprises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.leancrm.portlet.library.model.impl.EnterpriseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enterprises
	* @param end the upper bound of the range of enterprises (not inclusive)
	* @return the range of enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> getEnterprises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnterprises(start, end);
	}

	/**
	* Returns the number of enterprises.
	*
	* @return the number of enterprises
	* @throws SystemException if a system exception occurred
	*/
	public static int getEnterprisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnterprisesCount();
	}

	/**
	* Updates the enterprise in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param enterprise the enterprise
	* @return the enterprise that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.leancrm.portlet.library.model.Enterprise updateEnterprise(
		com.leancrm.portlet.library.model.Enterprise enterprise)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEnterprise(enterprise);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.leancrm.portlet.library.model.Enterprise addEnterprise(
		java.lang.String name, long companyId, java.lang.String taxid,
		java.lang.String description, java.lang.String email, long industry,
		boolean isPrivate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEnterprise(name, companyId, taxid, description, email,
			industry, isPrivate);
	}

	/**
	* @param actionRequest
	* @param actionResponse
	* @throws SystemException
	* @throws PortalException
	* @throws NumberFormatException
	*/
	public static com.leancrm.portlet.library.model.Enterprise addEnterprise(
		long companyId, long userId, java.lang.String name,
		java.lang.String taxId, java.lang.String countryId,
		java.lang.String description, java.lang.String email,
		java.lang.String industry, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String zipCode, java.lang.String city, boolean isPrivate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return getService()
				   .addEnterprise(companyId, userId, name, taxId, countryId,
			description, email, industry, street1, street2, street3, zipCode,
			city, isPrivate);
	}

	public static com.leancrm.portlet.library.model.Enterprise updateEnterprise(
		long enterpriseId, long companyId, long userId, java.lang.String name,
		java.lang.String taxId, java.lang.String countryId,
		java.lang.String description, java.lang.String email,
		java.lang.String industry, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String zipCode, java.lang.String city, boolean isPrivate)
		throws java.lang.Exception {
		return getService()
				   .updateEnterprise(enterpriseId, companyId, userId, name,
			taxId, countryId, description, email, industry, street1, street2,
			street3, zipCode, city, isPrivate);
	}

	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> getEnterpriseByTax(
		java.lang.String taxid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnterpriseByTax(taxid);
	}

	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> getEnterpriseByIndustryId(
		long industryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEnterpriseByIndustryId(industryId);
	}

	/**
	* Get Enterprise by Name
	*/
	public static java.util.List<com.leancrm.portlet.library.model.Enterprise> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByName(name);
	}

	public static void clearService() {
		_service = null;
	}

	public static EnterpriseLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EnterpriseLocalService.class.getName());

			if (invokableLocalService instanceof EnterpriseLocalService) {
				_service = (EnterpriseLocalService)invokableLocalService;
			}
			else {
				_service = new EnterpriseLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EnterpriseLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EnterpriseLocalService service) {
	}

	private static EnterpriseLocalService _service;
}