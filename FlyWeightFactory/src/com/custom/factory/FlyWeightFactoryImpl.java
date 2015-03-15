/**
 * 
 */
package com.custom.factory;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author rku140
 * @param Object
 * @return weak ref object having lock eg objLck
 */
public class FlyWeightFactoryImpl<T> {
	
	private WeakHashMap<T, WeakReference<T>> map = new WeakHashMap<T, WeakReference<T>>();
	
	private Object LOCK = new Object();
	
	public T get(T object){
		T objLck;
		synchronized (LOCK) {
			WeakReference<T> ref = map.get(object);
			
			if(ref == null){
				map.put(object, new WeakReference<T>(object));
				
				objLck = object;
				
			}
			else{
				objLck = ref.get();
			}
			return objLck;
		}
	}

}
