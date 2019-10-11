package com.funzzz.model;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPermissionidIsNull() {
            addCriterion("permissionId is null");
            return (Criteria) this;
        }

        public Criteria andPermissionidIsNotNull() {
            addCriterion("permissionId is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionidEqualTo(Integer value) {
            addCriterion("permissionId =", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotEqualTo(Integer value) {
            addCriterion("permissionId <>", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidGreaterThan(Integer value) {
            addCriterion("permissionId >", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("permissionId >=", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLessThan(Integer value) {
            addCriterion("permissionId <", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLessThanOrEqualTo(Integer value) {
            addCriterion("permissionId <=", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidIn(List<Integer> values) {
            addCriterion("permissionId in", values, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotIn(List<Integer> values) {
            addCriterion("permissionId not in", values, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidBetween(Integer value1, Integer value2) {
            addCriterion("permissionId between", value1, value2, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotBetween(Integer value1, Integer value2) {
            addCriterion("permissionId not between", value1, value2, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPurlIsNull() {
            addCriterion("purl is null");
            return (Criteria) this;
        }

        public Criteria andPurlIsNotNull() {
            addCriterion("purl is not null");
            return (Criteria) this;
        }

        public Criteria andPurlEqualTo(String value) {
            addCriterion("purl =", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotEqualTo(String value) {
            addCriterion("purl <>", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlGreaterThan(String value) {
            addCriterion("purl >", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlGreaterThanOrEqualTo(String value) {
            addCriterion("purl >=", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlLessThan(String value) {
            addCriterion("purl <", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlLessThanOrEqualTo(String value) {
            addCriterion("purl <=", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlLike(String value) {
            addCriterion("purl like", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotLike(String value) {
            addCriterion("purl not like", value, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlIn(List<String> values) {
            addCriterion("purl in", values, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotIn(List<String> values) {
            addCriterion("purl not in", values, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlBetween(String value1, String value2) {
            addCriterion("purl between", value1, value2, "purl");
            return (Criteria) this;
        }

        public Criteria andPurlNotBetween(String value1, String value2) {
            addCriterion("purl not between", value1, value2, "purl");
            return (Criteria) this;
        }

        public Criteria andIsmenuIsNull() {
            addCriterion("ismenu is null");
            return (Criteria) this;
        }

        public Criteria andIsmenuIsNotNull() {
            addCriterion("ismenu is not null");
            return (Criteria) this;
        }

        public Criteria andIsmenuEqualTo(Integer value) {
            addCriterion("ismenu =", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotEqualTo(Integer value) {
            addCriterion("ismenu <>", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuGreaterThan(Integer value) {
            addCriterion("ismenu >", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuGreaterThanOrEqualTo(Integer value) {
            addCriterion("ismenu >=", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuLessThan(Integer value) {
            addCriterion("ismenu <", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuLessThanOrEqualTo(Integer value) {
            addCriterion("ismenu <=", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuIn(List<Integer> values) {
            addCriterion("ismenu in", values, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotIn(List<Integer> values) {
            addCriterion("ismenu not in", values, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuBetween(Integer value1, Integer value2) {
            addCriterion("ismenu between", value1, value2, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotBetween(Integer value1, Integer value2) {
            addCriterion("ismenu not between", value1, value2, "ismenu");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andPinfoIsNull() {
            addCriterion("pinfo is null");
            return (Criteria) this;
        }

        public Criteria andPinfoIsNotNull() {
            addCriterion("pinfo is not null");
            return (Criteria) this;
        }

        public Criteria andPinfoEqualTo(String value) {
            addCriterion("pinfo =", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoNotEqualTo(String value) {
            addCriterion("pinfo <>", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoGreaterThan(String value) {
            addCriterion("pinfo >", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoGreaterThanOrEqualTo(String value) {
            addCriterion("pinfo >=", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoLessThan(String value) {
            addCriterion("pinfo <", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoLessThanOrEqualTo(String value) {
            addCriterion("pinfo <=", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoLike(String value) {
            addCriterion("pinfo like", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoNotLike(String value) {
            addCriterion("pinfo not like", value, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoIn(List<String> values) {
            addCriterion("pinfo in", values, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoNotIn(List<String> values) {
            addCriterion("pinfo not in", values, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoBetween(String value1, String value2) {
            addCriterion("pinfo between", value1, value2, "pinfo");
            return (Criteria) this;
        }

        public Criteria andPinfoNotBetween(String value1, String value2) {
            addCriterion("pinfo not between", value1, value2, "pinfo");
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