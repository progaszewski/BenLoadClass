package com.example.jvmint.instr;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import javassist.CannotCompileException;

import org.junit.Test;

import com.example.jvmint.service.TestJavassist;

public class testTest {
	private TestJavassist test = new TestJavassist();

	@Test
	public void agentTest(){
		try {
			test.runTestJavassist(1);
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
}
