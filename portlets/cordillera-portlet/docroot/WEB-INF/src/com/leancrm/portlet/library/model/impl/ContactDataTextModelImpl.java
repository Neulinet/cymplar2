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

package com.leancrm.portlet.library.model.impl;

import com.leancrm.portlet.library.model.ContactDataText;
import com.leancrm.portlet.library.model.ContactDataTextModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ContactDataText service. Represents a row in the &quot;crm_ContactDataText&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.leancrm.portlet.library.model.ContactDataTextModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactDataTextImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactDataTextImpl
 * @see com.leancrm.portlet.library.model.ContactDataText
 * @see com.leancrm.portlet.library.model.ContactDataTextModel
 * @generated
 */
public class ContactDataTextModelImpl extends BaseModelImpl<ContactDataText>
	implements ContactDataTextModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a contact data text model instance should use the {@link com.leancrm.portlet.library.model.ContactDataText} interface instead.
	 */
	public static final String TABLE_NAME = "crm_ContactDataText";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contactDataId", Types.BIGINT },
			{ "value", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table crm_ContactDataText (contactDataId LONG not null primary key,value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table crm_ContactDataText";
	public static final String ORDER_BY_JPQL = " ORDER BY contactDataText.contactDataId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY crm_ContactDataText.contactDataId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.leancrm.portlet.library.model.ContactDataText"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.leancrm.portlet.library.model.ContactDataText"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.leancrm.portlet.library.model.ContactDataText"));

	public ContactDataTextModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _contactDataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactDataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDataText.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDataText.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDataId", getContactDataId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDataId = (Long)attributes.get("contactDataId");

		if (contactDataId != null) {
			setContactDataId(contactDataId);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getContactDataId() {
		return _contactDataId;
	}

	@Override
	public void setContactDataId(long contactDataId) {
		_contactDataId = contactDataId;
	}

	@Override
	public String getValue() {
		if (_value == null) {
			return StringPool.BLANK;
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		_value = value;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ContactDataText.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ContactDataText toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ContactDataText)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ContactDataTextImpl contactDataTextImpl = new ContactDataTextImpl();

		contactDataTextImpl.setContactDataId(getContactDataId());
		contactDataTextImpl.setValue(getValue());

		contactDataTextImpl.resetOriginalValues();

		return contactDataTextImpl;
	}

	@Override
	public int compareTo(ContactDataText contactDataText) {
		long primaryKey = contactDataText.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDataText)) {
			return false;
		}

		ContactDataText contactDataText = (ContactDataText)obj;

		long primaryKey = contactDataText.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ContactDataText> toCacheModel() {
		ContactDataTextCacheModel contactDataTextCacheModel = new ContactDataTextCacheModel();

		contactDataTextCacheModel.contactDataId = getContactDataId();

		contactDataTextCacheModel.value = getValue();

		String value = contactDataTextCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			contactDataTextCacheModel.value = null;
		}

		return contactDataTextCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contactDataId=");
		sb.append(getContactDataId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.leancrm.portlet.library.model.ContactDataText");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactDataId</column-name><column-value><![CDATA[");
		sb.append(getContactDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ContactDataText.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ContactDataText.class
		};
	private long _contactDataId;
	private String _value;
	private ContactDataText _escapedModel;
}