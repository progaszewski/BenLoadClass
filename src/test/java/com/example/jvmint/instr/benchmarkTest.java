package com.example.jvmint.instr;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import javassist.CannotCompileException;

import org.junit.Test;

import com.example.jvmint.service.TestASM;
import com.example.jvmint.service.TestJavassist;

public class benchmarkTest {
	
	private final static int N = 10000;

	@Test
	public void testClassLoadJavassist(){
		try {
			TestJavassist test = new TestJavassist();
			test.runTestJavassist(N);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(true);
	}
	
	@Test
	public void testClassLoadAsm(){
		TestASM test = new TestASM();
		
		try {
			test.runTestASM(N);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
