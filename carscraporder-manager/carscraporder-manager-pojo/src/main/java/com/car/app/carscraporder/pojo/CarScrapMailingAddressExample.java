package com.car.app.carscraporder.pojo;

import java.util.ArrayList;
import java.util.List;

public class CarScrapMailingAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarScrapMailingAddressExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameIsNull() {
            addCriterion("addressee_name is null");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameIsNotNull() {
            addCriterion("addressee_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameEqualTo(String value) {
            addCriterion("addressee_name =", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameNotEqualTo(String value) {
            addCriterion("addressee_name <>", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameGreaterThan(String value) {
            addCriterion("addressee_name >", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameGreaterThanOrEqualTo(String value) {
            addCriterion("addressee_name >=", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameLessThan(String value) {
            addCriterion("addressee_name <", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameLessThanOrEqualTo(String value) {
            addCriterion("addressee_name <=", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameLike(String value) {
            addCriterion("addressee_name like", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameNotLike(String value) {
            addCriterion("addressee_name not like", value, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameIn(List<String> values) {
            addCriterion("addressee_name in", values, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameNotIn(List<String> values) {
            addCriterion("addressee_name not in", values, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameBetween(String value1, String value2) {
            addCriterion("addressee_name between", value1, value2, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeNameNotBetween(String value1, String value2) {
            addCriterion("addressee_name not between", value1, value2, "addresseeName");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneIsNull() {
            addCriterion("addressee_telephone is null");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneIsNotNull() {
            addCriterion("addressee_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneEqualTo(String value) {
            addCriterion("addressee_telephone =", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneNotEqualTo(String value) {
            addCriterion("addressee_telephone <>", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneGreaterThan(String value) {
            addCriterion("addressee_telephone >", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("addressee_telephone >=", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneLessThan(String value) {
            addCriterion("addressee_telephone <", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneLessThanOrEqualTo(String value) {
            addCriterion("addressee_telephone <=", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneLike(String value) {
            addCriterion("addressee_telephone like", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneNotLike(String value) {
            addCriterion("addressee_telephone not like", value, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneIn(List<String> values) {
            addCriterion("addressee_telephone in", values, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneNotIn(List<String> values) {
            addCriterion("addressee_telephone not in", values, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneBetween(String value1, String value2) {
            addCriterion("addressee_telephone between", value1, value2, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andAddresseeTelephoneNotBetween(String value1, String value2) {
            addCriterion("addressee_telephone not between", value1, value2, "addresseeTelephone");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Integer value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Integer value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Integer value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Integer value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Integer> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Integer> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Integer value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Integer value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Integer value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Integer value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Integer> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Integer> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(Integer value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(Integer value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(Integer value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(Integer value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(Integer value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(Integer value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<Integer> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<Integer> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(Integer value1, Integer value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(Integer value1, Integer value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return (Criteria) this;
        }

        public Criteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
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