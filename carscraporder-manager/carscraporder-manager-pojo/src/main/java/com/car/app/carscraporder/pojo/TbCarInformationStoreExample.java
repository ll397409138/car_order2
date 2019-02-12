package com.car.app.carscraporder.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbCarInformationStoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCarInformationStoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerIsNull() {
            addCriterion("car_manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerIsNotNull() {
            addCriterion("car_manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerEqualTo(String value) {
            addCriterion("car_manufacturer =", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerNotEqualTo(String value) {
            addCriterion("car_manufacturer <>", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerGreaterThan(String value) {
            addCriterion("car_manufacturer >", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("car_manufacturer >=", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerLessThan(String value) {
            addCriterion("car_manufacturer <", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerLessThanOrEqualTo(String value) {
            addCriterion("car_manufacturer <=", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerLike(String value) {
            addCriterion("car_manufacturer like", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerNotLike(String value) {
            addCriterion("car_manufacturer not like", value, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerIn(List<String> values) {
            addCriterion("car_manufacturer in", values, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerNotIn(List<String> values) {
            addCriterion("car_manufacturer not in", values, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerBetween(String value1, String value2) {
            addCriterion("car_manufacturer between", value1, value2, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarManufacturerNotBetween(String value1, String value2) {
            addCriterion("car_manufacturer not between", value1, value2, "carManufacturer");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNull() {
            addCriterion("car_brand is null");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNotNull() {
            addCriterion("car_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCarBrandEqualTo(String value) {
            addCriterion("car_brand =", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotEqualTo(String value) {
            addCriterion("car_brand <>", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThan(String value) {
            addCriterion("car_brand >", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThanOrEqualTo(String value) {
            addCriterion("car_brand >=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThan(String value) {
            addCriterion("car_brand <", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThanOrEqualTo(String value) {
            addCriterion("car_brand <=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLike(String value) {
            addCriterion("car_brand like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotLike(String value) {
            addCriterion("car_brand not like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandIn(List<String> values) {
            addCriterion("car_brand in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotIn(List<String> values) {
            addCriterion("car_brand not in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandBetween(String value1, String value2) {
            addCriterion("car_brand between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotBetween(String value1, String value2) {
            addCriterion("car_brand not between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarSystemIsNull() {
            addCriterion("car_system is null");
            return (Criteria) this;
        }

        public Criteria andCarSystemIsNotNull() {
            addCriterion("car_system is not null");
            return (Criteria) this;
        }

        public Criteria andCarSystemEqualTo(String value) {
            addCriterion("car_system =", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemNotEqualTo(String value) {
            addCriterion("car_system <>", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemGreaterThan(String value) {
            addCriterion("car_system >", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemGreaterThanOrEqualTo(String value) {
            addCriterion("car_system >=", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemLessThan(String value) {
            addCriterion("car_system <", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemLessThanOrEqualTo(String value) {
            addCriterion("car_system <=", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemLike(String value) {
            addCriterion("car_system like", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemNotLike(String value) {
            addCriterion("car_system not like", value, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemIn(List<String> values) {
            addCriterion("car_system in", values, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemNotIn(List<String> values) {
            addCriterion("car_system not in", values, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemBetween(String value1, String value2) {
            addCriterion("car_system between", value1, value2, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarSystemNotBetween(String value1, String value2) {
            addCriterion("car_system not between", value1, value2, "carSystem");
            return (Criteria) this;
        }

        public Criteria andCarModelIsNull() {
            addCriterion("car_model is null");
            return (Criteria) this;
        }

        public Criteria andCarModelIsNotNull() {
            addCriterion("car_model is not null");
            return (Criteria) this;
        }

        public Criteria andCarModelEqualTo(String value) {
            addCriterion("car_model =", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelNotEqualTo(String value) {
            addCriterion("car_model <>", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelGreaterThan(String value) {
            addCriterion("car_model >", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelGreaterThanOrEqualTo(String value) {
            addCriterion("car_model >=", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelLessThan(String value) {
            addCriterion("car_model <", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelLessThanOrEqualTo(String value) {
            addCriterion("car_model <=", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelLike(String value) {
            addCriterion("car_model like", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelNotLike(String value) {
            addCriterion("car_model not like", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelIn(List<String> values) {
            addCriterion("car_model in", values, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelNotIn(List<String> values) {
            addCriterion("car_model not in", values, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelBetween(String value1, String value2) {
            addCriterion("car_model between", value1, value2, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelNotBetween(String value1, String value2) {
            addCriterion("car_model not between", value1, value2, "carModel");
            return (Criteria) this;
        }

        public Criteria andSalesNameIsNull() {
            addCriterion("sales_name is null");
            return (Criteria) this;
        }

        public Criteria andSalesNameIsNotNull() {
            addCriterion("sales_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalesNameEqualTo(String value) {
            addCriterion("sales_name =", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotEqualTo(String value) {
            addCriterion("sales_name <>", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameGreaterThan(String value) {
            addCriterion("sales_name >", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameGreaterThanOrEqualTo(String value) {
            addCriterion("sales_name >=", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLessThan(String value) {
            addCriterion("sales_name <", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLessThanOrEqualTo(String value) {
            addCriterion("sales_name <=", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLike(String value) {
            addCriterion("sales_name like", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotLike(String value) {
            addCriterion("sales_name not like", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameIn(List<String> values) {
            addCriterion("sales_name in", values, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotIn(List<String> values) {
            addCriterion("sales_name not in", values, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameBetween(String value1, String value2) {
            addCriterion("sales_name between", value1, value2, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotBetween(String value1, String value2) {
            addCriterion("sales_name not between", value1, value2, "salesName");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardIsNull() {
            addCriterion("emission_standard is null");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardIsNotNull() {
            addCriterion("emission_standard is not null");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardEqualTo(String value) {
            addCriterion("emission_standard =", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardNotEqualTo(String value) {
            addCriterion("emission_standard <>", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardGreaterThan(String value) {
            addCriterion("emission_standard >", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardGreaterThanOrEqualTo(String value) {
            addCriterion("emission_standard >=", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardLessThan(String value) {
            addCriterion("emission_standard <", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardLessThanOrEqualTo(String value) {
            addCriterion("emission_standard <=", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardLike(String value) {
            addCriterion("emission_standard like", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardNotLike(String value) {
            addCriterion("emission_standard not like", value, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardIn(List<String> values) {
            addCriterion("emission_standard in", values, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardNotIn(List<String> values) {
            addCriterion("emission_standard not in", values, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardBetween(String value1, String value2) {
            addCriterion("emission_standard between", value1, value2, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andEmissionStandardNotBetween(String value1, String value2) {
            addCriterion("emission_standard not between", value1, value2, "emissionStandard");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andListedYearIsNull() {
            addCriterion("listed_year is null");
            return (Criteria) this;
        }

        public Criteria andListedYearIsNotNull() {
            addCriterion("listed_year is not null");
            return (Criteria) this;
        }

        public Criteria andListedYearEqualTo(String value) {
            addCriterion("listed_year =", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearNotEqualTo(String value) {
            addCriterion("listed_year <>", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearGreaterThan(String value) {
            addCriterion("listed_year >", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearGreaterThanOrEqualTo(String value) {
            addCriterion("listed_year >=", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearLessThan(String value) {
            addCriterion("listed_year <", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearLessThanOrEqualTo(String value) {
            addCriterion("listed_year <=", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearLike(String value) {
            addCriterion("listed_year like", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearNotLike(String value) {
            addCriterion("listed_year not like", value, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearIn(List<String> values) {
            addCriterion("listed_year in", values, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearNotIn(List<String> values) {
            addCriterion("listed_year not in", values, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearBetween(String value1, String value2) {
            addCriterion("listed_year between", value1, value2, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedYearNotBetween(String value1, String value2) {
            addCriterion("listed_year not between", value1, value2, "listedYear");
            return (Criteria) this;
        }

        public Criteria andListedMonthIsNull() {
            addCriterion("listed_month is null");
            return (Criteria) this;
        }

        public Criteria andListedMonthIsNotNull() {
            addCriterion("listed_month is not null");
            return (Criteria) this;
        }

        public Criteria andListedMonthEqualTo(String value) {
            addCriterion("listed_month =", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthNotEqualTo(String value) {
            addCriterion("listed_month <>", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthGreaterThan(String value) {
            addCriterion("listed_month >", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthGreaterThanOrEqualTo(String value) {
            addCriterion("listed_month >=", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthLessThan(String value) {
            addCriterion("listed_month <", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthLessThanOrEqualTo(String value) {
            addCriterion("listed_month <=", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthLike(String value) {
            addCriterion("listed_month like", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthNotLike(String value) {
            addCriterion("listed_month not like", value, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthIn(List<String> values) {
            addCriterion("listed_month in", values, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthNotIn(List<String> values) {
            addCriterion("listed_month not in", values, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthBetween(String value1, String value2) {
            addCriterion("listed_month between", value1, value2, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andListedMonthNotBetween(String value1, String value2) {
            addCriterion("listed_month not between", value1, value2, "listedMonth");
            return (Criteria) this;
        }

        public Criteria andProductionYearIsNull() {
            addCriterion("production_year is null");
            return (Criteria) this;
        }

        public Criteria andProductionYearIsNotNull() {
            addCriterion("production_year is not null");
            return (Criteria) this;
        }

        public Criteria andProductionYearEqualTo(String value) {
            addCriterion("production_year =", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearNotEqualTo(String value) {
            addCriterion("production_year <>", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearGreaterThan(String value) {
            addCriterion("production_year >", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearGreaterThanOrEqualTo(String value) {
            addCriterion("production_year >=", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearLessThan(String value) {
            addCriterion("production_year <", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearLessThanOrEqualTo(String value) {
            addCriterion("production_year <=", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearLike(String value) {
            addCriterion("production_year like", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearNotLike(String value) {
            addCriterion("production_year not like", value, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearIn(List<String> values) {
            addCriterion("production_year in", values, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearNotIn(List<String> values) {
            addCriterion("production_year not in", values, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearBetween(String value1, String value2) {
            addCriterion("production_year between", value1, value2, "productionYear");
            return (Criteria) this;
        }

        public Criteria andProductionYearNotBetween(String value1, String value2) {
            addCriterion("production_year not between", value1, value2, "productionYear");
            return (Criteria) this;
        }

        public Criteria andStopYearIsNull() {
            addCriterion("stop_year is null");
            return (Criteria) this;
        }

        public Criteria andStopYearIsNotNull() {
            addCriterion("stop_year is not null");
            return (Criteria) this;
        }

        public Criteria andStopYearEqualTo(String value) {
            addCriterion("stop_year =", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearNotEqualTo(String value) {
            addCriterion("stop_year <>", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearGreaterThan(String value) {
            addCriterion("stop_year >", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearGreaterThanOrEqualTo(String value) {
            addCriterion("stop_year >=", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearLessThan(String value) {
            addCriterion("stop_year <", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearLessThanOrEqualTo(String value) {
            addCriterion("stop_year <=", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearLike(String value) {
            addCriterion("stop_year like", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearNotLike(String value) {
            addCriterion("stop_year not like", value, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearIn(List<String> values) {
            addCriterion("stop_year in", values, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearNotIn(List<String> values) {
            addCriterion("stop_year not in", values, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearBetween(String value1, String value2) {
            addCriterion("stop_year between", value1, value2, "stopYear");
            return (Criteria) this;
        }

        public Criteria andStopYearNotBetween(String value1, String value2) {
            addCriterion("stop_year not between", value1, value2, "stopYear");
            return (Criteria) this;
        }

        public Criteria andCountriesIsNull() {
            addCriterion("countries is null");
            return (Criteria) this;
        }

        public Criteria andCountriesIsNotNull() {
            addCriterion("countries is not null");
            return (Criteria) this;
        }

        public Criteria andCountriesEqualTo(String value) {
            addCriterion("countries =", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotEqualTo(String value) {
            addCriterion("countries <>", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesGreaterThan(String value) {
            addCriterion("countries >", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesGreaterThanOrEqualTo(String value) {
            addCriterion("countries >=", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLessThan(String value) {
            addCriterion("countries <", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLessThanOrEqualTo(String value) {
            addCriterion("countries <=", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLike(String value) {
            addCriterion("countries like", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotLike(String value) {
            addCriterion("countries not like", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesIn(List<String> values) {
            addCriterion("countries in", values, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotIn(List<String> values) {
            addCriterion("countries not in", values, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesBetween(String value1, String value2) {
            addCriterion("countries between", value1, value2, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotBetween(String value1, String value2) {
            addCriterion("countries not between", value1, value2, "countries");
            return (Criteria) this;
        }

        public Criteria andJointStockIsNull() {
            addCriterion("joint_stock is null");
            return (Criteria) this;
        }

        public Criteria andJointStockIsNotNull() {
            addCriterion("joint_stock is not null");
            return (Criteria) this;
        }

        public Criteria andJointStockEqualTo(String value) {
            addCriterion("joint_stock =", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockNotEqualTo(String value) {
            addCriterion("joint_stock <>", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockGreaterThan(String value) {
            addCriterion("joint_stock >", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockGreaterThanOrEqualTo(String value) {
            addCriterion("joint_stock >=", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockLessThan(String value) {
            addCriterion("joint_stock <", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockLessThanOrEqualTo(String value) {
            addCriterion("joint_stock <=", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockLike(String value) {
            addCriterion("joint_stock like", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockNotLike(String value) {
            addCriterion("joint_stock not like", value, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockIn(List<String> values) {
            addCriterion("joint_stock in", values, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockNotIn(List<String> values) {
            addCriterion("joint_stock not in", values, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockBetween(String value1, String value2) {
            addCriterion("joint_stock between", value1, value2, "jointStock");
            return (Criteria) this;
        }

        public Criteria andJointStockNotBetween(String value1, String value2) {
            addCriterion("joint_stock not between", value1, value2, "jointStock");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeIsNull() {
            addCriterion("cylinder_volume is null");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeIsNotNull() {
            addCriterion("cylinder_volume is not null");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeEqualTo(String value) {
            addCriterion("cylinder_volume =", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeNotEqualTo(String value) {
            addCriterion("cylinder_volume <>", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeGreaterThan(String value) {
            addCriterion("cylinder_volume >", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeGreaterThanOrEqualTo(String value) {
            addCriterion("cylinder_volume >=", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeLessThan(String value) {
            addCriterion("cylinder_volume <", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeLessThanOrEqualTo(String value) {
            addCriterion("cylinder_volume <=", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeLike(String value) {
            addCriterion("cylinder_volume like", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeNotLike(String value) {
            addCriterion("cylinder_volume not like", value, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeIn(List<String> values) {
            addCriterion("cylinder_volume in", values, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeNotIn(List<String> values) {
            addCriterion("cylinder_volume not in", values, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeBetween(String value1, String value2) {
            addCriterion("cylinder_volume between", value1, value2, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andCylinderVolumeNotBetween(String value1, String value2) {
            addCriterion("cylinder_volume not between", value1, value2, "cylinderVolume");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNull() {
            addCriterion("displacement is null");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNotNull() {
            addCriterion("displacement is not null");
            return (Criteria) this;
        }

        public Criteria andDisplacementEqualTo(String value) {
            addCriterion("displacement =", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotEqualTo(String value) {
            addCriterion("displacement <>", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThan(String value) {
            addCriterion("displacement >", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThanOrEqualTo(String value) {
            addCriterion("displacement >=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThan(String value) {
            addCriterion("displacement <", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThanOrEqualTo(String value) {
            addCriterion("displacement <=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLike(String value) {
            addCriterion("displacement like", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotLike(String value) {
            addCriterion("displacement not like", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementIn(List<String> values) {
            addCriterion("displacement in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotIn(List<String> values) {
            addCriterion("displacement not in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementBetween(String value1, String value2) {
            addCriterion("displacement between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotBetween(String value1, String value2) {
            addCriterion("displacement not between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andIntakeFormIsNull() {
            addCriterion("Intake_form is null");
            return (Criteria) this;
        }

        public Criteria andIntakeFormIsNotNull() {
            addCriterion("Intake_form is not null");
            return (Criteria) this;
        }

        public Criteria andIntakeFormEqualTo(String value) {
            addCriterion("Intake_form =", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormNotEqualTo(String value) {
            addCriterion("Intake_form <>", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormGreaterThan(String value) {
            addCriterion("Intake_form >", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormGreaterThanOrEqualTo(String value) {
            addCriterion("Intake_form >=", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormLessThan(String value) {
            addCriterion("Intake_form <", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormLessThanOrEqualTo(String value) {
            addCriterion("Intake_form <=", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormLike(String value) {
            addCriterion("Intake_form like", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormNotLike(String value) {
            addCriterion("Intake_form not like", value, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormIn(List<String> values) {
            addCriterion("Intake_form in", values, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormNotIn(List<String> values) {
            addCriterion("Intake_form not in", values, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormBetween(String value1, String value2) {
            addCriterion("Intake_form between", value1, value2, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andIntakeFormNotBetween(String value1, String value2) {
            addCriterion("Intake_form not between", value1, value2, "intakeForm");
            return (Criteria) this;
        }

        public Criteria andFuelTypeIsNull() {
            addCriterion("fuel_type is null");
            return (Criteria) this;
        }

        public Criteria andFuelTypeIsNotNull() {
            addCriterion("fuel_type is not null");
            return (Criteria) this;
        }

        public Criteria andFuelTypeEqualTo(String value) {
            addCriterion("fuel_type =", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeNotEqualTo(String value) {
            addCriterion("fuel_type <>", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeGreaterThan(String value) {
            addCriterion("fuel_type >", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fuel_type >=", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeLessThan(String value) {
            addCriterion("fuel_type <", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeLessThanOrEqualTo(String value) {
            addCriterion("fuel_type <=", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeLike(String value) {
            addCriterion("fuel_type like", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeNotLike(String value) {
            addCriterion("fuel_type not like", value, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeIn(List<String> values) {
            addCriterion("fuel_type in", values, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeNotIn(List<String> values) {
            addCriterion("fuel_type not in", values, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeBetween(String value1, String value2) {
            addCriterion("fuel_type between", value1, value2, "fuelType");
            return (Criteria) this;
        }

        public Criteria andFuelTypeNotBetween(String value1, String value2) {
            addCriterion("fuel_type not between", value1, value2, "fuelType");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerIsNull() {
            addCriterion("maximum_power is null");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerIsNotNull() {
            addCriterion("maximum_power is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerEqualTo(String value) {
            addCriterion("maximum_power =", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotEqualTo(String value) {
            addCriterion("maximum_power <>", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerGreaterThan(String value) {
            addCriterion("maximum_power >", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerGreaterThanOrEqualTo(String value) {
            addCriterion("maximum_power >=", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerLessThan(String value) {
            addCriterion("maximum_power <", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerLessThanOrEqualTo(String value) {
            addCriterion("maximum_power <=", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerLike(String value) {
            addCriterion("maximum_power like", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotLike(String value) {
            addCriterion("maximum_power not like", value, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerIn(List<String> values) {
            addCriterion("maximum_power in", values, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotIn(List<String> values) {
            addCriterion("maximum_power not in", values, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerBetween(String value1, String value2) {
            addCriterion("maximum_power between", value1, value2, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumPowerNotBetween(String value1, String value2) {
            addCriterion("maximum_power not between", value1, value2, "maximumPower");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueIsNull() {
            addCriterion("maximum_torque is null");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueIsNotNull() {
            addCriterion("maximum_torque is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueEqualTo(String value) {
            addCriterion("maximum_torque =", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotEqualTo(String value) {
            addCriterion("maximum_torque <>", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueGreaterThan(String value) {
            addCriterion("maximum_torque >", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueGreaterThanOrEqualTo(String value) {
            addCriterion("maximum_torque >=", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueLessThan(String value) {
            addCriterion("maximum_torque <", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueLessThanOrEqualTo(String value) {
            addCriterion("maximum_torque <=", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueLike(String value) {
            addCriterion("maximum_torque like", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotLike(String value) {
            addCriterion("maximum_torque not like", value, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueIn(List<String> values) {
            addCriterion("maximum_torque in", values, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotIn(List<String> values) {
            addCriterion("maximum_torque not in", values, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueBetween(String value1, String value2) {
            addCriterion("maximum_torque between", value1, value2, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andMaximumTorqueNotBetween(String value1, String value2) {
            addCriterion("maximum_torque not between", value1, value2, "maximumTorque");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementIsNull() {
            addCriterion("cylinder_arrangement is null");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementIsNotNull() {
            addCriterion("cylinder_arrangement is not null");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementEqualTo(String value) {
            addCriterion("cylinder_arrangement =", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementNotEqualTo(String value) {
            addCriterion("cylinder_arrangement <>", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementGreaterThan(String value) {
            addCriterion("cylinder_arrangement >", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementGreaterThanOrEqualTo(String value) {
            addCriterion("cylinder_arrangement >=", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementLessThan(String value) {
            addCriterion("cylinder_arrangement <", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementLessThanOrEqualTo(String value) {
            addCriterion("cylinder_arrangement <=", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementLike(String value) {
            addCriterion("cylinder_arrangement like", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementNotLike(String value) {
            addCriterion("cylinder_arrangement not like", value, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementIn(List<String> values) {
            addCriterion("cylinder_arrangement in", values, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementNotIn(List<String> values) {
            addCriterion("cylinder_arrangement not in", values, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementBetween(String value1, String value2) {
            addCriterion("cylinder_arrangement between", value1, value2, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderArrangementNotBetween(String value1, String value2) {
            addCriterion("cylinder_arrangement not between", value1, value2, "cylinderArrangement");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberIsNull() {
            addCriterion("cylinder_number is null");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberIsNotNull() {
            addCriterion("cylinder_number is not null");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberEqualTo(String value) {
            addCriterion("cylinder_number =", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberNotEqualTo(String value) {
            addCriterion("cylinder_number <>", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberGreaterThan(String value) {
            addCriterion("cylinder_number >", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("cylinder_number >=", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberLessThan(String value) {
            addCriterion("cylinder_number <", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberLessThanOrEqualTo(String value) {
            addCriterion("cylinder_number <=", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberLike(String value) {
            addCriterion("cylinder_number like", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberNotLike(String value) {
            addCriterion("cylinder_number not like", value, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberIn(List<String> values) {
            addCriterion("cylinder_number in", values, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberNotIn(List<String> values) {
            addCriterion("cylinder_number not in", values, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberBetween(String value1, String value2) {
            addCriterion("cylinder_number between", value1, value2, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCylinderNumberNotBetween(String value1, String value2) {
            addCriterion("cylinder_number not between", value1, value2, "cylinderNumber");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioIsNull() {
            addCriterion("compression_ratio is null");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioIsNotNull() {
            addCriterion("compression_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioEqualTo(String value) {
            addCriterion("compression_ratio =", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioNotEqualTo(String value) {
            addCriterion("compression_ratio <>", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioGreaterThan(String value) {
            addCriterion("compression_ratio >", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioGreaterThanOrEqualTo(String value) {
            addCriterion("compression_ratio >=", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioLessThan(String value) {
            addCriterion("compression_ratio <", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioLessThanOrEqualTo(String value) {
            addCriterion("compression_ratio <=", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioLike(String value) {
            addCriterion("compression_ratio like", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioNotLike(String value) {
            addCriterion("compression_ratio not like", value, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioIn(List<String> values) {
            addCriterion("compression_ratio in", values, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioNotIn(List<String> values) {
            addCriterion("compression_ratio not in", values, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioBetween(String value1, String value2) {
            addCriterion("compression_ratio between", value1, value2, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andCompressionRatioNotBetween(String value1, String value2) {
            addCriterion("compression_ratio not between", value1, value2, "compressionRatio");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeIsNull() {
            addCriterion("oil_supply_mode is null");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeIsNotNull() {
            addCriterion("oil_supply_mode is not null");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeEqualTo(String value) {
            addCriterion("oil_supply_mode =", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeNotEqualTo(String value) {
            addCriterion("oil_supply_mode <>", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeGreaterThan(String value) {
            addCriterion("oil_supply_mode >", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeGreaterThanOrEqualTo(String value) {
            addCriterion("oil_supply_mode >=", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeLessThan(String value) {
            addCriterion("oil_supply_mode <", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeLessThanOrEqualTo(String value) {
            addCriterion("oil_supply_mode <=", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeLike(String value) {
            addCriterion("oil_supply_mode like", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeNotLike(String value) {
            addCriterion("oil_supply_mode not like", value, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeIn(List<String> values) {
            addCriterion("oil_supply_mode in", values, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeNotIn(List<String> values) {
            addCriterion("oil_supply_mode not in", values, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeBetween(String value1, String value2) {
            addCriterion("oil_supply_mode between", value1, value2, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andOilSupplyModeNotBetween(String value1, String value2) {
            addCriterion("oil_supply_mode not between", value1, value2, "oilSupplyMode");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionIsNull() {
            addCriterion("transmission_description is null");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionIsNotNull() {
            addCriterion("transmission_description is not null");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionEqualTo(String value) {
            addCriterion("transmission_description =", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionNotEqualTo(String value) {
            addCriterion("transmission_description <>", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionGreaterThan(String value) {
            addCriterion("transmission_description >", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("transmission_description >=", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionLessThan(String value) {
            addCriterion("transmission_description <", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("transmission_description <=", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionLike(String value) {
            addCriterion("transmission_description like", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionNotLike(String value) {
            addCriterion("transmission_description not like", value, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionIn(List<String> values) {
            addCriterion("transmission_description in", values, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionNotIn(List<String> values) {
            addCriterion("transmission_description not in", values, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionBetween(String value1, String value2) {
            addCriterion("transmission_description between", value1, value2, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andTransmissionDescriptionNotBetween(String value1, String value2) {
            addCriterion("transmission_description not between", value1, value2, "transmissionDescription");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsIsNull() {
            addCriterion("number_of_gears is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsIsNotNull() {
            addCriterion("number_of_gears is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsEqualTo(String value) {
            addCriterion("number_of_gears =", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsNotEqualTo(String value) {
            addCriterion("number_of_gears <>", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsGreaterThan(String value) {
            addCriterion("number_of_gears >", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsGreaterThanOrEqualTo(String value) {
            addCriterion("number_of_gears >=", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsLessThan(String value) {
            addCriterion("number_of_gears <", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsLessThanOrEqualTo(String value) {
            addCriterion("number_of_gears <=", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsLike(String value) {
            addCriterion("number_of_gears like", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsNotLike(String value) {
            addCriterion("number_of_gears not like", value, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsIn(List<String> values) {
            addCriterion("number_of_gears in", values, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsNotIn(List<String> values) {
            addCriterion("number_of_gears not in", values, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsBetween(String value1, String value2) {
            addCriterion("number_of_gears between", value1, value2, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andNumberOfGearsNotBetween(String value1, String value2) {
            addCriterion("number_of_gears not between", value1, value2, "numberOfGears");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeIsNull() {
            addCriterion("front_brake_type is null");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeIsNotNull() {
            addCriterion("front_brake_type is not null");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeEqualTo(String value) {
            addCriterion("front_brake_type =", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeNotEqualTo(String value) {
            addCriterion("front_brake_type <>", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeGreaterThan(String value) {
            addCriterion("front_brake_type >", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("front_brake_type >=", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeLessThan(String value) {
            addCriterion("front_brake_type <", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeLessThanOrEqualTo(String value) {
            addCriterion("front_brake_type <=", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeLike(String value) {
            addCriterion("front_brake_type like", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeNotLike(String value) {
            addCriterion("front_brake_type not like", value, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeIn(List<String> values) {
            addCriterion("front_brake_type in", values, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeNotIn(List<String> values) {
            addCriterion("front_brake_type not in", values, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeBetween(String value1, String value2) {
            addCriterion("front_brake_type between", value1, value2, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontBrakeTypeNotBetween(String value1, String value2) {
            addCriterion("front_brake_type not between", value1, value2, "frontBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeIsNull() {
            addCriterion("rear_brake_type is null");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeIsNotNull() {
            addCriterion("rear_brake_type is not null");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeEqualTo(String value) {
            addCriterion("rear_brake_type =", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeNotEqualTo(String value) {
            addCriterion("rear_brake_type <>", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeGreaterThan(String value) {
            addCriterion("rear_brake_type >", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rear_brake_type >=", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeLessThan(String value) {
            addCriterion("rear_brake_type <", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeLessThanOrEqualTo(String value) {
            addCriterion("rear_brake_type <=", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeLike(String value) {
            addCriterion("rear_brake_type like", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeNotLike(String value) {
            addCriterion("rear_brake_type not like", value, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeIn(List<String> values) {
            addCriterion("rear_brake_type in", values, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeNotIn(List<String> values) {
            addCriterion("rear_brake_type not in", values, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeBetween(String value1, String value2) {
            addCriterion("rear_brake_type between", value1, value2, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andRearBrakeTypeNotBetween(String value1, String value2) {
            addCriterion("rear_brake_type not between", value1, value2, "rearBrakeType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeIsNull() {
            addCriterion("front_suspension_type is null");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeIsNotNull() {
            addCriterion("front_suspension_type is not null");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeEqualTo(String value) {
            addCriterion("front_suspension_type =", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeNotEqualTo(String value) {
            addCriterion("front_suspension_type <>", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeGreaterThan(String value) {
            addCriterion("front_suspension_type >", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("front_suspension_type >=", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeLessThan(String value) {
            addCriterion("front_suspension_type <", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeLessThanOrEqualTo(String value) {
            addCriterion("front_suspension_type <=", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeLike(String value) {
            addCriterion("front_suspension_type like", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeNotLike(String value) {
            addCriterion("front_suspension_type not like", value, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeIn(List<String> values) {
            addCriterion("front_suspension_type in", values, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeNotIn(List<String> values) {
            addCriterion("front_suspension_type not in", values, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeBetween(String value1, String value2) {
            addCriterion("front_suspension_type between", value1, value2, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andFrontSuspensionTypeNotBetween(String value1, String value2) {
            addCriterion("front_suspension_type not between", value1, value2, "frontSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeIsNull() {
            addCriterion("rear_suspension_type is null");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeIsNotNull() {
            addCriterion("rear_suspension_type is not null");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeEqualTo(String value) {
            addCriterion("rear_suspension_type =", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeNotEqualTo(String value) {
            addCriterion("rear_suspension_type <>", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeGreaterThan(String value) {
            addCriterion("rear_suspension_type >", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rear_suspension_type >=", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeLessThan(String value) {
            addCriterion("rear_suspension_type <", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeLessThanOrEqualTo(String value) {
            addCriterion("rear_suspension_type <=", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeLike(String value) {
            addCriterion("rear_suspension_type like", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeNotLike(String value) {
            addCriterion("rear_suspension_type not like", value, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeIn(List<String> values) {
            addCriterion("rear_suspension_type in", values, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeNotIn(List<String> values) {
            addCriterion("rear_suspension_type not in", values, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeBetween(String value1, String value2) {
            addCriterion("rear_suspension_type between", value1, value2, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andRearSuspensionTypeNotBetween(String value1, String value2) {
            addCriterion("rear_suspension_type not between", value1, value2, "rearSuspensionType");
            return (Criteria) this;
        }

        public Criteria andDrivingModeIsNull() {
            addCriterion("driving_mode is null");
            return (Criteria) this;
        }

        public Criteria andDrivingModeIsNotNull() {
            addCriterion("driving_mode is not null");
            return (Criteria) this;
        }

        public Criteria andDrivingModeEqualTo(String value) {
            addCriterion("driving_mode =", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeNotEqualTo(String value) {
            addCriterion("driving_mode <>", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeGreaterThan(String value) {
            addCriterion("driving_mode >", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeGreaterThanOrEqualTo(String value) {
            addCriterion("driving_mode >=", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeLessThan(String value) {
            addCriterion("driving_mode <", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeLessThanOrEqualTo(String value) {
            addCriterion("driving_mode <=", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeLike(String value) {
            addCriterion("driving_mode like", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeNotLike(String value) {
            addCriterion("driving_mode not like", value, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeIn(List<String> values) {
            addCriterion("driving_mode in", values, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeNotIn(List<String> values) {
            addCriterion("driving_mode not in", values, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeBetween(String value1, String value2) {
            addCriterion("driving_mode between", value1, value2, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andDrivingModeNotBetween(String value1, String value2) {
            addCriterion("driving_mode not between", value1, value2, "drivingMode");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeIsNull() {
            addCriterion("car_body_type is null");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeIsNotNull() {
            addCriterion("car_body_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeEqualTo(String value) {
            addCriterion("car_body_type =", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeNotEqualTo(String value) {
            addCriterion("car_body_type <>", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeGreaterThan(String value) {
            addCriterion("car_body_type >", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_body_type >=", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeLessThan(String value) {
            addCriterion("car_body_type <", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeLessThanOrEqualTo(String value) {
            addCriterion("car_body_type <=", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeLike(String value) {
            addCriterion("car_body_type like", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeNotLike(String value) {
            addCriterion("car_body_type not like", value, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeIn(List<String> values) {
            addCriterion("car_body_type in", values, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeNotIn(List<String> values) {
            addCriterion("car_body_type not in", values, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeBetween(String value1, String value2) {
            addCriterion("car_body_type between", value1, value2, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarBodyTypeNotBetween(String value1, String value2) {
            addCriterion("car_body_type not between", value1, value2, "carBodyType");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberIsNull() {
            addCriterion("car_doors_number is null");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberIsNotNull() {
            addCriterion("car_doors_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberEqualTo(String value) {
            addCriterion("car_doors_number =", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberNotEqualTo(String value) {
            addCriterion("car_doors_number <>", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberGreaterThan(String value) {
            addCriterion("car_doors_number >", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_doors_number >=", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberLessThan(String value) {
            addCriterion("car_doors_number <", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberLessThanOrEqualTo(String value) {
            addCriterion("car_doors_number <=", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberLike(String value) {
            addCriterion("car_doors_number like", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberNotLike(String value) {
            addCriterion("car_doors_number not like", value, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberIn(List<String> values) {
            addCriterion("car_doors_number in", values, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberNotIn(List<String> values) {
            addCriterion("car_doors_number not in", values, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberBetween(String value1, String value2) {
            addCriterion("car_doors_number between", value1, value2, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andCarDoorsNumberNotBetween(String value1, String value2) {
            addCriterion("car_doors_number not between", value1, value2, "carDoorsNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberIsNull() {
            addCriterion("pedestal_number is null");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberIsNotNull() {
            addCriterion("pedestal_number is not null");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberEqualTo(String value) {
            addCriterion("pedestal_number =", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberNotEqualTo(String value) {
            addCriterion("pedestal_number <>", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberGreaterThan(String value) {
            addCriterion("pedestal_number >", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("pedestal_number >=", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberLessThan(String value) {
            addCriterion("pedestal_number <", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberLessThanOrEqualTo(String value) {
            addCriterion("pedestal_number <=", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberLike(String value) {
            addCriterion("pedestal_number like", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberNotLike(String value) {
            addCriterion("pedestal_number not like", value, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberIn(List<String> values) {
            addCriterion("pedestal_number in", values, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberNotIn(List<String> values) {
            addCriterion("pedestal_number not in", values, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberBetween(String value1, String value2) {
            addCriterion("pedestal_number between", value1, value2, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andPedestalNumberNotBetween(String value1, String value2) {
            addCriterion("pedestal_number not between", value1, value2, "pedestalNumber");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationIsNull() {
            addCriterion("front_tire_specification is null");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationIsNotNull() {
            addCriterion("front_tire_specification is not null");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationEqualTo(String value) {
            addCriterion("front_tire_specification =", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationNotEqualTo(String value) {
            addCriterion("front_tire_specification <>", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationGreaterThan(String value) {
            addCriterion("front_tire_specification >", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("front_tire_specification >=", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationLessThan(String value) {
            addCriterion("front_tire_specification <", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationLessThanOrEqualTo(String value) {
            addCriterion("front_tire_specification <=", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationLike(String value) {
            addCriterion("front_tire_specification like", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationNotLike(String value) {
            addCriterion("front_tire_specification not like", value, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationIn(List<String> values) {
            addCriterion("front_tire_specification in", values, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationNotIn(List<String> values) {
            addCriterion("front_tire_specification not in", values, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationBetween(String value1, String value2) {
            addCriterion("front_tire_specification between", value1, value2, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontTireSpecificationNotBetween(String value1, String value2) {
            addCriterion("front_tire_specification not between", value1, value2, "frontTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationIsNull() {
            addCriterion("rear_tire_specification is null");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationIsNotNull() {
            addCriterion("rear_tire_specification is not null");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationEqualTo(String value) {
            addCriterion("rear_tire_specification =", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationNotEqualTo(String value) {
            addCriterion("rear_tire_specification <>", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationGreaterThan(String value) {
            addCriterion("rear_tire_specification >", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("rear_tire_specification >=", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationLessThan(String value) {
            addCriterion("rear_tire_specification <", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationLessThanOrEqualTo(String value) {
            addCriterion("rear_tire_specification <=", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationLike(String value) {
            addCriterion("rear_tire_specification like", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationNotLike(String value) {
            addCriterion("rear_tire_specification not like", value, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationIn(List<String> values) {
            addCriterion("rear_tire_specification in", values, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationNotIn(List<String> values) {
            addCriterion("rear_tire_specification not in", values, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationBetween(String value1, String value2) {
            addCriterion("rear_tire_specification between", value1, value2, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andRearTireSpecificationNotBetween(String value1, String value2) {
            addCriterion("rear_tire_specification not between", value1, value2, "rearTireSpecification");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeIsNull() {
            addCriterion("front_wheel_type is null");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeIsNotNull() {
            addCriterion("front_wheel_type is not null");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeEqualTo(String value) {
            addCriterion("front_wheel_type =", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeNotEqualTo(String value) {
            addCriterion("front_wheel_type <>", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeGreaterThan(String value) {
            addCriterion("front_wheel_type >", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("front_wheel_type >=", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeLessThan(String value) {
            addCriterion("front_wheel_type <", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeLessThanOrEqualTo(String value) {
            addCriterion("front_wheel_type <=", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeLike(String value) {
            addCriterion("front_wheel_type like", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeNotLike(String value) {
            addCriterion("front_wheel_type not like", value, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeIn(List<String> values) {
            addCriterion("front_wheel_type in", values, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeNotIn(List<String> values) {
            addCriterion("front_wheel_type not in", values, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeBetween(String value1, String value2) {
            addCriterion("front_wheel_type between", value1, value2, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andFrontWheelTypeNotBetween(String value1, String value2) {
            addCriterion("front_wheel_type not between", value1, value2, "frontWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeIsNull() {
            addCriterion("rear_wheel_type is null");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeIsNotNull() {
            addCriterion("rear_wheel_type is not null");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeEqualTo(String value) {
            addCriterion("rear_wheel_type =", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeNotEqualTo(String value) {
            addCriterion("rear_wheel_type <>", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeGreaterThan(String value) {
            addCriterion("rear_wheel_type >", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rear_wheel_type >=", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeLessThan(String value) {
            addCriterion("rear_wheel_type <", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeLessThanOrEqualTo(String value) {
            addCriterion("rear_wheel_type <=", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeLike(String value) {
            addCriterion("rear_wheel_type like", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeNotLike(String value) {
            addCriterion("rear_wheel_type not like", value, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeIn(List<String> values) {
            addCriterion("rear_wheel_type in", values, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeNotIn(List<String> values) {
            addCriterion("rear_wheel_type not in", values, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeBetween(String value1, String value2) {
            addCriterion("rear_wheel_type between", value1, value2, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andRearWheelTypeNotBetween(String value1, String value2) {
            addCriterion("rear_wheel_type not between", value1, value2, "rearWheelType");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampIsNull() {
            addCriterion("xenon_headlamp is null");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampIsNotNull() {
            addCriterion("xenon_headlamp is not null");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampEqualTo(String value) {
            addCriterion("xenon_headlamp =", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampNotEqualTo(String value) {
            addCriterion("xenon_headlamp <>", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampGreaterThan(String value) {
            addCriterion("xenon_headlamp >", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampGreaterThanOrEqualTo(String value) {
            addCriterion("xenon_headlamp >=", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampLessThan(String value) {
            addCriterion("xenon_headlamp <", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampLessThanOrEqualTo(String value) {
            addCriterion("xenon_headlamp <=", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampLike(String value) {
            addCriterion("xenon_headlamp like", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampNotLike(String value) {
            addCriterion("xenon_headlamp not like", value, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampIn(List<String> values) {
            addCriterion("xenon_headlamp in", values, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampNotIn(List<String> values) {
            addCriterion("xenon_headlamp not in", values, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampBetween(String value1, String value2) {
            addCriterion("xenon_headlamp between", value1, value2, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andXenonHeadlampNotBetween(String value1, String value2) {
            addCriterion("xenon_headlamp not between", value1, value2, "xenonHeadlamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampIsNull() {
            addCriterion("front_fog_lamp is null");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampIsNotNull() {
            addCriterion("front_fog_lamp is not null");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampEqualTo(String value) {
            addCriterion("front_fog_lamp =", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampNotEqualTo(String value) {
            addCriterion("front_fog_lamp <>", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampGreaterThan(String value) {
            addCriterion("front_fog_lamp >", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampGreaterThanOrEqualTo(String value) {
            addCriterion("front_fog_lamp >=", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampLessThan(String value) {
            addCriterion("front_fog_lamp <", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampLessThanOrEqualTo(String value) {
            addCriterion("front_fog_lamp <=", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampLike(String value) {
            addCriterion("front_fog_lamp like", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampNotLike(String value) {
            addCriterion("front_fog_lamp not like", value, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampIn(List<String> values) {
            addCriterion("front_fog_lamp in", values, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampNotIn(List<String> values) {
            addCriterion("front_fog_lamp not in", values, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampBetween(String value1, String value2) {
            addCriterion("front_fog_lamp between", value1, value2, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andFrontFogLampNotBetween(String value1, String value2) {
            addCriterion("front_fog_lamp not between", value1, value2, "frontFogLamp");
            return (Criteria) this;
        }

        public Criteria andRearWiperIsNull() {
            addCriterion("rear_wiper is null");
            return (Criteria) this;
        }

        public Criteria andRearWiperIsNotNull() {
            addCriterion("rear_wiper is not null");
            return (Criteria) this;
        }

        public Criteria andRearWiperEqualTo(String value) {
            addCriterion("rear_wiper =", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperNotEqualTo(String value) {
            addCriterion("rear_wiper <>", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperGreaterThan(String value) {
            addCriterion("rear_wiper >", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperGreaterThanOrEqualTo(String value) {
            addCriterion("rear_wiper >=", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperLessThan(String value) {
            addCriterion("rear_wiper <", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperLessThanOrEqualTo(String value) {
            addCriterion("rear_wiper <=", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperLike(String value) {
            addCriterion("rear_wiper like", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperNotLike(String value) {
            addCriterion("rear_wiper not like", value, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperIn(List<String> values) {
            addCriterion("rear_wiper in", values, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperNotIn(List<String> values) {
            addCriterion("rear_wiper not in", values, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperBetween(String value1, String value2) {
            addCriterion("rear_wiper between", value1, value2, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andRearWiperNotBetween(String value1, String value2) {
            addCriterion("rear_wiper not between", value1, value2, "rearWiper");
            return (Criteria) this;
        }

        public Criteria andAirConditionerIsNull() {
            addCriterion("air_conditioner is null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerIsNotNull() {
            addCriterion("air_conditioner is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditionerEqualTo(String value) {
            addCriterion("air_conditioner =", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNotEqualTo(String value) {
            addCriterion("air_conditioner <>", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerGreaterThan(String value) {
            addCriterion("air_conditioner >", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerGreaterThanOrEqualTo(String value) {
            addCriterion("air_conditioner >=", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerLessThan(String value) {
            addCriterion("air_conditioner <", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerLessThanOrEqualTo(String value) {
            addCriterion("air_conditioner <=", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerLike(String value) {
            addCriterion("air_conditioner like", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNotLike(String value) {
            addCriterion("air_conditioner not like", value, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerIn(List<String> values) {
            addCriterion("air_conditioner in", values, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNotIn(List<String> values) {
            addCriterion("air_conditioner not in", values, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerBetween(String value1, String value2) {
            addCriterion("air_conditioner between", value1, value2, "airConditioner");
            return (Criteria) this;
        }

        public Criteria andAirConditionerNotBetween(String value1, String value2) {
            addCriterion("air_conditioner not between", value1, value2, "airConditioner");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}