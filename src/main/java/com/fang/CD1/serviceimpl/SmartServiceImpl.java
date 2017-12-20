package com.fang.CD1.serviceimpl;

import com.fang.CD1.model.CourseModel;
import com.fang.CD1.service.SmartService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Fang Yi on 17-1-3.
 */
@Service
public class SmartServiceImpl implements SmartService {
    @Override
    public List<CourseModel> feiFanDian(List<CourseModel> li) {
        Iterator<CourseModel> iterator = li.iterator();
        while (iterator.hasNext()) {
            CourseModel tmp = iterator.next();
            if (tmp.getTime() == 2 || tmp.getTime() == 4)
                iterator.remove();
        }
        return li;
    }

    @Override
    public List<CourseModel> gaoXueFen(List<CourseModel> li) {
        Iterator<CourseModel> iterator = li.iterator();
        while (iterator.hasNext()) {
            CourseModel tmp = iterator.next();
            if (tmp.getFen() < 3)
                iterator.remove();
        }
        return li;
    }

    @Override
    public List<CourseModel> xueShiDuan(List<CourseModel> li) {
        Iterator<CourseModel> iterator = li.iterator();
        while (iterator.hasNext()) {
            CourseModel tmp = iterator.next();
            if (tmp.getZhou() > 9)
                iterator.remove();
        }
        return li;
    }

    @Override
    public List<CourseModel> jiaoShiJin(List<CourseModel> li) {
        Iterator<CourseModel> iterator = li.iterator();
        while (iterator.hasNext()) {
            CourseModel tmp = iterator.next();
            if (tmp.getFloor() >2)
                iterator.remove();
        }
        return li;
    }
}
