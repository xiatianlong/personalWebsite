package com.personalWebsite.dictionary;

import com.personalWebsite.entity.DictionaryEntity;

import java.util.List;

/**
 * Dictionary cache
 * Created by xiatianlong on 2018/1/6.
 */
public class DictionaryCache {

    /**
     * get dictionary name
     *
     * @param code code
     * @return name
     */
    public static String getName(String code) {
        return DictionarySingleton.getInstance().getName(code);
    }

    /**
     * get dictionary parent code
     *
     * @param code code
     * @return parent code
     */
    public static String getParentCode(String code) {
        return DictionarySingleton.getInstance().getParentCode(code);
    }

    /**
     * get child list
     *
     * @param parentCode parentCode
     * @return child list
     */
    public static List<DictionaryEntity> getChildList(String parentCode) {
        return DictionarySingleton.getInstance().getDicList(parentCode);
    }

}
