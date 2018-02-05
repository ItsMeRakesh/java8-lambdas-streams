package org.rakiworld.method.reference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceOrderItem {

	static class OrderItem {
		Double weight;
		Long id;

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public OrderItem(Long id, Double weight) {
			this.id = id;
			this.weight = weight;
		}
	}

	public Double calculateOrderWeight(List<OrderItem> order, Function<OrderItem, Double> f) {
		Double totalWeight = 0d;
		for (Iterator<OrderItem> iterator = order.iterator(); iterator.hasNext();) {
			OrderItem orderItem = iterator.next();
			totalWeight += f.apply(orderItem);
		}
		return totalWeight;
	}

	public static void main(String[] args) {
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(new OrderItem(1l, 10d));
		orderItems.add(new OrderItem(2l, 20d));
		orderItems.add(new OrderItem(3l, 30d));
		orderItems.add(new OrderItem(4l, 40d));
		orderItems.add(new OrderItem(5l, 50d));

		MethodReferenceOrderItem ex = new MethodReferenceOrderItem();
		Double totalWeight = ex.calculateOrderWeight(orderItems, item -> item.getWeight() * 2);

		Double totalWeightWithReference = ex.calculateOrderWeight(orderItems, OrderItem::getWeight);
		System.out.println("Total Weight:" + totalWeight);
		System.out.println("Total Weight with method reference:" + totalWeightWithReference);

	}

}
