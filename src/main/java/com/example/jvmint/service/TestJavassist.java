package com.example.jvmint.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewMethod;


public class TestJavassist {
	
	public void runTestJavassist(int n) throws CannotCompileException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		for(int i = 0; i < n; i++){
			ClassPool cp = ClassPool.getDefault();
			CtClass mk = cp.makeClass("MojaKlasa" + 1);
			
			mk.addMethod(CtNewMethod.make("public int fun (int x) { return x*x; }", mk));
			Class[] formalParams = new Class[] { int.class };
			
			Object[] actualParams = new Object[] { new Integer(10) };
			
			Class mojaklasa = mk.toClass();
			Method method = mojaklasa.getDeclaredMethod("fun", formalParams);
			
			System.out.println(((Integer) method.invoke(mojaklasa.newInstance(), actualParams)).intValue());
		}
	}
	
	public static void main (String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, CannotCompileException{
		new TestJavassist().runTestJavassist(1);
	}

	
}

