package com.example.jvmint.service;

public class TestASM {
    
	public void runTestASM(int n) throws Exception{
		
		for(int i = 0; i < n ; i++){
			byte[] bytecode =  MojaKlasaAsm.dump(i);
			
			MyClassLoader mcl = new MyClassLoader();
	        
	        Class<?> mojaKlasaAsm = mcl.loadClass("com.example.jvmint.service.MojaKlasaAsm" + i, bytecode);
	        
	        Object obj = mojaKlasaAsm.newInstance();
	        System.out.println(mojaKlasaAsm.getMethod("fun", int.class).invoke(obj, 9));
		}
	}
	
	public static void main(String[] args) throws Exception{
		TestASM asm = new TestASM();
		asm.runTestASM(1);
	}
	
	private class MyClassLoader extends ClassLoader{
		private byte[] bytecode = null;
		

		public Class<?> loadClass(String name, byte[] bytecode) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			
			this.bytecode = bytecode;
			return findClass(name);
		}
		
		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {

			if(bytecode != null){
				return defineClass(name, bytecode, 0, bytecode.length);
			}
			return super.findClass(name);
		}
	}
}
