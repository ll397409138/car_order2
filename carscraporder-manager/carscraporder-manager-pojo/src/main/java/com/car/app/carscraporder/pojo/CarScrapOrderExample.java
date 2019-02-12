package com.car.app.carscraporder.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarScrapOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarScrapOrderExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andReportNoIsNull() {
            addCriterion("report_no is null");
            return (Criteria) this;
        }

        public Criteria andReportNoIsNotNull() {
            addCriterion("report_no is not null");
            return (Criteria) this;
        }

        public Criteria andReportNoEqualTo(String value) {
            addCriterion("report_no =", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoNotEqualTo(String value) {
            addCriterion("report_no <>", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoGreaterThan(String value) {
            addCriterion("report_no >", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoGreaterThanOrEqualTo(String value) {
            addCriterion("report_no >=", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoLessThan(String value) {
            addCriterion("report_no <", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoLessThanOrEqualTo(String value) {
            addCriterion("report_no <=", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoLike(String value) {
            addCriterion("report_no like", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoNotLike(String value) {
            addCriterion("report_no not like", value, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoIn(List<String> values) {
            addCriterion("report_no in", values, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoNotIn(List<String> values) {
            addCriterion("report_no not in", values, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoBetween(String value1, String value2) {
            addCriterion("report_no between", value1, value2, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportNoNotBetween(String value1, String value2) {
            addCriterion("report_no not between", value1, value2, "reportNo");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(Date value) {
            addCriterion("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(Date value) {
            addCriterion("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(Date value) {
            addCriterion("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(Date value) {
            addCriterion("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(Date value) {
            addCriterion("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<Date> values) {
            addCriterion("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<Date> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(Date value1, Date value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(Date value1, Date value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberIsNull() {
            addCriterion("car_frame_number is null");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberIsNotNull() {
            addCriterion("car_frame_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberEqualTo(String value) {
            addCriterion("car_frame_number =", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberNotEqualTo(String value) {
            addCriterion("car_frame_number <>", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberGreaterThan(String value) {
            addCriterion("car_frame_number >", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_frame_number >=", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberLessThan(String value) {
            addCriterion("car_frame_number <", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberLessThanOrEqualTo(String value) {
            addCriterion("car_frame_number <=", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberLike(String value) {
            addCriterion("car_frame_number like", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberNotLike(String value) {
            addCriterion("car_frame_number not like", value, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberIn(List<String> values) {
            addCriterion("car_frame_number in", values, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberNotIn(List<String> values) {
            addCriterion("car_frame_number not in", values, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberBetween(String value1, String value2) {
            addCriterion("car_frame_number between", value1, value2, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarFrameNumberNotBetween(String value1, String value2) {
            addCriterion("car_frame_number not between", value1, value2, "carFrameNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberIsNull() {
            addCriterion("car_model_number is null");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberIsNotNull() {
            addCriterion("car_model_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberEqualTo(Integer value) {
            addCriterion("car_model_number =", value, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberNotEqualTo(Integer value) {
            addCriterion("car_model_number <>", value, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberGreaterThan(Integer value) {
            addCriterion("car_model_number >", value, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_model_number >=", value, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberLessThan(Integer value) {
            addCriterion("car_model_number <", value, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberLessThanOrEqualTo(Integer value) {
            addCriterion("car_model_number <=", value, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberIn(List<Integer> values) {
            addCriterion("car_model_number in", values, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberNotIn(List<Integer> values) {
            addCriterion("car_model_number not in", values, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberBetween(Integer value1, Integer value2) {
            addCriterion("car_model_number between", value1, value2, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarModelNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("car_model_number not between", value1, value2, "carModelNumber");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionIsNull() {
            addCriterion("car_ascription is null");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionIsNotNull() {
            addCriterion("car_ascription is not null");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionEqualTo(String value) {
            addCriterion("car_ascription =", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionNotEqualTo(String value) {
            addCriterion("car_ascription <>", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionGreaterThan(String value) {
            addCriterion("car_ascription >", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionGreaterThanOrEqualTo(String value) {
            addCriterion("car_ascription >=", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionLessThan(String value) {
            addCriterion("car_ascription <", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionLessThanOrEqualTo(String value) {
            addCriterion("car_ascription <=", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionLike(String value) {
            addCriterion("car_ascription like", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionNotLike(String value) {
            addCriterion("car_ascription not like", value, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionIn(List<String> values) {
            addCriterion("car_ascription in", values, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionNotIn(List<String> values) {
            addCriterion("car_ascription not in", values, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionBetween(String value1, String value2) {
            addCriterion("car_ascription between", value1, value2, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarAscriptionNotBetween(String value1, String value2) {
            addCriterion("car_ascription not between", value1, value2, "carAscription");
            return (Criteria) this;
        }

        public Criteria andCarOwnerIsNull() {
            addCriterion("car_owner is null");
            return (Criteria) this;
        }

        public Criteria andCarOwnerIsNotNull() {
            addCriterion("car_owner is not null");
            return (Criteria) this;
        }

        public Criteria andCarOwnerEqualTo(String value) {
            addCriterion("car_owner =", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNotEqualTo(String value) {
            addCriterion("car_owner <>", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerGreaterThan(String value) {
            addCriterion("car_owner >", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("car_owner >=", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerLessThan(String value) {
            addCriterion("car_owner <", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerLessThanOrEqualTo(String value) {
            addCriterion("car_owner <=", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerLike(String value) {
            addCriterion("car_owner like", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNotLike(String value) {
            addCriterion("car_owner not like", value, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerIn(List<String> values) {
            addCriterion("car_owner in", values, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNotIn(List<String> values) {
            addCriterion("car_owner not in", values, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerBetween(String value1, String value2) {
            addCriterion("car_owner between", value1, value2, "carOwner");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNotBetween(String value1, String value2) {
            addCriterion("car_owner not between", value1, value2, "carOwner");
            return (Criteria) this;
        }

        public Criteria andIsdriveIsNull() {
            addCriterion("isdrive is null");
            return (Criteria) this;
        }

        public Criteria andIsdriveIsNotNull() {
            addCriterion("isdrive is not null");
            return (Criteria) this;
        }

        public Criteria andIsdriveEqualTo(Boolean value) {
            addCriterion("isdrive =", value, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveNotEqualTo(Boolean value) {
            addCriterion("isdrive <>", value, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveGreaterThan(Boolean value) {
            addCriterion("isdrive >", value, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdrive >=", value, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveLessThan(Boolean value) {
            addCriterion("isdrive <", value, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveLessThanOrEqualTo(Boolean value) {
            addCriterion("isdrive <=", value, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveIn(List<Boolean> values) {
            addCriterion("isdrive in", values, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveNotIn(List<Boolean> values) {
            addCriterion("isdrive not in", values, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveBetween(Boolean value1, Boolean value2) {
            addCriterion("isdrive between", value1, value2, "isdrive");
            return (Criteria) this;
        }

        public Criteria andIsdriveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdrive not between", value1, value2, "isdrive");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andAgentUseridIsNull() {
            addCriterion("agent_userid is null");
            return (Criteria) this;
        }

        public Criteria andAgentUseridIsNotNull() {
            addCriterion("agent_userid is not null");
            return (Criteria) this;
        }

        public Criteria andAgentUseridEqualTo(String value) {
            addCriterion("agent_userid =", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridNotEqualTo(String value) {
            addCriterion("agent_userid <>", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridGreaterThan(String value) {
            addCriterion("agent_userid >", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridGreaterThanOrEqualTo(String value) {
            addCriterion("agent_userid >=", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridLessThan(String value) {
            addCriterion("agent_userid <", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridLessThanOrEqualTo(String value) {
            addCriterion("agent_userid <=", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridLike(String value) {
            addCriterion("agent_userid like", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridNotLike(String value) {
            addCriterion("agent_userid not like", value, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridIn(List<String> values) {
            addCriterion("agent_userid in", values, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridNotIn(List<String> values) {
            addCriterion("agent_userid not in", values, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridBetween(String value1, String value2) {
            addCriterion("agent_userid between", value1, value2, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andAgentUseridNotBetween(String value1, String value2) {
            addCriterion("agent_userid not between", value1, value2, "agentUserid");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsIsNull() {
            addCriterion("take_car_contacts is null");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsIsNotNull() {
            addCriterion("take_car_contacts is not null");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsEqualTo(String value) {
            addCriterion("take_car_contacts =", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsNotEqualTo(String value) {
            addCriterion("take_car_contacts <>", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsGreaterThan(String value) {
            addCriterion("take_car_contacts >", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsGreaterThanOrEqualTo(String value) {
            addCriterion("take_car_contacts >=", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsLessThan(String value) {
            addCriterion("take_car_contacts <", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsLessThanOrEqualTo(String value) {
            addCriterion("take_car_contacts <=", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsLike(String value) {
            addCriterion("take_car_contacts like", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsNotLike(String value) {
            addCriterion("take_car_contacts not like", value, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsIn(List<String> values) {
            addCriterion("take_car_contacts in", values, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsNotIn(List<String> values) {
            addCriterion("take_car_contacts not in", values, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsBetween(String value1, String value2) {
            addCriterion("take_car_contacts between", value1, value2, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactsNotBetween(String value1, String value2) {
            addCriterion("take_car_contacts not between", value1, value2, "takeCarContacts");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberIsNull() {
            addCriterion("take_car_contact_number is null");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberIsNotNull() {
            addCriterion("take_car_contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberEqualTo(String value) {
            addCriterion("take_car_contact_number =", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberNotEqualTo(String value) {
            addCriterion("take_car_contact_number <>", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberGreaterThan(String value) {
            addCriterion("take_car_contact_number >", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("take_car_contact_number >=", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberLessThan(String value) {
            addCriterion("take_car_contact_number <", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberLessThanOrEqualTo(String value) {
            addCriterion("take_car_contact_number <=", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberLike(String value) {
            addCriterion("take_car_contact_number like", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberNotLike(String value) {
            addCriterion("take_car_contact_number not like", value, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberIn(List<String> values) {
            addCriterion("take_car_contact_number in", values, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberNotIn(List<String> values) {
            addCriterion("take_car_contact_number not in", values, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberBetween(String value1, String value2) {
            addCriterion("take_car_contact_number between", value1, value2, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarContactNumberNotBetween(String value1, String value2) {
            addCriterion("take_car_contact_number not between", value1, value2, "takeCarContactNumber");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeIsNull() {
            addCriterion("take_car_time is null");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeIsNotNull() {
            addCriterion("take_car_time is not null");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeEqualTo(Date value) {
            addCriterion("take_car_time =", value, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeNotEqualTo(Date value) {
            addCriterion("take_car_time <>", value, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeGreaterThan(Date value) {
            addCriterion("take_car_time >", value, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("take_car_time >=", value, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeLessThan(Date value) {
            addCriterion("take_car_time <", value, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeLessThanOrEqualTo(Date value) {
            addCriterion("take_car_time <=", value, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeIn(List<Date> values) {
            addCriterion("take_car_time in", values, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeNotIn(List<Date> values) {
            addCriterion("take_car_time not in", values, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeBetween(Date value1, Date value2) {
            addCriterion("take_car_time between", value1, value2, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarTimeNotBetween(Date value1, Date value2) {
            addCriterion("take_car_time not between", value1, value2, "takeCarTime");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressIsNull() {
            addCriterion("take_car_address is null");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressIsNotNull() {
            addCriterion("take_car_address is not null");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressEqualTo(String value) {
            addCriterion("take_car_address =", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressNotEqualTo(String value) {
            addCriterion("take_car_address <>", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressGreaterThan(String value) {
            addCriterion("take_car_address >", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressGreaterThanOrEqualTo(String value) {
            addCriterion("take_car_address >=", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressLessThan(String value) {
            addCriterion("take_car_address <", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressLessThanOrEqualTo(String value) {
            addCriterion("take_car_address <=", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressLike(String value) {
            addCriterion("take_car_address like", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressNotLike(String value) {
            addCriterion("take_car_address not like", value, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressIn(List<String> values) {
            addCriterion("take_car_address in", values, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressNotIn(List<String> values) {
            addCriterion("take_car_address not in", values, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressBetween(String value1, String value2) {
            addCriterion("take_car_address between", value1, value2, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andTakeCarAddressNotBetween(String value1, String value2) {
            addCriterion("take_car_address not between", value1, value2, "takeCarAddress");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNull() {
            addCriterion("express_company is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNotNull() {
            addCriterion("express_company is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyEqualTo(String value) {
            addCriterion("express_company =", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("express_company <>", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThan(String value) {
            addCriterion("express_company >", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("express_company >=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThan(String value) {
            addCriterion("express_company <", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("express_company <=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLike(String value) {
            addCriterion("express_company like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotLike(String value) {
            addCriterion("express_company not like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIn(List<String> values) {
            addCriterion("express_company in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotIn(List<String> values) {
            addCriterion("express_company not in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("express_company between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("express_company not between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressNumberIsNull() {
            addCriterion("express_number is null");
            return (Criteria) this;
        }

        public Criteria andExpressNumberIsNotNull() {
            addCriterion("express_number is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNumberEqualTo(String value) {
            addCriterion("express_number =", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotEqualTo(String value) {
            addCriterion("express_number <>", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberGreaterThan(String value) {
            addCriterion("express_number >", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberGreaterThanOrEqualTo(String value) {
            addCriterion("express_number >=", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberLessThan(String value) {
            addCriterion("express_number <", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberLessThanOrEqualTo(String value) {
            addCriterion("express_number <=", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberLike(String value) {
            addCriterion("express_number like", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotLike(String value) {
            addCriterion("express_number not like", value, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberIn(List<String> values) {
            addCriterion("express_number in", values, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotIn(List<String> values) {
            addCriterion("express_number not in", values, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberBetween(String value1, String value2) {
            addCriterion("express_number between", value1, value2, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andExpressNumberNotBetween(String value1, String value2) {
            addCriterion("express_number not between", value1, value2, "expressNumber");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameIsNull() {
            addCriterion("mailing_address_name is null");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameIsNotNull() {
            addCriterion("mailing_address_name is not null");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameEqualTo(String value) {
            addCriterion("mailing_address_name =", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameNotEqualTo(String value) {
            addCriterion("mailing_address_name <>", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameGreaterThan(String value) {
            addCriterion("mailing_address_name >", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameGreaterThanOrEqualTo(String value) {
            addCriterion("mailing_address_name >=", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameLessThan(String value) {
            addCriterion("mailing_address_name <", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameLessThanOrEqualTo(String value) {
            addCriterion("mailing_address_name <=", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameLike(String value) {
            addCriterion("mailing_address_name like", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameNotLike(String value) {
            addCriterion("mailing_address_name not like", value, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameIn(List<String> values) {
            addCriterion("mailing_address_name in", values, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameNotIn(List<String> values) {
            addCriterion("mailing_address_name not in", values, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameBetween(String value1, String value2) {
            addCriterion("mailing_address_name between", value1, value2, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressNameNotBetween(String value1, String value2) {
            addCriterion("mailing_address_name not between", value1, value2, "mailingAddressName");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneIsNull() {
            addCriterion("mailing_address_telephone is null");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneIsNotNull() {
            addCriterion("mailing_address_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneEqualTo(String value) {
            addCriterion("mailing_address_telephone =", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneNotEqualTo(String value) {
            addCriterion("mailing_address_telephone <>", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneGreaterThan(String value) {
            addCriterion("mailing_address_telephone >", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("mailing_address_telephone >=", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneLessThan(String value) {
            addCriterion("mailing_address_telephone <", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneLessThanOrEqualTo(String value) {
            addCriterion("mailing_address_telephone <=", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneLike(String value) {
            addCriterion("mailing_address_telephone like", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneNotLike(String value) {
            addCriterion("mailing_address_telephone not like", value, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneIn(List<String> values) {
            addCriterion("mailing_address_telephone in", values, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneNotIn(List<String> values) {
            addCriterion("mailing_address_telephone not in", values, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneBetween(String value1, String value2) {
            addCriterion("mailing_address_telephone between", value1, value2, "mailingAddressTelephone");
            return (Criteria) this;
        }

        public Criteria andMailingAddressTelephoneNotBetween(String value1, String value2) {
            addCriterion("mailing_address_telephone not between", value1, value2, "mailingAddressTelephone");
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

        public Criteria andClientTypeIsNull() {
            addCriterion("client_type is null");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNotNull() {
            addCriterion("client_type is not null");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("client_type =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotEqualTo(String value) {
            addCriterion("client_type <>", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThan(String value) {
            addCriterion("client_type >", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThanOrEqualTo(String value) {
            addCriterion("client_type >=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThan(String value) {
            addCriterion("client_type <", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThanOrEqualTo(String value) {
            addCriterion("client_type <=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLike(String value) {
            addCriterion("client_type like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotLike(String value) {
            addCriterion("client_type not like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeIn(List<String> values) {
            addCriterion("client_type in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotIn(List<String> values) {
            addCriterion("client_type not in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeBetween(String value1, String value2) {
            addCriterion("client_type between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotBetween(String value1, String value2) {
            addCriterion("client_type not between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNull() {
            addCriterion("payee_name is null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIsNotNull() {
            addCriterion("payee_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeNameEqualTo(String value) {
            addCriterion("payee_name =", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotEqualTo(String value) {
            addCriterion("payee_name <>", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThan(String value) {
            addCriterion("payee_name >", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("payee_name >=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThan(String value) {
            addCriterion("payee_name <", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLessThanOrEqualTo(String value) {
            addCriterion("payee_name <=", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameLike(String value) {
            addCriterion("payee_name like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotLike(String value) {
            addCriterion("payee_name not like", value, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameIn(List<String> values) {
            addCriterion("payee_name in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotIn(List<String> values) {
            addCriterion("payee_name not in", values, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameBetween(String value1, String value2) {
            addCriterion("payee_name between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andPayeeNameNotBetween(String value1, String value2) {
            addCriterion("payee_name not between", value1, value2, "payeeName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andOpeningBankIsNull() {
            addCriterion("opening_bank is null");
            return (Criteria) this;
        }

        public Criteria andOpeningBankIsNotNull() {
            addCriterion("opening_bank is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningBankEqualTo(String value) {
            addCriterion("opening_bank =", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankNotEqualTo(String value) {
            addCriterion("opening_bank <>", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankGreaterThan(String value) {
            addCriterion("opening_bank >", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankGreaterThanOrEqualTo(String value) {
            addCriterion("opening_bank >=", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankLessThan(String value) {
            addCriterion("opening_bank <", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankLessThanOrEqualTo(String value) {
            addCriterion("opening_bank <=", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankLike(String value) {
            addCriterion("opening_bank like", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankNotLike(String value) {
            addCriterion("opening_bank not like", value, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankIn(List<String> values) {
            addCriterion("opening_bank in", values, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankNotIn(List<String> values) {
            addCriterion("opening_bank not in", values, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankBetween(String value1, String value2) {
            addCriterion("opening_bank between", value1, value2, "openingBank");
            return (Criteria) this;
        }

        public Criteria andOpeningBankNotBetween(String value1, String value2) {
            addCriterion("opening_bank not between", value1, value2, "openingBank");
            return (Criteria) this;
        }

        public Criteria andIsremoveIsNull() {
            addCriterion("isremove is null");
            return (Criteria) this;
        }

        public Criteria andIsremoveIsNotNull() {
            addCriterion("isremove is not null");
            return (Criteria) this;
        }

        public Criteria andIsremoveEqualTo(Boolean value) {
            addCriterion("isremove =", value, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveNotEqualTo(Boolean value) {
            addCriterion("isremove <>", value, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveGreaterThan(Boolean value) {
            addCriterion("isremove >", value, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isremove >=", value, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveLessThan(Boolean value) {
            addCriterion("isremove <", value, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveLessThanOrEqualTo(Boolean value) {
            addCriterion("isremove <=", value, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveIn(List<Boolean> values) {
            addCriterion("isremove in", values, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveNotIn(List<Boolean> values) {
            addCriterion("isremove not in", values, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveBetween(Boolean value1, Boolean value2) {
            addCriterion("isremove between", value1, value2, "isremove");
            return (Criteria) this;
        }

        public Criteria andIsremoveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isremove not between", value1, value2, "isremove");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(String value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(String value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(String value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLike(String value) {
            addCriterion("source_type like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotLike(String value) {
            addCriterion("source_type not like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<String> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<String> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIsNull() {
            addCriterion("operatortime is null");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIsNotNull() {
            addCriterion("operatortime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatortimeEqualTo(Date value) {
            addCriterion("operatortime =", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotEqualTo(Date value) {
            addCriterion("operatortime <>", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeGreaterThan(Date value) {
            addCriterion("operatortime >", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operatortime >=", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeLessThan(Date value) {
            addCriterion("operatortime <", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeLessThanOrEqualTo(Date value) {
            addCriterion("operatortime <=", value, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeIn(List<Date> values) {
            addCriterion("operatortime in", values, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotIn(List<Date> values) {
            addCriterion("operatortime not in", values, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeBetween(Date value1, Date value2) {
            addCriterion("operatortime between", value1, value2, "operatortime");
            return (Criteria) this;
        }

        public Criteria andOperatortimeNotBetween(Date value1, Date value2) {
            addCriterion("operatortime not between", value1, value2, "operatortime");
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