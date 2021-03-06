/*
 * Copyright 2008-2009 the original author or authors.
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
package net.hasor.core.info;
import org.more.builder.ReflectionToStringBuilder;
import org.more.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
/**
 * 提供metaData。
 * @version : 2014年7月3日
 * @author 赵永春(zyc@hasor.net)
 */
public class MetaDataAdapter extends Observable {
    private Map<String, Object> metaData = new HashMap<String, Object>();
    public void setMetaData(final String key, final Object value) {
        this.metaData.put(key, value);
    }
    public Object getMetaData(final String key) {
        return this.metaData.get(key);
    }
    public void removeMetaData(String key) {
        this.metaData.remove(key);
    }
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    //
    protected void notify(NotifyData notifyData) {
        setChanged();
        this.notifyObservers(notifyData);
    }
}