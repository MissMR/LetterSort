package com.az.lettersort.azList;

import com.az.lettersort.SortBean;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtils {

    /**
     * 根据首字母排序list
     *
     * @param sourceList
     * @param order      true = 升序，false = 降序
     * @return
     */
    public static List<BaseSortBean> sortForListToInitials(List<BaseSortBean> sourceList, final boolean order) {
        Collections.sort(sourceList, new Comparator<BaseSortBean>() {
            @Override
            public int compare(BaseSortBean o1, BaseSortBean o2) {
                if (order) {
                    return o1.getInitials().compareTo(o2.getInitials());
                } else {
                    return o2.getInitials().compareTo(o1.getInitials());
                }

            }
        });
        return sourceList;
    }

    /**
     * 根据首字母排序list
     *
     * @param sourceList
     * @param order      true = 升序，false = 降序
     * @return
     */
    public static List<String> sortForStringListToInitials(List<String> sourceList, final boolean order) {
        Collections.sort(sourceList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (order) {
                    return getInitials(o1).compareTo(getInitials(o2));
                } else {
                    return getInitials(o2).compareTo(getInitials(o1));
                }

            }
        });
        return sourceList;
    }





    /**
     * 使用pinyin4j获取首字母
     * @param chinese
     * @return
     */
    public static String getInitials(String chinese){
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        if (arr[0] > 128) {
            try {
                String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[0], defaultFormat);
                if (_t != null) {
                    pybf.append(_t[0].charAt(0));
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            pybf.append(arr[0]);
        }
        return pybf.toString().replaceAll("\\W", "").trim().toLowerCase();
    }

}
