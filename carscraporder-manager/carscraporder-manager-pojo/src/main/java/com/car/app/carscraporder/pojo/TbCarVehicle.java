package com.car.app.carscraporder.pojo;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_car_vehicle")
public class TbCarVehicle extends BasePojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer carModelId;

    private Integer carSystemId;

    private String levelId;

    private String carname;

    private String saleTitle;

    private Boolean isDelete;

    private String vehicleGuid;

    private String abbreviation;

    private String year;

    private Boolean isFlag;

    private String source;

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Integer carModelId) {
        this.carModelId = carModelId;
    }

    public Integer getCarSystemId() {
        return carSystemId;
    }

    public void setCarSystemId(Integer carSystemId) {
        this.carSystemId = carSystemId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname == null ? null : carname.trim();
    }

    public String getSaleTitle() {
        return saleTitle;
    }

    public void setSaleTitle(String saleTitle) {
        this.saleTitle = saleTitle == null ? null : saleTitle.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getVehicleGuid() {
        return vehicleGuid;
    }

    public void setVehicleGuid(String vehicleGuid) {
        this.vehicleGuid = vehicleGuid == null ? null : vehicleGuid.trim();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Boolean getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(Boolean isFlag) {
        this.isFlag = isFlag;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

   
}