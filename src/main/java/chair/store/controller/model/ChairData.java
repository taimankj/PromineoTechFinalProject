package chair.store.controller.model;

import chair.store.entity.Chair;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChairData {
	private Long chairId;
	private String name;
	private String brand;
	private String model;
	private String price;
	
	public ChairData(Chair chair) {
		chairId = chair.getChairId();
		name = chair.getName();
		brand = chair.getBrand();
		model = chair.getModel();
		price = chair.getPrice();
	}
	
	public Chair toChair() {
		Chair chair = new Chair();
		
		chair.setChairId(chairId);
		chair.setName(name);
		chair.setName(name);
		chair.setBrand(brand);
		chair.setModel(model);
		chair.setPrice(price);
		
		return chair;
	}
}
