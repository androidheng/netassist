package com.netassist.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbSworkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSworkExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andFileIsNull() {
            addCriterion("file is null");
            return (Criteria) this;
        }

        public Criteria andFileIsNotNull() {
            addCriterion("file is not null");
            return (Criteria) this;
        }

        public Criteria andFileEqualTo(String value) {
            addCriterion("file =", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotEqualTo(String value) {
            addCriterion("file <>", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThan(String value) {
            addCriterion("file >", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileGreaterThanOrEqualTo(String value) {
            addCriterion("file >=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThan(String value) {
            addCriterion("file <", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLessThanOrEqualTo(String value) {
            addCriterion("file <=", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileLike(String value) {
            addCriterion("file like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotLike(String value) {
            addCriterion("file not like", value, "file");
            return (Criteria) this;
        }

        public Criteria andFileIn(List<String> values) {
            addCriterion("file in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotIn(List<String> values) {
            addCriterion("file not in", values, "file");
            return (Criteria) this;
        }

        public Criteria andFileBetween(String value1, String value2) {
            addCriterion("file between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andFileNotBetween(String value1, String value2) {
            addCriterion("file not between", value1, value2, "file");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCommittimeIsNull() {
            addCriterion("committime is null");
            return (Criteria) this;
        }

        public Criteria andCommittimeIsNotNull() {
            addCriterion("committime is not null");
            return (Criteria) this;
        }

        public Criteria andCommittimeEqualTo(String value) {
            addCriterion("committime =", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeNotEqualTo(String value) {
            addCriterion("committime <>", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeGreaterThan(String value) {
            addCriterion("committime >", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeGreaterThanOrEqualTo(String value) {
            addCriterion("committime >=", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeLessThan(String value) {
            addCriterion("committime <", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeLessThanOrEqualTo(String value) {
            addCriterion("committime <=", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeLike(String value) {
            addCriterion("committime like", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeNotLike(String value) {
            addCriterion("committime not like", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeIn(List<String> values) {
            addCriterion("committime in", values, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeNotIn(List<String> values) {
            addCriterion("committime not in", values, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeBetween(String value1, String value2) {
            addCriterion("committime between", value1, value2, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeNotBetween(String value1, String value2) {
            addCriterion("committime not between", value1, value2, "committime");
            return (Criteria) this;
        }

        public Criteria andTtidIsNull() {
            addCriterion("ttid is null");
            return (Criteria) this;
        }

        public Criteria andTtidIsNotNull() {
            addCriterion("ttid is not null");
            return (Criteria) this;
        }

        public Criteria andTtidEqualTo(Integer value) {
            addCriterion("ttid =", value, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidNotEqualTo(Integer value) {
            addCriterion("ttid <>", value, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidGreaterThan(Integer value) {
            addCriterion("ttid >", value, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ttid >=", value, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidLessThan(Integer value) {
            addCriterion("ttid <", value, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidLessThanOrEqualTo(Integer value) {
            addCriterion("ttid <=", value, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidIn(List<Integer> values) {
            addCriterion("ttid in", values, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidNotIn(List<Integer> values) {
            addCriterion("ttid not in", values, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidBetween(Integer value1, Integer value2) {
            addCriterion("ttid between", value1, value2, "ttid");
            return (Criteria) this;
        }

        public Criteria andTtidNotBetween(Integer value1, Integer value2) {
            addCriterion("ttid not between", value1, value2, "ttid");
            return (Criteria) this;
        }

        public Criteria andIsdowloadIsNull() {
            addCriterion("isDowload is null");
            return (Criteria) this;
        }

        public Criteria andIsdowloadIsNotNull() {
            addCriterion("isDowload is not null");
            return (Criteria) this;
        }

        public Criteria andIsdowloadEqualTo(String value) {
            addCriterion("isDowload =", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadNotEqualTo(String value) {
            addCriterion("isDowload <>", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadGreaterThan(String value) {
            addCriterion("isDowload >", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadGreaterThanOrEqualTo(String value) {
            addCriterion("isDowload >=", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadLessThan(String value) {
            addCriterion("isDowload <", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadLessThanOrEqualTo(String value) {
            addCriterion("isDowload <=", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadLike(String value) {
            addCriterion("isDowload like", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadNotLike(String value) {
            addCriterion("isDowload not like", value, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadIn(List<String> values) {
            addCriterion("isDowload in", values, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadNotIn(List<String> values) {
            addCriterion("isDowload not in", values, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadBetween(String value1, String value2) {
            addCriterion("isDowload between", value1, value2, "isdowload");
            return (Criteria) this;
        }

        public Criteria andIsdowloadNotBetween(String value1, String value2) {
            addCriterion("isDowload not between", value1, value2, "isdowload");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
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