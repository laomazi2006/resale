package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * 目录
 * @author Carl
 * @date 2016/3/23
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection="mall_category")
public class Category {
    @Field
    private ObjectId id;
    @Field private String name;
    @Field private String code;
    @Field private int order;
    @Field("css_name") private String cssName;//前端样式
    @Field("state") private State state;
    @Field("goods_count") private int goodsCount;//广告总数
    @Field("image_id")private ObjectId imageId;
    @Field("spec_types") private List<SpecificType> specTypes;
    @Field("business_id") private String business;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCssName() {
        return cssName;
    }

    public void setCssName(String cssName) {
        this.cssName = cssName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public ObjectId getImageId() {
        return imageId;
    }

    public void setImageId(ObjectId imageId) {
        this.imageId = imageId;
    }

    public List<SpecificType> getSpecTypes() {
        return specTypes;
    }

    public void setSpecTypes(List<SpecificType> specTypes) {
        this.specTypes = specTypes;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}