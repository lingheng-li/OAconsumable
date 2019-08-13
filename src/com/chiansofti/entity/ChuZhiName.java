package com.chiansofti.entity;

import java.io.Serializable;

public class ChuZhiName implements Serializable {   
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ChuZhiName(String name) {
			super();
			this.name = name;
		}
		public ChuZhiName() {

		}

		@Override
		public String toString() {
			return "ChuZhiName [name=" + name + "]";
		}
		
}
