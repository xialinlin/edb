/**
 * Copyright (c) 2021 , YangZhiJia 杨志佳 (edbplus@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edbplus.db.listener;

import com.edbplus.db.EDbPro;
import com.edbplus.db.dto.EDBListenerResult;
import com.edbplus.db.dto.FieldAndColumn;

import java.util.List;
import java.util.Map;

/**
 * jpa监听对象
 * 1、保存前监听 -- @EDbSave 之前触发
 * 2、更新前监听 -- @EDbUpdate 之前触发
 */
public interface EDbListener {

    /**
     * jpa对象统一保存前的实现逻辑
     * @param jpaClass -- 表对象
     * @param saveMap -- 保存前的对象数据
     * @param coumns  -- 保存对象的所有字段信息
     */
    public void beforeSave(Class jpaClass,Map<String,Object> saveMap, List<FieldAndColumn> coumns);

    /**
     * jpa对象统一更新前的实现逻辑
     * @param jpaClass -- 表对象
     * @param updateMap  -- 更新前的对象数据
     * @param coumns -- 更新对象的所有字段信息
     */
    public void beforeUpdate(Class jpaClass,Map<String,Object> updateMap, List<FieldAndColumn> coumns);

    /**
     * 执行删除前的相关操作
     * @param eDbPro -- 操作的数据库对象
     * @param jpaClass -- 表对象
     * @param deleteMaps -- 指定需要删除的集合(默认只给予主键对应的id)
     * @param coumns -- 表字段的相关信息
     * @return 返回true才能继续执行删除，否则不做任何处理
     */
    public EDBListenerResult beforeDelete(EDbPro eDbPro,Class jpaClass,List<Map<String,Object>> deleteMaps, List<FieldAndColumn> coumns);

}
