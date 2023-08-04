package com.fssa.zanarts.customexception;



	public class CustomExpection extends Exception {

		private static final long serialVersionUID = -8105491977357554060L;

		public  CustomExpection(String s) {
			super(s);
		}

		public CustomExpection(Throwable te) {
			super(te);
		}

		public CustomExpection(String s, Throwable te) {
			super(s, te);
		}

	}
//
//	class lengthExpection extends Exception {
//		private static final long serialVersionUID = -8105491977357554060L;
//
//		lengthExpection(String s) {
//
//			super(s);
//		}

//			public nullExpection(Throwable te) {
//				super(te);
//			}
		//
//			public nullExpection(String s, Throwable te) {
//				super(s, te);
//			}	

//	}


