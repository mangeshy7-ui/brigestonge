package com.mng.bridgestone.util;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class StringPrefixedSequenceGenerator extends SequenceStyleGenerator {
	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT = "";
	private String valueprefix;
	public static final String NUMBER_FORMAT_PARAMETR = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String numberFormat;

	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		this.valueprefix = ConfigurationHelper.getString("valuePrefix", params, "");
		this.numberFormat = ConfigurationHelper.getString("numberFormat", params, "%d");
	}

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return this.valueprefix + String.format(this.numberFormat, new Object[] { super.generate(session, object) });
	}
}