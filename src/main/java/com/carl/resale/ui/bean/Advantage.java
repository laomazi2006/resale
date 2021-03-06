package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 广告类
 *
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection = "mall_advantage")
public class Advantage {
    private ObjectId id;
    private String business;
    private String title;
    private String describe;
    @Field("publish_time")
    private Date publishTime = new Date();
    @DBRef
    private SysArea area;
    @Field("category")
    @DBRef
    private Category category;
    @Field("specific_type")
    @DBRef
    private SpecificType specificType;
    @Field("advantage_brand")
    private Brand brand;
    @Field("preview_image")
    private SysFile previewImage;
    @Field("sequence_no")
    private int sequenceNo;
    private int views;//查看次数
    private String display;
    private String summary;//描述
    private float price;//价格
    @Field("display_imgs")
    private List<SysFile> displayImgs;
    @Field("publish_user")
    @DBRef
    private SysUser publishUser;
    private String condition;

    /**
     * 展示类型与，Category.ShowType.id
     */
    private ObjectId showType;

    public ObjectId getShowType() {
        return showType;
    }

    public void setShowType(ObjectId showType) {
        this.showType = showType;
    }

    /**
     * 获取现在离发布时间天数
     *
     * @return
     */
    public long getPublishTimeType() throws ParseException {
        SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String rightNow = df.format(new Date());
        String pt = df.format(this.getPublishTime());
        long between = (df.parse(rightNow).getTime() - df.parse(pt).getTime()) / 1000;//除以1000是为了转换成秒
        return between/(24*3600);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public SysArea getArea() {
        return area;
    }

    public void setArea(SysArea area) {
        this.area = area;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SpecificType getSpecificType() {
        return specificType;
    }

    public void setSpecificType(SpecificType specificType) {
        this.specificType = specificType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public SysFile getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(SysFile previewImage) {
        this.previewImage = previewImage;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<SysFile> getDisplayImgs() {
        return displayImgs;
    }

    public void setDisplayImgs(List<SysFile> displayImgs) {
        this.displayImgs = displayImgs;
    }

    public SysUser getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(SysUser publishUser) {
        this.publishUser = publishUser;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Advantage{" +
                "id=" + id +
                ", business='" + business + '\'' +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", publishTime=" + publishTime +
                ", area=" + area +
                ", category=" + category +
                ", specificType=" + specificType +
                ", brand=" + brand +
                ", previewImage=" + previewImage +
                ", sequenceNo=" + sequenceNo +
                ", views=" + views +
                ", display='" + display + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", displayImgs=" + displayImgs +
                ", publishUser=" + publishUser +
                ", condition='" + condition + '\'' +
                '}';
    }
}
