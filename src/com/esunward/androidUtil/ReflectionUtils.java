package com.esunward.androidUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtils {
	/**
	 * ��ȡ���Բ��ҹ��˵���̬����
	 * @param clazz	Ŀ����
	 * @return
	 */
	public static List<Field> getFields(Class<?> clazz){
		return getFields(clazz,null,true);
	}
	/**
	 * ��ȡ����ע������Բ��ҹ��˵���̬����
	 * @param clazz	Ŀ����
	 * @return
	 */
	public static List<Field> getFields(Class<?> clazz,Class<? extends Annotation> annotation){
		return getFields(clazz,annotation,true);
	}
	public static List<Field> getFields(Class<?> clazz,Class<? extends Annotation> annotation,boolean containParent){
		List<Field> fields = new ArrayList<Field>();
		Field[] fieldArray = clazz.getDeclaredFields();
		for (Field field : fieldArray) {
			if(Modifier.isStatic(field.getModifiers())){	//���˵���̬����
				continue;
			}
			if(annotation==null||field.getAnnotation(annotation)!=null){
				fields.add(field);
			}
			
		}
		if(containParent){
			Class<?> clazz1 = clazz.getSuperclass();
			if(!clazz1.equals(Object.class)){	//�ݹ����ϻ�ȡ
				fields.addAll(getFields(clazz1,annotation,true));
			}
		}
		return fields;
	}
	
	/**
	 * ��һ��ʵ����ͨ������ת����һ��map����,���static����ֵ�Լ�ֵ�Ե���ʽ���
	 */
	public static <T>Map<String,Object> entity2HashMap(T t){
		Map<String,Object>newmap = new HashMap<String,Object>();
		try {
			List<Field>fieldList = ReflectionUtils.getFields(t.getClass());
			for(Field field:fieldList){
				field.setAccessible(true);
				String name = field.getName();
				Object obj = field.get(t);
				newmap.put(name, obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return newmap;
	}
}
