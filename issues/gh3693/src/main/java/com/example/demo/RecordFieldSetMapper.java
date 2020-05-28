package com.example.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.RecordComponent;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.Assert;
import org.springframework.validation.BindException;

public class RecordFieldSetMapper<T> implements FieldSetMapper<T> {

	private final Class<? extends T> targetType;
	private final RecordComponent[] recordComponents;
	private final ConversionService conversionService;

	public RecordFieldSetMapper(Class<? extends T> targetType) {
		this(targetType, new DefaultConversionService());
	}

	public RecordFieldSetMapper(Class<? extends T> targetType, ConversionService conversionService) {
		Assert.isTrue(targetType.isRecord(), "target type must be a record");
		this.targetType = targetType;
		this.recordComponents = this.targetType.getRecordComponents();
		this.conversionService = conversionService;
	}

	@Override
	public T mapFieldSet(FieldSet fieldSet) throws BindException {
		int recordComponentsLength = this.recordComponents.length;
		Assert.isTrue(fieldSet.getFieldCount() == recordComponentsLength, "Fields count must be equal to record components count");
		try {
			Constructor<?> canonicalConstructor = getCanonicalConstructor(this.targetType);
			Object[] initArgs = new Object[recordComponentsLength];
			// recordComponents are ordered, see javadoc:
			// "The components are returned in the same order that they are declared in the record header"
			for (int i = 0; i < recordComponentsLength; i++) {
				initArgs[i] = this.conversionService.convert(fieldSet.readRawString(i), this.recordComponents[i].getType());
			}
			// Record javadoc: "A record class has the following mandated members: a public canonical
			// constructor, whose descriptor is the same as the record descriptor;
			return (T) canonicalConstructor.newInstance(initArgs);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new BindException(null);
		}
	}

	private Constructor<?> getCanonicalConstructor(Class<?> targetType) {
		// Record javadoc: "A record class has the following mandated members: a public canonical
		// constructor, whose descriptor is the same as the record descriptor;
		Class<?>[] componentTypes = new Class<?>[this.recordComponents.length];
		for (int i = 0; i < this.recordComponents.length; i++) {
			componentTypes[i] = this.recordComponents[i].getType();
		}
		try {
			return targetType.getConstructor(componentTypes);
		} catch (NoSuchMethodException e) { // should not happen, from Record javadoc: "A record class has the following mandated members: a public canonical constructor , whose descriptor is the same as the record descriptor;"
			throw new RuntimeException("Invalid record definition", e);
		}
	}
}
