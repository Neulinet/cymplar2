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

import com.leancrm.portlet.library.model.AddressBookClp;
import com.leancrm.portlet.library.model.AddressBookContactClp;
import com.leancrm.portlet.library.model.AddressBookContactDataClp;
import com.leancrm.portlet.library.model.AddressBookOrganizationClp;
import com.leancrm.portlet.library.model.AddressBookUserClp;
import com.leancrm.portlet.library.model.ColleagueAddressBookContactClp;
import com.leancrm.portlet.library.model.ContactClp;
import com.leancrm.portlet.library.model.ContactContractClp;
import com.leancrm.portlet.library.model.ContactDataClp;
import com.leancrm.portlet.library.model.ContactDataMethodClp;
import com.leancrm.portlet.library.model.ContactDataPhoneClp;
import com.leancrm.portlet.library.model.ContactDataRefClp;
import com.leancrm.portlet.library.model.ContactDataTextClp;
import com.leancrm.portlet.library.model.ContractClp;
import com.leancrm.portlet.library.model.EnterpriseClp;
import com.leancrm.portlet.library.model.IndustryClp;
import com.leancrm.portlet.library.model.MyAddressBookContactClp;
import com.leancrm.portlet.library.model.NextFollowUpEventClp;
import com.leancrm.portlet.library.model.OrganizationIndustryClp;
import com.leancrm.portlet.library.model.ReportClp;
import com.leancrm.portlet.library.model.UserContractClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"cordillera-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"cordillera-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "cordillera-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AddressBookClp.class.getName())) {
			return translateInputAddressBook(oldModel);
		}

		if (oldModelClassName.equals(AddressBookContactClp.class.getName())) {
			return translateInputAddressBookContact(oldModel);
		}

		if (oldModelClassName.equals(AddressBookContactDataClp.class.getName())) {
			return translateInputAddressBookContactData(oldModel);
		}

		if (oldModelClassName.equals(AddressBookOrganizationClp.class.getName())) {
			return translateInputAddressBookOrganization(oldModel);
		}

		if (oldModelClassName.equals(AddressBookUserClp.class.getName())) {
			return translateInputAddressBookUser(oldModel);
		}

		if (oldModelClassName.equals(
					ColleagueAddressBookContactClp.class.getName())) {
			return translateInputColleagueAddressBookContact(oldModel);
		}

		if (oldModelClassName.equals(ContactClp.class.getName())) {
			return translateInputContact(oldModel);
		}

		if (oldModelClassName.equals(ContactContractClp.class.getName())) {
			return translateInputContactContract(oldModel);
		}

		if (oldModelClassName.equals(ContactDataClp.class.getName())) {
			return translateInputContactData(oldModel);
		}

		if (oldModelClassName.equals(ContactDataMethodClp.class.getName())) {
			return translateInputContactDataMethod(oldModel);
		}

		if (oldModelClassName.equals(ContactDataPhoneClp.class.getName())) {
			return translateInputContactDataPhone(oldModel);
		}

		if (oldModelClassName.equals(ContactDataRefClp.class.getName())) {
			return translateInputContactDataRef(oldModel);
		}

		if (oldModelClassName.equals(ContactDataTextClp.class.getName())) {
			return translateInputContactDataText(oldModel);
		}

		if (oldModelClassName.equals(ContractClp.class.getName())) {
			return translateInputContract(oldModel);
		}

		if (oldModelClassName.equals(EnterpriseClp.class.getName())) {
			return translateInputEnterprise(oldModel);
		}

		if (oldModelClassName.equals(IndustryClp.class.getName())) {
			return translateInputIndustry(oldModel);
		}

		if (oldModelClassName.equals(MyAddressBookContactClp.class.getName())) {
			return translateInputMyAddressBookContact(oldModel);
		}

		if (oldModelClassName.equals(NextFollowUpEventClp.class.getName())) {
			return translateInputNextFollowUpEvent(oldModel);
		}

		if (oldModelClassName.equals(OrganizationIndustryClp.class.getName())) {
			return translateInputOrganizationIndustry(oldModel);
		}

		if (oldModelClassName.equals(ReportClp.class.getName())) {
			return translateInputReport(oldModel);
		}

		if (oldModelClassName.equals(UserContractClp.class.getName())) {
			return translateInputUserContract(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAddressBook(BaseModel<?> oldModel) {
		AddressBookClp oldClpModel = (AddressBookClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressBookRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAddressBookContact(BaseModel<?> oldModel) {
		AddressBookContactClp oldClpModel = (AddressBookContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressBookContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAddressBookContactData(
		BaseModel<?> oldModel) {
		AddressBookContactDataClp oldClpModel = (AddressBookContactDataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressBookContactDataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAddressBookOrganization(
		BaseModel<?> oldModel) {
		AddressBookOrganizationClp oldClpModel = (AddressBookOrganizationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressBookOrganizationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAddressBookUser(BaseModel<?> oldModel) {
		AddressBookUserClp oldClpModel = (AddressBookUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressBookUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputColleagueAddressBookContact(
		BaseModel<?> oldModel) {
		ColleagueAddressBookContactClp oldClpModel = (ColleagueAddressBookContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getColleagueAddressBookContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContact(BaseModel<?> oldModel) {
		ContactClp oldClpModel = (ContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactContract(BaseModel<?> oldModel) {
		ContactContractClp oldClpModel = (ContactContractClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactContractRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactData(BaseModel<?> oldModel) {
		ContactDataClp oldClpModel = (ContactDataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactDataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactDataMethod(BaseModel<?> oldModel) {
		ContactDataMethodClp oldClpModel = (ContactDataMethodClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactDataMethodRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactDataPhone(BaseModel<?> oldModel) {
		ContactDataPhoneClp oldClpModel = (ContactDataPhoneClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactDataPhoneRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactDataRef(BaseModel<?> oldModel) {
		ContactDataRefClp oldClpModel = (ContactDataRefClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactDataRefRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContactDataText(BaseModel<?> oldModel) {
		ContactDataTextClp oldClpModel = (ContactDataTextClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContactDataTextRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputContract(BaseModel<?> oldModel) {
		ContractClp oldClpModel = (ContractClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getContractRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEnterprise(BaseModel<?> oldModel) {
		EnterpriseClp oldClpModel = (EnterpriseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEnterpriseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputIndustry(BaseModel<?> oldModel) {
		IndustryClp oldClpModel = (IndustryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getIndustryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMyAddressBookContact(
		BaseModel<?> oldModel) {
		MyAddressBookContactClp oldClpModel = (MyAddressBookContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMyAddressBookContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNextFollowUpEvent(BaseModel<?> oldModel) {
		NextFollowUpEventClp oldClpModel = (NextFollowUpEventClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNextFollowUpEventRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganizationIndustry(
		BaseModel<?> oldModel) {
		OrganizationIndustryClp oldClpModel = (OrganizationIndustryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganizationIndustryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputReport(BaseModel<?> oldModel) {
		ReportClp oldClpModel = (ReportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getReportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserContract(BaseModel<?> oldModel) {
		UserContractClp oldClpModel = (UserContractClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserContractRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.AddressBookImpl")) {
			return translateOutputAddressBook(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.AddressBookContactImpl")) {
			return translateOutputAddressBookContact(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.AddressBookContactDataImpl")) {
			return translateOutputAddressBookContactData(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.AddressBookOrganizationImpl")) {
			return translateOutputAddressBookOrganization(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.AddressBookUserImpl")) {
			return translateOutputAddressBookUser(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ColleagueAddressBookContactImpl")) {
			return translateOutputColleagueAddressBookContact(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContactImpl")) {
			return translateOutputContact(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContactContractImpl")) {
			return translateOutputContactContract(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContactDataImpl")) {
			return translateOutputContactData(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContactDataMethodImpl")) {
			return translateOutputContactDataMethod(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContactDataPhoneImpl")) {
			return translateOutputContactDataPhone(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContactDataRefImpl")) {
			return translateOutputContactDataRef(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContactDataTextImpl")) {
			return translateOutputContactDataText(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ContractImpl")) {
			return translateOutputContract(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.EnterpriseImpl")) {
			return translateOutputEnterprise(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.IndustryImpl")) {
			return translateOutputIndustry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.MyAddressBookContactImpl")) {
			return translateOutputMyAddressBookContact(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.NextFollowUpEventImpl")) {
			return translateOutputNextFollowUpEvent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.OrganizationIndustryImpl")) {
			return translateOutputOrganizationIndustry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.ReportImpl")) {
			return translateOutputReport(oldModel);
		}

		if (oldModelClassName.equals(
					"com.leancrm.portlet.library.model.impl.UserContractImpl")) {
			return translateOutputUserContract(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchAddressBookException")) {
			return new com.leancrm.portlet.library.NoSuchAddressBookException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchAddressBookContactException")) {
			return new com.leancrm.portlet.library.NoSuchAddressBookContactException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchAddressBookContactDataException")) {
			return new com.leancrm.portlet.library.NoSuchAddressBookContactDataException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchAddressBookOrganizationException")) {
			return new com.leancrm.portlet.library.NoSuchAddressBookOrganizationException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchAddressBookUserException")) {
			return new com.leancrm.portlet.library.NoSuchAddressBookUserException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException")) {
			return new com.leancrm.portlet.library.NoSuchColleagueAddressBookContactException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContactException")) {
			return new com.leancrm.portlet.library.NoSuchContactException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContactContractException")) {
			return new com.leancrm.portlet.library.NoSuchContactContractException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContactDataException")) {
			return new com.leancrm.portlet.library.NoSuchContactDataException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContactDataMethodException")) {
			return new com.leancrm.portlet.library.NoSuchContactDataMethodException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContactDataPhoneException")) {
			return new com.leancrm.portlet.library.NoSuchContactDataPhoneException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContactDataRefException")) {
			return new com.leancrm.portlet.library.NoSuchContactDataRefException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContactDataTextException")) {
			return new com.leancrm.portlet.library.NoSuchContactDataTextException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchContractException")) {
			return new com.leancrm.portlet.library.NoSuchContractException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchEnterpriseException")) {
			return new com.leancrm.portlet.library.NoSuchEnterpriseException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchIndustryException")) {
			return new com.leancrm.portlet.library.NoSuchIndustryException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchMyAddressBookContactException")) {
			return new com.leancrm.portlet.library.NoSuchMyAddressBookContactException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchNextFollowUpEventException")) {
			return new com.leancrm.portlet.library.NoSuchNextFollowUpEventException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchOrganizationIndustryException")) {
			return new com.leancrm.portlet.library.NoSuchOrganizationIndustryException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchReportException")) {
			return new com.leancrm.portlet.library.NoSuchReportException();
		}

		if (className.equals(
					"com.leancrm.portlet.library.NoSuchUserContractException")) {
			return new com.leancrm.portlet.library.NoSuchUserContractException();
		}

		return throwable;
	}

	public static Object translateOutputAddressBook(BaseModel<?> oldModel) {
		AddressBookClp newModel = new AddressBookClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressBookRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAddressBookContact(
		BaseModel<?> oldModel) {
		AddressBookContactClp newModel = new AddressBookContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressBookContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAddressBookContactData(
		BaseModel<?> oldModel) {
		AddressBookContactDataClp newModel = new AddressBookContactDataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressBookContactDataRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAddressBookOrganization(
		BaseModel<?> oldModel) {
		AddressBookOrganizationClp newModel = new AddressBookOrganizationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressBookOrganizationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAddressBookUser(BaseModel<?> oldModel) {
		AddressBookUserClp newModel = new AddressBookUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressBookUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputColleagueAddressBookContact(
		BaseModel<?> oldModel) {
		ColleagueAddressBookContactClp newModel = new ColleagueAddressBookContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setColleagueAddressBookContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContact(BaseModel<?> oldModel) {
		ContactClp newModel = new ContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactContract(BaseModel<?> oldModel) {
		ContactContractClp newModel = new ContactContractClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactContractRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactData(BaseModel<?> oldModel) {
		ContactDataClp newModel = new ContactDataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactDataRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactDataMethod(BaseModel<?> oldModel) {
		ContactDataMethodClp newModel = new ContactDataMethodClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactDataMethodRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactDataPhone(BaseModel<?> oldModel) {
		ContactDataPhoneClp newModel = new ContactDataPhoneClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactDataPhoneRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactDataRef(BaseModel<?> oldModel) {
		ContactDataRefClp newModel = new ContactDataRefClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactDataRefRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContactDataText(BaseModel<?> oldModel) {
		ContactDataTextClp newModel = new ContactDataTextClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContactDataTextRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputContract(BaseModel<?> oldModel) {
		ContractClp newModel = new ContractClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setContractRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEnterprise(BaseModel<?> oldModel) {
		EnterpriseClp newModel = new EnterpriseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEnterpriseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputIndustry(BaseModel<?> oldModel) {
		IndustryClp newModel = new IndustryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setIndustryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMyAddressBookContact(
		BaseModel<?> oldModel) {
		MyAddressBookContactClp newModel = new MyAddressBookContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMyAddressBookContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNextFollowUpEvent(BaseModel<?> oldModel) {
		NextFollowUpEventClp newModel = new NextFollowUpEventClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNextFollowUpEventRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganizationIndustry(
		BaseModel<?> oldModel) {
		OrganizationIndustryClp newModel = new OrganizationIndustryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganizationIndustryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputReport(BaseModel<?> oldModel) {
		ReportClp newModel = new ReportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setReportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserContract(BaseModel<?> oldModel) {
		UserContractClp newModel = new UserContractClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserContractRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}