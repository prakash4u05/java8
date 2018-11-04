package javatest;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ProductProcessor {

	public Supplier<List<DisplayProducts>> getSorted(List<Product> pList) {
		return () -> pList.stream().map(i -> new DisplayProducts(genearateSerialNum(i.getSerialNumber()), i.getModel()))
				.sorted(Comparator.comparing(DisplayProducts::getModel)).collect(Collectors.toList());
	}

	private String genearateSerialNum(String serialNum) {

		return (serialNum == null ? serialNum : serialNum.substring(4));
	}

	public class Product {
		private String serialNumber;
		private String model;

		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}
	}

	public class DisplayProducts {
		private String serialNumberToken;
		private String model;

		public DisplayProducts() {
			super();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((model == null) ? 0 : model.hashCode());
			result = prime * result + ((serialNumberToken == null) ? 0 : serialNumberToken.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DisplayProducts other = (DisplayProducts) obj;
			if (model == null) {
				if (other.model != null)
					return false;
			} else if (!model.equals(other.model))
				return false;
			if (serialNumberToken == null) {
				if (other.serialNumberToken != null)
					return false;
			} else if (!serialNumberToken.equals(other.serialNumberToken))
				return false;
			return true;
		}

		public String getSerialNumberToken() {
			return serialNumberToken;
		}

		public void setSerialNumberToken(String serialNumberToken) {
			this.serialNumberToken = serialNumberToken;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public DisplayProducts(String serialNumberToken, String model) {
			super();
			this.serialNumberToken = serialNumberToken;
			this.model = model;
		}

	}

}
