package com.carl.resale.ui.repositories;

import com.carl.resale.ui.bean.Advantage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 广告分类操作
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Repository("advRepository")
public interface AdvantageRepository extends MongoRepository<Advantage, ObjectId> {
}
