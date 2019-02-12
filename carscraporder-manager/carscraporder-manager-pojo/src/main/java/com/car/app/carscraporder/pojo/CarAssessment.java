package com.car.app.carscraporder.pojo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="car_assessment")
public class CarAssessment extends BasePojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String keyword1;

    private String keyword2;

    private String keyword3;

    private String datesofproduction;

    private String displacement;

    private String gearbox;

    private String fueltype;

    private String region;

    private String price;
    
    
    

    public CarAssessment() {
		super();
	}

	public CarAssessment(String datesofproduction, String displacement,
			String gearbox, String fueltype, String region) {
		super();
		this.datesofproduction = datesofproduction;
		this.displacement = displacement;
		this.gearbox = gearbox;
		this.fueltype = fueltype;
		this.region = region;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1 == null ? null : keyword1.trim();
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2 == null ? null : keyword2.trim();
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3 == null ? null : keyword3.trim();
    }

    public String getDatesofproduction() {
        return datesofproduction;
    }

    public void setDatesofproduction(String datesofproduction) {
        this.datesofproduction = datesofproduction == null ? null : datesofproduction.trim();
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement == null ? null : displacement.trim();
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox == null ? null : gearbox.trim();
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype == null ? null : fueltype.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

  
}